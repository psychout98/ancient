import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Clock extends JFrame implements ActionListener{
	JButton button = new JButton("Blackman");
	JPanel panel = new JPanel();
	private static  Clockpanel clock;
	static boolean close=true;
	static boolean open = false;
	static boolean black = false;
	int one=0;
	int two=0;
	int three=0;
	Clock() throws InterruptedException{
		super("Clock");
		init();
		this.setSize(700,600);
		this.setVisible(true);
		while(true){
			Thread.sleep(200);
			close=false;
			open=true;
			repaint();
			Thread.sleep(200);
			open=false;
			close=true;
			repaint();
			one++;
			two++;
			three++;
		}
		
	}
	public void init(){
		clock = new Clockpanel();
		button.addActionListener(this);
		panel.add(button);
		this.add(panel, BorderLayout.WEST);
		this.add(clock, BorderLayout.CENTER);
	}
	public static void main(String[]args) throws InterruptedException{
		
		Clock window=new Clock();
		window.setDefaultCloseOperation(3);

	}
	private class Clockpanel extends JPanel{
		public void paintComponent(Graphics g){
			
		
			if(black){
				int [] x={250,600,600},y={250,50,450};
				g.setColor(Color.blue);
				g.fillRect(0,0,600,600);
				g.setColor(new Color(137,109,85));
				g.fillOval(0,0, 500,500);
				g.setColor(Color.BLACK);
				g.fillOval(300, 30, 20, 20);
				if(close){
					g.setColor(Color.BLACK);
				g.drawLine(250, 250, 500, 250);
				
				}
				if(open){
					
					g.setColor(Color.blue);
					g.fillPolygon(x,y,3);
					g.setColor(Color.BLACK);
					g.setFont(new Font("Times New Roman",Font.BOLD,30));
					g.drawString("NIGGA", 250, 520);
			}
			}
			else{
				int [] x={250,600,600},y={250,50,450};
				g.setColor(Color.blue);
				g.fillRect(0,0,600,600);
		g.setColor(Color.yellow);
			g.fillOval(0,0, 500,500);
			g.setColor(Color.black);
			g.fillOval(300, 30, 20, 20);
			if(close){
				g.setColor(Color.BLACK);
			g.drawLine(250, 250, 500, 250);
			
			}
			if(open){
				g.setColor(Color.blue);
				g.fillPolygon(x,y,3);
				g.setColor(Color.green);
				g.setFont(new Font("Times New Roman",Font.BOLD,30));
			g.drawString("WAKA", 250,520);
			}
			}
		}
		}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==button){
			black=true;
			this.remove(panel);
		}}}
