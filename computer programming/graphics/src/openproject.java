import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class openproject {

	/**
	 * @param args
	 * @throws AWTException 
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		// TODO Auto-generated method stub
		Runtime.getRuntime().exec("snowman.HTML");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_F12);
		Thread.sleep(8);
		}

}
