import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
public class jframeOps extends JFrame implements ActionListener{
	jframeOps(){
		super("JFrame");
		init();
		this.setSize(500,500);
		this.setVisible(true);
	}
	static JButton button = new JButton("Push me");
	public void init(){
		
		JPanel panel = new JPanel(new GridLayout(1,1));
		this.add(panel, BorderLayout.CENTER);
		panel.add(button);
	}
public static void main(String[]args){
	jframeOps window = new jframeOps();
}
@Override
public void actionPerformed(ActionEvent arg0) {
	if(arg0.getSource() == button){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Who said you could push me?");
	}
	
}
}
