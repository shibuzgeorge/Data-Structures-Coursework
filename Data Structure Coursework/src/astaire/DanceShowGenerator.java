package astaire;

public class DanceShowGenerator implements Controller{
	
	String fn; //fileName
	InputReader ir;
	
	public DanceShowGenerator() {
		ir = new InputReader();
		ir.readGroupNames("astaireDataFiles/danceShowData_danceGroups.csv");
		ir.readNames("astaireDataFiles/danceShowData_danceGroups.csv", true);
		ir.readDances("astaireDataFiles/danceShowData_dances.csv");
	}

	@Override
	public String listAllDancersIn(String dance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listAllDancesAndPerformers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkFeasibilityOfRunningOrder(String filename, int gaps) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateRunningOrder(int gaps) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
