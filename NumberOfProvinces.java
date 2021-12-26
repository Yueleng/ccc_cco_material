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
