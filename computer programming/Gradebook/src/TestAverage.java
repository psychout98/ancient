import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestAverage extends JFrame implements ActionListener, KeyListener {
	int GRADE, finalscore, score;
	JPanel panel, panel1;
	JLabel names[] = new JLabel[30];
	JLabel scores[] = new JLabel[30];
	JLabel label1, label2;
	JTextArea NAME, SCORE;
	int i = -1;
	int j = 0;
	JButton checkname, checkscore;

	TestAverage() {
		super("Gradebook");
		init();
		this.setSize(500, 600);
		this.setVisible(true);
		this.setLocation(375, 170);
	}

	public void init() {
		this.setLayout(new GridLayout(1, 2));
		panel = new JPanel(new GridLayout(33, 1));
		panel1 = new JPanel(new GridLayout(33, 1));
		NAME = new JTextArea();
		NAME.addKeyListener(this);
		NAME.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		SCORE = new JTextArea();
		SCORE.addKeyListener(this);
		SCORE.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		checkname = new JButton("Add Name");
		checkname.addActionListener(this);
		checkscore = new JButton("Add Score");
		checkscore.addActionListener(this);
		label1 = new JLabel("Name");
		label2 = new JLabel("Score");
		(scores[0]) = new JLabel();
		(scores[1]) = new JLabel();
		(scores[2]) = new JLabel();
		(scores[3]) = new JLabel();
		(scores[4]) = new JLabel();
		(scores[5]) = new JLabel();
		(scores[6]) = new JLabel();
		(scores[7]) = new JLabel();
		(scores[8]) = new JLabel();
		(scores[9]) = new JLabel();
		(scores[10]) = new JLabel();
		(scores[11]) = new JLabel();
		(scores[12]) = new JLabel();
		(scores[13]) = new JLabel();
		(scores[14]) = new JLabel();
		(scores[15]) = new JLabel();
		(scores[16]) = new JLabel();
		(scores[17]) = new JLabel();
		(scores[18]) = new JLabel();
		(scores[19]) = new JLabel();
		(scores[20]) = new JLabel();
		(scores[21]) = new JLabel();
		(scores[22]) = new JLabel();
		(scores[23]) = new JLabel();
		(scores[24]) = new JLabel();
		(scores[25]) = new JLabel();
		(scores[26]) = new JLabel();
		(scores[27]) = new JLabel();
		(scores[28]) = new JLabel();
		(scores[29]) = new JLabel();
		panel.add(label1);
		panel.add(NAME);
		panel1.add(label2);
		panel1.add(SCORE);
		panel.add(checkname);
		panel1.add(checkscore);
		panel1.add(scores[0]);
		panel1.add(scores[1]);
		panel1.add(scores[2]);
		panel1.add(scores[3]);
		panel1.add(scores[4]);
		panel1.add(scores[5]);
		panel1.add(scores[6]);
		panel1.add(scores[7]);
		panel1.add(scores[8]);
		panel1.add(scores[9]);
		panel1.add(scores[10]);
		panel1.add(scores[11]);
		panel1.add(scores[12]);
		panel1.add(scores[13]);
		panel1.add(scores[14]);
		panel1.add(scores[15]);
		panel1.add(scores[16]);
		panel1.add(scores[17]);
		panel1.add(scores[18]);
		panel1.add(scores[19]);
		panel1.add(scores[20]);
		panel1.add(scores[21]);
		panel1.add(scores[22]);
		panel1.add(scores[23]);
		panel1.add(scores[24]);
		panel1.add(scores[25]);
		panel1.add(scores[26]);
		panel1.add(scores[27]);
		panel1.add(scores[28]);
		panel1.add(scores[29]);
		this.add(panel);
		this.add(panel1);
	}

	public static void main(String[] args) {
		TestAverage window = new TestAverage();
		window.setDefaultCloseOperation(3);
	}

@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource() == checkname) {
			NAMEcheck();
		}
		if (arg0.getSource() == checkscore) {
			SCOREcheck();
		}
	}

	
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getSource()==NAME){
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
		
		}
		}
		if(arg0.getSource()==SCORE){
			if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			
			}
			}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	public void NAMEcheck(){
		i = i + 1;
		names[i] = new JLabel(NAME.getText());
		panel.add(names[i]);
		validate();
		NAME.setText("");
		score = 0;
		j = 0;
	}
	public void SCOREcheck(){
		j = j + 1;
		GRADE = Integer.parseInt(SCORE.getText());
		score = score + GRADE;
		finalscore = score / j;
		scores[i].setText(""+finalscore);
		SCORE.setText("");
	}
}