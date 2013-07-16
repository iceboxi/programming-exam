import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class exam308 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			String [] wp = br.readLine().split(" ");
			String [] wc = br.readLine().split(" ");
			
			String [][] L = {{"a"}, {"a", "b"}, {"a", "b", "c"}, {"a", "b", "c", "d"}, {"a", "b", "c", "d", "e"}};
			int n = Integer.parseInt(br.readLine()) - 1;
			
			String [] choice = L[n];
		
			List<List<String>> pathList = new ArrayList<List<String>>();
			for (int i = 0; i < choice.length; i++) {
				List<String> initPath = new ArrayList<String>();
				initPath.add(choice[i]);
				pathList.add(initPath);
			}
			
			for (int round = 1; round < choice.length; round++) {
				List<List<String>> newPathList = new ArrayList<List<String>>();
				for (List<String> path : pathList) {
					for (int i = 0; i < choice.length; i++) {
						if (!isInThere(path, choice[i])) {
							List<String> newPath = new ArrayList<String>();
							for (String point : path) {
								newPath.add(point);
							}
							newPath.add(choice[i]);
							newPathList.add(newPath);
						}
					}
				}
				pathList = newPathList;
			}
			
			List<Action> resultList = new ArrayList<Action>();
			for (List<String> list : pathList) {
				String str = "";
				int sum = 0;
				for (int i = 0; i < list.size(); i++) {
					sum += Integer.parseInt(wp[i]) * Integer.parseInt(wc[getPoint(list.get(i))]);
					str += list.get(i);
				}
				Action ac = new Action();
				ac.setModel(str);
				ac.setValue(sum);
				if (resultList.size() == 0) {
					resultList.add(ac);
				}
				
				for (Action action : resultList) {
					if (action.getValue() < ac.getValue()) {
						resultList.add(resultList.indexOf(action), ac);
						break;
					}
				}
			}
			
			for (Action action : resultList) {
				System.out.println(action.getModel() + " " + action.getValue());
			}
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean isInThere(List<String> list, String point) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(point)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static int getPoint(String a) {
		if (a.equals("a")) {
			return 0;
		}else if(a.equals("b")) {
			return 1;
		}else if(a.equals("c")) {
			return 2;
		}else if(a.equals("d")) {
			return 3;
		}else {
			return 4;
		}
	}
}
