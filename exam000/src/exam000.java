import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class exam000 {

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
				for (int i = input.length-1; i < input.length && i >= 0; i--) {
					System.out.print(input[i] + " ");
				}
				System.out.println();
			}
			
			br.close();
			fr.close();
			
			
//			char buffer[] = new char[(int)file.length()];
//			fr.read(buffer);
//			System.out.println(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
