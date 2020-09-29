import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpeedFinesAreNotFine {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// System.out.print("Enter the speed limit:");
		int limit = Integer.parseInt(br.readLine());
		
		// System.out.print("Enter the recorded speed of the car:");
		int speed = Integer.parseInt(br.readLine());
		
		int diff = speed - limit;
		String fine;
		if (diff <= 0) {
			System.out.println("Congratulations, you are within the speed limit!");
		} else if (diff <= 20 && diff >= 1) {
			fine = "$100";
			System.out.println("You are speeding and your fine is " + fine + '.');
		} else if (diff >= 21 && diff <= 30) {
			fine = "$270";
			System.out.println("You are speeding and your fine is " + fine + '.');
		} else if (diff >= 31) {
			fine = "$500";
			System.out.println("You are speeding and your fine is " + fine + '.');
		}
	}
}