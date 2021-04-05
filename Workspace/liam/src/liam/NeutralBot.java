package liam;

import java.util.Random;
/**
 * a bot that only tweets about neutral things. Child class of ChatterBot. test
 */
public class NeutralBot extends ChatterBot{

  /**
   * A constructor for a bot that initially only responds with neutral tweets about topics, but has a moderate positive or negative bias. As its bias increases, it begins to post positive or negative comments.
   * @param  messages Neutral messages
   * @return          [description]
   */
  public NeutralBot(Message[] messages, ChatRoom room){
    super(messages, room);
    Random rand = new Random();
    mood += 0.25*(rand.nextDouble() - 1);
  }

  public void update(Message msg){
    boolean read = false;
    int sentiment = msg.getSentiment();

    if(mood > 1 && sentiment > 1)
      read = true;
    else if(mood < 1 && sentiment < 1)
      read = true;
    else if(sentiment == 1 && mood == 1)
      read = true;

    if(read)
      read(msg);
  }

  public void read(Message msg){
    int sentiment = msg.getSentiment();
    Random rand = new Random();
    double replyChance = rand.nextDouble()*2.0;
    boolean post = false;

    if(mood > 1 && replyChance < mood)
      post = true;
    else if(mood < 1 && replyChance > mood)
      post = true;

    if(sentiment > 1)
      mood += 0.01;
    else if (sentiment < 1)
      mood -= 0.01;
    else{
      if(mood > 1)
        mood -= 0.01;
      else
        mood += 0.01;
    }

    if(post)
      post();
  }

  /**
   * While the mood of the NeutralBot is between 0.5 and 1.5,
    it will only post neutral articles. Once the mood of the NeutralBot
    dips below 0.5 (negative) or above 1.5 (positive), it should then begin posting positive or negative articles.
   */
  public void post(){
    Message reply = null;
    Random rand = new Random();
    Message temp = new Message();
    if(mood < .5) {
    	while (reply == null) {
    		temp = messages[rand.nextInt(messages.length)];
    	if (temp.getSentiment() == 0) {
    		reply = temp;
    		}
    	}
    }
    else if((mood >= .5) && (mood <= 1.5)) {
    	while (reply == null) {
    		temp = messages[rand.nextInt(messages.length)];
    	if (temp.getSentiment() == 1) {
    		reply = temp;
    		}
    	}
    }
    else if (mood > 1.5) {
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