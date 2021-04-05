import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Poker extends JFrame implements ActionListener {
	static String card[][] = new String[13][4], a[] = { "Ace", "2", "3", "4",
			"5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" }, b[] = {
			" of Spades", " of Clubs", " of Diamonds", " of Hearts" },
			hand[] = new String[5];
	static boolean Card[][] = new boolean[13][4], pair = false,
			twopair = false, tok = false, fok = false;
	JPanel Hand1;
	JLabel visual;
	Poker() {
		super("Poker");
		this.setSize(800, 600);
		this.setVisible(true);
		init();
	}

	public void init() {
		Hand1 = new hand1();
		this.add(Hand1, BorderLayout.CENTER);
	}

	public static void main(String[] args) throws InterruptedException {
		Random rand = new Random();
		for (int i = 0; i < 13; i++)
			for (int j = 0; j < 4; j++)
				card[i][j] = a[i] + b[j];
		for (int i = 0; i < 5; i++) {
			hand[i] = card[rand.nextInt(13)][rand.nextInt(4)];
			for (int j = 0; j < 13; j++)
				for (int k = 0; k < 4; k++)
					if (hand[i] == card[j][k])
						Card[j][k] = false;
			if (i > 0)
				for (int j = 0; j < i; j++)
					if (hand[i] == hand[j])
						i--;
		}
		System.out.println(hand[0] + "\n" + hand[1] + "\n" + hand[2] + "\n"
				+ hand[3] + "\n" + hand[4]);

		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				for (int k = 0; k < 13; k++) {
					if (hand[i].contains(a[k]) && hand[j].contains(a[k])
							&& pair) {
						twopair = true;
						pair = false;
						break;
					}
					if (hand[i].contains(a[k]) && hand[j].contains(a[k])) {
						pair = true;
						break;
					}
				}
			}
		}
		for (int i = 2; i < 5; i++) {
			for (int j = 1; j < i; j++) {
				for (int k = 0; k < j; k++) {
					for (int l = 0; l < 13; l++) {
						if (hand[i].contains(a[l]) && hand[j].contains(a[l])
								&& hand[k].contains(a[l]) && twopair) {
							tok = true;
							twopair = false;
							pair = false;
							break;
						}
					}
				}
			}
		}

		if (fok)
			System.out.println("Four of a kind");
		if (tok)
			System.out.println("Three of a kind");
		if (twopair)
			System.out.println("Two pair");
		if (pair)
			System.out.println("Pair");
		Thread.sleep(5000);
		Poker window = new Poker();
		window.setDefaultCloseOperation(3);

	}

	private class hand1 extends JPanel {
		public void paintComponent(Graphics p) {
			int Card = 0;
			for (int j = 0; j < 13; j++)
				for (int k = 0; k < 4; k++)
					if (hand[0].contains(a[j]) && hand[0].contains(b[k]))
						Card = (j + 1) * (k + 1);
			File finalcard=null;
			switch (Card) {
			case 1:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\ace of spades.jpg");
			case 2:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\ace of clubs.jpg");
			case 3:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\ace of Diamonds.jpg");
			case 4:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\ace of hearts.jpg");
			case 5:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\two of spades.jpg");
			case 6:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\two of clubs.jpg");
			case 7:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\two of diamonds.jpg");
			case 8:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\two of hearts.jpg");
			case 9:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\three of spades.jpg");
			case 10:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\three of clubs.jpg");
			case 11:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\three of diamonds.jpg");
			case 12:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\three of hearts.jpg");
			case 13:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\four of spades.jpg");
			case 14:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\four of clubs.jpg");
			case 15:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\four of diamonds.jpg");
			case 16:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\four of hearts.jpg");
			case 17:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\five of spades.jpg");
			case 18:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\five of clubs.jpg");
			case 19:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\five of diamonds.jpg");
			case 20:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\five of hearts.jpg");
			case 21:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\six of spades.jpg");
			case 22:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\six of clubs.jpg");
			case 23:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\six of diamonds.jpg");
			case 24:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\six of hearts.jpg");
			case 25:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\seven of spades.jpg");
			case 26:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\seven of clubs.jpg");
			case 27:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\seven of diamonds.jpg");
			case 28:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\seven of hearts.jpg");
			case 29:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\eight of spades.jpg");
			case 30:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\eight of clubs.jpg");
			case 31:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\eight of diamonds.jpg");
			case 32:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\eight of hearts.jpg");
			case 33:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\nine of spades.jpg");
			case 34:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\nine of clubs.jpg");
			case 35:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\nine of diamonds.jpg");
			case 36:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\nine of hearts.jpg");
			case 37:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\ten of spades.jpg");
			case 38:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\ten of clubs.jpg");
			case 39:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\ten of diamonds.jpg");
			case 40:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\ten of hearts.jpg");
			case 41:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\jack of spades.jpg");
			case 42:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\jack of clubs.jpg");
			case 43:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\jack of diamonds.jpg");
			case 44:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\jack of hearts.jpg");
			case 45:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\queen of spades.jpg");
			case 46:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\queen of clubs.jpg");
			case 47:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\queen of diamonds.jpg");
			case 48:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\queen of hearts.jpg");
			case 49:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\king of spades.jpg");
			case 50:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\king of clubs.jpg");
			case 51:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\king of diamonds.jpg");
			case 52:
				finalcard = new File(
						"F:\\computer programming\\Poker\\src\\king of hearts.jpg");
			}
			BufferedImage cardImage=null;
			try {
				cardImage= ImageIO.read(finalcard);
			} catch (IOException e) {
				e.printStackTrace();
			}
			visual=new JLabel(new ImageIcon(cardImage));
			add(visual, BorderLayout.WEST);
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
