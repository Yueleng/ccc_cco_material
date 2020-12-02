package lecture4;

import java.io.IOException;
import java.util.Scanner;

public class ExactlyElectrical {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner((System.in));
		int[] start = new int[2];
		int[] end = new int[2];
		
		start[0] = sc.nextInt();
		start[1] = sc.nextInt();
		end[0] = sc.nextInt();
		end[1] = sc.nextInt();
		
		int power = sc.nextInt();
		
		sc.close();
		
		int horiDiff = Math.abs(start[0] - end[0]);
		int vertDiff = Math.abs(start[1] - end[1]);
		
		int dist = horiDiff + vertDiff;
		
		if ( (power >= dist) && ((power - dist) % 2 == 0)) {
			System.out.print("Y");
		} else {
			System.out.print("N");
		}
	}

}
