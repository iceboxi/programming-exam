import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class exam001 {

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
				System.out.print(data + "->");

				input = reverce(input);
				
				for (int i = 0; i < input.length; i++) {
					System.out.print(input[i]+ " ");
				}
				
				System.out.println();
			}
			
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String[] reverce(String [] data) {
		String [] reverce = new String [data.length];
		for (int i = 0; i < data.length; i++) {
			reverce[data.length - i - 1] = data[i];
		}
		return reverce;
		
	}
}
