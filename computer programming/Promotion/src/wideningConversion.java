
public class wideningConversion {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		byte bacon = 127;
		byte eggs = 127;
		int food = bacon+eggs;
		int finalbacon = bacon-eggs;
		System.out.println("I have " + food + " eggs and bacon.");
		Thread.sleep(500);
		System.out.println("After eating, I have " + finalbacon + " bacon and " + eggs + " eggs and bacon.");
		Thread.sleep(500);
		System.out.println("By the way, the final product was an int that was converted from a byte.");
		
		

	}

}
