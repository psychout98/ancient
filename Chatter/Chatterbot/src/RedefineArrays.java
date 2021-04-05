import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class RedefineArrays {

	public String arrayList,keywords[],responses[], array[],word[],description[];
	public File File,File2;
	RedefineArrays(String file1, String file2) throws FileNotFoundException{
		File = new File(file1);
		File2 = new File(file2);
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
}
