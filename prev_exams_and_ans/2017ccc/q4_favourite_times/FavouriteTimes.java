import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
// import java.util.Arrays;

public class FavouriteTimes {
	private static ArrayList<int[]> allPossibleTime;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int passedMinutes = Integer.parseInt(br.readLine());
		int passedDays = passedMinutes / 720;
		int observations = 0;
		generateAllPossibleTime();
		
//		print out the allPossibleTime
//		for (int[] time: allPossibleTime) {
//			System.out.println(time[0] + ":" + time[1]);
//		}
		
		observations += ( passedDays ) * allPossibleTime.size();
		passedMinutes = passedMinutes - passedDays * 720;
		
		for (int[] time: allPossibleTime) {
			if (determineTimeDifference(time) <= passedMinutes) {
				observations += 1;
			}
		}
		System.out.println(observations);
	}
	
	public static int determineTimeDifference(int[] end) {
//		difference between 12:00 and end
		int diffInMinutes = 0;
		if (end[0] == 12)
			end[0] = 0;
		diffInMinutes = (end[0]) * 60 + end[1];
		return diffInMinutes;
	}
	
	public static ArrayList<int[]> generateAllPossibleTime() {
		allPossibleTime = new ArrayList<>();
		for (int i = -4; i <= 4; i++) {
			for (int j = 1; j <= 12; j++) {
				if (j < 10) {
					int firstNum = j;
					if (firstNum + i <= 5 && firstNum + i >= 0 && firstNum + i * 2 <= 9 && firstNum + i * 2 >= 0) {
						// append to allPossibleTime
						int[] time = {j, (firstNum + i) * 10 + firstNum + 2 * i};
						allPossibleTime.add(time);
					}
				} else {
					// j = 10, 11, 12
					int firstNum = 1;
					int secondNum = j - 10;
					if (i != secondNum - firstNum) continue;
					if (secondNum + i <= 5 && secondNum + i >= 0 && secondNum + 2 * i <= 9 && secondNum + 2* i >= 0) {
						// append to allPossibleTime
						int[] time = {j, (secondNum + i) * 10 + secondNum + 2 * i};
						allPossibleTime.add(time);
					}
				}
			}
		}
		return allPossibleTime;
	}
}