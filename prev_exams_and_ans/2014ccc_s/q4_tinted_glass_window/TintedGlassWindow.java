import java.io.*;
import java.util.*;
import java.util.stream.*;

public class TintedGlassWindow {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        // LinkedList<Integer> xs = new LinkedList<>();
        // LinkedList<Integer> ys = new LinkedList<>();
        TreeSet<Integer> xs = new TreeSet<>();
        TreeSet<Integer> ys = new TreeSet<>();
        int[][] rects = new int[n][5];
        for (int i = 0; i < n; i++) {
            String[] info = br.readLine().split(" ");
            rects[i] = Stream.of(info).mapToInt(Integer::parseInt).toArray();
            xs.add(rects[i][0]);
            ys.add(rects[i][1]);
            xs.add(rects[i][2]);
            ys.add(rects[i][3]);
        }

/*                 # Original input data
        # rects= [[11, 11, 20, 15, 1],
        #         [13, 8, 14, 17, 2],
        #         [17, 8, 18, 17, 1],
        #         [12, 12, 19, 13, 1]]
        #
        # original x and y values
        # xs= [11, 20, 13, 14, 17, 18, 12, 19]
        # ys= [11, 15, 8, 17, 8, 17, 12, 13] */

        // Set<Integer> xsSet = new HashSet<>(xs);
        // Set<Integer> ysSet = new HashSet<>(ys);

        // Object[] xsUniqueObj = xsSet.toArray();
        // Object[] ysUniqueObj = ysSet.toArray();
        
        // Integer[] xsUnique = Arrays.copyOf(xsUniqueObj, xsUniqueObj.length, Integer[].class);
        // Integer[] ysUnique = Arrays.copyOf(ysUniqueObj, ysUniqueObj.length, Integer[].class);
        
        // Arrays.sort(xsUnique);
        // Arrays.sort(ysUnique);

        Integer[] xsUnique = xs.toArray(new Integer[0]);
        Integer[] ysUnique = ys.toArray(new Integer[0]);

        // # x and y values sorted with duplicates removed
        // # xsUnique= [11, 12, 13, 14, 17, 18, 19, 20]
        // # ysUnique= [8, 11, 12, 13, 15, 17]

        // int[] xPos = new int[xsUnique[xsUnique.length-1] + 1];
        // int[] yPos = new int[ysUnique[ysUnique.length-1] + 1];

        Map<Integer, Integer> xPos = new TreeMap<>();
        Map<Integer, Integer> yPos = new TreeMap<>();

        for (int i = 0; i < xsUnique.length; i++) {
            xPos.put(xsUnique[i], i);
        }

        for (int i = 0; i < ysUnique.length; i++) {
            yPos.put(ysUnique[i], i);
        }

        // for (int i = 0; i < xsUnique.length; i++)
        //     xPos[xsUnique[i]] = i;

        // for (int i = 0; i < ysUnique.length; i++)
        //     yPos[ysUnique[i]] = i;

        // # a quick way to find those coordinates
        // # xPos = [0,0,0,...,0,1,2,3,4,5,6,7], i.e. xPos[11] = 0, ..., xPos[20] = 7
        //    
        // # yPos = [0,0,0,...,0,0,1,2,3,4,5], i.e. yPos[8] = 0, ..., yPos[17] = 5

        int[][] da = new int[ysUnique.length][xsUnique.length];
        
        for (int j = 0; j < n; j++) {
            for (int i = yPos.get( rects[j][1] ); i < yPos.get( rects[j][3] ); i++) {
                da[i][xPos.get( rects[j][0] )] += rects[j][4];
                da[i][xPos.get( rects[j][2] )] -= rects[j][4];
            }
        }

        // # da= [[0, 0, 2, -2, 1, -1, 0, 0],
        // #      [1, 0, 2, -2, 1, -1, 0, -1],
        // #      [1, 1, 2, -2, 1, -1, -1, -1],
        // #      [1, 0, 2, -2, 1, -1, 0, -1],
        // #      [0, 0, 2, -2, 1, -1, 0, 0],
        // #      [0, 0, 0, 0, 0, 0, 0, 0]]

        long ans = 0;
        for (int i = 0; i < ysUnique.length-1; i++) {
            for (int j = 0; j < xsUnique.length-1; j++) {
                da[i][j+1] = da[i][j] + da[i][j+1];
		        if (da[i][j] >= t)
			        ans += (long) (ysUnique[i+1] - ysUnique[i]) * (xsUnique[j+1] - xsUnique[j]);
            }
        }

        // # da= [[0, 0, 2, 0, 1, 0, 0, 0],
        // #      [1, 1, 3, 1, 2, 1, 1, 0],
        // #      [1, 2, 4, 2, 3, 2, 1, 0],
        // #      [1, 1, 3, 1, 2, 1, 1, 0],
        // #      [0, 0, 2, 0, 1, 0, 0, 0],
        // #      [0, 0, 0, 0, 0, 0, 0, 0]]

        System.out.println(ans);
    }
}
