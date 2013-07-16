import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

// exam 087
public class old03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			int dimension = Integer.parseInt(br.readLine());
			int [][] array = new int [dimension][dimension];
			
			String data;
			while ((data = br.readLine()) != null) {
				toParserStringAndSetArray(array, data);
			}
			
			int [][] array_T = transport(array);
			
			int [][] result = new int [array.length][array_T[0].length];
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array_T[0].length; j++) {
					for (int j2 = 0; j2 < result.length; j2++) {
						result[i][j] += array[i][j2] * array_T[j2][j];
					}
				}
			}
			
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result.length; j++) {
					System.out.print(result[i][j] + ", ");
				}
				System.out.println();
			}
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void toParserStringAndSetArray(int [][] array, String data) {
		String row = data.split(":")[0].replace("(", "");
		String col = data.split(":")[1].split("\\)=")[0];
		String val = data.split(":")[1].split("\\)=")[1]; // ')' 應該是保留字元
		
//		String [] temp = data.split("(|:|=)");
//		for (int i = 0; i < temp.length; i++) {
//			System.out.println(temp[i]);
//		}
		
		array[Integer.parseInt(row)-1][Integer.parseInt(col)-1] = Integer.parseInt(val);
	}
	
	public static int[][] transport(int [][] array) {
		int [][] new_array = new int [array[0].length][array.length];
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				new_array[j][i] = array[i][j];
			}
		}
		
		return new_array;
	}
}
