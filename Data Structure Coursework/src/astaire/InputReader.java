package astaire;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class InputReader {

//	String path;
//	String[] lines;

	ArrayList<Group> groupArray;
	ArrayList<Dance> danceArray;
	ArrayList<Performer> performers;

	private HashMap<String, TreeSet<Performer>> danceMap;

	public InputReader() {
		groupArray = new ArrayList<Group>();
		performers = new ArrayList<Performer>();
		danceArray = new ArrayList<Dance>();

	}

	public void readGroupNames(String filename) {
		ArrayList<String> lines = null;
		// try to open the file
		try {
			lines = openFile(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (lines != null) // if the array has some contents
		{
			// convert to primitive string array
			String[] linesArray = lines.toArray(new String[lines.size()]);
			// start at 1 to miss the title
			for (int i = 1; i < linesArray.length; i++) {
				// find the tab and read what comes before it
				String groupName = linesArray[i].substring(0, linesArray[i].indexOf("\t"));
				groupArray.add(new Group(groupName));
			}
		}
	}

	private ArrayList<String> openFile(String filename) throws IOException {
		ArrayList<String> lines = new ArrayList<String>();
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lines;
	}

	public void readNames(String filename) {
		ArrayList<String> lines = null;
		// try to open the file
		try {
			lines = openFile(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (lines != null) // if the array has some contents
		{
			// convert to primitive string array
			String[] linesArray = lines.toArray(new String[lines.size()]);

			for (int i = 1; i < linesArray.length; i++) {
				int start = linesArray[i].indexOf("\t") + 1;
				String[] performersListInOneLine = linesArray[i].substring(start).split(",");

				for (int j = i - 1; j < performersListInOneLine.length; j++) {
					performers.add(new Performer(performersListInOneLine[j]));
				}
			}
		}

	}

	public void readDances(String filename) {

		ArrayList<String> lines = null;
		// try to open the file
		try {
			lines = openFile(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (lines != null) // if the array has some contents
		{
			String[] linesArray = lines.toArray(new String[lines.size()]);
			for (int i = 1; i < linesArray.length; i++) {
				String danceName = (linesArray[i].substring(0, linesArray[i].indexOf("\t")));
				danceArray.add(new Dance(danceName));
			}
		}
	}
}
