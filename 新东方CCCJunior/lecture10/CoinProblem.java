package demo;

import java.io.IOException;
import java.util.Scanner;

public class CoinProblem {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int moneyLeft = Integer.parseInt(sc.nextLine());
		String[] coinsStr = sc.nextLine().split(" ");
		int[] coins = new int[coinsStr.length];
		for (int i = 0; i < coinsStr.length; i++) {
			coins[i] = Integer.parseInt(coinsStr[i]);
		}
		
		System.out.println(count(coins, coins.length, moneyLeft));
	}
	
	public static int count(int S[], int m, int n) {
		if (n == 0) return 1;
		
		if (n < 0) return 0;
		
		if (m <= 0 && n > 0) return 0;
		
		return count(S, m-1, n) + count(S, m, n - S[m - 1]);
	}
	
}
