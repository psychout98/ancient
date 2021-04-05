import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class boat extends JFrame implements ActionListener,
		MouseWheelListener, MouseListener, MouseMotionListener,ChangeListener,KeyListener {
	double obj[][][];
	JPanel panel, sheetPanel;
	double angleH = Math.PI/4, angleV = Math.PI/6,curH = angleH,curV = angleV,Ox=0.001,Oy=0.001,Oz=0.001;
	int curX, curY, iX, iY,
			xMoved, yMoved, cur, cur2,sections = 40,s1=14, s2=5;
	boolean dragging = false, up = false, panup = false, pandown = false, panleft = false, panright=false,
			down = false, left = false, right = false,showHelp = false,shown = false;
	double zoom = 1;
	JButton help = new JButton("Help");

	boat() throws InterruptedException, FileNotFoundException {
		super("Calculus Final Project");
		this.setSize(1100, 800);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		this.setDefaultCloseOperation(3);
		this.addKeyListener(this);
		this.addMouseWheelListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		panel = new cube();
		panel.setSize(this.getWidth(), this.getHeight()-200);
		defineSections();
		this.add(panel);
		this.setVisible(true);
		while (true) {
			Thread.sleep(30);
			if(pandown){
				Oz+=Math.cos(angleV);
				Ox+=Math.sin(angleV)*Math.cos(angleH);
				Oy+=Math.sin(angleV)*Math.sin(angleH);
			}
			if(panup){
				Oz-=Math.cos(angleV);
				Ox-=Math.sin(angleV)*Math.cos(angleH);
				Oy-=Math.sin(angleV)*Math.sin(angleH);
			}
			if(panleft){
				Ox+=Math.sin(angleH);
				Oy+=Math.cos(angleH);
			}
			if(panright){
				Ox-=Math.sin(angleH);
				Oy-=Math.cos(angleH);
			}
			repaint();
		}
	}
	
	public void defineSections(){
		obj = new double[s1+s2][3][sections+2];
		for(int j=1;j<sections+1;j++){
			double x = 8.9*(2*(j-1)/(double)(sections-1)-1);
			double Bx =  (4.6*(Math.pow((x+3.646)/15.8, 2)+Math.pow((x-3)/15, 4)+Math.pow((x-17)/36, 6)-2.0/3.0)/5.0),
					By = (2.0/3.0 - 3.0*(((x-2.1)/9)+Math.pow((x-.5)/11, 2)+Math.pow((x-.5)/10, 4)+Math.pow((x-.5)/9, 6)+Math.pow((x+2.5)/15, 12)+Math.pow((x/8.9),100)+Math.pow(1.1, (.5-x)/100)-0.5022)/23);
			
			for(int i=0;i<s1;i++){
			obj[i][0][j] = x;
			obj[i][1][j] = Bx*(1.0-2.0*i/((double)(s1)));
			obj[i][2][j] = .7-By*Math.sqrt(1-Math.pow((1.0-2.0*i/((double)(s1))), 2));
			}
			for(int i=s1;i<s1+s2;i++){
				double scs = (1.0-2.0*(i-s1)/((double)(s2)));
				obj[i][0][j] = x;
				obj[i][1][j] = i==s1?(-Bx*scs):(x>-4&&x<1?((i-s1>2?1:-1)*(Bx+.1)):0);
				obj[i][2][j] = .7+(x>-4&&x<1?(i-s1==2||i-s1==3?-.2:0):(i>s1?(9-Math.abs(x))/45.0:0));
			}
			}
		for(int i=0;i<s1+s2;i++){
		obj[i][0][0] = -9;
		obj[i][1][0] = 0;
		obj[i][2][0] = .7;
		obj[i][0][sections+1] = 9;
		obj[i][1][sections+1] = 0;
		obj[i][2][sections+1] = .7;
		}
	}
	
	public double equate(String equation, double x){
		return 1;
	}

	public static void main(String[] args) throws InterruptedException,
			FileNotFoundException {
		boat window = new boat();
	}
	
	public class cube extends JPanel {
		double center = (this.getWidth() / 2) + xMoved, center2 = (this
				.getHeight() / 2) + yMoved;
		public void axis(Graphics p){
			p.setColor(Color.red);
			p.drawLine((int)(center+(zoom*getXY(-15,0,0,true))), (int)(center2+(zoom*getXY(-15,0,0,false))), (int)(center+(zoom*getXY(15,0,0,true))), (int)(center2+(zoom*getXY(15,0,0,false))));
			p.drawLine((int)(center+(zoom*getXY(0,-15,0,true))), (int)(center2+(zoom*getXY(0,-15,0,false))), (int)(center+(zoom*getXY(0,15,0,true))), (int)(center2+(zoom*getXY(0,15,0,false))));
			p.drawString("X", (int)(center+(zoom*getXY(15,0,0,true))), (int)(center2+(zoom*getXY(15,0,0,false))));
			p.drawString("Y", (int)(center+(zoom*getXY(0,15,0,true))), (int)(center2+(zoom*getXY(0,15,0,false))));
			p.setColor(Color.blue);
			p.drawLine((int)(center+(zoom*getXY(-15,0,0,true)))+1, (int)(center2+(zoom*getXY(-15,0,0,false)))+1, (int)(center+(zoom*getXY(15,0,0,true)))+1, (int)(center2+(zoom*getXY(15,0,0,false)))+1);
			p.drawLine((int)(center+(zoom*getXY(0,-15,0,true)))+1, (int)(center2+(zoom*getXY(0,-15,0,false)))+1, (int)(center+(zoom*getXY(0,15,0,true)))+1, (int)(center2+(zoom*getXY(0,15,0,false)))+1);
			p.drawLine((int)(center+(zoom*getXY(-15,0,0,true)))+1, (int)(center2+(zoom*getXY(-15,0,0,false)))+1, (int)(center+(zoom*getXY(15,0,0,true)))+1, (int)(center2+(zoom*getXY(15,0,0,false)))+1);
			p.drawLine((int)(center+(zoom*getXY(0,-15,0,true)))+1, (int)(center2+(zoom*getXY(0,-15,0,false)))+1, (int)(center+(zoom*getXY(0,15,0,true)))+1, (int)(center2+(zoom*getXY(0,15,0,false)))+1);
			p.setColor(Color.black);
		}
		public void person(Graphics p){
			p.setColor(Color.blue);
			double[][][] lns1 = {{{0,-5,3},{0,-5,5.1}},
								{{0,-6,0},{0,-5,3}},
								{{0,-4,0},{0,-5,3}},
								{{0,-4,3},{0,-5,5}},
								{{0,-6,3},{0,-5,5}}},lns2=new double[26][2][3];
			for(int i=0;i<25;i++){
				if(i<5)
					lns2[i]=lns1[i];
				else
					for(int j=0;j<2;j++)
						for(int k=0;k<3;k++)
							lns2[i][j][k]=(k==0?0:(k==1?(.4*Math.cos(Math.PI*(i-5+(j==0?0:1))/10)-5):(.4*Math.sin(Math.PI*(i-5+(j==0?0:1))/10)+5.5)));
			}
			for(int i=0;i<lns2.length;i++)
			p.drawLine((int)(center+(zoom*getXY(lns2[i][0][0],lns2[i][0][1],lns2[i][0][2],true))),
					(int)(center2+(zoom*getXY(lns2[i][0][0],lns2[i][0][1],lns2[i][0][2],false))),
					(int)(center+(zoom*getXY(lns2[i][1][0],lns2[i][1][1],lns2[i][1][2],true))),
					(int)(center2+(zoom*getXY(lns2[i][1][0],lns2[i][1][1],lns2[i][1][2],false))));
		}
		public void paint(Graphics p) {
			center = (this.getWidth() / 2) + xMoved;
			center2 = (this.getHeight() / 2) + yMoved;
			int[][][] poly = new int[obj.length*obj[0][0].length][2][4];
			p.setColor(Color.white);
			p.fillRect(0,0,(int)center*2, (int)center2*2);
			boolean Ao[] = {angleV>=0,angleH>=Math.PI/2 && angleH<=3*Math.PI/2,angleH>=Math.PI};
			if(Ao[0])
				axis(p);
			p.setColor(Color.black);
			if(Ao[2])
				person(p);		
				for(int j=0;j<obj[0][0].length-1;j++)
					for(int i=0;i<s1+s2;i++){
					for(int b=0;b<2;b++)
						for(int a=0;a<4;a++)
						poly[obj[0][0].length*i + j][b][a] = (int) ((b==0?center:center2) + (zoom * getXY(obj[a<2?i:(i==s1+s2-1?0:i+1)][0][a>0&&a<3?j:j+1],obj[a<2?i:(i==s1+s2-1?0:i+1)][1][a>0&&a<3?j:j+1],obj[a<2?i:(i==s1+s2-1?0:i+1)][2][a>0&&a<3?j:j+1],b==0?true:false)));
				}
				if(!Ao[0])
					for(int j=0;j<obj[0][0].length-1;j++){
						int b=Ao[1]?obj[0][0].length-2-j:j;
							for(int i=s1;i<s1+s2;i++){
								int a=Ao[2]?(2*s1+s2-1-i):i;
							p.setColor(new Color(180+(a%2==0?(b%2==0?25:0):(b%2==0?0:25)),180+(a%2==0?(b%2==0?25:0):(b%2==0?0:25)),180+(a%2==0?(b%2==0?25:0):(b%2==0?0:25))));
							p.fillPolygon(poly[obj[0][0].length*a + b][0],poly[obj[0][0].length*a + b][1],4);
							p.setColor(new Color(100,100,100));
							p.drawPolygon(poly[obj[0][0].length*a + b][0],poly[obj[0][0].length*a + b][1],4);
							}
							p.setColor(new Color(180+(b%2==0?25:0),180+(b%2==0?25:0),180+(b%2==0?25:0)));
								p.fillPolygon(poly[obj[0][0].length*(Ao[2]?s1-1:0) + b][0],poly[obj[0][0].length*(Ao[2]?s1-1:0) + b][1],4);
								p.setColor(new Color(100,100,100));
								p.drawPolygon(poly[obj[0][0].length*(Ao[2]?s1-1:0) + b][0],poly[obj[0][0].length*(Ao[2]?s1-1:0) + b][1],4);
							}
				for(int j=0;j<obj[0][0].length-1;j++)
					for(int i=0;i<s1;i++){
				int a=(Ao[2]?i:s1-1-i),b=Ao[1]?obj[0][0].length-2-j:j;
				p.setColor(new Color(180+(a%2==0?(b%2==0?25:0):(b%2==0?0:25)),180+(a%2==0?(b%2==0?25:0):(b%2==0?0:25)),180+(a%2==0?(b%2==0?25:0):(b%2==0?0:25))));
				p.fillPolygon(poly[obj[0][0].length*a + b][0],poly[obj[0][0].length*a + b][1],4);
				p.setColor(new Color(100,100,100));
				p.drawPolygon(poly[obj[0][0].length*a + b][0],poly[obj[0][0].length*a + b][1],4);
				}
				if(Ao[0])
				for(int j=0;j<obj[0][0].length-1;j++){
					int b=Ao[1]?obj[0][0].length-2-j:j;
						for(int i=s1;i<s1+s2;i++){
							int a=Ao[2]?(2*s1+s2-1-i):i;
						p.setColor(new Color(180+(a%2==0?(b%2==0?25:0):(b%2==0?0:25)),180+(a%2==0?(b%2==0?25:0):(b%2==0?0:25)),180+(a%2==0?(b%2==0?25:0):(b%2==0?0:25))));
						p.fillPolygon(poly[obj[0][0].length*a + b][0],poly[obj[0][0].length*a + b][1],4);
						p.setColor(new Color(100,100,100));
						p.drawPolygon(poly[obj[0][0].length*a + b][0],poly[obj[0][0].length*a + b][1],4);
						}
						p.setColor(new Color(180+(b%2==0?25:0),180+(b%2==0?25:0),180+(b%2==0?25:0)));
							p.fillPolygon(poly[obj[0][0].length*(Ao[2]?s1-1:0) + b][0],poly[obj[0][0].length*(Ao[2]?s1-1:0) + b][1],4);
							p.setColor(new Color(100,100,100));
							p.drawPolygon(poly[obj[0][0].length*(Ao[2]?s1-1:0) + b][0],poly[obj[0][0].length*(Ao[2]?s1-1:0) + b][1],4);
						}
				if(!Ao[2])
					person(p);
				p.setColor(Color.green);
				p.fillOval((int)(center)-3,(int)(center2)-3, 6, 6);
				p.setColor(Color.red);
				p.drawLine((int)(center+(getXY(.6-Ox/10.0,0.001-Oy/10.0,0.001-Oz/10.0,true))), (int)(center2+(getXY(.6-Ox/10.0,0.001-Oy/10.0,0.001-Oz/10.0,false))), (int)(center+(getXY(-.6-Ox/10.0,0.001-Oy/10.0,0.001-Oz/10.0,true))), (int)(center2+(getXY(-.6-Ox/10.0,0.001-Oy/10.0,0.001-Oz/10.0,false))));
				p.setColor(Color.blue);
				p.drawLine((int)(center+(getXY(0.001-Ox/10.0,.6-Oy/10.0,0.001-Oz/10.0,true))), (int)(center2+(getXY(0.001-Ox/10.0,.6-Oy/10.0,0.001-Oz/10.0,false))), (int)(center+(getXY(0.001-Ox/10.0,-.6-Oy/10.0,0.001-Oz/10.0,true))), (int)(center2+(getXY(0.001-Ox/10.0,0.-.6-Oy/10.0,0.001-Oz/10.0,false))));
				if(!Ao[0])
					axis(p);
				p.setColor(Color.red);
				p.drawLine((int)(center+(zoom*getXY(0,.5,0,true))),
					(int)(center2+(zoom*getXY(0,.5,0,false))),
					(int)(center+(zoom*getXY(0,.5,1,true))),
					(int)(center2+(zoom*getXY(0,.5,1,false))));
				p.drawLine((int)(center+(zoom*getXY(0,.5,1,true))),
						(int)(center2+(zoom*getXY(0,.5,1,false))),
						(int)(center+(zoom*getXY(0,-.5,1,true))),
						(int)(center2+(zoom*getXY(0,-.5,1,false))));
				p.drawLine((int)(center+(zoom*getXY(0,-.5,1,true))),
					(int)(center2+(zoom*getXY(0,-.5,1,false))),
					(int)(center+(zoom*getXY(0,-.5,0,true))),
					(int)(center2+(zoom*getXY(0,-.5,0,false))));
		}
		
		
	}

	public double getXY(double x, double y, double z, boolean XY) {
		x += Ox/10.0;
		y += Oy/10.0;
		z += Oz/10.0;
		x *= 40;
		y *= 40;
		z *= -40;
		
		double rxy = Math.sqrt((x*x)+(y*y)),
				rxz = Math.sqrt((x*x)+(z*z)),
				Hpt = (x>0?0:Math.PI)+(x>0?1:-1)*Math.asin(y/rxy),
				Vpt = (x>0?0:Math.PI)+(x>0?1:-1)*Math.asin(z/rxz);
		double Y = ((z * Math.sin(angleV + (Math.PI / 2))) + (rxy * Math.sin(angleV) * Math.cos(angleH + Hpt)));
		double X = ((y * Math.sin(angleH + (Math.PI / 2))) + (rxz * Math.sin(angleH) * Math.cos(angleV + Vpt)));
		X = (rxy * Math.sin(angleH + Hpt));
		return XY ? X : Y;
	}


	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		if (arg0.getWheelRotation() < 0)
			zoom *= 1.1;
		if (arg0.getWheelRotation() > 0)
			zoom *= .9;

	}

	public double getDepth(double X, double Y, double Z) {
		double x = getXY(X, Y, Z, true), y = getXY(X, Y, Z, false);
		int front = (angleH < 361 && angleH > 179 ? 1 : -1);
		X *= 10;
		Y *= 10;
		Z *= 10;
		X += Ox;
		Y += Oy;
		Z += Oz;
		int q = X > 0 ? 1 : -1;
		double c = Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2) + Math.pow(Z, 2)), b = Math
				.sqrt(Math.pow(x, 2) + Math.pow(y, 2)), depth = (Math.sqrt(Math
				.pow(c, 2) - Math.pow(b, 2)) / 10)
				* front * q;
		return depth;

	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		iX = arg0.getPoint().x;
		iY = arg0.getPoint().y;
		dragging = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		curH = angleH;
		curV = angleV;
		dragging = false;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == help && !showHelp && !shown){
			help.setText("Close");
		}
		if(arg0.getSource() == help && showHelp && shown){
			help.setText("Help");
		}
			
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		curX = e.getPoint().x;
		curY = e.getPoint().y;
		if (dragging) {
			int Dx = curX - iX, Dy = curY - iY;
			angleH = ((double) Math.PI * (Dx) / (720.0*zoom)) + curH;
			angleV = ((double) Math.PI * (Dy) / (720.0*zoom)) + curV;
		}
		if(angleV < -Math.PI/2){
			angleV = -Math.PI/2;
			iY=curY;
			curV = angleV;
		}
		if(angleV > Math.PI/2){
			angleV = Math.PI/2;
			iY=curY;
			curV = angleV;
		}
		if(angleH < 0){
			angleH = 1439*Math.PI/720;
			iX=curX;
			curH = angleH;
		}
		if(angleH > 2*Math.PI){
			angleH = 0;
			iX=curX;
			curH = angleH;
		}
	}


	@Override
	public void stateChanged(ChangeEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP)
			panup=true;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			pandown=true;
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			panleft=true;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			panright=true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP)panup=false;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)pandown=false;
		if(e.getKeyCode() == KeyEvent.VK_LEFT)panleft=false;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)panright=false;
	}


}