import java.io.*;
import java.util.*;
import java.util.stream.*;

public class LazyFox {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] pts = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            String[] info = br.readLine().split(" ");
            pts[i] = Stream.of(info).mapToInt(Integer::parseInt).toArray();
        }

        ArrayList<int[]> gs = new ArrayList<>(); // collection of edge information
        // n * (n + 1) / 2 edges
        for (int x = 0; x <= n; x++) { 
            for (int y = x+1; y <= n; y++) {
                int diffX = pts[x][0] - pts[y][0];
                int diffY = pts[x][1] - pts[y][1];
                gs.add(new int[] {diffX * diffX + diffY * diffY, x, y});
            }
        }


        int[] dp = new int[n+1];
        int[] mtain = new int[n+1];

        // dist[a]: current minimum out reaching distance for point a
        // dist[a]: last edge distance to a
        int[] dist = new int[n+1];

        // ArrayList(Collection) sort with user defined rules
        Collections.sort(gs, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] - b[0]; // return b[0] - a[0]
            }
        });

        

        // sorted by distance
        for (int[] entry: gs) {
            // System.out.print(entry[0] + ",");
            // System.out.print(entry[1] + ",");
            // System.out.print(entry[2]);
            // System.out.println();
            int d = entry[0];
            
            int a = entry[1];
            int b = entry[2];

            // update dist[a] if d > dist[a]
            if (d != dist[a]) {
                dist[a] = d;
                mtain[a] = dp[a];
            }
            
            if (d != dist[b]) {
                dist[b] = d;
                mtain[b] = dp[b];
            }
            
            if (a == 0) {
                dp[a] = Math.max(dp[a], mtain[b]);
            } else {
                dp[a] = Math.max(dp[a], mtain[b] + 1);
                dp[b] = Math.max(dp[b], mtain[a] + 1);
            }
        }

        System.out.println(dp[0] + 1); // why + 1?

    }
}
