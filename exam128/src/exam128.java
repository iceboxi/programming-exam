import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class exam128 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			int cases = Integer.parseInt(br.readLine());
			for (int caseNum = 0; caseNum < cases; caseNum++) {
				String [] questions = br.readLine().split(",");
				int degree = Integer.parseInt(questions[0]);
				int startPoint = Integer.parseInt(questions[1]) -1;
				int endPoint = Integer.parseInt(questions[2]) -1;
				
				String [][] dataStrings = new String [degree][degree];
				for (int i = 0; i < degree; i++) {
					dataStrings[i] = br.readLine().split(" ");
				}
				int [][] matrix = createPathMatrix(dataStrings);
				
				List<List<Integer>> oldPathList = new ArrayList<List<Integer>>();
				List<Integer> initPath = new ArrayList<Integer>();
				initPath.add(startPoint);
				oldPathList.add(initPath);
				
				boolean isFinedMinPath = false;
				while (!isFinedMinPath) {
					List<List<Integer>> newPathList = new ArrayList<List<Integer>>();
					for (List<Integer> integer : oldPathList) {
						Integer last = integer.get(integer.size()-1);
						for (int i = 0; i < matrix.length; i++) {
							List<Integer> newPath = new ArrayList<Integer>();
							for (int j = 0; j < integer.size(); j++) {
								newPath.add(integer.get(j));
							}
							if (matrix[last][i] == 1) {
								newPath.add(i);
								newPathList.add(newPath);
								if (i == endPoint) {
									isFinedMinPath = true;
								}
							}
						}
					}
					oldPathList = newPathList;
				}
				
				for (List<Integer> integer : oldPathList) {
//					System.err.println("1111");
					if (integer.get(integer.size()-1) == endPoint) {
						for (Integer integer2 : integer) {
							System.out.print((integer2+1) + ", ");
						}
						System.out.println();
					}
				}
				System.out.println();
			}
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int [][] createPathMatrix(String [][] data) {
		int [][] result = new int [data.length][data[0].length];
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = Integer.parseInt(data[i][j]);
			}
		}
		
		return result;
	}
}
