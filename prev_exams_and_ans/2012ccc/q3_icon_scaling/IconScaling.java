import java.util.Scanner;
import java.io.IOException;

// Topic: toCharArray; loop through string; string repeat; 

public class IconScaling {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
        int scale = sc.nextInt();
        sc.close();
		
		String[] templates = {"*x*", " xx", "* *"};
		
		for (String template: templates) {
			String line = "";
			for (char c: template.toCharArray()) {
				 line += repeat(c, scale);
			}
			for (int i = 1; i <= scale; i++)
				System.out.println(line);
		}
//		
//		for (int i = 1; i <= 3 * scale; i++) {
//			for (int j = 1; j <= 3 * scale; j++) {
//				if (i <= scale) {
//					if (j <= scale) {
//						System.out.print("*");
//					} else if (j >= scale + 1 && j <= scale * 2) {
//						System.out.print("x");
//					} else if (j >= scale * 2 + 1) {
//						System.out.print("*");
//					}
//				} else if (i >= scale + 1 && i <= 2 * scale) {
//					if (j <= scale) {
//						System.out.print(" ");
//					} else if (j >= scale + 1 && j <= scale * 2) {
//						System.out.print("x");
//					} else if (j >= scale * 2 + 1) {
//						System.out.print("x");
//					}
//				} else if (i >= scale * 2 + 1) {
//					if (j <= scale) {
//						System.out.print("*");
//					} else if (j >= scale + 1 && j <= scale * 2) {
//						System.out.print(" ");
//					} else if (j >= scale * 2 + 1) {
//						System.out.print("*");
//					}
//				}
//			}
//			System.out.println();
//		}
		
	}

	
	public static String repeat(char s, int n) {
		String outputString = ""; 
		for (int i = 1; i <= n; i++) {
			outputString += s;
		}
		return outputString;
	}
}
