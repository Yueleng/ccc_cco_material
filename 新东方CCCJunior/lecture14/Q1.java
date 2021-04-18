package mock;

import java.util.*;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		
		//one hand
		if(n >= 1 && n <= 5) {
			count++;
		}
		
		//two hands
		//1-0 2-1-1 3-1-1 4-1,2-2 5-1,2-2 6-1,2,3-3 
		//7-2,5 3,4-2 8-3,5 4,4-2 9-4,5-1 10-5,5
		//7-2, 8-2, 9-1, 10-1
		//11-n
		//4,3,2,1
		//
		//floor(n/2)
		if(n<7) {
			count+=n/2;
		}else {
			if(n == 7 || n == 8) {
				count+=2;
			}else {
				count+=1;
			}
		}
		
		System.out.println(count);
	}

}
