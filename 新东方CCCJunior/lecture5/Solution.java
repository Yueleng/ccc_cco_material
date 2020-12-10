import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2},
				          {3,4}};

		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		//VHVHVVVHHHVHVHVHVHHHHVH
		int V = 0;
		int H = 0;
		//0,1,2,3,4 -> length 5
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'V') {
				V++;
			}else {
				H++;
			}
		}
		
		if(V % 2 == 1) {
			//vertical flip
			//i is the index of row
			for(int i = 0; i < 2; i++) {
				int temp = matrix[i][0];
				matrix[i][0] = matrix[i][1];
				matrix[i][1] = temp;
			}
		}
		
		if(H % 2 == 1) {
			//horizontal flip
			//i is the index of column
			for(int i = 0; i < 2; i++) {
				int temp = matrix[0][i];
				matrix[0][i] = matrix[1][i];
				matrix[1][i] = temp;
			}
		}
		
		System.out.println(matrix[0][0] + " " + matrix[0][1]);
		System.out.println(matrix[1][0] + " " + matrix[1][1]);
		
	}
	
	

}
