package class3;

import java.util.Scanner;

public class AreWeThereYet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int[][] dis = new int[5][5];
		
		/*
		for(int i = 0; i < 5; i++) {
			dis[i][i] = 0;
		}*/
		
		int[] arr = new int[4];//{sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};

		for(int i = 0; i < 4; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i <= 3; i++) {
			dis[i][i+1] = arr[i];
			dis[i+1][i] = arr[i];
		}
		
		for(int i = 0; i <= 2; i++) {
			dis[i][i+2] = arr[i] + arr[i+1];
			dis[i+2][i] = arr[i] + arr[i+1];
		}
		
		for(int i = 0; i <= 1; i++) {
			dis[i][i+3] = arr[i] + arr[i+1] + arr[i+2];
			dis[i+3][i] = arr[i] + arr[i+1] + arr[i+2];
		}
		
		for(int i = 0; i <= 0; i++) {
			dis[i][i+4] = arr[i] + arr[i+1] + arr[i+2] + arr[i+3];
			dis[i+4][i] = arr[i] + arr[i+1] + arr[i+2] + arr[i+3];
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(dis[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
