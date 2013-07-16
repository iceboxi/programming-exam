import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class old08 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("Enter n(>0):");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 0;
		try {
			n = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Calculation.function(n));
	}

}
