import java.util.*;

public class RemoveInvalidParentheseFaster {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0;
        int r = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                l += 1;
            if (ch == ')') {
                if (l == 0)
                    r += 1;
                else
                    l -= 1;
            }
        }

        List<String> ans = new LinkedList<>();
        dfs(s, 0, l, r, ans);
        return ans;
    }

    private boolean isValid(String s) {
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

    private boolean shoudContinueSearch(String s) {
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
        return true;
    }

    private void dfs(String s, int start, int l, int r, List<String> ans) {
        // Nothing to remove
        if (l == 0 && r == 0) {
            if (isValid(s))
                ans.add(s);
            return;
        }

        if (!shoudContinueSearch(s.substring(0, start)))
            return;

        for (int i = start; i < s.length(); i++) {
            // We only remove the first parentheses if there are consecutive ones
            // to avoid duplications
            if (i != start && s.charAt(i) == s.charAt(i - 1))
                continue;

            if (s.charAt(i) == ')') {
                String curr = s;
                curr = curr.substring(0, i) + curr.substring(i + 1, s.length());
                if (r > 0)
                    dfs(curr, i, l, r - 1, ans);
            }

            if (s.charAt(i) == '(') {
                String curr = s;
                curr = curr.substring(0, i) + curr.substring(i + 1, s.length());
                if (l > 0)
                    dfs(curr, i, l - 1, r, ans);
            }
        }
    }
}
