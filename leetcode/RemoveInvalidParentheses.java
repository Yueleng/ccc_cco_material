import java.util.*;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0;
        int r = 0;

        for (int i = 0; i < s.length(); i++)  {
            char ch = s.charAt(i);
            if (ch == '(') l += 1;
            if (l == 0) {
                if (ch == ')') 
                   r += 1;
            } else {
                if (ch == ')')
                    l -= 1;
            }
                
        }

        List<String> ans = new LinkedList<>();

        return 
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
}
