import java.util.*;

public class Class {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		cube();
		String next = scan.next();
		random100();
		next = scan.next();
		randomInRange();
		next = scan.next();
		powersOfTwo();
		next = scan.next();
		alarm();
		next = scan.next();
		sum100();
		next = scan.next();
		maxOfTwo();
		next = scan.next();
		sumRange();
		next = scan.next();
		larger();
	}

	public static void cube() {
		System.out.println("cube");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		System.out.println(Math.pow(num, 3));
	}
	
	public static void random100(){
		System.out.println("random100");
		Random rand = new Random();
		System.out.println((rand.nextInt(100)+1));
	}
	
	public static void randomInRange(){
		System.out.println("randomInRange");
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int low,high;
		low=scan.nextInt();
		high=scan.nextInt();
		if(high<low)
			System.err.println("SECOND NUMBER CANNOT BE SMALLER");
		else
		System.out.println(rand.nextInt(high-low+1)+low);
	}
	
	public static void powersOfTwo(){
		System.out.println("powersOfTwo");
		for(int i=1;i<11;i++)
			System.out.println(Math.pow(2, i));
	}
	
	public static void alarm(){
		System.out.println("alarm");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		while(num<1)
			System.err.println("CANNOT BE LESS THAN ONE");
		for(int i=0;i<num;i++)
			System.out.println("ALARM");
		
	}
	
	public static void sum100(){
		System.out.println("sum100");
		int num=0;
		for(int i=1;i<101;i++)
			num=num+i;
		System.out.println(num);
		
	}
	public static void maxOfTwo(){
		System.out.println("maxOfTwo");
		Scanner scan = new Scanner(System.in);
		int num1=scan.nextInt(),num2=scan.nextInt();
			if(num1>num2)
				System.out.println(num1);
			if(num2>num1)
				System.out.println(num2);
	}
	public static void sumRange(){
		System.out.println("sumRange");
		Scanner scan = new Scanner(System.in);
		int num1=scan.nextInt(),num2=scan.nextInt();
		if(num2>num1)
			System.err.println("SECOND NUMBER CANNOT BE BIGGER");
		else
			System.out.println(num2-num1);
	}
	static double num1,num2;
	public static void larger(){
		System.out.println("larger");

		Scanner scan = new Scanner(System.in);
		num1=scan.nextDouble();
		num2=scan.nextDouble();
		if(num1>num2)
			System.out.println(num2);
	}
}
