import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangleTimes {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int firstAngle = Integer.parseInt(br.readLine());
		int secondAngle = Integer.parseInt(br.readLine());
        int thirdAngle = Integer.parseInt(br.readLine());
        
		if (firstAngle + secondAngle + thirdAngle != 180) {
		    System.out.println("Error");
		} else if (firstAngle == secondAngle && secondAngle == thirdAngle && firstAngle == 60) {
		    System.out.println("Equilateral");
		} else if (
		    (firstAngle == secondAngle || firstAngle == thirdAngle || secondAngle == thirdAngle)
		) {
		    System.out.println("Isosceles");
		} else {
			System.out.println("Scalene");
        }
	}
}
