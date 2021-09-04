public class BackpackTopDown {

    int[][] cache;

    private void initialize(int m, int n) {
        cache = new int[m][n];

        // first column
        for (int j = 0; j < m; j++) {
            cache[j][0] = 1;
        }

        // first row
        for (int i = 0; i < n; i++) {
            cache[0][i] = 1;
        }
    }

    // m rows, n columns
    public int uniquePaths(int m, int n) {
        if (n < 1 || m < 1)
            return 0;
        initialize(m, n);

        return uniquePathsRecursive(m, n);

    }

    private int uniquePathsRecursive(int m, int n) {
        if (cache[m - 1][n - 1] == 0) {
            cache[m - 1][n - 1] = uniquePathsRecursive(m - 1, n) + uniquePathsRecursive(m, n - 1);
        }
        return cache[m - 1][n - 1];
    }
}
