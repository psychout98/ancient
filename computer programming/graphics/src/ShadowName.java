import java.awt.*;
import javax.swing.JApplet;
import javax.swing.JFrame;

public class ShadowName extends JApplet {
	
	public void paint(Graphics g){
		g.drawString("Noah Heath", 100, 100);
		g.setColor(Color.GRAY);
		g.drawString("Noah Heath", 102, 102);
	}
}
