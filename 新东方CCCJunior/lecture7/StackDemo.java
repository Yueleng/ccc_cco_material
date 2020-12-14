import java.util.ArrayList;
import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ArrayList<Integer> list = new ArrayList<>();
		
		
		Stack<Integer> s = new Stack<>();
		
		s.push(4);
		s.push(5);
		s.push(6);
		*/
		//System.out.println(s.pop());
		//System.out.println(s.peek());
		//System.out.println(s.size());
		
		//while(!s.isEmpty()) {
		//	System.out.println(s.pop());
		//}
		
		System.out.println(isValid("{}((])"));

	}
	//{}
	//(
	//(
	//
	public static boolean isValid(String brackets) {
		
		Stack<Character> s = new Stack<>();
		
		for(int i = 0; i < brackets.length(); i++) {
			char element = brackets.charAt(i);
			if(element == '(' || element == '{' || element == '[') {
				s.push(element);
			}else {
				
				//has more right than left
				if(s.isEmpty()) {
					return false;
				}
				char top = s.pop();
				if(!((top == '(' && element == ')') 
						|| (top == '{' && element == '}') 
						||(top == '[' && element == ']'))) {
					return false;
				}
			}
		}
		
		return s.isEmpty();
	}

}
