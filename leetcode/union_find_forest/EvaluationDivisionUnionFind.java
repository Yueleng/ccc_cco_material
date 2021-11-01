/**
 * 399. Evaluate Division
 */

package union_find_forest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class EvaluationDivisionUnionFind {
    public static void main(String[] args) {
        List<List<String>> equations = new LinkedList<>();
        equations.add(new LinkedList<>());
        equations.get(0).add("a");
        equations.get(0).add("b");

        equations.add(new LinkedList<>());
        equations.get(1).add("b");
        equations.get(1).add("c");

        equations.add(new LinkedList<>());
        equations.get(2).add("d");
        equations.get(2).add("e");

        equations.add(new LinkedList<>());
        equations.get(3).add("a");
        equations.get(3).add("d");

        double[] values = new double[] { 1.0, 2.0, 3.0, 4.0 };

        List<List<String>> queries = new LinkedList<>();
        queries.add(new LinkedList<>());
        queries.get(0).add("c");
        queries.get(0).add("e");

        System.out.print(calcEquation(equations, values, queries)[0]);
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
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
                // if (!rA.s.equals(rB.s) || Math.abs(rA.d - rB.d) > 0.0001) {
                //     rA.s = rB.s;
                //     rA.d *= (rB.d * k);
                // }
                Pair rA = find(a, parents);
                Pair rB = find(b, parents);
                parents.put(rA.s, new Pair(rB.s, (1 / rA.d) * k * rB.d));
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

    public static Pair find(String s, HashMap<String, Pair> parents) {
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