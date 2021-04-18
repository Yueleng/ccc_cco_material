import java.io.*;
import java.util.*;

public class AromaticNumbers {
    public static HashMap<Character, Integer> symbolValues = new HashMap<>();
    public static void main(String[] args) throws IOException {
        symbolValues.put('I', 1);
        symbolValues.put('V', 5);
        symbolValues.put('X', 10);
        symbolValues.put('L', 50);
        symbolValues.put('C', 100);
        symbolValues.put('D', 500);
        symbolValues.put('M', 1000);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String symbols = br.readLine();
        boolean[] plusMinus = new boolean[symbols.length()/2];
        for (int i = 0; i < symbols.length(); i += 2) {
            if (i == 0) plusMinus[i / 2] = true;
            else {
                if (i == symbols.length() - 2) plusMinus[i / 2] = true;
                
                int currentIdx = i + 1;
                int prevIdx = i - 2 + 1;
                if (symbolValues.get(symbols.charAt(currentIdx)) <= symbolValues.get(symbols.charAt(prevIdx)))
                    plusMinus[(i - 2) / 2] = true;
                else 
                    plusMinus[(i - 2) / 2] = false;
            }
        }

        // for (int i = 0; i < symbols.length() / 2; i++)
        //     System.out.println(plusMinus[i]);


        int sum = 0;
        for (int i = 0; i < symbols.length(); i += 2) {
            if (plusMinus[i / 2]) sum += symbolValues.get(symbols.charAt(i+1)) * Integer.parseInt(symbols.charAt(i)+"");
            else 
                sum -= symbolValues.get(symbols.charAt(i+1)) * Integer.parseInt(symbols.charAt(i)+"");
        }
        System.out.println(sum);
    }


}