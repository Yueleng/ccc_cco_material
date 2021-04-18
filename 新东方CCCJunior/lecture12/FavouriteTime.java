package demo3;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class FavouriteTime {
	
	private static ArrayList<int[]> allPossibleTime;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int passedMinutes = Integer.parseInt(sc.nextLine());
		int passedDays = passedMinutes / 720;
		int observations = 0;
		
		allPossibleTime = generateAllPossibleTime();
		
		observations += ( passedDays ) * allPossibleTime.size();
		passedMinutes = passedMinutes - passedDays * 720; // passedMinutes % 720
		
		for (int[] time: allPossibleTime) {
			if (determineTimeDifference(time) <= passedMinutes) {
				observations += 1;
			}
		}
		
		System.out.println(observations);
		
	}
	
	public static int determineTimeDifference(int[] favouriteTime) {
//		difference between 12:00 and end
		int diffInMinutes = 0;
		if (favouriteTime[0] == 12)
			favouriteTime[0] = 0;
		diffInMinutes = (favouriteTime[0]) * 60 + favouriteTime[1];
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
