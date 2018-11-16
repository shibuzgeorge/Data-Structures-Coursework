package astaire;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class InputReader {
	
	String path;
	String[] lines;
	String[] names;
	String[] groupNames;
	
	public InputReader() {
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
	
	public String[] readGroupNames(String fileName) {
		path = fileName;
		 try {
			 lines = OpenFile();
			 for (int i = 1; i < lines.length; i++) {
				 
				//System.out.println(lines[i].substring(0, lines[i].indexOf("\t"))); //Group names
				String line = (lines[i].substring(0, lines[i].indexOf("\t")));
				String[] groupNames = line.split("\t");
				for (int j = 0; j < groupNames.length; j++) {
					System.out.println(groupNames[j].substring(0));
				}
			 }
		 }catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return groupNames;
	}
	
	public String[] readPerfomerNames(String fileName) {
		path = fileName;
		int k = 0;
		 try {
			 lines = OpenFile();
			 for (int i = 1; i < lines.length; i++) {
				//Prints all names of performers
				String line = (lines[i].substring(lines[i].indexOf("\t")+1));
				names = line.split(",");
				for (int j = 0; j < names.length; j++) {
					new Performer(k, names[j]);
					k++;
				}
			 }
		 }catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return names;
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
						new Dance(k, danceNames[j]).getName();
						k++;
					}
			 }
		 }catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
