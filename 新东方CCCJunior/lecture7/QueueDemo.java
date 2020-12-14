import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer> q = new LinkedList<>();
		
		q.offer(1);
		q.offer(2);
		q.offer(3);
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		/*
		System.out.println(q.poll());
		System.out.println(q.peek());
		System.out.println(q.poll());
		System.out.println(q.size());*/
		
	}
		//	[[0,1]
		//	[1,2]
		//	[3,1]
		//	[0,2]]
		
		//requisite [0,1]
		//requisite [1,2]
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		
		int[][] matrix = new int[numCourses][numCourses];//by default, all zero
		int[] indegree = new int[numCourses];
		
		for(int[] requisite : prerequisites) {	
			int pre = requisite[1];
			int ready = requisite[0];
			
			matrix[pre][ready] = 1;
			indegree[ready]++;
		}
		
		int count = 0;
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i < numCourses; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {	
			int course = q.poll();
			count++;
			for(int i = 0; i < numCourses; i++) {
				if(matrix[course][i] == 1) {
					indegree[i]--;
					if(indegree[i] == 0) {
						q.offer(i);
					}
				}
			}
		}
		
		return count == numCourses;
	}

}
