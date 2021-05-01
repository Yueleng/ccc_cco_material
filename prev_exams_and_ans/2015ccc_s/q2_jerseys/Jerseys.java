import java.io.*;
import java.util.*;
import java.util.stream.*;



public class Jerseys {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // number of jerseys
        int j = Integer.parseInt(br.readLine());

        // number of athletes
        int a = Integer.parseInt(br.readLine());

        // sizes array contains sizes information
        String[] sizes = new String[j+1];

        for (int i = 1; i <= j; i++) {
            sizes[i] = br.readLine();
        }

        // set output satisfied to be 0 by default.
        int requestedSatisfied = 0;
        for (int i = 1; i <= a; i++) {

            // requirement information
            String[] info = br.readLine().split(" ");
            
            // number: jersey number,  line: size info
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
