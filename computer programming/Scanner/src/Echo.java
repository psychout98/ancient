import java.util.Scanner;
public class Echo {
public static void main(String[]args) throws InterruptedException{
	Scanner scanObj = new Scanner(System.in);
	Boolean loop = true;
	System.out.println("Hi");
	while(loop){
	String input = "";
	input = scanObj.nextLine();
	if(input.contains("bye")){
		System.out.println("Bye");
		loop = false;
	}
	else{

		System.out.println("Why?");
		Thread.sleep(500);
	loop = true;
	}
	}
}
}
