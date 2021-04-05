import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class exponents extends JFrame implements KeyListener{

	static Random rand = new Random();
	static boolean check = false;
	static int  base, exponent,Score=0;
	static JLabel question = new JLabel(), timer = new JLabel(), score=new JLabel(""+Score), answer = new JLabel();
	static JTextField Answer = new JTextField();
	
	exponents(){
		super("Exponents");
		this.setSize(300,300);
		this.setVisible(true);
		init();
	}
	public void init(){
		Font f=new Font("Times New Roman", Font.BOLD, 30);
		JPanel panel = new JPanel(new GridLayout(3,2));
		timer.setFont(f);
		score.setFont(f);
		question.setFont(f);
		Answer.setFont(f);
		panel.add(timer);
		panel.add(score);
		panel.add(question);
		panel.add(Answer);
		Answer.addKeyListener(this);
		panel.add(answer);
		this.add(panel);
	}
	public static void main(String[] args) throws InterruptedException {
		exponents window = new exponents();
		window.setDefaultCloseOperation(3);
		while(true){
			base=rand.nextInt(7)+2;
			if(base<3)
				exponent=rand.nextInt(7)+2;
			if(base>=3&&base<5)
				exponent=rand.nextInt(4)+2;
			if(base>=5)
				exponent=rand.nextInt(2)+2;
			question.setText(""+base+"^"+exponent);
			for(int i=10;i>-1;i--){
				Thread.sleep(1000);
		if(check){
		if(Integer.parseInt(Answer.getText())==Math.pow(base, exponent)){
			Answer.setText("");
			check=false;
			Score++;
			score.setText(""+Score);
			answer.setText("Correct: "+base+"^"+exponent+"="+Math.pow(base, exponent));
			break;
		}
			
		if(Integer.parseInt(Answer.getText())!=Math.pow(base, exponent)|| i==0){
			Score--;
		check=false;
		Answer.setText("");
		answer.setText("Incorrect: "+base+"^"+exponent+"="+Math.pow(base, exponent));
		break;
		}
		}
		else
			timer.setText(""+i);
		}
			
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
			check=true;
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}

}
