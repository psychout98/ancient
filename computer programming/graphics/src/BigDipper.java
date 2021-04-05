import java.applet.Applet;
import java.awt.Color;
 
import java.awt.Graphics;
 
import java.util.Random;
 
public class BigDipper extends Applet {


public void paint(Graphics page) {
setSize(300,230);
 Random rand=new Random(); 
setBackground(Color.black); 
page.setColor(Color.white); 
page.fillOval(50,75,5,5); 
page.fillOval(100,65,5,5); 
page.drawLine(50,77,100,67); 
page.fillOval(135,90,5,5); 
page.drawLine(101,66,136,91); 
page.fillOval(180,110,5,5); 
page.drawLine(135,91,180,111); 
page.fillOval(275,120,5,5); 
page.drawLine(180,111,275,121); 
page.fillOval(250,170,5,5); 
page.drawLine(278,120,253,170);
page.fillOval(185,160,5,5);
page.drawLine(252,172,187,162);
page.drawLine(182,110,187,160);
}
}