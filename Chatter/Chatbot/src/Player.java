import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;


public class Player extends JFrame implements ActionListener{

	int rounds;
	String name;
	JButton done;
	String played[],scores[];
	JTextPane playing[],score[];
	
	Player(int arrayNum){
		name=Main.names[arrayNum];
		rounds = Main.round;
		played = new String[rounds];
		scores = new String[rounds];
		GridLayout gl = new GridLayout(rounds+2,3);
		this.setVisible(true);
		this.setLocation(200, 0);
		this.setDefaultCloseOperation(3);
		this.setLayout(gl);
		done = new JButton("Done");
		JLabel set[] = new JLabel[rounds],titles[]={new JLabel("Player 1"),new JLabel("Player 2"), new JLabel("score (1-2)")};
		playing = new JTextPane[rounds];
		score=new JTextPane[rounds];
		this.add(titles[0]);
		this.add(titles[1]);
		this.add(titles[2]);
		for(int i=0;i<rounds;i++){
			set[i] = new JLabel(name);
			playing[i] = new JTextPane();
			score[i] = new JTextPane();
			playing[i].setBorder(BorderFactory.createLineBorder(Color.black));
			score[i].setBorder(BorderFactory.createLineBorder(Color.black));
			this.add(set[i]);
			this.add(playing[i]);
			this.add(score[i]);
		}
		done.addActionListener(this);
		this.add(done);
		this.setSize(250,70+(rounds*30));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==done){
			for(int i=0;i<rounds;i++){
				scores[i] = score[i].getText();
				played[i] = playing[i].getText();
			}
		}
	}
}
