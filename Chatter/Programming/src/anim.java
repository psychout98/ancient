import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class anim extends JFrame implements KeyListener {

	JPanel panel;
	double X = 0, Y = 0, HEIGHT = 60;
	int angle = 90;
	int center, center2;
	double Va = 4;
	boolean F = false, B = false, U = false, D = false, L = false, R = false,
			SL = false, SR = false, started = false, UD = false,RISE = false, FALL = false;
	obj OBJ[] = new obj[101];

	anim() throws InterruptedException {
		super("Walk");
		panel = new paint();
		this.setSize(1300, 900);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.addKeyListener(this);
		this.add(panel, BorderLayout.CENTER);
		OBJ[0] = new obj(0, 50);
		OBJ[0].addLine(10, 10, 20, -10, 10, 20, Color.green);
		OBJ[0].addLine(10, 10, 20, 10, -10, 20, Color.green);
		OBJ[0].addLine(10, 10, 20, 10, 10, 0, Color.green);
		OBJ[0].addLine(-10, -10, 20, -10, 10, 20, Color.green);
		OBJ[0].addLine(-10, -10, 20, 10, -10, 20, Color.green);
		OBJ[0].addLine(-10, -10, 20, -10, -10, 0, Color.green);
		OBJ[0].addLine(-10, 10, 0, -10, 10, 20, Color.green);
		OBJ[0].addLine(-10, 10, 0, 10, 10, 0, Color.green);
		OBJ[0].addLine(-10, 10, 0, -10, -10, 0, Color.green);
		OBJ[0].addLine(10, -10, 0, 10, -10, 20, Color.green);
		OBJ[0].addLine(10, -10, 0, 10, 10, 0, Color.green);
		OBJ[0].addLine(10, -10, 0, -10, -10, 0, Color.green);
		for (int j = 0; j < 10; j++)
			for (int i = 1; i < 11; i++) {
				OBJ[(10 * j) + i] = new obj(10 * ((i - 5)), 10 * (j - 5));
				OBJ[(10 * j) + i].addLine(-50, -50, 0, -50, 50, 0, new Color(
						100, 100, 100));
				OBJ[(10 * j) + i].addLine(-50, 50, 0, 50, 50, 0, new Color(100,
						100, 100));
				OBJ[(10 * j) + i].addLine(50, 50, 0, 50, -50, 0, new Color(100,
						100, 100));
				OBJ[(10 * j) + i].addLine(50, -50, 0, -50, -50, 0, new Color(
						100, 100, 100));
			}
		center = this.getWidth() / 2;
		center2 = this.getHeight() / 2;
		started = true;
		while (true) {
			center = this.getWidth() / 2;
			center2 = this.getHeight() / 2;
			if (U && Va < 50)
				Va += 1;
			if (D && Va > -90)
				Va -= 1;
			if (L)
				angle += 2;
			if (R)
				angle -= 2;
			if (angle > 360)
				angle = 0;
			if (angle < 0)
				angle = 360;
			if(UD){
			if (F)
				HEIGHT += 8;
			if (B)
				HEIGHT -= 8;
			} else {
			if (F) {
				X += 8 * (Math.cos(angle / (180 / Math.PI)));
				Y += 8 * (Math.sin(angle / (180 / Math.PI)));
			}
			if (B) {
				X -= 8 * (Math.cos(angle / (180 / Math.PI)));
				Y -= 8 * (Math.sin(angle / (180 / Math.PI)));
			}
			}
			if (SL) {
				X += 8 * (Math.cos((angle + 90) / (180 / Math.PI)));
				Y += 8 * (Math.sin((angle + 90) / (180 / Math.PI)));
			}
			if (SR) {
				X += 8 * (Math.cos((angle - 90) / (180 / Math.PI)));
				Y += 8 * (Math.sin((angle - 90) / (180 / Math.PI)));
			}
			repaint();
			Thread.sleep(40);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		anim window = new anim();
	}

	public class paint extends JPanel {

		public void paintComponent(Graphics p) {
			if (started) {
				for (int i = 0; i < OBJ.length; i++) {
					int x = (int) (center + getXYZ(OBJ[i].cX, OBJ[i].cY, 0, 1)), y = (int) (getXYZ(
							OBJ[i].cX, OBJ[i].cY, 0, 2));
					if (y > 0 && x > -400 && x < (2 * center) + 400)
						OBJ[i].drawObject(p);
				}
			}
		}
	}

	public double getXYZ(double x, double y, double z, int XYZ) {
		double x1 = x - X, y1 = y - Y, r = Math.sqrt((x1 * x1) + (y1 * y1));
		double sA = x1 + .0001 < 0 ? Math.asin(y1 / r) : Math.PI
				- Math.asin(y1 / r);
		double y2 = 10 * r * Math.sin(((angle - 90) / (180 / Math.PI)) + (sA));
		double z2 = ((10 * z) - (HEIGHT + center2));
		double r2 = Math.sqrt((z2 * z2) + (y2 * y2));
		double sVa = Math.asin(z2 / r2);
		int q = y2 > 0 ? 1 : -1;
		double y3 = q * r2 * Math.cos((Va / (180 / Math.PI)) + sVa);
		double dF = 10 - (20 * Math.atan(y3 / 314) / Math.PI);
		double z3 = dF * r2 * Math.sin((Va / (180 / Math.PI)) + sVa);
		double x2 = dF * -10 * r
				* Math.cos(((angle - 90) / (180 / Math.PI)) + (sA));
		if (XYZ == 1)
			return x2;
		else if (XYZ == 2)
			return y3;
		else if (XYZ == 3)
			return z3;
		else
			return 0;
	}

	public class obj {

		int cX, cY;
		POINT P[] = {};
		LINE L[] = {};
		POLYGON T[] = {};

		public obj(double floorCoordinateX, double floorCoordinateY) {
			cX = (int) (10 * floorCoordinateX);
			cY = (int) (10 * floorCoordinateY);
		}

		public class LINE {

			double X1, Y1, Z1, X2, Y2, Z2;
			Color c;

			public LINE(double x1, double y1, double z1, double x2, double y2,
					double z2, Color C) {
				X1 = x1;
				Y1 = y1;
				Z1 = z1;
				X2 = x2;
				Y2 = y2;
				Z2 = z2;
				c = C;
			}
		}

		public class POLYGON {

			double[] X, Y, Z;
			Color c;

			public POLYGON(double[] xPoints, double[] yPoints,
					double[] zPoints, Color C) {
				X = xPoints;
				Y = yPoints;
				Z = zPoints;
				c = C;
			}
		}

		public void drawObject(Graphics p) {
			int index[] = new int[P.length];
			double depth[] = new double[P.length];
			boolean used[] = new boolean[P.length];
			for (int i = 0; i < P.length; i++) {
				used[i] = false;
				depth[i] = getXYZ(P[i].X, P[i].Y, P[i].Z, 2);
			}
			for (int i = 0; i < P.length; i++) {
				double highest = Double.MIN_VALUE;
				int Index = 0;
				for (int j = 0; j < P.length; j++) {
					if (!used[j] && depth[j] > highest) {
						highest = depth[j];
						Index = j;
					}
				}
				index[i] = Index;
				used[Index] = true;
			}
			
			int TD[] = new int[T.length];
			
			for (int i = 0; i < L.length; i++) {
				p.setColor(L[i].c);
				int x1 = (int) (center + getXYZ(cX + L[i].X1, cY + L[i].Y1,
						L[i].Z1, 1)), y1 = (int) (center2 - getXYZ(
						cX + L[i].X1, cY + L[i].Y1, L[i].Z1, 3)), x2 = (int) (center + getXYZ(
						cX + L[i].X2, cY + L[i].Y2, L[i].Z2, 1)), y2 = (int) (center2 - getXYZ(
						cX + L[i].X2, cY + L[i].Y2, L[i].Z2, 3));
				p.drawLine(x1, y1, x2, y2);
			}
			for (int i = 0; i < P.length; i++) {
				p.setColor(P[index[i]].c);
				int x = (int) (center + getXYZ(cX + P[index[i]].X, cY
						+ P[index[i]].Y, P[index[i]].Z, 1));
				int z = (int) (center2 - getXYZ(cX + P[index[i]].X, cY
						+ P[index[i]].Y, P[index[i]].Z, 3));
				if (x > 0 && x < center * 2 && z > 0 && z < center2 * 2)
					p.fillRect(x, z, 1, 1);
			}
			for(int i=0;i<T.length;i++){
				p.setColor(P[TD[i]].c);
			}
		}

		public void addPoint(double x, double y, double z, Color C) {
			POINT p[] = P;
			P = new POINT[p.length + 1];
			for (int i = 0; i < p.length; i++)
				P[i] = p[i];
			P[p.length] = new POINT(x, y, z, C);
		}

		public void addLine(double x1, double y1, double z1, double x2,
				double y2, double z2, Color C) {
			LINE l[] = L;
			L = new LINE[l.length + 1];
			for (int i = 0; i < l.length; i++)
				L[i] = l[i];
			L[l.length] = new LINE(x1, y1, z1, x2, y2, z2, C);
		}

		public void addPolygon(double x[], double y[], double z[]) {

		}

		public class POINT {

			double X, Y, Z;
			Color c;

			public POINT(double x, double y, double z, Color C) {
				X = x;
				Y = y;
				Z = z;
				c = C;
			}

		}

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_W)
			U = true;
		if (arg0.getKeyCode() == KeyEvent.VK_S)
			D = true;
		if (arg0.getKeyCode() == KeyEvent.VK_UP)
			F = true;
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN)
			B = true;
		if (arg0.getKeyCode() == KeyEvent.VK_UP)
			RISE = true;
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN)
			FALL = true;
		if (arg0.getKeyCode() == KeyEvent.VK_A)
			L = true;
		if (arg0.getKeyCode() == KeyEvent.VK_D)
			R = true;
		if (arg0.getKeyCode() == KeyEvent.VK_LEFT)
			SL = true;
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT)
			SR = true;
		if (arg0.getKeyCode() == KeyEvent.VK_SHIFT)
			UD = true;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_UP)
			F = false;
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN)
			B = false;
		if (arg0.getKeyCode() == KeyEvent.VK_W)
			U = false;
		if (arg0.getKeyCode() == KeyEvent.VK_S)
			D = false;
		if (arg0.getKeyCode() == KeyEvent.VK_A)
			L = false;
		if (arg0.getKeyCode() == KeyEvent.VK_D)
			R = false;
		if (arg0.getKeyCode() == KeyEvent.VK_LEFT)
			SL = false;
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT)
			SR = false;
		if (arg0.getKeyCode() == KeyEvent.VK_SHIFT)
			UD = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
}
