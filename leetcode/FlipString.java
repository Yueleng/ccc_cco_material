public class FlipString {

    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] l = new int[n + 1];
        int[] r = new int[n + 1];
        char[] S = s.toCharArray();

        r[n] = S[n - 1] == '1' ? 0 : 1;

        for (int i = n; i >= 2; i--) {
            // if S[i-2] == '0' => r[i-1] = r[i] + 1,
            // else if S[i-2] == '1' => r[i-1] = r[i]
            r[i - 1] = r[i] + '1' - S[i - 2];
        }

        for (int i = 1; i <= n; i++)
            l[i] = l[i - 1] + S[i - 1] - '0';

        int ans = l[0] + r[1];
        for (int i = 1; i <= n; i++)
            ans = Math.min(ans, l[i - 1] + r[i]);

        ans = Math.min(ans, l[n]);
        return ans;
    }

}
