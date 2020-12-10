import java.util.Scanner;

public class FractionAction {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Numerator");
		int numerator = sc.nextInt();
		
		System.out.println("Denominator");
		int denominator = sc.nextInt();
		
		int quotient = numerator / denominator;
		System.out.print(quotient);

		numerator -= quotient * denominator;
		//55 - 5 * 10 == 0 
		//5
		int a = denominator;
		int b = numerator;
		if(numerator != 0) {
			//euclidean algorithm 辗转相除法
			//GCD(numerator denominator)
			int remainder;
			do {
				remainder = a % b;
				a = b;
				b = remainder;
			}while(remainder != 0);

			int gcd = a;
			numerator /= gcd;
			denominator /= gcd;
			
			System.out.print(" " + numerator + "/" + denominator);
		}
	}
}
