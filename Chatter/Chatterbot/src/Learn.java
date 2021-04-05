import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Learn {

	
	Learn(String statement,File file) throws IOException{
		Scanner scan = new Scanner(file);
		String arrayList = "";
		while (scan.hasNextLine())
			arrayList += scan.nextLine() + "\n";
		arrayList += statement;
		while(arrayList.endsWith(" "))
			arrayList = arrayList.substring(0,arrayList.length()-1);
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(arrayList);
		bw.close();
	}
}
