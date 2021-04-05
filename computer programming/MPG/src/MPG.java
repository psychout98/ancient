import java.util.Scanner;
public class MPG {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanObj = new Scanner(System.in);
		double startfuel = 0;
		double miles = 0;
		double endfuel = 0;
		System.out.println("Starting fuel:");
		startfuel = scanObj.nextDouble();
		System.out.println("Miles traveled:");
		miles = scanObj.nextDouble();
		System.out.println("Ending fuel:");
		endfuel = scanObj.nextDouble();
		double MPG = miles/(startfuel-endfuel);
		System.out.println("Your MPG is about "+MPG+" miles per gallon.");
	}

}
