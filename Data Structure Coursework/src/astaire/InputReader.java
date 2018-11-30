package astaire;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class InputReader {
	
	String path;
	String[] lines;
	String[] names;
	
	ArrayList<Group> groupArray;
	ArrayList<Dance> danceArray;
	ArrayList<Performer> performers;
	
	int externalID = 100;
	
 	private HashMap<String, TreeSet<Performer>> danceMap;
	
	public InputReader() {
		groupArray = new ArrayList<Group>();
		performers = new ArrayList<Performer>();
		danceArray = new ArrayList<Dance>();
		
	}
	
	public String[] OpenFile() throws IOException{
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		
		int numOfLines = readLines();
		String[] textData = new String[numOfLines];
		
		for (int i = 0; i < numOfLines; i++) {
			textData[i] = textReader.readLine();
		}
		textReader.close();
		return textData;
	}

	private int readLines() throws IOException{
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
		path = fileName;
		int k = 0;
		 try {
			 lines = OpenFile();
			 for (int i = 1; i < lines.length-1; i++) {
				//System.out.println(lines[i].substring(0, lines[i].indexOf("\t"))); //Group names
				String line = (lines[i].substring(0, lines[i].indexOf("\t")));
				String[] groupNames = line.split("\t");
				for (int j = 0; j < groupNames.length; j++) {
					//new Group(j, groupNames[j]).getName();
					groupArray.add(new Group(k, groupNames[j]));
					//System.out.println(groupArray[k].getName());
					k++;
				}
			 }
		 }catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void readNames(String fileName, boolean createGroup) {
		path = fileName;
		int k = 0;
		int h = 0;
		int m = 0;
		danceMap = new HashMap<String, TreeSet<Performer>>();
		 try {
			 lines = OpenFile();
			 for (int i = 1; i < lines.length; i++) {
				 
				//Prints all names of performers
				String line = (lines[i].substring(lines[i].indexOf("\t")+1));
				names = line.split(",");
					for (int j = 0; j < names.length; j++) {
						if (createGroup) {
							//System.out.println(groupArray[h].getID());
							groupArray.get(h).addPerformer(new Performer(k, names[j]));
							//System.out.println(groupArray[h].getPerformerList().get(j).getName());
							k++;
						} else {
							//IF GROUP NAMES MATCH
							if (names[j].substring(0).equals(groupArray.get(h).getName())) {
								System.out.println("Match");
								//FOR ALL NAMES IN THAT GROUP
								for (int l = 0; l < groupArray.get(h).getPerformerList().size(); l++) {
									//System.out.println(groupArray[h].getPerformerList().get(l).getName());
									//performers.add(groupArray.get(h).getPerformerList().get(l));
									
									//Add those performers to dance
									//System.out.println(groupArray.get(h).getPerformerList().get(l).getName());
									danceArray.get(m).getPerformerTree().add(groupArray.get(h).getPerformerList().get(l));
									System.out.println(danceArray.get(m).getPerformerTree().iterator().next());
									System.out.println(danceArray.get(m).getName());
								}
								m++;
								danceMap.put(danceArray.get(i).getName(), danceArray.get(m).getPerformerTree());
//								for (int j2 = 0; j2 < danceArray.get(i).getPerformerTree().size(); j2++) {
//									System.out.println(danceArray.get(i).getPerformers());	
//								}
								
							} else {
								performers.add(new Performer(externalID, names[j]));
								//System.out.println(performers.get(0));
								externalID++;
							}
						}
					}
					if (h < groupArray.size()-2) {
						h++;
					} else {
						break;
					}
			 }
		 }catch (IOException e) {
			System.out.println(e.getMessage());
		}
//		 for (int i = 0; i < groupArray.size(); i++) {
//			 for (int j = 0; j < groupArray.get(i).getPerformerList().size(); j++) {
//				System.out.println(groupArray.get(i).getPerformerList().get(j).getName());
//			}
//		}
	}
	
	public void readDances(String fileName) {
		path = fileName;
		int k = 0;
		try {
			 lines = OpenFile();
			 for (int i = 1; i < lines.length; i++) {
				//Prints all names of performers
				 String line = (lines[i].substring(0, lines[i].indexOf("\t")));
				 String[] danceNames = line.split("\t");
					for (int j = 0; j < danceNames.length; j++) {
						danceArray.add(new Dance(k, danceNames[j]));
						k++;
					}
			 }
		 }catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public HashMap<String, TreeSet<Performer>> getDanceMap() {
		return danceMap;
	}

	public void setDanceMap(HashMap<String, TreeSet<Performer>> danceMap) {
		this.danceMap = danceMap;
	}
	
}
