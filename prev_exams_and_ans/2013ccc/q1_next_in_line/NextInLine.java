import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NextInLine {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int yongest = Integer.parseInt(br.readLine());
		int middle = Integer.parseInt(br.readLine());
		
		System.out.println(middle + (middle - yongest));
	}
}
