import java.io.IOException;
import java.util.Scanner;

/*
 * 
 * This is a recursive problem (or possibly a Dynamic Programming Problem)
 * 
 * This is the recursive solution.
 * 
 * Given n (number of pieces of pie) and k (number of people) and the minimum 
 * number of pieces that can be taken, the number of ways the pie can be distributed 
 * is
 * 
 * 	 1 if n = k or k = 1
 * 	 otherwise it is the sum of the ways of (n-i, k-1, i) where i goes from min to n/k (inclusive)
 *   
 *   an example might help: pi(9, 4, 1)
 *   
 *   n = 9, k = 4 and min = 1;
 *   for this the answer is calculated as follows:
 *   
 *   	the first person could take 1 piece leaving us the task of finding the ways 
 *   		with now 8 pieces (9 - 1), 3 people and a min of 1 ( = pi(8, 3, 1) )
 *   	the first person could take 2 pieces leaving us the task of finding the ways
 *   		with now 7 pieces (9 - 2), 3 people and a min of 2 ( = pi(7, 3, 2) )
 *   	the first person could NOT take 3 pieces (or more)_because that would leave 6
 *   		pieces for 3 people and since the first person took 3, they would have to 
 *   		take at least 3 themselves and that's 9 not 6 pieces! 
 *      in general, the most the first person person can take is n/k (eg 9/4 = 2)
 *      
 * The recursive as described above works fine, BUT is too slow for the later data sets,
 * SO, to avoid calculating same thing twice, there is a "visited" array. This is a 3D 
 * array keeping track of all previous results. Half the running time (and code) is devoted 
 * to creating it. And initializing it to 0. In the recursion, if the visited array knows the answer,
 * use it and don't recurse, otherwise calculate and store the answer in visited.
 * 
 * 
 * */

public class PieDay {
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		
		
		int[][][] piMemo = new int[n+1][k+1][n+1];
		
		System.out.println(pi(n, k, 1, piMemo));
		
	}
	
	public static int pi(int n, int k, int i, int[][][] piMemo) {
		// System.out.println(n + ", " + k + ", " + i );
		if (piMemo[n][k][i] == 0) {
			if (n == k && i == 1) {
				piMemo[n][k][i] = 1;
			} else if (k == 1) {
				piMemo[n][k][i] = 1;
			} else {
				int sum = 0;
				for (int j = i; j <= n/k; j++) {
					sum += pi(n-j, k-1, j, piMemo);
				}
				piMemo[n][k][i] = sum;
			}
		}
		
		return piMemo[n][k][i];
	}
}
