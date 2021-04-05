import java.util.Scanner;
public class Seconds {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanObj = new Scanner(System.in);
		int Hours = 0;
		int Minutes = 0;
		int Seconds = 0;
		System.out.println("Type the duration:\nHours:");
		Hours = scanObj.nextInt();
		System.out.println("Minutes:");
		Minutes = scanObj.nextInt();
		System.out.println("Seconds:");
		Seconds = scanObj.nextInt();
		int total = (3600*Hours)+(60*Minutes)+Seconds;
		System.out.println(Hours + " Hours " + Minutes + " Minutes and " + Seconds + " Seconds is equivalent to:\n" + total + " Seconds");
	}

}
