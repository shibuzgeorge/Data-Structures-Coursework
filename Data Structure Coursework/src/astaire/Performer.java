package astaire;

public class Performer implements Comparable{
	
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

	@Override
	public int compareTo(Object o) {
		if (!(o instanceof Performer)) {
			return -1;
		}
		
		Performer p = (Performer) o;
		int c = this.getName().compareToIgnoreCase(p.getName());
		if ( c == 0) {
			c = this.getName().substring(0, 1).compareToIgnoreCase(p.getName().substring(0, 1));
		} else {
			c = -1;
		}
		return c;
	}
	
	

}
