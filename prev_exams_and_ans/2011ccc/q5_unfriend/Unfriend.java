import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Unfriend {

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfPeople = Integer.parseInt(br.readLine());

		int[] invited = {1, 1, 1, 1, 1, 1, 1};
		for (int personInvited = 1; personInvited <= numOfPeople-1; personInvited++) {
			int invitedBy = Integer.parseInt(br.readLine());
			invited[invitedBy] = invited[invitedBy] + invited[invitedBy] * invited[personInvited];
		}
		System.out.println(invited[numOfPeople]);
	}

}
