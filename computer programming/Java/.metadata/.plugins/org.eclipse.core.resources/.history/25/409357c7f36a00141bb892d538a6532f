import java.awt.AWTException;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class TTT extends JFrame implements ActionListener {
	static String switcher = "";
	static boolean b = true;
	static boolean x = false;
	static boolean o = false;
	static boolean c = true;
	static boolean xx[] = new boolean[9];
	static boolean oo[] = new boolean[9];
	Random chooser = new Random();
	JPanel Box1, Box2, Box3, Box4, Box5, Box6, Box7, Box8, Box9;
	JButton Space1, player;
	JButton Space2;
	JButton Space3;
	JButton Space4;
	JButton Space5;
	JButton Space6;
	JButton Space7;
	JButton Space8;
	JButton Space9;
	static JButton X;
	static JButton O;
	static boolean player1 = false;
	static boolean player2 = false;
	static boolean t=false;
	

	public static class choice extends JFrame implements ActionListener {
		choice() {
			super("X or O?");
			init2();
			this.setSize(100, 80);
			this.setVisible(true);
		}

		public void init2() {
			JPanel panel = new JPanel(new GridLayout(1, 2));
			X = new JButton("X");
			O = new JButton("O");
			X.addActionListener(this);
			O.addActionListener(this);
			panel.add(X);
			panel.add(O);
			this.add(panel);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == X) {
				x = true;
			}
			if (e.getSource() == O) {
				o = true;
			}
		}
	}

	TTT() {
		super("Tic Tac Toe");
		init();
		this.setSize(200, 200);
		this.setVisible(true);
	}

	public void init() {
		this.setLayout(new GridLayout(3, 3));
		X = new JButton("X");
		O = new JButton("O");
		Box1 = new JPanel(new GridLayout(1, 1));
		Box2 = new JPanel(new GridLayout(1, 1));
		Box3 = new JPanel(new GridLayout(1, 1));
		Box4 = new JPanel(new GridLayout(1, 1));
		Box5 = new JPanel(new GridLayout(1, 1));
		Box6 = new JPanel(new GridLayout(1, 1));
		Box7 = new JPanel(new GridLayout(1, 1));
		Box8 = new JPanel(new GridLayout(1, 1));
		Box9 = new JPanel(new GridLayout(1, 1));
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

	public static void main(String[] args) throws InterruptedException,
			AWTException {
		boolean loop = true;
		while (loop) {
			for (int i = 0; i < 9; i++) {
				xx[i] = false;
				oo[i] = false;
			}
			choice frame = new choice();
			frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			while (b) {
				if (x) {
					b = false;
				}
				if (o) {
					b = false;
				}
				Thread.sleep(50);
			}
			frame.setVisible(false);
			TTT window = new TTT();
			window.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			while (c) {
				if ((xx[0] && xx[1] && xx[2]) || (xx[1] && xx[2] && xx[0])
						|| (xx[2] && xx[1] && xx[0])
						|| (xx[0] && xx[2] && xx[1])
						|| (xx[2] && xx[0] && xx[1])
						|| (xx[1] && xx[0] && xx[2])) {
					JOptionPane.showMessageDialog(null, "X won!");
					frame.setVisible(false);
					window.setVisible(false);
					loop = true;
					break;
				}
				if ((xx[3] && xx[4] && xx[5]) || (xx[4] && xx[5] && xx[3])
						|| (xx[5] && xx[4] && xx[3])
						|| (xx[3] && xx[5] && xx[4])
						|| (xx[5] && xx[3] && xx[4])
						|| (xx[4] && xx[3] && xx[5])) {
					JOptionPane.showMessageDialog(null, "X won!");
					frame.setVisible(false);
					window.setVisible(false);
					loop = true;
					break;
				}
				if ((xx[6] && xx[7] && xx[8]) || (xx[7] && xx[8] && xx[6])
						|| (xx[8] && xx[7] && xx[6])
						|| (xx[6] && xx[8] && xx[7])
						|| (xx[8] && xx[6] && xx[7])
						|| (xx[7] && xx[6] && xx[8])) {
					JOptionPane.showMessageDialog(null, "X won!");
					frame.setVisible(false);
					window.setVisible(false);
					loop = true;
					break;
				}
				if ((xx[0] && xx[3] && xx[6]) || (xx[3] && xx[6] && xx[0])
						|| (xx[6] && xx[3] && xx[0])
						|| (xx[0] && xx[6] && xx[3])
						|| (xx[6] && xx[0] && xx[3])
						|| (xx[3] && xx[0] && xx[6])) {
					JOptionPane.showMessageDialog(null, "X won!");
					frame.setVisible(false);
					window.setVisible(false);
					loop = true;
					break;
				}
				if ((xx[1] && xx[4] && xx[7]) || (xx[1] && xx[7] && xx[4])
						|| (xx[7] && xx[1] && xx[4])
						|| (xx[4] && xx[7] && xx[1])
						|| (xx[7] && xx[4] && xx[1])
						|| (xx[1] && xx[4] && xx[7])) {
					JOptionPane.showMessageDialog(null, "X won!");
					frame.setVisible(false);
					window.setVisible(false);
					loop = true;
					break;
				}
				if ((xx[5] && xx[8] && xx[2]) || (xx[8] && xx[2] && xx[5])
						|| (xx[2] && xx[8] && xx[5])
						|| (xx[5] && xx[2] && xx[8])
						|| (xx[2] && xx[5] && xx[8])
						|| (xx[8] && xx[5] && xx[2])) {
					JOptionPane.showMessageDialog(null, "X won!");
					frame.setVisible(false);
					window.setVisible(false);
					loop = true;
					break;
				}
				if ((xx[0] && xx[4] && xx[8]) || (xx[4] && xx[8] && xx[0])
						|| (xx[8] && xx[4] && xx[0])
						|| (xx[0] && xx[8] && xx[4])
						|| (xx[8] && xx[0] && xx[4])
						|| (xx[4] && xx[0] && xx[8])) {
					JOptionPane.showMessageDialog(null, "X won!");
					frame.setVisible(false);
					window.setVisible(false);
					loop = true;
					break;
				}
				if ((xx[6] && xx[4] && xx[2]) || (xx[4] && xx[2] && xx[6])
						|| (xx[2] && xx[4] && xx[6])
						|| (xx[6] && xx[2] && xx[4])
						|| (xx[2] && xx[6] && xx[4])
						|| (xx[4] && xx[6] && xx[2])) {
					JOptionPane.showMessageDialog(null, "X won!");
					frame.setVisible(false);
					window.setVisible(false);
					loop = true;
					break;
				}
				if ((oo[0] && oo[1] && oo[2]) || (oo[1] && oo[2] && oo[0])
						|| (oo[2] && oo[1] && oo[0])
						|| (oo[0] && oo[2] && oo[1])
						|| (oo[2] && oo[0] && oo[1])
						|| (oo[1] && oo[0] && oo[2])) {
					JOptionPane.showMessageDialog(null, "O won!");
					frame.setVisible(false);
					window.setVisible(false);
					loop = true;
					break;
				}
				if ((oo[3] && oo[4] && oo[5]) || (oo[4] && oo[5] && oo[3])
						|| (oo[5] && oo[4] && oo[3])
						|| (oo[3] && oo[5] && oo[4])
						|| (oo[5] && oo[3] && oo[4])
						|| (oo[4] && oo[3] && oo[5])) {
					JOptionPane.showMessageDialog(null, "O won!");
					frame.setVisible(false);
					window.setVisible(false);
					loop = true;
					break;
				}
				if ((oo[6] && oo[7] && oo[8]) || (oo[7] && oo[8] && oo[6])
						|| (oo[8] && oo[7] && oo[6])
						|| (oo[6] && oo[8] && oo[7])
						|| (oo[8] && oo[6] && oo[7])
						|| (oo[7] && oo[6] && oo[8])) {
					JOptionPane.showMessageDialog(null, "O won!");
					frame.setVisible(false);
					window.setVisible(false);
					loop = true;
					break;
				}
				if ((oo[0] && oo[3] && oo[6]) || (oo[3] && oo[6] && oo[0])
						|| (oo[6] && oo[3] && oo[0])
						|| (oo[0] && oo[6] && oo[3])
						|| (oo[6] && oo[0] && oo[3])
						|| (oo[3] && oo[0] && oo[6])) {
					JOptionPane.showMessageDialog(null, "O won!");
					frame.setVisible(false);
					window.setVisible(false);
					loop = true;
					break;
				}
				if ((oo[1] && oo[4] && oo[7]) || (oo[1] && oo[7] && oo[4])
						|| (oo[7] && oo[1] && oo[4])
						|| (oo[4] && oo[7] && oo[1])
						|| (oo[7] && oo[4] && oo[1])
						|| (oo[1] && oo[4] && oo[7])) {
					JOptionPane.showMessageDialog(null, "O won!");
					frame.setVisible(false);
					window.setVisible(false);
					loop = true;
					break;
				}
				if ((oo[5] && oo[8] && oo[2]) || (oo[8] && oo[2] && oo[5])
						|| (oo[2] && oo[8] && oo[5])
						|| (oo[5] && oo[2] && oo[8])
						|| (oo[2] && oo[5] && oo[8])
						|| (oo[8] && oo[5] && oo[2])) {
					JOptionPane.showMessageDialog(null, "O won!");
					frame.setVisible(false);
					window.setVisible(false);
					loop = true;
					break;
				}
				if ((oo[0] && oo[4] && oo[8]) || (oo[4] && oo[8] && oo[0])
						|| (oo[8] && oo[4] && oo[0])
						|| (oo[0] && oo[8] && oo[4])
						|| (oo[8] && oo[0] && oo[4])
						|| (oo[4] && oo[0] && oo[8])) {
					JOptionPane.showMessageDialog(null, "O won!");
					frame.setVisible(false);
					window.setVisible(false);
					loop = true;
					break;
				}
				if ((oo[6] && oo[4] && oo[2]) || (oo[4] && oo[2] && oo[6])
						|| (oo[2] && oo[4] && oo[6])
						|| (oo[6] && oo[2] && oo[4])
						|| (oo[2] && oo[6] && oo[4])
						|| (oo[4] && oo[6] && oo[2])) {
					JOptionPane.showMessageDialog(null, "O won!");
					frame.setVisible(false);
					window.setVisible(false);
					loop = true;
					break;
				}
				if((xx[0]||oo[0])&&(xx[1]||oo[1])&&(xx[2]||oo[2])&&(xx[3]||oo[3])&&(xx[4]||oo[4])&&(xx[5]||oo[5])&&(xx[6]||oo[6])&&(xx[6]||oo[6])&&(xx[7]||oo[7])&&(xx[8]||oo[8])){
					JOptionPane.showMessageDialog(null, "It's a draw!");
					frame.setVisible(false);
					window.setVisible(false);
					loop = true;
					break;
				}
			}
			while(true){
				Thread.sleep(5000);
				if(t){
					System.err.println("works");
					frame.dispose();
					window.dispose();
					t=false;
			b = true;
			x = false;
			o = false;
			c = true;
			loop = true;
				}
			}
		}
		
			
	}
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (x) {
			switcher = "X";
			player = new JButton(switcher);
		}
		if (o) {
			switcher = "O";
			player = new JButton(switcher);
		}
		if (e.getSource() == Space1) {
			player = new JButton(switcher);
			Box1.remove(Space1);
			validate();
			Box1.add(player);
			validate();
			if (switcher == "X") {
				o = true;
				x = false;
				xx[0] = true;
			}
			if (switcher == "O") {
				x = true;
				o = false;
				oo[0] = true;
			}
		}
		if (e.getSource() == Space2) {
			player = new JButton(switcher);
			Box2.remove(Space2);
			validate();
			Box2.add(player);
			validate();
			if (switcher == "X") {
				o = true;
				x = false;
				xx[1] = true;
			}
			if (switcher == "O") {
				x = true;
				o = false;
				oo[1] = true;
			}
		}
		if (e.getSource() == Space3) {
			player = new JButton(switcher);
			Box3.remove(Space3);
			validate();
			Box3.add(player);
			validate();
			if (switcher == "X") {
				o = true;
				x = false;
				xx[2] = true;
			}
			if (switcher == "O") {
				x = true;
				o = false;
				oo[2] = true;
			}
		}
		if (e.getSource() == Space4) {
			player = new JButton(switcher);
			Box4.remove(Space4);
			validate();
			Box4.add(player);
			validate();
			if (switcher == "X") {
				o = true;
				x = false;
				xx[3] = true;
			}
			if (switcher == "O") {
				x = true;
				o = false;
				oo[3] = true;
			}
		}
		if (e.getSource() == Space5) {
			player = new JButton(switcher);
			Box5.remove(Space5);
			validate();
			Box5.add(player);
			validate();
			if (switcher == "X") {
				o = true;
				x = false;
				xx[4] = true;
			}
			if (switcher == "O") {
				x = true;
				o = false;
				oo[4] = true;
			}
		}
		if (e.getSource() == Space6) {
			player = new JButton(switcher);
			Box6.remove(Space6);
			validate();
			Box6.add(player);
			validate();
			if (switcher == "X") {
				o = true;
				x = false;
				xx[5] = true;
			}
			if (switcher == "O") {
				x = true;
				o = false;
				oo[5] = true;
			}
		}
		if (e.getSource() == Space7) {
			player = new JButton(switcher);
			Box7.remove(Space7);
			validate();
			Box7.add(player);
			validate();
			if (switcher == "X") {
				o = true;
				x = false;
				xx[6] = true;
			}
			if (switcher == "O") {
				x = true;
				o = false;
				oo[6] = true;
			}
		}
		if (e.getSource() == Space8) {
			player = new JButton(switcher);
			Box8.remove(Space8);
			validate();
			Box8.add(player);
			validate();
			if (switcher == "X") {
				o = true;
				x = false;
				xx[7] = true;
			}
			if (switcher == "O") {
				x = true;
				o = false;
				oo[7] = true;
			}
		}
		if (e.getSource() == Space9) {
			player = new JButton(switcher);
			Box9.remove(Space9);
			validate();
			Box9.add(player);
			validate();
			if (switcher == "X") {
				xx[8] = true;
				o = true;
				x = false;
			}
			if (switcher == "O") {
				x = true;
				o = false;
				oo[8] = true;
			}
		}

		while(true){
			if(e.getSource()!= e.getSource()){
				t=true;
			}
		}

	}
	public class players extends JFrame implements ActionListener {
		JButton play2;
		JButton play1;
		players() {
			super("How many players?");
			init3();
			this.setSize(300, 200);
			this.setVisible(true);
		}
		public void init3() {
			JPanel panel1 = new JPanel(new GridLayout(1, 2));
			play1 = new JButton("1");
			play1.addActionListener(this);
			play2 = new JButton("2");
			panel1.add(play1);
			panel1.add(play2);
			this.add(panel1);
			play2.addActionListener(this);
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == play2) {
				player2 = true;
				player1 = false;
			}
			if (arg0.getSource() == play1) {
				player1 = true;
				player1 = false;
			}
		}
	}
}
