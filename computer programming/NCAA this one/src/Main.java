import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener {
	public static Font f = new Font("Calibri", Font.BOLD,10);
	public static PlayerAdd profile[][] = new PlayerAdd[2][14];
	public static int playerrank[][]=new int[2][14],playercompare[]=new int[2],t,t1 = 0, t2 = 1, tPlayers[] = {0,0}, MainTeam = 0,
			PlayedTeam = 1, Game[][][] = new int[2][2][10];
	public static double TeamProgression[]=new double[2],PlayerScore[][]=new double[2][14];
	public static String Player[][] = new String[2][14], RankedPlayer[][] = new String[2][14], Winner="";
	public static JTextField Team1 = new JTextField("Team 1"), Team2 = new JTextField(
			"Team 2"), GameScore[][][] = new JTextField[2][2][10];
	public static JLabel Title[] = { new JLabel("Players (Ranked)"),
			new JLabel(), new JLabel("Result    ::    Odds"), new JLabel(Winner),
			new JLabel(/*
						 * avg final odds
						 */), new JLabel("Players (Ranked)") },
			vs[][] = new JLabel[2][10], player[][] = new JLabel[2][14];
	public static JButton Team1Progression = new JButton("Calculate Progress"),
			Team2Progression = new JButton("Calculate Progress"),
			Team1PlayerAdd = new JButton("Add Player"),
			Team2PlayerAdd = new JButton("Add Player");


	Main() {
		super("Match Predictor");
		JPanel Team1Players = new JPanel(new GridLayout(16, 1)), Team2Players = new JPanel(
				new GridLayout(16, 1)), Team1Stats = new JPanel(new GridLayout(
				12, 2)), Team2Stats = new JPanel(new GridLayout(12, 2)), Results = new JPanel(
				new GridLayout(30, 1)),game[][] = new JPanel[2][10];
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				for (int k = 0; k < 10; k++) {
					GameScore[i][j][k] = new JTextField();
					game[i][k] = new JPanel(new GridLayout(1, 3));
					vs[i][k] = new JLabel("       --");
				}
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 14; j++)
				player[i][j] = new JLabel(""+(j + 1));
		Team1Players.add(Title[5]);
		for (int i = 0; i < 14; i++)
			Team1Players.add(player[0][i]);
		Team1Players.add(Team1PlayerAdd);
		Team1PlayerAdd.addActionListener(this);
		Team2Players.add(Title[0]);
		for (int i = 0; i < 14; i++)
			Team2Players.add(player[1][i]);
		Team2Players.add(Team2PlayerAdd);
		Team2PlayerAdd.addActionListener(this);
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
		Team1Progression.setFont(f);
		Team1Progression.addActionListener(this);
		Team2Stats.add(Team2);
		for (int i = 0; i < 10; i++)
			Team2Stats.add(game[1][i]);
		Team2Stats.add(Team2Progression);
		Team2Progression.setFont(f);
		Team2Progression.addActionListener(this);
		Results.add(Title[2]);
		this.setLayout(new GridLayout(1, 5));
		this.add(Team1Players);
		this.add(Team1Stats);
		this.add(Results);
		this.add(Team2Stats);
		this.add(Team2Players);
		this.setSize(600, 400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 14; j++){
				Player[i][j] = "";
				RankedPlayer[i][j] = "";
			}
		Main window = new Main();
		window.setDefaultCloseOperation(3);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == Team1PlayerAdd)
			Team1AddPlayer();
		if (arg0.getSource() == Team2PlayerAdd)
			Team2AddPlayer();
		if (arg0.getSource() == Team1Progression){
			CalculateProgression();
			t=0;
		}
		if (arg0.getSource() == Team2Progression){
			CalculateProgression();
			t=1;
		}
	}

	public void Team1AddPlayer() {
		t=0;
		tPlayers[t]++;
		profile[t][tPlayers[t]] = new PlayerAdd();
	}

	public void Team2AddPlayer() {
		t=1;
		tPlayers[t]++;
		profile[t][tPlayers[t]] = new PlayerAdd();
	}

	public void CalculateProgression() {
		for(int i=0;i<10;i++){
			for(int j=0;j<2;j++)
				Game[t][j][i]=Integer.parseInt(GameScore[t][j][i].getText());
			System.out.println(Game[t][0][i]);
			}
		int total=0,j=0;
		for(int i=1;i<10;i++){
			total=total+(Game[t][0][i]-Game[t][0][j]);
			System.out.println(Game[t][0][i]-Game[t][0][j]);
		j++;
		}
		double progress=total/9;
		if(t==0)
			Team1Progression.setText(""+progress);
		if(t==1)
			Team2Progression.setText(""+progress);
	}
	
	public static void RankPlayers(){
		if(tPlayers[t]==1)
			player[t][0].setText(Player[t][0]);
		else{
			int rank[]=new int[tPlayers[t]];
			for(int i=0;i<rank.length;i++)
				rank[i]=14;
			for(int i=0;i<tPlayers[t];i++)
				for(int j=0;j<i;j++){
					if(PlayerScore[t][i]>PlayerScore[t][j])
						rank[i]--;
					else
						rank[j]--;
				}
			for(int i=0;i<tPlayers[t];i++)
				for(int j=0;j<tPlayers[t];j++)
				if(rank[j]==i)
					player[t][i].setText((i+1)+" "+Player[t][j]);
			}
	}
	public static void getScore(){
		Player[t][tPlayers[t]]=PlayerAdd.Stat[0].getText();
		double Stat[]=new double[14],total=0;
		for(int i=0;i<13;i++){
			Stat[i]=Integer.parseInt(PlayerAdd.Stat[i+1].getText());
		}
		Stat[13]=PlayerAdd.Progress;
		for(int i=0;i<14;i++){
			if(i==7)
				total=total+(10-Stat[i]);
			else
				total=total+Stat[i];
		}
		PlayerScore[t][tPlayers[t]]=total;
		RankPlayers();
	}
	
	
	

	

}
