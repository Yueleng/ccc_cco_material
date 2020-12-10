import java.util.Scanner;

public class Shiftsum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		int factor = 0;
		for(int i = 0; i <= k; i++) {
			factor += Math.pow(10, i);
		}

		System.out.println(n * factor);
	}

}
