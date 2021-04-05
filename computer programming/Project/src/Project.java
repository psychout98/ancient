
public class Project {

	public static void main(String[] args) throws InterruptedException{
		long int1=1,int2=1,int3;
		System.out.println("Fibbonacci");
		System.out.println(int1);
		while(true){
		Thread.sleep(50);
		int3=int1+int2;
		System.out.println(int3);
		Thread.sleep(50);
		int1=int2+int3;
		System.out.println(int1);
		Thread.sleep(50);
		int2=int1+int3;
		System.out.println(int2);
		if((int2+"").contains("7540113804746346429"))
			break;
	}
	}
}
