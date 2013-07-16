import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class exam294 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			int cases = Integer.parseInt(br.readLine());
			for (int casei = 0; casei < cases; casei++) {
				
				System.out.println("================ " + casei + " ====================");
				
				int [][] goalArray = new int [5][5];
				int [][] goalMap = new int [5][5];
				int [] match = new int [25];
				
				List<int[]> result = new ArrayList<int[]>();
				
				String [] goalStrings = br.readLine().split(",");
				String [] matchsStrings = br.readLine().split(",");
				for (int i = 0; i < goalStrings.length; i++) {
					goalArray[i/5][i%5] = Integer.parseInt(goalStrings[i]);
					match[i] = Integer.parseInt(matchsStrings[i]);
				}
				
//				for (int i = 0; i < goalArray.length; i++) {
//					for (int j = 0; j < goalArray[i].length; j++) {
//						System.out.print(goalArray[i][j] + ", ");
//					}
//					System.out.println();
//				}
				
				boolean end = false;
				for (int n = 0; n < matchsStrings.length; n++) {
					for (int i = 0; i < goalArray.length; i++) {
						for (int j = 0; j < goalArray[i].length; j++) {
							if (match[n] == goalArray[i][j]) {
								goalMap[i][j] = 1;
								end = is4Line(goalArray, goalMap, result);
								if (end) {
									System.out.println((n+1));
									for (int[] is : result) {
										for (int j2 = 0; j2 < is.length; j2++) {
											System.out.print(is[j2] + ", ");
										}
										System.out.println();
									}
									break;
								}
							}
						}
						if (end) {
							break;
						}
					}
					if (end) {
						break;
					}
				}
				
				if (!end) {
					System.out.println("error");
					for (int[] is : result) {
						for (int j2 = 0; j2 < is.length; j2++) {
							System.out.print(is[j2] + ", ");
						}
						System.out.println();
					}
				}
				
//				for (int i = 0; i < goalMap.length; i++) {
//					for (int j = 0; j < goalMap[i].length; j++) {
//						System.out.print(goalMap[i][j] + ", ");
//					}
//					System.out.println();
//				}
			}
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean is4Line(int[][] number, int[][] choice, List<int[]> result) {
		int [] x_offset = {0,1,1,1,0,-1,-1,-1};
		int [] y_offset = {1,1,0,-1,-1,-1,0,1};
		
		for (int i = 0; i < choice.length; i++) {
			for (int j = 0; j < choice[i].length; j++) {
				if (choice[i][j] == 1) {
					
					for (int j2 = 0; j2 < x_offset.length; j2++) {	
						int [] match = new int [4];
						match[0] = number[i][j];
						for (int k = 1; k < 4; k++) {
							if (i+x_offset[j2]*k > -1 && i+x_offset[j2]*k < choice.length && j+y_offset[j2]*k > -1 && j+y_offset[j2]*k < choice[0].length) {
								if (choice[i+x_offset[j2]*k][j+y_offset[j2]*k] == 1) {
									match[k] = number[i+x_offset[j2]*k][j+y_offset[j2]*k];
								}else {
									match[0] = -1;
									break;
								}
							}else {
								match[0] = -1;
								break;
							}
						}
						
						if (match[0] != -1) {
//							System.out.println("match");
//							for (int k = 0; k < match.length; k++) {
//								System.out.print(match[k] + ", ");
//							}
//							System.out.println();
							if (!isInResult(match, result) && !isSameLine(match, result)) {
								result.add(match);
								
//								System.out.println("result");
//								for (int[] is : result) {
//									for (int kk = 0; kk < is.length; kk++) {
//										System.out.print(is[kk] + ", ");
//									}
//									System.out.println();
//								}
							}
						}
					}
				}
			}
		}
		
		if (result.size() == 4) {
			return true;
		}
		
		return false;
	}

	public static boolean isInResult(int [] match, List<int[]> result) {
		QuickSort.sort(match);
		
//		System.out.println("sorted");
//		for (int k = 0; k < match.length; k++) {
//			System.out.print(match[k] + ", ");
//		}
//		System.out.println();
		
		boolean isMatch = false;
		for (int[] is : result) {
			if (isMatch) 
				break;
			for (int i = 0; i < is.length; i++) {
				if (match[i] != is[i]) {
					break;
				}
				isMatch = true;
			}
		}
		
		return isMatch;
	}
	
	public static boolean isSameLine(int [] match, List<int[]> result) {
		boolean isSame = false;
		for (int[] is : result) {
			int count = 0;
			for (int i = 0; i < is.length; i++) {
				for (int j = 0; j < match.length; j++) {
					if (is[i] == match[j]) {
						count++;
					}
				}
			}
			if (count >= 3) {
				isSame = true;
				break;
			}
		}
		
		return isSame;
	}
}
