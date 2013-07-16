import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class exam027 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			List<double[]> formula = new ArrayList<double[]>();
			String data;
			while ((data = br.readLine()) != null) {
				String [] input = data.split(",");
				double [] equation = new double [input.length];
				for (int i = 0; i < input.length; i++) {
					equation[i] = Double.parseDouble(input[i]);
				}
				formula.add(equation);
			}
			
			for (int i = 0; i < formula.size(); i++) {
				double [] equation = formula.get(i);
				double dev = equation[i];
				if (dev != 1.0) {
					for (int j = 0; j < equation.length; j++) {
						equation[j] /= dev;
					}
					formula.set(i, equation);
				}
				
				for (int j = 0; j < formula.size(); j++) {
					if (j == i) {
						continue;
					}
					
					double [] action = formula.get(j);
					double p = -action[i];
					for (int k = 0; k < action.length; k++) {
						action[k] += equation[k]*p;
					}
					formula.set(j, action);
				}
			}
			
			for (int i = 0; i < formula.size(); i++) {
				double [] equation = formula.get(i);
				for (int j = 0; j < equation.length; j++) {
//					if (equation[j] == 1) {
//						System.out.println("X" + j + " = " + equation[equation.length-1]);
//						break;
//					}
					System.out.print(equation[j]+", ");
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
