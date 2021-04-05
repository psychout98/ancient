import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quadratics extends JFrame implements ActionListener {
	static JLabel ax = new JLabel("x^2+"), bx = new JLabel("x+"),eq = new JLabel("=0"),
			standard = new JLabel(), factor = new JLabel(),
			solutions = new JLabel();
	static JTextField a = new JTextField(), b = new JTextField(),
			c = new JTextField();
	JButton Finish = new JButton("Finish");
	private static Graph graph;
	static boolean showgraph = false, geteq = false;

	Quadratics() {
		super("Quadratics");
		this.setSize(500, 500);
		this.setVisible(true);
		JPanel panel1 = new JPanel(new GridLayout(1, 7)), panel2 = new JPanel(
				new GridLayout(3, 1));
		Finish.addActionListener(this);
		panel1.add(a);
		panel1.add(ax);
		panel1.add(b);
		panel1.add(bx);
		panel1.add(c);
		panel1.add(eq);
		panel1.add(Finish);
		panel2.add(standard);
		panel2.add(factor);
		panel2.add(solutions);
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		if(geteq){
		this.add(graph, BorderLayout.SOUTH);
		repaint();
		}
	}

	public static void main(String[] args) {
		Quadratics window = new Quadratics();
		window.setDefaultCloseOperation(3);
		if (geteq) {
			double A, B, C, sol1, sol2;
			A = Integer.parseInt(a.getText());
			B = Integer.parseInt(b.getText());
			C = Integer.parseInt(c.getText());
			sol1 = ((-1 * B) + Math.sqrt((B * B) - 4 * A * C)) / (2 * A);
			sol2 = ((-1 * B) - Math.sqrt((B * B) - 4 * A * C)) / (2 * A);
			standard.setText("Standard Form: " + a.getText() + "x^2+"
					+ b.getText() + "x+" + c.getText()+"=0");
			if(sol1<0){
			if(sol2<0)
				factor.setText("Factored Form: "+a.getText()+"(x+"+(-1*sol1)+")(x+"+(-1*sol2)+")=0");
			if(sol2>0)
				factor.setText("Factored Form: "+a.getText()+"(x+"+(-1*sol1)+")(x-"+sol2+")=0");
			}
			if(sol1>0){
				if(sol2<0)
					factor.setText("Factored Form: "+a.getText()+"(x-"+(sol1)+")(x+"+(-1*sol2)+")=0");
				if(sol2>0)
					factor.setText("Factored Form: "+a.getText()+"(x-"+(sol1)+")(x-"+(sol2)+")=0");
			}
			solutions.setText("Solutions: x={"+sol1+","+sol2+"}");
		}
	}

	public class Graph extends JPanel {
		public void graph(Graphics g) {
			if(geteq=true){
				int y;
				g.setColor(Color.BLACK);
				for(int x=-50;x<50;x++){
				g.fillRect((graph.getWidth()/2)+x,y,);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Finish)
			geteq = true;
	}

}
