import java.io.*;
import java.util.*;

public class BloodDistribution {

    private static boolean[] marked; // true if s->v path in residual network
    private static FlowEdge[] edgeTo; // last edge on s->v path
    private static int value; // value of flow
    public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        FlowNetwork G = new FlowNetwork(18); // 16 vertices + 2 artificial vertices

        HashMap<String, Integer> bpToIdx = new HashMap<>(); // bloods + patients => idx
        bpToIdx.put("ONB", 1);
        bpToIdx.put("OPB", 2);
        bpToIdx.put("ANB", 3);
        bpToIdx.put("APB", 4);
        bpToIdx.put("BNB", 5);
        bpToIdx.put("BPB", 6);
        bpToIdx.put("ABNB",7);
        bpToIdx.put("ABPB",8);
        bpToIdx.put("ONP", 9);
        bpToIdx.put("OPP", 10);
        bpToIdx.put("ANP", 11);
        bpToIdx.put("APP", 12);
        bpToIdx.put("BNP", 13);
        bpToIdx.put("BPP", 14);
        bpToIdx.put("ABNP",15);
        bpToIdx.put("ABPP",16);

        // construct the flow network
        String[] bloodCap = br.readLine().split(" ");
        for (int i = 1; i <= 8; i++) {
            FlowEdge e = new FlowEdge(0, i, Integer.parseInt(bloodCap[i-1]));
            G.addEdge(e);
        }

        // connect blood row to patients row
        // ABP receives any blood
        FlowEdge e = new FlowEdge(1, bpToIdx.get("ABPP"), Integer.parseInt(bloodCap[0]));
                 G.addEdge(e);
                 e = new FlowEdge(2, bpToIdx.get("ABPP"), Integer.parseInt(bloodCap[1]));
                 G.addEdge(e);
                 e = new FlowEdge(3, bpToIdx.get("ABPP"), Integer.parseInt(bloodCap[2]));
                 G.addEdge(e);
                 e = new FlowEdge(4, bpToIdx.get("ABPP"), Integer.parseInt(bloodCap[3]));
                 G.addEdge(e);
                 e = new FlowEdge(5, bpToIdx.get("ABPP"), Integer.parseInt(bloodCap[4]));
                 G.addEdge(e);
                 e = new FlowEdge(6, bpToIdx.get("ABPP"), Integer.parseInt(bloodCap[5]));
                 G.addEdge(e);
                 e = new FlowEdge(7, bpToIdx.get("ABPP"), Integer.parseInt(bloodCap[6]));
                 G.addEdge(e);
                 e = new FlowEdge(8, bpToIdx.get("ABPP"), Integer.parseInt(bloodCap[7]));
                 G.addEdge(e);

        // ABN receives ON AN BN ABN 
        e = new FlowEdge(bpToIdx.get("ONB"), bpToIdx.get("ABNP"), Integer.parseInt(bloodCap[bpToIdx.get("ONB")-1]));
        G.addEdge(e);
        e = new FlowEdge(bpToIdx.get("ANB"), bpToIdx.get("ABNP"), Integer.parseInt(bloodCap[bpToIdx.get("ANB")-1]));
        G.addEdge(e);
        e = new FlowEdge(bpToIdx.get("BNB"), bpToIdx.get("ABNP"), Integer.parseInt(bloodCap[bpToIdx.get("BNB")-1]));
        G.addEdge(e);
        e = new FlowEdge(bpToIdx.get("ABNB"), bpToIdx.get("ABNP"), Integer.parseInt(bloodCap[bpToIdx.get("ABNB")-1]));
        G.addEdge(e);

        // BP receives ON OP BN BP 
        e = new FlowEdge(bpToIdx.get("ONB"), bpToIdx.get("BPP"), Integer.parseInt(bloodCap[bpToIdx.get("ONB")-1]));
        G.addEdge(e);
        e = new FlowEdge(bpToIdx.get("OPB"), bpToIdx.get("BPP"), Integer.parseInt(bloodCap[bpToIdx.get("OPB")-1]));
        G.addEdge(e);
        e = new FlowEdge(bpToIdx.get("BNB"), bpToIdx.get("BPP"), Integer.parseInt(bloodCap[bpToIdx.get("BNB")-1]));
        G.addEdge(e);
        e = new FlowEdge(bpToIdx.get("BPB"), bpToIdx.get("BPP"), Integer.parseInt(bloodCap[bpToIdx.get("BPB")-1]));
        G.addEdge(e);

        // BN receives ON BN
        e = new FlowEdge(bpToIdx.get("ONB"), bpToIdx.get("BNP"), Integer.parseInt(bloodCap[bpToIdx.get("ONB")-1]));
        G.addEdge(e);
        e = new FlowEdge(bpToIdx.get("BNB"), bpToIdx.get("BNP"), Integer.parseInt(bloodCap[bpToIdx.get("BNB")-1]));
        G.addEdge(e);

        // AP receives ON OP AN AP
        e = new FlowEdge(bpToIdx.get("ONB"), bpToIdx.get("APP"), Integer.parseInt(bloodCap[bpToIdx.get("ONB")-1]));
        G.addEdge(e);
        e = new FlowEdge(bpToIdx.get("OPB"), bpToIdx.get("APP"), Integer.parseInt(bloodCap[bpToIdx.get("OPB")-1]));
        G.addEdge(e);
        e = new FlowEdge(bpToIdx.get("ANB"), bpToIdx.get("APP"), Integer.parseInt(bloodCap[bpToIdx.get("ANB")-1]));
        G.addEdge(e);
        e = new FlowEdge(bpToIdx.get("APB"), bpToIdx.get("APP"), Integer.parseInt(bloodCap[bpToIdx.get("APB")-1]));
        G.addEdge(e);

        // AN receives ON AN
        e = new FlowEdge(bpToIdx.get("ONB"), bpToIdx.get("ANP"), Integer.parseInt(bloodCap[bpToIdx.get("ONB")-1]));
        G.addEdge(e);
        e = new FlowEdge(bpToIdx.get("ANB"), bpToIdx.get("ANP"), Integer.parseInt(bloodCap[bpToIdx.get("ANB")-1]));
        G.addEdge(e);

        // OP receives ON OP
        e = new FlowEdge(bpToIdx.get("ONB"), bpToIdx.get("OPP"), Integer.parseInt(bloodCap[bpToIdx.get("ONB")-1]));
        G.addEdge(e);
        e = new FlowEdge(bpToIdx.get("OPB"), bpToIdx.get("OPP"), Integer.parseInt(bloodCap[bpToIdx.get("OPB")-1]));
        G.addEdge(e);

        // ON receives ON
        e = new FlowEdge(bpToIdx.get("ONB"), bpToIdx.get("ONP"), Integer.parseInt(bloodCap[bpToIdx.get("ONB")-1]));
        G.addEdge(e);

        String[] patientsCap = br.readLine().split(" ");
        for (int i = 9; i <= 16; i++) {
            e = new FlowEdge(i, 17, Integer.parseInt(patientsCap[i-9]));
            G.addEdge(e);
        }
        
        fordFulkerson(G, 0, 17);
        System.out.println(value);

    }

    private static void fordFulkerson(FlowNetwork G, int s, int t) {
        value = 0;
        while (hasAugmentedPath(G, s, t)) {
            // System.out.println("HAS");
            int bottle = Integer.MAX_VALUE;   // bottle: bottleneck

            // compute bottleneck capacity
            for (int v = t; v != s; v = edgeTo[v].other(v))
                bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));

            // augment flow
            for (int v = t; v != s; v = edgeTo[v].other(v)) 
                edgeTo[v].addResidualFlowTo(v, bottle); 
            
            value += bottle;
        }
    }

    private static boolean hasAugmentedPath(FlowNetwork G, int s, int t) {
        edgeTo = new FlowEdge[G.V()];
        marked = new boolean[G.V()];

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        marked[s] = true;
        while (!q.isEmpty()) {
            int v = q.remove();
            
            // bfs
            for (FlowEdge e: G.adj(v)) {
                int w = e.other(v);

                // found path from s to w in the residual network?
                if (e.residualCapacityTo(w) > 0 && !marked[w]) {
                    // 3 things: save last edge on path to w; mark w; add w to the queue
                    edgeTo[w] = e;
                    marked[w] = true;
                    q.add(w);

                    if (w == t) return true;
                }

            }
        }

        // for (int i = 0; i < marked.length; i++) {
        //     System.out.print(marked[i] + ", ");
        // }

        return marked[t]; // is t reachable from this augmentation?
    }
}


class FlowEdge {
    private final int v, w;
    private final int capacity;
    private int flow; // flow

    public FlowEdge(int v, int w, int capacity) {
        this.v = v;
        this.w = w;
        this.capacity = capacity;
    }

    // public int either() {
    //     return v;
    // }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public int other(int vertex) {
        if (vertex == v) return w;
        else return v;
    }

    public int capacity() {
        return capacity;
    }

    public int flow() {
        return flow;
    }

    public int residualCapacityTo(int vertex) {
        if (vertex == v) return flow;
        // else if (vertex == w) return capacity - flow;
        else return capacity - flow;
    }

    public void addResidualFlowTo(int vertex, int delta) {
        if (vertex == v) flow -= delta;
        else flow += delta;
    }

    // public int compareTo(FlowEdge that) {
    //     if (this.weight < that.weight) return -1;
    //     else if (this.weight > that.weight) return 1;
    //     else return 0;
    // }
}

class FlowNetwork {
    private final int V;
    private final LinkedList<FlowEdge>[] adj;

    public FlowNetwork(int V) {
        this.V = V;
        adj = (LinkedList<FlowEdge>[]) new LinkedList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new LinkedList<FlowEdge>();
    }

    public int V() {
        return V;
    }

    public void addEdge(FlowEdge e) {
        int v = e.from(), w = e.to();
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<FlowEdge> adj(int v) {
        return adj[v];
    }
}