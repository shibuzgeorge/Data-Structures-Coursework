package astaire;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {
	
	String path;
	String[] lines;
	String[] groups;
	
	public InputReader(String filePath) {
		path = filePath;
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
	
	public void read() {
		
		 try {
			 lines = OpenFile();
			 for (int i = 1; i < lines.length; i++) {
				System.out.println(lines[i].substring(0, lines[i].indexOf("\t"))); //Group names
				
				System.out.println(lines[i].substring(lines[i].indexOf("\t")+1)); //List of performer names
				
			 }
		 }catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
