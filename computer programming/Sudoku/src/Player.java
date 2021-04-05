import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

//random start button for custom start: hard can be min 17
//set red if false
//if they hit solve it shows something diffrent from if they cheated
//fix the timer
public class Player extends JFrame {
	static TimerTask timerEngine;
	static Timer timer = new Timer();
	static Random rand = new Random();
	static JTextField area[][] = new JTextField[9][9],
			custom = new JTextField();
	static Font font = new Font("Times New Roman", Font.PLAIN, 30);
	static int y[] = { 0, 0, 0, 1, 1, 1, 2, 2, 2, 0, 0, 0, 1, 1, 1, 2, 2, 2, 0,
			0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 3, 3, 3, 4, 4,
			4, 5, 5, 5, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8,
			6, 6, 6, 7, 7, 7, 8, 8, 8, 6, 6, 6, 7, 7, 7, 8, 8, 8 }, x[] = { 0,
			1, 2, 0, 1, 2, 0, 1, 2, 3, 4, 5, 3, 4, 5, 3, 4, 5, 6, 7, 8, 6, 7,
			8, 6, 7, 8, 0, 1, 2, 0, 1, 2, 0, 1, 2, 3, 4, 5, 3, 4, 5, 3, 4, 5,
			6, 7, 8, 6, 7, 8, 6, 7, 8, 0, 1, 2, 0, 1, 2, 0, 1, 2, 3, 4, 5, 3,
			4, 5, 3, 4, 5, 6, 7, 8, 6, 7, 8, 6, 7, 8 }, difficulty,
			grid[][] = new int[9][9], minutes = 0, seconds = 0,
			milliseconds = 0;
	static boolean started = false;

	Player() {
		super("Sudoku");
		init();
		this.setSize(500, 500);
		this.setVisible(true);
	}

	public void init() {
		final String Reset[][] = new String[9][9];
		JPanel panel[] = new JPanel[9], BackBone = new JPanel(new GridLayout(3,
				3)), north = new JPanel(new GridLayout(2, 2));
		final JButton[] button = { new JButton("Generate"),
				new JButton("Reset"), new JButton("Quit"), new JButton("Solve") };
		for (int i = 0; i < button.length; i++) {
			button[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {
					for (int i = 0; i < 9; i++)
						for (int j = 0; j < 9; j++) {
							area[i][j].setText(" ");
						}
					if (ae.getSource() != button[1]// solve real
							&& ae.getSource() != button[3]) {
						for (int i = 0; i < 9; i++)
							for (int j = 0; j < 9; j++)
								grid[i][j] = 0;
						for (int i = 0; i < 9; i++)
							for (int j = 0; j < 9; j++)
								if (!solve(i, j))
									j--;
					}
					if (ae.getSource() == button[0]) { // custom
						difficulty = Integer.valueOf(custom.getText()) < 81 ? Integer
								.valueOf(custom.getText()) : 0;

					}
					if (ae.getSource() == button[1]) {// reset
						for (int i = 0; i < 9; i++)
							for (int j = 0; j < 9; j++)
								area[i][j].setText(Reset[i][j]);

					}
					if (ae.getSource() == button[2]) // quit
						System.exit(0);
					if (ae.getSource() == button[3]) {// solves
						for (int i = 0; i < 9; i++)
							for (int j = 0; j < 9; j++)
								area[i][j].setText(String.valueOf(grid[i][j]));
					}
					if (ae.getSource() != button[1]
							&& ae.getSource() != button[3]) {
						for (int i = 0; i < 9; i++)
							for (int j = 0; j < 9; j++)
								Reset[i][j] = " ";
						String value = "";
						List<String> list = new ArrayList<String>(difficulty);
						int randomx, randomy;
						for (int i = 0; i < difficulty; i++) {
							if (!(list.contains(value = ((rand.nextInt(9)) + "" + (rand
									.nextInt(9)))))) {
								list.add(value);
								randomx = Integer.parseInt(value
										.substring(0, 1));
								randomy = Integer.parseInt(value.substring(1));
								area[randomx][randomy].setText(String
										.valueOf(grid[randomx][randomy]));
								Reset[randomx][randomy] = String
										.valueOf(grid[randomx][randomy]);
							} else
								i--;
						}
					}
				}
			});
		}
		north.add(button[0]);
		custom.setHorizontalAlignment(JTextField.CENTER);
		north.add(custom);
		final JLabel ltimer = new JLabel();
		ltimer.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		ltimer.setText(minutes + ":" + seconds + "." + milliseconds);
		north.add(ltimer);
		timerEngine = new TimerTask() {
			@Override
			public void run() {
				started = true;
				ltimer.setText((minutes = minutes + (seconds == 60 ? 1 : 0))
						+ ":"
						+ (seconds = (seconds == 60 ? 0
								: (milliseconds == 1000 ? seconds + 1 : seconds)))
						+ "."
						+ (milliseconds = (milliseconds == 1000 ? 0
								: milliseconds + 1)));

			}
		};
		for (int i = 1; i < button.length; i++)
			north.add(button[i]);

		add(north, BorderLayout.NORTH);

		for (int i = 0, k = 0; i < 9; i++) {
			panel[i] = new JPanel(new GridLayout(3, 3));
			panel[i].setBackground(new Color(0, 0, 102));
			panel[i].setBorder(BorderFactory.createLineBorder(new Color(0, 0,
					102), 1));
			for (int j = 0; j < 9; j++, k++) {
				area[x[k]][y[k]] = new JTextField();
				area[x[k]][y[k]].setFont(font);
				area[x[k]][y[k]].setHorizontalAlignment(JTextField.CENTER);
				area[x[k]][y[k]].setBorder(BorderFactory
						.createLineBorder(new Color(204, 204, 255)));
				area[x[k]][y[k]].setDisabledTextColor(Color.green);
				area[x[k]][y[k]].getDocument().addDocumentListener(
						new DocumentListener() {
							@Override
							public void changedUpdate(DocumentEvent DE) {
							}

							@Override
							public void insertUpdate(DocumentEvent DE) {
								for (int i = 0; i < 9; i++)
									for (int j = 0; j < 9; j++) {
										if (DE.getDocument() == area[i][j]
												.getDocument()) {
											boolean frozen;
											frozen = (area[i][j]
													.getText()
													.trim()
													.equals(String
															.valueOf(grid[i][j])) ? true
													: false);
											if (frozen)
												area[i][j].disable();
											else
												area[i][j].enable();
										}
									}

								if (isDone()) {
									timerEngine.cancel();
									for (int i = 0; i < 9; i++)
										for (int j = 0; j < 9; j++) {
											Reset[i][j] = "";
										}
									JOptionPane.showMessageDialog(null,
											"------------------------You Win!------------------------\nTime: "
													+ minutes + ":" + seconds
													+ "." + milliseconds,
											"congratulations",
											JOptionPane.PLAIN_MESSAGE);
								}
							}

							public void removeUpdate(DocumentEvent DE) {
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
		Player window = new Player();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private boolean solve(int row, int col) {
		if (row == 9 || grid[row][col] != 0
				&& solve(col == 8 ? (row + 1) : row, (col + 1) % 9))
			return true;
		else {
			Integer randoms[] = new Integer[9];
			for (int i = 0; i < 9; i++)
				randoms[i] = i + 1;
			Collections.shuffle(Arrays.asList(randoms));
			for (int i = 0; i < 9; i++) {
				if (!check(row, col, randoms[i])) {
					grid[row][col] = randoms[i];
					if (solve(col == 8 ? (row + 1) : row, (col + 1) % 9))
						return true;
					else
						grid[row][col] = 0;
				}
			}
		}
		return false;
	}

	private boolean check(int row, int col, int value) {
		int startRow = row / 3 * 3, startCol = col / 3 * 3;
		for (int i = startRow; i < startRow + 3; i++)
			for (int j = startCol; j < startCol + 3; j++)
				if (grid[i][j] == value && !(i == row && j == col))
					return true;
		for (int i = 0; i < 9; i++) {
			if (i != col && grid[row][i] == value || i != row
					&& grid[i][col] == value)
				return true;
		}
		return false;
	}

	public static Boolean isDone() {
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				if (area[i][j].isEnabled())
					return false;
			}
		return true;
	}
}