import java.util.Scanner;

public class RSANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter lower limit of range");
		int lower = sc.nextInt();
		
		System.out.println("Enter upper limit of range");
		int upper = sc.nextInt();
		
		int counter = 0;
		for(int i = lower; i <= upper; i++) {
			if(isRSANumber(i)) {
				counter++;
			}
		}
		
		System.out.println("The number of RSA numbers between " + lower + " and " + upper + " is " + counter);
	}
	
	public static boolean isRSANumber(int n) {
		
		int counter = 2;
		for(int i = 2; i < n; i++) {
			if(n % i == 0) {
				counter--;
				if(counter < 0) {
					return false;
				}
			}
		}
		
		return counter == 0;
	}

}
