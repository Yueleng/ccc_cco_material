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
