package demo3;


import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class ACoinGame {

	private static HashSet<String> visited; // isVisitedBefore
	private static LinkedList<State> tries; 
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		String n;
		
		while ( !(n = sc.nextLine()).equals("0")) {
			
			// Initialize the problem
			boolean foundFlag = false;
			visited = new HashSet<>();
			tries = new LinkedList<>();
			String[] initCurState = sc.nextLine().split(" ");
			State initState = new State(0, initCurState);
			
			if (isFinished(initState)) {
				System.out.println(initState.level);
				foundFlag = true;
				continue;
			}
			
			visited.add(Arrays.toString(initState.curState));
			tries.add(initState);
			
			
			// General Logic
			while (tries.size() > 0) {
				State nextState = tries.removeFirst();
				if (isFinished(nextState)) {
					foundFlag = true;
					System.out.println(nextState.level);
					break ;
				}
				
				tries.addAll(nextVisits(nextState)/*nexts*/);
			}
			
			
			// print IMPOSSIBLE
			if (!foundFlag) System.out.println("IMPOSSIBLE");
			
		}

	}
	
	private static LinkedList<State> nextVisits(State state) {
		LinkedList<State> nextVisits = new LinkedList<>();
		
		for (int i = 0; i < state.curState.length; i++) {
			for (int j = i - 1; j <= i + 1; j++) {
				if (j <= state.curState.length - 1 && j >= 0) {
					
					String slotI = state.curState[i];
					String slotJ = state.curState[j];
					
					if (!slotJ.equals("")) {
						int jLen = slotJ.length();
						int iLen = slotI.length();
						
						if (slotI.equals("") || slotJ.charAt(jLen - 1) < slotI.charAt(iLen - 1) /*char < char*/) {
							// move/action
							
							slotI += slotJ.charAt(jLen - 1);
							slotJ = slotJ.substring(0, jLen - 1);
							
							String[] newCurState = Arrays.copyOf(state.curState, state.curState.length);
							newCurState[i] = slotI;
							newCurState[j] = slotJ;
							State stateToBeAdded = new State(state.level + 1, newCurState);
							
							if (!visited.contains(Arrays.toString(stateToBeAdded.curState))) {
								nextVisits.add(stateToBeAdded);
								visited.add(Arrays.toString(stateToBeAdded.curState));
							}
							
						}
						
					}
					
				}
			}
		
		}
		
		return nextVisits;
	}
	
	private static boolean isFinished(State state) {
		for (int i = 0; i < state.curState.length; i++) {
			if (state.curState[i].equals("") || Integer.parseInt(state.curState[i]) != i + 1) {
				return false;
			}
		}
		return true;
	}

}

class State {
	public int level;
	public String[] curState;
	
	// constructor
	public State(int inputLevel, String[] curState) {
		this.level = inputLevel;
		this.curState = curState; // {"3", "2", "1"} or {"32", "", "1"} or {"321", "", ""}
	}
}
