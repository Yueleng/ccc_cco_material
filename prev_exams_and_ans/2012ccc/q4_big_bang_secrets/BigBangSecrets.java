import java.util.Scanner;
import java.io.IOException;


public class BigBangSecrets {

    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        String codes = sc.next();
        sc.close();

        String outputString = "";
        for (int i = 0; i < codes.length(); i++) {
            outputString += decode(codes.charAt(i), i+1/* position in codes */, K);
        }
        System.out.println(outputString);
    }

    public static char decode(char c, int idx, int paramK) {
        int alphaIdx = alphabet.indexOf(c);

        // get original idx of char s
        while (alphaIdx - 3 * idx - paramK < 0) {
            alphaIdx += alphabet.length();
        }

        return alphabet.charAt(alphaIdx - 3 * idx - paramK);
    }
}
