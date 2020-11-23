package lecture2;

import java.util.Scanner;
import java.io.IOException;

public class VoteCount {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int times = Integer.parseInt(sc.nextLine());
		String counts = sc.nextLine();
		
		int aCounts = 0;
		int bCounts = 0;
		
		for (int i = 0; i < counts.length(); i++) {
			if (counts.charAt(i) == 'A') {
				aCounts++;
			} else if (counts.charAt(i) == 'B') {
				bCounts++;
			}
		}
		
		String outputString = "";
		
		if (aCounts > bCounts) {
			outputString = "A";
		} else if (bCounts > aCounts) {
			outputString = "B";
		} else {
			outputString = "Tie";
		}
		
		System.out.println(outputString);
	}

}
