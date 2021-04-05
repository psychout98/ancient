import java.util.*;
public class SnowDay {
public static void main(String[]args){
	Scanner scanObj = new Scanner(System.in);
	System.out.println("Was it snow or ice?");
	String input = scanObj.nextLine();
	if(input.toLowerCase().startsWith("s")){
		System.out.println("How many inches of snow?");
		double input1=scanObj.nextInt();
		if(input1<2){
			System.out.println("School opens on time");
		}
		if(input1>=2.1&&input1<4){
			System.out.println("School will have a two hour delay");
		}
		if(input1>=4){
			System.out.println("School is closed");
		}
	}
	if(input.toLowerCase().startsWith("i")){
		System.out.println("How many inches of ice?");
		double input1=scanObj.nextDouble();
		if(input1<.04){
			System.out.println("School opens on time");
		}
		if(input1>=.05&&input1<.1){
			System.out.println("School will have a two hour delay");
		}
		if(input1>=.1){
			System.out.println("School is closed");
		}
	}
}
}
