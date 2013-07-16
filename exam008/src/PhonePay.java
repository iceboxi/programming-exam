
public class PhonePay {
	private static final int [] monthPay = {186, 386, 586, 986};
	private static final double [] secPay = {0.09, 0.08, 0.07, 0.06};
	private static final double [] minSaleOff = {0.9, 0.8, 0.7, 0.6};
	private static final double [] maxSaleOff = {0.8, 0.7, 0.6, 0.5};
	
	public static double howMuch(int pay, int sec) {
		int choice = 0;
		for (int i = 0; i < monthPay.length; i++) {
			if (pay == monthPay[i]) {
				choice = i;
			}
		}
		
		double needToPay = sec * secPay[choice];
		
		if (needToPay > monthPay[choice] * 2) {
			return needToPay * maxSaleOff[choice];
		}else if (needToPay > monthPay[choice]) {
			return needToPay * minSaleOff[choice];
		}else {
			return needToPay;
		}
	}
}
