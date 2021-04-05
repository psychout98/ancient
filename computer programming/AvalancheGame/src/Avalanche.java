import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Avalanche extends JFrame implements KeyListener {
	JPanel game = new Gamepanel();
	static boolean jump=false,pull=true,left=false,right=false,box[]=new boolean[1000],boxpull[]=new boolean[1000],stop=false;
	static int xbox[]=new int[1000],ybox[]=new int[1000],xplayer=250,yplayer=250,air,ground=500;
	static Random rand = new Random();
	Avalanche() throws InterruptedException {
		this.setSize(600, 600);
		this.setResizable(false);
		this.setVisible(true);
		this.add(game, BorderLayout.CENTER);
		this.addKeyListener(this);
		while (true) {
			for(int i=0;i<1000;i++){
				if(yplayer+60>ybox[i]&&(xplayer>=xbox[i]-29&&xplayer<=xbox[i]+49)&&yplayer<ybox[i]+50||yplayer+60>ground)
					stop=true;
				for(int j=0;j<i;j++)
				if(ybox[i]+50>ybox[j])
					boxpull[i]=false;
				if(ybox[i]+50>ground)
					boxpull[i]=false;
			}
					if(pull)
						yplayer+=2;
					if(stop)
						yplayer-=2;
					if(left)
						xplayer-=2;
					if(right)
						xplayer+=2;
					if(jump){
						stop=false;
						yplayer-=8;
						air++;
					}
					for(int i=0;i<1000;i++)
					if(boxpull[i])
						ybox[i]++;
					if(xplayer+40==500)
					if(air==10){
						air=0;
						jump=false;
					}
			repaint();
			Thread.sleep(1);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		box[0]=true;
		xbox[0]=rand.nextInt(450);
		ybox[0]=-10;
		boxpull[0]=true;
		for(int i=1;i<1000;i++){
			box[i]=false;
			boxpull[i]=false;
			xbox[i]=rand.nextInt(450);
			ybox[i]=-10;
		}
		Avalanche window = new Avalanche();
		window.setDefaultCloseOperation(3);

	}

	private class Gamepanel extends JPanel {

		public void paintComponent(Graphics p) {
			p.setColor(Color.gray);
			p.fillRect(0, 0, 500, 500);
			p.setColor(Color.WHITE);
			p.fillRect(xplayer, yplayer, 40, 60);
			p.setColor(Color.black);
			p.fillRect(0, ground, 500, 100);
			for(int i=0;i<1000;i++)
				if(box[i]){
					p.setColor(Color.blue);
					p.fillRect(xbox[i], ybox[i], 50, 50);
				}
					
		}

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_UP&&!jump&&stop)
			jump=true;
		if(arg0.getKeyCode()==KeyEvent.VK_LEFT)
			left=true;
		if(arg0.getKeyCode()==KeyEvent.VK_RIGHT)
			right=true;
		


	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_LEFT)
			left=false;
		if(arg0.getKeyCode()==KeyEvent.VK_RIGHT)
			right=false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
