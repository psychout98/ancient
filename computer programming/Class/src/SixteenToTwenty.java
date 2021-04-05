import java.util.Scanner;


public class SixteenToTwenty {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args){
	System.out.println();
	}
	
	public static double larger(){
		double num1 = scan.nextDouble(),num2 = scan.nextDouble();
		return (num1>num2?num1:num2);
	}
	
	public static int countA(){
		int num=0;
		String string = scan.nextLine();
		for(int i=0;i<string.length();i++)
		num = (string.charAt(i)=='A'?num+1:num);
		return num;
	}
	
	public static boolean evenlyDivisible(){
		int num1=scan.nextInt(),num2=scan.nextInt();
		return ((num1%num2==0||num2%num1==0)&&num1!=0&&num2!=0?true:false);		
	}
	
	public static boolean isAlpha(){
		String C = scan.next();
		char c = C.charAt(0);
		return (true);
	}
	
	public static boolean floatEquals(){
		float f1=scan.nextFloat(),f2=scan.nextFloat(),f3=scan.nextFloat();
		return (f1>=f2-f3&&f1<=f2+f3?true:false);
	}
	
	public static String reverse(){
		String string = scan.nextLine(),Reverse="";
			for(int j=string.length()-1;j>-1;j--)
			Reverse=Reverse+string.charAt(j);	
		return Reverse;
	}
}
