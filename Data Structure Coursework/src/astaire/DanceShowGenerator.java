package astaire;

import java.util.TreeSet;

public class DanceShowGenerator implements Controller{
	
	String fn; //fileName
	InputReader ir;
	
	public DanceShowGenerator() {
		ir = new InputReader();
		ir.readGroupNames("astaireDataFiles/danceShowData_danceGroups.csv");
		ir.readNames(true, "astaireDataFiles/danceShowData_danceGroups.csv");
		ir.readDances("astaireDataFiles/danceShowData_dances.csv");
		ir.readNames(false, "astaireDataFiles/danceShowData_dances.csv");
		
	}

	@Override
	public String listAllDancersIn(String dance) {
		// TODO Auto-generated method stub
		String temp = ": [";
		for (int i = 0; i < ir.danceArray.size(); i++) {
			TreeSet<Performer> tree = new TreeSet<Performer>();
			TreeSet<Performer> tempSet = ir.danceArray.get(i).getPerformerTree();
			tree.addAll(tempSet);
			if (dance.contains(ir.danceArray.get(i).getName())) {
				for (Performer p: tree) {
					 temp += p.getName() +  ",";
				}
				break;
			}
		}
		return  dance + temp + "]";
	}

	@Override
	public String listAllDancesAndPerformers() {
		// TODO Auto-generated method stub
		
		String output = "";
		System.out.println(ir.danceArray.size());
		for (int i = 0; i < ir.getDanceArray().size(); i++) {
			output += ir.getDanceArray().get(i).getName() + ": [";
			TreeSet<Performer> tempSet = ir.getDanceArray().get(i).getPerformerTree();
			for(Performer p: tempSet) {
				output += p.getName() + ", ";
			}

			output += "] \n";
		}
		return output ;
	}

	@Override
	public String checkFeasibilityOfRunningOrder(String filename, int gaps) {
		// TODO Auto-generated method stub
		ir.checkFeasibility(filename, gaps);
		return null;
	}

	@Override
	public String generateRunningOrder(int gaps) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
