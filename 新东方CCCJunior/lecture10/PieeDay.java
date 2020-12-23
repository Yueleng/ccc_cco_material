package demo;

import java.io.IOException;
import java.util.Scanner;

public class PieeDay {
	
	public static int[][][] piCache;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // pieLeft
		int k = sc.nextInt(); // peopleLeft
		sc.close();
		
		piCache = new int[n+1][k+1][n+1];
		
		System.out.println(pi(n, k, 1/*minPie*/));
		
	}
	
	public static int pi(int n, int k, int i) {
		// Exit
		if (piCache[n][k][i] == 0) {
			if (n == k * i) {
				piCache[n][k][i] = 1;
			} else if (k == 1 && n >= i) {
				piCache[n][k][i] = 1;
			} else {
				// Relationship
				int sum = 0;
				for (int min = i; min <= n /*pieLeft*/ / k /*peopleLeft*/; min++) {
					sum += pi(n - min, k - 1, min);
				}
				piCache[n][k][i] = sum;				
			}
		}
		return piCache[n][k][i];
	}
}
