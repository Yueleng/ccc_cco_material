import java.util.ArrayList;
import java.util.Scanner;

public class From1987To2013 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int year = sc.nextInt();
		
		String yearStr = String.valueOf(++year);
		
		boolean found = false;
		
		while(!found) {
			
			found = true;
			ArrayList<Character> uniq = new ArrayList<>();
			
			for(int i = 0; i < yearStr.length(); i++) {
				
				if(uniq.contains(yearStr.charAt(i))) {
					found = false;	
					break;
				}else {
					uniq.add(yearStr.charAt(i));
				}
						
			}
			
			if(!found) {
				year++;
				yearStr = String.valueOf(year);
			}
				
		}
		
		System.out.println(year);
	}
	

}
