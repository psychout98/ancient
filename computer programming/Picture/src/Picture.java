import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class Picture {
public static void main(String[] args) throws AWTException, IOException, InterruptedException{
	Robot r = new Robot();
	Runtime.getRuntime().exec("notepad");
	Thread.sleep(3000);

}
public static void u() throws AWTException, InterruptedException{
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_SHIFT);
	r.keyPress(KeyEvent.VK_MINUS);
	r.keyRelease(KeyEvent.VK_SHIFT);
	Thread.sleep(10);
}
public static void d() throws AWTException, InterruptedException{
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_SHIFT);
	r.keyPress(KeyEvent.VK_4);
	r.keyRelease(KeyEvent.VK_SHIFT);
	Thread.sleep(10);
}
public static void s() throws AWTException, InterruptedException{
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_S);
	Thread.sleep(10);
}
}
