import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class exam078 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			int memberNum = Integer.parseInt(br.readLine());
			
			int [][] distance = new int [memberNum+1][memberNum+1];
			for (int i = 0; i < memberNum+1; i++) {
				String [] input = br.readLine().split(" ");
				for (int j = 0; j < input.length; j++) {
					distance[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			boolean isDone = false;
			List<Integer> connected = new ArrayList<Integer>();
			connected.add(0);
			
			int sum = 0;
			
			while (connected.size() < memberNum+1) {
				int min = 10000;
				int [] point = new int [2];
				for (Integer integer : connected) {
					for (int i = 0; i < distance[integer].length; i++) {
						if (distance[integer][i] < min && connected.indexOf(i) == -1) {
							min = distance[integer][i];
							point[0] = integer; point[1] = i;
						}
					}
				}
				sum += min;
				connected.add(point[1]);
			}
			
			System.out.println(sum);
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
