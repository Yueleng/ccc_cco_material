class DominoAndTrominoTiling {
    public static int numTilings(int n) {

        // int[][] dp = new int[n][2];
        // int kMod = 1000000000 + 7;
        // for (int i = 2; i < n + 1; i++) {
        // dp[i][0] = (dp[i - 1][0] + dp[i - 2][0] + 2 * dp[i - 1][1]) % kMod;
        // dp[i][1] = (dp[i - 2][0] + dp[i - 1][1]) % kMod;
        // }

        // return 0;

        long kMod = 1000000000 + 7;
        long[] dp = new long[1000];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        if (n <= 3)
            return (int) dp[n];

        for (int i = 4; i <= n; i++) {
            dp[i] = 2 * dp[i - 1] + dp[i - 3];
            dp[i] %= kMod;
        }

        return (int) dp[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 30; i++) {
            System.out.println(numTilings(i));
        }
    }
}