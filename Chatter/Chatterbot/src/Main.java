import java.awt.AWTException;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Main extends JFrame implements ActionListener, KeyListener {

	static JTextPane Statement, Response;
	static boolean go = false, responded = false;
	static String keyword, response, keywords[], responses[], arrayList = "",
			definitions[], Words[], array[], word[], description[];
	static int wordnum;

	Main() throws InterruptedException {
		super("Chatbot");
		this.setSize(500, 300);
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(new GridLayout(1, 1));
		this.setDefaultCloseOperation(3);
		init();
	}

	public void init() throws InterruptedException {
		JPanel panel = new JPanel(new GridLayout(1, 2));
		Statement = new JTextPane();
		Statement.setEditable(true);
		Statement.addKeyListener(this);
		Statement.setBorder(BorderFactory.createLineBorder(Color.black));
		Response = new JTextPane();
		Response.setEditable(false);
		Response.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.add(Response);
		panel.add(Statement);
		this.add(panel);

	}

	public static void main(String[] args) throws InterruptedException,
			IOException {
		GetDefinition test = new GetDefinition("action");
		System.out.println(GetDefinition.definition);
		Main window = new Main();
		RedefineArrays arrays = new RedefineArrays("Arrays.txt", "Words.txt");
		arrayList = arrays.arrayList;
		keywords = new String[arrays.keywords.length];
		responses = new String[arrays.responses.length];
		array = new String[arrays.array.length];
		word = new String[arrays.word.length];
		description = new String[arrays.description.length];
		for (int i = 0; i < keywords.length; i++)
			keywords[i] = arrays.keywords[i];
		for (int i = 0; i < responses.length; i++)
			responses[i] = arrays.responses[i];
		for (int i = 0; i < array.length; i++)
			array[i] = arrays.array[i];
		for (int i = 0; i < word.length; i++)
			word[i] = arrays.word[i];
		for (int i = 0; i < description.length; i++)
			description[i] = arrays.description[i];
		Response.setText("Hello, lets talk.");
		while (!Statement.getText().toLowerCase().equals("bye")) {
			if (go) {
				if (!Statement.getText().contains(" ")) {
					Words = new String[1];
					if (Statement.getText().charAt(
							Statement.getText().length() - 1) == '.'
							|| Statement.getText().charAt(
									Statement.getText().length() - 1) == '?'
							|| Statement.getText().charAt(
									Statement.getText().length() - 1) == '!')
						Words[0] = Statement.getText()
								.substring(0, Statement.getText().length() - 1)
								.replace(",", "");
					else
						Words[0] = Statement.getText().substring(0)
								.replace(",", "");
				} else {
					SplitWords split = new SplitWords(Statement.getText());
					Words = new String[split.Words.length];
					for (int i = 0; i < Words.length; i++)
						Words[i] = split.Words[i];
				}
				Reread read = new Reread(Statement.getText());
				if (!read.any) {
					wordnum = Reread.wordnum;
					Statement.setText("");
					Response.setText("");
					GetDefinition definition = new GetDefinition(Words[wordnum]);
					if (GetDefinition.learnPlural) {
						Learn plural = new Learn(Words[wordnum]
								+ "s is the plural of " + Words[wordnum], new File("Words.txt"));
					}
					Statement.setText(definition.fullDefinition);
					Response.setText("Define " + Words[wordnum]);
					go=false;
					responded=true;
					while (!Statement.getText().toLowerCase().equals("bye")) {
						if (go) {
							Learn info = new Learn(Statement.getText(),new File("Words.txt"));
						}
					}

				} 
				else {
					Respond response = new Respond(Statement.getText());
					Response.setText(response.response);
				}
				go = false;
				responded = true;
			}
			Thread.sleep(100);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (responded && e.getKeyCode() == e.getKeyCode()) {
			Statement.setText("");
			responded = false;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		Robot r;
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				r = new Robot();
				r.keyPress(KeyEvent.VK_BACK_SPACE);
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
			go = true;

		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}
