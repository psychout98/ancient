package liam;

import java.util.Random;

public class ChatterBot{

  protected Message[] messages;
  protected final ChatRoom room;
  protected double mood = 1;

  public ChatterBot(Message[] messages, ChatRoom room){
     this.messages = messages;
     this.room = room;
  }

  public void update(Message msg){

  }

  public void read(Message msg){

  }

  public void post(){
    }

  public double getMood(){
    return mood;
  }
}
