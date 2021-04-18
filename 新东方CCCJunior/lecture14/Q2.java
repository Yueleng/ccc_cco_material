package mock;

import java.util.*;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int trout = sc.nextInt();
		int pike = sc.nextInt();
		int pickerel = sc.nextInt();
		
		int total = sc.nextInt();
		int count = 0;
		
		for(int i = total/trout; i >= 0; i--) {
			for(int j = total/pike; j >= 0; j--) {
				for(int k = 0; k <= total/pickerel; k++) {
					//System.out.println("i = " + i + ", j = " + j + ", k = " + k);
					if(i>0||j>0|| k>0) {	
						//System.out.println("i = " + i + ", j = " + j + ", k = " + k);
						//System.out.println(i * trout + j * pike + k * pickerel);
						
						if(i * trout + j * pike + k * pickerel <= total) {
							count++;
							System.out.println(i + " Brown Trout, " + j + " Northern Pike, " + k +" Yellow Pickerel");
						}
					}
				}
			}
		}
		
		System.out.println("Number of ways to catch fish: " + count);
		
	}

}
