import java.util.Stack;

public class BaseballScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int calScore(String[] ops) {
		//["5", "-2", "C" ...]
		int sum = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(String operation : ops) {
			
			if(operation.equals("+")) {
				
				int a = stack.pop();
				int b = stack.pop();
				int n = a + b;
				sum += n;
				stack.push(b);
				stack.push(a);
				stack.push(n);
				
			}else if(operation.equals("C")) {
				
				int n = stack.pop();
				sum -= n;

			}else if(operation.equals("D")) {
				int n = stack.peek();
				n *= 2;//n = n * 2;
				stack.push(n);
				sum += n;
			}else {
				//is a number
				int n = Integer.parseInt(operation);
				stack.push(n);
				sum += n;
			}
		}
		
		return sum;
	}

}
