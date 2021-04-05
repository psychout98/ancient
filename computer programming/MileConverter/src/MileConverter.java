import java.util.Scanner;
public class MileConverter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanObj = new Scanner(System.in);
		float Miles = 0f;
		System.out.println("Type the number of miles:");
		Miles = scanObj.nextFloat();
		float Kilometers = (float)(1.60935*Miles);
		System.out.println(Miles + " Miles = " + Kilometers + " Kilometers");
	}

}
