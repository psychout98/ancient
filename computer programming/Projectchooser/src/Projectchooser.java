import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Projectchooser extends JFrame implements ActionListener{
	JButton rps,ttt;
	static boolean ROCKPAPERSCISSORS=false;
	static boolean TICTACTOE=false;
	Projectchooser(){
		super("Ngames");
		init();
		this.setSize(500,500);
		this.setVisible(true);
	}
	
	public void init(){
		rps=new JButton("Rock Paper Scissors");
		ttt=new JButton("Tic Tac Toe");
		rps.addActionListener(this);
		ttt.addActionListener(this);
		JPanel panel = new JPanel(new GridLayout(1,2));
		panel.add(rps);
		panel.add(ttt);
		this.add(panel);
	}
	
	public static void main(String[]args){
		Projectchooser window = new Projectchooser();
	if(TICTACTOE=true){
	}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==rps){
			ROCKPAPERSCISSORS=true;
		}
		if(arg0.getSource()==ttt){
			TICTACTOE=true;
		}
		
	}

}
