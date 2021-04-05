import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class TTT extends JFrame implements ActionListener{
	static boolean b = false;
	Random chooser = new Random();
	JPanel Box1,Box2,Box3,Box4,Box5,Box6,Box7,Box8,Box9;
	JButton Space1,Space2,Space3,Space4,Space5,Space6,Space7,Space8,Space9;
	JButton X,O;
	public static class choice extends JFrame{
		choice(){
		super("X or O?");
		init2();
		this.setSize(300,400);
		this.setVisible(true);
		}
		public void init2(){
			
		}
	}
	
	TTT(){
		super("Tic Tac Toe");
		init();
		this.setSize(300,300);
		this.setVisible(true);
	}
	public void init(){
		this.setLayout(new GridLayout(3,3));
		Box1 = new JPanel(new GridLayout(1,1));
		Box2 = new JPanel(new GridLayout(1,1));
		Box3 = new JPanel(new GridLayout(1,1));
		Box4 = new JPanel(new GridLayout(1,1));
		Box5 = new JPanel(new GridLayout(1,1));
		Box6 = new JPanel(new GridLayout(1,1));
		Box7 = new JPanel(new GridLayout(1,1));
		Box8 = new JPanel(new GridLayout(1,1));
		Box9 = new JPanel(new GridLayout(1,1));
		Space1 = new JButton();
		Space1.addActionListener(this);
		Space2 = new JButton();
		Space2.addActionListener(this);
		Space3 = new JButton();
		Space3.addActionListener(this);
		Space4 = new JButton();
		Space4.addActionListener(this);
		Space5 = new JButton();
		Space5.addActionListener(this);
		Space6 = new JButton();
		Space6.addActionListener(this);
		Space7 = new JButton();
		Space7.addActionListener(this);
		Space8 = new JButton();
		Space8.addActionListener(this);
		Space9 = new JButton();
		Space9.addActionListener(this);
		Box1.add(Space1);
		Box2.add(Space2);
		Box3.add(Space3);
		Box4.add(Space4);
		Box5.add(Space5);
		Box6.add(Space6);
		Box7.add(Space7);
		Box8.add(Space8);
		Box9.add(Space9);
		this.add(Box1);
		this.add(Box2);
		this.add(Box3);
		this.add(Box4);
		this.add(Box5);
		this.add(Box6);
		this.add(Box7);
		this.add(Box8);
		this.add(Box9);
	}
	
	public static void main(String[] args){
	
	TTT window = new TTT();
	window.setDefaultCloseOperation(3);
}

@Override
public void actionPerformed(ActionEvent e) {
	for(int i=0; i<9;i++){
		if(e.getSource() == Space1){
			Box1.remove(Space1);
		}
	}
	
}
}
