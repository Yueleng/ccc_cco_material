import java.io.*;
import java.util.Arrays;

public class MouseJouneyDp {
    public static int row;
    public static int column;
    public static int[][] paths;
    public static boolean[][] grid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        row = Integer.parseInt(info[0]);
        column = Integer.parseInt(info[1]);

        grid = new boolean[row+1][column+1];
        paths = new int[row+1][column+1];

        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i], true);
        }

        int numOfCats;
        numOfCats = Integer.parseInt(br.readLine());
        for (int i = 0; i < numOfCats; i++) {
            info = br.readLine().split(" ");
            int row1 = Integer.parseInt(info[0]);
            int column1 = Integer.parseInt(info[1]);
            grid[row1][column1] = false; // set cat loc to false
        }

        calculate();

        System.out.println(paths[row][column]);
    }

    public static void calculate() {
        paths[0][1] = 1;
        for (int i = 1; i < row+1; i++)
            for (int j = 1; j < column+1; j++)
                if (grid[i][j]) 
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];
    }

}
