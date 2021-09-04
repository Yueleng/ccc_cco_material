import java.io.*;
import java.util.*;

public class CombiningRiceballs {
    static BufferedReader br;
    static StringTokenizer st;

    static int N;
    static boolean[][] dp;
    static int[] sz;
    static int ans;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = readInt();
        dp = new boolean[N + 1][N + 1];
        sz = new int[N + 1];
        for (int i = 1; i <= N; i++)
            sz[i] = readInt() + sz[i - 1];
        
        for (int gap = 0; gap < N; gap++) {
            for (int i = 1; i <= N; i++) {
                int j = i + gap;

                if (j > N)
                    continue;
                
                dp[i][j] = false;
                
                if (j - i == 0) {
                    dp[i][j] = true;
                } else if (j - i <= 2) {
                    if (dp[i][i] && dp[j][j] && get(i, i) == get(j, j)) {
                      dp[i][j] = true;
                    }
                }

                // [i, k], [k + 1, l - 1], [l, j]
                HashMap<Integer, Integer> sizeIndex = new HashMap<Integer, Integer>();
                for (int k = i; k <= j - 2; k++)
                    if (dp[i][k])
                        sizeIndex.put(get(i, k), k);

                for (int k = i + 2; k <= j; k++) {
                    if (dp[k][j]) {
                        if (sizeIndex.containsKey(get(k, j)) && sizeIndex.get(get(k, j)) <= k - 2) {
                            int left = sizeIndex.get(get(k, j)) + 1;
                            int right = k - 1;
                            if (dp[left][right])
                                dp[i][j] = true;
                        }
                    }
                }

                for (int k = i; k <= j - 1; k++) {
                    if (dp[i][k] && dp[k + 1][j] && get(i, k) == get(k + 1, j)) {
                        dp[i][j] = true;
                    }
                }
        
                if (dp[i][j]) {
                    ans = Math.max(ans, get(i, j));
                }
            }
        }
        System.out.println(ans);

    }

    // return the cumulative rice ball weights from slot i - 1 to j
    static int get (int i, int j) {
        return sz[j] - sz[i - 1];
      }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());        
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static Double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
