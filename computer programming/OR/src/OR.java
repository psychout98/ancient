import java.util.Scanner;

import javax.swing.JOptionPane;
public class OR {


	public static void main(String[] args) {
		boolean loop=true;
		while(loop){
		Scanner scanObj = new Scanner(System.in);
		String s =JOptionPane.showInputDialog("How many shots have you done?");
		int input = scanObj.nextInt();
		if(s=="7" || s=="42"){
			System.out.println("YOU'RE DRUNK!!!");
		}
		if(input!=7&&input!=42){
			System.out.println("You are unfortunately sober.");
		}
		loop=true;
		}
	}

}
