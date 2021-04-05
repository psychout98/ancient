package liam;

import java.util.ArrayList;
public class ChatRoom {
  private final ChatterBot[] bots;
  private double mood, moodVariance;
  public ArrayList<Message> posts;

  public ChatRoom(ChatterBot[] bots){
    this.bots = bots;
    this.posts = new ArrayList<Message>();
  }

  /**
   * What is the mean (average) mood of all the bots in this room?
   * @return mean (average) mood of all the bots in this room
   */
  public double getMoodMean(){
    double moodStore = 0;
    for (int i = 0; i < bots.length-1; i++){
      moodStore +=  bots[i].getMood();
    }
    double moodMean = moodStore/bots.length;
    return moodMean;
  }

  /**
   * What is the variance of the moods of all the bots in this room?
   * @return the variance of the moods of all the bots in this room
   */
  public double getMoodVariance(){
    for (int i = 0; i < bots.length-1; i++){
      moodVariance += ((bots[i].getMood()*bots[i].getMood())/bots.length)-(getMoodMean()*getMoodMean());
    }
    return moodVariance;
  }

  /**
   * Accept a new message for posting in the next round of updates
   * @param msg The message to be posted.
   */
  public void postNewMessage(Message msg){
    posts.add(msg);
  }

  /**
   * Update all the bots with messages that have been posted since the last round of updates.
   */
  public void updateBots(Message msg){
	  for (ChatterBot bot : bots) 
	  { 
	      bot.update(msg);
	  }
  }

  /**
   * Were messages posted during the last round of updates?
   * @return If new messages were posted during the last round of updates, return true, otherwise, false.
   */
  public boolean hasNewMessages(){
    return false;
  }

}
