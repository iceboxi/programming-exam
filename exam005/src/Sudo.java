

public class Sudo {
	private int [][][] sudo = new int [9][3][3];
	
	public Sudo(String [] rows) {
		
		for (int i = 0; i < rows.length; i++) {
			String [] row = rows[i].split("");
			for (int j = 0; j < row.length-1; j++) {
//				sudo[i][j] = Integer.parseInt(row[j+1]);
				
				if (i<3) {
					if (j<3) {
						//1
						sudo [0][i%3][j%3] = Integer.parseInt(row[j+1]);
					}else if (j<6) {
						//2
						sudo [1][i%3][j%3] = Integer.parseInt(row[j+1]);
					}else if (j<9) {
						//3
						sudo [2][i%3][j%3] = Integer.parseInt(row[j+1]);
					}
				}else if (i<6) {
					if (j<3) {
						//4
						sudo [3][i%3][j%3] = Integer.parseInt(row[j+1]);
					}else if (j<6) {
						//5
						sudo [4][i%3][j%3] = Integer.parseInt(row[j+1]);
					}else if (j<9) {
						//6
						sudo [5][i%3][j%3] = Integer.parseInt(row[j+1]);
					}
				}else if (i<9) {
					if (j<3) {
						//7
						sudo [6][i%3][j%3] = Integer.parseInt(row[j+1]);
					}else if (j<6) {
						//8
						sudo [7][i%3][j%3] = Integer.parseInt(row[j+1]);
					}else if (j<9) {
						//9
						sudo [8][i%3][j%3] = Integer.parseInt(row[j+1]);
					}
				}
			}
		}
		
//		for (int i = 0; i < sudo[3].length; i++) {
//			for (int j = 0; j < sudo[3][i].length; j++) {
//				System.out.print(sudo[3][i][j]);
//			}
//			System.out.println();
//		}
	}
	
	public int [] getRow(int rowNum) {
		int [] row = new int [9];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
//				System.out.println((i+rowNum/3*3) + " " + (rowNum%3) + " " + j);
				row[3*i+j] = sudo[i+rowNum/3*3][rowNum%3][j];
			}
		}
		
		return row;
	}
	
	public int [] getColumn(int colNum) {
		int [] col = new int [9];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				col[3*i+j] = sudo[i*3+colNum/3][j][colNum%3];
			}
		}
		
		return col;
	}
	
	public boolean isTrueSudo(String type, int lineNum, int [] num) {
		for (int i = 0; i < 9; i++) {
			int checkNum = num[i];
			int count = 0;
			for (int j = 0; j < num.length; j++) {
				if (num[j] == checkNum) {
					count++;
					if (count >= 2) {
						System.out.println(type + "[" + lineNum +"], #" + checkNum);
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public boolean isTrueSudo(int blockNum, int [][] num) {
		int [] toLine = new int [9];
		
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				toLine[i*3+j] = num[i][j];
			}
		}
		
		return isTrueSudo("block", blockNum, toLine);
	}
	
	public int[][] getBlock(int blockNum) {
		return sudo[blockNum];
	}
}
