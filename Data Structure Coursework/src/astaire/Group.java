package astaire;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Group {
	
	protected static int lastID = 0;
	private int ID;
	private String Name;
	private ArrayList<Performer> performerList;

	public Group(String gn) {
		ID = nextID();
		Name = gn;
		performerList = new ArrayList<>();
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	public void addPerformer(Performer p) {
		performerList.add(p);
	}

	public ArrayList<Performer> getPerformerList() {
		return performerList;
	}

	public void setPerformerList(ArrayList<Performer> performerList) {
		this.performerList = performerList;
	}
	
	private static int nextID()
	{
		return lastID++;
		
	}
	
	

}
