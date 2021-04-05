
public class SplitWords {

	public String Words[];
	SplitWords(String statement){
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
}
