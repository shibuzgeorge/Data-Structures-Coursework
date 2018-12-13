package astaire;

public class CountTracker {
	
	private int foundOn;
	private int lastSeen;
	private int numOccurences;
	
	public CountTracker(int foundOn)
	{
		this.foundOn = foundOn;
		this.lastSeen = foundOn;
		this.numOccurences = 1;
	}

	public int getFoundOn() {
		return foundOn;
	}

	public void setFoundOn(int foundOn) {
		this.foundOn = foundOn;
	}

	public int getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(int lastSeen) {
		this.lastSeen = lastSeen;
	}

	public int getNumOccurences() {
		return numOccurences;
	}

	public void incrementNumOccurences() {
		this.numOccurences ++;
	}
}
