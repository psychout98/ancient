import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class superscatter extends JFrame implements ActionListener,
MouseWheelListener, MouseListener, MouseMotionListener,ChangeListener,KeyListener{
	
	college[] c = {new college("Boston University",4.26,3.59,620,730,570,680,0.33,17932,391,false,48436,39436,51),
					new college("Case Western",4.34,3.66,620,720,540,660,0.36,5121,295,false,46006,39095,41),
					new college("UC Boulder",3.85,3.23,540,660,530,640,0.8,27010,1000,true,35079,15331,36),
					new college("Cooper Union",4.2,3.55,610,720,630,790,13,899,250,false,43850,39589,0)};
	int[][] C = {{0,0,255},{255,0,0},{0,255,0},{255,255,0}};
	JPanel panel = new graphic(),left = new JPanel(),right = new JPanel(),top = new JPanel(),bottom = new JPanel();
	
	
	superscatter() throws InterruptedException{
		super("College Lister");
		this.setSize(1100, 800);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(3);
		this.addKeyListener(this);
		this.addMouseWheelListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		left.setLayout(new GridLayout(c.length,1));
		JRadioButton rb[] = new JRadioButton[c.length];
		for(int i=0;i<c.length;i++){
			rb[i] = new JRadioButton(c[i].name);
			left.add(rb[i]);
		}
		left.setSize(90,800);
		right.setSize(90, 800);
		top.setSize(920,100);
		bottom.setSize(920, 100);
		this.add(panel,BorderLayout.CENTER);
		this.add(left,BorderLayout.WEST);
		this.add(right,BorderLayout.EAST);
		this.add(top,BorderLayout.NORTH);
		this.add(bottom,BorderLayout.SOUTH);
		this.setVisible(true);
		while(true){
			Thread.sleep(1000);
			repaint();
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		superscatter window = new superscatter();
	}
	
	public class graphic extends JPanel{
	
	public void paint(Graphics p) {
		setSize(920, 600);
		p.setFont(new Font("Helvetica",Font.BOLD,12));
		p.setColor(Color.white);
		p.fillRect(0, 0, 920, 600);
		p.setColor(Color.black);
		p.drawLine(50, 0, 50, 600);
		p.drawLine(0, 558, 920, 558);
		for (int i = 0; i < 25; i++) {
			p.setColor(Color.gray);
			p.drawLine(50, 8 + (22 * i), 920, 8 + (22 * i));
			p.setColor(Color.black);
			p.drawString(String.valueOf((double) (i + 1) / 5), 25, 540 - (22 * i));
		}
		for (int i = 1; i < 41; i++) {
			p.setColor(Color.gray);
			p.drawLine(50 + (i * 850 / 40), 0, 50 + (i * 850 / 40), 558);
			if (i % 2 != 0) {
				p.setColor(Color.black);
				p.drawString(String.valueOf((i + 1) * 40), 60 + (i * 850 / 40), 570);
			}
		}
		for(int i=0;i<c.length;i++){
			p.setColor(new Color(C[i][0],C[i][1],C[i][2],100));
			p.fillOval(50+(int)(850.0*(c[i].ml+c[i].rl)/1600.0), 558-(int)(110.0*(2*c[i].wgpa-c[i].gpa)), (int)(850.0*(c[i].mh+c[i].rh-c[i].ml-c[i].rl)/1600.0), (int)(220.0*(c[i].wgpa-c[i].gpa)));
		//	p.setColor(new Color(C[i][0],C[i][1],C[i][2],100));
		//	p.drawOval(50+(int)(850.0*(c[i].ml+c[i].rl)/1600.0), 558-(int)(110.0*(2*c[i].wgpa-c[i].gpa)), (int)(850.0*(c[i].mh+c[i].rh-c[i].ml-c[i].rl)/1600.0), (int)(220.0*(c[i].wgpa-c[i].gpa)));
		}
		for(int i=0;i<c.length;i++){
			p.setColor(new Color(255-C[i][0],255-C[i][1],255-C[i][2]));
			p.drawString(c[i].name, 60+(int)(850.0*(c[i].ml+c[i].rl+c[i].mh+c[i].rh)/3200.0)-(int)(3.7*c[i].name.length()), 563-(int)(110.0*c[i].wgpa));
		}
		p.setColor(Color.red);
		p.fillOval(40+(int)(850.0*1420.0/1600.0), 558-(int)(110.0*3.34), 20, 20);
		p.setColor(Color.black);
		p.drawString("ME", 41+(int)(850.0*1420.0/1600.0), 573-(int)(110.0*3.34));
	}

	}
	
	public class college {

		int ml,mh,rl,rh,size,dist,price,finance,usnews;
		double gpa,wgpa,acc;
		String name;
		boolean pub;
		
		college(String Name,double WGPA,double GPA, int MathLow,int MathHigh, int ReadingLow, int ReadingHigh,double Acceptance,int Size,int Distance,boolean Public,int Tuition,int Finance,int USNewsRank){
			name = Name;
			ml=MathLow;
			mh=MathHigh;
			rl=ReadingLow;
			rh=ReadingHigh;
			gpa = GPA;
			wgpa = WGPA;
			acc = Acceptance;
			size=Size;
			dist=Distance;
			pub=Public;
			price=Tuition;
			finance=Finance;
			usnews=USNewsRank;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
