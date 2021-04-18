package codeII;

import java.util.*;

public class KnightHopBFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int fx = sc.nextInt();
		int fy = sc.nextInt();
		
		Queue<Integer> xQ = new LinkedList<>();
		Queue<Integer> yQ = new LinkedList<>();
		
		int[] dx = {1,1,2,2,-1,-1,-2,-2};
		int[] dy = {2,-2,1,-1,2,-2,1,-1};
		
		//{1,-1,0,0};
		//{0,0,1,-1};
		
		int step = 0;
		boolean flag = false;
		
		xQ.add(x);
		yQ.add(y);
		
		while(true) {
			
			Queue<Integer> newxQ = new LinkedList<>();
			Queue<Integer> newyQ = new LinkedList<>();
			
			while(!xQ.isEmpty()) {
				
				x = xQ.poll();
				y = yQ.poll();
				
				if(x == fx && y == fy) {
					flag = true;
					break;
				}
				
				for(int i = 0; i < 8; i++) {
					int newx = x + dx[i];
					int newy = y + dy[i];
					
					if(newx < 1 || newy < 1 || newx > 8 || newy > 8) {continue;}
					newxQ.add(newx);
					newyQ.add(newy);
				}
			}
			
			if(flag) {break;}
			
			xQ = newxQ;
			yQ = newyQ;
			step++;
		}
		System.out.println(step);
	}

}
