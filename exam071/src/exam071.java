import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class exam071 {
	private static int [] soksCount;
	private static int [] wansCount;
	private static int [] tansCount;
	private static int [] wordsCount;
	private static int face;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		
//		字 :  東南西北中發白 對應  27~33
		try {
			String [] handStrings = readFileAndInitialInput();
			initAndcountHandPais(handStrings);
			face = 0;
			boolean isHasPair = false;
			
			int [] count = new int [34];
			
			checkChows(soksCount);
			checkChows(wansCount);
			checkChows(tansCount);
			
			checkPungs(soksCount);
			checkPungs(wansCount);
			checkPungs(tansCount);
			checkPungs(wordsCount);
			
			isHasPair = checkEye(soksCount)|checkEye(wansCount)|checkEye(tansCount)|checkEye(wordsCount);
			
			if (!isHasPair) {
				System.out.println("Lost :(");
			}else {
				System.out.println("WIN :)");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean checkEye(int[] pais) {
		if (face == 5) {
			for (int i = 0; i < pais.length; i++) {
				if (pais[i] == 2) {
					return true;
				}
			}
		}
		
		return false;
	}

	private static void checkPungs(int[] pais) {
		for (int i = 0; i < pais.length; i++) {
			if (pais[i] >= 3) {
				pais[i] -= 3;
				face++;
			}
		}
	}

	private static void checkChows(int[] pais) {
		for (int i = 0; i < pais.length-2; i++) {
			while (pais[i] > 0) {
				if (pais[i+1] > 0 && pais[i+2] > 0) {
					pais[i]--; pais[i+1]--; pais[i+2]--;
					face++;
				}else {
					break;
				}
			}
		}
	}

	private static void initAndcountHandPais(String[] handStrings) {
		soksCount = new int [9];	// 0-8
		wansCount = new int [9];	// 9-17
		tansCount = new int [9];	// 18-26
		wordsCount = new int [7];	// 27-33
		
		for (String string : handStrings) {
			int input = Integer.parseInt(string);
			if (input < 9) {
				soksCount[input]++;
			}else if (input < 18) {
				wansCount[input-9]++;
			}else if (input < 27) {
				tansCount[input-18]++;
			}else {
				wordsCount[input-27]++;
			}
		}
	}
	
	private static String[] readFileAndInitialInput() {
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			String [] handStrings = br.readLine().split(" ");
			
			br.close();
			fr.close();
			
			return handStrings;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new String[0];
	}

}
