import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Galaga extends JFrame implements KeyListener {
	static Random rand = new Random();
	JPanel game;
	static int starx[]=new int[60],stary[]=new int[60],xplayer = 250, xshot, yshot,xshot2,yshot2, xenemy[] = new int[100],
			yenemy[] = new int[100], c[] = new int[3], xenemyshot, yenemyshot, score = 0, level, randx[] = new int[50],xboom,yboom,
			randy[] = new int[50],size1=15,size2=10;
	static boolean shot = false,shot2=false, enemy[] = new boolean[100], enemyshot = false,
			loser = false, exit = false,right=false,left=false,slow=false,boom, start=false,directions=false;

	Galaga() throws InterruptedException {
		init();
		this.setSize(600, 800);
		this.setResizable(false);
		this.setVisible(true);
		this.add(game);
		this.addKeyListener(this);
		while (true) {
			if(!start){
			repaint();
			Thread.sleep(50);
			}
			if(start){
			if(boom){
				size1--;
				size2--;
				if(size1<=0&&size2<=0){
					boom=false;
					size1=15;
					size2=10;
				}
			}
			for (int w = 0; w < 11; w++) {
			
				for(int p=0;p<5;p++){
			

				level = (score / 100) + 1;
				if (shot)
					yshot--;
				if (yshot < 75) {
					yshot = 490;
					shot = false;
				}
				if (shot2)
					yshot2--;
				if (yshot2 < 75) {
					yshot2 = 490;
					shot2 = false;
				}
				if (xplayer > 570)
					xplayer = 0;
				if (xplayer < 0)
					xplayer = 570;
				
				
				
				for (int i = 0; i < 100; i++) {
					
					if ((xshot2 >= xenemy[i] && xshot2 <= xenemy[i] + 15
							&& yshot2 == yenemy[i])) {
						xboom=xenemy[i];
						yboom=yenemy[i];
						boom=true;
						yenemy[i]=-30;
						shot2=false;
						yshot2=490;
						score = score + 10;
					}
					if ((xshot >= xenemy[i] && xshot <= xenemy[i] + 15
							&& yshot == yenemy[i])) {
						xboom=xenemy[i];
						yboom=yenemy[i];
						boom=true;
						yenemy[i]=-30;
						shot=false;
						yshot=490;
						score = score + 10;
					}
					
					if (yenemy[i] >= 650)
						loser = true;
				}
				for (int spawn = 0; spawn < 99; spawn++) {
					if (yenemy[spawn] >= 75) {
						enemy[spawn + 1] = true;
					}
					if(spawn==98)
						enemy[0]=true;
					
				}
				Thread.sleep(1);
				repaint();
				
			}
			if(right){
				if(slow)
					xplayer=xplayer+1;
				else
				xplayer=xplayer+2;
			}
			if(left){
				if(slow)
					xplayer=xplayer-1;
				else
				xplayer=xplayer-2;
			}
		}
			for (int i = 0; i < 100; i++) 
				if (enemy[i])
					yenemy[i]++;
				
			
			}
			
		}
	}
	

	public void init() {
		game = new Gamepanel();
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			yenemy[i] = -10;
			xenemy[i] = rand.nextInt(500) + 35;
			for(int j=0;j<i;j++)
				while(xenemy[j]==xenemy[i])
					xenemy[j]=rand.nextInt(500)+35;
			enemy[i] = false;
		}
		for(int i=0;i<60;i++){
			starx[i]=rand.nextInt(570);
			stary[i]=rand.nextInt(750);
			
		}
		enemy[0]=true;
		yenemy[0]=75;
		Galaga window = new Galaga();
		
				
		

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
			p.drawLine(0,75,600,75);
			p.drawRect(xplayer, 700, 10, 10);
			p.setColor(Color.RED);
			p.drawLine(0, 650, 600, 650);
			if(!start){
			p.drawString("To start, press space", 100, 300);
			if(!directions)
			p.drawString("Press d for directions", 100, 600);
			if(directions){
			p.drawString("To shoot, press space or up", 100, 350);
			p.drawString("To move, press left and right", 100, 400);
			p.drawString("Keep the enemies behind th red line", 100, 450);
			p.drawString("As the levels get higher,", 100, 500);
			p.drawString("more enemies will appear on", 100, 550);
			p.drawString("the screen at once", 100, 600);
			}
                
			}
			for(int i=0;i<60;i++){
				p.setColor(Color.white);
				p.fillOval(starx[i], stary[i], 3, 3);
			}
			if(start){
			if (shot) {

				p.setColor(Color.RED);
				p.fillRect(xshot, yshot, 2, 20);
				p.setColor(Color.blue);
				p.drawRect(xshot, yshot, 3, 20);
			}
			if (shot2) {

				p.setColor(Color.RED);
				p.fillRect(xshot2, yshot2, 2, 20);
				p.setColor(Color.blue);
				p.drawRect(xshot2, yshot2, 3, 20);
			}
			if(boom){
				p.setColor(Color.RED);
				p.fillRect(xboom, yboom, size1, size2);
			}
			for (int i = 0; i < 100; i++) {
				if (enemy[i]) {
					p.setColor(Color.green);
					p.fillRect(xenemy[i], yenemy[i], 15, 10);
					p.setColor(Color.blue);
					p.drawRect(xenemy[i], yenemy[i], 15, 10);
			}
			}
			if (loser) {
				p.setColor(Color.RED);
				p.setFont(f);
				p.drawString("YOU LOSE :(", 100, 300);
				
			}
			
		}
	}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
if(!loser){
		if(!start){
			if(arg0.getKeyCode()==KeyEvent.VK_SPACE)
				start=true;
		}
			
		if(start){
			if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
				left=true;
			}
			if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
				right=true;
			}

			if ((arg0.getKeyCode() == KeyEvent.VK_UP || arg0.getKeyCode() == KeyEvent.VK_SPACE)
					&& shot == false&&shot2==false) {
				xshot = xplayer + 4;
				yshot = 690;
				shot = true;
			}

			if ((arg0.getKeyCode() == KeyEvent.VK_UP || arg0.getKeyCode() == KeyEvent.VK_SPACE)
					&& shot == true&&shot2==false&&yshot<600){
				xshot2 = xplayer + 4;
				yshot2 = 690;
				shot2 = true;
			}
		
	if(arg0.getKeyCode()==KeyEvent.VK_SHIFT)
		slow=true;
		}
}
if(arg0.getKeyCode()==KeyEvent.VK_D)
	directions=true;
if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE)
	System.exit(0);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		if(start){
			if (arg0.getKeyCode() == KeyEvent.VK_LEFT) 
				left=false;
			if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) 
				right=false;
			if(arg0.getKeyCode()==KeyEvent.VK_SHIFT)
				slow=false;
		}
		

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
