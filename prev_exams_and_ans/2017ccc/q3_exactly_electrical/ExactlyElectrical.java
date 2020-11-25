import java.io.IOException;
import java.util.Scanner;

public class ExactlyElectrical {
	public static void main (String[]args) throws IOException{
		Scanner sc = new Scanner((System.in));

		int[] start = new int [2];
		int[] end = new int [2];
		
		start[0] = sc.nextInt();
		start[1] = sc.nextInt();
		
		end[0] = sc.nextInt();
		end[1] = sc.nextInt();

		int t = sc.nextInt();
		sc.close();

		int horiDiff = Math.abs(start[0] - end[0]);
		int vertDiff = Math.abs(start[1] - end[1]);

		if ( (t >= horiDiff + vertDiff) && ((horiDiff + vertDiff - t) % 2 == 0)) {
			System.out.println("Y");
		} else {
			System.out.println("N");
		}
	}
}
