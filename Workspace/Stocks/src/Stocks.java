
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Stocks extends JFrame implements KeyListener, ActionListener,MouseListener,MouseMotionListener,MouseWheelListener{

	share[] s = {new share("JP:3402","Toray",1009.5,1),
			new share("AMZN","Amazon",848.91,1),
			new share("GOOG","Google",830.63,1),
			new share("AAPL","Apple",138.96,1),
			new share("MSFT","Microsoft",64.01,1),
			new share("FB","Facebook",136.76,1),
			new share("BA","Boeing",182.98,1),
			new share("TSLA","Tesla",250.2,1),
			new share("MMM","3M",189.89,1),
			new share("INTC","Intel",35.91,1),
			new share("DIS","Disney",110.59,1),
			new share("SNAP","Snapchat",24.78,1),
			new share("NKE","Nike",57.8,1),
			new share("NFLX","Netflix",139.5,1),
			new share("VIA","Viacom",44.45,1),
			new share("NTDOY","Nintendo",25.07,1),
			new share("WMT","Walmart",70.65,1),
			new share("BBY","Best Buy",44.85,1),
			new share("GD","General Dynamics",191.05,1),
			new share("JNJ","Johnson&Johnson",123.8,1),
			new share("CVS","CVS",81.35,1),
			new share("AMTD","AmeriTrade",40,1),
			new share("BAC","Bank of America",25.22,1),
			new share("DKS","Dick's",51.04,1),
			new share("FDX","FedEx",194.71,1),
			new share("HPE","HP Enterprise",22.76,1),
			new share("IBM","International Business Machines",180.53,1),
			new share("TGT","Target",57.95,1),
			new share("BKS","Barnes&Noble",9.05,1),
			new share("ADBE","Adobe",119.9,1),
			new share("AAP","Advance Auto Parts",157.36,1),
			new share("AET","Aetna",129.51,1),
			new share("ADI","Analog Devices",83.65,1),
			new share("APA","Apache Corp",51.92,1),
			new share("ARNC","Arconic Inc",28.54,1),
			new share("ADSK","Autodesk",85.75,1),
			new share("BSX","Boston Scientific",25,1),
			new share("CBS","CBS",67.15,1),
			new share("CVX","Chevron",113.48,1),
			new share("CMG","Chipotle",416.29,1),
			new share("COH","Coach",38.43,1),
			new share("KO","Coca Cola",42.42,1),
			new share("CL","Colgate-Palmolive",73.74,1),
			new share("COST","Costco",170.58,1),
			new share("CSX","CSX Railroads",48.25,1),
			new share("DOW","Dow Chemical",63.35,1),
			new share("XOM","Exxon Mobil",83.46,1),
			new share("F","Ford Motors",12.65,1),
			new share("GE","General Electric",30.07,1),
			new share("GM","General Motors",37.72,1),
			new share("GT","Goodyear",36.15,1),
			new share("HPQ","HP Inc",17.44,1),
			new share("K","Kellogg",75.02,1),
			new share("KHC","Kraft Heinz",91.28,1),
			new share("LMT","Lockheed Martin",267.5,1),
			new share("JWN","Nordstrom",46.65,1),
			new share("PYPL","PayPal",42.77,1),
			new share("PEP","PepsiCo",110.11,1),
			new share("PGR","Progressive",39.68,1),
			new share("O","Realty Income",60.56,1),
			new share("SRE","Sempra Energy",109.75,1),
			new share("SPLS","Staples",9.25,1),
			new share("SBUX","Starbucks",57.12,1),
			new share("TWX","Time Warner",98.96,1),
			new share("UNP","Union Pacific Railroads",109.05,1),
			new share("URBN","Urban Outfitters",26.93,1),
			new share("VLO","Valero Energy",66.45,1),
			new share("WM","Waste Management",73.28,1),
			new share("AAL","American Airlines",45.8,1),
			new share("VMC","Vulcan Materials",121.32,1),
			new share("WFC","Wells Fargo",58.85,1),
			new share("WFM","Whole Foods Market",30.46,1),
			new share("JP:8058","Mitsubishi",2561,1),
			new share("NYA","NYSE",11575.91,0),
			new share("COMP","Nasdaq",5861.22,0),
			new share("SPX","S&P500",2381.92,0),
			new share("DJIA","Dow Jones",21002.97,0),
			new share("MA","Mastercard",111.35,1),
			new share("T","AT&T",42.07,1)};
	double worth = 100000;
	
	Stocks(){
		super("Trading");
		this.setSize(1100, 800);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(3);
		this.addKeyListener(this);
		this.addMouseWheelListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		double total = 0;
		for(int i=0;i<s.length;i++){
			total+=s[i].price*s[i].shares;
		}
		System.out.println(total);
		JPanel list = new JPanel(new GridLayout(s.length,1));
		JScrollPane ctr = new JScrollPane(list);
		for(int i=0;i<s.length;i++)
			list.add(s[i].p);
		this.add(ctr);
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		Stocks window = new Stocks();
	}
	
	public class share{
		
		String name, symbol,notes;
		double price;
		int shares;
		JPanel p = new JPanel(new GridLayout(1,5));
		JLabel t[];
		
		share(String sym,String nm,double cst,int amt){
			name = nm;
			symbol=sym;
			price = cst;
			shares = amt;
			JLabel txt[] = {new JLabel(""+symbol),new JLabel(""+name),new JLabel(""+price),new JLabel(""+shares),new JLabel(""+notes)};
			t = txt;
			for(int i=0;i<t.length;i++){
				t[i].setBorder(BorderFactory.createLineBorder(Color.black));
				p.add(t[i]);
			}
		}
		
		public void makeNote(String note){
			notes+=note+"\n";
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
