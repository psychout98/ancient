import java.util.Scanner;
public class TempConverter {

	public static void main(String[]args){
		Scanner scanObj = new Scanner(System.in);
		double Fahrenheit = 0;
		System.out.println("Type the Farenheit temperature:");
		Fahrenheit = scanObj.nextDouble();
		double Celsius = (double)((double)((5*Fahrenheit)/9)-((double)(5*32)/9));
		System.out.println((int)Fahrenheit+ "ºF = " + Celsius + "ºC");
	}
}
