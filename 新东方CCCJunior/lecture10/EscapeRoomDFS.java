package demo;

import java.io.IOException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;

public class EscapeRoomDFS {

	public static HashMap<Integer, ArrayList<int[]>> intDecompose;
	public static boolean[][] isVisitedBefore;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		// Initialize the problem
		int rowNum = Integer.parseInt(sc.nextLine());
		int colNum = Integer.parseInt(sc.nextLine());
		
		int[][] numsOnCords = new int[rowNum+1][colNum+1];
		intDecompose = new HashMap<>();
		
		// Read the data and create the hashmap for fast next function
		for (int i = 1; i <= rowNum; i++) {
			String[] currentLine = sc.nextLine().split(" ");
			for (int j = 1; j <= colNum; j++) {
				numsOnCords[i][j] = Integer.parseInt(currentLine[j-1]);
				
				// Create the hashMap of integer -> ArrayList<int[]>: intDecompose
				if (!intDecompose.containsKey(i * j)) {
					ArrayList<int[]> decompose = new ArrayList<>();
					decompose.add(new int[] {i, j});
					intDecompose.put(i * j, decompose);
				} else {
					ArrayList<int[]> decompose = intDecompose.get(i * j);
					decompose.add(new int[] {i, j});
					intDecompose.put(i * j, decompose);
				}
			}
		}
		
		LinkedList<int[]> tries = new LinkedList<>();
		
		// initialization of isVisitedBefore and tries List, add the children of {1, 1} to the tries List
		isVisitedBefore = new boolean[rowNum+1][colNum+1];
		isVisitedBefore[1][1] = true;
		tries.add(new int[] {1, 1});
		
		while (tries.size() > 0) {
			int[] aCord = tries.removeLast(); // IMPORTANT, DFS;
			if (aCord[0] == rowNum && aCord[1] == colNum) {
				System.out.println("yes");
				return;
			}
			
			tries.addAll(nexts(numsOnCords[aCord[0]][aCord[1]] /*numToSearch*/));
		}
		
		System.out.println("no");
		
	}
	
	public static LinkedList<int[]> nexts(int numToSearch) {
		if (!intDecompose.containsKey(numToSearch)) {
			return new LinkedList<int[]>();
		} else {
			ArrayList<int[]> decomposes = intDecompose.get(numToSearch);
			LinkedList<int[]> nextVisits = new LinkedList<>();
			for (int i = 0; i < decomposes.size(); i++) {
				int rowIdx = decomposes.get(i)[0];
				int colIdx = decomposes.get(i)[1];
				if (isVisitedBefore[rowIdx][colIdx] == false) {
					nextVisits.add(new int[] {rowIdx, colIdx});
					isVisitedBefore[rowIdx][colIdx] = true;
				}
			}
			return nextVisits;
		}
	}
}
