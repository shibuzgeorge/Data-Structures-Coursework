package astaire;

public interface QueueADT<T>{
	
	public void enqueue(T Element);
	
	public T dequeue();
	
	public boolean contains();
	
	public T first();
	
	public boolean isEmpty();
	
	public int size();
	
	public String toString();
}
