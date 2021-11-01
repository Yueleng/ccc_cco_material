package union_find_forest;

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
