import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class exam006 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			int cases = Integer.parseInt(br.readLine());
			for (int i = 0; i < cases; i++) {
				String numString = br.readLine();
				System.out.print(numString + " -> ");
				int maxPrime = -1;
				for (int j = numString.length(); j > 0; j--) {
					for (int j2 = 0; j2 <= numString.length()-j; j2++) {
						String subNumString = numString.substring(j2, j2+j);
						if (isPrime(subNumString)) {
							maxPrime = Integer.parseInt(subNumString) > maxPrime ? Integer.parseInt(subNumString) : maxPrime;
						}
					}
					if (maxPrime != -1) {
						System.out.println(String.valueOf(maxPrime));
						break;
					}
				}
				
				if (maxPrime == -1) {
					System.out.println("No prime found");
				}
			}
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean isPrime(String numString) {
		int num = Integer.parseInt(numString);
		
		if(num == 0 || num == 1) return false;
		
		for (int i = 2; i < num/2+1; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
