import java.io.BufferedReader;
import java.io.InputStreamReader;


public class exam075 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("Enter # cases:");
			int cases = Integer.parseInt(br.readLine());
			for (int i = 0; i < cases; i++) {
				System.out.print("what's n?");
				int n = Integer.parseInt(br.readLine());
				System.out.println(calculationSum(n));
			}
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int calculationSum(int n) {
		if (n < 0) {
			return -1;
		}else if (n == 1) {
			return 0;
		}else {
			return (n+1) * n * (n-1) + calculationSum(n-1);
		}
	}
}
