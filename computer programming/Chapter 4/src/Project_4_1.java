import java.util.Scanner;
public class Project_4_1 {

	
	public static void main(String[] args) {
		Scanner scanObj = new Scanner(System.in);
		System.out.println("Give a year");
		int input = scanObj.nextInt();
		if(input<1582){
			System.err.println("Error: The Gregorian Calendar was not a thing back then");
			}
		else if(input%4==0){
			if(input%100==0&&input%400!=0){
				System.out.println(input+" was not a leap year.");
			}
			if(input%100==0&&input%400==0){
				System.out.println(input+" was a leap year.");
			}
			if(input%100!=0&&input%400!=0){
				System.out.println(input+" was a leap year.");
			}
		}
		else{
			System.out.println("Not a leap year.");
		}
		
		}
		

	

}
	