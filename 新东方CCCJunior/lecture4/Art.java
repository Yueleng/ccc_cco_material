package lecture4;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Art {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		String[] inputs = new String[n];
		
		for (int i = 0; i < n; i++) {
			inputs[i] = sc.nextLine();
		}
		
		sc.close();
		
		// int[] xs = new int[n];		
		ArrayList<Integer> xs = new ArrayList<>();
		ArrayList<Integer> ys = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			String input = inputs[i];
			// "44,62" ->[split(",")] {"44", "62"}
			// "44 62" ->[split(" ")] {"44", "62"}
			String[] pointStr = input.split(",");
			// xs[i] = Integer.parseInt(pointStr[0]);
			xs.add(Integer.parseInt(pointStr[0]));
			ys.add(Integer.parseInt(pointStr[1]));
		}
		
		Collections.sort(xs);
		Collections.sort(ys);

		System.out.println((xs.get(0) - 1) + "," + (ys.get(0)- 1));
		System.out.println((xs.get(xs.size()-1)+1) + "," + (ys.get(ys.size()-1)+1));
	}

}
