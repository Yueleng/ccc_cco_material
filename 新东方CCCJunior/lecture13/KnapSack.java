package codeII;

public class KnapSack {
	
	public int knapsack(int[] val, int[] weight, int W) {
		
		int n = val.length;
		
		int[][] dp = new int[n+1][W+1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= W; j++) {
				
				if(weight[i] > j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(val[i] + dp[i-1][j-val[i]], dp[i-1][j]);
				}
			}
		}
		return dp[n][W];
	}

}
