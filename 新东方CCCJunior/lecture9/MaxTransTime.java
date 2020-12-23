package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxTransTime {

	public int maxTime(int[][] times, int N, int K) {
		
		double[][] disTo = new double[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				disTo[i][j] = Double.MAX_VALUE;
			}
		}
		
		for(int i = 0; i < N; i++) {
			disTo[i][i] = 0;
		}
		
		for(int[] edge : times) {
			
			int from = edge[0] - 1;
			int to = edge[1] - 1;
			
			disTo[from][to] = edge[2];
		}
		
		for(int k = 1; k < N; k++) {
			for(int i = 1; i < N; i++) {
				for(int j = 1; j < N; j++) {
					
					if(disTo[i][k] + disTo[k][j] < disTo[i][j]) {
						disTo[i][j] = disTo[i][k] + disTo[k][j];
					}
				}
			}
		}
		
		double max = Double.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			max = Math.max(disTo[K-1][i],max);
		}
		
		return (int)(max);
	}
}
