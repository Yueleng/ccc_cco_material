import java.util.Scanner;

public class Divisor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		/*
		for(int d = 1; d <= n; d++) {
			
			if(n % d == 0) {
				System.out.println(d);
			}
			
		}*/
		
		int sum = 0;
		for(int d = 2; d <= Math.sqrt(n); d++) {
			if(n % d == 0) {
				//System.out.println(d);
				sum += d;
				if(n/d != d) {
					//System.out.println(n/d);
					sum += n/d;
				}
			}
		}
		sum += 1;
		
		if(sum == n) {
			System.out.println("Perfect");
		}else {
			System.out.println("Not Perfect");
		}

	}

}
