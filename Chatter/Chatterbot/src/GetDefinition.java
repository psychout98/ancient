import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class GetDefinition {
	public static String fullDefinition = "", word = "", afterIs = "", definition = "";
	public static boolean learnPlural = false;
	GetDefinition(String Word){
		word = Word;
		String type = "", Line = "";
		String sHtml = get("http://dictionary.reference.com/browse/" + word
				+ "?s=t", null);
		Scanner scan = new Scanner(sHtml);
		int begin = 0, end = 0;
		String defLine = "";
		while (scan.hasNextLine()) {
			String current = scan.nextLine();
			System.out.println(current);
			if(current.contains("<header class=\"luna-data-header\">")){
				Line = scan.nextLine();
			}
			else if(current.contains("<span class=\"def-number\">1.</span>")){
				defLine=scan.nextLine();
			}
		}
		System.out.println(defLine+"\n"+Line);
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
		if(type.contains("verb") && word.endsWith("s")){
				word = word.substring(0, word.length()-2);
				learnPlural = true;
			}
		char letters[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
				'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
				'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6',
				'7', '8', '9', '0' };
		begin = 0;
		end = 0;
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
		System.out.println(definition);
		fullDefinition = word +" is "+afterIs+definition;
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
}