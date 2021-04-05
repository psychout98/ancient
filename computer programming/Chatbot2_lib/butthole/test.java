
public class test{
	public static void main(String[]args)
	
	{
		String ranks[] = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		int vals[] = {2,3,4,5,6,7,8,9,10,11,12,13,14};
		String suits[]={"Hearts","Spades","Clubs","Diamonds",};
		
		Deck a = new Deck(ranks,suits,vals);
		
		System.out.println(a.toString());
		
	}

}
