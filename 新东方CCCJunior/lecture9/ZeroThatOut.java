package graph;

import java.util.Scanner;
import java.util.Stack;

public class ZeroThatOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> stack = new Stack<Integer>();
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int total = 0;
		
		while(n-->0) {//n>=0? n=n-1
			
			int score = sc.nextInt();
			
			if(score == 0) {
				total -= stack.pop();
			}else {
				total += score;
				stack.push(score);
			}
		}
		
		System.out.println(total);
	}

}
