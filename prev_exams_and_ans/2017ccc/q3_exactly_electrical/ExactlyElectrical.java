import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class ExactlyElectrical {
	public static void main (String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a[] = br.readLine().split(" ");
		String b[] = br.readLine().split(" ");
		int a1[] = new int [2];
		int b1[] = new int [2];
		for(int i = 0; i<2;i++) {
			a1[i] = Integer.parseInt(a[i]);
			b1[i] = Integer.parseInt(b[i]);
		}
		int h = a1[0]-b1[0];
		h = Math.abs(h);
		int z = a1[1]-b1[1];
		z = Math.abs(z);
		int input = Integer.parseInt(br.readLine());
		if(input < h+z || (input-h-z)%2!=0) {
			System.out.println("N");
		}else {
			System.out.println("Y");
		}
	}
}
