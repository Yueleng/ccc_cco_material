import java.util.ArrayList;
import java.util.List;

public class ExpressionAndOperator_ {
    private char[] num;
    private List<String> ans;
    private char[] exp; // "a+b" => ['a', '+', 'b']
    private int target;

    public List<String> addOperators(String num, int target) {
        this.num = num.toCharArray();
        this.ans = new ArrayList<>();
        this.target = target;
        this.exp = new char[num.length() * 2];
        dfs(0, 0, 0, 0);
        return ans;
    }

    // pos: current pos pointer of the num string.
    // len: current length of expression.
    // curr: current value of expression.
    // prev: last element in the expression.
    public void dfs(int pos, int len, long prev, long curr) {
        if (pos == num.length) {
            if (curr == target)
                // ['a', '+', 'b'] => "a+b"
                ans.add(new String(exp /* char array */, 0 /* starting point of char array */,
                        len /* end point of char array */));
            return;
        }

        int s = pos;
        int l = len;

        if (s != 0) // s > 0, not the first position.
            len++;

        long n = 0;

        // 1203
        // 1 + 2 => 0 or 03
        // 1 + 20 => 3
        while (pos < num.length) {
            if (num[s] == '0' && pos - s > 0) {
                break; // 0X...
            }
            n = n * 10 + (int) (num[pos] - '0'); // (int)('9' - '0') = 9; (int)('1' - '0') = 1; int('1')
            if (n > Integer.MAX_VALUE)
                break;

            // exp = [..., 'a', '+', num[pos]] or exp = [..., 'a', '+', 'b', num[pos]]
            exp[len++] = num[pos++]; // exp[len] = num[pos]; len++; pos++;
            if (s == 0) {
                dfs(pos, len, n, n);
                continue;
            }

            exp[l] = '+';
            dfs(pos, len, n, curr + n);
            exp[l] = '-';
            dfs(pos, len, -n, curr - n);
            exp[l] = '*';
            dfs(pos, len, prev * n, curr - prev + prev * n);
        }
    }
}
