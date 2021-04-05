import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Main extends JFrame implements ActionListener{
	JButton done;
	static boolean Done = false, go = false, entered[], complete[],
			Complete = false,used[];
	static String names[], Record[],NAMES[];
	JComboBox players33, rounds33,NameBox[][],ScoreBox[],OddBox;
	JTextPane Name[][],Score[],OddName=new JTextPane();
	JLabel odd = new JLabel("Odd player: ");
	static Player player[];
	static int round, Entered = 0, arrayNum, wins[],losses[], Number = 0, records[],
			players2, ROUNDS;
/*make record file
 *   make method that eliminates used players
 *   set comboboxes blank when refreshed
 *   tweak score textbox
 *    fix rank so that you can click on the names to get their records
	*/
	Main() throws InterruptedException {
		super("Tournament");
		this.setVisible(true);
		this.setSize(200, 130);
		this.setDefaultCloseOperation(3);
		this.setLayout(new GridLayout(2, 1));
		JPanel panel1 = new JPanel(new GridLayout(2, 2)), panel2 = new JPanel();
		done = new JButton("Done");
		done.addActionListener(this);
		String nums[] = new String[43];
		String Rounds2[] = { "3", "4", "5", "6", "7", "8", "9" };
		for (int i = 0; i < 43; i++)
			nums[i] = "" + (i + 8);
		players33 = new JComboBox(nums);
		players33.setEditable(true);
		players33.setSelectedIndex(0);
		players33.addActionListener(this);
		players2 = 8;
		rounds33 = new JComboBox(Rounds2);
		rounds33.setEditable(true);
		rounds33.setSelectedIndex(0);
		rounds33.addActionListener(this);
		round = 3;
		JLabel Players = new JLabel("Players"), Rounds = new JLabel("Rounds");
		panel1.add(Players);
		panel1.add(Rounds);
		panel1.add(players33);
		panel1.add(rounds33);
		panel2.add(done);
		this.add(panel1);
		this.add(panel2);
		while (true) {
			if (Done)
				break;
			Thread.sleep(100);
		}
		Done = false;
		this.remove(panel1);
		this.remove(panel2);
		used = new boolean[players2];
		wins = new int[players2];
		losses = new int[players2];
		for(int i=0;i<players2;i++){
			wins[i]=0;
			used[i]=false;
			losses[i]=0;
		}
		JPanel panel4;
		done.setText("Next Round");
		ROUNDS = players2 / 2;
		Record = new String[players2];
		this.setSize(330, 70 + (30 * ROUNDS));
		this.setLayout(new BorderLayout());
		panel1 = new JPanel(new GridLayout(ROUNDS + 1, 2));
		panel2 = new JPanel(new GridLayout(ROUNDS + 1, 2));
		JLabel vs[] = new JLabel[ROUNDS], labels[] = { new JLabel("Player 1"),
				new JLabel(""), new JLabel("Player 2"),
				new JLabel("Score (1-2)") };
		Name = new JTextPane[2][ROUNDS];
		Score = new JTextPane[ROUNDS];
		if(players2%2!=0){
			OddName.setBorder(BorderFactory.createLineBorder(Color.black));
			panel4 = new JPanel(new GridLayout(1,3));
			panel4.add(odd);
			panel4.add(OddName);
			panel4.add(done);
		}
		else{
			panel4 = new JPanel();
			panel4.add(done);
		}
		panel1.add(labels[0]);
		panel1.add(labels[1]);
		panel2.add(labels[2]);
		panel2.add(labels[3]);
		for (int i = 0; i < ROUNDS; i++) {
			vs[i] = new JLabel("          VS");
			Score[i] = new JTextPane();
			Name[0][i] = new JTextPane();
			Name[1][i] = new JTextPane();
			
			Name[0][i].setBorder(BorderFactory.createLineBorder(Color.black));
			Name[1][i].setBorder(BorderFactory.createLineBorder(Color.black));
			Score[i].setBorder(BorderFactory.createLineBorder(Color.black));
			panel1.add(Name[0][i]);
			panel1.add(vs[i]);
			panel2.add(Name[1][i]);
			panel2.add(Score[i]);
		}
		JPanel panel3 = new JPanel(new GridLayout(1, 2));
		panel3.add(panel1);
		panel3.add(panel2);
		this.add(panel3);
		this.add(panel4, BorderLayout.SOUTH);
		Done=false;
		int incomplete;
		for(int j=0;j<round-1;j++){
		while (true) {
		/*	for(int i=0;i<NameBox[0].length;i++){
				if(NameBox[0][i].getSelectedIndex()>)
			}*/
			incomplete=0;
			for(int i=0;i<Name[0].length;i++)
				if(Name[0][i].getText().length()<1||Name[1][i].getText().length()<1)
					incomplete++;
			for(int i=0;i<Score.length;i++)
				if(Score[i].getText().length()!=3)
					incomplete++;
				if(Done&&incomplete>0)
					Done=false;
				else if (Done&&incomplete==0)
				break;
			Thread.sleep(100);
		}
		if(j==0){
			this.remove(panel3);
			this.remove(panel4);
		}
		refresh(j);
		Done=false;
		}
		while(true){
			for(int i=0;i<NameBox[0].length;i++){
				
			}
			if(Done)break;Thread.sleep(100);}
		Record();
		Rank window = new Rank(names,wins,losses);
	}
	
	public void Record(){
		String RECORD[] = new String[players2];
		for(int i=0;i<players2;i++){
			RECORD[i]+=names[i]+"\nWin-Loss Record: "+wins[i]+"-"+losses[i];
		}
	}

	public void refresh(int j) {
		
		if(j==0){
		names=new String[players2];
		if(players2%2!=0){
		names[players2-1]=OddName.getText();
		wins[players2-1]+=3;
		}
		for(int i=0;i<Name[0].length;i++){
			names[i]=Name[0][i].getText();
			names[i+(players2/2)]=Name[1][i].getText();
			String score = Score[i].getText();
			int p1 = Integer.parseInt(String.valueOf(score.charAt(0))),p2=Integer.parseInt(String.valueOf(score.charAt(2)));
			if(p1>p2){
				wins[i]+=3;
			losses[i+(players2/2)]++;
			}
			else if(p2>p1){
				wins[i+(players2/2)]+=3;
			losses[i]++;
			}
				else{
				wins[i]++;
				wins[i+(players2/2)]++;
			}
		Score[i].setText("");
		}
		JPanel panel1,panel2,panel3,panel4;
		panel1 = new JPanel(new GridLayout(ROUNDS + 1, 2));
		panel2 = new JPanel(new GridLayout(ROUNDS + 1, 2));
		JLabel vs[] = new JLabel[ROUNDS], labels[] = { new JLabel("Player 1"),
				new JLabel(""), new JLabel("Player 2"),
				new JLabel("Score (1-2)") };
		NameBox = new JComboBox[2][ROUNDS];
		ScoreBox = new JComboBox[ROUNDS];
		panel1.add(labels[0]);
		panel1.add(labels[1]);
		panel2.add(labels[2]);
		panel2.add(labels[3]);
		for (int i = 0; i < ROUNDS; i++) {
			vs[i] = new JLabel("          VS");
			NameBox[0][i] = new JComboBox(names);
			NameBox[1][i] = new JComboBox(names);
			NameBox[0][i].setEditable(true);
			NameBox[1][i].setEditable(true);
			panel1.add(NameBox[0][i]);
			panel1.add(vs[i]);
			panel2.add(NameBox[1][i]);
			panel2.add(Score[i]);
		}
		if(players2%2!=0){
			panel4 = new JPanel(new GridLayout(1,2));
			OddBox = new JComboBox(names);
			OddBox.setEditable(true);
			panel4.add(odd);
			panel4.add(OddBox);
			panel4.add(done);
		}
		else{
			panel4 = new JPanel();
			panel4.add(done);
		}
		panel3 = new JPanel(new GridLayout(1, 2));
		panel3.add(panel1);
		panel3.add(panel2);
		this.add(panel3);
		this.add(panel4, BorderLayout.SOUTH);
		}
		if(j>0){
			String Tnames[]=new String[players2];
			int Twins[] = new int[players2],Tlosses[] = new int[players2];
			for(int i=0;i<NameBox[0].length;i++){
				Tnames[i]=names[NameBox[0][i].getSelectedIndex()];
				Tnames[i+(players2/2)]=names[NameBox[1][i].getSelectedIndex()];
				String score = Score[i].getText();
				int p1 = Integer.parseInt(String.valueOf(score.charAt(0))),p2=Integer.parseInt(String.valueOf(score.charAt(2)));
				if(p1>p2){
					Twins[i]+=3;
				Tlosses[i+(players2/2)]++;
				}
				else if(p2>p1){
					Twins[i+(players2/2)]+=3;
				Tlosses[i]++;
				}
					else{
					Twins[i]++;
					Twins[i+(players2/2)]++;
				}
			Score[i].setText("");
			Done=false;	
		}
			if(players2%2!=0){
				Tnames[players2-1]=names[OddBox.getSelectedIndex()];
				Twins[players2-1]+=3;
			}
			for(int i=0;i<names.length;i++)
				for(int k=0;k<names.length;k++)
					if(Tnames[i].equals(names[k])){
						wins[k]+=Twins[i];
						losses[k]+=losses[i];
				}
			if(j==round-2)
			done.setText("Finish");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Main window = new Main();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == done)
			Done = true;
		else
			Done=false;
		
		
		if (arg0.getSource() == players33)
			players2 = players33.getSelectedIndex() + 8;
		
		if (arg0.getSource() == rounds33)
			round = rounds33.getSelectedIndex() + 3;
		
	}
	
	
	
	
	
	
	
	
	
	public class Rank extends JFrame implements ActionListener {

		JButton button[];
		String names[];
		int records[], record[],Packs[];

		Rank(String Names[], int Record[], int Records[]) {
			super("Outcome");
			names = Names;
			record = Record;
			records = Records;
			this.setSize(250, (names.length * 30) + 40);
			this.setVisible(true);
			this.setDefaultCloseOperation(3);
			this.setLayout(new GridLayout(names.length + 1, 1));
			int packs = (int) (names.length * 1.5);
			Packs = new int[names.length];
			String ranked[] = new String[names.length];
			int rank[] = new int[names.length];
			for (int i = 0; i < names.length; i++) {
				for (int j = 0; j < names.length; j++)
					if (record[i] < record[j])
						rank[i]++;
					else if (record[i] == record[j] && j < i)
						rank[i]++;
			}
			int Wins = 0;
			for (int i = 0; i < names.length; i++)
				if (records[i] == 0)
					Wins++;
			int Nums[] = { packs }, nums[];
			for (int a = 0; a < Wins - 1; a++) {
				nums = new int[Nums.length];
				for (int b = 0; b < Nums.length; b++) {
					nums[b] = Nums[b];
				}
				int B = 0;
				Nums = new int[nums.length + 1];
				for (int b = 0; b < nums.length; b++)
					if (nums[b] == 1) {
						B = b - 1;
						b = nums.length;
					}
				if (nums[nums.length - 1] > 1)
					B = nums.length - 1;
				for (int c = Nums.length - 1; c > B + 1; c--)
					Nums[c] = nums[c - 1];
				if (nums[B] % 2 == 0) {
					Nums[B] = nums[B] / 2;
					Nums[B + 1] = nums[B] / 2;
				} else {
					Nums[B] = (int) (nums[B] / 2) + 1;
					Nums[B + 1] = (int) (nums[B] / 2);
				}
				for (int c = 0; c < B; c++)
					Nums[c] = nums[c];
				B = nums.length;
			}
			for (int i = 0; i < Nums.length - 2; i++)
				if (record[i] == record[i + 1] && Nums[i] > Nums[i + 1]) {
					int total = Nums[i] + Nums[i + 1];
					if (total % 2 == 0) {
						Nums[i] = total / 2;
						Nums[i + 1] = total / 2;
					} else if (i < Nums.length - 2) {
						Nums[i] = (int) (total / 2);
						Nums[i + 1] = (int) (total / 2);
						Nums[i + 2]++;
					} else {
						Nums[i] = (int) (total / 2);
						Nums[i + 1] = (int) (total / 2);
					}
				}
			for (int i = 0; i < Nums.length; i++)
				Packs[i] = Nums[i];
			for (int i = Nums.length; i < Packs.length; i++)
				Packs[i] = 0;
			for (int i = 0; i < names.length; i++)
				for (int j = 0; j < names.length; j++)
					if (rank[i] == j) {
						ranked[j] = (j + 1) + ". " + names[i] + " : " + Packs[i];
					}
			button = new JButton[names.length];
			JLabel label = new JLabel("Player : Packs");
			this.add(label);
			for (int i = 0; i < names.length; i++) {
				button[i] = new JButton(ranked[i]);
				button[i].addActionListener(this);
				this.add(button[i]);
			}
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (int i = 0; i < button.length; i++)
				if (arg0.getSource() == button[i])
					button[i]
							.setText(button[i].getText().startsWith("" + (i + 1)+".") ? names[i]
									+ "'s record: " + record[i] + "-" + records[i]
									: (i + 1) + ". " + names[i] + " : " + Packs[i]);

		}
	}
	
	
	
}