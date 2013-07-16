import java.io.BufferedReader;
import java.io.InputStreamReader;


public class exam175 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.print("Enter a int number:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(br.readLine());
			int [][] magic = createMagicMatrix2(num);
			
			for (int i = 0; i < magic.length; i++) {
				for (int j = 0; j < magic[i].length; j++) {
					System.out.print(magic[i][j] + ", ");
				}
				System.out.println();
			}
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 用的規則?  一個是左上->有數就左上往下  另一個是 左上->有數就原地往下
	 */
	public static int[][] createMagicMatrix(int num) {
		int [][] matrix = new int [num][num];
		
		int x = 0;
		int y = num / 2;
		matrix[x][y] = 1;
		for (int i = 2; i <= num*num; i++) {
			if (isInArray(x-1, num) && isInArray(y+1, num)) {
				if (matrix[x-1][y+1] == 0) {
					matrix[x-1][y+1] = i;
					x = x-1;
					y = y+1;
				}else if (matrix[x-1 + 1][y+1] == 0) {
					matrix[x-1 + 1][y+1] = i;
					x = x-1 + 1;
					y = y+1;
				}
			}else {
				if (!isInArray(x-1, num)) {
					x = (x-1) + num;
				}else {
					x = x-1;
				}
				if (!isInArray(y+1, num)) {
					y = (y+1) - num;
				}else {
					y = y+1;
				}
				
				if (matrix[x][y] == 0) {
					matrix[x][y] = i;
				}else if (matrix[x + 1][y] == 0) {
					matrix[x + 1][y] = i;
					x = x + 1;
				}
			}
//			System.out.println(x + ", " + y);
		}
		
		return matrix;
	}
	
	public static int[][] createMagicMatrix2(int num) {
		int [][] matrix = new int [num][num];
		
		int x = 0;
		int y = num / 2;
		matrix[x][y] = 1;
		for (int i = 2; i <= num*num; i++) {
			if (isInArray(x-1, num) && isInArray(y+1, num)) {
				if (matrix[x-1][y+1] == 0) {
					matrix[x-1][y+1] = i;
					x = x-1;
					y = y+1;
				}else if (matrix[x + 1][y] == 0) {
					matrix[x + 1][y] = i;
					x = x + 1;
					y = y;
				}
			}else {
				int temp_x = x;
				int temp_y = y;
				if (!isInArray(x-1, num)) {
					x = (x-1) + num;
				}else {
					x = x-1;
				}
				if (!isInArray(y+1, num)) {
					y = (y+1) - num;
				}else {
					y = y+1;
				}
				
				if (matrix[x][y] == 0) {
					matrix[x][y] = i;
				}else if (matrix[temp_x+1][temp_y] == 0) {
					matrix[temp_x+1][temp_y] = i;
					x = temp_x+1;
					y = temp_y;
				}
			}
//			System.out.println(x + ", " + y);
		}
		
		return matrix;
	}
	
	public static boolean isInArray(int x, int degree) {
		if (x >= 0 && x < degree) {
			return true;
		}
		return false;
	}
}
