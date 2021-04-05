import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class State extends JFrame implements ActionListener {
	JButton state[] = { new JButton("Alabama"), new JButton("Alaska"), new JButton("American Samoa"),
			new JButton("Arizona"), new JButton("Arkansas"), new JButton("California"), new JButton("Colorado"),
			new JButton("Connecticut"), new JButton("Deleware"), new JButton("D.C."), new JButton("Florida"),
			new JButton("Georgia"), new JButton("Hawaii"), new JButton("Idaho"), new JButton("Illinois"),
			new JButton("Indiana"), new JButton("Iowa"), new JButton("Kansas"), new JButton("Kentucky"),
			new JButton("Louisiana"), new JButton("Maine"), new JButton("Maryland"), new JButton("Massachusets"),
			new JButton("Michigan"), new JButton("Minnesota"), new JButton("Mississippi"), new JButton("Missouri"),
			new JButton("Montana"), new JButton("Nebraska"), new JButton("Nevada"), new JButton("New Hampshire"),
			new JButton("New York"), new JButton("New Jersey"), new JButton("New Mexico"), new JButton("North Carolina"),
			new JButton("North Dakota"), new JButton("Ohio"), new JButton("Oklahoma"), new JButton("Oregon"),
			new JButton("Pennsylvania"), new JButton("South Carolina"), new JButton("Rhode Island"), new JButton("South Dakota"),
			new JButton("Tennessee"), new JButton("Texas"), new JButton("Utah"), new JButton("Vermont"),
			new JButton("Virginia"), new JButton("Washington"), new JButton("West Virginia"),new JButton("Wisconsin"),new JButton("Wyoming") };

	State() {
		super("State");
		this.setVisible(true);
		this.setSize(getMaximumSize());
		this.setLayout(new GridLayout(7,8));
		for(int i=0;i<state.length;i++)
			this.add(state[i]);
	}

	public static void main(String[] args) {
		State window=new State();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
//http://www.ilru.org/html/publications/directory/state_list.html