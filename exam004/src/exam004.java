import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class exam004 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			String [] goaltemp = br.readLine().split(" ")[0].split("");
			String [] goalString = new String [goaltemp.length - 1];
			for (int i = 0; i < goaltemp.length-1; i++) {
				goalString[i] = goaltemp[i+1];
			}
			
			if (goalString.length >= 10) {
				System.out.println("目標過長");
				System.exit(0);
			}
			
			String temp;
			List<String> stringMapTemp = new ArrayList<String>();
			while ((temp = br.readLine()) != null) {
				stringMapTemp.add(temp.split(" ")[0]);
			}
			
			if (stringMapTemp.get(0).length() >= 20 || stringMapTemp.size() >= 20) {
				System.out.println("陣列過大");
				System.exit(0);
			}
			
			String [][] stringMap = new String [stringMapTemp.size()][stringMapTemp.get(0).length()];
			for (int i = 0; i < stringMapTemp.size(); i++) {
				String [] strings = stringMapTemp.get(i).split("");
				for (int j = 0; j < strings.length-1; j++) {
					stringMap[i][j] = strings[j+1];
				}
			}
			
			int [] x_offset = {0, -1, -1, -1, 0, 1, 1, 1};
			int [] y_offset = {-1, -1, 0, 1, 1, 1, 0, -1};
			
			for (int i = 0; i < stringMap.length; i++) {
				for (int j = 0; j < stringMap[i].length; j++) {
					if (stringMap[i][j].equals(goalString[0])) {
						for (int k = 0; k < y_offset.length; k++) {
							if(isOutEdge(i, j, goalString.length, x_offset[k], y_offset[k], stringMap.length, stringMap[0].length)) {
								continue;
							}
							
							boolean isMatch = false;
							for (int l = 1; l < goalString.length; l++) {
								if (!stringMap[i+l*x_offset[k]][j+l*y_offset[k]].equals(goalString[l])) {
//									System.out.println("goal[l] = " + goalString[l] + " not equals " + stringMap[i+l*x_offset[k]][j+l*y_offset[k]]);
									isMatch = false;
									break;
								}else 
									isMatch = true;
							}
							
							// 0, 0 To 3, 0
							if (isMatch) {
								System.out.println(i + ", " + j + " To " + (i+(goalString.length-1)*x_offset[k]) + ", " + (j+(goalString.length-1)*y_offset[k]));
							}
						}
					}
				}
			}
			
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isOutEdge(int i, int j, int rage, int x, int y, int max_x, int max_y) {
		if(i+(rage-1)*x < 0 || i+(rage-1)*x > max_x || j+(rage-1)*y < 0 || j+(rage-1)*y > max_y) {
			return true;
		}
		
		return false;
	}
}
