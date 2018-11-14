package astaire;

public class Dance<T> {

	private int Id;
	private String name;
	private QueueADT<T> performers;
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
	public QueueADT<T> getPerformers() {
		return performers;
	}
	public void setPerformers(QueueADT<T> performers) {
		this.performers = performers;
	}
	
}
