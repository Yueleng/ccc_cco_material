import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class ColdCompress {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int numOfLines = Integer.parseInt(sc.nextLine());
		
		String[] restStrArr = new String[numOfLines];
		for (int i = 0; i < numOfLines; i++) {
			String restString = sc.nextLine();
			restStrArr[i] = restString;
		}
		
		sc.close();
		
		for (int i = 0; i < numOfLines; i++) {
			ArrayList<String> cum = new ArrayList<>();
			System.out.println(coldCompress(cum, restStrArr[i]));
		}
	}
	
	public static String coldCompress(ArrayList<String> cum, String rs) {
		int N = cum.size();
		
		// EXIT
		if (rs.equals("")) {
			String listString = "";
			for (String s: cum) {
				listString += s + " ";
			}
			return listString;
		}
		
		// Relationship
		if ( N >= 2 && cum.get(N-1).equals(rs.substring(0,1)) ) {
			int lastCumCount = Integer.parseInt(cum.get(N-2));
			lastCumCount++;
			cum.set(N-2, lastCumCount+"");
			return coldCompress(
				cum,
				rs.substring(1, rs.length())
			);
		} else {
			cum.add("1");
			cum.add(rs.substring(0, 1));
			return coldCompress(
				cum, 
				rs.substring(1, rs.length())
			);
		}
	}

}