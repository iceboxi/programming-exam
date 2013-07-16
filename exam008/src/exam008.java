import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class exam008 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			String [] input = br.readLine().split(",");
			int pay = (int)PhonePay.howMuch(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			System.out.println(pay);
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
