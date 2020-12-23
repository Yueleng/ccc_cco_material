package graph;

import java.util.ArrayList;

public class GraphRepresentationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = 5;
		int[][] graphArray = new int[N][N];//by default, all zeros
		graphArray[0][4] = 1;
		graphArray[4][0] = 1;
		
		graphArray[0][1] = 1;
		graphArray[1][0] = 1;
		
		//...
		
		ArrayList<ArrayList> graphList = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			graphList.add(new ArrayList<Integer>());
		}
		
		// 0 - 1 / 0 - 4
		graphList.get(0).add(1);
		graphList.get(0).add(4);
		
		// 2 - 1 / 2 - 3
		graphList.get(2).add(1);
		graphList.get(2).add(3);
		
	}

}
