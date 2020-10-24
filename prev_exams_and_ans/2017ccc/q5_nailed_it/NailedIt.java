import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NailedIt {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfInputs = Integer.parseInt(br.readLine());
		int[] woodCount= new int[2010];
        int[] sumCount = new int[4020];
        
        // count
		for (String input: br.readLine().split(" ")) {
			int woodLength = Integer.parseInt(input);
			woodCount[woodLength] += 1;
        }

		// calculate sumCount
		for (int n = 1; n <= 2000; n++) {
			if (woodCount[n] != 0) {
				if (woodCount[n] > 1) {
					sumCount[n * 2] += woodCount[n] / 2;
				}
				for (int s = n + 1; s <= 2000; s++) {
					if (woodCount[s] != 0) {
						sumCount[n+s] += Math.min(woodCount[n], woodCount[s]);
					}
				}
			}
		}

		// get maxLengthofFence and it's occurence
		int maxLengthOfFence = 1;
		int maxLengthOfFenceOccurence = 0;
		for (int i = 1; i <= 4000; i++) {
			if (sumCount[i] > maxLengthOfFence) {
				maxLengthOfFence = sumCount[i];
				maxLengthOfFenceOccurence = 1;
			} else if (sumCount[i] == maxLengthOfFence) {
				maxLengthOfFenceOccurence += 1;
			}
		}

		System.out.println(maxLengthOfFence + " " + maxLengthOfFenceOccurence);
	}
}
