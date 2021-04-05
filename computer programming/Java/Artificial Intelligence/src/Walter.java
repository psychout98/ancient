import java.util.Scanner;

public class Walter {
	
	public static void main(String[] args) throws InterruptedException{
		Scanner scan = new Scanner(System.in);
		System.out.println("Hello");
		while(true){
			String Input = scan.nextLine();
			Interpret input = new Interpret(Input);
			Respond response = new Respond(input.interpretedMessage);
		}

	}

}
