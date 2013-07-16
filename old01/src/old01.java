import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class old01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			int cases = Integer.parseInt(br.readLine());
			for (int i = 0; i < cases; i++) {
				String [] midStrings = br.readLine().split(" ");
				
				Transport.postfix(midStrings);
			}
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
