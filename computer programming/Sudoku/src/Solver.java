import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//random start
//right/wrong mech erase and set text that is colored

public class Solver extends JFrame {
	Random rand = new Random();
	static Boolean done;
	static JTextField[][] area = new JTextField[9][9];
	static String S[][] = new String[9][9], Fc[] = new String[9],
			Fr[] = new String[9], Fxy[] = new String[9], a[] = { "1", "2", "3",
					"4", "5", "6", "7", "8", "9" };
	static Font font = new Font("Times New Roman", Font.BOLD, 30);
	static int y[] = { 0, 0, 0, 1, 1, 1, 2, 2, 2, 0, 0, 0, 1, 1, 1, 2, 2, 2, 0,
			0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 3, 3, 3, 4, 4,
			4, 5, 5, 5, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8,
			6, 6, 6, 7, 7, 7, 8, 8, 8, 6, 6, 6, 7, 7, 7, 8, 8, 8 }, x[] = { 0,
			1, 2, 0, 1, 2, 0, 1, 2, 3, 4, 5, 3, 4, 5, 3, 4, 5, 6, 7, 8, 6, 7,
			8, 6, 7, 8, 0, 1, 2, 0, 1, 2, 0, 1, 2, 3, 4, 5, 3, 4, 5, 3, 4, 5,
			6, 7, 8, 6, 7, 8, 6, 7, 8, 0, 1, 2, 0, 1, 2, 0, 1, 2, 3, 4, 5, 3,
			4, 5, 3, 4, 5, 6, 7, 8, 6, 7, 8, 6, 7, 8 };

	Solver() {
		super("Sudoku");
		init();
		this.setSize(500, 500);
		this.setVisible(true);
	}

	public void init() {
		JPanel panel[] = new JPanel[9], BackBone = new JPanel(new GridLayout(3,
				3)), north = new JPanel(new GridLayout(2, 3));

		final JButton[] button = { new JButton("Easy"), new JButton("Medium"),
				new JButton("Hard"), new JButton("Reset"), new JButton("Quit"),
				new JButton("Solve") };
		for (int i = 0; i < button.length; i++) {
			button[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {
					if (ae.getSource() == button[0]) {// easy-37 boxes
						for (int i = 0; i < 37; i++) {
							int num = rand.nextInt(9) + 1, x = rand.nextInt(9), y = rand
									.nextInt(9);
							for (int j = 0; j < 9; j++) {
										for(int m=1;m<10;m++)
										if (area[x][j].getText() == ""+m||area[j][y].getText() == ""+m)
								while (Integer.parseInt(area[x][y].getText()) == Integer
										.parseInt(area[x][j].getText())
										|| Integer.parseInt(area[x][y]
												.getText()) == Integer
												.parseInt(area[j][y].getText())) {
									num = rand.nextInt(9) + 1;
								}

							}
							S[x][y] = String.valueOf(num);
							area[x][y].setText("" + num);
						}
					}
					if (ae.getSource() == button[1]) {// medium-30
						for (int i = 0; i < 9; i++)
							for (int j = 0; j < 9; j++) {
								S[i][j] = " ";
								area[i][j].setText(" ");
							}
					}
					if (ae.getSource() == button[2]) {// hard-23

						for (int i = 0; i < 9; i++)
							for (int j = 0; j < 9; j++) {
								S[i][j] = " ";
								area[i][j].setText(" ");
							}
					}
					if (ae.getSource() == button[3]) {// solve
					}
					if (ae.getSource() == button[5]) {// reset
						for (int i = 0; i < 9; i++)
							for (int j = 0; j < 9; j++) {
								S[i][j] = " "; // if !original
								area[i][j].setText(" ");
							}
					}
					if (ae.getSource() == button[4]) // quit
						System.exit(0);
				}
			});
			north.add(button[i]);
		}
		add(north, BorderLayout.NORTH);
		for (int i = 0, k = 0; i < 9; i++) {
			panel[i] = new JPanel(new GridLayout(3, 3));
			panel[i].setBackground(Color.BLACK);
			panel[i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
			for (int j = 0; j < 9; j++, k++) {
				area[x[k]][y[k]] = new JTextField(/* random[][] */);
				area[x[k]][y[k]].setFont(font);
				area[x[k]][y[k]].setHorizontalAlignment(JTextField.CENTER);
				area[x[k]][y[k]].setBorder(BorderFactory
						.createLineBorder(Color.BLACK));
				area[x[k]][y[k]].addKeyListener(new KeyListener() {
					@Override
					public void keyPressed(KeyEvent e) {
						
					}

					@Override
					public void keyReleased(KeyEvent e) {
					}

					@Override
					public void keyTyped(KeyEvent e) {
					}
				});
				panel[i].add(area[x[k]][y[k]], BorderLayout.CENTER);
			}
			BackBone.add(panel[i], BorderLayout.CENTER);
		}
		add(BackBone, BorderLayout.CENTER);
	}

	public static void main(String[] args) throws AWTException,
			InterruptedException {
	
		
	}
}