
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PhonomenalReviews {
    private static int dis[], n, p, longestDist, rt, cnt = 0;
    private static boolean pho[];
    private static ArrayList<ArrayList<Integer>> g  = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<ArrayList<Integer>> g2 = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); 
        p = sc.nextInt(); 
        dis = new int[n]; 
        pho = new boolean[n];

        for(int i = 0; i <= n;i ++) {
            g.add(new ArrayList<Integer>()); 
            g2.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < p; i++) {
            rt = sc.nextInt(); 
            pho[rt] = true;
        }
        
        // add path between restaurant
        for(int i = 1; i < n; i++) {
            int x = sc.nextInt(); 
            int y = sc.nextInt();
            g.get(x).add(y); 
            g.get(y).add(x);
        }
        
        tree_prunning_dfs(rt, -1);
        Arrays.fill(dis, 0); 
        longestDist = 0;
		dfs_prunned(rt, -1);
        System.out.println(2 * cnt - longestDist);
        sc.close();

    }
    
    private static void tree_prunning_dfs(int curr, int prev) {

        if(prev != -1) 
            dis[curr] = dis[prev] + 1;
        
        // l: longest dist
		if(dis[curr] > longestDist && pho[curr]) {
            longestDist = dis[curr];
            rt = curr;
        }
        
        for (int next : g.get(curr)) {
            if(next == prev) 
                continue;
            tree_prunning_dfs(next, curr);
            
            if(!g2.get(next).isEmpty() || pho[next]) {
                g2.get(curr).add(next); 
                g2.get(next).add(curr); 
                cnt++;
            }
		}
    }
    
    static void dfs_prunned(int curr, int prev) {
        if (prev != -1) {
            dis[curr] = dis[prev] + 1; 
            longestDist = Math.max(longestDist, dis[curr]);
        }
        
        for(int next : g2.get(curr)) {
			if(next == prev) continue;
			dfs_prunned(next, curr);
		}
	}

}