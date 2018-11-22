package astaire;

import java.util.HashMap;

public class Dance {

	private int Id;
	private String name;
	
	
	public Dance(int ID_param, String name_param) {
		Id = ID_param;
		name = name_param;
		//pQueue = new QueueADT<>();
	}
	
	public void addPerformer(Performer p) {
		//pQueue.addElement(p);
	}
	
	public void removePerformer(Performer p) {
		//pQueue.removeElement(p);
	}
	
	public void exampleMethod() {
//		for(Performer p: pQueue) {
//			System.out.println(p.toString());
//		}
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
	
}