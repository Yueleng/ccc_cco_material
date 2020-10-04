import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoubleDice {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int rows = Integer.parseInt(br.readLine());
		int playerOnePoint = 100;
		int playerTwoPoint = 100;
		for (int i = 0; i < rows; i++) {
			String[] twoNumStr = br.readLine().split(" ");
			int playOnePointCurrentRound = Integer.parseInt(twoNumStr[0]);
			int playTwoPointCurrentRound = Integer.parseInt(twoNumStr[1]);
			if (playOnePointCurrentRound > playTwoPointCurrentRound) {
				playerTwoPoint -= playOnePointCurrentRound;
			} else if (playOnePointCurrentRound < playTwoPointCurrentRound) {
				playerOnePoint -= playTwoPointCurrentRound;
			}
		}
		System.out.println(playerOnePoint);
		System.out.println(playerTwoPoint);
	}

}
