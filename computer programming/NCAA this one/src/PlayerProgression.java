import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerProgression extends JFrame implements ActionListener {

	public static double OverallProgression;
	JPanel left = new JPanel(new GridLayout(10, 1)), right = new JPanel(
			new GridLayout(10, 10));
	JLabel Stat[] = new JLabel[10];
	JTextField stat[][] = new JTextField[10][10];
	JButton CalculateProgression = new JButton("Calculate Progression");

	PlayerProgression() {
		super("Progression Chart");
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				stat[i][j] = new JTextField();
		Stat[0] = new JLabel("Offensive Rebounds----------");
		Stat[1] = new JLabel("Defensive Rebounds----------");
		Stat[2] = new JLabel("Assists---------------------");
		Stat[3] = new JLabel("Steals----------------------");
		Stat[4] = new JLabel("Blocks----------------------");
		Stat[5] = new JLabel("Turnovers-------------------");
		Stat[6] = new JLabel("Personal Fouls--------------");
		Stat[7] = new JLabel("Field Goals-----------------");
		Stat[8] = new JLabel("3-Point Field Goals---------");
		Stat[9] = new JLabel("Free Throws-----------------");
		for (int i = 0; i < 10; i++)
			left.add(Stat[i]);
		this.add(CalculateProgression,BorderLayout.SOUTH);
		CalculateProgression.addActionListener(this);
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				right.add(stat[i][j]);
		this.add(right, BorderLayout.CENTER);
		this.add(left, BorderLayout.WEST);
		this.setSize(500, 400);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == CalculateProgression)
			Calculate();
	}

	public void Calculate() {
		PlayerAdd.progress.setVisible(false);
		double avg[] = new double[10],total=0;
		int Stat[][] = new int[10][10];
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				Stat[i][j] = Integer.parseInt(stat[i][j].getText());
		for (int i = 1; i < 10; i++){
			for(int j=0;j<9;j++)
			avg[i] = avg[i]+(Stat[i][j+1] - Stat[i][j]);
			avg[i]=avg[i]/9;
			total = total+avg[i];
		}
		OverallProgression=total/10;
		PlayerAdd.Progress=OverallProgression;
		PlayerAdd.stat[14].setText(""+OverallProgression);
	}

}
