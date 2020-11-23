package lecture2;

import java.util.Scanner;

public class LectureOneReview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		System.out.println("---Casting---");
		int i = 0;
		double d = i;
		System.out.println("double d: " + d); // int -> double automatic
		
		double dd = 22.7;
		int ii = (int) dd; 
		System.out.println("int ii: " + ii);
		
		// char -> int -> float -> double: Automatic
		// double -> float -> int -> char: Narrow Casting (manually)
		
		System.out.println("'a' + 2: " + ('a' + 2)); // char + int => (char -> int) + int
		
		int ia = 'a';
		System.out.println("'a' to int: " + ia);
		
		// Math
		System.out.println("---Math---");
		int i1 = 10 / 5;
		System.out.println("10 / 5: " + i1);
		
		int i2 = (int)(10 / 3.0);
		// 10 / 3.0 => 10.0 / 3.0 => 3.3333... => has to use mannually casting
		System.out.println("10 / 3: " + i2);
		
		
		int i3 = 10 % 3;
		System.out.println("10 % 3: " + i3);
		
		// Math Package or Math.* API
		System.out.println("---Math.*(No need to import any outside package(s))---");
		System.out.println("Maximum of 10 and 100: " + Math.max(10, 100));
		System.out.println("Minumum of 10 and 100: " + Math.min(10, 100));
		System.out.println("Square root of 2: " + Math.sqrt(2));
		System.out.println("Absolute value of -2: " + Math.abs(-2));
		System.out.println("Floor of 2.3: " + Math.floor(2.3));
		System.out.println("Floor of -2.3: " + Math.floor(-2.3));
		System.out.println("Ceil of 2.3: " + Math.ceil(2.3));
		System.out.println("Ceil of -2.3: " + Math.ceil(-2.3));
		System.out.println("2^3: " + (int) Math.pow(2, 3));
		
		
		// String Method or String API
		// primitive type: 
		// String: Object == char, char, char, char, char
		System.out.println("---String API---");
		String s1 = "ireallylovejava";
		char c = s1.charAt(1);
		System.out.println("`ireallylovejava` index 1 is: " + c);
		
		String s2 = "ABC";
		String s3 = "ABC";
		
		boolean equalsOrNot = s2.equals(s3);
		System.out.println("Result of string comparison: " + equalsOrNot);
		
//		boolean equalsOrNot2 = (s2 == s3); // NOT RECOMMENDED
//		System.out.println("Result of string comparison using `==`: " + equalsOrNot2);
		
		String subOfS1 = s1.substring(1 /*startIndex*/, 2/*endIndex*/); // [1, 2): 
		System.out.println("subOfS1: " + subOfS1); // "r" != 'r' => [r] != r
		
		String sub2OfS1 = s1.substring(1); // [1, +infinity]
		System.out.println("sub2OfS1: " + sub2OfS1);
		
		System.out.println("`ireallylovejava` lenth is: " + s1.length());
		
	}

}
