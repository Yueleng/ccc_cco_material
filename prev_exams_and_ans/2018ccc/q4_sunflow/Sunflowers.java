import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sunflowers {
	private static int[][] grid;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		grid = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] row = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		transBackFrom(determineDegree());
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
	
	public static String determineDegree() {
		int N = grid.length;
		if (grid[0][N-1] < grid[0][N-2] && grid[0][N-1] < grid[1][N-1]) {
			return "positive_90";
		} else if (grid[N-1][N-1] < grid[N-1][N-2] && grid[N-1][N-1] < grid[N-2][N-1]) {
			return "diagonal";
		} else if (grid[N-1][0] < grid[N-2][0] && grid[N-1][0] < grid[N-1][1]) {
			return "negative_90";
		}
		return "zero";
	}
	
	public static void transBackFrom(String direction) {
		int N = grid.length;
		int[][] rotatedGrid = new int[N][N];
		
		if (direction.equals("positive_90")) {
			for(int x = 0; x < N; x++) {
		        for(int y = 0; y < N; y++) {
		            rotatedGrid[N-1-y][x] = grid[x][y];
		        }
		    }
			grid = rotatedGrid;
		} else if (direction.equals("diagonal")) {
			for(int x = 0; x < N; x++) {
		        for(int y = 0; y < N; y++) {
		            rotatedGrid[N-1-x][N-1-y] = grid[x][y];
		        }
		    }
			grid = rotatedGrid;
		} else if (direction.equals("negative_90")) {
		    for(int x = 0; x < N; x++) {
		        for(int y = 0; y < N; y++) {
		            rotatedGrid[y][N-1-x] = grid[x][y];
		        }
		    }
		    grid = rotatedGrid;
		}
		
	}
}