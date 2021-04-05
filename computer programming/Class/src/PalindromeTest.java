import java.util.Scanner;
public class PalindromeTest {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		char punctuation[] = {'`','~','!','@','#','$','%','^','&','*','(',')','-','_','=','+','{','}','[',']','|','\\',':',';','\'','\'','<',','
				,'>','.','?','/',' '};
		System.out.println("enter a word");
		String input=scan.nextLine();
		char letter2[]=new char[input.length()],letter[]=new char[input.length()];
		String backwards="",reg="";
		for(int i=0;i>=input.length();i++){
			for(int j=0;j<punctuation.length;j++)
				if(input.charAt(i)==punctuation[j])
					i++;
					letter[i]=input.charAt(i);
			reg=reg+letter[i];
		}
		for(int i=input.length()-1;i>=0;i--){
			for(int j=0;j<punctuation.length;j++)
				if(input.charAt(i)==punctuation[j])
					i--;
					letter2[i]=input.charAt(i);
			backwards=backwards+letter2[i];
		}
		System.out.println("Backwards: "+backwards);
		if(backwards.toLowerCase().contains(reg.toLowerCase()))
			System.out.println("Palindrome");
		else
			System.out.println("Not a palindrome");
	}
}
