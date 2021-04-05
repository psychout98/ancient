import java.util.Scanner;
public class Coins {
public static void main(String[] args){
	Scanner scanObj = new Scanner(System.in);
	int quarters = 0;
	int dimes = 0;
	int nickels = 0;
	int pennies = 0;
	System.out.println("Quarters:");
	quarters = scanObj.nextInt();
	System.out.println("Dimes:");
	dimes = scanObj.nextInt();
	System.out.println("Nickels:");
	nickels = scanObj.nextInt();
	System.out.println("Pennies:");
	pennies = scanObj.nextInt();
	double coins = .01*pennies + .05*nickels + .1*dimes + .25*quarters;
	System.out.println("$" + coins);
}
}
