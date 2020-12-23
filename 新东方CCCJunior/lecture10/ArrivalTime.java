package demo;

import java.io.IOException;
import java.util.Scanner;

public class ArrivalTime {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String[] startTimeString = sc.nextLine().split(":");
		
		// "01" -> 1, "05" -> 5
		int[] startTime = {Integer.parseInt(startTimeString[0]), Integer.parseInt(startTimeString[1])};
		
		System.out.println(arrivalTime(startTime));
	}

	
	public static String arrivalTime(int[] startTime) {
		// distance = sum(speed * delta_t);
		int startHour = startTime[0];
		int startMin = startTime[1];
		
		double distance = 0;
		// distance = 120; normal speed = 1, half speed 1/2
		while (distance < 120.0) {
			int[] newTime = {startHour, startMin};
			distance += speed(newTime);
			
			// update time after small movement.
			startMin += 1;
			if (startMin == 60) {
				startMin = 0;
				startHour += 1;
				if (startHour == 24)
					startHour = 0;
			}
		}
		
		return (startHour <= 9 ? "0" : "" ) + startHour
				+ ":" 
				+ (startMin <= 9 ? "0" : "") + startMin;
	}
	
	public static double speed(int[] time) {
		if (time[0] >= 7 && time[0] <= 9)
			return 0.5;
		else if (time[0] >= 15 && time[0] <= 18) {
			return 0.5;
		}
		return 1.0;
	}
}
