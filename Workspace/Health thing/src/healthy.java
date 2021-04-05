import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class healthy extends JFrame implements ActionListener{

	int W=400,H=400;
	
	healthy() throws InterruptedException{
		super("");
		this.setSize(W, H+80);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setVisible(false);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		healthy window = new healthy();
	}

	public class graphic extends JPanel{
		
		public void paint(Graphics p){
			
			}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
