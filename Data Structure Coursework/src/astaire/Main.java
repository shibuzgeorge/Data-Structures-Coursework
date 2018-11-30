package astaire;

public class Main {
	
	static TUI tui;
	static DanceShowGenerator dsg;
	private Dance dance;
	
	public Main() {
		dance = new Dance(69, "b");
		
		dsg = new DanceShowGenerator();
		tui = new TUI(dsg);
	}
	
	
	public static void main(String[] args) {
		new Main();
	}
	
}
