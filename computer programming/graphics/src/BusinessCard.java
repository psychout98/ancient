import java.awt.*;
import javax.swing.JApplet;
import javax.swing.JFrame;

public class BusinessCard extends JApplet {
	
	public void paint(Graphics g){
		setSize(300,190);
		g.setColor(Color.BLUE);
		g.fillRect(0,0,300,190);
		g.setColor(Color.YELLOW);
		g.fillOval(0, 0, 80, 80);
		g.fillRect(60, 130, 130, 30);
		g.setFont(new Font("Times New Roman",Font.ITALIC,30));
		g.drawString("BCC High School",80,50);
		g.setColor(Color.BLACK);
		g.fillRect(20,20,10,10);
		g.fillRect(50,20,10,10);
		g.drawArc(20, 40, 40, 20, 180, 180);
		g.setFont(new Font("Times New Roman",Font.BOLD,22));
		g.drawString("Noah Heath",65,150);
	}
}