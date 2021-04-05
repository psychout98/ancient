import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class Decryption extends JFrame {

	public String decryptedMessage, encryptedMessage, legendPiece,
			indexChar[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
					"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
					"w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
					"9", "0", " ", "~", "`", "!", "@", "#", "$", "%", "^", "&",
					"*", "(", ")", "-", "_", "+", "=", "{", "[", "}", "]", "|",
					":", ";", "'", "<", ",", ">", ".", "?", "/" },
			legend[] = new String[indexChar.length], Legend = "";

	public Decryption(String message) throws InterruptedException {
		JTextPane text = new JTextPane(), text2 = new JTextPane(), text3 = new JTextPane();
		JPanel panel1 = new JPanel(new GridLayout(1, 1)), panel2 = new JPanel(
				new GridLayout(2, 1));
		Font f = new Font("Agency FB", Font.BOLD, 12);
		text.setForeground(Color.white);
		text2.setForeground(Color.white);
		text.setBackground(Color.black);
		text2.setBackground(Color.black);
		text.setFont(f);
		text2.setFont(f);
		text.setText(message);
		text2.setText(message);
		text3.setFont(f);
		text3.setForeground(Color.white);
		text3.setBackground(Color.black);
		this.setSize(500, 500);
		this.setVisible(true);
		this.setLocation(500, 0);
		this.setLayout(new GridLayout(1, 2));
		panel1.add(text2);
		panel2.add(text);
		panel2.add(text3);
		this.add(panel1);
		this.add(panel2);
		encryptedMessage = message;
		for (int i = 0; i < encryptedMessage.length() - 3; i++) {
			if (encryptedMessage.charAt(i) == '.'
					&& encryptedMessage.charAt(i + 3) != '.') {
				legendPiece = encryptedMessage.substring(i + 1, i + 5);
				Legend += legendPiece + ".";
				Legend(legendPiece);
				encryptedMessage = encryptedMessage.substring(0, i)
						+ encryptedMessage.substring(i + 5,
								encryptedMessage.length());
				i--;
				text.setText(encryptedMessage);
				text3.setText(Legend);
				Thread.sleep(100);
			}
		}
		Password decode = new Password(toString());
	}

	public void Legend(String code) {
		int arraylocation = Integer.parseInt(code.substring(0, 2));
		String arrayvalue = code.substring(2, 4);
		legend[arraylocation] = arrayvalue;
	}

	public String toString() {
		String message = "";
		for (int j = 0; j < encryptedMessage.length() - 2; j++)
			for (int i = 0; i < indexChar.length; i++)
				if (encryptedMessage.substring(j, j + 2).contains(legend[i]))
					message += indexChar[i];
		return message;
	}

}
