import java.awt.*;import javax.swing.*;import java.io.*;import java.awt.event.*;
public class googleSearch extends JFrame implements ActionListener{private static final long serialVersionUID=1L;
static boolean close=true;static boolean g=false;static boolean w=false;static boolean b=false;
static boolean y=false;static boolean go=true;JTextField S=new JTextField(20);JButton google,wiki,bing,yahoo,other;
static String in, s;static googleSearch window;googleSearch() {super("Websites");init();this.setSize(400, 180);
this.setVisible(close);}public void init(){this.setLayout(new GridLayout(2,1));JLabel Search=new JLabel("Search:");
JPanel panel=new JPanel(new GridLayout(1,5));JPanel panel2=new JPanel(new GridLayout(1,3));google=new JButton("Google");
wiki=new JButton("Wikipedia");bing=new JButton("Bing");yahoo=new JButton("Yahoo");other=new JButton("Other engine");
google.addActionListener(this);wiki.addActionListener(this);bing.addActionListener(this);yahoo.addActionListener(this);
other.addActionListener(this);panel2.add(other);panel2.add(Search);panel2.add(S);this.add(panel2, BorderLayout.NORTH);
panel.add(google);panel.add(wiki);panel.add(bing);panel.add(yahoo);this.add(panel, BorderLayout.SOUTH);}
public static void main(String[]args)throws AWTException,IOException,InterruptedException{boolean tryagain = true;
window=new googleSearch();window.setDefaultCloseOperation(EXIT_ON_CLOSE);Robot r=new Robot();robotGuide aweRobot
=new robotGuide();while(tryagain){Thread.sleep(100);if(go == false){char[] userType = new char[s.length()];
java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://" + in + ".com"));Thread.sleep(8000);for (int i = 0;
i<userType.length; i++) {userType[i] = s.charAt(i);aweRobot.type(userType[i]);Thread.sleep(50);}r.keyPress(KeyEvent.
VK_ENTER);tryagain = false;Thread.sleep(30000);close = true;}if(go == true){tryagain = true;}}}@Override
public void actionPerformed(ActionEvent e) {s = S.getText();if (e.getSource() == google){in = "Google";close=false;
window.setVisible(close);go=false;}if (e.getSource() == wiki) {in = "Wikipedia";close = false;window.setVisible(close);
go=false;}if (e.getSource() == bing) {in = "Bing";close = false;window.setVisible(close);go=false;}if (e.getSource()
== yahoo) {in = "Yahoo";close = false;window.setVisible(close);go=false;}if(e.getSource()==other){window.setVisible(false);
in = JOptionPane.showInputDialog("Other Search Engine:");s=JOptionPane.showInputDialog("Search:");go=false;}}}