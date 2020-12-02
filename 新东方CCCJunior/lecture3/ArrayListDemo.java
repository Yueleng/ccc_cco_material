package class3;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> list = new ArrayList<>();
		
		list.add("First");
		
		list.add("Hello");
		
		System.out.println(list.get(0));
		
		System.out.println(list.size());
		
		System.out.println(list.contains("First"));
		System.out.println(list.remove("First"));
		System.out.println(list.contains("First"));
		
		System.out.println(list.size());
	}

}
