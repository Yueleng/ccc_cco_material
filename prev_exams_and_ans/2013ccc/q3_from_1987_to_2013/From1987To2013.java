import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class From1987To2013 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputYear = Integer.parseInt(br.readLine());
		int nextYear = inputYear + 1;
		while (!isDistinct(nextYear)) {
			nextYear += 1;
		}
		System.out.println(nextYear);
	}

	public static boolean isDistinct(int year) {
		if (year < 9) return true;
		String yearString = Integer.toString(year);
		int[] digits = new int[yearString.length()];
		for (int i = 0; i < digits.length; i++) {
			digits[i] = Integer.parseInt(yearString.charAt(i) + "");
		}

		Arrays.sort(digits);
		for (int i = 0; i < digits.length - 1; i++) {
			if (digits[i] == digits[i+1])
				return false;
		}
		return true;
	}
}