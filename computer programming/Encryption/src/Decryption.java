import java.awt.GridLayout;

import javax.swing.*;
public class Decryption extends JFrame{

	public String decryptedMessage, encryptedMessage,
			legend[] = new String[Encryption.indexChar.length], legendPiece,
			indexChar[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
					"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
					"w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
					"9", "0", " ", "~", "`", "!", "@", "#", "$", "%", "^", "&",
					"*", "(", ")", "-", "_", "+", "=", "{", "[", "}", "]", "|",
					":", ";", "'", "<", ",", ">", ".", "?", "/" };

	public Decryption(String message) throws InterruptedException {
		JTextPane text = new JTextPane(),text2= new JTextPane();
		text.setText(message);
		text2.setText(message);
		this.setSize(500,500);
		this.setVisible(true);
		this.setLocation(600, 0);
		this.setLayout(new GridLayout(2,1));
		this.add(text);
		this.add(text2);
		encryptedMessage = message;
		for (int i = 0; i < encryptedMessage.length() - 3; i++) {
			if (encryptedMessage.charAt(i) == '.'
					&& encryptedMessage.charAt(i + 3) != '.') {
				legendPiece = encryptedMessage.substring(i + 1, i + 5);
				Legend(legendPiece);
				encryptedMessage = encryptedMessage.substring(0, i)
						+ encryptedMessage.substring(i + 5,
								encryptedMessage.length());
				i--;
				text.setText(encryptedMessage);
				Thread.sleep(100);
			}
		}

	}

	public void Legend(String code) {
		int arraylocation = Integer.parseInt(code.substring(0, 2));
		String arrayvalue = code.substring(2, 4);
		legend[arraylocation] = arrayvalue;
	}

	public String toString() {
		String message="";
		for(int j=0;j<encryptedMessage.length()-2;j++)
		for(int i=0;i<indexChar.length;i++)
		if(encryptedMessage.substring(j, j+2).contains(legend[i]))
			message+=indexChar[i];
		return message;
	}

}
