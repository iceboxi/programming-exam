import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class exam071 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//		�r :  �F�n��_���o�� ����  27~33
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			String [] handStrings = br.readLine().split(" ");
			int face = 0;
			boolean isHasPair = false;
			
			int [] count = new int [34];
			
			// ������@�P�i��
			for (int i = 0; i < handStrings.length; i++) { 
				count[Integer.parseInt(handStrings[i])]++;
			}
			
			// �D��
			// �� :  �@��~�E�� : 0~8 
			for (int i = 0; i <= 8 - 2; i++) {
				if (count[i] > 0) {
					if (count[i+1] > 0 && count[i+2] > 0) {
						count[i]--; count[i+1]--; count[i+2]--;
						face++;
					}
				}
			}
			
			// �U :  �@�U~�E�U : 9~17 
			for (int i = 9; i <= 17 - 2; i++) {
				if (count[i] > 0) {
					if (count[i+1] > 0 && count[i+2] > 0) {
						count[i]--; count[i+1]--; count[i+2]--;
						face++;
					}
				}
			}
			
			// �� :  �@��~�E�� : 18~26 
			for (int i = 18; i <= 26 - 2; i++) {
				if (count[i] > 0) {
					if (count[i+1] > 0 && count[i+2] > 0) {
						count[i]--; count[i+1]--; count[i+2]--;
						face++;
					}
				}
			}
			
			// �D��
			for (int i = 0; i < count.length; i++) {
				if (count[i] >= 3) {
					count[i] -= 3;
					face++;
				}
			}
			
			// �D��
			if (face == 5) {
				for (int i = 0; i < count.length; i++) {
					if (count[i] == 2) {
						isHasPair = true;
						System.out.println("WIN :)");
					}
				}
			}
			
			if (!isHasPair) {
				System.out.println("Lost :(");
			}
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
