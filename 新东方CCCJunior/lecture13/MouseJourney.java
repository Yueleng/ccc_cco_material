package codeII;

import java.util.*;

public class MouseJourney {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		long[][] dp = new long[x + 1][y + 1];
		
		int cat = sc.nextInt();
		
		while(cat-- > 0) {
			dp[sc.nextInt()][sc.nextInt()] = -1;
		}
		
		for(int i = 1; i <= x; i++) {
			for(int j = 1; j <= y; j++) {
				
				if(dp[i][j] == -1) {
					continue;
				}else if(i == 1 && j == 1) {
					dp[i][j] = 1;
				}else {
					dp[i][j] = 
							((dp[i-1][j] == -1) ? 0 : dp[i-1][j])
						  + ((dp[i][j-1] == -1) ? 0 : dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[x][y]);
	}

}
