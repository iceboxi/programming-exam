import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class exam102 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			int cases = Integer.parseInt(br.readLine());
			String [] input = br.readLine().split(" ");
			
			for (int i = 0; i < input.length; i++) {
				System.out.println(findTriangle(Integer.parseInt(input[i])));
			}
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean isTriangle(int i, int j, int k) {
		return i+j>k ? true : false;
	}
	
	public static int findTriangle(int n) {
		int count = 0;
		
		for (int i = 1; i < n+1; i++) {
			for (int j = i+1; j < n+1; j++) {
				for (int k = j+1; k < n+1; k++) {
					count += isTriangle(i, j, k) ? 1 : 0;
				}
			}
		}
		
		return count;
	}
}
