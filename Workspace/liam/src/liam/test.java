package liam;

import java.io.FileNotFoundException;
public class test {

	public static void main(String[] args) throws FileNotFoundException{
		
		String a = "full-corpus.csv";
		Message[] messages = MessageParser.parseMessages(a);
		System.out.println("test1");
		ChatterBot[] penises = new ChatterBot[100];
		ChatRoom butts = new ChatRoom(penises);
		for(int i=0;i<10;i++)
			penises[i] = new PusherBot(messages,butts);
		for(int i=10;i<100;i++)
			penises[i] = new NeutralBot(messages,butts);
		for(int i=0;i<100;i++)
			penises[i].post();
		System.out.println(butts.posts);
		
	}		
	

}
