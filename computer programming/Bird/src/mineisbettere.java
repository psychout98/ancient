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

public class mineisbettere extends JFrame implements KeyListener {
	JPanel game = new Gamepanel();
	static int  yplayer = 250, score=0,background,xblocks[]=new int[100],blocks[]=new int[100],blocks2[]=new int[100];
	static boolean right = false,restart=false, left = false, up = false, down = false,block[]=new boolean[100],loser=false;

	mineisbettere() throws InterruptedException {
		setSize(getMaximumSize());
		setResizable(false);
		setVisible(true);
		add(game, BorderLayout.CENTER);
		addKeyListener(this);
		this.addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent arg0) {
			}

			@Override
			public void windowClosed(WindowEvent arg0) {System.exit(0);
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
			}
			
		});
		background=getHeight();
		while (true) {
			if(!loser){
			for(int j=0;j<2;j++){
			if(up)
				yplayer--;
			if(down)
				yplayer++;
				
				for(int i=0;i<99;i++){
					if(xblocks[i]<=260&& xblocks[i]>=250)
						if(yplayer<blocks[i]||yplayer+10>blocks2[i])
						loser=false;
				if(xblocks[i]<=400)
					block[i+1]=true;
				if(xblocks[i]==251)
					score++;
				}
					
			Thread.sleep(5);
			repaint();
			}

			background--;
			}
		}
	}

	

	public static void main(String[] args) throws InterruptedException {
		
		Random rand=new Random();
		blocks[0]=rand.nextInt(480)+10;
		blocks2[0]=blocks[0]+20;
		xblocks[0]=480;
		block[0]=true;
		for(int i=1;i<100;i++){
			block[i]=false;
			blocks[i]=rand.nextInt(200)+blocks[i-1]-40;
			blocks2[i]=blocks[i]+20;
			while(blocks2[i]>490){
				blocks[i]=rand.nextInt(200)+blocks[i-1]-40;
				blocks2[i]=blocks[i]+20;
			}
		}
		
		mineisbettere window = new mineisbettere();
		window.setDefaultCloseOperation(3);
			
	}

	private class Gamepanel extends JPanel {

		public void paintComponent(Graphics p) {
			p.setColor(Color.BLACK);
			p.fillRect(0, 0, getHeight(), getWidth());
			p.setColor(Color.white);
			p.setFont(new Font("Times New Roman",Font.BOLD,30));
			p.drawString(""+score, 30, 10);
			for(int i=0;i<100;i++){
				if(block[i]&&!loser){
				xblocks[i]=background+i*100;
				p.setColor(Color.RED);
				p.drawLine(xblocks[i],0,xblocks[i],blocks[i]);
				p.drawLine(xblocks[i],500,xblocks[i],blocks2[i]);
				}
			}
			p.setColor(Color.green);
			p.fillRect(250, yplayer, 10, 10);
			p.drawRect(250, yplayer, 10, 10);
		if(loser)
			p.drawString("LOL u suk", 200, 240);
		}

		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		if (arg0.getKeyCode() == KeyEvent.VK_UP)
			up = true;
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN)
		down = true;

if(arg0.getKeyCode()==KeyEvent.VK_ESCAPE)
	System.exit(0);
if(arg0.getKeyCode()==KeyEvent.VK_R)
	restart=true;

	}

	@Override
	public void keyReleased(KeyEvent arg0){
		
		if (arg0.getKeyCode() == KeyEvent.VK_UP)
			up = false;
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN)
			down = false;
		}
	

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
