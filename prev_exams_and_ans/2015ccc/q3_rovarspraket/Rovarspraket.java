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
			} else /* isConsonant */ {
				outputString += transform(c); 
			}
		}
		System.out.println(outputString);
		
//		System.out.println(nearestVowel('j'));
	}
	
	public static boolean isVowel(char c) {
		return "aeiou".indexOf(c) >= 0;
	}
	
	public static String transform(char c) {
		return "" + c + nearestVowel(c) + nextConsonant(c);
	}
	
	public static char nextConsonant(char c) {
		int indexOfC = alphabet.indexOf(c);
		for (int i = indexOfC + 1; i < alphabet.length(); i++) {
			char nextChar = alphabet.charAt(i);
			if (!isVowel(nextChar))
				return nextChar;
		}
		return 'z';
	}
	
	public static char nearestVowel(char c) {
		int idxOfC = alphabet.indexOf(c);
		int idxOfNextVowel = 100;
		int idxOfPrevVowel = -100;
		for (int i = idxOfC - 1; i >= 0; i--) {
			if (isVowel(alphabet.charAt(i))) {
				idxOfPrevVowel = i;
				break; // can be tested on class
			}
		}
		
		for (int i = idxOfC + 1; i < alphabet.length(); i++) {
			if (isVowel(alphabet.charAt(i))) {
				idxOfNextVowel = i;
				break; // can be tested on class
			}
		}
		
		return (idxOfC - idxOfPrevVowel <= idxOfNextVowel - idxOfC) 
				? alphabet.charAt(idxOfPrevVowel) 
				: alphabet.charAt(idxOfNextVowel);
	}
}
