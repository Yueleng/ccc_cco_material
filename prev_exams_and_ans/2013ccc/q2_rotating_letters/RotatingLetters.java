import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class RotatingLetters {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String testStr = br.readLine();
		String RotatableChars = "IOSHZXN";
		String outputString = "YES";
		for (int i = 0; i < testStr.length(); i++) {
			if (RotatableChars.indexOf(testStr.charAt(i)) < 0) {
				outputString = "NO";
				break;
			}
		}
		System.out.println(outputString);
	}

}
