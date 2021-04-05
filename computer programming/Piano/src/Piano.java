import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Piano extends JFrame implements ActionListener, KeyListener {
	//12 keys starting with c
	static boolean Play = false;
	static int scale=4;
	JButton C = new JButton(), D = new JButton(), E = new JButton(),
			F = new JButton(), G = new JButton(), A = new JButton(),
			B = new JButton(), CD = new JButton(), DE = new JButton(),
			FG = new JButton(), GA = new JButton(), AB = new JButton();
	JTextField keyplay = new JTextField(0);
	Piano() {
		super("Piano");
		this.setSize(600, 400);
		this.setVisible(true);
		this.setLayout(new GridLayout(2, 1));
		init();
	}

	public void init() {
		JPanel top = new JPanel(new GridLayout(1, 12)), bottom = new JPanel(
				new GridLayout(1, 7)), space[] = { new JPanel(), new JPanel(),
				new JPanel(), new JPanel(), new JPanel(), new JPanel()};
		C.setBackground(Color.white);
		D.setBackground(Color.white);
		E.setBackground(Color.white);
		F.setBackground(Color.white);
		G.setBackground(Color.white);
		A.setBackground(Color.white);
		B.setBackground(Color.white);
		CD.setBackground(Color.black);
		DE.setBackground(Color.black);
		FG.setBackground(Color.black);
		GA.setBackground(Color.black);
		AB.setBackground(Color.black);
		C.addActionListener(this);
		D.addActionListener(this);
		E.addActionListener(this);
		F.addActionListener(this);
		G.addActionListener(this);
		A.addActionListener(this);
		B.addActionListener(this);
		CD.addActionListener(this);
		DE.addActionListener(this);
		FG.addActionListener(this);
		GA.addActionListener(this);
		AB.addActionListener(this);
		keyplay.addKeyListener(this);
		keyplay.setEditable(false);
		top.add(space[0]);
		top.add(CD);
		top.add(space[1]);
		top.add(DE);
		top.add(space[2]);
		top.add(space[3]);
		top.add(FG);
		top.add(space[4]);
		top.add(GA);
		top.add(space[5]);
		top.add(AB);
		top.add(keyplay);
		bottom.add(C);
		bottom.add(D);
		bottom.add(E);
		bottom.add(F);
		bottom.add(G);
		bottom.add(A);
		bottom.add(B);
		this.add(top);
		this.add(bottom);
	}

	public static void main(String[] args) {
		Piano window = new Piano();
		window.setDefaultCloseOperation(3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==C)
			play(1);
		if(e.getSource()==CD)
			play(2);
		if(e.getSource()==D)
			play(3);
		if(e.getSource()==DE)
			play(4);
		if(e.getSource()==E)
			play(5);
		if(e.getSource()==F)
			play(6);
		if(e.getSource()==FG)
			play(7);
		if(e.getSource()==G)
			play(8);
		if(e.getSource()==GA)
			play(9);
		if(e.getSource()==A)
			play(10);
		if(e.getSource()==AB)
			play(11);
		if(e.getSource()==B)
			play(12);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_Z)
			play(1);
		if(e.getKeyCode()==KeyEvent.VK_S)
			play(2);
		if(e.getKeyCode()==KeyEvent.VK_X)
			play(3);
		if(e.getKeyCode()==KeyEvent.VK_D)
			play(4);
		if(e.getKeyCode()==KeyEvent.VK_C)
			play(5);
		if(e.getKeyCode()==KeyEvent.VK_V)
			play(6);
		if(e.getKeyCode()==KeyEvent.VK_G)
			play(7);
		if(e.getKeyCode()==KeyEvent.VK_B)
			play(8);
		if(e.getKeyCode()==KeyEvent.VK_H)
			play(9);
		if(e.getKeyCode()==KeyEvent.VK_N)
			play(10);
		if(e.getKeyCode()==KeyEvent.VK_J)
			play(11);
		if(e.getKeyCode()==KeyEvent.VK_M)
			play(12);
		if(e.getKeyCode()==KeyEvent.VK_1)
			scale = 1;
		if(e.getKeyCode()==KeyEvent.VK_2)
			scale = 2;
		if(e.getKeyCode()==KeyEvent.VK_3)
			scale = 3;
		if(e.getKeyCode()==KeyEvent.VK_4)
			scale = 4;
		if(e.getKeyCode()==KeyEvent.VK_5)
			scale = 5;
		if(e.getKeyCode()==KeyEvent.VK_6)
			scale = 6;
		if(e.getKeyCode()==KeyEvent.VK_7)
			scale = 7;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==e.getKeyCode()){
			C.setBackground(Color.white);
			D.setBackground(Color.white);
			E.setBackground(Color.white);
			F.setBackground(Color.white);
			G.setBackground(Color.white);
			A.setBackground(Color.white);
			B.setBackground(Color.white);
			CD.setBackground(Color.black);
			DE.setBackground(Color.black);
			FG.setBackground(Color.black);
			GA.setBackground(Color.black);
			AB.setBackground(Color.black);
			Play=false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
	
	public void play(int Key){
		switch(Key){
		case 1:
			C.setBackground(Color.gray);
			playSound("C\t::\t"+scale);
			break;
		case 2:
			CD.setBackground(Color.gray);
			playSound("C Sharp/D Flat\t::\t"+scale);
			break;
		case 3:
			D.setBackground(Color.gray);
			playSound("D\t::\t"+scale);
			break;
		case 4:
			DE.setBackground(Color.gray);
			playSound("D Sharp/E Flat\t::\t"+scale);
			break;
		case 5:
			E.setBackground(Color.gray);
			playSound("E\t::\t"+scale);
			break;
		case 6:
			F.setBackground(Color.gray);
			playSound("F\t::\t"+scale);
			break;
		case 7:
			FG.setBackground(Color.gray);
			playSound("F Sharp/G Flat\t::\t"+scale);
			break;
		case 8:
			G.setBackground(Color.gray);
			playSound("G\t::\t"+scale);
			break;
		case 9:
			GA.setBackground(Color.gray);
			playSound("G Sharp/A Flat\t::\t"+scale);
			break;
		case 10:
			A.setBackground(Color.gray);
			playSound("A\t::\t"+scale);
			break;
		case 11:
			AB.setBackground(Color.gray);
			playSound("A Sharp/B Flat\t::\t"+scale);
			break;
		case 12:
			B.setBackground(Color.gray);
			playSound("B\t::\t"+scale);
			break;
		}
	}
	public static synchronized void playSound(final String url) {
		  new Thread(new Runnable() {
		    public void run() {
		      try {
		        Clip clip = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		          Piano.class.getResourceAsStream("/path/to/sounds/" + url));
		        clip.open(inputStream);
		        clip.start(); 
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    }
		  }).start();
		}
}
