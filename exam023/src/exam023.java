import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class exam023 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			int cases = Integer.parseInt(br.readLine());
			for (int caseNum = 0; caseNum < cases; caseNum++) {
				int peopleNum = Integer.parseInt(br.readLine());
				int [][] heartScore = new int [peopleNum][peopleNum];
				for (int i = 0; i < peopleNum; i++) {
					String[] score = br.readLine().split(" ");
					for (int j = 0; j < score.length; j++) {
						heartScore[i][j] = Integer.parseInt(score[j]);
					}
				}
				
				List<Integer> boyChoiced = new ArrayList<Integer>();
				List<Integer> girlChoiced = new ArrayList<Integer>();
				for (int round = 0; round < peopleNum; round++) {
					int maxScore = -1;
					int [] tempCouple = new int[2];
					for (int i = 0; i < heartScore.length; i++) {
						if (isPeopleChoiced(i, boyChoiced)) {
							continue;
						}
						for (int j = 0; j < heartScore[i].length; j++) {
							if (isPeopleChoiced(j, girlChoiced)) {
								continue;
							}
							
							if (heartScore[i][j] > maxScore) {
								maxScore = heartScore[i][j]; 
								tempCouple[0] = i; 
								tempCouple[1] = j;
							}
						}
					}
					
					boyChoiced.add(tempCouple[0]);
					girlChoiced.add(tempCouple[1]);
				}
				
				for (int i = 0; i < peopleNum; i++) {
					System.out.println("boy " + (boyChoiced.get(i) + 1) + " pair with girl " + (girlChoiced.get(i) + 1));
				}
				
				System.out.println();
			}
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isPeopleChoiced(int peopleNum, List<Integer> choiced) {
		for (int i : choiced) {
			if (peopleNum == i) {
				return true;
			}
		}
		return false;
	}

}
