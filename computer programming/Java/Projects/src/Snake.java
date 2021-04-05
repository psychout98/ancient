import java.awt.Color;

import java.awt.Dimension;

import java.awt.Font;

import java.awt.Graphics;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import java.awt.event.MouseWheelEvent;

import java.awt.event.MouseWheelListener;

import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;

import javax.swing.BorderFactory;

import javax.swing.JButton;

import javax.swing.JFileChooser;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JMenu;

import javax.swing.JMenuBar;

import javax.swing.JMenuItem;

import javax.swing.JPanel;

import javax.swing.JRadioButtonMenuItem;

import javax.swing.JSpinner;

import javax.swing.JTextPane;

import javax.swing.SpinnerModel;

import javax.swing.SpinnerNumberModel;

public class draw extends JFrame implements KeyListener, ActionListener, MouseWheelListener {
    
    JPanel panel,drawing;
    
    int angleH = 270, angleV = 180;
    
    boolean up = false, down = false, left = false, right = false,
    
    lineFull = false, pointFull = false,stopped = true,Axis = false,Grid=false,IDP=false;
    
    double x1[] = new double[0], y1[] = new double[0], z1[] = new double[0],
    
    x2[] = new double[0], y2[] = new double[0], z2[] = new double[0],zoom=1;
    
    SpinnerModel zeros[] = new SpinnerNumberModel[9];
    
    JSpinner X1, Y1, Z1, X2, Y2, Z2, X, Y, Z;
    
    JMenuItem line, point, getfile,savefile,saveAs;
    
    JRadioButtonMenuItem showGrid,showAxis;
    
    JButton control = new JButton(),createP,createL,cancel;
    
    String filename;
    
    draw() throws InterruptedException, FileNotFoundException {
        
        super("3D Model");
        
        for(int i=0;i<zeros.length;i++)
            
            zeros[i]= new SpinnerNumberModel(0, -1000, 1000, .1);
        
        this.setSize(800, 800);
        
        this.setVisible(false);
        
        this.setDefaultCloseOperation(3);
        
        filename = "H:\\Downloads\\Arrays (1).txt";
        
        redefineArrays();
        
        panel = new cube();
        
        control = new JButton("Control");
        
        control.addKeyListener(this);
        
        this.addKeyListener(this);
        
        this.addMouseWheelListener(this);
        
        this.setLayout(null);
        
        JMenuBar mb = new JMenuBar();
        
        JMenu file = new JMenu("File");
        
        getfile = new JMenuItem("Open");
        
        savefile = new JMenuItem("Save");
        
        saveAs = new JMenuItem("Save As");
        
        JMenu create = new JMenu("Create");
        
        line = new JMenuItem("Line");
        
        point = new JMenuItem("Point");
        
        JMenu fmt = new JMenu("Format");
        
        showGrid = new JRadioButtonMenuItem("Show Grid");
        
        showAxis = new JRadioButtonMenuItem("Show Axis");
        
        getfile.addActionListener(this);
        
        savefile.addActionListener(this);
        
        saveAs.addActionListener(this);
        
        line.addActionListener(this);
        
        point.addActionListener(this);
        
        showGrid.addActionListener(this);
        
        showAxis.addActionListener(this);
        
        file.add(getfile);
        
        file.add(savefile);
        
        file.add(saveAs);
        
        create.add(line);
        
        create.add(point);
        
        fmt.add(showGrid);
        
        fmt.add(showAxis);
        
        mb.add(file);
        
        mb.add(create);
        
        mb.add(fmt);
        
        this.add(panel);
        
        panel.setSize(this.getWidth(),this.getHeight());
        
        panel.setLocation(0, 0);
        
        this.add(control);
        
        control.setSize(80, 80);
        
        control.setLocation(this.getWidth()-80, 0);
        
        this.setJMenuBar(mb);
        
        Thread.sleep(500);
        
        this.setVisible(true);
        
        while (true) {
            
            Axis=showAxis.isSelected();
            
            Grid=showGrid.isSelected();
            
            panel.setSize(this.getWidth(),this.getHeight());
            
            control.setLocation(this.getWidth()-100, 0);
            
            if (up)
                
                angleV++;
            
            if (down)
                
                angleV--;
            
            if (left)
                
                angleH--;
            
            if (right)
                
                angleH++;
            
            if (angleV > 360)
                
                angleV = 0;
            
            if (angleV < 0)
                
                angleV = 360;
            
            if (angleH > 360)
                
                angleH = 0;
            
            if (angleH < 0)
                
                angleH = 360;
            
            Thread.sleep(15);
            
            repaint();
            
        }
        
    }
    
    public void drawingPanel(int type){
        
        IDP = true;
        
        drawing = new JPanel();
        
        drawing.setBackground(Color.white);
        
        drawing.setBorder(BorderFactory.createLineBorder(Color.black));
        
        if(type == 1){
            
            drawing.setLayout(new GridLayout(4,2));
            
            X = new JSpinner(zeros[0]);
            
            Y = new JSpinner(zeros[1]);
            
            Z = new JSpinner(zeros[2]);
            
            X.setBorder(BorderFactory.createLineBorder(Color.black));
            
            Y.setBorder(BorderFactory.createLineBorder(Color.black));
            
            Z.setBorder(BorderFactory.createLineBorder(Color.black));
            
            JLabel labels[] = {new JLabel(" X: "),new JLabel(" Y: "),new JLabel(" Z: ")};
            
            Font f = new Font("Times New Roman",0,12);
            
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
            
            drawing.setSize(150,120);
            
        }
        
        else if(type == 2){
            
            drawing.setLayout(new GridLayout(3,1));
            
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
            
            JLabel labels[] = {new JLabel(" X1:"),new JLabel(" Y1:"),new JLabel(" Z1:"),new JLabel(" X2:"),new JLabel(" Y2:"),new JLabel(" Z2:")};
            
            Font f = new Font("Times New Roman",0,12);
            
            createL = new JButton("Create");
            
            cancel = new JButton("Cancel");
            
            createL.setFont(f);
            
            cancel.setFont(f);
            
            createL.addActionListener(this);
            
            cancel.addActionListener(this);
            
            JPanel p[] = new JPanel[3];
            
            p[0] = new JPanel(new GridLayout(1,6));
            
            p[1] = new JPanel(new GridLayout(1,6));
            
            p[2] = new JPanel(new GridLayout(1,2));
            
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
            
            drawing.setSize(300,120);
            
        }
        
        this.add(drawing);
        
        drawing.setLocation(0,0);
        
        validate();
        
    }
    
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        
        draw window = new draw();
        
    }
    
    public void addPoints(double Xs1, double Ys1, double Zs1, double Xs2, double Ys2,
                          
                          double Zs2) {
        
        for(int i=0;i<zeros.length;i++)
            
            zeros[i]= new SpinnerNumberModel(0, -1000, 1000, .1);
        
        pointFull=false;
        
        double xs[] = new double[x1.length+1],
        
        ys[] = new double[x1.length+1],
        
        zs[] = new double[x1.length+1],
        
        x2s[] = new double[x1.length+1],
        
        y2s[] = new double[x1.length+1],
        
        z2s[] = new double[x1.length+1];
        
        for(int i=0;i<x1.length;i++){
            
            xs[i]=x1[i];
            
            ys[i]=y1[i];
            
            zs[i]=z1[i];
            
            x2s[i]=x2[i];
            
            y2s[i]=y2[i];
            
            z2s[i]=z2[i];
            
        }
        
        xs[x1.length] = (Xs1);
        
        ys[y1.length] = (Ys1);
        
        zs[z1.length] = (Zs1);
        
        x2s[x2.length] = (Xs2);
        
        y2s[y2.length] = (Ys2);
        
        z2s[z2.length] = (Zs2);
        
        x1 = new double[xs.length];
        
        y1 = new double[xs.length];
        
        z1 = new double[xs.length];
        
        x2 = new double[xs.length];
        
        y2 = new double[xs.length];
        
        z2 = new double[xs.length];
        
        for(int i=0;i<x1.length;i++){
            
            x1[i]=xs[i];
            
            y1[i]=ys[i];
            
            z1[i]=zs[i];
            
            x2[i]=x2s[i];
            
            y2[i]=y2s[i];
            
            z2[i]=z2s[i];
            
        }
        
    }
    
    　
    
    @Override
    
    public void keyPressed(KeyEvent arg0) {
        
        if(arg0.getSource() == control){
            
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
        
        if(arg0.getKeyCode() == KeyEvent.VK_CONTROL && arg0.getKeyCode() == KeyEvent.VK_SHIFT && arg0.getKeyCode()==KeyEvent.VK_P && !IDP)
            
            drawingPanel(1);
        
        if(arg0.getKeyCode() == KeyEvent.VK_CONTROL&&arg0.getKeyCode() == KeyEvent.VK_SHIFT && arg0.getKeyCode()==KeyEvent.VK_L && !IDP)
            
            drawingPanel(2);
        
    }
    
    @Override
    
    public void keyReleased(KeyEvent arg0) {
        
        if(arg0.getSource() == control){
            
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
        
        public void paint(Graphics p) {
            
            double center = this.getWidth() / 2,center2=this.getHeight()/2;
            
            if(Axis){
                
                double[] A={(this.getHeight()/20)-10,0,0},B={0,(this.getHeight()/20)-10,0},C={0,0,(this.getHeight()/20)-10};
                
                for(int i=0;i<3;i++){
                    
                    p.drawLine((int)(center + getXY(A[i], B[i], C[i], true)),
                               
                               (int)(center2 + getXY(A[i], B[i], C[i], false)),
                               
                               (int)(center + getXY(-A[i], -B[i], -C[i], true)),
                               
                               (int)(center2 + getXY(-A[i], -B[i], -C[i], false)));
                    
                }
                
                p.drawLine((int)(center + getXY(A[0],0,0,true)), (int)(center2 + getXY(A[0],0,0,false)), (int)(center + getXY(A[0]-2,0,-2,true)), (int)(center2+ getXY(A[0]-2,0,-2,false)));
                
                p.drawLine((int)(center + getXY(-A[0],0,0,true)), (int)(center2 + getXY(-A[0],0,0,false)), (int)(center + getXY(-A[0]+2,0,2,true)), (int)(center2+ getXY(-A[0]+2,0,2,false)));
                
                p.drawLine((int)(center + getXY(A[0],0,0,true)), (int)(center2 + getXY(A[0],0,0,false)), (int)(center + getXY(A[0]-2,0,2,true)), (int)(center2 + getXY(A[0]-2,0,2,false)));
                
                p.drawLine((int)(center + getXY(-A[0],0,0,true)), (int)(center2 + getXY(-A[0],0,0,false)), (int)(center + getXY(-A[0]+2,0,-2,true)), (int)(center2 + getXY(-A[0]+2,0,-2,false)));
                
                p.drawLine((int)(center + getXY(0,B[1],0,true)), (int)(center2 + getXY(0,B[1],0,false)), (int)(center + getXY(-2,B[1]-2,0,true)), (int)(center2 + getXY(-2,B[1]-2,0,false)));
                
                p.drawLine((int)(center + getXY(0,-B[1],0,true)), (int)(center2 + getXY(0,-B[1],0,false)), (int)(center + getXY(2,-B[1]+2,0,true)), (int)(center2 + getXY(2,-B[1]+2,0,false)));
                
                p.drawLine((int)(center + getXY(0,B[1],0,true)), (int)(center2 + getXY(0,B[1],0,false)), (int)(center + getXY(2,B[1]-2,0,true)), (int)(center2 + getXY(2,B[1]-2,0,false)));
                
                p.drawLine((int)(center + getXY(0,-B[1],0,true)), (int)(center2 + getXY(0,-B[1],0,false)), (int)(center + getXY(-2,-B[1]+2,0,true)), (int)(center2 + getXY(-2,-B[1]+2,0,false)));
                
                p.drawLine((int)(center + getXY(0,0,C[2],true)), (int)(center2 + getXY(0,0,C[2],false)), (int)(center + getXY(2,0,C[2]-2,true)), (int)(center2 + getXY(2,0,C[2]-2,false)));
                
                p.drawLine((int)(center + getXY(0,0,C[2],true)), (int)(center2 + getXY(0,0,C[2],false)), (int)(center + getXY(-2,0,C[2]-2,true)), (int)(center2 + getXY(-2,0,C[2]-2,false)));
                
                p.drawLine((int)(center + getXY(0,0,-C[2],true)), (int)(center2 + getXY(0,0,-C[2],false)), (int)(center + getXY(2,0,-C[2]+2,true)), (int)(center2 + getXY(2,0,-C[2]+2,false)));
                
                p.drawLine((int)(center + getXY(0,0,-C[2],true)), (int)(center2 + getXY(0,0,-C[2],false)), (int)(center + getXY(-2,0,-C[2]+2,true)), (int)(center2 + getXY(-2,0,-C[2]+2,false)));
                
                p.drawString("X", (int)(center + getXY((this.getHeight()/20)-7.5,0,0,true)), (int)(center2 + getXY((this.getHeight()/20)-7.5,0,0,false)));
                
                p.drawString("Y", (int)(center + getXY(0,(this.getHeight()/20)-7.5,0,true)), (int)(center2 + getXY(0,(this.getHeight()/20)-7.5,0,false)));
                
                p.drawString("Z", (int)(center + getXY(0,0,(this.getHeight()/20)-7.5,true)), (int)(center2 + getXY(0,0,(this.getHeight()/20)-7.5,false)));
                
            }
            
            for (int i = 0; i < x1.length; i++)
                
                p.drawLine((int)(center+(zoom*getXY(x1[i], y1[i], z1[i], true))),
                           
                           (int)(center2+(zoom*getXY(x1[i], y1[i], z1[i], false))),
                           
                           (int)(center+(zoom*getXY(x2[i], y2[i], z2[i], true))),
                           
                           (int)(center2+(zoom*getXY(x2[i], y2[i], z2[i], false))));
            
        }
        
        public int getXY(double x, double y, double z, boolean XY) {
            
            x+=.0001;
            
            y+=.0001;
            
            z+=.0001;
            
            x*=10;
            
            y*=10;
            
            z*=10;
            
            int q = y < 0 ? (z < 0 ? 3 : 2) : (z < 0 ? 4 : 1);
            
            double radH = angleH / (180 / Math.PI),
            
            radV = angleV/ (180 / Math.PI),
            
            cP = x * Math.sin(radH + (Math.PI / 2)),
            
            r = Math.sqrt((y * y) + (z * z)),
            
            sA = q==1||q==4?Math.asin(z / r):Math.PI-Math.asin(z/r),
            
            sH = radH;
            
            int X = (int) (cP + (r * Math.sin(sH) * Math.cos(radV+ sA))),
            
            Y = (int) (r * Math.sin(radV + sA));
            
            return XY ? X : Y;
            
        }
        
    }
    
    public void NewPoint(double x,double y,double z){
        
        addPoints(x,y,z,x,y,z);
        
    }
    
    public void NewLine(double x1, double y1, double z1, double x2, double y2, double z2){
        
        addPoints(x1,y1,z1,x2,y2,z2);
        
    }
    
    public void SaveAs(){
        
    }
    
    @Override
    
    public void actionPerformed(ActionEvent arg0) {
        
        if (arg0.getSource() == point && !IDP){
            
            drawingPanel(1);
            
        }
        
        if(arg0.getSource() == createP){
            
            NewPoint(Double.parseDouble(X.getValue().toString()),Double.parseDouble(Y.getValue().toString()),Double.parseDouble(Z.getValue().toString()));
            
            this.remove(drawing);
            
            IDP = false;
            
        }
        
        if(arg0.getSource()== createL){
            
            NewLine(Double.parseDouble(X1.getValue().toString()),Double.parseDouble(Y1.getValue().toString()),Double.parseDouble(Z1.getValue().toString()),Double.parseDouble(X2.getValue().toString()),Double.parseDouble(Y2.getValue().toString()),Double.parseDouble(Z2.getValue().toString()));
            
            this.remove(drawing);
            
            IDP = false;
            
        }
        
        if(arg0.getSource()==cancel){
            
            this.remove(drawing);
            
            IDP = false;
            
        }
        
        if (arg0.getSource() == line && !IDP){
            
            drawingPanel(2);
            
        }
        
        if(arg0.getSource() == savefile){
            
            fixFile();
            
        }
        
        if(arg0.getSource() == saveAs){
            
            SaveAs();
            
        }
        
        if(arg0.getSource()==getfile){
            
            JFileChooser JFC = new JFileChooser(System
                                                
                                                .getProperty("user.home") + "\\Desktop");
            
            JFC.showOpenDialog(JFC);
            
            filename = JFC.getSelectedFile().toString();
            
            try {
                
                redefineArrays();
                
            } catch (FileNotFoundException e) {
                
                e.printStackTrace();
                
            }
            
        }
        
    }
    
    public void redefineArrays() throws FileNotFoundException{
        
        File file = new File(filename);
        
        Scanner scan = new Scanner(file),scan1 = new Scanner(file);
        
        int lines = -1;
        
        while(scan.hasNextLine()){
            
            scan.nextLine();
            
            lines++;
            
        }
        
        double line[] = new double[6];
        
        x1 = new double[lines];
        
        y1 = new double[lines];
        
        z1 = new double[lines];
        
        x2 = new double[lines];
        
        y2 = new double[lines];
        
        z2 = new double[lines];
        
        String cLine;
        
        for(int i=0;i<lines;i++){
            
            cLine = scan1.nextLine();
            
            if(cLine.startsWith("l")){
                
                char spacer[] = {'!','@','#','~','$','%','&'};
                
                int space[] = new int[7];
                
                for(int j=0;j<7;j++)
                    
                    space[j] = cLine.indexOf(spacer[j]);
                
                for(int k=0;k<6;k++)
                    
                    line[k]=Double.parseDouble(cLine.substring(space[k]+1, space[k+1]));
                
                x1[i] = line[0];
                
                y1[i] = line[1];
                
                z1[i] = line[2];
                
                x2[i] = line[3];
                
                y2[i] = line[4];
                
                z2[i] = line[5];
                
            }
            
            else if(cLine.startsWith("p")){
                
                char spacer[] = {'!','@','#','$'};
                
                int space[] = new int[3];
                
                for(int j=0;j<4;j++)
                    
                    space[j] = cLine.indexOf(spacer[j]);
                
                for(int k=0;k<3;k++)
                    
                    line[k]=Double.parseDouble(cLine.substring(space[k]+1, space[k+1]));
                
                x1[i] = line[0];
                
                y1[i] = line[1];
                
                z1[i] = line[2];
                
                x2[i] = line[0];
                
                y2[i] = line[1];
                
                z2[i] = line[2];
                
            }
            
        }
        
    }
    
    public void fixFile(){
        
    }
    
    @Override
    
    public void mouseWheelMoved(MouseWheelEvent arg0) {
        
        if(arg0.getWheelRotation() < 0)
            
            zoom*=1.1;
        
        if(arg0.getWheelRotation() > 0)
            
            zoom*=.9;
        
    }
    
}