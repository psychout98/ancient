import java.util.Scanner;
public class PalindromeTester {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String punctuation[] = {"`","~","!","@","#","$","%","^","&","*","(",")","-","_","=","+","{","}","[","]","|","\\",":",";","\"","\"","<",","
				,">",".","?","/"," "};
		String fixr="";
		System.out.println("enter a word");
		String input=scan.nextLine();
		for(int i=0;i<punctuation.length;i++)
			input.replaceAll(punctuation[i], fixr);
		System.out.println(input);
		char letter2[]=new char[input.length()];
		String backwards="";
		for(int i=input.length()-1;i>=0;i--){
			letter2[i]=input.charAt(i);
			backwards=backwards+letter2[i];
		}
		if(backwards.toLowerCase().contains(input.toLowerCase()))
			System.out.println("Palindrome");
		else
			System.out.println("Not a palindrome");
	}
}
