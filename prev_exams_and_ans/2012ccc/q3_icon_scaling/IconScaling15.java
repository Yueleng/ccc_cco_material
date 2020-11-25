import java.util.Scanner;
import java.io.IOException;

public class IconScaling15 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
        int scale = sc.nextInt();
        sc.close();
		
		String[] templates = {"*x*", " xx", "* *"};
		
		for (String template: templates) {
			String line = "";
			for (char c: template.toCharArray()) {
				 line += (c + "").repeat(scale);
			}
			for (int i = 1; i <= scale; i++)
				System.out.println(line);
		}
	}
}