import java.util.*;
import java.io.*;

public class ItsToughBeingATean {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] adj = new int[8][8];
        int[] cnt = new int[8];

        // construct the relationship
        adj[1][7] = 1; // 1 should happen before 7
        adj[1][4] = 1;
        adj[2][1] = 1;
        adj[3][4] = 1;
        adj[3][5] = 1; // 3 should happend before 5

        cnt[7] = 1;
        cnt[4] = 2; // 2 things happened before 4
        cnt[1] = 1;
        cnt[5] = 1;

        while (true) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            adj[a][b] = 1;
            cnt[b] += 1;

            if (a == 0 && b == 0)
                break;
        }

        // order the events
        int index = 1;
        int[] order = new int[8];

        for (int i = 1; i <= 7; i++) {
            // i is useless here

            for (int j = 1; j <= 7; j++) {
                // only care about those event that has no proceeedings
                if (cnt[j] == 0) {
                    order[index] = j; index++;
                    cnt[j] = -1;

                    // KEY IDEA
                    for (int k = 1; k <= 7; k++) {
                        
                        if (adj[j][k] == 1) {
                            adj[j][k] = 0;
                            cnt[k] -= 1; // set k's proceedings minus 1
                        }
                    }
                    break; // avoid k < j and cnt[k] - 1 == 0
                }
            }
        }
        // print out result
        if (index < 7)
            System.out.println("Cannot complete these tasks. Going to bed.");
        else 
            for (int i = 1; i <= 7; i++)
                System.out.print(order[i] + " ");
    }
}