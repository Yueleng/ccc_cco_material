package class3;

import java.util.Scanner;

public class MagicSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int[][] square = new int[4][4];
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				square[i][j] = sc.nextInt();
			}
		}
		
		int sum = 0;
		
		for(int i = 0; i < 4; i++) {sum += square[0][i];}
		
		//check sum of each row
		//i is the index of row
		for(int i = 1; i < 4; i++) {
			int tempSum = 0;
			for(int j = 0; j < 4; j++) {
				tempSum += square[i][j];
			}
			if(sum != tempSum) {
				System.out.println("not magic");
				return ;
			}
		}
		
		//check sum of each column
		//i is the index of column
		for(int i = 0; i < 4; i++) {
			int tempSum = 0;
			for(int j = 0; j < 4; j++) {
				tempSum += square[j][i];
			}	
			if(sum != tempSum) {
				System.out.println("not magic");
				return ;
			}
		}
		System.out.println("magic");
	}

}
