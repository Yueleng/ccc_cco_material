import java.util.*;
import java.io.*;

public class AnimalFarmLazyPrim {
    public static boolean[] marked;   // MST vertices
    public static Queue<Edge> mst;
    public static PriorityQueue<Edge> pq;
    public static int[] distTo;
    public static void main(String[] args) throws IOException {
        

        HashMap<String, LinkedList<Integer>> boundsPensTable = new HashMap<>();
        // create the bounds 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        for (int v = 0; v < V; v++) {
            String[] info = br.readLine().split(" ");
            int numBound = Integer.parseInt(info[0]);
            for (int i = 1; i <= numBound; i++) {
                String boundName;
                if (i < numBound) {
                    boundName = Integer.parseInt(info[i]) < Integer.parseInt(info[i+1]) ? info[i] + "<->" + info[i+1] : info[i+1] + "<->" + info[i];  // 1<->2;    
                } else {
                    // i = numBound
                    boundName = Integer.parseInt(info[numBound]) < Integer.parseInt(info[1]) ? info[numBound] + "<->" + info[1] : info[1] + "<->" + info[numBound];  // 1<->2;
                }

                int boundValue = Integer.parseInt(info[i+numBound]); // boundValue = 7
                if (!boundsPensTable.containsKey(boundName)) {
                    // this bound appears the first time
                    LinkedList<Integer> boundInfo = new LinkedList<>();
                    boundInfo.add(boundValue); boundInfo.add(v); // add weight, and pen index 
                    boundsPensTable.put(boundName, boundInfo);
                } else {
                    // the bound appears before
                    LinkedList<Integer> boundInfo = boundsPensTable.get(boundName);
                    boundInfo.add(v); // add pen index
                }
            }
        }

        // for testing the representation.
        // for (String boundName: boundsPensTable.keySet()) {
        //     System.out.print(boundName + " ");
        //     boundsPensTable.get(boundName).forEach(intt -> System.out.print(intt + ","));
        //     System.out.println();
        // }

        EdgeWeightedGraph G = new EdgeWeightedGraph(V);
        // Add edges to graph
        for (String boundName: boundsPensTable.keySet()) {
            LinkedList<Integer> boundInfo = boundsPensTable.get(boundName);
            if (boundInfo.size() == 3) {
                Edge edge = new Edge(boundInfo.get(1), boundInfo.get(2), boundInfo.get(0));
                G.addEdge(edge);
            }
        }
        // Graph G was created

        // Add outside as anther VERTICE
        EdgeWeightedGraph G2 = new EdgeWeightedGraph(V+1);
        for (String boundName: boundsPensTable.keySet()) {
            LinkedList<Integer> boundInfo = boundsPensTable.get(boundName);
            if (boundInfo.size() == 3) {
                Edge edge = new Edge(boundInfo.get(1), boundInfo.get(2), boundInfo.get(0));
                G2.addEdge(edge);
            } else {
                Edge edge = new Edge(boundInfo.get(1), V, boundInfo.get(0));
                G2.addEdge(edge);
            }
        }
        // Graph G2 was created
        
        // First do bfs to get distTo[] to make sure if we have multiple sets or just one set
        distTo = new int[V];
        // dist[0] = 0; by default and correct
        for (int i = 1; i < V; i++) {
            distTo[i] = Integer.MAX_VALUE;
        }

        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(0);
        int count = bfs(G, ints, 0);
        // System.out.println("count: " + count);
        // check count to determine
        if (count == V) {
            // one set
            int totalWeight = totalWeight(G);
            int totalWeight2 = totalWeight(G2);
            System.out.println(totalWeight < totalWeight2 ? totalWeight: totalWeight2);
        } else {
            // multiple set
            System.out.println(totalWeight(G2));
        }
        
    }

    public static void visit (EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e: G.adj(v))
            if (!marked[e.other(v)]) // v should not be in the T yet
                pq.add(e);
    }

    public static int bfs(EdgeWeightedGraph G, ArrayList<Integer> vertices, int count) {
        ArrayList<Integer> nextVertices = new ArrayList<>();
        for (int v: vertices) {
            // System.out.println("v: " + v);
            count++;
            for (Edge e: G.adj(v)) {
                int w = e.other(v);
                if (distTo[w] != Integer.MAX_VALUE) continue;
                else {
                    // w not visited
                    distTo[w] = distTo[v] + e.weight();
                    nextVertices.add(w);
                }
            }
        }
        if (nextVertices.size() > 0) return bfs(G, nextVertices, count);
        else return count;
    }

    public static int totalWeight(EdgeWeightedGraph G) {
        pq = new PriorityQueue<Edge>();
        mst = new LinkedList<Edge>();
        marked = new boolean[G.V()];
        int totalWeight = 0;
        visit(G, 0);

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.poll();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.add(e);
            totalWeight += e.weight();
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
        }
        return totalWeight;
    }
}

class Edge implements Comparable<Edge> {
    private final int v, w;
    private final int weight;

    public Edge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if (vertex == v) return w;
        else return v;
    }

    public int weight() {
        return this.weight;
    }

    public int compareTo(Edge that) {
        if (this.weight < that.weight) return -1;
        else if (this.weight > that.weight) return 1;
        else return 0;
    }
}

class EdgeWeightedGraph {
    private final int V;
    private final LinkedList<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        adj = (LinkedList<Edge>[]) new LinkedList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new LinkedList<Edge>();
    }

    public int V() {
        return V;
    }

    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
}