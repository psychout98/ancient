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

public class Chatter2 extends JFrame implements ActionListener,

KeyListener {
	static JTextPane Statement, Response;
	static boolean go = false, responded = false;
	static String keyword, response, keywords[], responses[], arrayList = "",
			definitions[], Words[], array[], word[], description[];
	static int wordnum;

	static File File = new File("Arrays.txt"), File2 = new File("Words.txt");

	Chatter2() throws InterruptedException {
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

	public static void splitWords(String statement) {
		int spaces = 0, space[];
		for (int i = 0; i < statement.length(); i++)
			if (statement.charAt(i) == ' ')
				spaces++;
		space = new int[spaces];
		Words = new String[spaces + 1];
		spaces = -1;
		for (int i = 0; i < statement.length(); i++)
			if (statement.charAt(i) == ' ') {
				spaces++;
				space[spaces] = i;
			}
		spaces++;
		Words[0] = statement.substring(0, space[0]).replace(",", "").replace(";", "").replace(".", "");
		for (int i = 1; i < spaces; i++) {
			Words[i] = statement.substring(space[i - 1] + 1, space[i]).replace(",", "").replace(";", "").replace(".", "");
		}
		if (statement.charAt(statement.length() - 1) == '.'
				|| statement.charAt(statement.length() - 1) == '?'
				|| statement.charAt(statement.length() - 1) == '!')
			Words[spaces] = statement.substring(space[spaces - 1] + 1,
					statement.length() - 1).replace(",", "").replace(";", "").replace(".", "");
		else
			Words[spaces] = statement.substring(space[spaces - 1] + 1).replace(",", "").replace(";", "").replace(".", "");

	}

	public static void reread(String statement) throws IOException,
			InterruptedException {
		boolean any = false;
		for (int j = 0; j < Words.length; j++) {
			any = false;
			for (int i = 0; i < word.length; i++)
				if (word[i].contains(Words[j])) {
					any = true;
				}
			if (!any) {
				wordnum = j;
				Statement.setText("");
				Response.setText("");
				Statement.setText(Words[wordnum] +" is "+findAfterIs(Words[wordnum])+findDefinition(Words[wordnum]));
				Response.setText("Define " + Words[wordnum]);
				go = false;
				responded = false;
				while(!Statement.getText().toLowerCase().equals("bye")){
					if(go){
								learn(Statement.getText());
								redefineArrays();
								splitWords(Statement.getText());
								reread(Statement.getText());
								break;
					}
					Thread.sleep(100);
				}
			}
		}
		if (any)
			Respond(statement);
	}
	
	public static String findAfterIs(String word) throws InterruptedException, IOException{
		String afterIs = "", type = "", Line = "";
		String sHtml = get("http://dictionary.reference.com/browse/" + word
				+ "?s=t", null);
		Scanner scan = new Scanner(sHtml);
		int begin = 0, end = 0;
		while (scan.hasNextLine()) {
			if(scan.nextLine().contains("<header class=\"luna-data-header\">")){
				Line = scan.nextLine();
				break;
			}
		}
		for(int i=0;i<Line.length();i++)
			if(Line.charAt(i) == '>'){
				begin = i+1;
				break;
			}
		for(int i=begin;i<Line.length();i++)
			if(Line.charAt(i) == '<'){
				end = i;
				break;
			}
		type = Line.substring(begin,end);
		if(type.contains("adverb") || type.contains("adjective"))
			afterIs = "a word describing ";
		if(type.contains("preposition"))
			afterIs = "a preposition, ";
		if(type.contains("verb"))
			if(Words[wordnum].endsWith("s")){
				Words[wordnum] = Words[wordnum].substring(0, Words[wordnum].length()-2);
				learn(Words[wordnum]+"s is the plural of "+Words[wordnum]);
			}
		return afterIs;
	}
	
	public static String findDefinition(String word) {
		char letters[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
				'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
				'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6',
				'7', '8', '9', '0' };
		String sHtml = get("http://dictionary.reference.com/browse/" + word
				+ "?s=t", null), definition = "", defLine = "";
		Scanner scan = new Scanner(sHtml);
		while (scan.hasNextLine()) {
			if (scan.nextLine()
					.contains("<span class=\"def-number\">1.</span>")) {
				scan.nextLine();
				defLine = scan.nextLine();
				break;
			}
		}
		int begin = 0, end = 0;
		for (int i = 0; i < defLine.length(); i++) {
			for (int j = 0; j < letters.length; j++) {
				if (defLine.charAt(i) == letters[j]) {
					begin = i;
					i = defLine.length();
					j = letters.length;
				}
			}
		}
		boolean any;
		for (int i = begin; i < defLine.length(); i++) {
			any = false;
			for (int j = 0; j < letters.length; j++)
				if (defLine.charAt(i) == letters[j] || defLine.charAt(i) == ' '
						|| defLine.charAt(i) == ',' || defLine.charAt(i) == ';'
					      || defLine.charAt(i) == '(' || defLine.charAt(i) == ')' || defLine.charAt(i) == '.')
					any = true;
			if (!any) {
				end = i;
				break;
			}
		}
		definition = defLine.substring(begin, end);
		return definition;
	}

	public static final String get(String s_httpUrl, String s_endingString) {
		return append((new StringBuilder()), s_httpUrl, s_endingString)
				.toString();
	}

	public static final Appendable append(Appendable ap_bl, String s_httpUrl,
			String s_endingString) {
		try {
			return appendX(ap_bl, s_httpUrl, s_endingString);
		} catch (IOException iox) {
			throw new RuntimeException(iox);
		}
	}

	public static final Appendable appendX(Appendable ap_bl, String s_httpUrl,
			String s_endingString) throws MalformedURLException, IOException {
		if (s_httpUrl == null || s_httpUrl.length() == 0) {
			throw new IllegalArgumentException("s_httpUrl (\"" + s_httpUrl
					+ "\") is null or empty.");
		}
		if (s_endingString != null && s_endingString.length() == 0) {
			throw new IllegalArgumentException(
					"s_endingString is non-null and empty.");
		}
		URL url = new URL(s_httpUrl);
		InputStream is = url.openStream();
		BufferedInputStream bis = new BufferedInputStream(is);
		int ixEndStr = 0;
		while (true) {
			int iChar = bis.read();
			if (iChar == -1) {
				break;
			}
			char c = (char) iChar;
			try {
				ap_bl.append(c);
			} catch (NullPointerException npx) {
				throw new NullPointerException("ap_bl");
			}
			if (s_endingString != null) {
				char[] ac = s_endingString.toCharArray();
				if (c == ac[ixEndStr]) {
					if (ixEndStr == (ac.length - 1)) {
						return ap_bl;
					}
					ixEndStr++;
				} else {
					ixEndStr = 0;
				}
			}
		}
		if (s_endingString != null) {
			throw new EOFException(
					"s_endingString "
							+ (new String(s_endingString))
							+ " (is non-null, and was not found at the end of the web-page's source-code.");
		}
		return ap_bl;
	}

	public static void learn(String word) throws InterruptedException, IOException {
				Scanner scan = new Scanner(File2);
				arrayList = "";
				while (scan.hasNextLine())
					arrayList += scan.nextLine() + "\n";
				arrayList += word;
				while(arrayList.endsWith(" "))
					arrayList = arrayList.substring(0,arrayList.length()-1);
				FileWriter fw = new FileWriter(File2.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(arrayList);
				bw.close();
	}

	public static void Respond(String statement) throws IOException {
		boolean any = false, anyWords = false;
		if (statement.endsWith("?")) {
			Answer();
			any = true;
		}
		for (int i = 0; i < array.length; i++)
			if (statement.contains(array[i])) {
				Response.setText("I knew that.");
				any = true;
			} else {
				// respond to statement find older algorithm
			}
		if (!any) {
			Response.setText(getRandomResponse());
		}
	}

	private static String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		}

		return response;
	}

	public static void Answer() {

	}

	public static void redefineArrays() throws FileNotFoundException {
		Scanner as3 = new Scanner(File), as4 = new Scanner(File);
		int lines2 = 0, k = 0;
		while (as3.hasNextLine()) {
			arrayList += as3.nextLine() + "\n";
			lines2++;
		}
		keywords = new String[lines2];
		responses = new String[lines2];
		for (int l = 0; l < lines2; l++) {
			String line2 = as4.nextLine();
			for (int j = 0; j < line2.length(); j++)
				if (line2.charAt(j) == ':')
					k = j;
			keywords[l] = line2.substring(0, k);
			responses[l] = line2.substring(k + 1);
		}
		Scanner as1 = new Scanner(File2), as2 = new Scanner(File2);
		int lines = 0, space = 0, space2 = 0;
		while (as1.hasNextLine()) {
			arrayList += as1.nextLine() + "\n";
			lines++;
		}
		array = new String[lines];
		word = new String[lines];
		description = new String[lines];
		for (int l = 0; l < lines; l++) {
			String line = as2.nextLine();
			array[l] = line;
			for (int i = 0; i < line.length(); i++)
				if (line.charAt(i) == ' ') {
					space = i;
					i = line.length();
				}
			word[l] = line.substring(0, space);
			for (int i = space + 1; i < line.length(); i++)
				if (line.charAt(i) == ' ') {
					space2 = i;
					i = line.length();
				}
			description[l] = line.substring(space2 + 1);
		}
	}

	public static void main(String[] args) throws InterruptedException,
			IOException, AWTException {
		Chatter2 window = new Chatter2();
		redefineArrays();
		Response.setText("Hello, lets talk.");
		while (!Statement.getText().toLowerCase().equals("bye")) {
			if (go) {
				if(!Statement.getText().contains(" ")){
					Words = new String[1];
					if (Statement.getText().charAt(Statement.getText().length() - 1) == '.'
							|| Statement.getText().charAt(Statement.getText().length() - 1) == '?'
							|| Statement.getText().charAt(Statement.getText().length() - 1) == '!')
						Words[0] = Statement.getText().substring(0,
								Statement.getText().length() - 1).replace(",", "");
					else
						Words[0] = Statement.getText().substring(0).replace(",", "");
				}
				else
				splitWords(Statement.getText());
				reread(Statement.getText());
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
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}