import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class birdview extends JFrame implements KeyListener{
	
	JPanel leftPanel,rightPanel,panel3;
	int movement,Ox=200,Oy=100, g = 2;
	double angle=Math.PI/2,X=0,Y=0,dX=150,dY=150;
	
	public birdview() throws InterruptedException{
		super("2D Graphic");
		this.setSize(1200, 600);
		this.setVisible(false);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1,2));
		this.setResizable(false);
		leftPanel = new graphic();
		rightPanel = new graphic2();
		panel3 = new graphic3();
		this.addKeyListener(this);
	//	this.add(leftPanel);
		this.add(rightPanel);
		this.add(panel3);
		this.setVisible(true);
		while (true) {
			if(movement == 1){
				X+=Math.cos(angle);
				Y+=Math.sin(angle);
			}
			if(movement == 2){
				X-=Math.cos(angle);
				Y-=Math.sin(angle);
			}
			if(movement == 3){
				X+=Math.cos(angle+Math.PI/2);
				Y+=Math.sin(angle+Math.PI/2);
			}
			if(movement == 4){
				X-=Math.cos(angle+Math.PI/2);
				Y-=Math.sin(angle+Math.PI/2);
			}
			if(movement == 5){
				angle+=Math.PI/180;
			}
			if(movement == 6){
				angle-=Math.PI/180;
			}
			if(angle<0)
				angle+=2*Math.PI;
			if(angle>=2*Math.PI)
				angle-=2*Math.PI;
			Thread.sleep(10);
			repaint();
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		birdview window = new birdview();
	}
	public class graphic3 extends JPanel {
		
		public void paint(Graphics p){
			setSize(600,600);
			p.setColor(Color.white);
			p.fillRect(0, 0, 600, 600);
			p.setColor(Color.red);
			for(int i=0;i<11;i++){
				for(int j=0;j<11;j++){
			Line2(40*i-200,200-40*j,40*i-160,200-40*j,p);
			Line2(40*i-200,200-40*j,40*i-200,240-40*j,p);
				}
			}
			p.setColor(Color.black);
			p.fillRect(0, 497, 600, 200);
		}
	}
	public class graphic2 extends JPanel {
		
		public void paint(Graphics p){
			setSize(600,600);
			p.setColor(Color.white);
			p.fillRect(0, 0, 600, 600);
			p.setColor(Color.red);
			for(int i=0;i<11;i++){
				for(int j=0;j<11;j++){
			Line(40*i-200,200-40*j,40*i-160,200-40*j,p);
			Line(40*i-200,200-40*j,40*i-200,240-40*j,p);
				}
			}
			p.setColor(Color.blue);
			p.fillRect(250, 497, 100, 5);
			p.drawLine(300,570,300+(int)(600*Math.cos(2*Math.PI/3)),600-(int)(600*Math.sin(2*Math.PI/3)));
			p.drawLine(300,570,300+(int)(600*Math.cos(Math.PI/3)),600-(int)(600*Math.sin(Math.PI/3)));
		}
	}
	
	public void Line(double x1,double y1,double x2, double y2, Graphics p){
		p.drawLine(X(x1, y1),Y(x1, y1),X(x2, y2),Y(x2, y2));
	}

	public void Line2(double x1,double y1,double x2, double y2, Graphics p){
		p.drawLine(pX(x1, y1),Y(x1, y1),pX(x2, y2),Y(x2, y2));
	}
	
	public int X(double x,double y){
		return 300+(int)(Math.sqrt(((x-X)*(x-X))+((y-Y)*(y-Y)))*Math.cos(Math.atan((y-Y)/(x-X))+(x-X<0?Math.PI:(y-Y<0?2*Math.PI:0))-angle+Math.PI/2));
	}
	
	public int pX(double x,double y){
		double nY = Math.sqrt(((x-X)*(x-X))+((y-Y)*(y-Y)))*Math.sin(Math.atan((y-Y)/(x-X))+(x-X<0?Math.PI:(y-Y<0?2*Math.PI:0))-angle+Math.PI/2)+73,
				nX = 6*Math.sqrt(((x-X)*(x-X))+((y-Y)*(y-Y)))*Math.cos(Math.atan((y-Y)/(x-X))+(x-X<0?Math.PI:(y-Y<0?2*Math.PI:0))-angle+Math.PI/2)*(1-Math.atan(nY/73));
		return 300+(int)nX;
	}
	
	public int Y(double x, double y){
		return 570-(int)(Math.sqrt(((x-X)*(x-X))+((y-Y)*(y-Y)))*Math.sin(Math.atan((y-Y)/(x-X))+(x-X<0?Math.PI:(y-Y<0?2*Math.PI:0))-angle+Math.PI/2));
	}
	
	public class graphic extends JPanel {
		
		public void paint(Graphics p){
			setSize(600, 600);
			double x=Ox-X,y=Oy-Y, q = x<0?Math.PI:(y<0?2*Math.PI:0), pA=Math.atan(y/x)+q,d = Math.sqrt((x*x)+(y*y));
			int[][] ds = new int[4][314];
			p.setColor(Color.white);
			p.fillRect(0, 0, 600, 600);
			p.setColor(Color.red);
			p.fillOval(295+Ox, 295-Oy, 10, 10);
			p.setColor(Color.blue);
			p.fillOval(295+(int)X, 295-(int)Y, 10, 10);
			p.setColor(Color.black);
			p.drawLine(300, 0, 300, 600);
			p.drawLine(0, 300, 600, 300);
			p.drawLine(300+(int)(X-d), 300-(int)(Y), 300+(int)(X+d), 300-(int)(Y));
			p.drawLine(300+(int)(X), 300-(int)(Y+d), 300+(int)(X), 300-(int)(Y-d));
			p.drawLine(300+Ox, 300-Oy, 300+Ox, 300-(int)Y);
			p.drawLine(300+Ox, 300-Oy, 300+(int)X, 300-Oy);
			p.setColor(Color.orange);
			p.drawLine(300+(int)(X-d*Math.cos(angle)),300-(int)(Y-d*Math.sin(angle)),300+(int)(X+d*Math.cos(angle)),300-(int)(Y+d*Math.sin(angle)));
			p.drawLine(300+(int)(X+d*Math.cos(angle+(Math.PI/2))),300-(int)(Y+d*Math.sin(angle+(Math.PI/2))),300+(int)(X+d*Math.cos(angle-(Math.PI/2))),300-(int)(Y+d*Math.sin(angle-(Math.PI/2))));
			p.setColor(Color.magenta);
			for(double i=-1.57;i<1.57;i+=.01){
				ds[0][(int)((i+1.57)*100)] = 300+(int)(X+(d*Math.cos(i)*Math.cos(i-pA)));
				ds[1][(int)((i+1.57)*100)] = 300-(int)(Y+(d*Math.sin(i)*Math.cos(i-pA)));
			}
			p.drawPolygon(ds[0], ds[1], 314);
			
			if(Math.abs(angle-pA)>1000*Math.PI/2){
			ds[2][0]=300+(int)X;
			ds[3][0]=300-(int)Y;
			ds[2][1]=ds[0][158+(int)(100*(angle-pA))];
			ds[3][1]=ds[1][158+(int)(100*(angle-pA))];
			ds[2][2]=300+Ox;
			ds[3][2]=300-Oy;
			ds[2][3]=ds[0][158-(int)(100*(angle-pA))];
			ds[3][3]=ds[1][158-(int)(100*(angle-pA))];
			p.drawPolygon(ds[2], ds[3], 4);
			}
			p.setColor(Color.green);
			p.drawLine(300+(int)X, 300-(int)Y, 300+Ox, 300-Oy);
			p.setColor(Color.blue);
	//		p.drawArc(300+(int)(X-d), 300-(int)(Y+d), (int)(2*d), (int)(2*d), 0, (int)(180*angle/Math.PI));
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP)
			movement=1;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			movement=2;
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			movement=3;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			movement=4;
		if(e.getKeyCode() == KeyEvent.VK_COMMA)
			movement=5;
		if(e.getKeyCode() == KeyEvent.VK_PERIOD)
			movement=6;
		if(e.getKeyCode() == KeyEvent.VK_1)
			g = 1;
		if(e.getKeyCode() == KeyEvent.VK_2)
			g = 2;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == e.getKeyCode())
			movement=0;
	}

}
