import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class chaos extends JFrame implements ActionListener{

	int W=1100,H=600, time =0;
	double speed=1, G = 67,cGx,cGy;
	JPanel panel;
	JButton upspeed,downspeed,pause;
	Random r = new Random();
	boolean stopped = false;
	double[][] m = new double[2][11]; // x,y,z,vx,vy,vz,size,r,g,b,mass,agx,agy,agz
	int[][][] trails = new int[m.length][0][2];
	
	chaos() throws InterruptedException{
		super("");
		this.setSize(W, H+80);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setVisible(false);
		JPanel control = new JPanel();
		panel = new graphic();
		upspeed = new JButton("Higher Speed");
		downspeed = new JButton("Lower Speed");
		pause = new JButton("Pause");
		upspeed.addActionListener(this);
		downspeed.addActionListener(this);
		pause.addActionListener(this);
		control.add(upspeed);
		control.add(downspeed);
		control.add(pause);
		this.add(panel,BorderLayout.CENTER);
		this.add(control,BorderLayout.NORTH);
		this.setVisible(true);
		for(int i=0;i<m.length;i++){
			m[i][2] = r.nextInt(200)-100;
			m[i][3] = r.nextInt(200)-100;
			m[i][4] = r.nextInt(35)+20;
			m[i][5] = r.nextInt(255);
			m[i][6] = r.nextInt(255);
			m[i][7] = r.nextInt(255);
			m[i][8] = r.nextInt(20)+20;
			m[i][9] = 0;
			m[i][10] = 0;
			m[i][0] = r.nextInt(W-2*(int)m[i][4])+m[i][4];
			m[i][1] = r.nextInt(H-2*(int)m[i][4])+m[i][4];
			if(i>0)
			for(int j=0;j<i-1;j++){
				while(colliding(m[i],m[j])){
					m[i][0] = r.nextInt(W-2*(int)m[i][4])+m[i][4];
					m[i][1] = r.nextInt(H-2*(int)m[i][4])+m[i][4];
					j=0;
				}
			}
		}
		while(true){
			if(pause.getText().equals("Play"))
				stopped=true;
			if(pause.getText().equals("Pause"))
				stopped=false;
			while(stopped){
				if(pause.getText().equals("Pause"))
					stopped=false;
			}
			for(int i=0;i<34;i++){
			go();
			Thread.sleep(1);
			}
			repaint();
			time++;
		}
	}
	
	public void go(){
		double MM[][] = new double[m.length][2];
		for(int i=0;i<m.length;i++){
			m[i][9] = 0;
			m[i][10] = 0;
			if(m[i][0]>W-m[i][4]){
				m[i][0]=W-m[i][4];
				m[i][2] *=-1;
			}
				if(m[i][0]<m[i][4]){
					m[i][0]=m[i][4];
				m[i][2] *=-1;
			}
			if(m[i][1] > H-m[i][4]){
				m[i][1] = H-m[i][4];
				m[i][3] *=-1;
			}
				if(m[i][1]<m[i][4]){
					m[i][1] = m[i][4];
				m[i][3] *=-1;
			}
			MM[i][0]=m[i][2];
			MM[i][1]=m[i][3];
			for(int j=0;j<m.length;j++){
				if(j!=i){
					if(colliding(m[i],m[j])){
						if(Math.sqrt(m[i][2]*m[i][2]+m[i][3]*m[i][3])+Math.sqrt(m[j][2]*m[j][2]+m[j][3]*m[j][3])<(m[i][4]+m[j][4])){
							combine(m[i],m[j]);
						}
						else{
					MM[i][0]=(m[i][2]*(m[i][8]-m[j][8])/(m[i][8]+m[j][8]))+(m[j][2]*2*m[j][8]/(m[i][8]+m[j][8]));
					MM[i][1]=(m[i][3]*(m[i][8]-m[j][8])/(m[i][8]+m[j][8]))+(m[j][3]*2*m[j][8]/(m[i][8]+m[j][8]));
				//	for(int k=5;k<8;k++)
				//		m[i][k]=(m[i][k]+m[j][k])/2;
				}
					}
					m[i][9]+= G*m[j][8]*(m[j][0]-m[i][0])/Math.pow(Math.sqrt(Math.pow(m[i][0]-m[j][0],2)+Math.pow(m[i][1]-m[j][1],2)),3);
					m[i][10]+= G*m[j][8]*(m[j][1]-m[i][1])/Math.pow(Math.sqrt(Math.pow(m[i][0]-m[j][0],2)+Math.pow(m[i][1]-m[j][1],2)),3);
				}
			}
			MM[i][0]+=(m[i][9]/(speed));
			MM[i][1]+=(m[i][10]/(speed));
		}
		for(int i=0;i<m.length;i++){
			m[i][2] = MM[i][0];
			m[i][3] = MM[i][1];
			m[i][0]+=m[i][2]/(1000*speed);
			m[i][1]+=m[i][3]/(1000*speed);
		}
	}
	
	public boolean colliding(double[] m1, double[] m2){
		return Math.sqrt(((m1[0]-m2[0])*(m1[0]-m2[0]))+((m1[1]-m2[1])*(m1[1]-m2[1])))<=(m1[4]+m2[4]);
	}
	
	public void combine(double[] m1, double[] m2){
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		chaos window = new chaos();
	}

	public class graphic extends JPanel{
		
		public void paint(Graphics p){
			p.setColor(Color.white);
			p.fillRect(0, 0, W, H);
			for(int i=0;i<m.length;i++){
	/*			int[][] trail = new int[time+1][2];
				for(int j=0;j<time;j++)
				trail[j] = trails[i][j];
				trail[time][0] = (int)(m[i][0]);
				trail[time][1] = (int)(m[i][1]);
				trails[i] = trail;
				for(int j=0;j<time+1;j++)
					p.fillOval(trail[j][0],trail[j][1],3,3);*/
		//		p.drawString(i+"", (int)(m[i][0]-(m[i][4])), (int)(m[i][1]-(m[i][4])));
				p.setColor(new Color((int)(m[i][5]),(int)(m[i][6]),(int)(m[i][7])));
				p.fillOval((int)(m[i][0]-(m[i][4])/*-cGx+W/2*/), (int)(m[i][1]-(m[i][4])/*-cGy+H/2*/), 2*(int)(m[i][4]), 2*(int)(m[i][4]));
				cGx = 0;
				cGy = 0;
				for(int j=0;j<m.length;j++){
				cGx+=m[j][0];
				cGy+=m[j][1];
				}
				cGx/=m.length;
				cGy/=m.length;
				p.setColor(Color.red);
				p.fillOval((int)cGx, (int)cGy, 5, 5);
				/*
				for(int j=0;j<m.length;j++)
				p.drawLine((int)(m[i][0]), (int)(m[i][1]), (int)(m[j][0]), (int)(m[j][1]));
				*/
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == upspeed)
			speed/=2;
		if(e.getSource() == downspeed)
			speed*=2;
		if(e.getSource() == pause && !stopped){
			pause.setText("Play");
		}
		if(e.getSource() == pause && stopped){
			pause.setText("Pause");
		}
	}
}
