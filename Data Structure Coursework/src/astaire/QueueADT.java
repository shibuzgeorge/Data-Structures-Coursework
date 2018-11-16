package astaire;

import java.util.ArrayList;
import java.util.Iterator;

public class QueueADT<T> implements Iterable<T>{
	public ArrayList<T> dancersQ;
	
	public QueueADT(){
		dancersQ = new ArrayList<T>();
	}
	
	public void addElement(T cuckold){
		dancersQ.add(cuckold);
	}
	
	public void removeElement(T cuckold) {
		dancersQ.remove(cuckold);
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return dancersQ.iterator();
	}
}
