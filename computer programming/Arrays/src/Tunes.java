
public class Tunes {

	public static void main(String[] args){
		CDCollection collection = new CDCollection();
		collection.addCD("Music", "You", 10, 10);
		collection.addCD("Not Music", "Not You", 20, 10);
		collection.addCD("Maybe Music", "Me", 30, 10);
		System.out.println(collection.toString());
	}
}
