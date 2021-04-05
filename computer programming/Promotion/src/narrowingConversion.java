
public class narrowingConversion {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int bacon = 100000000;
		int me = 1;
		byte finalbacon = (byte)((byte)bacon - (me*bacon));
		System.out.println("I have "+bacon+" strips of bacon and "+me+" me.");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(500);
		System.out.println("Now i have " + finalbacon+ " strips of bacon.");
		Thread.sleep(500);
		System.out.println("By the way the outcome was a byte.");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(500);
		System.out.println("And I'm fat.");
	}

}
