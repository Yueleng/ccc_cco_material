import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnfriendRecursive {
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int numOfPeople = Integer.parseInt(br.readLine());
		
		int[] invited = new int[numOfPeople];
		
		for(int personInvited = 1; personInvited < numOfPeople; personInvited++) {
			invited[personInvited] = Integer.parseInt(br.readLine()); 
		}
		
		System.out.println(possibleRemoves(invited, numOfPeople));
		
	}
	
	public static int possibleRemoves(int[] invited, int invitedBy) {
		int count = 1;
		for (int personInvited = 1; personInvited < invited.length; personInvited++) {
            // TODO: To be improved
			if (invited[personInvited] == invitedBy)
				count =  count * possibleRemoves(invited, personInvited) + count;
		}
		return count;
	}
}
