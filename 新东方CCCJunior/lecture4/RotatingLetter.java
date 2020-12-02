package lecture4;

import java.io.IOException;
import java.util.Scanner;

public class RotatingLetter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String testStr = sc.nextLine();
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
