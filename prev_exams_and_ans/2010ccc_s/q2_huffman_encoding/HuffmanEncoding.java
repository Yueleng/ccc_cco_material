
import java.util.*;
import java.io.*;

public class HuffmanEncoding {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // The first line of input will be an integer k (1≤k≤20),
        int k = Integer.parseInt(br.readLine());
	    char[] letter = new char [20];
	    String[] code = new String [20];

        // input section
        for (int i = 0; i < k; i++) {
            String[] info = br.readLine().split(" ");
            letter[i] = info[0].charAt(0);
            code[i] = info[1];
            

        }
        String binary = br.readLine();

        String decode = "";

        while (binary.length() > 0) {
            int i = 0;
            while (!binary.startsWith(code[i]))
                i++;
            
            decode += letter[i];
            binary = binary.substring(code[i].length());
        }

        System.out.println(decode);
    }
}
