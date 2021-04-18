import java.io.*;
import java.util.*;

public class Gates {
    public static int[] root;


    public static int find(int x) {
        if (x != root[x]) 
            root[x] = find(root[x]);
        return root[x];
    }
    
    public static void merge(int x, int y) {
        root[find(x)] = find(y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numGates = Integer.parseInt(br.readLine());
        int numPlanes = Integer.parseInt(br.readLine());
        root = new int[numGates + 1];
        for (int i = 1; i <= numGates; i++)
            root[i] = i;

        int i = 0;
        boolean keepgoing = true;

        while (i < numPlanes && keepgoing) {
            int gateWanted = Integer.parseInt(br.readLine());
            int gateWantedRoot = find(gateWanted);
            if (gateWantedRoot == 0) {
                System.out.println(i);
                keepgoing = false;
                break;
            }
            merge(gateWantedRoot,gateWantedRoot-1);
            i += 1;
        }
    
        if (keepgoing)
            System.out.println(numPlanes);
    }
}