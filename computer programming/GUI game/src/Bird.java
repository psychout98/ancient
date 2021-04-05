import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bird extends JFrame implements KeyListener {
	JPanel game = new Gamepanel();
	static int xplayer = 250, yplayer = 490;
	static boolean right = false, left = false, up = false, down = false;

	Bird() throws InterruptedException {
		this.setSize(600, 800);
		this.setResizable(false);
		this.setVisible(true);
		this.add(game, BorderLayout.CENTER);
		this.addKeyListener(this);
		while (true) {
			if(up)
				yplayer--;
			if(down)
				yplayer++;
			if(right)
				xplayer++;
			if(left)
				xplayer--;
			if(xplayer>600)
				xplayer=0;
			if(xplayer<0)
				xplayer=600;
			if(yplayer>750)
				yplayer=0;
			if(yplayer<0)
				yplayer=750;
			Thread.sleep(1);
			repaint();
		}
	}

	

	public static void main(String[] args) throws InterruptedException {
		Bird window = new Bird();
		window.setDefaultCloseOperation(3);
	}

	private class Gamepanel extends JPanel {

		public void paintComponent(Graphics p) {
			p.setColor(Color.BLACK);
			p.fillRect(0, 0, 600, 750);
			p.setColor(Color.WHITE);
			p.fillRect(xplayer, yplayer, 10, 10);
			p.setColor(Color.green);
			p.drawLine(0, 75, 600, 75);
			p.drawRect(xplayer, yplayer, 10, 10);

		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		if (arg0.getKeyCode() == KeyEvent.VK_LEFT)
			left = true;

		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT)
			right = true;

		if (arg0.getKeyCode() == KeyEvent.VK_UP)
			up = true;

		if (arg0.getKeyCode() == KeyEvent.VK_DOWN)
			down = true;

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

		if (arg0.getKeyCode() == KeyEvent.VK_LEFT)
			left = false;

		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT)
			right = false;

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
