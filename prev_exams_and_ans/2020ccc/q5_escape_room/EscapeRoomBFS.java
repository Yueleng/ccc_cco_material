import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EscapeRoomBFS {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Initialize the problem
        int rowNum = Integer.parseInt(br.readLine());
        int colNum = Integer.parseInt(br.readLine());
        int[][] numsOnCords = new int[rowNum+1][colNum+1];
        String[] currentLine = null;
        for (int i = 1; i <= rowNum; i++) {
            currentLine = br.readLine().split(" ");
            for (int j = 1; j <= colNum; j++) {
                numsOnCords[i][j] = Integer.parseInt(currentLine[j-1]);
            }
        }

        ArrayList<int[]> cordsToTry = getCord(rowNum, colNum, numsOnCords[1][1]);
        boolean[][] isVisitedBefore = new boolean[rowNum+1][colNum+1];
        while(cordsToTry.size()>0) {
            int[] aCord = cordsToTry.remove(0);
            if (!isVisitedBefore[aCord[0]][aCord[1]]) {
                isVisitedBefore[aCord[0]][aCord[1]] = true;
                if (aCord[0] == rowNum && aCord[1] == colNum) {
                    System.out.println("yes");
                    return;
                }
                ArrayList<int[]> cordsToBeChecked = getCord(rowNum, colNum, numsOnCords[aCord[0]][aCord[1]]);
                cordsToTry.addAll(cordsToBeChecked);
            } else {
                continue;
            }
        }
        System.out.println("no");
    }
    
    // public static ArrayList<int[]> getCord(int rowNum, int colNum, int numToSearch) {
    //     ArrayList<int []> addedCords = new ArrayList<int[]>();
    //     for (int i = 0; i <= rowNum; i++) {
    //         for (int j = 0; j <= colNum; j++) {
    //             if (i * j == numToSearch) {
    //                 addedCords.add(new int[]{i,j});
    //                 // There won't be any cord right of {i,j} which also equals numToSearch
    //                 // Thus break
    //                 // There may be some other cords on different row after row i. thus, only break one level up.
    //                 break;
    //             }
    //         }
    //     }

    //     return addedCords;
    // }

    public static ArrayList<int[]> getCord(int rowNum, int colNum, int numToSearch) {
        ArrayList<int []> addedCords = new ArrayList<int[]>();

        for (int i = 1; i <= rowNum; i++) {
            if (numToSearch % i == 0 && numToSearch / i <= colNum)
                addedCords.add(new int[]{i, numToSearch / i});
        }

        return addedCords;
    }
}
