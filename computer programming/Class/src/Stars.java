import java.util.*;

public class Stars {
	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		System.out.println("What do you want the max rows to be?");
		int input = scan.nextInt();
		final int MAX_ROWS = input;

		for (int row = 1; row <= MAX_ROWS; row++) {
			for (int star = 1; star <= row; star++){
				System.out.print("*");
			Thread.sleep(50);
			if (star % 10 == 0)
				System.out.println();
			}

			System.out.println("0");
		}
	}
}
