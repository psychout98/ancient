import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Pi extends JFrame{
	static char input;
	static boolean key=false;
	static JTextPane field = new JTextPane();
	Pi(){
		super("Pi");
		this.setSize(1000,600);
		this.setVisible(true);
		this.add(field);
	}
	public static void main(String[] args) throws AWTException, InterruptedException {
		Pi window = new Pi();
		window.setDefaultCloseOperation(3);
		Robot r = new Robot();
		Scanner scan = new Scanner(System.in);
		String FULLPI = "3.14159265358979323846264338327950288419716939937510582097494459230781640628620899862803482534211706798214808651328230664709384460955058223172535940812848111745028410270193852110555964462294895493038196442881097566593344612847",pi = FULLPI ;
		while(true){
			if(field.getText().length()==pi.length())
				for(int j=0;j<field.getText().length();j++)
					field.setText("");
		for (int i = 0; i < field.getText().length(); i++) {
			if(field.getText().charAt(i)!=pi.charAt(i)){
				field.setText("");
			i=0;
			}
			}
		Thread.sleep(1);
	}
	}

}
