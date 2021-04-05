import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener {
	JButton red = new JButton(), blue = new JButton(), green = new JButton(),
			yellow = new JButton();
	Color On = new Color(204, 255, 255), redOn, blueOn, greenOn, yellowOn;
	Random rand = new Random();
	String pattern = "", mypattern = "";
	int clicks = 0;
	boolean loop = false;

	GUI() throws InterruptedException {
		super("Simon");
		this.setSize(500, 500);
		this.setVisible(true);
		this.setLayout(new GridLayout(2, 2));
		init();
		while (true) {
			Thread.sleep(2000);
			loop = false;
			clicks = 0;
			mypattern="";
			for (int i = 0; i < pattern.length(); i++)
				switch (pattern.charAt(i)) {
				case 'r':
					red.setBackground(On);
					Thread.sleep(500);
					red.setBackground(Color.RED);
					break;
				case 'b':
					blue.setBackground(On);
					Thread.sleep(500);
					blue.setBackground(Color.blue);
					break;
				case 'g':
					green.setBackground(On);
					Thread.sleep(500);
					green.setBackground(Color.green);
					break;
				case 'y':
					yellow.setBackground(On);
					Thread.sleep(500);
					yellow.setBackground(Color.yellow);
					break;
				}

			switch (rand.nextInt(4)) {
			case 0:
				red.setBackground(On);
				Thread.sleep(500);
				red.setBackground(Color.RED);
				pattern = pattern + "r";
				break;
			case 1:
				blue.setBackground(On);
				Thread.sleep(500);
				blue.setBackground(Color.blue);
				pattern = pattern + "b";
				break;
			case 2:
				green.setBackground(On);
				Thread.sleep(500);
				green.setBackground(Color.green);
				pattern = pattern + "g";
				break;
			case 3:
				yellow.setBackground(On);
				Thread.sleep(500);
				yellow.setBackground(Color.yellow);
				pattern = pattern + "y";
				break;
			}
			while (!loop) {
			}
		}

	}

	public void init() {
		red.setBackground(Color.RED);
		blue.setBackground(Color.blue);
		green.setBackground(Color.green);
		yellow.setBackground(Color.yellow);
		red.addActionListener(this);
		blue.addActionListener(this);
		green.addActionListener(this);
		yellow.addActionListener(this);
		this.add(red, BorderFactory.createLineBorder(Color.BLACK));
		this.add(blue, BorderFactory.createLineBorder(Color.BLACK));
		this.add(green, BorderFactory.createLineBorder(Color.BLACK));
		this.add(yellow, BorderFactory.createLineBorder(Color.BLACK));
	}

	public static void main(String[] args) throws InterruptedException {
		GUI window = new GUI();
		window.setDefaultCloseOperation(3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == red) {
			mypattern = mypattern + "r";
			if (pattern.contains(mypattern))
				clicks++;
			if (!pattern.contains(mypattern))
				System.exit(0);
			if (clicks == pattern.length())
				loop = true;

		}
		if (e.getSource() == blue) {
			mypattern = mypattern + "b";
			if (pattern.contains(mypattern))
				clicks++;
			if (!pattern.contains(mypattern))
				System.exit(0);
			if (clicks == pattern.length())
				loop = true;

		}
		if (e.getSource() == green) {
			mypattern = mypattern + "g";
			if (pattern.contains(mypattern))
				clicks++;
			if (!pattern.contains(mypattern))
				System.exit(0);
			if (clicks == pattern.length())
				loop = true;

		}
		if (e.getSource() == yellow) {
			mypattern = mypattern + "y";
			if (pattern.contains(mypattern))
				clicks++;
			if (!pattern.contains(mypattern))
				System.exit(0);
			if (clicks == pattern.length())
				loop = true;

		}
	}

	public boolean isSame() {
		return (pattern.contains(mypattern));
	}
}
