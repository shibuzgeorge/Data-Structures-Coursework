package astaire;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.TreeSet;

public class DanceShowGenerator implements Controller {
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
				for (Performer p : tree) {
					temp += p.getName() + ",";
				}
				break;
			}
		}
		return dance + temp + "]";
	}

	@Override
	public String listAllDancesAndPerformers() {
		// TODO Auto-generated method stub

		String output = "";
		System.out.println(ir.danceArray.size());
		for (int i = 0; i < ir.getDanceArray().size(); i++) {
			output += ir.getDanceArray().get(i).getName() + ": [";
			TreeSet<Performer> tempSet = ir.getDanceArray().get(i).getPerformerTree();
			for (Performer p : tempSet) {
				output += p.getName() + ", ";
			}

			output += "] \n";
		}
		return output;
	}

	@Override
	public String checkFeasibilityOfRunningOrder(String filename, int gaps) {
		// TODO Auto-generated method stub
		return ir.checkFeasibility(filename, gaps);
	}

	@Override
	public String generateRunningOrder(int gaps) {
		// TODO Auto-generated method stubs

		LinkedHashSet<String> generatedOrder;
		String names = "";
		generatedOrder = new LinkedHashSet<String>();
		Random rnd = new Random();
		boolean generate = true;
		int rndIndex = rnd.nextInt(ir.getDanceArray().size());
		while (generate) {
			for (int j = 0; j < gaps; j++) {
				int rndIndex2 = rnd.nextInt(ir.getDanceArray().size());
				String temp = ir.getDanceArray().get(rndIndex2).getPerformers();
				String[] eachName = temp.split(",");
				for (int i = 0; i < ir.getDanceArray().get(rndIndex2).getPerformerTree().size(); i++) {
					
					if (!ir.getDanceArray().get(rndIndex).comparePerformerNames(eachName,
							ir.getDanceArray().get(rndIndex))) {
						generatedOrder.add(ir.getDanceArray().get(rndIndex).getName() + "\t"
								+ ir.getDanceArray().get(rndIndex).getPerformers());
						generatedOrder.add(ir.getDanceArray().get(rndIndex2).getName() + "\t"
								+ ir.getDanceArray().get(rndIndex2).getPerformers());
					}
				}
				rndIndex = rndIndex2;
			}
			if (generatedOrder.size() >= ir.getDanceArray().size() - 1) {
				generate = false;
			}

		}
		PrintWriter pw;
		try {
			pw = new PrintWriter(new File("astaireDataFiles/test.csv"));
			StringBuilder sb = new StringBuilder();
			sb.append("Dance");
			sb.append('\t');
			sb.append("Performer");
			sb.append('\n');

			for (String s : generatedOrder) {
				sb.append(s);
				sb.append("\n");
			}

			pw.write(sb.toString());
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String s: generatedOrder) {
			names = names + s + "\n";
		}
		
		return names;

	}

}
