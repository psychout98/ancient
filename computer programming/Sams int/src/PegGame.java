import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import javax.swing.JOptionPane;

class IllegalPegException extends Exception {
	IllegalPegException(int peginx) {
	}
}

class PegColor {
	public final static Color BLACKEMPTY = new Color(0, 0, 0, 120);
}

class Rules {
	static int list[][] = { { 1, 2, 4 }, { 1, 3, 6 }, { 2, 4, 7 }, { 2, 5, 9 },
			{ 3, 5, 8 }, { 3, 6, 10 }, { 4, 2, 1 }, { 4, 5, 6 }, { 4, 8, 13 },
			{ 4, 7, 11 }, { 5, 8, 12 }, { 5, 9, 14 }, { 6, 3, 1 }, { 6, 5, 4 },
			{ 6, 9, 13 }, { 6, 10, 15 }, { 7, 4, 2 }, { 7, 8, 9 }, { 8, 5, 3 },
			{ 8, 9, 10 }, { 9, 5, 2 }, { 9, 8, 7 }, { 10, 6, 3 }, { 10, 9, 8 },
			{ 11, 7, 4 }, { 11, 12, 13 }, { 12, 8, 5 }, { 12, 13, 14 },
			{ 13, 12, 11 }, { 13, 8, 4 }, { 13, 9, 6 }, { 13, 14, 15 },
			{ 14, 9, 5 }, { 14, 13, 12 }, { 15, 10, 6 }, { 15, 14, 13 } };

	public static Vector getValidMoves(int peginx, MyCircle pegs[]) {
		Vector v = new Vector();
		int src, jmp, dst;
		for (int i = 0; i < list.length; ++i) {
			src = list[i][0];
			jmp = list[i][1];
			dst = list[i][2];
			if ((src == peginx)
					&& (pegs[src].getColor() != PegColor.BLACKEMPTY)
					&& (pegs[jmp].getColor() != PegColor.BLACKEMPTY)
					&& (pegs[dst].getColor() == PegColor.BLACKEMPTY))
				v.addElement(list[i]);
		}
		return v;
	}

	public static int getTarget(int source, int jumpee) {
		int target = 0;
		for (int i = 0; i < list.length; ++i) {
			if ((list[i][0] == source) && (list[i][1] == jumpee)) {
				target = list[i][2];
				break;
			}
		}
		return target;
	}
}

class MyCircle {
	private Color color;
	public final int xx, yy;

	MyCircle(int x, int y) {
		color = Color.green;
		xx = x;
		yy = y;
	}

	public int getX() {
		return xx;
	}

	public int getY() {
		return yy;
	}

	public void setcolor(Color c) {
		color = c;
	}

	public Color getColor() {
		return color;
	}

	public void drawIt(Graphics gc) {
		gc.setColor(color);
		gc.fillOval(xx - 10, yy - 10, 20, 20);
	}
}

public class PegGame extends Applet {
	static final int NUMPEGS = 15;
	int LastPegClicked, pegSource;
	public static int gamestate = 3;
	Rules rules = new Rules();
	static int numPegs;
	MyCircle pegs[];

	public void reset() {
		for (int i = 1; i < pegs.length; i++)
			pegs[i].setcolor(Color.green);
		gamestate = 3;
		repaint();
	}

	public void init() {
		setSize(236, 200);
		numPegs = 14;
		pegs = new MyCircle[16];
		int[] dimX = { 200, 180, 220, 160, 200, 240, 140, 180, 220, 260, 120,
				160, 200, 240, 280 }, dimY = { 100, 130, 130, 160, 160, 160,
				190, 190, 190, 190, 220, 220, 220, 220, 220 };
		for (int i = 1; i < pegs.length; i++)
			pegs[i] = new MyCircle(dimX[i - 1] - 80, dimY[i - 1] - 40);
		Button customButton = new Button("New");
		customButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		add(customButton);
		addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent event) {
				LastPegClicked = getPegIndex(event.getX(), event.getY());
				try {
					handleGame(LastPegClicked); // heart of the algorithm!
				} catch (IllegalPegException e) {
				}
				repaint();
				if (isGameOver()) {
					for (int i = 1; i < 11; i++)
						if (numPegs == i)
							if (JOptionPane.showConfirmDialog(getParent(),
									"Game Over! You have " + i
											+ " left.\nDoy want to restart?") == 0)
								reset();
							else
								System.exit(0);
				}
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseReleased(MouseEvent arg0) {
			}
		});
	}

	public void paint(Graphics gc) {
		URL url = null, url2 = null;
		try {
			url = new URL(
					"http://www.michaelkuhlmann.com/hope/wp-content/uploads/texture-wood-purgo.jpg");
			url2 = new URL("http://www.imprintedgolftees.com/Tees_Green.jpg");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Image img = getImage(url), img2 = getImage(url2);
		gc.drawImage(img2, 0, 0, this);
		int[] xPoints = { 10, 120, 230 }, yPoints = { 195, 35, 195 };
		Polygon clip = new Polygon(xPoints, yPoints, 3);
		gc.setClip(clip);
		gc.drawImage(img, 0, 0, this);
		Vector v = new Vector();
		for (int i = 1; i <= NUMPEGS; ++i) {
			if (pegs[i] != null)
				pegs[i].drawIt(gc);
		}

	}
	public static void main(String[] args){
		PegGame window = new PegGame();
	}

	public void handleGame(int peginx) throws IllegalPegException {
		int jumpee;
		int target;
		if (peginx == 0)
			return;
		else if (pegs[peginx].getColor() == PegColor.BLACKEMPTY)
			return;
		else if (numPegs == 1)
			return;
		else if (gamestate == 3) {
			pegs[peginx].setcolor(PegColor.BLACKEMPTY);
			numPegs = 14;
			gamestate = 1;
		} else if (gamestate == 2) {
			if (pegs[peginx].getColor() != Color.red)
				;
			else {
				target = Rules.getTarget(pegSource, peginx);
				if (target == 0)
					throw new IllegalPegException(target);
				handleJump(pegSource, peginx, target);
				for (int jj = 1; jj <= NUMPEGS; ++jj) {
					if (pegs[jj].getColor() == Color.red) {
						pegs[jj].setcolor(Color.green);
					}
				}
				gamestate = 1;
			}
		} else if (gamestate == 1) {
			Vector vect = new Vector();
			vect = Rules.getValidMoves(peginx, pegs);
			int n = vect.size();
			if (n == 0)
				;
			else if (n == 1) {
				int jumplist[] = (int[]) vect.elementAt(0);
				jumpee = jumplist[1];
				target = jumplist[2];
				handleJump(peginx, jumpee, target);
			} else {
				pegSource = peginx;
				int jumplist[];
				for (int ii = 0; ii < vect.size(); ++ii) {
					jumplist = (int[]) vect.elementAt(ii);
					jumpee = jumplist[1];
					pegs[jumpee].setcolor(Color.red);
				}
				gamestate = 2;
			}
		}
	}

	public void handleJump(int src, int jmp, int dst) {
		pegs[src].setcolor(PegColor.BLACKEMPTY);
		pegs[jmp].setcolor(PegColor.BLACKEMPTY);
		pegs[dst].setcolor(Color.green);
		--numPegs;
	}

	int getPegIndex(int clickX, int clickY) {
		int peginx = 0, pegx, pegy, left, right, top, bot;
		for (int i = 1; i <= NUMPEGS; ++i) {
			pegx = pegs[i].getX();
			pegy = pegs[i].getY();
			left = pegx - 10;
			right = pegx + 10;
			top = pegy - 10;
			bot = pegy + 10;
			if ((left <= clickX) && (clickX <= right) && (top <= clickY)
					&& (clickY <= bot)) {
				peginx = i;
				break;
			}
		}
		return peginx;
	}

	boolean isGameOver() {
		boolean result;
		if (gamestate == 1) {
			result = true;
			for (int peginx = 1; peginx <= NUMPEGS; ++peginx) {
				if (pegs[peginx].getColor() == PegColor.BLACKEMPTY)
					continue;
				if (Rules.getValidMoves(peginx, pegs).size() >= 1) {
					result = false;
					break;
				}
			}
		} else
			result = false;
		return result;
	}
}