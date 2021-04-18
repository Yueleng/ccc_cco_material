import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MouseJourney {
    public static int row;
    public static int column;
    public static int sum = 0;
    public static boolean[][] path;
    public static boolean[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        row = Integer.parseInt(info[0]);
        column = Integer.parseInt(info[1]);

        grid = new boolean[row+1][column+1];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i], true);
        }
        
        path = new boolean[row+1][column+1];

        int numOfCats;
        numOfCats = Integer.parseInt(br.readLine());
        for (int i = 0; i < numOfCats; i++) {
            info = br.readLine().split(" ");
            int row1 = Integer.parseInt(info[0]);
            int column1 = Integer.parseInt(info[1]);
            grid[row1][column1] = false; // set cat loc to false
        }

        path[1][1] = true; // start point
        List<int[]> nexts = new LinkedList<>();
        if (grid[1][2]) nexts.add(new int[]{1,2});
        if (grid[2][1]) nexts.add(new int[]{2,1});
        dfs(new int[]{1,1}, nexts);
        System.out.println(sum);
    }
    

    public static void dfs(int[] currSlot, List<int[]> nexts) {
        // if (nexts.size() == 0) 
        //     return;

        for (int[] next: nexts) {
            if (next[0] == row && next[1] == column) {
                sum += 1;
                continue;
            }
            
            path[next[0]][next[1]] = true;
            List<int[]> newNexts = validNeighbors(next);
            dfs(next, newNexts);
        }

        path[currSlot[0]][currSlot[1]] = false;
    }

    // helper function
    public static List<int[]> validNeighbors(int[] slot) {
        LinkedList<int[]> nexts = new LinkedList<>();
        int row = slot[0];
        int column = slot[1];

        // upper
        // if (row >= 2) {
        //     int[] upper = new int[] {row - 1, column};
        //     // path unvisited: path[][] == false
        //     // grid valid: grid[][] == true
        //     if (!path[upper[0]][upper[1]] && grid[upper[0]][upper[1]])
        //         nexts.add(upper);
        // }
        
        // down
        if (row <= (grid.length-1) - 1) {
            int[] down = new int[] {row + 1, column};
            if (!path[down[0]][down[1]] && grid[down[0]][down[1]])
                nexts.add(down);
        }

        // left 
        // if (column >= 2) {
        //     int[] left = new int[] {row, column-1};
        //     if (!path[left[0]][left[1]] && grid[left[0]][left[1]])
        //         nexts.add(left);
        // }


        // right
        if (column <=  (grid[0].length-1) - 1) {
            int[] right = new int[] {row, column+1};
            if (!path[right[0]][right[1]] && grid[right[0]][right[1]])
                nexts.add(right);
        }

        return nexts;
    }
}
