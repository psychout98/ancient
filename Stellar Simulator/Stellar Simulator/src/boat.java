import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class boat extends JFrame
		implements ActionListener, KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

	JPanel centerPanel, menuPanel;
	int fX, fY, iX, iY;
	double angleH = 0, angleV = 0, X = 10, Y = 0, Z = 0; //position variables
	double curH,curV,curX,curY,curZ;
	boolean dragging = false,dragAngle = true,dragPosition=false;
	JButton pDrag,aDrag;
	JTextPane vars;

	boat() throws InterruptedException {
		super("3D graphic");
		this.setSize(1000, 700);
		this.setVisible(false);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		centerPanel = new graphic();
		centerPanel.addMouseListener(this);
		centerPanel.addMouseMotionListener(this);
		this.addKeyListener(this);
		menuPanel = new JPanel();
		setMenuPanel();
		JMenuBar mb = new JMenuBar();
		JMenu file = new JMenu("File");
		mb.add(file);
		this.setJMenuBar(mb);
		this.add(menuPanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.setVisible(true);
		while (true) {
			vars.setText("angleV: "+(int)(angleV*180/Math.PI)+"\nangleH: "+(int)(angleH*180/Math.PI)+"\nX: "+X+"\tY: "+Y+"\tZ: "+Z);
			Thread.sleep(42);
			repaint();
		}
	}

	public void setMenuPanel() {
		menuPanel.setLayout(new GridLayout(1, 15)); //
		menuPanel.setPreferredSize(new Dimension(1000, 65));
		pDrag = new JButton("Drag Postition");
		aDrag = new JButton("Drag Angles");
		pDrag.addActionListener(this);
		aDrag.addActionListener(this);
		vars = new JTextPane();
		vars.setEditable(false);
		menuPanel.add(pDrag);
		menuPanel.add(aDrag);
		menuPanel.add(vars);
	}

	public static void main(String[] args) throws InterruptedException {
		boat window = new boat();
	}

	public class graphic extends JPanel {

		public void paint(Graphics p) {
			setSize(1000, 600);
			p.setColor(Color.gray);
			p.fillRect(0, 0, 1000, 600);
			p.setColor(Color.white);
			p.fillRect(0, 0, 200, 200);
			p.setColor(Color.black);
			p.drawLine(0, 100, 200, 100);
			p.drawLine(100, 0, 100, 200);
			p.drawLine((int)(X/10)+100, (int)(Y/10)+100, (int)(X/10 + 10*Math.cos(angleH))+100, (int)(Y/10 + 10*Math.sin(angleH))+100);
			p.drawOval((int)(X/10)+99, (int)(Y/10)+99, 2, 2);
			
			double[][] box = {{-5,-5,5},{-5,5,5},{-5,5,-5},{-5,-5,-5},{5,-5,-5},{5,-5,5},{5,5,5},{5,5,-5}};
			for(int i=0;i<7;i++)
				drawLine(box[i],box[i+1],Color.black,p);
			drawLine(box[7],box[4],Color.black,p);
			drawLine(box[0],box[3],Color.black,p);
			drawLine(box[0],box[5],Color.black,p);
			drawLine(box[1],box[6],Color.black,p);
			drawLine(box[2],box[7],Color.black,p);
		}

		
		public void drawLine(double[] p1, double[] p2, Color c, Graphics p){
			p.setColor(c);
			p.drawLine(500+getXYZ(p1[0],p1[1],p1[2],0), 300+getXYZ(p1[0],p1[1],p1[2],1), 500+getXYZ(p2[0],p2[1],p2[2],0), 300+getXYZ(p2[0],p2[1],p2[2],1));
		}
		
		public void Polygon(double[][] pts, Color c, Graphics p, boolean fill){
			int Points[][] = new int[2][pts.length];
			for(int i=0;i<pts.length;i++){
				Points[0][i] = 500 + getXYZ(pts[i][0],pts[i][1],pts[i][2],0);
				Points[1][i] = 300 + getXYZ(pts[i][0],pts[i][1],pts[i][2],1);
			}
			if(fill)
				p.fillPolygon(Points[0], Points[1], pts.length);
			else
				p.drawPolygon(Points[0], Points[1], pts.length);
		}

		public int getXYZ(double x, double y, double z, int XYZ) {
			x = ((10*x) - X);
			y = ((10*y) - Y);
			z = ((10*z) - Z);
			return XYZ == 0 ? (int) (y) : XYZ == 1 ? (int) (z) : (int) (x);
		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {
		iX = arg0.getPoint().x;
		iY = arg0.getPoint().y;
		if(dragAngle){
			curH = angleH;
			curV = angleV;
		}
		if(dragPosition){
			curX = X;
			curY = Y;
			curZ = Z;
		}
		dragging = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		dragging = false;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		}
	@Override
	public void keyTyped(KeyEvent arg0) {}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == aDrag){
			dragPosition = false;
			dragAngle = true;
		}
		if(arg0.getSource() == pDrag){
			dragAngle = false;
			dragPosition = true;
		}
	}
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() < 0){
			
		}
		if (e.getWheelRotation() > 0){
			
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		fX = e.getPoint().x;
		fY = e.getPoint().y;
		if (dragging) {
			int Dx = fX - iX, Dy = fY - iY;
			double Mag = Math.sqrt(Dx*Dx + Dy*Dy);
			if(dragAngle){
				angleH = curH - ((double) Math.PI * (Dx) / 720);
				if(angleV <= Math.PI/2 && angleV >= -Math.PI/2)
				angleV = curV - ((double) Math.PI * (Dy) / 720);
			}
			if(dragPosition){
				
			}
		}
		}
	

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

}
