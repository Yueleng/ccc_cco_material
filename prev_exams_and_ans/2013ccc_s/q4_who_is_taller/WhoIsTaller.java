import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
public class WhoIsTaller {
    public static int N;
    public static int M;
    public static LinkedList<Integer>[] tree;
    public static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);

        tree = (LinkedList<Integer>[]) new LinkedList[N];
        for (int i = 0; i < N; i++)
            tree[i] = new LinkedList<Integer>();

        for (int i = 0; i < M; i++) {
            info = br.readLine().split(" ");
            int p = Integer.parseInt(info[0]) - 1;
            int q = Integer.parseInt(info[1]) - 1;
            tree[p].add(q);
        }

        info = br.readLine().split(" ");
        int p = Integer.parseInt(info[0]) - 1;
        int q = Integer.parseInt(info[1]) - 1;

        visited = new boolean[N];
        visited[p] = true;
        if (taller(p, q)) {
            System.out.println("yes");
            return;
        }
        
        visited = new boolean[N];
        visited[q] = true;
        if (taller(q, p)) {
            System.out.println("no");
            return;
        }
        
        System.out.println("unknown");
    }

    public static boolean taller(int p, int q) {
        boolean[] v = new boolean[N];
        LinkedList<Integer> queue = new LinkedList<>();

        for (Integer x: tree[p]) {
            queue.add(x);
            visited[x] = true;
            if (x == q) return true;
        }

        while (queue.size() > 0) {
            int h = queue.removeFirst();
            // if (h == q)
            //     return true; // 1 means p > q
            if (!v[h]) {
                v[h] = true;
                for (Integer x: tree[h]) {
                    if (!visited[x]) {
                        queue.add(x);
                        visited[x] = true;
                        if (x == q) return true;
                    }
                }
            }
        }
        return false;
    }
}
