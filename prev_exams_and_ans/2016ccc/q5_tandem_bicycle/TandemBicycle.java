import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class TandemBicycle {

	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
		int maxMinIndicator = sc.nextInt();
        int N = sc.nextInt();
        
        int dmo[] = new int[N];
        int peg[] = new int[N];

        for (int i = 0; i < N; i++)
            dmo[i] = sc.nextInt();

        for (int i = 0; i < N; i++)
            peg[i] = sc.nextInt();

        sc.close();

        Arrays.sort(dmo);
        Arrays.sort(peg);

		// if (maxMinIndicator == 2) {
		// 	System.out.println(maxSpd(dmo, peg));
		// } else if (maxMinIndicator == 1) {
		// 	System.out.println(minSpd(dmo, peg));	
        // }
        System.out.println(totalSpd(dmo, peg, maxMinIndicator));
    }
    
    public static int maxSpd(int[] arr1, int[] arr2) {
        int sum = 0;
        int arrLen = arr1.length;
        for (int i = 0; i < arrLen; i++) {
            sum += Math.max(arr1[i], arr2[arrLen-1-i]);
        }
        return sum;
    }

    public static int minSpd(int[] arr1, int[] arr2) {
        int sum = 0;
        int arrLen = arr1.length;
        for (int i = 0; i < arrLen; i++) {
            sum += Math.max(arr1[i], arr2[i]);
        }
        return sum;
    }

    public static int totalSpd(int[] arr1, int[] arr2, int indicator) {
        int sum = 0;
        int arrLen = arr1.length;
        for (int i = 0; i < arrLen; i++) {
            sum += Math.max(arr1[i], arr2[(indicator == 1) ? i : (arrLen - i - 1)]);
        }
        return sum;
    }
}