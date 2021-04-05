import java.awt.*;
import javax.swing.JApplet;
import javax.swing.JFrame;

public class Olympic extends JApplet {
	//blue black red yellow green
	public void paint(Graphics g){
		setSize(300,300);
		g.setColor(Color.BLUE);
		g.drawOval(50, 50, 50, 50);
		g.setColor(Color.BLACK);
		g.drawOval(110, 50, 50, 50);
		g.setColor(Color.RED);
		g.drawOval(170, 50, 50, 50);
		g.setColor(Color.YELLOW);
		g.drawOval(80, 80, 50, 50);
		g.setColor(Color.GREEN);
		g.drawOval(140, 80, 50, 50);
	}
}
