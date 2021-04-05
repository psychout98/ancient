import java.io.IOException;


public class Reread {

	public boolean any = false;
	public static int wordnum;
	public String Words[], word[];
	
	Reread(String statment){
		Words = new String[Main.Words.length];
		for(int i=0;i<Words.length;i++)
			Words[i] = Main.Words[i];
		word = new String[Main.word.length];
		for(int i=0;i<word.length;i++)
			word[i] = Main.word[i];
	for (int j = 0; j < Words.length; j++) {
		any = false;
		for (int i = 0; i < word.length; i++)
			if (word[i].contains(Words[j])) {
				any = true;
			}
		if (!any) {
			wordnum = j;
			break;
		}
	}
		

	}
}
