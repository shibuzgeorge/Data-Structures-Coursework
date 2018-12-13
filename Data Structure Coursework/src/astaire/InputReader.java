package astaire;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class InputReader {

	String[] lines;

	ArrayList<Group> groupArray;
	public ArrayList<Dance> danceArray;
	ArrayList<Performer> performers;
	HashMap<String, CountTracker> tracker = new HashMap<String, CountTracker>();

	int externalID = 100;

	public InputReader() {
		groupArray = new ArrayList<Group>();
		performers = new ArrayList<Performer>();
		danceArray = new ArrayList<Dance>();

	}

	public String[] OpenFile(String path) throws IOException {
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);

		int numOfLines = readLines(path);
		String[] textData = new String[numOfLines];

		for (int i = 0; i < numOfLines; i++) {
			textData[i] = textReader.readLine();
		}
		textReader.close();
		return textData;
	}

	private int readLines(String path) throws IOException {
		FileReader fileToRead = new FileReader(path);
		BufferedReader bf = new BufferedReader(fileToRead);

		String aLine;
		int numOfLines = 0;

		while ((aLine = bf.readLine()) != null) {
			numOfLines++;
		}
		bf.close();
		return numOfLines;
	}

	public void readGroupNames(String fileName) {
		int k = 0;
		try {
			lines = OpenFile(fileName);
			for (int i = 1; i < lines.length; i++) {
				String line = (lines[i].substring(0, lines[i].indexOf("\t")));
				String[] groupNames = line.split("\t");
				for (int j = 0; j < groupNames.length; j++) {
					groupArray.add(new Group(k, groupNames[j]));
					k++;
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void readNames(boolean createGroup, String path) {
		int performerID = 0;
		int groupIterator = 0;

		try {
			lines = OpenFile(path);
			for (int i = 1; i < lines.length; i++) {

				// Prints all names of performers
				String eachLine = (lines[i].substring(lines[i].indexOf("\t") + 1));
				String[] names = eachLine.split(",");

				for (int j = 0; j < names.length; j++) {
					if (createGroup) {
						groupArray.get(groupIterator).addPerformer(new Performer(performerID, names[j].trim(), groupArray.get(groupIterator)));
						performerID++;
					} else {
						// IF GROUP NAMES MATCH
						System.out.println(names[j]);
						for (Group s : groupArray) {
							if (names[j].contains(s.getName())) {
								System.out.println("Match");
								for (int l = 0; l < s.getPerformerList().size(); l++) {

									// Add those performers to dance
									danceArray.get(i - 1).getPerformerTree().add(s.getPerformerList().get(l));

								}
							}

						}
						if (compareGroupNames(names[j]) == null) {
							// NEED TO FIND A WAY TO SEPERATE THE NAMES
							danceArray.get(i - 1).getPerformerTree().add(new Performer(externalID, names[j].trim(), null));
							externalID++;

						}
					}
				}
				if (groupIterator < groupArray.size() - 1) {
					groupIterator++;
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Dance> readDances(String fileName) {
		int k = 0;
		try {
			lines = OpenFile(fileName);
			for (int i = 1; i < lines.length; i++) {
				// Prints all names of performers
				String line = (lines[i].substring(0, lines[i].indexOf("\t")));
				String[] danceNames = line.split("\t");
				for (int j = 0; j < danceNames.length; j++) {
					getDanceArray().add(new Dance(k, danceNames[j]));
					k++;
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return getDanceArray();
	}


	public String checkFeasibility(String fileName, int gap) {
		String isFeasible = "Is Feasible";
		try {

			lines = OpenFile(fileName);
			for (int i = 1; i < lines.length; i++) {
				
				
				String eachLine = (lines[i].substring(lines[i].indexOf("\t") + 1));
				// list of names in one line
				String[] names = eachLine.split(",");
				for (String name : names) {
					name = name.trim();
					/* Increment count of number of times name has been seen */
					for (int j = 0; j < groupArray.size(); j++) {
						for (int k = 0; k < groupArray.get(j).getPerformerList().size(); k++) {
							Performer tempPerformer = groupArray.get(j).getPerformerList().get(k);
							if (name.equals(tempPerformer.getName())) {
								CountTracker ct = tracker.get(tempPerformer.getGroup().getName());
								if (ct == null) {
									tracker.put(tempPerformer.getGroup().getName(), new CountTracker(i));
								} else {
									ct.setLastSeen(i);
									ct.incrementNumOccurences();
									
									tracker.put(tempPerformer.getGroup().getName(), ct);
									if (ct.getLastSeen() - ct.getFoundOn() <= gap && ct.getLastSeen() - ct.getFoundOn() > 0) {
										isFeasible = "Not Feasible: " + "\n" + name + " repeats in " + 
												tempPerformer.getGroup().getName();
										return isFeasible;
									}
								}
							}
						}
					}
					
					CountTracker ct = tracker.get(name);
					if (ct == null) {
						tracker.put(name, new CountTracker(i));
					} else {
						ct.setLastSeen(i);
						ct.incrementNumOccurences();
						
						tracker.put(name, ct);
						if (ct.getLastSeen() - ct.getFoundOn() <= gap && ct.getLastSeen() - ct.getFoundOn() > 0) {
							isFeasible = "Not Feasible: " + "\n" + name;
							return isFeasible;
						}
					}
				}
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());

		}

		return isFeasible;
	}

	public String comparePerformerNameToGroupName(String name) {
		for (int l = 0; l < groupArray.size(); l++) {
			for (int m = 0; m < groupArray.get(l).getPerformerList().size(); m++) {
				if (name.contains(groupArray.get(l).getPerformerList().get(m).getName())) {
					return groupArray.get(l).getName();
				}
				break;
			}
		}
		return "";
	}

	public Group compareGroupNames(String name) {
		Group group = null;
		for (Group g : groupArray) {
			if (name.contains(g.getName())) {
				group = g;
				break;
			}
		}
		return group;
	}

	public ArrayList<Group> getGroupArray() {
		return groupArray;
	}

	public void setGroupArray(ArrayList<Group> groupArray) {
		this.groupArray = groupArray;
	}

	public ArrayList<Dance> getDanceArray() {
		return danceArray;
	}

	public void setDanceArray(ArrayList<Dance> danceArray) {
		this.danceArray = danceArray;
	}

}
