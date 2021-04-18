import java.util.ArrayList;
import java.util.Scanner;

public class PatternGenerator {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		
		ArrayList<String[]> set = new ArrayList<>();

		while(n-- > 0) {
			set.add((sc.nextLine().split(" ")));
		}
		
		for(String[] num : set) {
			System.out.println("The bit patterns are\n");
			generatePattern(num);
			System.out.println();
		}
	}
	
	public static ArrayList<String> generatePattern(String[] nums){
		
		StringBuilder sb = new StringBuilder();
		ArrayList<String> res = new ArrayList<>();
	
		int n = Integer.parseInt(nums[1]);
		while(n-- > 0) {
			sb.append("1");
		}
		n = Integer.parseInt(nums[0]) - Integer.parseInt(nums[1]);
		while(n-- > 0) {
			sb.append("0");
		}
		
		String lastString = new StringBuilder(sb).reverse().toString();
		
		while(!sb.toString().equals(lastString)) {
			
			System.out.println(sb.toString());
			res.add(sb.toString());
	
			int lastOnePos;
			int i;
			for(i = sb.length() - 1; i > 0; i--) {
				if(sb.charAt(i) == '0' && sb.charAt(i-1) == '1') {
					break;
				}
			}
			lastOnePos = i;
			
			//System.out.println(lastOnePos);
			
			sb.replace(lastOnePos, lastOnePos+1, "1");
			sb.replace(lastOnePos-1, lastOnePos, "0");
			
			//System.out.println(sb.toString());
			
			for(int left = lastOnePos + 1, right = sb.length() - 1; left < right;) {
				
				char l = sb.charAt(right);
				char r = sb.charAt(left);
				
				sb.replace(left, left+1, l+"");
				sb.replace(right, right+1, r+"");
				
				left++;
				right--;
			}
			
		}
		System.out.println(sb.toString());
		res.add(sb.toString());
		return res;
	}

}
