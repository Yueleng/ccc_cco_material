import java.util.*;
import java.io.*;

public class BalancedTrees {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashMap<Long, Long> dp;

    public static void main(String[] args) throws IOException {
        long N = readLong();
        dp = new HashMap<Long, Long>();
        long t = count(N);
        System.out.println(t);
    }

    static long count(long n) {
        if (n == 1 || n == 2)
            return 1;
        if (dp.containsKey(n))
            return dp.get(n);
        long k = n;
        long c = 0;

        while (k >= 2) {
            // # k: upper bound branches
            // # e.g.: n = 100, k = 100, x = 1, nn = 50, fin += (100 - 50) * func(1)
            // # next n = 100, k = 50, x = 2, nn = 33, fin += (50 - 33) * func(2)
            // # ...
            long x = n / k;
            // # nn: lower bound branches
            long nn = n / (x + 1);
            // # func(2) = 1, k - nn = 1
            c += (k - nn) * count(x);
            k = nn;
        }
        dp.put(n, c);
        return c;
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

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}