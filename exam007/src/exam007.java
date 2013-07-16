import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.naming.ldap.SortControl;


public class exam007 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			String [] inputStrings = br.readLine().split("");
			int [] num = new int [inputStrings.length-1];
			for (int i = 0; i < num.length; i++) {
				num[i] = Integer.parseInt(inputStrings[i+1]);
			}
			
			QuickSort.sort(num);
			
			String [] sortedStrings = new String [num.length];
			for (int i = 0; i < sortedStrings.length; i++) {
				sortedStrings[i] = String.valueOf(num[i]);
			}
			
			String max = "", min = "";
			for (int i = 0; i < sortedStrings.length; i++) {
				min += sortedStrings[i];
				max += sortedStrings[sortedStrings.length-i-1];
			}
			
			System.out.println(Integer.parseInt(max) - Integer.parseInt(min));
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
