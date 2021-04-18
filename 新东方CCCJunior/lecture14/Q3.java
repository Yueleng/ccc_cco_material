package mock;

import java.util.*;

public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		//[3,4] -> len = 2 int array
		List<int[]> list = new ArrayList<>();
		
		//string -> char[]
		//char : char[]
		for(char c : s.toCharArray()) {
			if(c == ' ') {
				list.add(new int[] {2,4});
			}else if(c == '-') {
				list.add(new int[] {3,4});
			}else if(c == '.') {
				list.add(new int[] {4,4});
			}else {
				list.add(new int[] {(c - 'A')%6, (c - 'A')/6});
			}
		}
		
		list.add(new int[] {5,4});
		int[] prev = new int[]{0,0};
		int total = 0;

		for(int[] coord: list) {		
			total += Math.abs(coord[0] - prev[0]);
			total += Math.abs(coord[1] - prev[1]);
			prev = coord;
		}
		
		System.out.println(total);
	}

}
