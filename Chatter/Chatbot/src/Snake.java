import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snake extends JFrame implements KeyListener {

	JPanel gamePanel;
	boolean right = false, left = false, up = false, down = false, Z = true, wasLeft = false, wasRight = false, wasUp = false, wasDown = false;
	int X[] = { 250, 225, 200 }, Y[] = { 250, 250, 250 },on=3;

	Snake() throws InterruptedException {
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(3);
		gamePanel = new paintComponent();
		this.add(gamePanel);
		this.addKeyListener(this);
		this.setSize(500, 500);
		while (true) {
			
			
			
			if (right) {
				X[0]+=25;
			}
			if (left) {
				X[0] -= 25;
			}
			if (up) {
				Y[0] -= 25;
			}
			if (down) {
				Y[0] += 25;
			}
			
			
			
			if (X[0] <= 0 || X[0] >= 475 || Y[0] <= 0 || Y[0] >= 450) {
				up = false;
				down = false;
				right = false;
				left = false;
			}
			repaint();
			Thread.sleep(100);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Snake window = new Snake();
	}

	public void keyPressed(KeyEvent arg0) {

		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT && !left && X[0]<475) {
			up = false;
			down = false;
			right = true;
			wasRight = true;
			wasLeft = false;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_LEFT && !right && X[0]>0) {
			up = false;
			down = false;
			left = true;
			wasLeft = true;
			wasRight = false;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_UP && !down&&Y[0]>0) {
			left = false;
			right = false;
			up = true;
			wasUp = true;
			wasDown = false;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN && !up&&Y[0]<450) {
			left = false;
			right = false;
			down = true;
			wasDown = true;
			wasUp = false;
		}
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}

	public class paintComponent extends JPanel {
		public void paint(Graphics g) {
			setSize(500, 500);
			for(int i=0;i<on;i++)
			g.fillRect(X[i], Y[i], 20, 20);
		}
	}
}