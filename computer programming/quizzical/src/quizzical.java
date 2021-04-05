import java.util.Scanner;
public class quizzical {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "";
		Scanner scanOBJ = new Scanner(System.in);
		System.out.println("If quizzes are quizzical," + "\n" + "What are tests?");
		input = scanOBJ.nextLine();
		if(input.contains("testicles")){
			System.out.println("EXCUSE ME!!!!!!!!!!!!!??????????");
		}
		else{
			System.out.println("no");
		}
	}

}
