import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class exam005 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			int caseNum = Integer.parseInt(br.readLine().split(" ")[0]);
			for (int i = 0; i < caseNum; i++) {
				String [] rows = new String[9];
				for (int j = 0; j < 9; j++) {
					rows[j] = br.readLine().split(" ")[0];
				}
				
				boolean isTrue = true;
				Sudo sudo = new Sudo(rows);
				for (int j = 0; j < 9; j++) {
					int [] row = sudo.getRow(j);
					isTrue &= sudo.isTrueSudo("row", j+1, row);
//					for (int k = 0; k < row.length; k++) {
//						System.out.print(row[k]);
//					}
//					System.out.println();
				}
				
				for (int j = 0; j < 9; j++) {
					int [] col = sudo.getColumn(j);
					isTrue &= sudo.isTrueSudo("column", j+1, col);
//					for (int k = 0; k < col.length; k++) {
//						System.out.print(col[k]);
//					}
//					System.out.println();
				}
				
				for (int j = 0; j < 9; j++) {
					isTrue &= sudo.isTrueSudo(j+1, sudo.getBlock(j));
				}
				
				if (isTrue) {
					System.out.println("true");
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
