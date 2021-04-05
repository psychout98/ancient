import java.util.Scanner;
public class Project_4_2 {

	
	public static void main(String[] args) {
		Scanner scanObj = new Scanner(System.in);
		System.out.println("How many years do you want to check?");
		int input1=scanObj.nextInt();
		int input[]=new int[input1];
		System.out.println("Give "+input1+" years");
		for(int i=0;i<input1;i++){
		input[i] = scanObj.nextInt();
		}
		for(int i=0;i<input1;i++){
		if(input[i]<1582){
			System.err.println("Error: The Gregorian Calendar was not a thing back then");
			break;
		}
		else if(input[i]%4==0){
			if(input[i]%100==0&&input[i]%400!=0){
				System.out.println(input[i]+" was not a leap year.");
			}
			if(input[i]%100==0&&input[i]%400==0){
				System.out.println(input[i]+" was a leap year.");
			}
			if(input[i]%100!=0&&input[i]%400!=0){
				System.out.println(input[i]+" was a leap year.");
			}
		}
		else{
			System.out.println(input[i]+" was not a leap year.");
		}
		
		}}

}
