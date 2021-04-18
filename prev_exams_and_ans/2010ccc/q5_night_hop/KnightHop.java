import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.LinkedList;

public class KnightHop {

	private static LinkedList<State> tries;
	private static int[] finalPos;
	private static boolean[][] isVisitedBefore;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// Initialize startState, finalPos
		String[] startPosStr = br.readLine().split(" ");
		
		State startState = new State(
			0, 
			new int[] {Integer.parseInt(startPosStr[0]), Integer.parseInt(startPosStr[1])}
		);
		
		String[] finalPosStr = br.readLine().split(" ");
		finalPos = new int[] {Integer.parseInt(finalPosStr[0]), Integer.parseInt(finalPosStr[1])};
		
		// Initialize tries, isVisitedBefore
		tries = new LinkedList<>();
		isVisitedBefore = new boolean[9][9];
		tries.add(startState);
		isVisitedBefore[startState.curPos[0]][startState.curPos[1]] = true;
		
		while (tries.size() > 0) {
			State nextVisit = tries.removeFirst();
			if (isFinished(nextVisit)) {
				System.out.println(nextVisit.level);
				return;
			}
			
			tries.addAll(nexts(nextVisit));
		}
	}
	
	private static LinkedList<State> nexts(State state) {
		LinkedList<State> nextVisits = new LinkedList<>();
		
		int[][] moves = new int[][] {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};

		for (int[] move: moves) {
			State nextState = new State(
				state.level + 1, 
				new int[] {state.curPos[0] + move[0], state.curPos[1] + move[1]}
			);
			
			if (isInsideBound(nextState) && !isVisitedBefore[nextState.curPos[0]][nextState.curPos[1]]) {
				nextVisits.add(nextState);
				isVisitedBefore[nextState.curPos[0]][nextState.curPos[1]] = true;
			}
		}
		
		return nextVisits;
		
	}
	
	private static boolean isFinished(State state) {
		return state.curPos[0] == finalPos[0] && state.curPos[1] == finalPos[1];
	}
	
	private static boolean isInsideBound(State state) {
		return state.curPos[0] <= 8 && state.curPos[0] >= 1 && state.curPos[1] <= 8 && state.curPos[1] >= 1;
	}

}

class State {
	public int level;
	public int[] curPos;
	
	public State(int inputLevel, int[] inputPos) {
		this.level = inputLevel;
		this.curPos = inputPos;
	}
}