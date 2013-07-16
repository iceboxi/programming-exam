import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class exam003 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			int caseNum = Integer.parseInt(br.readLine().split(" ")[0]);
			int [][] cases = new int [caseNum][2];
			String [] temp = br.readLine().split(" ");
			for (int i = 0, j =0; i < caseNum; i++) {
				cases[i][0] = Integer.parseInt(temp[j++]);
				cases[i][1] = Integer.parseInt(temp[j++]);
			}
			
			List<Car> cars = new ArrayList<Car>();
			for (int i = 0; i < caseNum; i++) {
				boolean isHaveIdleCar = false;
				for (Car car : cars) {
					if (car.getEndTime() <= cases[i][0]) {
						car.setStartTime(cases[i][0]);
						car.setEndTime(cases[i][1]);
						isHaveIdleCar = true;
						break;
					}
				}
				
				if (!isHaveIdleCar) {
					Car car = new Car();
					car.setStartTime(cases[i][0]);
					car.setEndTime(cases[i][1]);
					cars.add(car);
				}
			}
			
			System.out.println("need " + cars.size() + " cars");
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
