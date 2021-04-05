import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class PlayerAdd extends JFrame implements ActionListener{
	JLabel stat[]=new JLabel[13];
	JTextField Stat[]=new JTextField[14];
	PlayerAdd(){
		super("Add Player");
		this.setLayout(new GridLayout(15,2));
		this.setSize(400,600);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}

}
