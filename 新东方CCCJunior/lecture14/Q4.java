package mock;

import java.util.*;

public class Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		sc.nextLine();
		String decode = sc.nextLine();
		
		String res = "";
		
		//S = 3P + K
		for(int i = 0; i < decode.length(); i++) {
			
			int P = i + 1;
			int S = 3 * P + K;
			
			char c = decode.charAt(i);
			
			//ABCDEFG...
			//F -> 3*1+3 = 6
			//A = 0 F = 5 -> -1 Z
			//-2 Y
			//-3 X
			if(c - S < 'A') {
				//trace back to ZYXW...
				res += (char)(c-S+26);
			}else {
				res += (char)(c-S);
			}
		}
		
		System.out.println(res);

	}

}
