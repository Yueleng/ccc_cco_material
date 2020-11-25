import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// Topic: loop through string; charAt; string indexOf

public class RotatingLetters {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String testStr = br.readLine();
		String rotatableChars = "IOSHZXN";
		String outputString = "YES";
		for (int i = 0; i < testStr.length(); i++) {
			if (rotatableChars.indexOf(testStr.charAt(i)) < 0) {
				outputString = "NO";
				break;
			}
		}
		System.out.println(outputString);
	}

}
