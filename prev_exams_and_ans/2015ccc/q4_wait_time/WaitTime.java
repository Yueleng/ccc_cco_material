import java.io.IOException;
//import java.util.Scanner;
//import java.util.HashMap;
//import java.util.ArrayList;
import java.util.*;

public class WaitTime {
	
	// <friendId, [waitTime, indicator]}>
	// indicator: -1 if all cleared up; timeStamp if not cleared up;
	private static HashMap <String, int[]> waitTimeTable = new HashMap<>();
	private static ArrayList<String> friendArray = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int rows = Integer.parseInt(sc.nextLine());
		int timeStamp = 0;
		for (int i = 0; i < rows; i++) {
			String[] rowInfo = sc.nextLine().split(" ");
			String action = rowInfo[0];

			if (!action.equals("W")) {
				// action equals R or S
				String friendId = rowInfo[1];
				if (!waitTimeTable.containsKey(friendId) /* new friend */) {
					int[] friendInfo = {0, timeStamp};
					waitTimeTable.put(friendId, friendInfo);
					friendArray.add(friendId);
				} else /* old friend */ {
					// old friend, either "S" to complete conversation 
					//                 or "R" to start a new conversation
					int[] friendInfo = waitTimeTable.get(friendId);
					if (action.equals("S")) {
						friendInfo[0] = friendInfo[0] + (timeStamp - friendInfo[1]);
						friendInfo[1] = -1; // indicator: -1; complete conversation.
						waitTimeTable.put(friendId, friendInfo);
					} else /* "R" */ {
						friendInfo[1] = timeStamp;
						waitTimeTable.put(friendId, friendInfo);
					}
				}
				timeStamp += 1;
			} else /* action equals W*/ {
				timeStamp += Integer.parseInt(rowInfo[1]) - 1; // Why -1?
			} 
			
		}
		
		Collections.sort(friendArray);
		for (String friendId: friendArray) {
			int[] friendInfo = waitTimeTable.get(friendId);
			System.out.println(friendId + " " + (friendInfo[1] == -1 ? friendInfo[0] : -1));
		}
	}

}