package astaire;

public class Main {
	
	static TUI tui;
	static DanceShowGenerator dsg;
	
	public static void main(String[] args) {
		dsg = new DanceShowGenerator();
		tui = new TUI(dsg);
	}
	
}
