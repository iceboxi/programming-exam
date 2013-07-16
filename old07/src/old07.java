import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class old07 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			int dimension = Integer.parseInt(br.readLine());
			int [][] match = new int [dimension][dimension];
			
			for (int i = 0; i < dimension; i++) {
				String [] data = br.readLine().split(" ");
				setArrayWithStrings(match, data, i);
			}
			
			dimension = Integer.parseInt(br.readLine());
			int [][] template = new int [dimension][dimension];
			
			for (int i = 0; i < dimension; i++) {
				String [] data = br.readLine().split(" ");
				setArrayWithStrings(template, data, i);
			}
			
			int [] location = templateMatching(match, template);
			
			System.out.println(location[0] + " " + location[1]);
			
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
	
	public static int[] templateMatching(int [][] match, int [][] template) {
		int [] location = new int [2];
		
		int min_value = template.length * template.length;
		for (int i = 0; i < template.length - match.length; i++) {
			for (int j = 0; j < template[0].length - match.length; j++) {
				int d_sum = 0;
				for (int m = 0; m < match.length; m++) {
					for (int n = 0; n < match[m].length; n++) {
						if (match[m][n] != template[i+m][j+n]) {
							d_sum += differentValue(m, n, match.length);
						}
					}
				}
				if (d_sum < min_value) {
					location[0] = i+1;
					location[1] = j+1;
					if (d_sum == 0) {
						return location;
					}
					min_value = d_sum;
				}
			}
		}
		
		return location;
	}
	
	public static int differentValue(int x, int y, int dimension) {
		for (int i = 0; i < dimension / 2 + 1; i++) {
			if (x == i || x == dimension - i - 1) {
				return i+1;
			}else if (y == i || y == dimension - i - 1) {
				return i+1;
			}
		}
		
		return -1;
	}
}
