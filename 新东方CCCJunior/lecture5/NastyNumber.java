import java.util.ArrayList;
import java.util.Scanner;

public class NastyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		//for(int i:arr){}
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			
			boolean nasty = isNasty(arr[i]);
			
			if(nasty) {
				System.out.println(arr[i] + " is nasty");
			}else {
				System.out.println(arr[i] + " is not nasty");
			}
		}

	}
	
	public static boolean isNasty(int number) {
		
		ArrayList<Integer> sum = new ArrayList<>();
		ArrayList<Integer> diff = new ArrayList<>();
		
		for(int d = 1; d <= Math.sqrt(number); d++) {
			if(number % d == 0) {
				//find a pair of divisors
				//d n/d
				sum.add(d + (number/d));
				diff.add((number/d) - d);
			}
		}
		
		int i = 0;
		int j = 0;
		
		while(i < sum.size() && j < diff.size()) {
			
			if(sum.get(i) == diff.get(j)) {
				return true;
			}else if(sum.get(i) < diff.get(j)){
				j++;
			}else {
				i++;
			}
			
		}
		
		return false;
	}
	

}
