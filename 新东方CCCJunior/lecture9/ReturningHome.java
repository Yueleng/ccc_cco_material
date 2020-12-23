import java.util.LinkedList;
import java.util.Scanner;

public class ReturningHome {

	public static void main(String[] args)
	{
		LinkedList<String> path = new LinkedList<String>();
		Scanner sc = new Scanner(System.in);
		
		String next;
		
		do{
			next = sc.nextLine();
			path.addFirst(next);
		}while(!next.equals("SCHOOL"));
		
		path.stream().forEach(str->System.out.println(str));
		
		for(int i = 1; i < path.size()-1; i+=2) {
			if(path.get(i).equals("L")) {
				System.out.println("Turn RIGHT onto " + path.get(i+1) + " Street.");
			}else {
				System.out.println("Turn LEFT onto " + path.get(i+1) + " Street.");
			}
		}
		
		if(path.get(path.size()-1).equals("L")) {
			System.out.println("Turn RIGHT into your HOME.");
		}else {
			System.out.println("Turn LEFT into your HOME.");
		}	
	}
}
