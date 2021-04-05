//I spend a few hours and I cut about 4 months worth of programming in to 292 lines. before i started it was about 560.
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;
class SimpleGui extends JFrame implements ActionListener {
	 static JProgressBar progressBar;
	 static int SpiralType = 1, rows;
	static JTextField Pprime, Pcomposite, Prows;
	 public JComboBox classes;
	 public JButton done;
	static String filename, prime, composite;
	 static boolean BDone, LoS, doneL, Rprime, Ospiral, stupid = false;
	final String options[] = { "ulam spiral", "odd spiral", "Sam spiral" };
	 private static final long serialVersionUID = 1279909781274258506L;
	JRadioButton large, small, other;
	 public SimpleGui() throws InterruptedException {
		 setTitle("Ulam Spirals");
		setSize(220, 300);
		 JPanel west = new JPanel(new GridLayout(3, 1));

		 ButtonGroup groupsize = new ButtonGroup();
 
		west.add(new JLabel("Size"));

		 large = new JRadioButton("Large");

		 large.addActionListener(this);
 
		large.setActionCommand("large");

		 small = new JRadioButton("Small");

		 small.setActionCommand("small");
 
		small.addActionListener(this);

		 groupsize.add(large);

		 groupsize.add(small);
 
		west.add(large);

		 west.add(small);

		 this.add(west, BorderLayout.WEST);
 



		JPanel north = new JPanel(new GridLayout(2, 1));

		 north.add(new JLabel("Select spiral"));
 
		classes = new JComboBox();

		 for (int i = 0; i < options.length; i++) {

			 classes.addItem(options[i]);
 
		}

		 classes.addActionListener(this);

		 north.add(classes);
 
		this.add(north, BorderLayout.NORTH);

		 // center.add(Box.createHorizontalStrut(15));

		 // done.setBorder(BorderFactory.createLineBorder(Color.BLACK));
 
		// progressBar.setValue(0);

		 // progressBar.setStringPainted(true);

		 JPanel center1 = new JPanel(new GridLayout(1, 1));
 
		done = new JButton("Done");

		 done.addActionListener(this);

		 center1.add(done);
 
		this.add(center1);




		 JPanel center = new JPanel(new GridLayout(8, 1));

		 center.add(new JLabel("Input # of rows"));
 
		center.add(Prows = new JTextField(5));

		 center.add(new JLabel("Prime"));

		 center.add(Pprime = new JTextField(5));
 
		center.add(new JLabel("Composite"));

		 center.add(Pcomposite = new JTextField(5));

		 center.add(new JLabel("loading", JLabel.CENTER));
 



		progressBar = new JProgressBar();

		 center.add(progressBar);

		 this.add(center, BorderLayout.SOUTH);
 



	}




	 @Override

	 public void actionPerformed(ActionEvent ae) {
 
		if (ae.getSource() == done) {

			 String Srows = Prows.getText();

			 rows = Integer.parseInt(Srows);// rows
 



			prime = Pprime.getText();// prime

			 if (Pprime.getText() == null)

				 prime = " ";
 
			composite = Pcomposite.getText();// composite

			 if (Pcomposite.getText() == null)

				 composite = " ";
 
			final JFileChooser fc = new JFileChooser();

			 int responce = fc.showSaveDialog(SimpleGui.this);

			 if (responce == JFileChooser.APPROVE_OPTION) {
 
				BDone = true;

				 filename = fc.getSelectedFile().toString();// filename

			 } else {
 
				BDone = true;

				 filename = "default";// filename

			 }
 
			;

		 }

		 if (ae.getSource() == large) {

			 LoS = true;// LoS
 
		}

		 if (ae.getSource() == small) {

			 LoS = false;// LoS
 
		}// size

		 if (ae.getSource() == classes) {

			 switch (classes.getSelectedIndex()) {
 
			case 0:

				 SpiralType = 1;// SpiralType

				 break;
 
			case 1:

				 SpiralType = 2;// SpiralType

				 break;
 
			case 2:

				 SpiralType = 3;// SpiralType

				 break;
 
			}

		 }

	 }




	 public static void main(String args[]) throws IOException,
 
			InterruptedException {

		 SimpleGui gui = new SimpleGui();

		 gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
		gui.setVisible(true);

		 gui.setResizable(false);




		 while (true) {
 
			gui.setCursor(null);

			 if (BDone) {

				 BDone = false;
 
				progressBar.setIndeterminate(true);

				 gui.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

 				if (SpiralType == 1) {

					 Ospiral = false;

					 new ulamSpiral();
 
				} else if (SpiralType == 2) {

					 Ospiral = true;

					 new ulamSpiral();
 
				} else if (SpiralType == 3) {

					 new SamSpiral();

				 }
 
				Toolkit.getDefaultToolkit().beep();

				 progressBar.setIndeterminate(false);

			 }
 
			Thread.sleep(50);

		 }

	 }




	 static class ulamSpiral {
 
		public ulamSpiral() throws IOException {

			 if (rows % 2 == 0)

				 rows = (rows + 1);
 
			String[][] board = new String[rows][rows];

			 int S = (rows * rows) + 1;

			 if (Ospiral)
 
				S = (rows * rows) * 2 + 1;

			 int A = rows / 2;

			 int B = rows / 2;
 
			int X = 1;

			 int freq = 1;

			 int Z = 1;

			 int j = rows / 2;
 
			int i = rows / 2;

			 clearBoard(board);

			 board[i][j] = "@";
 
			while (X != S) {

				 for (int freq1 = 0; freq1 < freq; freq1++) {

					 if (X != S)
 
						X = (X + 1);

					 else

						 break;

					 if ((X != S) && (X % 2 == 0) && (Ospiral))
 
						X = X + 1;




					 {

						 if ((Z == 1) && (X != S)) {
 
							B = B + 1;

							 j = B;

							 board[i][j] = ((isPrime(X)) ? prime : composite);
 
						} else if ((Z == 2) && (X != S)) {

							 A = A - 1;

							 i = A;
 
							board[i][j] = ((isPrime(X)) ? prime : composite);

						 } else if ((Z == 3) && (X != S)) {

 							B = B - 1;

							 j = B;

							 board[i][j] = ((isPrime(X)) ? prime : composite);
 
						} else if ((Z == 4) && (X != S)) {

							 A = A + 1;

							 i = A;
 
							board[i][j] = ((isPrime(X)) ? prime : composite);

						 }

					 }
 
				}

				 if (Z == 4) {

					 Z = 1;

					 freq = freq + 1;
 
				} else if (Z == 2) {

					 freq = freq + 1;

					 Z = Z + 1;
 
				} else {

					 Z = Z + 1;

				 }

				 drawBoard(board);
 
			}

		 }

	 }




	 static class SamSpiral {
 
		public SamSpiral() throws IOException {

			 rows = (3 * rows) + 2;

			 String[][] board = new String[rows][rows];
 
			int wtf = (((rows + 1) * rows) / 2) + 1;

			 int X = wtf;

			 int A = rows - 1;
 
			int B = rows;

			 int freq = rows;

			 int freq3 = freq;
 
			int Z = 3;

			 int j = rows;

			 int i = rows - 1;

 			clearBoard(board);

			 do {

				 do {

					 freq = freq - 1;
 
					X = X - 1;

					 {

						 if ((Z == 3) && (X != 0)) {
 
							B = B - 1;

							 j = B;

							 board[i][j] = ((isPrime(X) ? prime : composite));
 
						} else if ((Z == 2) && (X != 0)) {

							 A = A - 1;

							 i = A;
 
							board[i][j] = ((isPrime(X) ? prime : composite));

						 } else if ((Z == 1) && (X != 0)) {

 							A = A + 1;

							 B = B + 1;

							 i = A;

							 j = B;
 
							board[i][j] = ((isPrime(X) ? prime : composite));

						 }

					 }
 
				} while (freq != 0);

				 freq3 = freq3 - 1;

				 freq = freq3;
 
				if (Z == 1)

					 Z = 3;

				 else {

					 Z = Z - 1;
 
				}

			 } while (X != 1);

			 board[i][j] = "@";
 
			drawBoard(board);

		 }

	 }




	 public static boolean isPrime(int n) {
 
		Rprime = true;

		 for (int p = 2; p < n; p++) {

			 if (n % p == 0)
 
				Rprime = false;

		 }

		 return Rprime;

	 }
 



	public static void drawBoard(String[][] board) throws IOException {

		 FileWriter fw = new FileWriter(filename);
 
		PrintWriter output = new PrintWriter(fw);

		 for (int i = 0; i < rows; i++) {

			 for (int j = 0; j < rows; j++) {
 
				output.print(board[i][j]);

				 if (LoS) {

					 output.print(" ");
 
				}

			 }

			 output.println();

		 }
 
		output.println();

		 output.close();

		 fw.close();

 	}




	 public static void clearBoard(String[][] board) {

		 for (int i = 0; i < rows; i++) {
 
			for (int j = 0; j < rows; j++) {

				 board[i][j] = " ";

			 }
 
		}

	 }

}