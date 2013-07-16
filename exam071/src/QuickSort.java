
public class QuickSort {
	public static void swap(int[] number, int x, int y) {
		int temp = number[x];
		number[x] = number[y];
		number[y] = temp;
	}
	
	public static void sort(int[] number, int left, int right) {
		if (left < right) {
			int standard = number[left];
			int i = left;
			int j = right + 1;
			
			while (true) {
				// ¦V¥k§ä 
				while(i + 1 < number.length && number[++i] < standard) ;  
				// ¦V¥ª§ä 
				while(j -1 > -1 && number[--j] > standard) ;  
				if(i >= j) 
					break; 
				swap(number, i, j);
			}
			
			number[left] = number[j];
			number[j] = standard;
			sort(number, left, j-1);
			sort(number, j+1, right);
		}
	}
	
	public static void sort (int [] number) {
		sort(number, 0, number.length-1);
	}
}
