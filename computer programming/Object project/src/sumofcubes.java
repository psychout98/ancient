import java.util.Scanner;


public class sumofcubes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanObj = new Scanner (System.in);
		System.out.println("Both numbers must be less than 232");
		System.out.println("First number:");
		int f = scanObj.nextInt();
		System.out.println("Second number:");
		int s = scanObj.nextInt();
		int sum = f + s;
		System.out.println("Sum:\n"+sum);
		System.out.println("Sum Cubed:\n"+(Math.pow(sum, 3)));
	}

}
