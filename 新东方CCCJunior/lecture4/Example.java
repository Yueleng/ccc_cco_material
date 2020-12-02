package lecture4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
	
public class Example {

	public static void main(String[] args) {
		// INDEX OF
		System.out.println("---INDEX OF---");
		System.out.println("ABCDEFGDEFG".indexOf('A'));
		System.out.println("ABCDEFGDEFG".indexOf("DE")); // first occurrence
		System.out.println("ABCDEFGDEFG".indexOf("DEG")); // -1
		
		System.out.println("--- Differene between Array and ArrayList ---");
		boolean[] boolArr = new boolean[5];
		int[] intArr = new int[5];
		double[] doubleArr = new double[5];
		char[] charArr = new char[5];
		String[] stringArr = new String[5];
		
		// ArrayList<String> stringList = new ArrayList<String>(); 
		ArrayList<String> stringList = new ArrayList<>();
		ArrayList<Object> objectList = new ArrayList<>();
		ArrayList<Integer> integerList = new ArrayList<>(); // wrapper class; int -> Integer.
		ArrayList<Boolean> boolList = new ArrayList<>(); // wrapper class; boolean -> Boolean.
		ArrayList<Double> doubleList = new ArrayList<>(); // wrapper class; double -> Double.
		
		System.out.println("--- Insert element into ---");
		intArr[0] = 2;
		charArr[1] = 'T';
		
		System.out.println("intArr length: " + intArr.length); // attribute
		
		System.out.println("stringList length: " + stringList.size()); // method
		stringList.add("ABC");
		System.out.println("stringList length: " + stringList.size()); // method
		
		System.out.println("--- Arrays sort and Collections sort ---");
		int[] intArr1 = {6, 7, 2, 3, 4, 1, -1, -3}; // Syntactic sugar
		Arrays.sort(intArr1); 
		System.out.println(Arrays.toString(intArr1));
		
		String[] stringArr1 = {"ilovejava", "lovejava", "ovejava", "zebra", "apple", "i"};
		Arrays.sort(stringArr1);
		System.out.println(Arrays.toString(stringArr1));
		
		char[] charArr1 = {'B', 'e', 'c', 'b', 'a', 'A'};
		Arrays.sort(charArr1);
		System.out.println(Arrays.toString(charArr1));
		
		ArrayList<Integer> integerList1 = new ArrayList<>();
		integerList1.add(1);
		integerList1.add(3);
		integerList1.add(2);
		Collections.sort(integerList1);
		System.out.println(integerList1);
		
		System.out.println("--- Advanced Sort ---");
		String[] stringArr2 = {"ilovejava", "lovejava", "ovejava", "zebra", "apple", "i"};
		Arrays.sort(stringArr2, Collections.reverseOrder());
		System.out.println(Arrays.toString(stringArr2));
		
		Collections.sort(integerList1, Collections.reverseOrder());
		System.out.println(integerList1);
		
		ArrayList<int[]> info = new ArrayList<>();
		// syntactic sugar
		//		int[] abc = {1,2,3};
		//		info.add(abc);
		info.add(new int[]{1,2,3});
		info.add(new int[]{1,2,4});
		info.add(new int[]{3,2,4});
		info.add(new int[]{-1,2,0});
		// [{1,2,3}, {1,2,4}, {3,2,4}, {-1,2,0}]
		Collections.sort(info, new SortByEleInOrder());
		info.forEach(e -> {System.out.print(Arrays.toString(e) + ", ");});
		System.out.println();
		
		// Two Pointer Algorithm;
		System.out.println("--- Two pointers in arrays ---");
		int arr[] = {3, 5, 9, 2, 8, 10, 11};
		
		int val = 17;
		
		int arrSize = arr.length;
		
		System.out.println(Arrays.toString(isPairSum(arr, arrSize, val)));
		
		
		
		
	}
	
	public static int[] isPairSum(int A[], int N, int x) {
		int i = 0;
		
		int j = N - 1;
		
		while (i < j) {
			if (A[i] + A[j] == x)
				return new int[]{i, j};
			else if (A[i] + A[j] < x)
				i++;
			else 
				j--;
		}
		
		return new int[] {-1, -1};
	}
}


class SortByEleInOrder implements Comparator<int[]> {
	public int compare(int[] intArr1, int[] intArr2) {
		for (int i = 0; i < intArr1.length; i++) {
			if (intArr1[i] != intArr2[i]) return intArr1[i] - intArr2[i];
		}
		return 1;
	}
}