import java.util.LinkedList;

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