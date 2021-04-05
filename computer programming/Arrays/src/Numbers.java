import java.util.*;

public class Numbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num[] = new int[1000], nums = 0;
		num[0] = scan.nextInt();
		while (num[nums] < 51) {
			nums++;
			num[nums] = scan.nextInt();
		}
		int Num[] = new int[nums];
		for(int i=0;i<Num.length;i++)
			Num[i]=num[i];
		int numbers[] = new int[50];
		boolean numUsed[] = new boolean[50];
		for (int i = 0; i < 50; i++)
			numbers[i] = i + 1;
		int frequency[] = new int[50];
		for (int i = 0; i < numbers.length; i++) {
			frequency[i] = 0;
			for (int j = 0; j < Num.length; j++) {
				if (Num[j] == numbers[i]){
					numUsed[i]=true;
					frequency[i]++;
				}
			}
		}
		String list = "";
		for (int i = 0; i < Num.length - 1; i++)
			list += Num[i] + ", ";
		list += Num[Num.length - 1];
		System.out.println(list);
		for (int i = 0; i < numbers.length; i++)
			if(numUsed[i])
			System.out.println(numbers[i] + ": " + frequency[i]);
	}
}
