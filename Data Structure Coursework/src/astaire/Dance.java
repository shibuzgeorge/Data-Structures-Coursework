package astaire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class Dance {

	private int Id;
	private String name;
	
	private TreeSet<Performer> performerTree;
	
	
	public Dance(int ID_param, String name_param) {
		Id = ID_param;
		name = name_param;
		performerTree = new TreeSet<Performer>();
	}
	
	public void removePerformer(Performer p) {
		//pQueue.removeElement(p);
		performerTree.remove(p);
	}
	
	public TreeSet<Performer> getAllPerformer() {
		return performerTree;	
	}
	
	public String getPerformers() {
		return performerTree.iterator().next().getName();
		
	}

	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public TreeSet<Performer> getPerformerTree() {
		return performerTree;
	}

	public void setPerformerTree(TreeSet<Performer> performerTree) {
		this.performerTree = performerTree;
	}


	
	
}