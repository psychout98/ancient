
public class Interpret {

	String interpretedMessage, words[];
	
	Interpret(String input){
		if(!input.endsWith("."))
			input+=".";
		int Words = 0;
		for(int i=0;i<input.length(); i++)
			if(input.charAt(i) == ' ' || input.charAt(i) == '.'){
				Words++;
			}
		int seperator[] = new int[Words+1];
		seperator[0] = 0;
		for(int j=1;j<Words+1;j++)
		for(int i=0;i<input.length();i++)
				if(input.charAt(i) == ' ' || input.charAt(i) == '.')
					seperator[j] = i;
		words = new String[Words];
		for(int i=0;i<Words;i++){
			int j=i+1;
			words[i] = input.substring(seperator[i], seperator[j]);
		}
	}
}
