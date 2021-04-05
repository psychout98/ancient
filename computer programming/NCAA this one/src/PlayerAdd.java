import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PlayerAdd extends JFrame implements ActionListener {
	static public PlayerProgression progress;
	public static double Statistic[] = new double[14], Progress;
	static JLabel stat[] = new JLabel[15];
	public static JTextField Stat[] = new JTextField[14];
	JButton CalculateProgression = new JButton("Calculate Progression"),
			CreatePlayer = new JButton("Create Player");
	PlayerAdd() {
		super("Add Player");
		this.setLayout(new GridLayout(16, 2));
		stat[0] = new JLabel("Player");
		stat[1] = new JLabel("Offensive Rebounds");
		stat[2] = new JLabel("Defensive Rebounds");
		stat[3] = new JLabel("Assists");
		stat[4] = new JLabel("Steals");
		stat[5] = new JLabel("Blocks");
		stat[6] = new JLabel("Turnovers");
		stat[7] = new JLabel("Personal Fouls");
		stat[8] = new JLabel("Field Goal %");
		stat[9] = new JLabel("3-Point Field Goal %");
		stat[10] = new JLabel("Free Throw %");
		stat[11] = new JLabel("Height (Inches)");
		stat[12] = new JLabel("Time on Team");
		stat[13] = new JLabel("Time Playing");
		stat[14] = new JLabel(""/*progression*/);
		CalculateProgression = new JButton("Calculate Progression");
		CalculateProgression.addActionListener(this);
		CreatePlayer = new JButton("Create Player");
		CreatePlayer.addActionListener(this);
		for(int i=0;i<14;i++)
			Stat[i]= new JTextField();
		for(int i=0;i<14;i++){
			this.add(stat[i]);
			this.add(Stat[i]);
		}
		this.add(CalculateProgression);
		this.add(stat[14]);
		this.add(CreatePlayer);
		this.setSize(350, 600);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==CalculateProgression)
			progress = new PlayerProgression();
		if(arg0.getSource()==CreatePlayer)
			Create();
	}
	public void Create(){
		Main.profile[Main.t][Main.tPlayers[Main.t]].setVisible(false);
		Main.getScore();
	}

}
