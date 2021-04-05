import java.awt.*;
import java.util.*;

import javax.swing.*;

public class Password extends JFrame {

	Password(String message) throws InterruptedException {
	Random rand = new Random();
	int sets=0;
	boolean set[] = new boolean[message.length()];
	String index[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
			"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
			"x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
			" ", "~", "`", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")",
			"_", "-", "+", "=", "{", "[", "}", "]", "|", ":", ";", "'", "<",
			",", ">", ".", "?", "/" }, pass[] = new String[message.length()], Message = "";
		for (int i = 0; i < message.length(); i++){
			pass[i] = index[rand.nextInt(index.length)];
		}
		this.setSize(500,500);
		this.setVisible(true);
		this.setLocation(0, 250);
		for(int i=0;i<message.length();i++)
			Message+=pass[i];
		Font f = new Font("Agency FB", Font.BOLD,30);
		JTextPane text = new JTextPane();
		text.setEditable(false);
		text.setFont(f);
		this.add(text);
		while (true) {
			Message="";
			for(int i=0;i<message.length();i++)
				Message+=pass[i];
			text.setText(Message);
			for (int i = 0; i < message.length(); i++)
				if(String.valueOf(message.charAt(i)).contains(pass[i])&&!set[i]){
					set[i]=true;
					sets++;
				}
			if (sets==message.length())
				break;
			int fix = rand.nextInt(message.length());
			while (set[fix])
				fix = rand.nextInt(message.length());
			pass[fix] = index[rand.nextInt(index.length)];
			Thread.sleep(5);
		}
		
	}

}
