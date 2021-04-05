package liam;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MessageParser {
	/**
	 * Take the name of a comma-separated value (.csv) file in the local directory
	 * and parse the contents for tweets. The tweets have an expected structure of
	 * "Topic", "Sentiment", "TweetId", "TweetDate", "TweetText"
	 * 
	 * @param filename the name of a comma-separated value (.csv) file in the local
	 *                 directory
	 * @return An array of parsed Message objects
	 * @throws FileNotFoundException 
	 */
	public static Message[] parseMessages(String filename) throws FileNotFoundException {
		// Creates an array of Message objects
		Message[] messages = new Message[5113];
		File file = new File(filename);
		Scanner input = new Scanner(file);
		String temp;
		temp = input.nextLine();
		int sentiment = 0;
		int i = 0;
		// This will check that the file has data and then pull the line of the file
		// into a Message object
		while (input.hasNext()) {
			temp = input.nextLine();
			String[] line = temp.split(",", 5);
			if (line[1].equals("positive")) {
				sentiment = 2;
			} else if (line[1].equals("negative")) {
				sentiment = 0;
			} else if (line[1].equals("neutral")) {
				sentiment = 1;
			} else {
				sentiment = -1;
			}
			messages[i] = new Message(line[0], sentiment, line[2], line[3], line[4]);
			i++;
		}
		input.close();
		return messages;
		
		
		
	}
}
