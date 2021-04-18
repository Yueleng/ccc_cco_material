import java.util.*;
import java.io.*;

public class MordenArt {
    public static HashSet<Integer> rowSet = new HashSet<>();
    public static HashSet<Integer> colSet = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int height = Integer.parseInt(br.readLine());
        int width = Integer.parseInt(br.readLine());
        
        int inputRowNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputRowNum; i++) {
            String[] line = br.readLine().split(" ");
            if (line[0].equals("R")) {
                int row = Integer.parseInt(line[1]);
                if (rowSet.contains(row)) rowSet.remove(row);
                else rowSet.add(row);
            } else {
                int col = Integer.parseInt(line[1]);
                if (colSet.contains(col)) colSet.remove(col);
                else colSet.add(col);
            }
        }

        int goldCount = 0;

        goldCount += rowSet.size() * width;
        goldCount += colSet.size() * height;
        goldCount -= rowSet.size() * colSet.size() * 2;
        System.out.println(goldCount);
    }
    
    
}
