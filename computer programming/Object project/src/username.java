import java.util.Scanner;
import java.util.Random;

public class username {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Random random = new Random();
		Scanner scanObj = new Scanner(System.in);
		System.out.println("First name:");
		String f = scanObj.nextLine();
		System.out.println("Last name:");
		String l = scanObj.nextLine();
		String name = f+l;
		String password;
		System.out.println("Your have "+Math.pow(name.length(),name.length())+" new username:\n possibilities:" );
		for(int i=0;i<Math.pow(name.length(),name.length()*2);i++){
			password = ""+name.charAt(random.nextInt(name.length()))+
			name.charAt(random.nextInt(name.length()))+
			name.charAt(random.nextInt(name.length()))+
			name.charAt(random.nextInt(name.length()))+
			name.charAt(random.nextInt(name.length()))+
			name.charAt(random.nextInt(name.length()))+
			name.charAt(random.nextInt(name.length()))+
			name.charAt(random.nextInt(name.length()));
			System.out.println(password);
		}
		
	}

}
