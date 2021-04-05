import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

public class gold extends JApplet{

	public void paint(Graphics p){
		setSize(1200,700);
		p.setColor(Color.white);
		double a=4;
		for(double b=0;b<1;b+=.1/a){
			if(b>1/(b+1)){
				System.out.println(a*(b-(.1/a))+" "+(a/((b-(.1/a))+1))+" "+a*Math.sqrt(1+(b-(.1/a))*(b-(.1/a))));
				System.out.println(a*b+" "+(a/(b+1))+" "+a*Math.sqrt(1+b*b));
				break;
		}
		}
	
		double b = 1;
		for(double a1=1;a1<1000;){
				if((b/a1)==(a1/(a1+b))){
					System.out.println("Gold: "+a1+" "+b);
					break;
				}
				else if((b/a1)>(a1/(a1+b))){
				//	if(a1/b>1.618)
					System.out.println(a1+" "+b+" "+(a1/b));
					a1++;
				}
				else if((b/a1)<(a1/(a1+b)))
					b++;
		}
		p.setColor(Color.black);
		int x=600,y=350;
		double n=1,n2=2,n3=0;
		System.out.print("\n1 "+n+"\n2 "+n2+"\n");
		x-=2;y++;
		while(n3<5){
			n+=n2;
			System.out.println(n3+" "+n+" "+(n/n2)+" "+n/n3);
		//	p.drawRect(x+(int)(n3%2==0?0:-n), y+(int)(n3%2==0?0:-n), (int)n, (int)n);
		//	p.drawArc(x+(int)(n3%2==0?0:-2*n), y-(int)n, (int)n*2, (int)n*2, n3%2==0?180:0, 90);
		//	p.drawOval(x+(int)(n3%2==0?0:-2*n), y-(int)n, (int)n*2, (int)n*2);
			x+=(int)(n3%2==0?n:-n);
			y+=(int)(n3%2==0?n:-n);
			n2+=n;
			System.out.println(n3+" "+n2+" "+(n2/n)+" " + n2/n3);
		//	p.drawRect(x+(int)(n3%2==0?0:-n2), y+(int)(n3%2==0?-n2:0), (int)n2, (int)n2);
		//	p.drawArc(x-(int)n2, y+(int)(n3%2==0?-2*n2:0), (int)n2*2, (int)n2*2, n3%2==0?270:90, 90);
		//	p.drawOval(x-(int)n2, y+(int)(n3%2==0?-2*n2:0), (int)n2*2, (int)n2*2);
			x+=(int)(n3%2==0?n2:-n2);
			y+=(int)(n3%2==0?-n2:n2);
			n3++;
		}
		p.drawOval(300, 300, 300, 300);
		p.drawOval(450, 150, 300, 300);
		p.drawOval(300, 150, 300, 300);
		p.drawOval(450, 300, 300, 300);
		p.drawOval(375, 100, 300, 300);
		p.drawOval(375, 350, 300, 300);
		p.drawOval(250, 225, 300, 300);
		p.drawOval(500, 225, 300, 300);
	}
	
}
