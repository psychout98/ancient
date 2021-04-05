package liam;

import java.util.Random;

public class PusherBot extends ChatterBot {

	public PusherBot(Message[] messages, ChatRoom room) {
		super(messages, room);
		Random rand = new Random();
	}

	public void update(Message msg) {
		post();
	}

	public void post() {
		Random rand = new Random();
		Message reply = null;
		Message temp = new Message();
		if ((this.room.getMoodMean() < 1)) {
			while (reply == null) {
				temp = messages[rand.nextInt(messages.length)];
				if (temp.getSentiment() == 0) {
					reply = temp;
				}
			}
		}

		else if (this.room.getMoodMean() >= 1) {
			while (reply == null) {
				temp = messages[rand.nextInt(messages.length)];
				if (temp.getSentiment() == 2) {
					reply = temp;
				}
			}
		}
		this.room.postNewMessage(reply);
	}

}
