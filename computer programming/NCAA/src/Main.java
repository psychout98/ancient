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

public class Main extends JFrame implements ActionListener {
	PlayerAdd profile[][] = new PlayerAdd[2][30];
	public static int t1 = 0, t2 = 1, t1Players = 0, t2Players = 0,
			Stat[][][] = new int[2][30][14],
			pStat[][][][] = new int[2][30][14][10], MainTeam = 0,
			PlayedTeam = 1, Game[][][] = new int[2][2][10];
	public static String Player[][] = new String[2][30];
	public static JTextField Team1 = new JTextField("Team 1"), Team2 = new JTextField(
			"Team 2"), GameScore[][][] = new JTextField[2][2][10];
	public static JLabel Title[] = { new JLabel("Players (Ranked)"),
			new JLabel("Result"), new JLabel("Odds"), new JLabel(/* Winner */),
			new JLabel(/*
						 * avg final odds
						 */), new JLabel("Players (Ranked)") },
			vs[][] = new JLabel[2][10], player[][] = new JLabel[2][30];
	public static JButton Team1Progression = new JButton("Calculate Progression"),
			Team2Progression = new JButton("Calculate Progression"),
			Team1PlayerAdd = new JButton("Add Player"),
			Team2PlayerAdd = new JButton("Add Player");

	Main() {
		super("Match Predictor");
		JPanel Team1Players = new JPanel(new GridLayout(32, 1)), Team2Players = new JPanel(
				new GridLayout(32, 1)), Team1Stats = new JPanel(new GridLayout(
				12, 2)), Team2Stats = new JPanel(new GridLayout(12, 2)), Results = new JPanel(
				new GridLayout(30, 1)), Odds = new JPanel(new GridLayout(30, 1)), game[][] = new JPanel[2][10];
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				for (int k = 0; k < 10; k++) {
					GameScore[i][j][k] = new JTextField();
					game[i][k] = new JPanel(new GridLayout(1, 3));
					vs[i][k] = new JLabel("       --");
				}
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 30; j++)
				player[i][j] = new JLabel((j + 1) + Player[i][j]);
		Team1Players.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Team1Players.add(Title[5]);
		for (int i = 0; i < 30; i++)
			Team1Players.add(player[0][i]);
		Team1Players.add(Team1PlayerAdd);
		Team1PlayerAdd.addActionListener(this);
		Team2Players.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Team2Players.add(Title[0]);
		for (int i = 0; i < 30; i++)
			Team2Players.add(player[1][i]);
		Team2Players.add(Team2PlayerAdd);
		Team2PlayerAdd.addActionListener(this);
		Team1Stats.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Team1Stats.add(Team1);
		for (int t = 0; t < 2; t++)
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 2; j++) {
					game[t][i].add(GameScore[t][j][i]);
					if (j == 0)
						game[t][i].add(vs[t][i]);
				}
			}
		for (int i = 0; i < 10; i++)
			Team1Stats.add(game[0][i]);
		Team1Stats.add(Team1Progression);
		Team1Progression.addActionListener(this);
		Team2Stats.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Team2Stats.add(Team2);
		for (int i = 0; i < 10; i++)
			Team2Stats.add(game[1][i]);
		Team2Stats.add(Team2Progression);
		Team2Progression.addActionListener(this);
		Results.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Results.add(Title[1]);
		Odds.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Odds.add(Title[2]);
		this.setLayout(new GridLayout(1, 6));
		this.add(Team1Players);
		this.add(Team1Stats);
		this.add(Results);
		this.add(Odds);
		this.add(Team2Stats);
		this.add(Team2Players);
		this.setSize(1000, 700);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 30; j++)
				Player[i][j] = "";
		Main window = new Main();
		window.setDefaultCloseOperation(3);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == Team1PlayerAdd)
			Team1AddPlayer();
		if (arg0.getSource() == Team2PlayerAdd)
			Team2AddPlayer();
		if (arg0.getSource() == Team1Progression)
			Team1CalculateProgression();
		if (arg0.getSource() == Team2Progression)
			Team2CalculateProgression();
	}

	public void Team1AddPlayer() {
		profile[0][t1Players] = new PlayerAdd();
	}

	public void Team2AddPlayer() {
		profile[1][t2Players] = new PlayerAdd();
	}

	public void Team1CalculateProgression() {

	}

	public void Team2CalculateProgression() {

	}

}
