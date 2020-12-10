import java.util.Scanner;

public class BinaryNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//convert to binary
		//57 = 32 + 16 + 8 + 1
		//111001
		//57 / 2 = 28 ... 1
		//28 / 2 = 14 ... 0
		//14 / 2 = 7 ... 0
		//7 / 2 = 3 ... 1
		//3 / 2 = 1 ... 1
		//1 / 2 = 0 ....1
		
		//.....0 even
		//.....1 odd
		
		//1010 / 2 -> 101 / 2 -> 10 / 2 -> 1 / 2 
		//0 -> 1 -> 0 -> 1
		//101 * 2 -> 1010
		
		String binaryNumber = "";
		//1
		//01
		//001
		//1001
		//11001...
		
		while(n != 0){
			int r = n % 2;
			binaryNumber = r + binaryNumber;
			n /= 2;
		}
		
		System.out.println(binaryNumber);

	}

}
