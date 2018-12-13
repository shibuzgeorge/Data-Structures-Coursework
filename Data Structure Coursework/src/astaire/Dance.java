package astaire;

import java.util.TreeSet;

public class Dance implements Comparable<Dance>{

	private int Id;
	private String name;
	
	private TreeSet<Performer> performerTree;
	
	
	public Dance(int ID_param, String name_param) {
		Id = ID_param;
		name = name_param;
		performerTree = new TreeSet<Performer>();
	}
	
	public void removePerformer(Performer p) {
		performerTree.remove(p);
	}
	
	public String getPerformers() {
		String allNames = "";
		for (Performer p : performerTree) {
			allNames = allNames + "" + p.getName() + ",";
		}
		return allNames;
	}
	
	public boolean comparePerformerNames(String[] name, Dance dName) {
		boolean isFound = false;
		for(int i = 0; i < name.length; i++) {
			if (dName.getPerformers().contains(name[i].trim())) {
				isFound = true;
				break;
			}
			dName.getPerformers();
		}
		return isFound;
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

	@Override
	public int compareTo(Dance d) {
		// TODO Auto-generated method stub
		return this.getName().compareToIgnoreCase(d.getName());
	}

	
	
}