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
	
	int externalID = 100;
	
	public InputReader() {
		groupArray = new ArrayList<Group>();
		performers = new ArrayList<Performer>();
		danceArray = new ArrayList<Dance>();
		
	}
	
	public String[] OpenFile(String path) throws IOException{
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

	private int readLines(String path) throws IOException{
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
					//new Group(j, groupNames[j]).getName();
					groupArray.add(new Group(k, groupNames[j]));
					//PRINTS GROUP NAMES
					//System.out.println(groupArray.get(k).getName());
					k++;
				}
			 }
		 }catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void readNames(boolean createGroup, String path) {
		int performerID = 0;
		int groupIterator = 0;
		
		 try {
			 lines = OpenFile(path);
			 for (int i = 1; i < lines.length; i++) {
				 
				//Prints all names of performers
				String eachLine = (lines[i].substring(lines[i].indexOf("\t")+1));
				String[] names = eachLine.split(",");
					for (int j = 0; j < names.length; j++) {
						if (createGroup) {
							//System.out.println(groupArray[h].getID());
							groupArray.get(groupIterator).addPerformer(new Performer(performerID, names[j]));
							//System.out.println(groupArray.get(h).getPerformerList().get(j).getName());
							performerID++;
						} else {
							//IF GROUP NAMES MATCH
							System.out.println(names[j]);
							for(Group s: groupArray) {
								//System.out.println(names[j].contains(s.getName()));
								if(names[j].contains(s.getName())) {
									System.out.println("Match");
									for (int l = 0; l < s.getPerformerList().size(); l++) {
										
										//Add those performers to dance
										//System.out.println(groupArray.get(h).getPerformerList().get(l).getName());
										danceArray.get(i-1).getPerformerTree().add(s.getPerformerList().get(l));
										System.out.println(danceArray.get(i-1).getPerformerTree().iterator().next());
										System.out.println(danceArray.get(i-1).getName());
										System.out.println(i-1);
									}
								}
							}
							if (!compareGroupNames(names[j])) {
									//NEED TO FIND A WAY TO SEPERATE THE NAMES
									System.out.println("new Performer");
									System.out.println(names[j]);
									danceArray.get(i-1).getPerformerTree().add(new Performer(externalID, names[j]));
									externalID++;
							}
						}
					}
					if (groupIterator < groupArray.size()-1) {
						groupIterator++;
					}
			 	}
		 }catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<Dance> readDances(String fileName) {
		int k = 0;
		try {
			 lines = OpenFile(fileName);
			 for (int i = 1; i < lines.length; i++) {
				//Prints all names of performers
				 String line = (lines[i].substring(0, lines[i].indexOf("\t")));
				 String[] danceNames = line.split("\t");
					for (int j = 0; j < danceNames.length; j++) {
						getDanceArray().add(new Dance(k, danceNames[j]));
						k++;
					}
			 }
		 }catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return getDanceArray();
	}
	
	
//	public boolean checkFeasibility(String fileName, int gap) {
//		boolean isFeasible = false;
//		try {
//			lines = OpenFile(fileName);
//			for (int i = 1; i < lines.length; i++) {
//				int counter = 0;
//				
//				String eachLine = (lines[i].substring(lines[i].indexOf("\t")+1));
//				String[] names = eachLine.split(",");
//				
//					for (int j = 0; j < names.length; j++) {
//						for (int k = 1; k < lines.length; k++) {
//							
//							String eachLine2 = (lines[k].substring(lines[k].indexOf("\t")+1));
//							String[] namesToCompare = eachLine.split(",");
//							System.out.println(namesToCompare.length);
//							
//							for (int l = 0; l < namesToCompare.length; l++) {
//								if (names[j].equals(namesToCompare[l])) {
//									System.out.println("1st Line: "+ i);
//									System.out.println("LINE:" + k);
//									
//									System.out.println("ORIGINAL NAME: " + names[j]);
//									System.out.println("COMPARED NAME: " + namesToCompare[l]);
//									
//									counter++;
//									
//									if (counter > 1) {
//										if (k == i) {
//											System.out.println("SAME");
//										} else if ((k-i < gap) && (k - i >= 0)) {
//											isFeasible = false;
//											System.out.println("NEVER FEASIBLE");
//											counter = 0;
//										} else {
//											isFeasible = true;
//											System.out.println("FEASIBLE SDFGHJKJHGFDS");
//											counter = 0;
//										}
//										
//										//astaireDataFiles/danceShowData_runningOrder.csv
//									}
//									//System.out.println(comparePerformerNameToGroupName(names[j]));
//								}
//							}
//						}
//					}
////					if (!isFeasible) {
////						break;
////					}
//					
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		if (isFeasible) {
//			System.out.println("IS FEASIBLE");
//		} else {
//			System.out.println("IS NOT FEASIBLE");
//			//astaireDataFiles/danceShowData_runningOrder.csv
//		}
//		
//		return isFeasible;
//		
//	}
	
	public boolean checkFeasibility(String fileName, int gap) {
		boolean isFeasible = false;
		fileName = "astaireDataFiles/danceShowData_runningOrder.csv";
		try {
			lines = OpenFile(fileName);
			for (int i = 1; i < lines.length; i++) {
				int counter = 0;
				//Prints all names of performers
				String eachLine = (lines[i].substring(lines[i].indexOf("\t")+1));
				String[] names = eachLine.split(",");
				
					for (int j = 0; j < names.length; j++) {
						for (int k = 1; k < lines.length; k++) {
							
							if (lines[k].contains(names[j])) {
								
								System.out.println("1st Line: "+ i);
								System.out.println("LINE:" + k);
								
								System.out.println("ORIGINAL NAME: " + names[j]);
								System.out.println("COMPARED NAME: " + lines[k]);
								
								counter++;
								if (counter > 1) {
									if (k == i) {
										System.out.println("SAME");
									} else if ((k-i <= gap) && (k - i > 0)) {
										isFeasible = false;
										System.out.println("NEVER FEASIBLE");
										counter = 0;
									} else {
										isFeasible = true;
										System.out.println("Feasible");
										counter = 0;
									}
									
									//astaireDataFiles/danceShowData_runningOrder.csv
								}
								System.out.println(comparePerformerNameToGroupName(names[j]));
							}
//							if (lines[k].contains(comparePerformerNameToGroupName(names[j]))) {
//								System.out.println(comparePerformerNameToGroupName(names[j]));
//								if (lines[k].contains(names[j])) {
//									if (counter > 1) {
//										if (k == i) {
//											break;
//										} else if ((k-i <= gap) && (k - i > 0)) {
//											isFeasible = false;
//										} else {
//											isFeasible = true;
//										}
//									}
//							}
						}
					}
//					if (!isFeasible) {
//						break;
//					}
					
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (isFeasible) {
			System.out.println("IS FEASIBLE");
		} else {
			System.out.println("IS NOT FEASIBLE");
			//astaireDataFiles/danceShowData_runningOrder.csv
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
	
	public boolean compareGroupNames(String name) {
		boolean isEqual = false;
		for(Group g : groupArray) {
			if (name.contains(g.getName())) {
				isEqual = true; 
				break;
			} else {
				isEqual = false;
			}
		}
		return isEqual;
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
