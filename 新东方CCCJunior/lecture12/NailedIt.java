package demo3;

import java.util.Scanner;
import java.io.IOException;

public class NailedIt {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int numOfInputs = Integer.parseInt(sc.nextLine());
		int[] woodCount = new int[2001];
		int[] sumCount = new int[4001];
		
		// count
		for (String input: sc.nextLine().split(" ")) {
			int woodLength = Integer.parseInt(input);
			woodCount[woodLength] += 1;
		}
		
		// calculate sumCount
		for (int n = 1; n <= 2000; n++) {
			if (woodCount[n] !=0) {
				if (woodCount[n] > 1) {
					sumCount[n*2] += woodCount[n] / 2; // 6 6 6 6 6 6 6 6 => sumCount[12] += 8 / 2
				}
				for (int s = n + 1; s <= 2000; s++) {
					if (woodCount[s] != 0) {
						sumCount[n+s] +=  Math.min(woodCount[n], woodCount[s]); // 2 2 2 4 4 => sumCount[6] += 2;   
						// sumCount[110] = 3
					}
				}
				
//				correct when there is no duplicate wood, i.e. every wood has difference length;
//				for (int s = n + 1; s <= 2000; s++) {
//					if (woodCount[s] != 0) {
//						sumCount[n+s] +=  1;
//					}
//				}
				
			}
		}
		
		// get maxLengthOfFence and it's occurence
		int maxLengthOfFence = 1;
		int maxLengthOfFenceOccurence = 0;
		for (int i = 1; i <= 4000; i++) {
			if (sumCount[i] > maxLengthOfFence) {
				maxLengthOfFence = sumCount[i];
				maxLengthOfFenceOccurence = 1; 
			} else if (sumCount[i] == maxLengthOfFence) {
				maxLengthOfFenceOccurence++; 
			}
		}
		System.out.println(maxLengthOfFence + " " + maxLengthOfFenceOccurence);
	}
}
