import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

// exam 116
public class old04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			String [] casesStrings = br.readLine().split(" ");
			String [] pointsName = br.readLine().split(" ");
			List<String> pointsList = new ArrayList<String>();
			for (int i = 0; i < pointsName.length; i++) {
				pointsList.add(pointsName[i]);
			}
			
			List<LineInfo> lineInfos = new ArrayList<LineInfo>();
			String data;
			while ((data = br.readLine()) != null) {
				String [] value = data.split(" ");
				LineInfo lineInfo = new LineInfo(value);
				int i = 0;
				for (LineInfo info : lineInfos) {	// ¶¶«K±Æ§Ç
					if (info.getDistance() > lineInfo.getDistance()) {
						break;
					}
					i++;
				}
				
				lineInfos.add(i, lineInfo);
			}
			
			List<LineInfo> result = new ArrayList<LineInfo>();
			List<List<String>> info = new ArrayList<List<String>>();
			
			for (LineInfo li : lineInfos) {
//				for (List<String> list : info) {
//					for (String string : list) {
//						System.out.print(string + ", ");
//					}
//					System.out.println();
//				}
//				System.out.println();
				
				int startListNum = -1;
				int endListNum = -1;
				for (int m = 0; m < info.size(); m++) {
					List<String> list = info.get(m);
					if (list.indexOf(li.getStart()) != -1) {
						startListNum = m;
					}
					if (list.indexOf(li.getEnd()) != -1) {
						endListNum = m;
					}
				}
				
				if (startListNum == -1 && endListNum == -1) {
					List<String> list = new ArrayList<String>();
					list.add(li.getStart());
					list.add(li.getEnd());
					info.add(list);
					
					result.add(li);
				}else if (startListNum == -1) {
					List<String> list = info.get(endListNum);
					list.add(li.getStart());
					info.set(endListNum, list);
					
					result.add(li);
				}else if (endListNum == -1) {
					List<String> list = info.get(startListNum);
					list.add(li.getEnd());
					info.set(startListNum, list);
					
					result.add(li);
				}else if (startListNum == endListNum) {
					continue;
				}else {
					List<String> list1 = info.get(startListNum);
					List<String> list2 = info.get(endListNum);
					
					for (String string : list2) {
						list1.add(string);
					}
					
					info.set(startListNum, list1);
					info.remove(endListNum);
					
					result.add(li);
				}
			}
			
			int sum = 0;
			for (LineInfo lineInfo : result) {
				sum += lineInfo.getDistance();
				System.out.print("(" + lineInfo.getStart() + " " + lineInfo.getEnd() + ") ");
			}
			System.out.println();
			System.out.println(sum);
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
