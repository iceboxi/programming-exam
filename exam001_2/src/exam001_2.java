import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class exam001_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File file = new File("input.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String data;
			
			while ((data = br.readLine()) != null) {
				String [] input = data.split(" ");
				long sum = 0;
				for (int i = 0; i < input.length; i++) {
					sum += Integer.parseInt(input[i]) * Integer.parseInt(input[i]) * Integer.parseInt(input[i]);
				}
				
				System.out.println("sum = " + sum);
			}
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
