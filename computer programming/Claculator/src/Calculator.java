import java.awt.BorderLayout;

import java.awt.Container;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import

java.awt.event.ComponentListener;

import

java.awt.event.ContainerListener;

import

javax.swing.JButton;

import javax.swing.JOptionPane;

import

javax.swing.JFrame;

import

javax.swing.JPanel;

import

javax.swing.JTextArea;

import

javax.swing.JTextField;

public class Calculator 
//extends JFrame implements ActionListener 
{
/*
	JButton plus, minus,
			times, divide, decimal, neg, enter, clear;
JButton number[] = new JButton[10];
	int digit[] = new int[10];

	String operator;

	double outcome;

	int length;

	double num;

	double num1;

	Calculator() {

		super("Calculator");

		init();

		this.setSize(400, 600);

		this.setVisible(true);

	}

	public void init() {

		JPanel numpad =

		new JPanel(new GridLayout(4, 3));

		JPanel operate =

		new JPanel(new GridLayout(6, 1));

		number[1] = new JButton("1");

		number[2]= new JButton("2");

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

		numpad.add(
				number[7]);

		numpad.add(

				number[8]);

		numpad.add(

				number[9]);

		numpad.add(

				number[4]);

		numpad.add(

				number[5]);

		numpad.add(

				number[6]);

		numpad.add(

				number[1]);

		numpad.add(

				number[2]);

		numpad.add(

				number[3]);

		numpad.add(

				number[0]);

		numpad.add(

		decimal);

		numpad.add(

		neg);

		operate.add(

		clear);

		operate.add(

		divide);

		operate.add(

		times);

		operate.add(

		minus);

		operate.add(

		plus);

		operate.add(

		enter);

		this.add(numpad, BorderLayout.CENTER);

		this.add(operate, BorderLayout.EAST);

	}
*/
	public static void main(String[] args) {
		//Calculator calc = new Calculator();
		//calc.setDefaultCloseOperation(EXIT_ON_CLOSE);
		int length = 0;
		int digit[]=new int[10];
		int num1=0;
		int num2=0;
		String number2 = "";
		String equation = JOptionPane.showInputDialog("Calculator");
		for(int i=0; i<equation.length(); i++){
			if(equation.charAt(i) == '+'||equation.charAt(i) == '-'||equation.charAt(i) == 'x'||equation.charAt(i) == '/'){
				char num1digit[] = new char[i];
				break;
				for(int j=0;j<i;j--){
					for (int k=0;k<i;k++){
				num1digit[k]=equation.charAt(j);
			}}}
		}
		for(int i=0;i<number1.length();i++){
			for(int j=0;j<10;j++){
			if(number1.charAt(i) == j){
				digit[i] = j;
			}
			}
			length = i;
		}
			for(int x=length;x>0;x--){
				for (int i=0;i<length;i++){
			num1 = (int) ((digit[i]*(Math.pow(10, x)))+num1);
		}}
		
		
		
		
		
		
		
		
		for(int i=0; i<equation.length(); i++){
			if(equation.charAt(i) == '+'){
				int solution = num1+num2;
			}
			if(equation.charAt(i) == '-'){
				int solution = num1-num2;
			}
			if(equation.charAt(i) == 'x'){
				int solution = num1*num2;
			}
			if(equation.charAt(i) == '/'){
				int solution = num1/num2;
			}
		}
	}
/*
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<20;i++){
			for(int j=0;j<10;j++){
		while(e.getSource() == number[j]){
			digit[i] = j;
		}
		for(int x=0;x<i;i--){
		if(e.getSource() == plus){
			num=(digit[i]*(Math.pow(10, x)));
		}
		}
		}
	}
		JOptionPane.showMessageDialog(null, num);
		}
*/
}
