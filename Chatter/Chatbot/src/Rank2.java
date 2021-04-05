import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Rank2 extends JFrame implements ActionListener {

	JButton button[];
	String names[];
	int records[], record[],Packs[];

	Rank2(String Names[], int Record[], int Records[]) {
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
