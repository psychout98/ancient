import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class solid extends JFrame implements ActionListener,
		MouseWheelListener, MouseListener, MouseMotionListener,ChangeListener {
	double obj[][][];
	JPanel panel, sheetPanel;
	double angleH = Math.PI/2, angleV = Math.PI/2,curH = Math.PI/2,curV = Math.PI/2;
	double range = 9.701,resol=2*range/40;
	int curX, curY, iX, iY,
			xMoved, yMoved, cur, cur2;
	boolean dragging = false, up = false,
			down = false, left = false, right = false,showHelp = false,shown = false;
	double zoom = 2;
	JSlider sections = new JSlider(10,100,40);
	JButton help = new JButton("Help");

	solid() throws InterruptedException, FileNotFoundException {
		super("Calculus Final Project");
		this.setSize(800, 800);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		this.setDefaultCloseOperation(3);
		JTabbedPane tp = new JTabbedPane();
		JPanel graphicPanel = new JPanel(new BorderLayout());
		sheetPanel = new JPanel();
		JScrollPane sheetPane = new JScrollPane(sheetPanel,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sheetPane.getVerticalScrollBar().setUnitIncrement(16);
		panel = new cube();
		JPanel tpan = new JPanel(new BorderLayout());
		graphicPanel.addMouseWheelListener(this);
		graphicPanel.addMouseListener(this);
		graphicPanel.addMouseMotionListener(this);
		help.addActionListener(this);
		JLabel scts = new JLabel("Number of Cross Sections: ");
		sections.setMajorTickSpacing(5);
		sections.setMinorTickSpacing(1);
		sections.setPaintTicks(true);
		sections.setPaintLabels(true);
		sections.addChangeListener(this);
		tpan.add(scts, BorderLayout.WEST);
		tpan.add(sections,BorderLayout.CENTER);
		tpan.add(help,BorderLayout.EAST);
		graphicPanel.add(tpan, BorderLayout.NORTH);
		graphicPanel.add(panel, BorderLayout.CENTER);
		panel.setSize(this.getWidth(), this.getHeight()-200);
		defineSections();
		tp.add("3D Graphic", graphicPanel);
		tp.add("Spreadsheet",sheetPane);
		this.add(tp);
		this.setVisible(true);
		while (true) {
			Thread.sleep(42);
			if(dragging){
			if (up)
				angleV+=Math.PI/180;
			if (down)
				angleV-=Math.PI/180;
			if (left)
				angleH-=Math.PI/180;
			if (right)
				angleH+=Math.PI/180;
			if (angleH > 2*Math.PI)
				angleH = Math.PI/180;
			if (angleH < 0)
				angleH = 359*Math.PI/180;
			repaint();
			}	
		}
	}
	
	public void defineSections(){
		obj = new double[3][3][sections.getValue()+1];
		resol = 2*range/sections.getValue();
		double tv=0;
		sheetPanel.removeAll();
		sheetPanel.setLayout(new GridLayout(sections.getValue()+6,10));;
		JTextArea[][] val = new JTextArea[sections.getValue()+6][9];
		for(int i=0;i<sections.getValue()+6;i++)
			for(int j=0;j<9;j++){
				val[i][j] = new JTextArea();
				val[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				val[i][j].setEditable(false);
				sheetPanel.add(val[i][j]);
			}
		String[] l1 = {"    Section","         x","        dx","        y1","        y2"," Base Length","    Height","     Area","    Volume"};
		for(int i=0;i<9;i++)
		val[0][i].setText(l1[i]);
		for(double x=-range;x<=range;x+=resol){
			int section = (int)(.1+(x+range)/resol);
			for(int i=0;i<obj.length;i++)
			obj[i][0][section] = x;
			obj[0][1][section] = x<=.767?-Math.sqrt(100-(x*x)):((17*x*x)-400)/(51*x);
			obj[0][2][section] = 0;
			obj[1][1][section] = x<=-.767?((17*x*x)-400)/(51*x):Math.sqrt(100-(x*x));
			obj[1][2][section] = 0;
			double y1 = obj[1][1][section],y2 = obj[0][1][section],base = (obj[1][1][section])-(obj[0][1][section]),height = base*Math.sin(Math.PI*(x+range)/(4*range));
			obj[2][1][section] = obj[1][1][section]-base*Math.cos(Math.PI*(x+range)/(4*range));
			obj[2][2][section] = height;
			double Area=height*base/2,Volume=Area*resol;
			tv+=Volume;
			double[] nums = {section+1,x,resol,y1,y2,base,height,Area,Volume};
			for(int i=0;i<nums.length;i++)
			val[section+1][i].setText(" "+(new BigDecimal(nums[i])).round(new MathContext(3)));
		}
		val[sections.getValue()+3][7].setText(" Volume: ");
		val[sections.getValue()+3][8].setText(""+(new BigDecimal(tv)).round(new MathContext(6)));
		double error = 100*(tv-748.822)/748.822;
		val[sections.getValue()+5][1].setText(" Integral: ");
		val[sections.getValue()+5][2].setText(""+748.822);
		val[sections.getValue()+5][4].setText("LRAM: ");
		val[sections.getValue()+5][5].setText(""+(new BigDecimal(tv)).round(new MathContext(6)));
		val[sections.getValue()+5][7].setText(" % Error: ");
		val[sections.getValue()+5][8].setText((new BigDecimal(error)).round(new MathContext(3))+"%");
	}
	
	public double equate(String equation, double x){
		return 1;
	}

	public static void main(String[] args) throws InterruptedException,
			FileNotFoundException {
		solid window = new solid();
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
		public void paint(Graphics p) {
			center = (this.getWidth() / 2) + xMoved;
			center2 = (this.getHeight() / 2) + yMoved;
			p.setColor(Color.white);
			p.fillRect(0,0,(int)center*2, (int)center2*2);
			boolean Ao[] = {angleV>=0,angleH>=Math.PI/2 && angleH<=3*Math.PI/2,angleH>=Math.PI};
			if(Ao[0])
				axis(p);
				int[][][] poly = new int[5*obj[0][0].length][2][4];
				for(int i=0;i<obj[0][0].length;i++){
					for(int a=0;a<3;a++)
						for(int b=0;b<5;b+=4){
							poly[5*i+b][0][a] = (int) (center + (zoom * getXY(obj[a][0][i]+(b>0?resol:0),obj[a][1][i],obj[a][2][i],true)));
							poly[5*i+b][1][a] = (int) (center2 + (zoom * getXY(obj[a][0][i]+(b>0?resol:0),obj[a][1][i],obj[a][2][i],false)));
						}
					
					for(int b=1;b<4;b++)
					for(int a=0;a<4;a++){
							poly[5*i+b][0][a] = (int) (center + (zoom * getXY(obj[b<3?(b-1+(a/2)):(a>1?0:b-1)][0][i]+(a==1||a==2?resol:0),obj[b<3?(b-1+(a/2)):(a>1?0:b-1)][1][i],obj[b<3?(b-1+(a/2)):(a>1?0:b-1)][2][i],true)));
							poly[5*i+b][1][a] = (int) (center2 + (zoom * getXY(obj[b<3?(b-1+(a/2)):(a>1?0:b-1)][0][i]+(a==1||a==2?resol:0),obj[b<3?(b-1+(a/2)):(a>1?0:b-1)][1][i],obj[b<3?(b-1+(a/2)):(a>1?0:b-1)][2][i],false)));
						}
					
				}
				int[] order = {Ao[0]?(Ao[1]?4:0):(Ao[2]?3:2),Ao[0]?1:(Ao[1]?4:0),Ao[0]?(Ao[2]?3:2):(Ao[1]?0:4),Ao[2]?2:3,Ao[0]?(Ao[1]?0:4):1};
				for(int i=0;i<obj[0][0].length;i++)
					for(int j=0;j<5;j++){
					int col = 150+15*order[j];
					int sec = Ao[1]?5*(obj[0][0].length-i-1)+order[j]:5*i+order[j];
					p.setColor(new Color(col,col,col));
					p.fillPolygon(poly[sec][0], poly[sec][1], order[j]==0||order[j]==4?3:4);
					p.setColor(Color.black);
					p.drawPolygon(poly[sec][0], poly[sec][1], order[j]==0||order[j]==4?3:4);
					}
				if(!Ao[0])
					axis(p);
				if(showHelp)
					helper(p);
				else
					shown = false;
		}
		
		public void helper(Graphics p){
			p.setColor(Color.blue);
			p.drawString("Drag the mouse to move",(int) (2*center-300), 20);
			p.drawString("Scroll to zoom",(int) (2*center-300), 40);
			p.drawString("The help button is pointless",(int) (2*center-300), 60);
			p.drawString("This is super easy to use",(int) (2*center-300), 80);
			p.drawString("I'm gonna miss you Ms. Decarolis!!",(int) (2*center-300), 100);
			shown = true;
		}
		
	}

	public double getXY(double x, double y, double z, boolean XY) {
		x += .0001;
		y += .0001;
		z += .0001;
		x *= 10;
		y *= 10;
		z *= -10;
		
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
		if (Math.abs(arg0.getWheelRotation()) > 0)
		dragging = true;
		else
			dragging = false;
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
		X += .000001;
		Y += .000001;
		Z += .000001;
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
			dragging = true;
			showHelp = true;
			help.setText("Close");
		}
		if(arg0.getSource() == help && showHelp && shown){
			dragging = true;
			showHelp = false;
			help.setText("Help");
		}
			
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		curX = e.getPoint().x;
		curY = e.getPoint().y;
		if (dragging) {
			int Dx = curX - iX, Dy = curY - iY;
			angleH = ((double) Math.PI * (Dx) / 720) + curH;
			angleV = ((double) Math.PI * (Dy) / 720) + curV;
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
		if(e.getSource()==sections){
		dragging = true;
			defineSections();
		dragging = false;
		}
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


}