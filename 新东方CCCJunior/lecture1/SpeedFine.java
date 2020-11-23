import java.util.Scanner;

public class SpeedFine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		int limit = scanner.nextInt();
		int speed = scanner.nextInt();
		
		if(speed <= limit) {
			System.out.println("Congratulations, you are within the speed limit!");
		}else if(speed - limit <= 20) {
			//0 < (speed - limit) <= 20
			// 0 < (speed - limit) &&  (speed - limit) <= 20
			System.out.println("You are speeding and your fine is $100.");
		}else if(speed - limit <= 30) {
			System.out.println("You are speeding and your fine is $270.");
		}else /*if(speed - limit > 30)*/{
			System.out.println("You are speeding and your fine is $500.");
		}
		
	}

}
