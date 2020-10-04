import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumacSequences {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num1 = Integer.parseInt(br.readLine());
		int num2 = Integer.parseInt(br.readLine());
		int count = 2;
		int diff = 0;
		while (num1 >= num2) {
			count++;
			diff = num1 - num2;
			num1 = num2;
			num2 = diff;
		}
		System.out.println(count);
	}

}
