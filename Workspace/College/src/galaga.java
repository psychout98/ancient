import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class galaga extends JFrame implements KeyListener {
	static Random rand = new Random();
	JPanel game;
	static int xplayer = 250, xshot, yshot, xenemy[] = new int[100],
			yenemy[] = new int[100], c[] = new int[3], xenemyshot, yenemyshot,
			enemyspeed = 11, score = 0, level, randx[] = new int[50],
			randy[] = new int[50];
	static boolean shot = false, enemy[] = new boolean[100], enemyshot = false,
			loser = false, exit = false,right=false,left=false;

	galaga() throws InterruptedException {
		super("GUI game");
		init();
		this.setSize(600, 800);
		this.setVisible(true);
		this.add(game);
		this.addKeyListener(this);
		while (true) {
			for (int w = 0; w < enemyspeed; w++) {
				for(int p=0;p<5;p++){
				level = (score / 100) + 1;
				if (shot)
					yshot--;
				if (yshot < 0) {
					yshot = 490;
					shot = false;
				}
				if (xplayer > 570)
					xplayer = 0;
				if (xplayer < 0)
					xplayer = 570;
				for (int i = 0; i < 100; i++) {
					if (xshot >= xenemy[i] && xshot <= xenemy[i] + 10
							&& yshot == yenemy[i]) {
						yenemy[i] = -10;
						xenemy[i] = -10;
						enemy[i] = false;
						shot = false;
						score = score + 10;
					}
					if (yenemy[i] >= 650)
						loser = true;
				}
				for (int spawn = 0; spawn < 100; spawn++) 
					if (yenemy[spawn] >= 50) {
						enemy[spawn + 1] = true;
					}
				
					
				Thread.sleep(1);
				repaint();
				
			}
			if(right)
				xplayer++;
			if(left)
				xplayer--;
		}
			for (int i = 0; i < 100; i++) 
				if (enemy[i])
					yenemy[i]++;
			if(level==1)
				enemyspeed=25;
			if(level==2)
				enemyspeed=24;
			if(level==3)
				enemyspeed=23;
			if(level==4)
				enemyspeed=22;
			if(level==5)
				enemyspeed=21;
			if(level==6)
				enemyspeed=20;
			if(level==7)
				enemyspeed=19;
			if(level==8)
				enemyspeed=18;
			if(level==9)
				enemyspeed=17;
			if(level==10)
				enemyspeed=16;
		}
		}
	

	public void init() {
		game = new Gamepanel();
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			yenemy[i] = -10;
			xenemy[i] = rand.nextInt(500) + 20;
			enemy[i] = false;
		}
		enemy[0]=true;
		yenemy[0]=0;
		galaga window = new galaga();
		window.setDefaultCloseOperation(3);

	}

	private class Gamepanel extends JPanel {
		public void paintComponent(Graphics p) {

			Font f = new Font("Times New Roman", Font.BOLD, 30);
			Color Color = new Color(c[0], c[1], c[2]);
			p.setColor(Color);
			p.fillRect(0, 0, 600, 750);
			p.setColor(Color.WHITE);
			p.setFont(f);
			p.drawString("" + score, 40, 40);
			p.drawString("" + level, 560, 40);
			p.setColor(Color.BLUE);
			p.fillRect(xplayer, 700, 10, 10);
			p.setColor(Color.green);
			p.drawRect(xplayer, 700, 10, 10);
			p.setColor(Color.RED);
			p.drawLine(0, 650, 600, 650);
			if (shot) {

				p.setColor(Color.RED);
				p.fillRect(xshot, yshot, 2, 20);
				p.setColor(Color.blue);
				p.drawRect(xshot, yshot, 3, 20);
			}

			for (int i = 0; i < 100; i++) 
				if (enemy[i]) {
					p.setColor(Color.green);
					p.fillRect(xenemy[i], yenemy[i], 10, 10);
					p.setColor(Color.blue);
					p.drawRect(xenemy[i], yenemy[i], 10, 10);
			}
			if (loser) {
				p.setColor(Color.RED);
				p.setFont(f);
				p.drawString("YOU LOSE :(   press e", 100, 300);
				if (exit)
					System.exit(0);
			}

		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		if (!loser) {
			if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
				left=true;
			}
			if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
				right=true;
			}

			if ((arg0.getKeyCode() == KeyEvent.VK_UP || arg0.getKeyCode() == KeyEvent.VK_SPACE)
					&& shot == false) {
				xshot = xplayer + 4;
				yshot = 690;
				shot = true;
			}

			if ((arg0.getKeyCode() == KeyEvent.VK_UP || arg0.getKeyCode() == KeyEvent.VK_SPACE)
					&& shot == true)
				;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_E) {
			exit = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
			if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
				left=false;
			}
			if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
				right=false;
			}
		

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
