import java.util.*;

public class RemoveInvalidParentheses_huahua {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0;
        int r = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                l += 1;
            if (l == 0) {
                if (ch == ')')
                    r += 1;
            } else {
                if (ch == ')')
                    l -= 1;
            }

        }

        List<String> ans = new LinkedList<>();
        dfs(s, 0, l, r, ans);
        return ans;
    }

    public static boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                count++;
            if (ch == ')')
                count--;
            if (count < 0)
                return false;
        }
        return count == 0;
    }

    // l/r: number of left/right parentheses to remove
    public static void dfs(String s, int start, int l, int r, List<String> ans) {
        // Nothing to remove.
        if (l == 0 && r == 0) {
            if (isValid(s))
                ans.add(s);
            return;
        }

        for (int i = start; i < s.length(); ++i) {
            // We only remove the first parentheses if there are consecutive
            // to avoid dupolications
            if (i != start && s.charAt(i) == s.charAt(i - 1))
                continue;

            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                String curr = s;
                curr = curr.substring(0, i) + curr.substring(i + 1, s.length());
                if (r > 0)
                    dfs(curr, i, l, r - 1, ans);
                else if (l > 0)
                    dfs(curr, i, l - 1, r, ans);

            }
        }

    }
}
