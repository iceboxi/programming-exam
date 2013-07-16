import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class exam002 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			int caseNum = Integer.parseInt(br.readLine().split(" ")[0]);
			for (int i = 0; i < caseNum; i++) {
				String [] info = br.readLine().split(" ");
				String [][] graphInfo = new String [Integer.parseInt(info[0])][Integer.parseInt(info[1])];
				for (int j = 0; j < Integer.parseInt(info[0]); j++) {
					graphInfo[j] = br.readLine().split(" ");
				}
				
				for (int j = 0; j < graphInfo.length; j++) {
					for (int k = 0; k < graphInfo[j].length; k++) {
						if (graphInfo[j][k].equals("0")) {
							System.out.print("_");
							continue;
						}
						
						// top, bottom, left, right
						// 上下左右有任一個為0即為邊緣
						int [] x_offset = {-1, 1, 0, 0};
						int [] y_offset = {0, 0, -1, 1};
						
						boolean isEdge = false;
						for (int l = 0; l < 4; l++) {
							isEdge |= graphInfo[j + x_offset[l]][k + y_offset[l]].equals("0");
						}
						
						System.out.print( isEdge ? "0" : "_" );
					}
					System.out.println();				
				}
				System.out.println();
			}
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
