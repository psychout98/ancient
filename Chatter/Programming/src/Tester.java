//Noah Heath	pd. 4

public class Tester {

	public static void main(String[] args) {
		char ch[] = new char[26];
		for(int i=65;i<91;i++)
			ch[i-65] = (char) i;
		for(int i=0;i<25;i++)
			System.out.print(ch[i]+", ");
		System.out.print(ch[25]);
	}

}
