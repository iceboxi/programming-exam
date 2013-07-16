
public class QuickSort {
	public static void sort(int[] number) {
		sort(number, 0, number.length-1);
	}

	private static void sort(int[] number, int left, int right) {
		if(left < right) { 
			int s = number[left]; 
			int i = left; 
			int j = right + 1; 
			while(true) { 
				// �V�k�� 
				while(i + 1 < number.length && number[++i] < s) ;  
				// �V���� 
				while(j -1 > -1 && number[--j] > s) ;  
				if(i >= j) 
					break; 
				swap(number, i, j); 
			} 
			number[left] = number[j]; 
			number[j] = s; 
			sort(number, left, j-1);   // �索��i�滼�j 
			sort(number, j+1, right);  // ��k��i�滼�j 
		}
	}

	private static void swap(int[] number, int i, int j) {
		int t; 
		t = number[i]; 
		number[i] = number[j]; 
		number[j] = t;
	}
}
