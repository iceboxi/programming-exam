
public class Calculation {
	public static int function(int n) {
		if (n == 0 || n == 1) {
			return n+1;
		}else if (n > 1) {
			return function(n-1) + function(n/2);
		}
		
		return -1;
	}
}
