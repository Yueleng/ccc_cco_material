import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ArrayList;

public class EscapeRoomBacktrack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Initialize the problem
        int rowNum = Integer.parseInt(br.readLine());
        int colNum = Integer.parseInt(br.readLine());
        int[][] numsOnCords = new int[rowNum+1][colNum+1];
        // String[] numToCords = new String[rowNum * colNum + 1];
        ArrayList<ArrayList<int[]>> numToCords = new ArrayList<ArrayList<int[]>>();
        for (int i = 0; i <= rowNum * colNum; i++) {
            ArrayList<int[]> cords = new ArrayList<int[]>();
            numToCords.add(cords);
        }

        for (int i = 1; i <= rowNum; i++) {
            String[] currentLine = br.readLine().split(" ");
            for (int j = 1; j <= colNum; j++) {
                numsOnCords[i][j] = Integer.parseInt(currentLine[j-1]);
                if (numsOnCords[i][j] <= rowNum * colNum) {
                    numToCords.get(numsOnCords[i][j]).add(new int[]{i,j});
                }
            }
        }
        
        LinkedList<int[]> cordsToTry = new LinkedList<int[]>();
        boolean[][] isVisitedBefore = new boolean[rowNum+1][colNum+1];
        isVisitedBefore[rowNum][colNum] = true;
        cordsToTry.add(new int[]{rowNum,colNum});
        while(cordsToTry.size()>0) {
            int[] aCord = cordsToTry.removeFirst();

            if (aCord[0] == 1 && aCord[1] == 1) {
                System.out.println("yes");
                return;
            }
            getCordsToTry(numToCords, aCord[0] * aCord[1], cordsToTry, isVisitedBefore);
            
        }
        
        System.out.println("no");

    }

    public static void getCordsToTry(ArrayList<ArrayList<int[]>> numToCords, int numToSearch, LinkedList<int[]> cordsToTry, boolean[][] isVisitedBefore) {
		if (numToCords.get(numToSearch) == null) {
			return ;
		} else {
            ArrayList<int[]> cords = numToCords.get(numToSearch);
            
			// set to null after search; Important!!
			numToCords.set(numToSearch, null);

			for (int i = 0; i < cords.size(); i++) {
                // in LinkedList, add and addLast perform the same thing: Appends the specified element to the end of this list.
                if (!isVisitedBefore[cords.get(i)[0]][cords.get(i)[1]]) {
                    isVisitedBefore[cords.get(i)[0]][cords.get(i)[1]] = true;
                    cordsToTry.add(new int[]{cords.get(i)[0],cords.get(i)[1]});
                }
			}
		}
	}
}
