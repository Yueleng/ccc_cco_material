import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumacSequencesRecursive {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num1 = Integer.parseInt(br.readLine());
		int num2 = Integer.parseInt(br.readLine());
		System.out.println(sumacCount(num1, num2));
	}
	
	public static int sumacCount(int num1, int num2) {
		if (num1 < num2) 
			return 2;
		return 1 + sumacCount(num2, num1 - num2); 
	}

}