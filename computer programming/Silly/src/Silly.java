import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;


public class Silly extends JFrame implements KeyListener{
	static boolean b=false;
	static JTextPane textbox = new JTextPane();
	static JTextArea timer = new JTextArea();
	Silly(){
		super("False-hope-inator");
		JPanel panel = new JPanel(new GridLayout(1,3));
		textbox.addKeyListener(this);
		panel.add(textbox);
		panel.add(timer);
		this.add(panel, BorderLayout.CENTER);
		this.setSize(500,500);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args, KeyEvent e) throws AWTException{
		Robot r = new Robot();
		Silly window=new Silly();
		window.setDefaultCloseOperation(3);
		if(e.getKeyCode()==e.getKeyCode()){
			r.keyPress(e.getKeyCode());
		}
		
	}
	
	
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
