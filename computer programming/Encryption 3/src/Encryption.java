import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;

public class Encryption extends JFrame implements ActionListener,
		WindowListener {
	static JTextPane text, password, Encrypted, Message, Legend;
	JButton start = new JButton("Restart time");
	static boolean Start = false;
	static String indexChar[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i",
			"j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
			"w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"0", " ", "~", "`", "!", "@", "#", "$", "%", "^", "&", "*", "(",
			")", "-", "_", "+", "=", "{", "[", "}", "]", "|", ":", ";", "'",
			"<", ",", ">", ".", "?", "/" }, indexNum[] = { "00", "01", "02",
			"03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13",
			"14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
			"25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35",
			"36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
			"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57",
			"58", "59", "60", "61", "62", "63", "64", "65", "66" },
			encryptedIndex[] = new String[indexChar.length],
			legend[] = new String[indexChar.length], message,
			encryptedMessage = "";
	static Random rand = new Random();
	static boolean numUsed[] = new boolean[indexChar.length], restart = false;

	Encryption() throws InterruptedException {
		this.setDefaultCloseOperation(3);
		JPanel panel1 = new JPanel(new GridLayout(1, 2)), panel2 = new JPanel(
				new GridLayout(3, 1));
		text = new JTextPane();
		password = new JTextPane();
		text.setBorder(BorderFactory.createLineBorder(Color.black));
		password.setBorder(BorderFactory.createLineBorder(Color.black));
		Encrypted = new JTextPane();
		Message = new JTextPane();
		Legend = new JTextPane();
		JLabel time = new JLabel("Time left: 60");
		Encrypted.setForeground(Color.white);
		Encrypted.setBackground(Color.black);
		Message.setForeground(Color.white);
		Message.setBackground(Color.black);
		Legend.setForeground(Color.white);
		Legend.setBackground(Color.black);
		Encrypted.setEditable(false);
		Message.setEditable(false);
		Legend.setEditable(false);
		panel1.add(Message);
		panel1.add(Legend);
		panel2.add(text);
		panel2.add(time);
		panel2.add(start);
		start.addActionListener(this);
		this.setSize(600, 700);
		this.setVisible(true);
		this.setLayout(new GridLayout(3, 1));
		this.add(panel2);
		this.add(panel1);
		this.add(Encrypted);
		Arrays.fill(numUsed, false);
		for (int i = 0; i < indexChar.length; i++) {
			int num = rand.nextInt(indexChar.length);
			while (numUsed[num])
				num = rand.nextInt(indexChar.length);
			encryptedIndex[i] = indexNum[num];
			legend[i] = indexNum[i] + encryptedIndex[i];
			numUsed[num] = true;
		}
		for (int i = 0; i < numUsed.length; i++)
			numUsed[i] = false;
		for (int i = 10; i > -1; i--) {
			if (restart) {
				i = 10;
				restart = false;
			}
			time.setText("Time Left: " + i);
			Thread.sleep(1000);
		}
		message = text.getText();
		String message1 = "", legendString = "";
		for (int i = 0; i < message.length(); i++) {
			message1 += toEncryption(String.valueOf(message.charAt(i)));
			Message.setText(message1);
			Thread.sleep(5);
		}
		for (int i = 0; i < indexChar.length; i++) {
			legendString += legend[i] + ".";
			Legend.setText(legendString);
			Thread.sleep(5);
		}
		for (int i = 0; i < (message.length() > indexChar.length ? message
				.length() : indexChar.length); i++) {
			if (i < message.length()) {
				encryptedMessage += toEncryption(String.valueOf(message
						.charAt(i)));
				Encrypted.setText(encryptedMessage);
				Thread.sleep(5);
			}
			if (i < indexChar.length) {
				int num = rand.nextInt(indexChar.length);
				while (numUsed[num])
					num = rand.nextInt(indexChar.length);
				encryptedMessage += legend[num] + ".";
				Encrypted.setText(encryptedMessage);
				numUsed[num] = true;
				Thread.sleep(5);
			}
		}

	}

	public static void main(String[] args) throws InterruptedException,
			LineUnavailableException, IOException {
		Encryption window = new Encryption();
		AudioEncrypt audiofile = new AudioEncrypt(encryptedMessage);
		Decryption decrypt = new Decryption(encryptedMessage);

	}

	public static String toEncryption(String letter) {
		int num = 0;
		for (int i = 0; i < indexChar.length; i++)
			if (letter.toLowerCase().contains(indexChar[i]))
				num = i;
		return encryptedIndex[num] + ".";
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == start)
			restart = true;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
