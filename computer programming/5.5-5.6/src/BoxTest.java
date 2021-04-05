//pd.7 Noah Heath 4/22/14
public class BoxTest {
	public static void main(String[] args){
	Box box1=new Box(10,4,12);
	Box box2=new Box(8,6,4);
	Box box3=new Box(10,2,16);
	System.out.println(box1+"\n"+box2+"\n"+box3);
	box1.setDepth(0);
	System.out.println(box1);
}
}