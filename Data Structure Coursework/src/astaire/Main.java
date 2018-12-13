package astaire;

public class Main {
	
	static TUI tui;
	static DanceShowGenerator dsg;
	
	public Main() {
		
		dsg = new DanceShowGenerator();
		tui = new TUI(dsg);
	}
	
	
	public static void main(String[] args) {
		new Main();
	}
	
}
