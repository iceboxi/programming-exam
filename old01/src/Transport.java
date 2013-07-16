import java.util.ArrayList;
import java.util.List;


public class Transport {
	public static void postfix(String [] mid) {
		List<String> stack = new ArrayList<String>();
		for (String string : mid) {
			switch (string.charAt(0)) {
			case '(':
				stack.add(string);
				break;

			case '+':
			case '-':
			case '*':
			case '/':
				while (stack.size() > 0 && priority(stack.get(stack.size()-1)) > priority(string)) {
					System.out.print(" " + stack.get(stack.size()-1));
					stack.remove(stack.size()-1);
				}
				
				stack.add(string);
				break;
				
			case ')':
				while (!stack.get(stack.size()-1).equals("(")) {
					System.out.print(" " + stack.get(stack.size()-1));
					stack.remove(stack.size()-1);
				}
				stack.remove(stack.size()-1); // ¤£¦L (
				break;
				
			default:
				System.out.print(" " + string);
				break;
			}
		}
		
		while (stack.size() > 0) {
			System.out.print(" " + stack.get(stack.size()-1));
			stack.remove(stack.size()-1);
		}
		
		System.out.println();
	}
	
	private static int priority(String s) {
		switch (s.charAt(0)) {
		case '+':
		case '-':	
			return 1;
		
		case '*':
		case '/':
			return 2;
			
		default:
			return 0;
		}
	}
}
