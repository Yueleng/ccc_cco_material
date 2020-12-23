package graph;

public class ComputerCommunicate {
	
	public int computerCanCommunicate(int[][] grid) {
		
		int numRows = grid.length;
		int numCols = grid[0].length;
		
		int[] rowCount = new int[numRows];
		int[] columnCount = new int[numCols];
		
		int total = 0;
		
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				
				if(grid[i][j] == 1) {
					total++;
					rowCount[i]++;
					columnCount[j]++;
				}
			}
		}
		
		
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				
				if(grid[i][j] == 1 && rowCount[i] == 1 && columnCount[j] == 1) {
					total --;
				}
			}
		}		
		
		return total;
	}

}
