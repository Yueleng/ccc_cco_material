import java.util.*;
import java.io.*;

public class CCC20S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int s_len;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }

    public static void main(String[] args) throws IOException {
        // Map<Character, ArrayList<Integer>> prefix = createPrefix("ABCCBABACACCAABB");
        // Iterator<Character> it = prefix.keySet().iterator();
        // while (it.hasNext()) {
        // System.out.println(prefix.get(it.next()).toString());
        // }

        String s = readLine();
        s_len = s.length();
        Map<Character, ArrayList<Integer>> prefix = createPrefix(s);
        Map<Character, Integer> countABC = countABC(s);
        if (countABC.get('A') == s_len || countABC.get('B') == s_len ||
                countABC.get('C') == s_len) {
            System.out.println(0);
            return;
        }

        if (countABC.get('A') + countABC.get('B') == s_len) {
            int ABC = getMinimumSwaps(s, 'A', 'B', 'C', prefix);
            int BAC = getMinimumSwaps(s, 'B', 'A', 'C', prefix);
            System.out.println(Math.min(ABC, BAC));
            return;
        }

        if (countABC.get('B') + countABC.get('C') == s_len) {
            int BCA = getMinimumSwaps(s, 'B', 'C', 'A', prefix);
            int CBA = getMinimumSwaps(s, 'C', 'B', 'A', prefix);
            System.out.println(Math.min(BCA, CBA));
            return;
        }

        if (countABC.get('A') + countABC.get('C') == s_len) {
            int ACB = getMinimumSwaps(s, 'A', 'C', 'B', prefix);
            int CAB = getMinimumSwaps(s, 'C', 'A', 'B', prefix);
            System.out.println(Math.min(ACB, CAB));
            return;
        }

        int ABC = getMinimumSwaps(s, 'A', 'B', 'C', prefix);
        int ACB = getMinimumSwaps(s, 'A', 'C', 'B', prefix);
        int BAC = getMinimumSwaps(s, 'B', 'A', 'C', prefix);
        int BCA = getMinimumSwaps(s, 'B', 'C', 'A', prefix);
        int CAB = getMinimumSwaps(s, 'C', 'A', 'B', prefix);
        int CBA = getMinimumSwaps(s, 'C', 'B', 'A', prefix);
        System.out.println(Math.min(Math.min(Math.min(Math.min(Math.min(ABC, ACB),
                BAC), BCA), CAB), CBA));

        // System.out.println(notCount('A', 1, 5, prefix)); // 4
        // System.out.println(notCount('A', 0, 15, prefix)); // 16 - 6 = 10
        // System.out.println(notCount('A', 0, 13, prefix)); // 14 - 6 = 8
        // System.out.println(notCount('A', 1, 13, prefix)); // 13 - 5 = 8
        // System.out.println(notCount('A', 5, 13, prefix)); // 9 - 5 = 4
        // System.out.println(notCount('A', 6, 13, prefix)); // 8 - 4 = 4
        // System.out.println(notCount('A', 4, 13, prefix)); // 10 - 5 = 5
        // System.out.println(notCount('A', 4, 15, prefix)); // 12 - 5 = 7

        // System.out.println(Sxy('A', 0, 5, prefix)); // 2
        // System.out.println(Sxy('A', 0, 4, prefix)); // 1
        // System.out.println(Sxy('A', 1, 5, prefix)); // 1
    }

    public static int getMinimumSwaps(String s, char x, char y, char z, Map<Character, ArrayList<Integer>> prefix) {
        int[] counts = countXYZ(s, x, y, z);
        int count_x = counts[0];
        int count_y = counts[1];
        // System.out.println("x " + x);
        // System.out.println(x + " " + count_x);
        // System.out.println("y " + y);
        // System.out.println(y + " " + count_y);
        int count = s.length();
        for (int i = 0; i < s.length(); i++) {
            int x_start = i;
            int x_end = x_start + count_x <= s.length() ? x_start + count_x - 1 : x_start + (count_x - 1) - s.length();
            int y_start = x_end == s.length() - 1 ? 0 : x_end + 1;
            int y_end = y_start + count_y <= s.length() ? y_start + (count_y - 1)
                    : y_start + (count_y - 1) - s.length();
            // System.out.println("x_start " + x_start);
            // System.out.println("x_end " + x_end);
            // System.out.println("y_staart" + y_start);
            // System.out.println("y_end" + y_end);
            int ans = notCount(x, x_start, x_end, prefix) + notCount(y, y_start, y_end, prefix) // N_A + N_B - min(S_AB,
                                                                                                // S_BA)
                    - Math.min(Sxy(x, y_start, y_end, prefix), Sxy(y, x_start, x_end, prefix));
            if (ans < count)
                count = ans;
        }
        return count;
    }

    public static int[] countXYZ(String s, char x, char y, char z) {
        int[] count = new int[3];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == x) {
                count[0] += 1;
            } else if (c == y) {
                count[1] += 1;
            } else {
                count[2] += 1;
            }
        }

        return count;
    }

    public static Map<Character, Integer> countABC(String s) {
        Map<Character, Integer> countABC = new HashMap<>();
        countABC.put('A', 0);
        countABC.put('B', 0);
        countABC.put('C', 0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                countABC.put('A', countABC.get('A') + 1);
            } else if (c == 'B') {
                countABC.put('B', countABC.get('B') + 1);
            } else {
                countABC.put('C', countABC.get('C') + 1);
            }
        }
        return countABC;
    }

    public static Map<Character, ArrayList<Integer>> createPrefix(String s) {
        Map<Character, ArrayList<Integer>> prefix = new HashMap<>();
        prefix.put('A', new ArrayList<Integer>());
        prefix.put('B', new ArrayList<Integer>());
        prefix.put('C', new ArrayList<Integer>());

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Iterator<Character> it = prefix.keySet().iterator();
            while (it.hasNext()) {
                char A_B_C = it.next();
                if (c == A_B_C) {
                    ArrayList<Integer> listOfInt = prefix.get(A_B_C);
                    listOfInt.add(listOfInt.size() > 0 ? listOfInt.get(listOfInt.size() - 1) + 1 : 1);
                } else {
                    ArrayList<Integer> listOfInt = prefix.get(A_B_C);
                    listOfInt.add(listOfInt.size() > 0 ? listOfInt.get(listOfInt.size() - 1) : 0);
                }
            }
        }
        return prefix;
    };

    // end inclusive
    public static int _notCount(char c, int start, int end, Map<Character, ArrayList<Integer>> prefix) {
        int gap = end - start + 1;
        return gap - (prefix.get(c).get(end) - (start == 0 ? 0 : prefix.get(c).get(start - 1)));
    }

    public static int notCount(char c, int start, int end, Map<Character, ArrayList<Integer>> prefix) {
        if (end > start)
            return _notCount(c, start, end, prefix);
        else
            return _notCount(c, start, s_len - 1, prefix) + _notCount(c, 0, end, prefix);

    }

    // count of type y in x section
    // end inclusive
    public static int _Sxy(char y, int start, int end, Map<Character, ArrayList<Integer>> prefix) {
        return prefix.get(y).get(end) - (start == 0 ? 0 : prefix.get(y).get(start - 1));
    }

    public static int Sxy(char y, int start, int end, Map<Character, ArrayList<Integer>> prefix) {
        if (end > start)
            return _Sxy(y, start, end, prefix);
        else
            return _Sxy(y, start, s_len - 1, prefix) + _Sxy(y, 0, end, prefix);
    }
}