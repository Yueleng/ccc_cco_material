import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SoundsFishy {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] depths = new int[4];
		for (int i = 0; i < 4; i++) {
			depths[i] = Integer.parseInt(br.readLine());
		}

		if (isMonotone(depths)) {
			//	String outputString = depthsRead[0] - depthsRead[1] < 0 ? "Fish Rising"
			//		: (depthsRead[0] - depthsRead[1] > 0 ? "Fish Diving" : "Fish At Constant");
			//		System.out.println(outputString);
			
			int outputState = comparisonState(depths[0], depths[1]);
			switch(outputState) {
			case 1 :
				System.out.println("Fish Rising");
				break;
			case 0: 
				System.out.println("Fish At Constant");
				break;
			case -1:
				System.out.println("Fish Diving");
			}
		} else {
			System.out.println("No Fish");
		}

	}

	public static boolean isMonotone(int[] depths) {
		if (depths.length == 0) return true;
		int firstComparison = comparisonState(depths[0], depths[1]);
		for (int i = 0; i < depths.length - 1; i++) {
			int comparisonState = comparisonState(depths[i], depths[i+1]);
			if (firstComparison != comparisonState)
				return false;
		}

		return true;
	}


	public static int comparisonState (int a, int b) {
		return a - b < 0 ? 1 : (a - b ==  0 ? 0 : -1);
	}
}
