import java.util.*;

public class MinimumSwapsToMakeSequencesIncreasing {

    // dp[i][0] stores the ans that num1[i] and num2[i] isn't swapped
    // dp[i][1] stores the ans that num1[i] and num2[i] is swapped
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] A = Arrays.copyOf(nums1, n);
        int[] B = Arrays.copyOf(nums2, n);

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i][1] = n;

            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + 1;
            }

            if (B[i] > A[i - 1] && A[i] > B[i - 1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
            }
        }

        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }

}