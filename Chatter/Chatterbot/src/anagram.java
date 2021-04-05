import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class anagram {

 
 public static void main(String[] args) throws FileNotFoundException, InterruptedException{
  String anagram = "";
  File words = new File("words.txt");
  Scanner Words = new Scanner(words), Words2 = new Scanner(words), input = new Scanner(System.in);
  String full = "";
  int lines = 0, nums = 0;
  while(Words.hasNextLine()){
   full+=" "+Words.nextLine()+" ";
  }
  String Word = "";
  System.out.println("input letters (no more than eight letters)");
  Word = input.nextLine();
  char letters[] = new char[Word.length()];
  for(int i=0;i<Word.length();i++)
  letters[i] = Word.charAt(i);
  int length = letters.length;
  String highest = "", numString = "",found = "";
  for(int i=length;i>0;i--)
   highest+=i;
  boolean wrong = false;
  for(int i=1;i<Long.parseLong(highest)+1;i++){
   anagram = "";
   wrong = false;
   numString = ""+i;
   for(int j=length+1;j<10;j++){
    if(numString.contains(String.valueOf(j))||numString.contains("0"))
     wrong = true;
   }
   for(int j=0;j<numString.length();j++){
    int freq=0;
   char num = numString.charAt(j);
   for(int k=0;k<numString.length();k++)
    if(numString.charAt(k)==num)
     freq++;
   if(freq>1)
    wrong = true;
   }
   if(!wrong){
    for(int k=0;k<numString.length();k++)
     anagram+=letters[Integer.parseInt(String.valueOf(numString.charAt(k)))-1];
     if(full.contains(" "+anagram+" "))
      found+=(found.contains(" "+anagram)?"":" "+anagram);
   }
  }
  lines = 0;
  for(int i=0;i<found.length();i++)
   if(found.charAt(i) == ' ')
    lines++;
  String[] Found = new String[lines];
  int space[] = new int[lines+1];
  space[0] = 0;
  space[lines]=found.length();
  lines=1;
  for(int i=1;i<found.length();i++)
   if(found.charAt(i) == ' '){
    space[lines]=i;
    lines++;
  }
  for(int i=0;i<lines;i++){
   Found[i] = found.substring(space[i]+1,space[i+1]);
  }
  for(int i=0;i<Found.length;i++){
   System.out.println(i>0?(Found[i].length()>Found[i-1].length()?Found[i].length()+" letter words:\n"+Found[i]:Found[i]):  (Found[i].length()+" letter words:\n"+Found[i])  );
  }
 }
}