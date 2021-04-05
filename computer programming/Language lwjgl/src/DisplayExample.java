import javax.swing.JOptionPane;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

public class DisplayExample {
	public static void main(String[] args) {
		try {
		
			Display.setDisplayMode(new DisplayMode(640, 480));
			
			Display.setTitle("Episode 3 - OpenGL Rendering");

			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		
		
		
		while (!Display.isCloseRequested()) {
			
			while(Keyboard.next()) {
				if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
				System.out.println("player is moving up");	
				}
			}
		}

		Display.destroy();
		System.exit(0);
	}

}

// http://thecodinguniverse.com/lwjgl-tutorials/