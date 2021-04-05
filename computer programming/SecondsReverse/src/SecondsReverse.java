import java.util.Scanner;
public class SecondsReverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanObj = new Scanner(System.in);
		int total = 0;
		int seconds = 0;
		int hours = 0;
		int minutes = 0;
		System.out.println("Seconds:");
		total = scanObj.nextInt();
		seconds = total%60;
		minutes = ((total-seconds)/60)%60;
		hours = ((total-seconds)/60-minutes)/60;
		System.out.println(hours + " Hours, " + minutes +" Minutes, and " +seconds+ " Seconds");
	}

}
