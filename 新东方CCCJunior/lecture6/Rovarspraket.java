package demo;

import java.io.IOException;
import java.util.Scanner;

public class Rovarspraket {

	private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		sc.close();
		
		String outputString = "";
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (isVowel(c)) {
				outputString += c;
			} else /*isConsonant*/ {
				outputString += transform(c);
			}
		}
		System.out.println(outputString);
	}
	
	public static boolean isVowel(char c) {
//		if ("aeiou".indexOf(c) >= 0)
//			return true;
//		else 
//			return false;
		return "aeiou".indexOf(c) >= 0;
	}
	
	public static String transform(char c) {
		return "" + c + nearestVowel(c) + nextConsonant(c);
		
	}
	
	public static char nearestVowel(char c) {
		int indexOfC = alphabet.indexOf(c);
		
		int idxOfPrevVowel = -1000;
		int idxOfNextVowel = 1000;
		
		for (int i = indexOfC - 1; i >= 0; i--) {
			if (isVowel(alphabet.charAt(i))) {
				idxOfPrevVowel = i;
				break;
			}
		}
		
		for (int i = indexOfC + 1; i < alphabet.length(); i++) {
			if (isVowel(alphabet.charAt(i))) {
				idxOfNextVowel = i;
				break;
			}
		}
		
		return indexOfC - idxOfPrevVowel <= idxOfNextVowel - indexOfC
			    ? alphabet.charAt(idxOfPrevVowel)
			    : alphabet.charAt(idxOfNextVowel);
	}
	
	public static char nextConsonant(char c) {
		int indexOfC = alphabet.indexOf(c);
		for (int i = indexOfC + 1; i < alphabet.length(); i++) {
			char nextChar = alphabet.charAt(i);
			if (!isVowel(nextChar)) {
				return nextChar;
			}
		}
		return 'z';
	}

}
