import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

public class tester {

	public static void main(String[] args) throws AWTException,
			InterruptedException, IOException {
		Robot r = new Robot();
		/*
		JOptionPane.showMessageDialog(null,"DO NOT TOUCH THE COMPUTER!!! TESTING IN PROGRESS!!! You can press enter right now though :D");
		Thread.sleep(1000);
		r.mouseMove(1731, 149);
		Thread.sleep(20);
		r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(20);
		r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(20);
		r.mouseMove(1671, 58);
		Thread.sleep(20);
		r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(20);
		r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(20);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_T);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_T);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_E);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_E);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_S);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_S);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_T);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_T);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_T);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_T);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_E);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_E);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_S);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_S);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_T);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_T);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_SPACE);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_SHIFT);
		Thread.sleep(20);
		for(int i=0;i<3;i++){
			r.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(20);
			r.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(20);
			r.keyPress(KeyEvent.VK_SPACE);
			Thread.sleep(20);
			r.keyRelease(KeyEvent.VK_SPACE);
			Thread.sleep(20);
		}
		r.keyRelease(KeyEvent.VK_SHIFT);
		Thread.sleep(20);
		*/
		Thread.sleep(3000);
		for (int i = 0; i < 6; i++) {
			r.keyPress(KeyEvent.VK_SPACE);
			Thread.sleep(20);
			r.keyRelease(KeyEvent.VK_SPACE);
			Thread.sleep(20);
			for (int j = 0; j < i + 1; j++) {
				r.keyPress(KeyEvent.VK_DOWN);
				Thread.sleep(20);
				r.keyRelease(KeyEvent.VK_DOWN);
				Thread.sleep(20);
			}
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(20);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(20);
			r.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(20);
			r.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(20);
			r.keyPress(KeyEvent.VK_T);
			Thread.sleep(20);
			r.keyRelease(KeyEvent.VK_T);
			Thread.sleep(20);
			r.keyPress(KeyEvent.VK_E);
			Thread.sleep(20);
			r.keyRelease(KeyEvent.VK_E);
			Thread.sleep(20);
			r.keyPress(KeyEvent.VK_S);
			Thread.sleep(20);
			r.keyRelease(KeyEvent.VK_S);
			Thread.sleep(20);
			r.keyPress(KeyEvent.VK_T);
			Thread.sleep(20);
			r.keyRelease(KeyEvent.VK_T);
			Thread.sleep(20);
			if (i == 0) {
				r.keyPress(KeyEvent.VK_0);
				Thread.sleep(20);
				r.keyRelease(KeyEvent.VK_0);
				Thread.sleep(20);
			} else if (i == 1) {
				r.keyPress(KeyEvent.VK_1);
				Thread.sleep(20);
				r.keyRelease(KeyEvent.VK_1);
				Thread.sleep(20);
			} else if (i == 2) {
				r.keyPress(KeyEvent.VK_2);
				Thread.sleep(20);
				r.keyRelease(KeyEvent.VK_2);
				Thread.sleep(20);
			} else if (i == 3) {
				r.keyPress(KeyEvent.VK_3);
				Thread.sleep(20);
				r.keyRelease(KeyEvent.VK_3);
				Thread.sleep(20);
			} else if (i == 4) {
				r.keyPress(KeyEvent.VK_4);
				Thread.sleep(20);
				r.keyRelease(KeyEvent.VK_4);
				Thread.sleep(20);
			} else if (i == 5) {
				r.keyPress(KeyEvent.VK_5);
				Thread.sleep(20);
				r.keyRelease(KeyEvent.VK_5);
				Thread.sleep(20);
			}
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(20);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(20);
		}
		r.keyPress(KeyEvent.VK_SHIFT);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_SHIFT);
		Thread.sleep(20);
		for (int a = 0; a < 4; a++) {
			for (int i = 0; i < 29; i++) {
				Thread.sleep(200);
				r.keyPress(KeyEvent.VK_SPACE);
				Thread.sleep(20);
				r.keyRelease(KeyEvent.VK_SPACE);
				Thread.sleep(20);
				for (int j = 0; j < i + 1; j++) {
					r.keyPress(KeyEvent.VK_DOWN);
					Thread.sleep(20);
					r.keyRelease(KeyEvent.VK_DOWN);
					Thread.sleep(20);
				}
				r.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(20);
				r.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(20);
				r.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(20);
				r.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(20);
				r.keyPress(KeyEvent.VK_T);
				Thread.sleep(20);
				r.keyRelease(KeyEvent.VK_T);
				Thread.sleep(20);
				r.keyPress(KeyEvent.VK_E);
				Thread.sleep(20);
				r.keyRelease(KeyEvent.VK_E);
				Thread.sleep(20);
				r.keyPress(KeyEvent.VK_S);
				Thread.sleep(20);
				r.keyRelease(KeyEvent.VK_S);
				Thread.sleep(20);
				r.keyPress(KeyEvent.VK_T);
				Thread.sleep(20);
				r.keyRelease(KeyEvent.VK_T);
				Thread.sleep(20);
				r.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(20);
				r.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(20);
			}
			r.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(20);
			r.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(20);
			if (a == 2) {
				r.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(20);
				r.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(20);
			}
		}
		for(int i=0;i<26;i++){
			r.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(20);
			r.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(20);
		}
		r.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_SPACE);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_T);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_T);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_E);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_E);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_S);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_S);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_T);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_T);
		Thread.sleep(20);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(20);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(20);
		JOptionPane.showMessageDialog(null,"You can touch the computer now. Testing is over");
	}

}
