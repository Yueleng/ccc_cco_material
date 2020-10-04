import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VotesCount {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfVotes = Integer.parseInt(br.readLine()); // not used
		int aGets = 0;
		String votes = br.readLine();
		
		for (int i = 0; i < votes.length(); i++) {
			char vote = votes.charAt(i);
			if (vote == 'A')
				aGets += 1;
		}
		
		if (aGets > votes.length() - aGets)
			System.out.println("A");
		else if (aGets == votes.length() - aGets) 
			System.out.println("Tie");
		else 
			System.out.println("B");
	}
}