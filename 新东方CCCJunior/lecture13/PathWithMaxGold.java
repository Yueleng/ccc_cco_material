package codeII;

public class PathWithMaxGold {

	
	public int maxGold(int[][] grid) {
		int max = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				max = Math.max(helper(grid, i , j), max);
			}
		}
		return max;
	}
	
	public int helper(int[][] grid, int x, int y) {
		
		if(grid[x][y] == 0) {
			return 0;
		}
		
		int cur = grid[x][y];
		grid[x][y] = 0;
		
		int max = 0;
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		
		for(int i = 0; i < 4; i++) {
			if(isSafe(grid, x+dx[i], y+dy[i])) {
				max = Math.max(helper(grid, x+dx[i] , y+dy[i]), max);
			}
		}
		
		grid[x][y] = cur;
		return max + cur;
	}
	
	public boolean isSafe(int[][] grid, int x, int y) {
		return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] != 0;
	}
	
}
