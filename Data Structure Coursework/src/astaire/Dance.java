package astaire;

public class Dance {

	private int Id;
	private String name;
	private QueueADT<Performer> pQueue;
	
	public Dance(int ID_param, String name_param) {
		Id = ID_param;
		name = name_param;
		pQueue = new QueueADT<>();
//		Performer tony = new Performer(5, "Tony Bearmount");
//		addPerformer(tony);
//		Performer azhar = new Performer(5, "Azhar Zaman");
//		addPerformer(azhar);
	}
	
	public void addPerformer(Performer p) {
		pQueue.addElement(p);
	}
	
	public void removePerformer(Performer p) {
		pQueue.removeElement(p);
	}
	
	public void exampleMethod() {
		for(Performer p: pQueue) {
			System.out.println(p.toString());
		}
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