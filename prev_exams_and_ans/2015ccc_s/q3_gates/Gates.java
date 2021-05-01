import java.io.*;

public class Gates {
    public static int[] root;


    /**
     * @param x
     * @return return the root of x
     */
    public static int find(int x) {
        // path compression
        if (x != root[x])
            root[x] = find(root[x]);
        return root[x];
    }
    
    /**
     * union root of x to root of y, after union, root[find(x)] = root[root[x]] <- root[y]
     * root[find(x)] return the largest number i [less than x] such that root[i] = i
     * i.e.  root[x] attached to root[y]. thus y should be less than x.
     * @param x
     * @param y
     */
    public static void union(int x, int y) {
        root[find(x)] = find(y); // root[6] = 5; 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read in number of Gates
        int numGates = Integer.parseInt(br.readLine());

        // Read in number of Planes
        int numPlanes = Integer.parseInt(br.readLine());

        // initialize root array
        root = new int[numGates + 1];

        // set root[i] = i first, i.e. root[x] == x at the very begining
        for (int i = 1; i <= numGates; i++)
            root[i] = i;

        // i: how many planes parked now.
        int i = 0;

        // keep going flag.
        boolean keepgoing = true;

        while (i < numPlanes && keepgoing) {
            int gate = Integer.parseInt(br.readLine());

            // gateWant: the largest gate number that could be parked.
            // firstly, 6 park at gate 6
            // then 6 park at gate 5
            // ....
            int gateWanted = find(gate);
            if (gateWanted == 0) {
                System.out.println(i);
                keepgoing = false;
                break;
            }
            union(gateWanted,gateWanted-1);
            i += 1;
        }
    
        if (keepgoing)
            System.out.println(numPlanes);
    }
}