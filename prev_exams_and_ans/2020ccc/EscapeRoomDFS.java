import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class EscapeRoomDFS {

	public static void main(String[] args)  throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Initialize the problem
        int rowNum = Integer.parseInt(br.readLine());
        int colNum = Integer.parseInt(br.readLine());
        int[][] numsOnCords = new int[rowNum+1][colNum+1];
        String[] numDecompose = new String[rowNum * colNum + 1];  
        for (int i = 1; i <= rowNum; i++) {
            String[] currentLine = br.readLine().split(" ");
            for (int j = 1; j <= colNum; j++) {
                numsOnCords[i][j] = Integer.parseInt(currentLine[j-1]);
                if (numDecompose[i * j] == null) {
                	numDecompose[i*j] = i + "," + j;
                } else {
                	numDecompose[i*j] = numDecompose[i*j] + ";" + i + "," + j;
                }
            }
		}
		
		LinkedList<int[]> cordsToTry = new LinkedList<int[]>();
		cordsToTry.add(new int[] {1,1});
        boolean[][] isVisitedBefore = new boolean[rowNum+1][colNum+1];
        while(cordsToTry.size()>0) {
            int[] aCord = cordsToTry.removeLast();
            if (!isVisitedBefore[aCord[0]][aCord[1]]) {
                isVisitedBefore[aCord[0]][aCord[1]] = true;
                if (aCord[0] == rowNum && aCord[1] == colNum) {
                    System.out.println("yes");
                    return;
                }
                getCordToCordsToTry(numDecompose, numsOnCords[aCord[0]][aCord[1]], cordsToTry);
            } else {
                continue;
            }
        }
        
        System.out.println("no");
	}
	
	public static void getCordToCordsToTry(String[] numDecompose, int numToSearch, LinkedList<int[]> cordsToTry) {
		if (numDecompose.length - 1 /* rowNum * colNum */ < numToSearch || numDecompose[numToSearch] == null) {
			return ;
		} else {
			String cordsString = numDecompose[numToSearch];
			
			// set to null after search; Important!!
			numDecompose[numToSearch] = null;
			
			String[] cordsStrArr = cordsString.split(";");
			for (int i = 0; i < cordsStrArr.length; i++) {
				String[] cordStrArr = cordsStrArr[i].split(",");
				// in LinkedList, add and addLast perform the same thing: Appends the specified element to the end of this list.
				cordsToTry.add(new int[]{Integer.parseInt(cordStrArr[0]),Integer.parseInt(cordStrArr[1])});
			}
		}
	}

}
