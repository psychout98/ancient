import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class lol {
 public static void main(String[] args) throws AWTException, InterruptedException{
	 Robot r = new Robot();
	 Thread.sleep(10000);
	while(true){
		 r.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		 r.keyPress(KeyEvent.VK_V);
		 r.keyRelease(KeyEvent.VK_V);
		 Thread.sleep(1000);
		 r.keyRelease(KeyEvent.VK_CONTROL);
		 r.keyPress(KeyEvent.VK_ENTER);
		 Thread.sleep(1000);
		 r.keyPress(KeyEvent.VK_ESCAPE);
		 Thread.sleep(1000);
		 r.keyPress(KeyEvent.VK_ESCAPE);
		 Thread.sleep(1000);
		 r.keyPress(KeyEvent.VK_ESCAPE);
		 Thread.sleep(1000);
	 }
	 
	 
 }
}
