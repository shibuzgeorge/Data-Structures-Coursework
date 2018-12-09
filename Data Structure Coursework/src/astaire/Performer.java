package astaire;

public class Performer implements Comparable<Performer> {

	protected static int lastID = 0;
	private int ID;
	String Name;
	Group group;

	public int getID() {
		return ID;
	}

	public Performer(String name_param) {
		ID = nextID();
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

	@Override
	public int compareTo(Performer p) {
		// TODO Auto-generated method stub
		return this.getName().compareToIgnoreCase(p.getName());
	}

	private static int nextID() {
		return lastID++;

	}

	@Override
	public String toString() {
		return "Performer [ID=" + ID + ", Name=" + Name + "]";
	}

}
