package lecture2;

import java.util.Scanner;
import java.io.IOException; // io: InputOutput

public class WhoHasSeenTheWind {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		
//		int humidity = Integer.parseInt(sc.nextLine());
//		int timeLeft = Integer.parseInt(sc.nextLine());
		int humidity = sc.nextInt();
		int timeLeft = sc.nextInt();
		sc.close();
		
		String outputString = "The balloon does not touch ground in the given time.";
		for (int currentTime = 1; currentTime <= timeLeft; currentTime++) {
			int currentAltitude = predict(currentTime, humidity);
			if (currentAltitude <= 0) {
				outputString = "The balloon first touches ground at hour: \n" + currentTime;
				break;
			}
		}
		System.out.println(outputString);

	}
	
	public static int predict(int currentTime, int humidity) {
		return - 6 * (int) Math.pow(currentTime, 4) 
				+ humidity * (int) Math.pow(currentTime, 3) 
				+ 2 * (int) Math.pow(currentTime, 2) 
				+ currentTime;
	}

}
