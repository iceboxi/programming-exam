import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class old06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			int many = Integer.parseInt(br.readLine());
			for (int mc = 0; mc < many; mc++) {
				int dimension = Integer.parseInt(br.readLine());
				int [][] array = new int [dimension][dimension];
				
				for (int i = 0; i < dimension; i++) {
					String [] data = br.readLine().split(" ");
					setArrayWithStrings(array, data, i);
				}
				
//				printArray(array);
				
				List<Integer> caseNums = findNodeHave3UpLine(array); // 有三條線以上的點
				
				List<int[]> cases = findAllCase(caseNums);			 // 取出所有不重複組合n取4
				int count = checkDiamond(cases, array);
				
				System.out.println(count);
			}
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setArrayWithStrings(int [][] array, String [] data, int row) {
		for (int i = 0; i < data.length; i++) {
			array[row][i] = Integer.parseInt(data[i]);
		}
	}
	
	public static void printArray(int [][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + ", ");
			}
			System.out.println();
		}
	}
	
	public static List<Integer> findNodeHave3UpLine(int [][] array) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			int count = 0;
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == 1) {
					count++;
				}
			}
			
			if (count >= 3) {
				result.add(i);
			}
		}
		
		return result;
	}
	
	public static List<int[]> findAllCase(List<Integer> nums) {
		List<int[]> result = new ArrayList<int[]>();
		
		for (int i = 0; i < nums.size(); i++) {
			for (int j = 1; j < nums.size() -i - 2; j++) {
				int [] choice = new int [4];
				choice[0] = nums.get(i);
				choice[1] = nums.get(j+i);
				choice[2] = nums.get(j+i+1);
				choice[3] = nums.get(j+i+2);
				
				result.add(choice);
			}
		}
		
		return result;
	}
	
	public static int checkDiamond(List<int[]> points, int [][] array) {
		int count = 0;
		
		for (int[] is : points) {
			boolean isDiamond = true;
			for (int i = 0; i < is.length; i++) {
				for (int j = 0; j < is.length; j++) {
					if (i == j) {
						continue;
					}
//					System.out.println(is[i] + ", " + is[j]);
					if(array[is[i]][is[j]] != 1) {
						isDiamond = false;
						break;
					}
				}
			}
			
			if (isDiamond) {
				count++;
			}
		}
		return count;
	}
}
