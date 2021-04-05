import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class draw extends JFrame implements KeyListener, ActionListener,
		MouseWheelListener, MouseListener, MouseMotionListener {

	draw() throws InterruptedException, FileNotFoundException {
		super("3D Model");
		for (int i = 0; i < zeros.length; i++)
			zeros[i] = new SpinnerNumberModel(0, -1000, 1000, .1);
		sped = new SpinnerNumberModel(1, .4, 18.1, .1);
		Sped.setModel(sped);
		this.setSize(1300, 900);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		this.setDefaultCloseOperation(3);
		// filename = "H:\\rectum";
		filename = "Arrays.txt";
		redefineArrays();
		panel = new cube();
		control = new JButton("Control");
		control.addKeyListener(this);
		this.addKeyListener(this);
		this.addMouseWheelListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setLayout(null);
		JMenuBar mb = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu showGrid = new JMenu("Show Grid");
		getfile = new JMenuItem("Open");
		savefile = new JMenuItem("Save");
		saveAs = new JMenuItem("Save As");
		newfile = new JMenuItem("New");
		showManager = new JMenuItem("Open Manager");
		JMenu create = new JMenu("Create");
		line = new JMenuItem("Line");
		plane = new JMenuItem("Plane");
		point = new JMenuItem("Point");
		JMenu fmt = new JMenu("Options");
		xGrid = new JCheckBoxMenuItem("X-Axis");
		yGrid = new JCheckBoxMenuItem("Y-Axis");
		zGrid = new JCheckBoxMenuItem("Z-Axis");
		showGrid.add(xGrid);
		showGrid.add(yGrid);
		showGrid.add(zGrid);
		showAxis = new JRadioButtonMenuItem("Show Axis");
		newfile.addActionListener(this);
		getfile.addActionListener(this);
		savefile.addActionListener(this);
		saveAs.addActionListener(this);
		line.addActionListener(this);
		plane.addActionListener(this);
		point.addActionListener(this);
		showGrid.addActionListener(this);
		showManager.addActionListener(this);
		showAxis.addActionListener(this);
		JPanel SPanel = new JPanel(new GridLayout(1, 2));
		JLabel SLabel = new JLabel("       Speed:");
		SPanel.add(SLabel);
		SPanel.add(Sped);
		file.add(newfile);
		file.add(getfile);
		file.add(savefile);
		file.add(saveAs);
		create.add(line);
		create.add(point);
		create.add(plane);
		fmt.add(showGrid);
		fmt.add(showAxis);
		fmt.add(showManager);
		fmt.add(SPanel);
		mb.add(file);
		mb.add(create);
		mb.add(fmt);
		this.add(panel);
		panel.setSize(this.getWidth(), this.getHeight());
		panel.setLocation(0, 0);
		this.add(control);
		control.setSize(80, 80);
		control.setLocation(this.getWidth() - 80, 0);
		this.setJMenuBar(mb);
		Thread.sleep(500);
		this.setVisible(true);
		while (true) {
			if (EditingP) {
				PC[editP].X = Double.parseDouble(eX.getValue().toString());
				PC[editP].Y = Double.parseDouble(eY.getValue().toString());
				PC[editP].Z = Double.parseDouble(eZ.getValue().toString());
			}
			if (EditingL) {
				LC[editL].X1 = Double.parseDouble(eX1.getValue().toString());
				LC[editL].Y1 = Double.parseDouble(eY1.getValue().toString());
				LC[editL].Z1 = Double.parseDouble(eZ1.getValue().toString());
				LC[editL].X2 = Double.parseDouble(eX2.getValue().toString());
				LC[editL].Y2 = Double.parseDouble(eY2.getValue().toString());
				LC[editL].Z2 = Double.parseDouble(eZ2.getValue().toString());
			}
			if (EditingPL) {

				for (int i = 0; i < 4; i++) {
					PLC[editPL].X[i] = Double.parseDouble(epX[i].getValue()
							.toString());
					PLC[editPL].Y[i] = Double.parseDouble(epY[i].getValue()
							.toString());
					PLC[editPL].Z[i] = Double.parseDouble(epZ[i].getValue()
							.toString());
				}
			}
			if (EditingCL) {
				curColor = new Color(Integer.parseInt("" + r.getValue()),
						Integer.parseInt("" + g.getValue()),
						Integer.parseInt("" + b.getValue()));
				PLC[editPL].changeColor(curColor);
			}
			p.setSize(200, this.getHeight() - 260);
			drawing.setLocation(0, this.getHeight() - 260);
			Axis = showAxis.isSelected();
			Grid = showGrid.isSelected();
			panel.setSize(this.getWidth(), this.getHeight());
			control.setLocation(this.getWidth() - 100, 0);
			if (up)
				angleV -= 5;
			if (down)
				angleV += 5;
			if (left)
				angleH += 5;
			if (right)
				angleH -= 5;
			if (angleV > 360)
				angleV = 1;
			if (angleV < 0)
				angleV = 359;
			if (angleH > 360)
				angleH = 1;
			if (angleH < 0)
				angleH = 359;
			Thread.sleep((long) (36 / Double.parseDouble(String.valueOf(Sped
					.getValue()))));
			repaint();
		}
	}

	public double getXY(double x, double y, double z, int XY) {
		x *= 10;
		y *= 10;
		z *= 10;
		x += .0001;
		y += .0001;
		z += .0001;
		int q = y < 0 ? (z < 0 ? 3 : 2) : (z < 0 ? 4 : 1);
		double radH = angleV / (180 / Math.PI), radV = angleH / (180 / Math.PI), cP = x
				* Math.sin(radH + (Math.PI / 2)), r = Math.sqrt((y * y)
				+ (z * z)), sA = q == 1 || q == 4 ? Math.asin(z / r) : Math.PI
				- Math.asin(z / r);
		int X = (int) (r * Math.sin(radV + sA)), Y = (int) (cP + (r
				* Math.sin(radH) * Math.cos(radV + sA)));

		int front = (angleV <= 360 && angleV >= 180 ? 1 : -1);
		q = x > 0 ? 1 : -1;
		double c = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)), b = Math
				.sqrt(Math.pow(X, 2) + Math.pow(Y, 2)), Z = (Math.sqrt(Math
				.pow(c, 2) - Math.pow(b, 2)) / 10)
				* front * q;
		double dF = 1 - (Math.atan(Z / 18) / 2);
		dF = 1;
		X *= dF;
		Y *= dF;
		return XY == 1 ? X : XY == 2 ? Y : Z;
	}

	public void colorChooser() {
		EditingCL = false;
		colorPanel.removeAll();
		this.remove(colorPanel);
		colorPanel = new JPanel();
		JPanel panel1 = new JPanel(new GridLayout(3, 2));
		JLabel labels[] = { new JLabel("Red: "), new JLabel("Green: "),
				new JLabel("Blue: ") };
		SpinnerModel s[] = {
				new SpinnerNumberModel(curColor.getRed(), 0, 255, 1),
				new SpinnerNumberModel(curColor.getGreen(), 0, 255, 1),
				new SpinnerNumberModel(curColor.getBlue(), 0, 255, 1) };
		r.setModel(s[0]);
		g.setModel(s[1]);
		b.setModel(s[2]);
		panel1.add(labels[0]);
		panel1.add(r);
		panel1.add(labels[1]);
		panel1.add(g);
		panel1.add(labels[2]);
		panel1.add(b);
		colorPanel.add(panel1);
		colorPanel.setLocation(this.getWidth() - 200, this.getHeight() - 200);
		colorPanel.setSize(200, 200);
		this.add(colorPanel);
		validate();
		EditingCL = true;
	}

	public void showPlaneData(int i) {
		EditingCL = false;
		colorPanel.removeAll();
		this.remove(colorPanel);
		EditingPL = false;
		editing.removeAll();
		this.remove(editing);
		curColor = PLC[i].c;
		editPL = i;
		spins[9] = new SpinnerNumberModel(PLC[i].X[0], -1000, 1000, .1);
		spins[10] = new SpinnerNumberModel(PLC[i].Y[0], -1000, 1000, .1);
		spins[11] = new SpinnerNumberModel(PLC[i].Z[0], -1000, 1000, .1);
		spins[12] = new SpinnerNumberModel(PLC[i].X[1], -1000, 1000, .1);
		spins[13] = new SpinnerNumberModel(PLC[i].Y[1], -1000, 1000, .1);
		spins[14] = new SpinnerNumberModel(PLC[i].Z[1], -1000, 1000, .1);
		spins[15] = new SpinnerNumberModel(PLC[i].X[2], -1000, 1000, .1);
		spins[16] = new SpinnerNumberModel(PLC[i].Y[2], -1000, 1000, .1);
		spins[17] = new SpinnerNumberModel(PLC[i].Z[2], -1000, 1000, .1);
		spins[18] = new SpinnerNumberModel(PLC[i].X[3], -1000, 1000, .1);
		spins[19] = new SpinnerNumberModel(PLC[i].Y[3], -1000, 1000, .1);
		spins[20] = new SpinnerNumberModel(PLC[i].Z[3], -1000, 1000, .1);
		editing.setLayout(new GridLayout(6, 1));
		for (int j = 0; j < 4; j++) {
			epX[j] = new JSpinner(spins[(j * 3) + 9]);
			epY[j] = new JSpinner(spins[(j * 3) + 10]);
			epZ[j] = new JSpinner(spins[(j * 3) + 11]);
			epX[j].setBorder(BorderFactory.createLineBorder(Color.black));
			epY[j].setBorder(BorderFactory.createLineBorder(Color.black));
			epZ[j].setBorder(BorderFactory.createLineBorder(Color.black));
		}
		JLabel labels[] = { new JLabel("     X1:"), new JLabel("     Y1:"),
				new JLabel("     Z1:"), new JLabel("     X2:"),
				new JLabel("     Y2:"), new JLabel("     Z2:"),
				new JLabel("     X3:"), new JLabel("     Y3:"),
				new JLabel("     Z3:"), new JLabel("     X4:"),
				new JLabel("     Y4:"), new JLabel("     Z4:") };
		Font f = new Font("Times New Roman", 0, 12);
		deletePL = new JButton("Delete");
		PLcancel = new JButton("Cancel");
		deletePL.setFont(f);
		PLcancel.setFont(f);
		deletePL.addActionListener(this);
		PLcancel.addActionListener(this);
		JPanel p[] = new JPanel[6];
		p[0] = new JPanel(new GridLayout(1, 6));
		p[1] = new JPanel(new GridLayout(1, 6));
		p[3] = new JPanel(new GridLayout(1, 6));
		p[4] = new JPanel(new GridLayout(1, 6));
		p[2] = new JPanel(new GridLayout(1, 2));
		p[5] = new JPanel(new GridLayout(1, 2));
		changePLcolor = new JButton("Change Color");
		changePLcolor.addActionListener(this);
		p[5].add(changePLcolor);
		p[0].add(labels[0]);
		p[0].add(epX[0]);
		p[0].add(labels[1]);
		p[0].add(epY[0]);
		p[0].add(labels[2]);
		p[0].add(epZ[0]);
		p[1].add(labels[3]);
		p[1].add(epX[1]);
		p[1].add(labels[4]);
		p[1].add(epY[1]);
		p[1].add(labels[5]);
		p[1].add(epZ[1]);
		p[3].add(labels[6]);
		p[3].add(epX[2]);
		p[3].add(labels[7]);
		p[3].add(epY[2]);
		p[3].add(labels[8]);
		p[3].add(epZ[2]);
		p[4].add(labels[9]);
		p[4].add(epX[3]);
		p[4].add(labels[10]);
		p[4].add(epY[3]);
		p[4].add(labels[11]);
		p[4].add(epZ[3]);
		p[2].add(PLcancel);
		p[2].add(deletePL);
		editing.add(p[0]);
		editing.add(p[1]);
		editing.add(p[3]);
		editing.add(p[4]);
		editing.add(p[5]);
		editing.add(p[2]);
		editing.setSize(400, 160);
		editing.setLocation(200, 0);
		this.add(editing);
		validate();
		EditingPL = true;
	}

	public void showPointData(int i) {
		EditingP = false;
		editing.removeAll();
		this.remove(editing);
		editP = i;
		spins[0] = new SpinnerNumberModel(PC[i].X, -1000, 1000, .1);
		spins[1] = new SpinnerNumberModel(PC[i].Y, -1000, 1000, .1);
		spins[2] = new SpinnerNumberModel(PC[i].Z, -1000, 1000, .1);
		editing.setLocation(200, 0);
		editing.setLayout(new GridLayout(4, 2));
		eX = new JSpinner(spins[0]);
		eY = new JSpinner(spins[1]);
		eZ = new JSpinner(spins[2]);
		eX.setBorder(BorderFactory.createLineBorder(Color.black));
		eY.setBorder(BorderFactory.createLineBorder(Color.black));
		eZ.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel labels[] = { new JLabel("          X: "),
				new JLabel("          Y: "), new JLabel("          Z: ") };
		Font f = new Font("Times New Roman", 0, 12);
		deleteP = new JButton("Delete");
		cancelP = new JButton("Cancel");
		deleteP.setFont(f);
		cancelP.setFont(f);
		deleteP.addActionListener(this);
		cancelP.addActionListener(this);
		editing.add(labels[0]);
		editing.add(eX);
		editing.add(labels[1]);
		editing.add(eY);
		editing.add(labels[2]);
		editing.add(eZ);
		editing.add(cancelP);
		editing.add(deleteP);
		editing.setSize(210, 130);
		this.add(editing);
		EditingP = true;
		validate();
	}

	public void showLineData(int i) {
		EditingL = false;
		editing.removeAll();
		this.remove(editing);
		editL = i;
		editing.setLayout(new GridLayout(3, 1));
		spins[3] = new SpinnerNumberModel(LC[i].X1, -1000, 1000, .1);
		spins[4] = new SpinnerNumberModel(LC[i].Y1, -1000, 1000, .1);
		spins[5] = new SpinnerNumberModel(LC[i].Z1, -1000, 1000, .1);
		spins[6] = new SpinnerNumberModel(LC[i].X2, -1000, 1000, .1);
		spins[7] = new SpinnerNumberModel(LC[i].Y2, -1000, 1000, .1);
		spins[8] = new SpinnerNumberModel(LC[i].Z2, -1000, 1000, .1);
		eX1 = new JSpinner(spins[3]);
		eY1 = new JSpinner(spins[4]);
		eZ1 = new JSpinner(spins[5]);
		eX2 = new JSpinner(spins[6]);
		eY2 = new JSpinner(spins[7]);
		eZ2 = new JSpinner(spins[8]);
		eX1.setBorder(BorderFactory.createLineBorder(Color.black));
		eY1.setBorder(BorderFactory.createLineBorder(Color.black));
		eZ1.setBorder(BorderFactory.createLineBorder(Color.black));
		eX2.setBorder(BorderFactory.createLineBorder(Color.black));
		eY2.setBorder(BorderFactory.createLineBorder(Color.black));
		eZ2.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel labels[] = { new JLabel("     X1:"), new JLabel("     Y1:"),
				new JLabel("     Z1:"), new JLabel("     X2:"),
				new JLabel("     Y2:"), new JLabel("     Z2:") };
		Font f = new Font("Times New Roman", 0, 12);
		deleteL = new JButton("Delete");
		Lcancel = new JButton("Cancel");
		deleteL.setFont(f);
		Lcancel.setFont(f);
		deleteL.addActionListener(this);
		Lcancel.addActionListener(this);
		JPanel p[] = new JPanel[3];
		p[0] = new JPanel(new GridLayout(1, 6));
		p[1] = new JPanel(new GridLayout(1, 6));
		p[2] = new JPanel(new GridLayout(1, 2));
		p[0].add(labels[0]);
		p[0].add(eX1);
		p[1].add(labels[3]);
		p[1].add(eX2);
		p[0].add(labels[1]);
		p[0].add(eY1);
		p[1].add(labels[4]);
		p[1].add(eY2);
		p[0].add(labels[2]);
		p[0].add(eZ1);
		p[1].add(labels[5]);
		p[1].add(eZ2);
		p[2].add(Lcancel);
		p[2].add(deleteL);
		editing.add(p[0]);
		editing.add(p[1]);
		editing.add(p[2]);
		editing.setSize(400, 130);
		editing.setLocation(200, 0);
		this.add(editing);
		EditingL = true;
		validate();
	}

	public void deletePoint(int i) {
		EditingP = false;
		highlightPoint = false;
		POINT CP[] = new POINT[PC.length - 1];
		for (int j = 0; j < CP.length; j++)
			CP[j] = (j < i ? PC[j] : PC[j + 1]);
		PC = CP;
		editing.removeAll();
		this.remove(editing);
		manager();
	}

	public void deletePlane(int i) {
		EditingPL = false;
		highlightPlane = false;
		PLANE CPL[] = new PLANE[PLC.length - 1];
		for (int j = 0; j < CPL.length; j++)
			CPL[j] = (j >= i ? PLC[j + 1] : PLC[j]);
		PLC = CPL;
		editing.removeAll();
		this.remove(editing);
		manager();
	}

	public void deleteLine(int i) {
		EditingL = false;
		highlightLine = false;
		LINE CL[] = new LINE[LC.length - 1];
		for (int j = 0; j < CL.length; j++)
			CL[j] = (j >= i ? LC[j + 1] : LC[j]);
		LC = CL;
		editing.removeAll();
		this.remove(editing);
		manager();
	}

	public void manager() {
		this.remove(p);
		showManager.setText("Close Manager");
		JPanel managerPanel = new JPanel(new GridLayout(PC.length + LC.length
				+ PLC.length + 1, 1));
		managerPanel.setBackground(Color.white);
		managerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		managerPanel.setPreferredSize(new Dimension(180, (PC.length + LC.length
				+ PLC.length + 1) * 30));
		points = new JButton[PC.length];
		lines = new JButton[LC.length];
		planes = new JButton[PLC.length];
		JLabel label = new JLabel("Manager");
		managerPanel.add(label);
		for (int i = 0; i < PC.length; i++) {
			points[i] = new JButton("Point " + (i + 1));
			points[i].addActionListener(this);
			managerPanel.add(points[i]);
		}
		for (int i = 0; i < LC.length; i++) {
			lines[i] = new JButton("Line " + (i + 1));
			lines[i].addActionListener(this);
			managerPanel.add(lines[i]);
		}
		for (int i = 0; i < PLC.length; i++) {
			planes[i] = new JButton("Plane " + (i + 1));
			planes[i].addActionListener(this);
			managerPanel.add(planes[i]);
		}
		p = new JScrollPane(managerPanel,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(p);
		p.setSize(200, this.getHeight() - 260);
		p.setLocation(0, 0);
		managing = true;
		validate();
	}

	public void drawingPanel(int type) {
		drawing.removeAll();
		IDP = true;
		drawing.setBackground(Color.white);
		drawing.setBorder(BorderFactory.createLineBorder(Color.black));
		if (type == 1) {
			drawing.setLayout(new GridLayout(4, 2));
			X = new JSpinner(zeros[0]);
			Y = new JSpinner(zeros[1]);
			Z = new JSpinner(zeros[2]);
			X.setBorder(BorderFactory.createLineBorder(Color.black));
			Y.setBorder(BorderFactory.createLineBorder(Color.black));
			Z.setBorder(BorderFactory.createLineBorder(Color.black));
			JLabel labels[] = { new JLabel("          X: "),
					new JLabel("          Y: "), new JLabel("          Z: ") };
			Font f = new Font("Times New Roman", 0, 12);
			createP = new JButton("Create");
			cancel = new JButton("Cancel");
			createP.setFont(f);
			cancel.setFont(f);
			createP.addActionListener(this);
			cancel.addActionListener(this);
			drawing.add(labels[0]);
			drawing.add(X);
			drawing.add(labels[1]);
			drawing.add(Y);
			drawing.add(labels[2]);
			drawing.add(Z);
			drawing.add(cancel);
			drawing.add(createP);
			drawing.setSize(210, 130);
		} else if (type == 2) {
			drawing.setLayout(new GridLayout(3, 1));
			X1 = new JSpinner(zeros[3]);
			Y1 = new JSpinner(zeros[4]);
			Z1 = new JSpinner(zeros[5]);
			X2 = new JSpinner(zeros[6]);
			Y2 = new JSpinner(zeros[7]);
			Z2 = new JSpinner(zeros[8]);
			X1.setBorder(BorderFactory.createLineBorder(Color.black));
			Y1.setBorder(BorderFactory.createLineBorder(Color.black));
			Z1.setBorder(BorderFactory.createLineBorder(Color.black));
			X2.setBorder(BorderFactory.createLineBorder(Color.black));
			Y2.setBorder(BorderFactory.createLineBorder(Color.black));
			Z2.setBorder(BorderFactory.createLineBorder(Color.black));
			JLabel labels[] = { new JLabel("     X1:"), new JLabel("     Y1:"),
					new JLabel("     Z1:"), new JLabel("     X2:"),
					new JLabel("     Y2:"), new JLabel("     Z2:") };
			Font f = new Font("Times New Roman", 0, 12);
			createL = new JButton("Create");
			cancel = new JButton("Cancel");
			createL.setFont(f);
			cancel.setFont(f);
			createL.addActionListener(this);
			cancel.addActionListener(this);
			JPanel p[] = new JPanel[3];
			p[0] = new JPanel(new GridLayout(1, 6));
			p[1] = new JPanel(new GridLayout(1, 6));
			p[2] = new JPanel(new GridLayout(1, 2));
			p[0].add(labels[0]);
			p[0].add(X1);
			p[1].add(labels[3]);
			p[1].add(X2);
			p[0].add(labels[1]);
			p[0].add(Y1);
			p[1].add(labels[4]);
			p[1].add(Y2);
			p[0].add(labels[2]);
			p[0].add(Z1);
			p[1].add(labels[5]);
			p[1].add(Z2);
			p[2].add(cancel);
			p[2].add(createL);
			drawing.add(p[0]);
			drawing.add(p[1]);
			drawing.add(p[2]);
			drawing.setSize(400, 130);
		} else if (type == 3) {
			drawing.setLayout(new GridLayout(5, 1));
			for (int j = 0; j < 4; j++) {
				pX[j] = new JSpinner(zeros[(j * 3) + 9]);
				pY[j] = new JSpinner(zeros[(j * 3) + 10]);
				pZ[j] = new JSpinner(zeros[(j * 3) + 11]);
				pX[j].setBorder(BorderFactory.createLineBorder(Color.black));
				pY[j].setBorder(BorderFactory.createLineBorder(Color.black));
				pZ[j].setBorder(BorderFactory.createLineBorder(Color.black));
			}
			JLabel labels[] = { new JLabel("     X1:"), new JLabel("     Y1:"),
					new JLabel("     Z1:"), new JLabel("     X2:"),
					new JLabel("     Y2:"), new JLabel("     Z2:"),
					new JLabel("     X3:"), new JLabel("     Y3:"),
					new JLabel("     Z3:"), new JLabel("     X4:"),
					new JLabel("     Y4:"), new JLabel("     Z4:") };
			Font f = new Font("Times New Roman", 0, 12);
			createPL = new JButton("Create");
			cancel = new JButton("Cancel");
			createPL.setFont(f);
			cancel.setFont(f);
			createPL.addActionListener(this);
			cancel.addActionListener(this);
			JPanel p[] = new JPanel[5];
			p[0] = new JPanel(new GridLayout(1, 6));
			p[1] = new JPanel(new GridLayout(1, 6));
			p[3] = new JPanel(new GridLayout(1, 6));
			p[4] = new JPanel(new GridLayout(1, 6));
			p[2] = new JPanel(new GridLayout(1, 2));
			p[0].add(labels[0]);
			p[0].add(pX[0]);
			p[0].add(labels[1]);
			p[0].add(pY[0]);
			p[0].add(labels[2]);
			p[0].add(pZ[0]);
			p[1].add(labels[3]);
			p[1].add(pX[1]);
			p[1].add(labels[4]);
			p[1].add(pY[1]);
			p[1].add(labels[5]);
			p[1].add(pZ[1]);
			p[3].add(labels[6]);
			p[3].add(pX[2]);
			p[3].add(labels[7]);
			p[3].add(pY[2]);
			p[3].add(labels[8]);
			p[3].add(pZ[2]);
			p[4].add(labels[9]);
			p[4].add(pX[3]);
			p[4].add(labels[10]);
			p[4].add(pY[3]);
			p[4].add(labels[11]);
			p[4].add(pZ[3]);
			p[2].add(cancel);
			p[2].add(createPL);
			drawing.add(p[0]);
			drawing.add(p[1]);
			drawing.add(p[3]);
			drawing.add(p[4]);
			drawing.add(p[2]);
			drawing.setSize(400, 160);
		}
		this.add(drawing);
		drawing.setLocation(0, this.getHeight() - 260);
		validate();
	}

	public static void main(String[] args) throws InterruptedException,
			FileNotFoundException {
		draw window = new draw();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getSource() == control) {
			if (arg0.getKeyCode() == KeyEvent.VK_UP) {
				up = true;
			}
			if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
				down = true;
			}
			if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
				left = true;
			}
			if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
				right = true;
			}
		}
		if (arg0.getKeyCode() == KeyEvent.VK_CONTROL
				&& arg0.getKeyCode() == KeyEvent.VK_SHIFT
				&& arg0.getKeyCode() == KeyEvent.VK_P && !IDP)
			drawingPanel(1);
		if (arg0.getKeyCode() == KeyEvent.VK_CONTROL
				&& arg0.getKeyCode() == KeyEvent.VK_SHIFT
				&& arg0.getKeyCode() == KeyEvent.VK_L && !IDP)
			drawingPanel(2);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == control) {
			if (arg0.getKeyCode() == KeyEvent.VK_UP) {
				up = false;
			}
			if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
				down = false;
			}
			if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
				left = false;
			}
			if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
				right = false;
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	public class cube extends JPanel {

		public void drawObject(int i, int j, Graphics p) {
			double center = (this.getWidth() / 2) + xMoved, center2 = (this
					.getHeight() / 2) + yMoved;
			switch (j) {
			case 1:
				p.drawLine((int) (center + (zoom * (LC[i].getXs1()))),
						(int) (center2 + (zoom * (LC[i].getYs1()))),
						(int) (center + (zoom * (LC[i].getXs2()))),
						(int) (center2 + (zoom * (LC[i].getYs2()))));
				p.setColor(Color.black);
				if (labels)
					p.drawString(
							"Line" + (i + 1),
							(int) (((center + (zoom * (LC[i].getXs1()))) + (center + (zoom * (LC[i]
									.getXs2())))) / 2),
							(int) (((center2 + (zoom * (LC[i].getYs1()))) + (center2 + (zoom * (LC[i]
									.getYs2())))) / 2));
				break;
			case 2:
				p.drawOval((int) (center + (zoom * (PC[i].getXs()))) - 2,
						(int) (center2 + (zoom * (PC[i].getYs()))) - 2, 4, 4);
				p.setColor(Color.black);
				if (labels)
					p.drawString("Point " + (i + 1),
							(int) (center + (zoom * (PC[i].getXs()))) - 4,
							(int) (center2 + (zoom * (PC[i].getYs()))) - 4);
				break;
			case 3:
				int[] x = { (int) (center + (zoom * (PLC[i].getX(0)))),
						(int) (center + (zoom * (PLC[i].getX(1)))),
						(int) (center + (zoom * (PLC[i].getX(2)))),
						(int) (center + (zoom * (PLC[i].getX(3)))) },
				y = { (int) (center2 + (zoom * (PLC[i].getY(0)))),
						(int) (center2 + (zoom * (PLC[i].getY(1)))),
						(int) (center2 + (zoom * (PLC[i].getY(2)))),
						(int) (center2 + (zoom * (PLC[i].getY(3)))) };
				p.setColor(PLC[i].c.brighter());
				p.fillPolygon(x, y, 4);
				p.setColor(PLC[i].c.darker());
				p.drawPolygon(x, y, 4);
				int xs = 0,
				ys = 0;
				for (int l = 0; l < 4; l++) {
					xs += x[l];
					ys += y[l];
				}
				ys /= 4;
				xs /= 4;
				p.setColor(Color.black);
				if (labels)
					p.drawString("Plane " + (i + 1), xs, ys);
				break;
			}
		}

		public int[][] sort(int[][] object) {
			int[][] sorted = new int[object.length][2];
			double[] depth = new double[object.length];
			for (int i = 0; i < object.length; i++) {
				switch (object[i][1]) {
				case 1:
					double d1 = LC[object[i][0]].getDepth1(),
					d2 = LC[object[i][0]].getDepth2();
					depth[i] = d1 >= d2 ? d1 : d2;
					break;
				case 2:
					depth[i] = PC[object[i][0]].getPointDepth();
					break;
				case 3:
					depth[i] = PLC[object[i][0]].getAveragePlaneDepth();
					break;
				}
			}
			int rank[] = new int[depth.length];
			Arrays.fill(rank, 0);
			for (int i = 0; i < depth.length; i++) {
				for (int j = 0; j < depth.length; j++) {
					rank[i] += (i == j ? 0 : (depth[i] >= depth[j] ? 1 : 0));
				}
			}
			for (int k = 0; k < object.length; k++)
				for (int i = 0; i < depth.length; i++) {
					for (int j = 0; j < depth.length; j++) {
						if (i != j && rank[i] == rank[j])
							rank[i]--;
					}
				}
			for (int i = 0; i < rank.length; i++) {
				for (int j = 0; j < rank.length; j++) {
					if (rank[j] == i) {
						sorted[i][0] = object[j][0];
						sorted[i][1] = object[j][1];
					}
				}
			}
			return sorted;
		}

		public void paint(Graphics p) {
			int[][] object = new int[LC.length + PC.length + PLC.length][2];
			double center = (this.getWidth() / 2) + xMoved, center2 = (this
					.getHeight() / 2) + yMoved;
			int k = 0;
			for (int i = 1; i < 4; i++)
				for (int j = 0; j < (i == 1 ? LC.length : (i == 2 ? PC.length
						: PLC.length)); j++) {
					object[k][0] = j;
					object[k][1] = i;
					k++;
				}
			object = sort(object);
			for (int i = 0; i < object.length; i++)
				drawObject(object[i][0], object[i][1], p);
			if (highlightPoint) {
				p.setColor(Color.yellow);
				p.fillOval(
						(int) (center + (zoom * highlightedPoint.getXs())) - 1,
						(int) (center2 + (zoom * highlightedPoint.getYs())) - 1,
						2, 2);
				p.drawOval(
						(int) (center + (zoom * highlightedPoint.getXs())) - 3,
						(int) (center2 + (zoom * highlightedPoint.getYs())) - 3,
						6, 6);
				p.setColor(Color.black);
			}
			if (highlightPlane) {
				p.setColor(Color.yellow);
				int[] x = {
						(int) (center + (zoom * (highlightedPlane.getX(0)))),
						(int) (center + (zoom * (highlightedPlane.getX(1)))),
						(int) (center + (zoom * (highlightedPlane.getX(2)))),
						(int) (center + (zoom * (highlightedPlane.getX(3)))) }, y = {
						(int) (center2 + (zoom * (highlightedPlane.getY(0)))),
						(int) (center2 + (zoom * (highlightedPlane.getY(1)))),
						(int) (center2 + (zoom * (highlightedPlane.getY(2)))),
						(int) (center2 + (zoom * (highlightedPlane.getY(3)))) };
				p.drawPolygon(x, y, 4);
				p.setColor(Color.black);
			}
			if (highlightLine) {
				p.setColor(Color.yellow);
				p.drawLine(
						(int) (center + (zoom * highlightedLine.getXs1())) - 1,
						(int) (center2 + (zoom * highlightedLine.getYs1())),
						(int) (center + (zoom * highlightedLine.getXs2())),
						(int) (center2 + (zoom * highlightedLine.getYs2())) - 1);
				p.drawLine(
						(int) (center + (zoom * highlightedLine.getXs1())) + 1,
						(int) (center2 + (zoom * highlightedLine.getYs1())),
						(int) (center + (zoom * highlightedLine.getXs2())) + 1,
						(int) (center2 + (zoom * highlightedLine.getYs2())));
				p.setColor(Color.black);
			}
			if (Axis) {
				p.setColor(Color.black);
				double[] A = { (this.getHeight() / 20) - 10, 0, 0 }, B = { 0,
						(this.getHeight() / 20) - 10, 0 }, C = { 0, 0,
						(this.getHeight() / 20) - 10 };
				for (int i = 0; i < 3; i++) {
					p.drawLine((int) (center + getXY(A[i], B[i], C[i], 1)),
							(int) (center2 + getXY(A[i], B[i], C[i], 2)),
							(int) (center + getXY(-A[i], -B[i], -C[i], 1)),
							(int) (center2 + getXY(-A[i], -B[i], -C[i], 2)));
				}
				p.drawLine((int) (center + getXY(A[0], 0, 0, 1)),
						(int) (center2 + getXY(A[0], 0, 0, 2)),
						(int) (center + getXY(A[0] - 2, 0, -2, 1)),
						(int) (center2 + getXY(A[0] - 2, 0, -2, 2)));
				p.drawLine((int) (center + getXY(-A[0], 0, 0, 1)),
						(int) (center2 + getXY(-A[0], 0, 0, 2)),
						(int) (center + getXY(-A[0] + 2, 0, 2, 1)),
						(int) (center2 + getXY(-A[0] + 2, 0, 2, 2)));
				p.drawLine((int) (center + getXY(A[0], 0, 0, 1)),
						(int) (center2 + getXY(A[0], 0, 0, 2)),
						(int) (center + getXY(A[0] - 2, 0, 2, 1)),
						(int) (center2 + getXY(A[0] - 2, 0, 2, 2)));
				p.drawLine((int) (center + getXY(-A[0], 0, 0, 1)),
						(int) (center2 + getXY(-A[0], 0, 0, 2)),
						(int) (center + getXY(-A[0] + 2, 0, -2, 1)),
						(int) (center2 + getXY(-A[0] + 2, 0, -2, 2)));
				p.drawLine((int) (center + getXY(0, B[1], 0, 1)),
						(int) (center2 + getXY(0, B[1], 0, 2)),
						(int) (center + getXY(-2, B[1] - 2, 0, 1)),
						(int) (center2 + getXY(-2, B[1] - 2, 0, 2)));
				p.drawLine((int) (center + getXY(0, -B[1], 0, 1)),
						(int) (center2 + getXY(0, -B[1], 0, 2)),
						(int) (center + getXY(2, -B[1] + 2, 0, 1)),
						(int) (center2 + getXY(2, -B[1] + 2, 0, 2)));
				p.drawLine((int) (center + getXY(0, B[1], 0, 1)),
						(int) (center2 + getXY(0, B[1], 0, 2)),
						(int) (center + getXY(2, B[1] - 2, 0, 1)),
						(int) (center2 + getXY(2, B[1] - 2, 0, 2)));
				p.drawLine((int) (center + getXY(0, -B[1], 0, 1)),
						(int) (center2 + getXY(0, -B[1], 0, 2)),
						(int) (center + getXY(-2, -B[1] + 2, 0, 1)),
						(int) (center2 + getXY(-2, -B[1] + 2, 0, 2)));
				p.drawLine((int) (center + getXY(0, 0, C[2], 1)),
						(int) (center2 + getXY(0, 0, C[2], 2)),
						(int) (center + getXY(2, 0, C[2] - 2, 1)),
						(int) (center2 + getXY(2, 0, C[2] - 2, 2)));
				p.drawLine((int) (center + getXY(0, 0, C[2], 1)),
						(int) (center2 + getXY(0, 0, C[2], 2)),
						(int) (center + getXY(-2, 0, C[2] - 2, 1)),
						(int) (center2 + getXY(-2, 0, C[2] - 2, 2)));
				p.drawLine((int) (center + getXY(0, 0, -C[2], 1)),
						(int) (center2 + getXY(0, 0, -C[2], 2)),
						(int) (center + getXY(2, 0, -C[2] + 2, 1)),
						(int) (center2 + getXY(2, 0, -C[2] + 2, 2)));
				p.drawLine((int) (center + getXY(0, 0, -C[2], 1)),
						(int) (center2 + getXY(0, 0, -C[2], 2)),
						(int) (center + getXY(-2, 0, -C[2] + 2, 1)),
						(int) (center2 + getXY(-2, 0, -C[2] + 2, 2)));
				p.drawString(
						"X",
						(int) (center + getXY((this.getHeight() / 20) - 7.5, 0,
								0, 1)),
						(int) (center2 + getXY((this.getHeight() / 20) - 7.5,
								0, 0, 2)));
				p.drawString(
						"Y",
						(int) (center + getXY(0, (this.getHeight() / 20) - 7.5,
								0, 1)),
						(int) (center2 + getXY(0,
								(this.getHeight() / 20) - 7.5, 0, 2)));
				p.drawString(
						"Z",
						(int) (center + getXY(0, 0,
								(this.getHeight() / 20) - 7.5, 1)),
						(int) (center2 + getXY(0, 0,
								(this.getHeight() / 20) - 7.5, 2)));
				int[][] circle = new int[2][360];
				for (int i = 0; i < 360; i++) {
					circle[0][i] = (int) center
							+ (int) getXY(
									(A[0] * Math.sin(i / (180 / Math.PI))),
									(A[0] * Math.cos(i / (180 / Math.PI))), 0,
									1);
					circle[1][i] = (int) center2
							+ (int) getXY(
									(A[0] * Math.sin(i / (180 / Math.PI))),
									(A[0] * Math.cos(i / (180 / Math.PI))), 0,
									2);
				}
				p.drawPolygon(circle[0], circle[1], 360);
				for (int i = 0; i < 360; i++) {
					circle[0][i] = (int) center
							+ (int) getXY(
									(A[0] * Math.sin(i / (180 / Math.PI))), 0,
									(A[0] * Math.cos(i / (180 / Math.PI))), 1);
					circle[1][i] = (int) center2
							+ (int) getXY(
									(A[0] * Math.sin(i / (180 / Math.PI))), 0,
									(A[0] * Math.cos(i / (180 / Math.PI))), 2);
				}
				p.drawPolygon(circle[0], circle[1], 360);
				for (int i = 0; i < 360; i++) {
					circle[0][i] = (int) center
							+ (int) getXY(0,
									(A[0] * Math.sin(i / (180 / Math.PI))),
									(A[0] * Math.cos(i / (180 / Math.PI))), 1);
					circle[1][i] = (int) center2
							+ (int) getXY(0,
									(A[0] * Math.sin(i / (180 / Math.PI))),
									(A[0] * Math.cos(i / (180 / Math.PI))), 2);
				}
				p.drawPolygon(circle[0], circle[1], 360);
			}

		}

	}

	public void NewPlane(double pX1, double pY1, double pZ1, double pX2,
			double pY2, double pZ2, double pX3, double pY3, double pZ3,
			double pX4, double pY4, double pZ4) {
		for (int i = 0; i < zeros.length; i++)
			zeros[i] = new SpinnerNumberModel(0, -1000, 1000, .1);
		PLANE PLCs[] = new PLANE[PLC.length + 1];
		for (int i = 0; i < PLC.length; i++) {
			PLCs[i] = PLC[i];
		}
		double[] x = { pX1, pX2, pX3, pX4 }, y = { pY1, pY2, pY3, pY4 }, z = {
				pZ1, pZ2, pZ3, pZ4 };
		PLCs[PLC.length] = new PLANE(x, y, z, new Color(100, 100, 100));
		PLC = new PLANE[PLCs.length];
		for (int i = 0; i < PLC.length; i++)
			PLC[i] = PLCs[i];
	}

	public void NewPoint(double Xs, double Ys, double Zs) {
		for (int i = 0; i < zeros.length; i++)
			zeros[i] = new SpinnerNumberModel(0, -1000, 1000, .1);
		POINT PCs[] = new POINT[PC.length + 1];
		for (int i = 0; i < PC.length; i++) {
			PCs[i] = PC[i];
		}
		PCs[PC.length] = new POINT(Xs, Ys, Zs);
		PC = new POINT[PCs.length];
		for (int i = 0; i < PC.length; i++)
			PC[i] = PCs[i];

	}

	public void NewLine(double Xs1, double Ys1, double Zs1, double Xs2,
			double Ys2, double Zs2) {
		for (int i = 0; i < zeros.length; i++)
			zeros[i] = new SpinnerNumberModel(0, -1000, 1000, .1);
		LINE LCs[] = new LINE[LC.length + 1];
		for (int i = 0; i < LC.length; i++)
			LCs[i] = LC[i];
		LCs[LC.length] = new LINE(Xs1, Ys1, Zs1, Xs2, Ys2, Zs2);
		LC = new LINE[LCs.length];
		for (int i = 0; i < LC.length; i++) {
			LC[i] = LCs[i];
		}
	}

	public void SaveAs() throws IOException {
		JFileChooser JFC = new JFileChooser(System.getProperty("user.home")
				+ "\\Desktop");
		JFC.showSaveDialog(JFC);
		filename = JFC.getSelectedFile().toString();
		fixFile();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == point && !IDP) {
			drawingPanel(1);
		}
		if (arg0.getSource() == createP) {
			NewPoint(Double.parseDouble(X.getValue().toString()),
					Double.parseDouble(Y.getValue().toString()),
					Double.parseDouble(Z.getValue().toString()));
			this.remove(drawing);
			IDP = false;
			if (managing)
				manager();
		}
		if (arg0.getSource() == createPL) {
			NewPlane(Double.parseDouble(pX[0].getValue().toString()),
					Double.parseDouble(pY[0].getValue().toString()),
					Double.parseDouble(pZ[0].getValue().toString()),
					Double.parseDouble(pX[1].getValue().toString()),
					Double.parseDouble(pY[1].getValue().toString()),
					Double.parseDouble(pZ[1].getValue().toString()),
					Double.parseDouble(pX[2].getValue().toString()),
					Double.parseDouble(pY[2].getValue().toString()),
					Double.parseDouble(pZ[2].getValue().toString()),
					Double.parseDouble(pX[3].getValue().toString()),
					Double.parseDouble(pY[3].getValue().toString()),
					Double.parseDouble(pZ[3].getValue().toString()));
			this.remove(drawing);
			IDP = false;
			if (managing)
				manager();
		}
		if (arg0.getSource() == changePLcolor)
			colorChooser();
		if (arg0.getSource() == colorCancel) {
			EditingCL = false;
			colorPanel.removeAll();
			this.remove(colorPanel);
		}
		if (arg0.getSource() == createL) {
			NewLine(Double.parseDouble(X1.getValue().toString()),
					Double.parseDouble(Y1.getValue().toString()),
					Double.parseDouble(Z1.getValue().toString()),
					Double.parseDouble(X2.getValue().toString()),
					Double.parseDouble(Y2.getValue().toString()),
					Double.parseDouble(Z2.getValue().toString()));
			this.remove(drawing);
			IDP = false;
			if (managing)
				manager();
		}
		if (arg0.getSource() == cancel) {
			this.remove(drawing);
			IDP = false;
		}
		if (arg0.getSource() == newfile) {
			filename = null;
			LC = new LINE[0];
			PC = new POINT[0];
			PLC = new PLANE[0];
		}
		if (managing) {
			for (int i = 0; i < planes.length; i++)
				if (arg0.getSource() == planes[i]) {
					showPlaneData(i);
					highlightedPlane = PLC[i];
					highlightPlane = true;
					highlightPoint = false;
					highlightLine = false;
				}
			for (int i = 0; i < points.length; i++)
				if (arg0.getSource() == points[i]) {
					showPointData(i);
					highlightedPoint = PC[i];
					highlightPoint = true;
					highlightLine = false;
					highlightPlane = false;
				}
			for (int i = 0; i < lines.length; i++)
				if (arg0.getSource() == lines[i]) {
					showLineData(i);
					highlightedLine = LC[i];
					highlightLine = true;
					highlightPoint = false;
					highlightPlane = false;
				}
		}
		if (arg0.getSource() == line && !IDP) {
			drawingPanel(2);
		}
		if (arg0.getSource() == plane && !IDP) {
			drawingPanel(3);
		}
		if (arg0.getSource() == savefile) {
			try {
				fixFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (arg0.getSource() == cancelP || arg0.getSource() == Lcancel
				|| arg0.getSource() == PLcancel) {
			editing.removeAll();
			this.remove(editing);
			highlightLine = false;
			highlightPoint = false;
			highlightPlane = false;
			EditingPL = false;
			EditingL = false;
			EditingP = false;
			EditingCL = false;
			colorPanel.removeAll();
			this.remove(colorPanel);
		}
		if (arg0.getSource() == deleteL)
			deleteLine(editL);
		if (arg0.getSource() == deleteP)
			deletePoint(editP);
		if (arg0.getSource() == deletePL)
			deletePlane(editPL);
		if (arg0.getSource() == showManager && !managing) {
			labels = true;
			manager();
			arg0.setSource(control);
		}
		if (arg0.getSource() == showManager && managing) {
			labels = false;
			managing = false;
			showManager.setText("Open Manager");
			this.remove(p);
		}
		if (arg0.getSource() == saveAs) {
			try {
				SaveAs();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (arg0.getSource() == getfile) {
			JFileChooser JFC = new JFileChooser(System.getProperty("user.home")
					+ "\\Desktop");
			JFC.showOpenDialog(JFC);
			filename = JFC.getSelectedFile().toString();
			try {
				redefineArrays();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public void redefineArrays() throws FileNotFoundException {
		File file = new File(filename);
		Scanner scan = new Scanner(file), scan1 = new Scanner(file);
		int lines = 0, L = 0, P = 0, R = 0;
		while (scan.hasNextLine()) {
			String cur = scan.nextLine();
			if (cur.startsWith("l"))
				L++;
			if (cur.startsWith("p"))
				P++;
			if (cur.startsWith("r"))
				R++;
			lines++;
		}
		double line[] = new double[6];
		LC = new LINE[L];
		PC = new POINT[P];
		PLC = new PLANE[R];
		String cLine;
		int l = 0, p = 0, r = 0;
		for (int i = 0; i < lines; i++) {
			cLine = scan1.nextLine();
			if (cLine.startsWith("l")) {
				char spacer[] = { '!', '@', '#', '~', '$', '%', '&' };
				int space[] = new int[7];
				for (int j = 0; j < 7; j++)
					space[j] = cLine.indexOf(spacer[j]);
				for (int k = 0; k < 6; k++)
					line[k] = Double.parseDouble(cLine.substring(space[k] + 1,
							space[k + 1]));
				LC[l] = new LINE(line[0], line[1], line[2], line[3], line[4],
						line[5]);
				l++;
			} else if (cLine.startsWith("p")) {
				char spacer[] = { '!', '@', '#', '$' };
				int space[] = new int[4];
				for (int j = 0; j < 4; j++)
					space[j] = cLine.indexOf(spacer[j]);
				for (int k = 0; k < 3; k++)
					line[k] = Double.parseDouble(cLine.substring(space[k] + 1,
							space[k + 1]));
				PC[p] = new POINT(line[0], line[1], line[2]);
				p++;
			} else if (cLine.startsWith("r")) {
				int v[] = new int[3];
				double coor[][] = new double[3][4];
				String Points[] = new String[5];
				char spacer[] = { '!', '@', '#', '$', '&', '~' };
				int space[] = new int[6];
				for (int j = 0; j < 6; j++)
					space[j] = cLine.indexOf(spacer[j]);
				for (int k = 0; k < 5; k++) {
					Points[k] = cLine.substring(space[k] + 1, space[k + 1]);
					char Spcr[] = { '{', '%', '?', '}' };
					int Spc[] = new int[4];
					for (int j = 0; j < 4; j++)
						Spc[j] = Points[k].indexOf(Spcr[j]);
					if (k < 4)
						for (int j = 0; j < 3; j++)
							coor[j][k] = Double.parseDouble(Points[k]
									.substring(Spc[j] + 1, Spc[j + 1]));
					else
						for (int j = 0; j < 3; j++)
							v[j] = Integer.parseInt(Points[k].substring(
									Spc[j] + 1, Spc[j + 1]));

				}
				PLC[r] = new PLANE(coor[0], coor[1], coor[2], new Color(v[0],
						v[1], v[2]));
				r++;
			}
		}
	}

	public void fixFile() throws IOException {
		File f = new File(filename);
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		String s = "";
		bw.write("");
		for (int i = 0; i < LC.length; i++) {
			s += "l!" + LC[i].X1 + "@" + LC[i].Y1 + "#" + LC[i].Z1 + "~"
					+ LC[i].X2 + "$" + LC[i].Y2 + "%" + LC[i].Z2 + "&\n";
		}
		for (int i = 0; i < PC.length; i++) {
			s += "p!" + PC[i].X + "@" + PC[i].Y + "#" + PC[i].Z + "$\n";
		}
		for (int i = 0; i < PLC.length; i++) {
			s += "r!{" + PLC[i].X[0] + "%" + PLC[i].Y[0] + "?" + PLC[i].Z[0]
					+ "}@{" + PLC[i].X[1] + "%" + PLC[i].Y[1] + "?"
					+ PLC[i].Z[1] + "}#{" + PLC[i].X[2] + "%" + PLC[i].Y[2]
					+ "?" + PLC[i].Z[2] + "}${" + PLC[i].X[3] + "%"
					+ PLC[i].Y[3] + "?" + PLC[i].Z[3] + "}&{"
					+ PLC[i].c.getRed() + "%" + PLC[i].c.getGreen() + "?"
					+ PLC[i].c.getBlue() + "}~\n";
		}
		bw.write(s);
		bw.close();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		if (arg0.getWheelRotation() < 0)
			zoom *= 1.1;
		if (arg0.getWheelRotation() > 0)
			zoom *= .9;

	}

	public class LINE {

		double X1, Y1, Z1, X2, Y2, Z2, depth1, depth2;

		public LINE(double x1, double y1, double z1, double x2, double y2,
				double z2) {
			X1 = x1;
			Y1 = y1;
			Z1 = z1;
			X2 = x2;
			Y2 = y2;
			Z2 = z2;
		}

		public int getXs1() {
			return (int) getXY(X1, Y1, Z1, 1);
		}

		public int getYs1() {
			return (int) getXY(X1, Y1, Z1, 2);
		}

		public int getXs2() {
			return (int) getXY(X2, Y2, Z2, 1);
		}

		public int getYs2() {
			return (int) getXY(X2, Y2, Z2, 2);
		}

		public double getDepth1() {
			return getXY(X1, Y1, Z1, 3);
		}

		public double getDepth2() {
			return getXY(X2, Y2, Z2, 3);
		}

	}

	/*
	 * 
	 * 
	 * 
	 * public class CIRCLE {
	 * 
	 * 
	 * 
	 * double center,p1,p2;
	 * 
	 * 
	 * 
	 * public CIRCLE(double Center,double P1,double P2){ center = Center; p1 =
	 * 
	 * P1; p2 = P2; }
	 * 
	 * 
	 * 
	 * public double getPoint(){ return 0; } public double getWidth(){ return 0;
	 * 
	 * } public double getHeight(){ return 0; } }
	 */

	public class PLANE {

		double[] X, Y, Z;
		Color c;

		public PLANE(double x[], double y[], double z[], Color C) {
			X = x;
			Y = y;
			Z = z;
			c = C;
		}

		public int getX(int i) {
			return (int) getXY(X[i], Y[i], Z[i], 1);
		}

		public int getY(int i) {
			return (int) getXY(X[i], Y[i], Z[i], 2);
		}

		public int getAverageY() {
			return ((int) getXY(X[0], Y[0], Z[0], 2)
					+ (int) getXY(X[1], Y[1], Z[1], 2)
					+ (int) getXY(X[2], Y[2], Z[2], 1) + (int) getXY(X[3],
						Y[3], Z[3], 2)) / 4;
		}

		public int getAverageX() {
			return ((int) getXY(X[0], Y[0], Z[0], 1)
					+ (int) getXY(X[1], Y[1], Z[1], 2)
					+ (int) getXY(X[2], Y[2], Z[2], 1) + (int) getXY(X[3],
						Y[3], Z[3], 2)) / 4;
		}

		public double getAveragePlaneDepth() {
			return (getXY(X[0], Y[0], Z[0], 3) + getXY(X[1], Y[1], Z[1], 3)
					+ getXY(X[2], Y[2], Z[2], 3) + getXY(X[3], Y[3], Z[3], 3)) / 4;
		}

		public void changeColor(Color C) {
			c = C;
		}

	}

	public class POINT {

		double X, Y, Z;

		public POINT(double x, double y, double z) {
			X = x;
			Y = y;
			Z = z;
		}

		public int getXs() {
			return (int) getXY(X, Y, Z, 1);
		}

		public int getYs() {
			return (int) getXY(X, Y, Z, 2);
		}

		public double getPointDepth() {
			return getXY(X, Y, Z, 3);
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
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		cur = xMoved;
		cur2 = yMoved;
		dragging = false;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		curX = arg0.getPoint().x;
		curY = arg0.getPoint().y;
		if (dragging) {
			xMoved = curX - iX + cur;
			yMoved = curY - iY + cur2;
		}

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

	}

	JPanel panel, drawing = new JPanel(), editing = new JPanel(),
			colorPanel = new JPanel();
	int angleH = 179, angleV = 179, editP, editL, editPL, curX, curY, iX, iY,
			xMoved, yMoved, pressed = 0, cur, cur2;
	boolean dragging = false, managing = false, highlightPoint = false,
			highlightLine = false, EditingP = false, EditingL = false,
			EditingPL = false, highlightPlane = false, up = false,
			down = false, left = false, right = false, stopped = true,
			Axis = false, Grid = false, IDP = false, EditingCL = false,
			labels = false;
	LINE LC[] = new LINE[0], highlightedLine;
	POINT PC[] = new POINT[0], highlightedPoint;
	PLANE PLC[] = new PLANE[0], highlightedPlane;
	double zoom = 1, xRatio = 1, yRatio = 1, zRatio = 1;
	SpinnerModel zeros[] = new SpinnerNumberModel[21],
			spins[] = new SpinnerNumberModel[21], sped;
	JSpinner X1, Y1, Z1, X2, Y2, Z2, X, Y, Z, eX, eY, eZ, eX1, eY1, eZ1, eX2,
			eY2, eZ2, epX[] = new JSpinner[4], epY[] = new JSpinner[4],
			epZ[] = new JSpinner[4], pX[] = new JSpinner[4],
			pY[] = new JSpinner[4], pZ[] = new JSpinner[4], r = new JSpinner(),
			g = new JSpinner(), b = new JSpinner(), Sped = new JSpinner();
	JMenuItem line, point, plane, getfile, savefile, showManager, saveAs,
			newfile;
	JCheckBoxMenuItem xGrid, yGrid, zGrid;
	JRadioButtonMenuItem showAxis;
	JButton control = new JButton(), createP, createL, createPL, cancel,
			points[], lines[], planes[], deleteP, cancelP, deleteL, Lcancel,
			PLcancel, deletePL, changePLcolor, colorCancel;
	JScrollPane p = new JScrollPane();
	String filename;
	Color curColor = new Color(100, 100, 100);
}