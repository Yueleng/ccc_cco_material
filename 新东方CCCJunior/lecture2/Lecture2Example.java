package lecture2;

public class Lecture2Example {

	public static void main(String[] args) {
		System.out.println("Print out three \"Hello World\": ");
		
		for (int i = 1; i <= 3; i++) {
			System.out.println("Hello World!");
		}
		
		System.out.println("---Calculate 1 + 2 + ... + 10: ---");
		int sum = 0;
		for (int i = 1; i <= 10; i++) {	
			sum += i; // sum = sum + i;
		}
		System.out.println("Sum:= " + sum);
		
		System.out.println("---Calculate 2 + 4 + ... + 20: ---");
		sum = 0;
		for (int i = 1; i <= 20; i++) {
			// i = 1, 2, 3, 4, 5, ..., 20
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("Sum: " + sum);
		
		System.out.println("---Calculate 2 + 4 + ... + 20: ---");
		sum = 0;
		for (int i = 2; i <= 20; i+=2) {
			// i = 2, 4, 6, 8, ... 20
			sum += i;
		}
		System.out.println("Sum: " + sum);
		
		System.out.println("---Calculate 2 + 4 + ... + 20: ---");
		sum = 0;
		for (int i = 1; i <= 10; i++) {
			// i = 1, 2, 3, ..., 10
			sum += i*2;
		}
		System.out.println("Sum:= " + sum);
		// O(n) <-> O(n/2)
		// O(n^2) <-> O(n)
		
		System.out.println("---Calculate 20 + 18 + ... + 10: ---");
		sum = 0;
		for (int i = 20; i >= 10; i -= 2) {
			sum += i;
		}
		System.out.println("Sum := " + sum);
		
		System.out.println("Calculate 1 + 2 + ... + 10: While Loop");
		int i = 1;
		sum = 0;
		while (i <= 10) {
			sum += i;
			i++;
		}
		System.out.println("Sum := " + sum);
		
		System.out.println("Calculate 1 + 2 + ... + 10: For Loop While style");
		i = 1; 
		sum = 0;
		for (; i <= 10;) {
			sum += i;
			i++;
		}
		System.out.println("Sum:= " + sum);
		
		// Usage of Continue
		sum = 0; 
		System.out.println("---Usage of continue--");
		System.out.println("Print out all the odd number from 1 to 20");
		for (int j = 1; j <= 20; j++) {
			// j = 1, 2
			if (j % 2 == 0) {
				continue;
			}
			System.out.print(j + ", ");
		// continue
		}// break;
		System.out.println();
		
		System.out.println("---Usage of break---");
		System.out.println("Pirnt numbers until you hit 18");
		for (int j = 10; j <= 20; j++) {
			if (j == 18) {
				break;
			}
			
			System.out.print(j + ", ");
		}
		System.out.println();
		
		// Print all prime numbers from 10 to 100
		System.out.println("Print all prime numbers from 10 to 100");
		
		for (int j = 10; j <= 100; j++) {
			if (isPrime(j) /*returns true/false*/) {
				System.out.print(j + ", ");
			}
		}
		System.out.println();
		
		// nested for loop
		System.out.println("Print Triangle Stars");
		for (int j = 1; j<=5; j++) {
			// j = 1, 2, ..., 5
			for (int k = 1; k <= j; k++) {
				// k = 1, ..., j
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("Print Number Matrix");
		for (int j = 1; j <= 5; j++) {
			for (int k = 1; k <= 5; k++) {
				System.out.print(j * k + " "); // int * int + String => int + String => String
			}
			System.out.println();
		}
		
		
		
	}
	
	public static boolean isPrime(int n) {
		if (n == 1 || n == 2) {
			return true;
		} else {
			int i = 2;
			while(i <= n - 1) {
				if (n % i == 0) {
					return false; // break-sense
				}
				i++;
			}
			return true;
		}
	}
}
