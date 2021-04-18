package mock;

import java.util.*;

public class Q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> motels = new ArrayList<>();
		//0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000
		motels.add(0);
		motels.add(990);
		motels.add(1010);
		motels.add(1970);
		motels.add(2023);
		motels.add(2940);
		motels.add(3060);
		motels.add(3930);
		motels.add(4060);
		motels.add(4970);
		motels.add(5030);
		motels.add(5990);
		motels.add(6010);
		motels.add(7000);
		
		Scanner sc = new Scanner(System.in);
		int min = sc.nextInt();
		int max = sc.nextInt();
		int n = sc.nextInt();
		
		while(n-- > 0) {
			motels.add(sc.nextInt());
		}
		
		Collections.sort(motels);//Arrays.sort(arr);
		
		int[] dp = new int[motels.size()];
		dp[0] = 1;
		
		for(int i = 1; i < motels.size()/* motels.get(i) <= 7000*/; i++) {
			for(int j = i - 1; j >= 0; j--) {
				int d = motels.get(i) - motels.get(j);
				if(d >= min && d <= max) {
					dp[i] += dp[j];
				}else if(d > max){
					break;
				}
			}
		}
		
		System.out.println(dp[dp.length - 1]);
		
	}

}
