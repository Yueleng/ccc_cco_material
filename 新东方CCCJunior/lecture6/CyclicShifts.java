package demo;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class CyclicShifts {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String t = sc.nextLine();
		String s = sc.nextLine();
		sc.close();

		
		ArrayList<String> sCyclic = genCyclic(s);
		
		for (String cyclic: sCyclic) {
			if (t.indexOf(cyclic) >= 0) {
				System.out.println("yes");
				return ;
			}
		}
		
		System.out.println("no");
	}
	
	public static ArrayList<String> genCyclic(String s) {
		int sLen = s.length();
		
		ArrayList<String> sCyclic = new ArrayList<>();
		
		for (int i = 0; i < sLen; i++) {
			sCyclic.add(s.substring(i) + s.substring(0,i));
		}
		return sCyclic;
	}

}
