# Reivew Of CCC Tutorial

# Date: 07.17.2021


### Q 

### Solution:
```Python
class p:
    def __init__(self, x, y):
        self.x = x
        self.y = y

def init_order():
    order.append(p(2, 2))
    order.append(p(2, 1))
    order.append(p(2, 3))
    order.append(p(1, 2))
    order.append(p(3, 2))


def fillR(r, cnt):
    if v[r][1]:
        a[r][1] = 2 * a[r][2] - a[r][3]
        col[1] -= 1
        v[r][1] = False

    if v[r][3]:
        a[r][3] = 2 * a[r][2] - a[r][1]
        col[3] -= 1
        v[r][3] = False

    if v[r][2]:
        a[r][2] = int((a[r][1] + a[r][3]) / 2)
        col[2] -= 1
        v[r][2] = False

    row[r] -= 1
    return cnt - 1


def fillC(c, cnt):
    if v[1][c]:
        a[1][c] = 2 * a[2][c] - a[3][c]
        row[1] -= 1
        v[1][c] = False

    if v[3][c]:
        a[3][c] = 2 * a[2][c] - a[1][c]
        row[3] -= 1
        v[3][c] = False

    if v[2][c]:
        a[2][c] = int((a[1][c] + a[3][c]) / 2)
        row[2] -= 1
        v[2][c] = False

    col[c] -= 1
    return cnt - 1


def fillCell(r, c, cnt):
    row[r] -= 1
    col[c] -= 1
    v[r][c] = False
    a[r][c] = 0
    return cnt - 1


if __name__ == "__main__":
            
    a = [[0, 0, 0, 0] for i in range(4)]
    v = [[False, False, False, False] for i in range(4)]
    row = [0, 0, 0, 0]
    col = [0, 0, 0, 0]
    cnt = 0
    order = []

    # execute only if run as a script
    init_order()

    for i in range(1, 4):
        j = 1
        for x in input().split(' '):
            if x == "X":
                v[i][j] = True
                row[i] += 1
                col[j] += 1
                cnt += 1
            else:
                a[i][j] = int(x)
            j += 1

    while cnt > 0:
        
        ok = False
        for i in range(1, 4):
            if row[i] == 1:
                # print("fill r ", i)
                cnt = fillR(i, cnt)
                ok = True
                break
        if ok:
            continue
        for i in range(1, 4):
            if col[i] == 1:
                # print("fill c ", i)
                cnt = fillC(i, cnt)
                ok = True
                break
        if ok:
            continue
        for p in order:
            if v[p.x][p.y]:
                # print("fill cell  ", p.x, " ", p.y)
                cnt = fillCell(p.x, p.y, cnt)
                ok = True
                break
        if ok:
            continue
        for i in range(1, 4):
            for j in range(1, 4):
                if v[i][j]:
                    # print("fill cell ", i, " ", j)
                    cnt = fillCell(i, j, cnt)
                    ok = True
                    break
            if ok:
                break
                
    for i in range(1, 4):
        for j in range(1, 4):
            print(a[i][j], end=" ")
        print()
```

# Date: 07.25.2021

### Q: 307. Range Sum Query - Mutable
### URL: https://leetcode.com/problems/range-sum-query-mutable/
### 涉及算法/数据结构: Segment Tree

### Solution
```Python
class SegmentTreeNode:
    def __init__(self, start, end, sums, left, right):
        """
        start: starting index of this Node
        end: ending index of this Node
        sums: sums of starting index to ending index in the number array
        left (SegmentTreeNode): left branch 
        right (SegmentTreeNode): right branch
        """
        self.start = start
        self.end = end
        self.sums = sums
        self.left = left
        self.right = right

class NumArray(object):
    def __build(self, start, end):
        if (start == end):
            return SegmentTreeNode(start, end, self.nums[start], None, None)
        mid = start + int((end - start) / 2)
        # mid = int(( start + end ) / 2)
        left = self.__build(start, mid)
        right = self.__build(mid + 1, end)
        sums = left.sums + right.sums
        return SegmentTreeNode(start, end, sums, left, right)

    def __update(self, root, i, val):
        if root.start == i and root.end == i:
            root.sums = val
            return
        
        mid = root.start + (int(root.end - root.start) / 2)
        if (i <= mid):
            self.__update(root.left, i, val)
        if (i > mid):
            self.__update(root.right, i, val)
        root.sums = root.left.sums + root.right.sums

    def __sumRange(self, root, i, j):
        if i == root.start and j == root.end:
            return root.sums
        
        mid = root.start + int((root.end - root.start) / 2)
        if (j <= mid):
            return self.__sumRange(root.left, i, j)
        elif (i > mid):
            return self.__sumRange(root.right, i, j)
        else:
            return self.__sumRange(root.left, i, mid) + self.__sumRange(root.right, mid+1,j)

    def __init__(self, nums):
        self.nums = nums
        self.root = self.__build(0, len(nums) - 1)
    
    def update(self, index, val):
        self.__update(self.root, index, val)

    def sumRange(self, left, right):
        return self.__sumRange(self.root, left, right)
```

# Date: 08.01.2021

### Q: 307. Range Sum Query - Mutable

### URL: https://leetcode.com/problems/range-sum-query-mutable/

### 涉及算法/数据结构: Fenwick Tree

```Python
class FenwickTree:
    def __init__(self, n):
        self.n = n
        self.sums = [0 for i in range(n)]
    def __lowbit(self, x):
        # '&':bit wise operator
        # 5: 0101, 
        # -5: ~(5) + 1: 1010 + 1: 1011
        # 0101 & 1011 =? 0001
        return x & -x
    
    def update(self, i, delta): # delta: increment
        while i < self.n:
            self.sums[i] += delta
            i += self.__lowbit(i)
    
    def query(self, i):
        sums = 0
        while i > 0:
            sums += self.sums[i]
            i -= self.__lowbit(i)
        return sums

class NumArray(object):
    def __init__(self, nums):
        self.nums = [0] + nums
        self.tree = FenwickTree(len(self.nums))
        for i in range(1, len(self.nums)):
            self.tree.update(i, self.nums[i])
    
    def update(self, index, val):
        i = index + 1
        delta = val - self.nums[i]
        self.tree.update(i, delta)
        self.nums[i] = val

    def sumRange(self, left, right):
        # sum([0, ..., left-1])
        # sum([0, ..., right])
        return self.tree.query(right + 1) - self.tree.query(left)
```

# Date: 08.08.2021

### Q: LeetCode: 535. Encode and Decode TinyURL

### URL: https://leetcode.com/problems/encode-and-decode-tinyurl/

### 涉及算法/数据结构: DP

### Solution: 
```java
public class Codec {
    
    HashMap<Character, String> huffmanTable;
    Node root;
    
    //Huffman Tree Node
    class Node {
        char c;
        int val;
        Node left, right;
        
        Node(char c, int val) {
            this.c = c;
            this.val = val;
            this.left = null;
            this.right = null;
        }
        Node(char c, int val, Node left, Node right) {
            this.c = c;
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    void createHuffmanTable(Node node, String encoding) {
        if(node.left == null && node.right == null) {
            huffmanTable.put(node.c, encoding);
            // System.out.println(node.c + " ~ " + encoding + " ~ " + f.get(node.c)); // Prints all character's encoding and frequency
            return;
        }
        
        createHuffmanTable(node.left, encoding + "0");
        createHuffmanTable(node.right, encoding + "1");
    }
    
    // Encodes a URL to a shortened URL.
    // Steps
    //   1. Populate the longUrl to create the HashMap<Character, Integer> f
    //   2. Populate the HashMap<> f to create the PriorityQueue<Node> pq
    //   3. Populate the PriorityQueue pq to create the HuffmanTree with Node: root
    //   4. Populate the HuffmanTree to create the HuffmanTable<Character, String> huffmanTable
    //   5. Populate the longUrl and attach each Char with the value in huffmanTable, i.e., 'a' -> '000'
    public String encode(String longUrl) {
        int len = longUrl.length();

        huffmanTable = new HashMap<>(); // HashMap containing each unique character and its Huffman encoding ('a' -> '000', 'b' -> '110' etc.)
        HashMap<Character,Integer> f = new HashMap<>(); // HashMap containing each unique character and its frequency ('a' -> 2, 'b' -> 5 etc.)
        
        // Filling HashMap with each unique character and its frequency in longUrl
        for(int i = 0 ; i < len; i++) {
            char c = longUrl.charAt(i);
            if(!f.containsKey(c)) {
                f.put(c, 0);  // Create an entry for new unique character found in longUrl
            }
            f.put(c, f.get(c) + 1);  // Increase its frequency by 1
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(len, (a,b) -> a.val - b.val); // For building Huffman Tree
        for(Map.Entry<Character, Integer> entry : f.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue())); // Add all unique characters present in url to priority queue (based on their frequency)
        }
        
        root = null; // Root of HuffmanTree

        // We run this till we have only one node left in priority queue and this remaining last node will be the root of our Huffman tree
        while(pq.size() > 1) {
            Node a = pq.poll(); // 1st Minimum frequency character in Priority Queue
            Node b = pq.poll(); // 2nd Minimum frequency character in Priority Queue
            Node node = new Node('\u0000', a.val + b.val, a, b); // Create a new Node with frequency as 'sum of a's frequency and b's frequency'
            root = node;
            pq.add(node);       // Push newly created node back into priority queue
        }
        
        createHuffmanTable(root, ""); // Filling huffmanTable to see our encodings
        
        StringBuilder url = new StringBuilder("http://tinyurl.com/");
        for(int i = 0 ; i < len ; i++) {
            char c = longUrl.charAt(i);
            url.append(huffmanTable.get(c));
        }

        return url.toString();
    }

    // Decodes a shortened URL to its original URL.
    // Steps:
    //   1. Populate the shortUrl to decode each '0101...10' back to Char in the tree, 
    //                         every time start from root, 0 means left, 1 means right
    public String decode(String shortUrl) {
        int len = shortUrl.length();
        StringBuilder url = new StringBuilder();
        
        // {0..18} is "http://tinyurl.com/" so ignore it during decoding
        for(int i = 19 ; i < len ;) {
            Node node = root; // Always start at root of Huffman tree
            
            // Only leaf nodes have valid characters rest are '\u0000'
            while(node.left != null && node.right != null) {
                // If '0', go left in Huffman tree else go right
                if(shortUrl.charAt(i) == '0') {
                    node = node.left;
                } else {
                    node = node.right;
                }
                i++;
            }
            
            // Append leaf node's character to the url
            url.append(node.c);
        }
        return url.toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
```

# Date: 08.14.2021

### Q: LeetCode 926. Flip String to Monotone Increasing
### Q: LeetCode 62. Unique Paths
### Q: 70. Climbing Stairs

### URL: https://leetcode.com/problems/flip-string-to-monotone-increasing/
### URL: https://leetcode.com/problems/unique-paths/
### URL: https://leetcode.com/problems/climbing-stairs/

### 涉及算法/数据结构: DP

### Solution:
```java
class Solution {
    public int minFlipsMonoIncr(String s) {
      int n = s.length();
      int[] l = new int[n+1];
      int[] r = new int[n+1];
      char[] S = s.toCharArray();

      // l[1] = S[0] == '0' ? 0 : 1;
      r[n] = S[n-1] == '1' ? 0 : 1;

      for (int i = 1; i <= n; i++)
        l[i] = l[i - 1] + S[i-1] - '0';

      for (int i = n; i >= 2; i--)
        r[i-1] = r[i] + '1' - S[i-2];

      int ans = l[0] + r[1];

      for (int i = 1; i <= n; i++)
        ans = Math.min(ans, l[i-1] + r[i]);

      ans = Math.min(ans, l[n]);
      
      return ans;
    }
}

import java.util.Arrays;

class Solution {

    int[][] cache;

    private void initilize(int m, int n) {
        cache = new int[m][n];
        for (int j = 0; j < m; j++)
          cache[j][0] = 1;

        for (int i = 0; i < n; i++)
          cache[0][i] = 1;
    }

    public int uniquePaths(int m, int n) {
        if (n < 1 || m < 1) return 0;
        
        
        initilize(m, n);
        
        return uniquePathsRecursive(m, n);
        
        
    }
    
    public int uniquePathsRecursive(int m, int n) {
        if (cache[m-1][n-1] == 0) {
          cache[m-1][n-1] = uniquePathsRecursive(m-1, n) + uniquePathsRecursive(m, n-1);
        }        
        return cache[m-1][n-1];
    }

}

public class ClimbingStairs {
    int[] cache = new int[100];

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        if (cache[n] == 0) {
            cache[n] = climbStairs(n - 1) + climbStairs(n - 2);
        }

        return cache[n];

    }
}


```

# Date: 08.21.2021

### Q: 845. Longest Mountain in Array
### Q: 790. Domino and Tromino Tiling
### Q: 801. Minimum Swaps To Make Sequences Increasing

### URL: https://leetcode.com/problems/longest-mountain-in-array/
### URL: https://leetcode.com/problems/domino-and-tromino-tiling/
### URL: https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/

### 涉及算法/数据结构: DP

### Solution
```java
class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[] A = Arrays.copyOf(arr, n);

        // inr[i]: from 0 to i, the length of the longest increasing subarray
        int[] inc = new int[n];
        int[] dec = new int[n];

        for (int i = 1; i < n; i++)
            // A = [1,2,5,3,4,7]
            if (A[i] > A[i - 1])
                inc[i] = inc[i - 1] + 1;
        // inc[0, 1, 2, 0, 1, 2]

        for (int i = n - 2; i >= 0; i--)
            if (A[i] > A[i + 1])
                dec[i] = dec[i + 1] + 1;

        int ans = 0;

        for (int i = 0; i < n; i++)
            if (inc[i] != 0 && dec[i] != 0)
                ans = Math.max(ans, inc[i] + dec[i] + 1);

        return ans;

    }
}

class Solution {
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


class Solution {
    
    // dp[i][0] stores the ans that nums1[i] and nums2[i] isn't swapped
    // dp[i][1] stores the ans that nums1[i] and nums2[i] is swapped
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


```

### HomeWork:
```
DP还有习题你可以做一下不过下节课不讲DP了，自己做一下
https://leetcode.com/problems/house-robber/
https://leetcode.com/problems/min-cost-climbing-stairs/
https://leetcode.com/problems/word-break/
https://leetcode.com/problems/race-car/
https://leetcode.com/problems/edit-distance/
```

# Date: 08.28.2021
### 请假

# Date: 09.04.2021

### Q: 301. Remove Invalid Parentheses

### URL: https://leetcode.com/problems/remove-invalid-parentheses/

### 涉及算法/数据结构: DFS

### Solution:
```java
import java.util.*;

public class RemoveInvalidParentheses {
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

            if (s.charAt(i) == '(') {
                String curr = s;
                curr = curr.substring(0, i) + curr.substring(i + 1, s.length());
                if (l > 0)
                    dfs(curr, i, l - 1, r, ans);

            }

            if (s.charAt(i) == ')') {
                String curr = s;
                curr = curr.substring(0, i) + curr.substring(i + 1, s.length());
                if (r > 0)
                    dfs(curr, i, l, r - 1, ans);
            }

        }

    }
}

```

# Date: 09.12.2021
### 休假

# Date: 09.19.2021
## Q: LeetCode 547. Number of Provinces
### URL: https://leetcode.com/problems/number-of-provinces/
### 涉及算法/数据结构: DFS
### Solution: 

```java
import java.util.*;

public class EvaluationDivisionDFS {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> mp = new HashMap<>();
        double[] res = new double[queries.size()];

        // Create the Map
        for (int i = 0; i < values.length; i++) {
            mp.putIfAbsent(equations.get(i).get(0), new HashMap<>());
            mp.putIfAbsent(equations.get(i).get(1), new HashMap<>());

            mp.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
            mp.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1 / values[i]);
        }

        // DFS Search
        for (int i = 0; i < res.length; i++) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1, mp, new HashSet<>());
        }

        // return the result
        return res;
    }

    public double dfs(String s, String e, double r, HashMap<String, HashMap<String, Double>> mp, Set<String> seen) {
        if (!mp.containsKey(s) || !seen.add(s))
            return -1;

        if (s.equals(e))
            return r;

        for (String next : mp.get(s).keySet()) {
            double result = dfs(next, e, r * mp.get(s).get(next), mp, seen);
            if (result != -1)
                return result;
        }

        return -1;
    }
}

```

### Q: LeetCode: 282. Expression Add Operators

### URL: https://leetcode.com/problems/expression-add-operators/

### 涉及算法/数据结构: DFS

### Solution:
```java
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

```

# Date: 09.25.2021

## Q: LeetCode 547. Number of Provinces

### URL: https://leetcode.com/problems/number-of-provinces/

### 涉及算法/数据结构: Union-Find Data Structure

### Solution: 
```java
import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {
    private int[] parents; // parents.get("A") => "B", parents[1] = 3
    private int[] ranks; // depth of that union
    private Set<Integer> provinces = new HashSet<>();

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parents = new int[n];
        ranks = new int[n];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        // isConnected = [[1,1,0],[1,1,0],[0,0,1]]
        // populate the matrix isConnected[][]
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (isConnected[i][j] == 1)
                    union(i, j);

        for (int i = 0; i < n; i++) {
            provinces.add(find(i));
        }

        return provinces.size();
    }

    public boolean union(int u, int v) {
        int root_u = find(u);
        int root_v = find(v);

        if (root_u == root_v)
            return false;

        if (ranks[root_u] > ranks[root_v])
            // 把 root_v 接到 root_u 上
            parents[root_v] = root_u;
        else if (ranks[root_v] > ranks[root_u])
            // 把 root_u 接到 root_v 上
            parents[root_u] = root_v;
        else {
            parents[root_u] = root_v;
            ranks[root_v] += 1;
        }

        return true;
    }

    public int find(int id) {
        if (id != parents[id]) {
            // path compression.
            parents[id] = find(parents[id]);
        }
        return parents[id];
    }
}
```

### Q: LeetCode: 684. Redundant Connection

### URL: https://leetcode.com/problems/redundant-connection/

### 涉及算法/数据结构: Union-Find Data Structure

### Solution:
```java
public class RedunctConnection {
    private int[] parents; // parents.get("A") => "B", parents[1] = 3
    private int[] ranks; // depth of that union

    // edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
    // edges = [[1,2], [3,4]] => parents = [0,1,2,3,4]
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length * 2 + 1;
        parents = new int[n]; // [0, 0, 0, 0, 0]
        ranks = new int[n];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        } // parents = [0, 1, 2, 3, 4, ...] parents[i] == i

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1]))
                return edge.clone();
        }

        return new int[2];
    }

    public boolean union(int u, int v) {
        int root_u = find(u);
        int root_v = find(v);

        if (root_u == root_v)
            return false;

        if (ranks[root_u] > ranks[root_v])
            // 把 root_v 接到 root_u 上
            parents[root_v] = root_u;
        else if (ranks[root_v] > ranks[root_u])
            // 把 root_u 接到 root_v 上
            parents[root_u] = root_v;
        else {
            parents[root_u] = root_v;
            ranks[root_v] += 1;
        }

        return true;
    }

    public int find(int id) {
        if (id != parents[id]) {
            // path compression.
            parents[id] = find(parents[id]);
        }
        return parents[id];
    }
}

```

### Q: LeetCode: 399. Evaluate Division

### URL: https://leetcode.com/problems/evaluate-division/

### 涉及算法/数据结构: Union-Find Data Structure

### Solution:
```java
import java.util.HashMap;
import java.util.List;

public class EvaluationDivisionUnionFind {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // parents["A"] = {"B", 2.0}, meaning: A = 2.0 * B
        // parents["B"] = {"C", 3.0}, meaning: B = 3.0 * C
        HashMap<String, Pair> parents = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            double k = values[i];

            if (!parents.containsKey(a) && !parents.containsKey(b)) {
                parents.put(a, new Pair(b, k));
                parents.put(b, new Pair(b, 1.0));
            } else if (!parents.containsKey(a)) {
                parents.put(a, new Pair(b, k));
            } else if (!parents.containsKey(b)) {
                parents.put(b, new Pair(a, 1.0 / k));
            } else {
                // Pair rA = find(a, parents);
                // Pair rB = find(b, parents);
                // if (!rA.s.equals(rB.s)) {
                // rA.s = rB.s;
                // rA.d *= (rB.d * k);
                // }
                Pair rA = find(a, parents);
                Pair rB = find(b, parents);
                parents.put(rA.s, new Pair(rB.s, k / rA.d * rB.d));
            }
        }

        double[] ans = new double[queries.size()];
        int i = 0;
        for (List<String> query : queries) {
            String x = query.get(0);
            String y = query.get(1);

            if (!parents.containsKey(x) || !parents.containsKey(y)) {
                ans[i] = -1.0;
                i++;
                continue;
            }

            Pair rX = find(x, parents);
            Pair rY = find(y, parents);

            if (!rX.s.equals(rY.s))
                ans[i] = -1.0;
            else
                ans[i] = (rX.d / rY.d);

            i++;
        }
        return ans;
    }

    public Pair find(String s, HashMap<String, Pair> parents) {
        if (!s.equals(parents.get(s).s)) {
            Pair p = find(parents.get(s).s, parents);
            parents.get(s).s = p.s;
            parents.get(s).d *= p.d;
        }
        // return p; wrong;
        return parents.get(s);
    }
}

class Pair {
    public String s;
    public double d;

    public Pair(String s, double d) {
        this.s = s;
        this.d = d;
    }
}
```

# Date: 10.02.2021

## 请假

# Date: 10.09.2021

## 请假

# Date: 10.16.2021

## Q: Leetcode 146: LRU Cache (Least Recently Used (LRU) cache.)

### URL: https://leetcode.com/problems/lru-cache/

### 涉及算法/数据结构: HashMap, LinkedList

### Solution:

```java
import java.util.Hashtable;

public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node) {

        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail.
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {

        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; // should raise exception here.
        }

        // move the accessed node to the head;
        this.moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {

            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if (count > capacity) {
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }
    }

}
```

# Date: 10.24.2021

### Q: Leetcode 1206. Design Skiplist

### URL: https://leetcode.com/problems/design-skiplist/

### 涉及算法/数据结构: SkipList, Complexity Analysis

### Solution:

```java
import java.util.LinkedList;
import java.util.Random;
// Invariant: 
//   If a node value exists on current level, it must exists on next level;
public class Skiplist {

    class Node {
        int val;
        Node right;
        Node down;

        public Node() {
            this.val = -1;
            this.right = null;
            this.down = null;
        }

        public Node(int val, Node right, Node down) {
            this.val = val;
            this.right = right;
            this.down = down;
        }
    }


    private Node head;
    Random rd = new Random();

    public Skiplist() {
        // Dummy Head;
        this.head = new Node();
    }

    public boolean search(int target) {
        Node node = this.head;

        while (node != null) {
            // Move to the right in the current level
            while (node.right != null && node.right.val < target)
                node = node.right;
            
            
            if (node.right != null && node.right.val == target)
                return true;
            
            // Move to the next level
            node = node.down;
        }

        return false;
    }

    public boolean erase(int num) {
        Node node = this.head;
        boolean found = false;

        while (node != null) {
            // Move to the right in the current level
            while (node.right != null && node.right.val < num)
                node = node.right;
            
            // Find the target node
            if (node.right != null && node.right.val == num) {
                // Delete by skipping
                node.right = node.right.right;
                found = true;
            }

            // Move to the next level
            node = node.down;
        }

        return found;
    }

    public void add(int num) {
        LinkedList<Node> nodes = new LinkedList<Node>();
        Node node = this.head;

        while (node != null) {
            // Move to the right in the current level
            while (node.right != null && node.right.val < num)
                node = node.right;
            
            nodes.add(node);
            // Move to the next level
            node = node.down;
        }

        boolean insert = true;
        Node down = null;

        // Bottom up
        while (insert && nodes.size() > 0) {
            node = nodes.removeLast();
            node.right = new Node(num, node.right, down);
            down = node.right;
            insert = rd.nextBoolean(); // prob 1/2 = false and prob 1/2 = true;
        }

        // Create a new level with a dummy head;
        // right = null
        // down = current head
        if (insert)
            this.head = new Node(-1, null, this.head);

    }
}

```

# Date: 10.31.2021

### Q: CCC '21 S3 - Lunch Concert

### URL: https://dmoj.ca/problem/ccc21s3

### 涉及算法/数据结构: Math Analysis (Convex Function Property) & Binary Search

### Solution: 

```java
import java.util.*;
import java.io.*;

public class CCC21S3 {
  // static class AudienceInfoComparator implements Comparator<AudienceInfo> {
  //   @Override
  //   public int compare(AudienceInfo audience1, AudienceInfo audience2) {
  //     return audience1.p - audience2.p;
  //   }
  // }

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  // static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    int audience = readInt();
    // long[] sums = new long[audience];
    Map<Integer, Long> sums = new HashMap<>();
    Set<Integer> candidatesX = new HashSet<Integer>();
    ArrayList<AudienceInfo> audiences = new ArrayList<AudienceInfo>();
    for (int i = 0; i < audience; i++) {
      int p = readInt();
      int w = readInt();
      int d = readInt();
      AudienceInfo audienceInfo = new AudienceInfo(p, w, d);
      audiences.add(audienceInfo);
      candidatesX.add(p - d);
      candidatesX.add(p + d);
    }
    // Collections.sort(audiences, new AudienceInfoComparator());

    int[] candPos = new int[candidatesX.size()];
    Iterator<Integer> it = candidatesX.iterator();
    int i = 0;
    while (it.hasNext()) {
      candPos[i] = it.next();
      i++;
    }
    Arrays.sort(candPos);

    // passed
    // for (int i = 0; i < audience; i++) {
    // System.out.println(audiences.get(i).p);
    // }

    // Binary Search
    System.out.println(binarySearch(sums, audiences, candPos, 0, candPos.length - 1));

  }

  static int timeOneAudience(int x, int p, int d, int w) {
    if (x < p - d)
      return w * (p - d - x);
    else if (x > p + d)
      return w * (x - p - d);
    else
      return 0;
  }

  static long timeAllAudience(int x, ArrayList<AudienceInfo> audiences) {
    int n = audiences.size();
    long sum = 0;
    for (int i = 0; i < n; i++) {
      sum += timeOneAudience(x, audiences.get(i).p, audiences.get(i).d, audiences.get(i).w);
    }
    return sum;
  }

  static long binarySearch(Map<Integer, Long> sums, ArrayList<AudienceInfo> audiences, int[] candPos, int l, int r) {
    if (r >= l) {
      int midIdx = l + (r - l) / 2;

      if (!sums.containsKey(candPos[midIdx]))
        sums.put(candPos[midIdx], timeAllAudience(candPos[midIdx], audiences));
      if (midIdx - 1 >= 0 && !sums.containsKey(candPos[midIdx - 1]))
        sums.put(candPos[midIdx - 1], timeAllAudience(candPos[midIdx - 1], audiences));
      if (midIdx + 1 <= candPos.length - 1 && !sums.containsKey(candPos[midIdx + 1]))
        sums.put(candPos[midIdx + 1], timeAllAudience(candPos[midIdx + 1], audiences));

      if (midIdx == 0)
        // return sums.get(candPos[midIdx]) <= sums.get(candPos[r]) ? sums.get(candPos[midIdx]) : sums.get(candPos[r]);
        return sums.get(candPos[midIdx]);
      if (midIdx == candPos.length - 1)
        return sums.get(candPos[midIdx]);
      
      if (r == l)
        return sums.get(candPos[r]);

      // if find two adjacent point equals to each other, you find the optimal index.
      if ((midIdx - 1 >= 0 && sums.get(candPos[midIdx - 1]) == sums.get(candPos[midIdx]))
          || (midIdx + 1 <= candPos.length - 1 && sums.get(candPos[midIdx + 1]) == sums.get(candPos[midIdx])))
        return sums.get(candPos[midIdx]);

        
      if (sums.get(candPos[midIdx]) < sums.get(candPos[midIdx - 1])
          && sums.get(candPos[midIdx]) < sums.get(candPos[midIdx + 1]))
        return sums.get(candPos[midIdx]);

      if (sums.get(candPos[midIdx - 1]) < sums.get(candPos[midIdx])
          && sums.get(candPos[midIdx]) < sums.get(candPos[midIdx + 1]))
        r = midIdx;
      if (sums.get(candPos[midIdx - 1]) > sums.get(candPos[midIdx])
          && sums.get(candPos[midIdx]) > sums.get(candPos[midIdx + 1]))
        l = midIdx;
      return binarySearch(sums, audiences, candPos, l, r);
    }

    // We reach here when element is not
    // present in array
    return -1;
  }

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
}


class AudienceInfo {
  public int p;
  public int w;
  public int d;

  AudienceInfo(int p, int w, int d) {
    this.p = p;
    this.w = w;
    this.d = d;
  }
}
```


# Data: 11.07.2021

### 请假

# Data: 11.14.2021

### 请假

# Date: 11.21.2021

### Q: CCC '20 S3 - Searching for Strings

### URL: https://dmoj.ca/src/4051168

### 涉及算法/数据结构: HashMap, Math Analysis

### Solution: 

```java
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

        collection.add(chars.toString().substring(1, 3 * chars.size() - 1).replaceAll(", ", ""));

        Map<Character, Integer> subCount = getCount(chars.toString().substring(1, 3 * chars.size() - 1).replaceAll(", ", ""));
        // compare NCount with subCount
        if (compareCount(NCount, subCount)) {
            num += 1;
        }

        for (int i = 1; i <= s.length() - n; i++) {
            // copy s to a new_s, getsubstring from new_s
            // String sub = s.substring(i, i+n);

            chars.removeFirst();
            chars.add(s.charAt(i + n - 1));

            String sub = chars.toString().substring(1, 3 * chars.size() - 1).replaceAll(", ", "");

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
```

# Date: 11.28.2021

### Q: CCC '20 S4 - Swapping Seats

### URL: https://dmoj.ca/problem/ccc20s4

### 涉及算法/数据结构：Math Analysis, Prefix Array

### Soluton:

```java
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
```

## Date： 12.05.2012

### 请假


# Date: 12.12.2021

### Q: Shortest Path Visiting All Nodes

### URL: https://leetcode.com/problems/shortest-path-visiting-all-nodes/

### 涉及算法/数据结构: BFS, 位运算， 状态表达

### Solution: 

```Java
class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int finalState = (1 << n) - 1; // if n = 4; 1 << 4 => 10000; 10000 - 1? = 1111
        LinkedList<int[]> q = new LinkedList<>();
        // int[0][1101]: 0: current_node, 1101: visited+nodes
        // node 0 jump to node 1
        // visited[1][1111] = 1 ? why? 1101 | 0010 = 1111
        int[][] visited = new int[n][1 << n]; // 1 << 1 => 10; 1 << 2 => 100; 1 << n => 100000...0;
        for (int i = 0; i < n; i++) {
            q.add(new int[] { i, 1 << i }); // <{0, 0001}, {1, 0010}, {2, 0100}, {3, 1000}>
        }
        int steps = 0;
        while (q.size() != 0) {
            int s = q.size(); // get all the nodes from the same level;
            while (s != 0) {
                s--;
                int[] p = q.removeFirst();
                int node = p[0];
                int state = p[1];
                if (state == finalState)
                    return steps;
                if (visited[node][state] == 1)
                    continue;
                visited[node][state] = 1;
                for (int next : graph[node])
                    q.add(new int[] { next, state | (1 << next) });
                
            }
            steps++;
        }
        return -1;
    }
}
```



# Date: 12.19.2021

### Q: Number of Restricted Paths From First To Last Node

### URL: https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node/

### 涉及算法/数据结构: Dijkstra algorithm, DFS

### Solution:

```Java
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Solution {
    int mod = 1000000007;

    class Edge implements Comparable<Edge> {
        int v;
        int wt;

        Edge(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge o) {
            return this.wt - ((Edge) o).wt;
        }

    }

    public int countRestrictedPaths(int n, int[][] edges) {
        ArrayList<Edge>[] graph = new ArrayList[n];

        // create arraylist for each i
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0] - 1; // map number to index.
            int v2 = edges[i][1] - 1; // map number to index.
            int wt = edges[i][2];
            graph[v1].add(new Edge(v2, wt));
            graph[v2].add(new Edge(v1, wt));
        }

        int shortestPath[] = new int[n];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        pq.add(new Edge((n - 1), 0));

        while (pq.size() > 0) {
            Edge re = pq.remove();
            if (visited[re.v])
                continue;
            visited[re.v] = true;
            shortestPath[re.v] = re.wt;
            for (Edge e : graph[re.v])
                if (visited[e.v] == false)
                    pq.add(new Edge(e.v, re.wt + e.wt));
        }

        int[] memory = new int[n];
        Arrays.fill(memory, -1);
        visited = new boolean[n];
        int count = dfs(graph, 0, memory, shortestPath, visited);
        return count;
    }

    /**
     * 
     * @param graph
     * @param v starting point for this recursion
     * @param wt 
     * @param memory
     * @param shortestPath
     * @param visited
     * @return
     */
    public int dfs(ArrayList<Edge> graph[], int v, int memory[], int shortestPath[], boolean[] visited) {
        if (v == graph.length - 1) 
            return 1;

        if (memory[v] != -1) {
            return memory[v];
        }

        visited[v] = true;

        int countPath = 0;
        for (Edge e : graph[v]) {
            if (visited[e.v] == false && shortestPath[v] > shortestPath[e.v]) {
                countPath += dfs(graph, e.v, memory, shortestPath, visited);
                countPath = countPath % mod;
            }
        }

        visited[v] = false;
        memory[v] = countPath;
        return countPath;
    }
}

```
