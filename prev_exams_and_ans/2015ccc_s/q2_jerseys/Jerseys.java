import java.io.*;
import java.util.*;
import java.util.stream.*;



public class Jerseys {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int j = Integer.parseInt(br.readLine());

        int a = Integer.parseInt(br.readLine());

        String[] sizes = new String[j+1];

        for (int i = 1; i <= j; i++) {
            sizes[i] = br.readLine();
        }

        int requestedSatisfied = 0;
        for (int i = 1; i <= a; i++) {
            String[] info = br.readLine().split(" ");
            int number = Integer.parseInt(info[1]);
            String line = info[0];
            
            if (!sizes[number].equals("T")) {
                if (line.equals("S") 
                || line.equals(sizes[number]) 
                || (line.equals("M") && sizes[number].equals("L"))) {
                    requestedSatisfied += 1;
                    sizes[number] = "T";
                }
            }
        }

        System.out.println(requestedSatisfied);

    }
    
}
