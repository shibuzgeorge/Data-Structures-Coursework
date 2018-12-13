package astaire;


public class Performer implements Comparable<Performer>{
	
	int ID;
	String Name;
	Group group;
	
	public int getID() {
		return ID;
	}
	
	public Performer(int id_p, String name_param, Group group) {
		ID = id_p;
		Name = name_param;
		this.group = group;
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

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	public String toString() {
		return Name;
		
		
	}

	@Override
	public int compareTo(Performer p) {
		// TODO Auto-generated method stub
		return this.getName().compareToIgnoreCase(p.getName());
	}

	
	

}
