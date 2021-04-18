


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FireHose {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int LEN = 1000000;
    static int[] h;
    static int n;

    public static void main(String[] args) throws IOException {
        n = readInt(); // n: number of houses
        h = new int[2 * n];
        for (int x = 0; x < n; x++)
            h[x] = readInt();

        Arrays.sort(h, 0, n); // public static void sort(int[] arr, int from_Index, int to_Index)

        // h[] stores the address and its augumented address. i.e. + LEN
        for (int x = 0; x < n; x++)
            h[x + n] = h[x] + LEN;

        // k = number of fire hydrants
        int k = readInt();

        // lo: minimum of [largest distance of one hydrant to one house]
        // hi: maximum of [largest distance of one hydrant to one house]
        // search from (lo + hi) / 2 and do binary search approach.

        int lo = 0;
        int hi = LEN;

        while (lo < hi) {
            int mid = (hi + lo) / 2;
            // System.out.println(mid);
            if (k >= poss(mid))
                hi = mid;
            else
                lo = mid + 1;
        }
        System.out.println(lo);
    }

    // num of hydrants needed to satify that mid.
    static int poss (int mid) {
        int hydrants = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            hydrants = Math.min(hydrants, compute(i, mid));
        return hydrants;
    }

    // j: starting position of the house.
    // n + j: ending position of the house.
    // max len of house to hydrant 
    // returns num of hydrants to satisfy the max length.
    static int compute (int j, int mid) {
        int curr = j, hydrants = 1;
        for (int i = j; i < n + j; i++)
            if (h[i] - h[curr] > 2 * mid) {
                curr = i;
                hydrants++;
        }
        return hydrants;
    }




    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }


    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}
