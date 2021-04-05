import java.util.Scanner;

public class Define {
	Scanner scan = new Scanner(System.in);
	String[] Dictionary = new String[20000000];
	String[] Definition = new String[Dictionary.length];
	String definition;
		public Define(String word){
			for(int i=0;i<Dictionary.length;i++){
				if(word.toLowerCase() == Dictionary[i].toLowerCase())
					definition = Definition[i];
				else if(i==Dictionary.length-1){
					System.out.println("I do not recognize the word \""+word+"\", is this a spelling mistake or should i add this word to my vocabulary? 1 or 2");
				int input = scan.nextInt();
				if(input == 1){
					System.out.println("Ok, could you input the correct spelling?");
					word = scan.nextLine();
					for(int j=0;j<Dictionary.length;j++)
						if(word.toLowerCase() == Dictionary[i].toLowerCase())
							definition = Definition[i];
			}
				if(input == 2){
					System.out.println("Enter word");
					String Word = scan.nextLine();
					System.out.println("Enter definition");
					String Defined = scan.nextLine();
					//add to vocabulary
				}
		}
			}
			System.out.println(definition);
		}
	
}
