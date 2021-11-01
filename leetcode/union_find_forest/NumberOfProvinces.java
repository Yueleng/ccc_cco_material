/**
 * 547. Number of Provinces
 */

package union_find_forest;

import java.util.HashSet;

class NumberOfProvinces {
    private int[] parents;
    private int[] ranks;
    private HashSet<Integer> circles = new HashSet<>();

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        parents = new int[n];
        ranks = new int[n];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (isConnected[i][j] == 1)
                    Union(i, j);

        for (int i = 0; i < n; i++)
            circles.add(Find(i));

        return circles.size();
    }

    public boolean Union(int u, int v) {
        int pu = Find(u);
        int pv = Find(v);

        if (pu == pv)
            return false;

        if (ranks[pu] > ranks[pv]) {
            // 把 pv 接到 pu 上
            parents[pv] = pu;
        } else if (ranks[pu] > ranks[pv]) {
            // 把 pu 接到 pv 上
            parents[pu] = pv;
        } else {
            parents[pu] = pv;
            ranks[pv] += 1;
        }
        return true;
    }

    public int Find(int id) {
        if (id != parents[id]) {
            parents[id] = Find(parents[id]);
        }
        return parents[id];
    }
}