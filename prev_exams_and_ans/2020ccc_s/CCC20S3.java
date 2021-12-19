import java.util.*;
import java.io.*;

public class CCC20S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

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
        String N = readLine();
        String H = readLine();
        if (N.length() > H.length()) {
            System.out.println(0);
            return;
        }
        Map<Character, Integer> NCount = getCount(N);
        System.out.println(getResult(H, N.length(), NCount));
    }

    public static int getResult(String s, int n, Map<Character, Integer> NCount) {
        int num = 0;
    
        Set<String> collection = new TreeSet<>(); // HashSet<>();
        // List of chars
        LinkedList<Character> chars = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            chars.add(c);
        }

        collection.add(charListToString(chars));

        Map<Character, Integer> subCount = getCount(charListToString(chars));
        // compare NCount with subCount
        if (compareCount(NCount, subCount)) {
            num += 1;
        }

        for (int i = 1; i <= s.length() - n; i++) {
            // copy s to a new_s, getsubstring from new_s
            // String sub = s.substring(i, i+n);

            chars.removeFirst();
            chars.add(s.charAt(i + n - 1));

            String sub = charListToString(chars);

            if (!collection.contains(sub)) {
                collection.add(sub);
                Map<Character, Integer> subCount1 = getCount(sub);
                // compare NCount with subCount
                if (compareCount(NCount, subCount1)) {
                    num += 1;
                }
            }
                
        }

        return num;
    }

    public static String charListToString(List<Character> chars) {
        return chars.toString().substring(1, 3 * chars.size() - 1).replaceAll(", ", "");
    }

    // O(s.length * log(s.length))
    public static Map<Character, Integer> getCount(String s) {
        Map<Character, Integer> count = new TreeMap<>(); // HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }
        return count;
    }

    // O(keys.length)
    public static boolean compareCount(Map<Character, Integer> count1, Map<Character, Integer> count2) {
        Iterator<Character> count2KeysIt = count2.keySet().iterator();
        while (count2KeysIt.hasNext()) {
            Character key = count2KeysIt.next();
            if (!count1.containsKey(key))
                return false;
            if (!count1.get(key).equals(count2.get(key)))
                return false;
        }
        return true;
    }
}