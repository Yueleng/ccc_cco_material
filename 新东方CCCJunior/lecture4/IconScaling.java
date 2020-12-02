package lecture4;

import java.util.Scanner;
import java.io.IOException;

public class IconScaling {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// int scale = Integer.parseInt(sc.nextLine());
		int scale = sc.nextInt();
		sc.close();
		
		for (int i = 1; i <= 3*scale; i++) {
			for (int j = 1; j <= 3*scale; j++) {
				if (i <= scale) {
					if (j <= scale) {
						System.out.print("*");
					} else if (j >= scale + 1 && j <= scale * 2) {
						System.out.print("x");
					} else {
						System.out.print("*");
					}
				} else if (i >= scale + 1 && i <= 2 * scale) {
					if (j <= scale) {
						System.out.print(" ");
					} else if (j >= scale + 1 && j <= scale * 2) {
						System.out.print("x");
					} else if (j >= scale * 2 + 1) {
						System.out.print("x");
					}
				} else {
					if (j <= scale) {
						System.out.print("*");
					} else if (j >= scale + 1 && j <= scale * 2) {
						System.out.print(" ");
					} else if (j >= scale * 2 + 1) {
						System.out.print("*");
					}
				}
			}
			System.out.println();
		}
		
	}

}
