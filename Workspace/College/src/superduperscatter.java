import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class superduperscatter extends JFrame
		implements ActionListener, KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

	JPanel centerPanel;
	int curX, curY, iX, iY;
	double curH = 0, curV = 0, angleH = 0, angleV = 0, direc = 0, aV = 0, aH = 0;
	boolean dragging = false, active = false;
	Random r = new Random();
	college[] c = {
			new college("Boston University", 4.26, 3.59, 620, 730, 570, 680, 0.33, 17932, 391, false, 48436, 39436, 51),
			new college("Case Western", 4.34, 3.66, 620, 720, 540, 660, 0.36, 5121, 295, false, 46006, 39095, 41),
			new college("Cooper Union", 4.2, 3.55, 610, 720, 630, 790, .13, 899, 250, false, 43850, 39589, 0),
			new college("Delaware", 3.88, 3.28, 560, 660, 550, 650, .63, 18322, 1, true, 32250, 13608, 56),
			new college("Drexel", 3.75, 3.17, 560, 670, 530, 630, .76, 16896, 1, false, 48791, 33002, 56),
			new college("GW", 4.19, 3.58, 600, 700, 590, 690, .46, 11157, 1, false, 50435, 41780, 98),
			new college("Maryland", 4.21, 3.54, 620, 730, 590, 690, .45, 27443, 1, true, 9996, 13672, 23),
			new college("NC State", 4.11, 3.48, 590, 680, 570, 650, .50, 24111, 1, true, 26399, 12849, 31),
			new college("Penn State", 3.79, 3.2, 560, 670, 530, 630, .51, 40742, 1, true, 32382, 10359, 18),
			new college("Purdue", 4.03, 3.4, 560, 700, 520, 630, .59, 29497, 1, true, 28804, 13155, 9),
			new college("RIT", 3.91, 3.28, 580, 690, 550, 660, .57, 13543, 1, false, 38568, 26000, 63),
			new college("RPI", 4.03, 3.36, 670, 770, 610, 720, .42, 5864, 1, false, 49341, 40809, 31),
			new college("UNH", 3.77, 3.2, 500, 610, 500, 600, .79, 13034, 1, true, 31424, 23000, 124),
			new college("Virginia Tech", 4.09, 3.46, 570, 680, 540, 640, .73, 24247, 1, true, 28525, 16745, 15),
			new college("WPI", 3.84, 3.39, 640, 740, 570, 680, .49, 4299, 1, false, 45590, 35814, 63),
			new college("WVU", 2.93, 2.55, 470, 580, 460, 560, .86, 22498, 1, true, 21432, 6616, 108),
			new college("UMass", 3.77, 3.18, 550, 640, 580, 670, .58, 22718, 1, true, 32389, 15551, 56),
			new college("UMBC", 3.73, 3.18, 540, 640, 570, 670, .60, 11379, 1, true, 11006, 10299, 108),
			new college("Wash U", 4.56, 3.83, 690, 760, 710, 790, .17, 7504, 1, false, 49770, 42389, 41),
			new college("ME", 3.04, 2.74, 740, 800, 600, 660, 13, 899, 250, false, 43850, 39589, 0) };
	int[][] C = { { 255, 0, 0 }, 
			{ 0, 255, 0 }, 
			{ 0, 0, 255 }, 
			{ 255, 255, 0 }, 
			{ 0, 255, 255 }, 
			{ 255, 0, 255 },
			{ 128, 0, 0 }, 
			{ 128, 128, 0 }, 
			{ 0, 128, 0 }, 
			{ 128, 0, 128 }, 
			{ 0, 128, 128 }, 
			{ 0, 0, 128 }, 
			{ 255, 165, 0 },
			{ 127, 255, 212 }, 
			{ 138, 43, 226 }, 
			{ 255, 20, 147 }, 
			{ 160, 82, 45 }, 
			{ 135, 206, 235 }, 
			{ 0, 255, 127 },
			{ 218, 165, 32 } };

	superduperscatter() throws InterruptedException {
		super("Solar Nebula Formation Simulator");
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
		this.add(centerPanel, BorderLayout.CENTER);
		this.setVisible(true);
		while (true) {
			Thread.sleep(42);
			repaint();
			while (!active) {
				Thread.sleep(42);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		superduperscatter window = new superduperscatter();
	}

	public class graphic extends JPanel {

		public void paint(Graphics p) {
			setSize(1000, 700);
			p.setColor(Color.white);
			p.fillRect(0, 0, 1000, 700);
			makeScatterBox(p);
		}

		public void makeScatterBox(Graphics p) {
			p.setColor(Color.black);
			for (int i = 0; i < 3; i++)
				for (int j = -1; j < 2; j += 2)
					for (int k = -1; k < 2; k += 2)
						p.drawLine(500 + getXYZ((i < 2 ? -1 : 1) * 20, j * 20, k * 20, 0),
								350 + getXYZ((i < 2 ? -1 : 1) * 20, j * 20, k * 20, 1),
								500 + getXYZ((i > 0 ? 1 : -1) * 20, (i == 1 ? j : -k) * 20, (i == 1 ? k : j) * 20, 0),
								350 + getXYZ((i > 0 ? 1 : -1) * 20, (i == 1 ? j : -k) * 20, (i == 1 ? k : j) * 20, 1));
			for (int i = 0; i < c.length; i++) {
				double[] pos = { c[i].ml, c[i].mh, c[i].rl, c[i].rh, c[i].gpa, 2 * c[i].wgpa - c[i].gpa };
				for (int j = 0; j < pos.length; j++)
					pos[j] = j < 2 ? ((-40.0 * (pos[j] - 400.0) / 400.0) + 20.0)
							: (j < 4 ? ((40.0 * (pos[j] - 400.0) / 400.0) - 20.0) : ((16.0 * (pos[j] - 2.5)) - 20.0));
				int[][][] box = new int[6][2][4];
				for (int j = 0; j < 6; j++) {
					for (int k = 0; k < 2; k++)
						for (int l = 0; l < 2; l++)
							for (int m = 0; m < 2; m++)
								box[j][k][(m > 0 ? 1 - l : l) + 2 * m] = (k == 0 ? 500 : 350)
										+ getXYZ((j < 2 ? pos[j] : pos[l]),
												(j < 4 && j > 1 ? pos[j] : (j > 3 ? pos[2 + m] : pos[2 + l])),
												(j > 3 ? pos[j] : pos[4 + m]), (k == 0 ? 0 : 1));
					p.setColor(new Color(C[i][0], C[i][1], C[i][2], 75));
					p.fillPolygon(box[j][0], box[j][1], 4);
					p.setColor(new Color(C[i][0], C[i][1], C[i][2]));
					p.drawPolygon(box[j][0], box[j][1], 4);
				}

			}
			p.setColor(Color.black);
			p.drawString("2.0", 500 + getXYZ(20, -20, -18, 0), 350 + getXYZ(20, -20, -18, 1));
			p.drawString("400", 500 + getXYZ(18, -20, -20, 0), 350 + getXYZ(18, -20, -20, 1));
			p.drawString("400", 500 + getXYZ(20, -18, -20, 0), 350 + getXYZ(20, -18, -20, 1));
			p.drawString("WGPA", 500 + getXYZ(20, -24, 0, 0), 350 + getXYZ(20, -24, 0, 1));
			p.drawString("SAT Math", 500 + getXYZ(-3, -20, -22, 0), 350 + getXYZ(-3, -20, -22, 1));
			p.drawString("SAT Reading", 500 + getXYZ(20, -5, -22, 0), 350 + getXYZ(20, -5, -22, 1));
			p.drawString("800", 500 + getXYZ(22, 22, -22, 0), 350 + getXYZ(22, 22, -22, 1));
			p.drawString("800", 500 + getXYZ(-22, -22, -22, 0), 350 + getXYZ(-22, -22, -22, 1));
			p.drawString("5.0", 500 + getXYZ(22, -22, 22, 0), 350 + getXYZ(22, -22, 22, 1));
		}

	}

	public int getXYZ(double x, double y, double z, int XYZ) {
		x += .0001;
		y += .0001;
		z += .0001;
		x *= 10;
		y *= 10;
		z *= -10;

		double r = Math.sqrt((x * x) + (y * y) + (z * z)), rxy = Math.sqrt((x * x) + (y * y)),
				rxz = Math.sqrt((x * x) + (z * z)), Hpt = (x > 0 ? 0 : Math.PI) + (x > 0 ? 1 : -1) * Math.asin(y / rxy),
				Vpt = (x > 0 ? 0 : Math.PI) + (x > 0 ? 1 : -1) * Math.asin(z / rxz);
		double Y = ((z * Math.sin(angleV + (Math.PI / 2))) + (rxy * Math.sin(angleV) * Math.cos(angleH + Hpt)));
		double X = ((y * Math.sin(angleH + (Math.PI / 2))) + (rxz * Math.sin(angleH) * Math.cos(angleV + Vpt)));
		X = (rxy * Math.sin(angleH + Hpt));
		double Z = (rxz * Math.cos(angleH + Hpt) * (angleV + Vpt > Math.PI / 2 ? -1 : 1));
		return XYZ == 0 ? (int) (X) : (XYZ == 1 ? (int) (Y) : (int) (Z));
	}

	public class college {

		int ml, mh, rl, rh, size, dist, price, finance, usnews;
		double gpa, wgpa, acc;
		String name;
		boolean pub;

		college(String Name, double WGPA, double GPA, int MathLow, int MathHigh, int ReadingLow, int ReadingHigh,
				double Acceptance, int Size, int Distance, boolean Public, int Tuition, int Finance, int USNewsRank) {
			name = Name;
			ml = MathLow;
			mh = MathHigh;
			rl = ReadingLow;
			rh = ReadingHigh;
			gpa = GPA;
			wgpa = WGPA;
			acc = Acceptance;
			size = Size;
			dist = Distance;
			pub = Public;
			price = Tuition;
			finance = Finance;
			usnews = USNewsRank;
		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		iX = arg0.getPoint().x;
		iY = arg0.getPoint().y;
		dragging = true;
		active = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		curH = angleH;
		curV = angleV;
		dragging = false;
		active = false;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		curX = e.getPoint().x;
		curY = e.getPoint().y;
		if (dragging) {
			int Dx = curX - iX, Dy = curY - iY;
			angleH = ((double) Math.PI * (Dx) / 720) + curH;
			angleV = ((double) Math.PI * (Dy) / 720) + curV;
		}
		if (angleV < 0) {
			angleV = 1439 * Math.PI / 720;
			iY = curY;
			curV = angleV;
		}
		if (angleV > 2 * Math.PI) {
			angleV = 0;
			iY = curY;
			curV = angleV;
		}
		if (angleH < 0) {
			angleH = 1439 * Math.PI / 720;
			iX = curX;
			curH = angleH;
		}
		if (angleH > 2 * Math.PI) {
			angleH = 0;
			iX = curX;
			curH = angleH;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

}
