import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhoHasSeenTheWind {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int humidity = Integer.parseInt(br.readLine());
		int timeLeft = Integer.parseInt(br.readLine());
		int currentTime = 1;
		String outputString = "The balloon does not touch ground in the given time.";
		while (currentTime <= timeLeft) {
			int currentAltitude = predict(currentTime, humidity);
			// System.out.println(currentAltitude);
			if (currentAltitude <= 0) {
				outputString = "The balloon first touches ground at hour: \n" + currentTime;
				break;
			}
			currentTime += 1;
		}
		System.out.println(outputString);
	}

	public static int predict(int time, int h) {
		return - 6 * (int) Math.pow(time, 4) + h * (int) Math.pow(time, 3) + 2 * (int) Math.pow(time, 2) + time;
		// return - 6 * time * time * time * time + h * time * time * time + 2 * time * time + time;
	}

}
