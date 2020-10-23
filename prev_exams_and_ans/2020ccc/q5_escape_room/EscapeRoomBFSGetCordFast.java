import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EscapeRoomBFSGetCordFast {

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
        
        // ArrayList<int[]> cordsToTry = getCord(rowNum, colNum, numsOnCords[1][1]);
        ArrayList<int[]> cordsToTry = getCord(numDecompose, numsOnCords[1][1]);
        boolean[][] isVisitedBefore = new boolean[rowNum+1][colNum+1];
        while(cordsToTry.size()>0) {
            int[] aCord = cordsToTry.remove(0);
            if (!isVisitedBefore[aCord[0]][aCord[1]]) {
                isVisitedBefore[aCord[0]][aCord[1]] = true;
                if (aCord[0] == rowNum && aCord[1] == colNum) {
                    System.out.println("yes");
                    return;
                }
                // ArrayList<int[]> cordsToBeChecked = getCord(rowNum, colNum, numsOnCords[aCord[0]][aCord[1]]);
                ArrayList<int[]> cordsToBeChecked = getCord(numDecompose, numsOnCords[aCord[0]][aCord[1]]);
                cordsToTry.addAll(cordsToBeChecked);
            } else {
                continue;
            }
        }
        
        System.out.println("no");
	}
	
	public static ArrayList<int[]> getCord(String[] numDecompose, int numToSearch) {
		ArrayList<int []> addedCords = new ArrayList<int[]>();
		if (numDecompose.length - 1 /* rowNum * colNum */ < numToSearch || numDecompose[numToSearch] == null) {
			return addedCords;
		} else {
			String cordsString = numDecompose[numToSearch];
			String[] cordsStrArr = cordsString.split(";");
			for (int i = 0; i < cordsStrArr.length; i++) {
				String[] cordStrArr = cordsStrArr[i].split(",");
				addedCords.add(new int[]{Integer.parseInt(cordStrArr[0]),Integer.parseInt(cordStrArr[1])});
			}
			return addedCords;
		}
	}

}
