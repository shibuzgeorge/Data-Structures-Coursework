package astaire;

public class Performer {
	
	int ID;
	String Name;
	Group group;
	public int getID() {
		return ID;
	}
	
	public Performer(int id_p, String name_param) {
		ID = id_p;
		Name = name_param;
		
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
	
	

}
