import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;


public class Graph extends JApplet{
static int a,b,c;
	public static void main(String[] args){
		painter();
	}
	public class painter extends JApplet{
	public void paint(Graphics p){
		p.setColor(Color.black);
		p.drawLine(100, 0, 100, 200);
		p.drawLine(0, 100, 200, 100);
	}
	}
}
