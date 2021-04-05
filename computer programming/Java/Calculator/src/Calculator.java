import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Calculator extends JFrame implements ActionListener {

	String Number = "";
	boolean operated = false;
	JButton plus, minus, times, divide, decimal, neg, enter, clear;
	JButton number[] = new JButton[10];
	JTextPane screen = new JTextPane();
	static String operator;
	String outcome;
	double num, num1;

	Calculator() {
		super("Calculator");
		init();
		this.setSize(200, 300);
		this.setVisible(true);
	}
	
	public void init() {
		JPanel Screen = new JPanel(new GridLayout(1,1));
		JPanel numpad =	new JPanel(new GridLayout(4, 3));
		JPanel operate = new JPanel(new GridLayout(6, 1));
		screen.setEditable(false);
		Font f = new Font("Times New Roman", Font.BOLD, 15);
		screen.setFont(f);
		number[1] = new JButton("1");
		number[2] = new JButton("2");
		number[3] = new JButton("3");
		number[4] = new JButton("4");
		number[5] = new JButton("5");
		number[6] = new JButton("6");
		number[7] = new JButton("7");
		number[8] = new JButton("8");
		number[9] = new JButton("9");
		number[0] = new JButton("0");
		plus = new JButton("+");
		minus = new JButton("--");
		times = new JButton("x");
		divide = new JButton("/");
		decimal = new JButton(".");
		neg = new JButton("(-)");
		enter = new JButton("ENTER");
		clear = new JButton("Clear");
		number[1].addActionListener(this);
		number[2].addActionListener(this);
		number[3].addActionListener(this);
		number[4].addActionListener(this);
		number[5].addActionListener(this);
		number[6].addActionListener(this);
		number[7].addActionListener(this);
		number[8].addActionListener(this);
		number[9].addActionListener(this);
		number[0].addActionListener(this);
		plus.addActionListener(this);
		minus.addActionListener(this);
		times.addActionListener(this);
		divide.addActionListener(this);
		neg.addActionListener(this);
		enter.addActionListener(this);
		clear.addActionListener(this);
		decimal.addActionListener(this);
		Screen.add(screen);
		numpad.add(number[7]);
		numpad.add(number[8]);
		numpad.add(number[9]);
		numpad.add(number[4]);
		numpad.add(number[5]);
		numpad.add(number[6]);
		numpad.add(number[1]);
		numpad.add(number[2]);
		numpad.add(number[3]);
		numpad.add(number[0]);
		numpad.add(neg);
		numpad.add(decimal);
		operate.add(clear);
		operate.add(divide);
		operate.add(times);
		operate.add(minus);
		operate.add(plus);
		operate.add(enter);
		this.add(numpad, BorderLayout.CENTER);
		this.add(operate, BorderLayout.EAST);
		this.add(Screen, BorderLayout.NORTH);

	}

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<10;i++)
			if(e.getSource() == number[i])
				Number+=""+i;
		if(e.getSource() == decimal)
				Number+=".";
		screen.setText(Number);
		if(e.getSource() == plus){
			operated = true;
			num = Double.parseDouble(Number);
			operator="+";
			Number = "";
			screen.setText("");
		}
		if(e.getSource() == minus){
			operated = true;
			num = Double.parseDouble(Number);
			operator="-";
			Number = "";
			screen.setText("");
		}
		if(e.getSource() == times){
			operated = true;
			num = Double.parseDouble(Number);
			operator="*";
			Number = "";
			screen.setText("");
		}
		if(e.getSource() == divide){
			operated = true;
			num = Double.parseDouble(Number);
			operator="/";
			Number = "";
			screen.setText("");
		}
		if(e.getSource() == enter && operated){
			num1 = Double.parseDouble(Number);
			Number = "";
			screen.setText(""+Outcome(num,num1));
			operated = false;
		}
			
			
	}
	
	public double Outcome(double num, double num1){
		double result=0;
		if(operator.contains("+"))
			result=num+num1;
		if(operator.contains("-"))
			result=num-num1;
		if(operator.contains("*"))
			result=num*num1;
		if(operator.contains("/"))
			result=num/num1;
		return result;
	}

}
