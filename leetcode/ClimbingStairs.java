public class ClimbingStairs {
    int[] cache = new int[100];

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        if (cache[n] == 0) {
            cache[n] = climbStairs(n - 1) + climbStairs(n - 2);
        }

        return cache[n];

    }
}
