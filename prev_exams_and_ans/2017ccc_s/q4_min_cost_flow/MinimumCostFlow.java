// Kruskal's Algorithm for solving the MST(Minimum Spanning Tree) problem
// https://en.wikipedia.org/wiki/Kruskal%27s_algorithm
import java.util.*;
import java.io.*;

public class MinimumCostFlow {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] root;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int m = readInt();
        int d = readInt();
        Edge[] edges = new Edge[m];
        root = new int[n+1];
        rank = new int[n+1];
        for (int i = 0; i < m; i++) {
            if (i < n - 1)
                edges[i] = new Edge(readInt(), readInt(), readInt(), 0);
            else 
                edges[i] = new Edge(readInt(), readInt(), readInt(), 1);
        }

        Arrays.sort(edges);
        // init root[]
        for (int i = 1; i < root.length; i++)
            root[i] = i;

        int cnt = 0, mst = 0, days = 0, i = 0;
        for (; i < m; i++) {
            if (cnt == n - 1)
                break;
            if (union(edges[i].u, edges[i].v)) {
                cnt++;
                mst = edges[i].w;
                days += edges[i].o;
            }
        }

        if (edges[i-1].o == 1) {
            // init root[]
            for (int j = 1; j < root.length; j++)
                root[j] = j;
            for (Edge e: edges)
                if (find(e.u) != find(e.v))
                    if (e.w < mst || (e.w == mst && e.o == 0))
                        union(e.u, e.v);
                    else if (e.o == 0 && e.w <= d) {
                        System.out.println(days - 1);
                        return;
                    }
        }

        System.out.println(days);
    }

    static int find(int d) {
        if(d != root[d])
            root[d] = find(root[d]);
        return root[d];
    }

    static boolean union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if(xRoot == yRoot) return false;

        if(rank[xRoot] < rank[yRoot]) root[xRoot] = yRoot;
        else if (rank[yRoot] < rank[xRoot]) root[yRoot] = xRoot;
        else {
            root[yRoot] = xRoot;
            rank[xRoot]++;
        }

        return true;
  	}

    static class Edge implements Comparable<Edge> {
        public int u, v, w, o;
        public Edge(int u, int v, int w, int o) {
            this.u = u;
            this.v = v;
            this.w = w;
            this.o = o;
        }
        public int compareTo(Edge that) {
            if (this.w != that.w) 
                return this.w - that.w;
            return this.o - that.o;
        }
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

    static Double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
