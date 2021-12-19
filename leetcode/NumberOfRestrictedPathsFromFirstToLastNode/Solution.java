package leetcode.NumberOfRestrictedPathsFromFirstToLastNode;

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
