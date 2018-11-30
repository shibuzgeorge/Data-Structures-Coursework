package astaire;

import java.util.TreeSet;

public class DanceShowGenerator implements Controller{
	
	String fn; //fileName
	InputReader ir;
	
	public DanceShowGenerator() {
		ir = new InputReader();
		ir.readGroupNames("astaireDataFiles/danceShowData_danceGroups.csv");
		ir.readNames("astaireDataFiles/danceShowData_danceGroups.csv", true);
		ir.readDances("astaireDataFiles/danceShowData_dances.csv");
		ir.readNames("astaireDataFiles/danceShowData_dances.csv", false);
	}

	@Override
	public String listAllDancersIn(String dance) {
		// TODO Auto-generated method stub
		String temp = ": ";
		for (int i = 0; i < ir.danceArray.size(); i++) {
			TreeSet<Performer> tempSet = ir.danceArray.get(i).getPerformerTree();
			
			System.out.println("typed: " + dance);
			System.out.println("inspected: " + ir.danceArray.get(i).getName());
			
			if (dance.contains(ir.danceArray.get(i).getName())) {
				System.out.println(dance);
				System.out.println(ir.danceArray.get(i).getName());
				for (Performer p: tempSet) {
					System.out.println("luns");
					temp += p.getName();
				}
				break;
			} else {
				System.out.println("DANCE NAME NOT FOUND");
			}
		}
		return dance + temp;
	}
	
	//Singing in the Rain

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
