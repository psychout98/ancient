import java.util.Scanner;
public class roots {
	public static void main(String[] args) {
		Scanner scanObj = new Scanner(System.in);
		System.out.println("Give us a number");
		int n = scanObj.nextInt();
		for (int i = 2; i < 11; i++) {
		System.out.println("To the "+i+" power: "+Math.pow(n, i));
		}}}
