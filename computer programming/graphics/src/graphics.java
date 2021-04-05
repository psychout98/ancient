import java.awt.*;
import javax.swing.JApplet;
import javax.swing.JFrame;

public class graphics extends JApplet {
	
	public void paint(Graphics g){
		final int MID = 150;
		final int TOP = 50;
		
		g.setColor(Color.cyan);
		g.fillRect(0, 0, 300, 175);
		
		g.setColor(Color.blue);
		g.fillRect(0, 175, 300, 50);
		
		g.setColor(Color.yellow);
		g.fillOval(-40, -40, 80, 80);
		
		g.setColor(Color.white);
		g.fillOval(MID - 20, TOP, 40, 40);
		g.fillOval(MID - 35, TOP + 35, 70, 50);
		g.fillOval(MID - 50, TOP + 80, 100, 60);
		
		g.setColor(Color.black);
		g.fillOval(MID - 10, TOP + 10, 5, 5);
		g.fillOval(MID + 5, TOP + 10, 5, 5);
		
		g.drawArc(MID - 10, TOP + 20, 20, 10, 190, 160);
		
		g.drawLine(MID - 25, TOP + 60, MID - 50, TOP + 40);
		g.drawLine(MID + 25, TOP + 60, MID + 55, TOP + 60);
		
		g.drawLine(MID - 20, TOP + 5, MID + 20, TOP + 5);
		g.fillRect(MID - 15, TOP - 20, 30, 25);
		g.setColor(Color.RED);
		g.fillOval(145, 90, 10, 10);
		g.fillOval(145, 110, 10, 10);
	}
}

