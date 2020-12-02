import java.util.Scanner;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Arrays;

public class ACoinGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n;
		while (!(n = sc.nextLine()).equals("0")) {
            
            boolean foundFlag = false;
			HashSet<String> visited = new HashSet<>();
			String[] initCurState = sc.nextLine().split(" ");
            
            State initState = new State(); 
            initState.level = 0; 
            initState.curState = initCurState;
			
			// test if the original place is already finished
			if (isFinished(initState)) {
				System.out.println(initState.level);
				foundFlag = true;
				continue ;
			}
			
			visited.add(Arrays.toString(initState.curState));
			
			LinkedList<State> tries = new LinkedList<>();
			LinkedList<State> nextInitialStates = nextVisits(initState);
			tries.addAll(nextInitialStates);
			
			for (State nextState: nextInitialStates) {
				visited.add(Arrays.toString(nextState.curState));
			}
			
			
			while(tries.size() > 0) {
				State nextState = tries.removeFirst();
				if (isFinished(nextState)) {
					System.out.println(nextState.level);
					foundFlag = true;
					break ;
				}
				
				// System.out.println("Finding next visits for " + Arrays.toString(nextState.curState));
				
				LinkedList<State> nextVisits = nextVisits(nextState);
				for (State nextVisit: nextVisits) {
					if (!visited.contains(Arrays.toString(nextVisit.curState))) {
						visited.add(Arrays.toString(nextVisit.curState));
						tries.add(nextVisit);
					}
				}
			}
			
			if (!foundFlag) {
				System.out.println("IMPOSSIBLE");
			}
			
		}
		sc.close();
//		String[] initCurState = {"32", "", "1"};
//		State initState = new State(); initState.level = 0; initState.curState = initCurState; 
//		nextVisits(initState);
//		
//		System.out.println(isFinished(initState));
	}
	
	public static LinkedList<State> nextVisits(State state) {
		LinkedList<State> newStates = new LinkedList<>();
		for (int i = 0; i < state.curState.length; i++) {
			for (int j = i-1; j <= i + 1; j++) {
				if (j < state.curState.length && j >= 0) {
					String slotI = state.curState[i];
					String slotJ = state.curState[j];
					if (!slotJ.equals("")) {
						int jLen = slotJ.length();
						int iLen = slotI.length();
						if ((!slotI.equals("") && slotJ.charAt(jLen - 1) < slotI.charAt(iLen-1)) || (slotI.equals(""))) {
							slotI += slotJ.charAt(jLen - 1);
							slotJ = slotJ.substring(0, jLen - 1);
							String[] newState = Arrays.copyOf(state.curState, state.curState.length);
							newState[i] = slotI;
							newState[j] = slotJ;
							
							// System.out.println(Arrays.toString(newState));
							
							State stateToBeAdded = new State();
							stateToBeAdded.level = state.level + 1;
							stateToBeAdded.curState = newState;
							newStates.add(stateToBeAdded);
						}
					}
				}
			}
		}
		return newStates;
	}
	
	public static boolean isFinished(State state) {
		for (int i = 0; i < state.curState.length; i++) {
			if (state.curState[i].equals("") || Integer.parseInt(state.curState[i]) != i + 1)
				return false;
		}
		return true;
	}
}


class State {
	public int level;
	public String[] curState;
}