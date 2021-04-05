import java.awt.event.*;
import javax.swing.*;


public class Age extends JFrame implements ActionListener{
	JTextField day,month,year;
	JLabel totalAge,seconds,minutes,hours,days,months,years;
	int Today;
	Age(){
		super("Age");
		this.setSize(500,500);
		this.setVisible(true);
		init();
	}
	public void init(){
		
	}
	public static void main(String[] args){
		Age window = new Age();
		window.setDefaultCloseOperation(3);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
