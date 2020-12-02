package lecture4;
import java.util.Scanner;
import java.io.IOException;

// DRY: Don't Repeat Yourself.

public class IconScaling2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// int scale = Integer.parseInt(sc.nextLine());
		int scale = sc.nextInt();
		sc.close();
		
		String[] templates = {"*x*", " xx", "* *"};
		
		for (String template: templates) {
			String line = "";
			for (char c: template.toCharArray())
				// "*x*" -> {'*', 'x', '*'}
				line += repeat(c, scale);
			
			for (int i = 1; i <= scale; i++)
				System.out.println(line);
		}	
	}
	
	public static String repeat(char s, int n) {
		String outputString = ""; 
		for (int i = 1; i <= n; i++) {
			outputString += s;
		}
		return outputString;
	}
}
