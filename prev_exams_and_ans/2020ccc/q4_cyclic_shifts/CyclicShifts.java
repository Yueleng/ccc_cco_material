import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CyclicShifts {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String t = br.readLine();
        String s = br.readLine();

        // int t_len = t.length();
        // int s_len = s.length();

        ArrayList<String> s_cyclic = genCyclic(s);
        

        // WHY ??
        // for (int i = 0; i < t_len - s_len; i++) {
        //     if (s_cyclic.contains(t.substring(i, i + s_len))) {
        //         System.out.println("yes");
        //         return ;
        //     }
        // }

        for (String cyclic : s_cyclic) {
            if (t.indexOf(cyclic) >= 0) {
                System.out.println("yes");
                return ;
            }
        }

        System.out.println("no");
        return ;
    }
    
    public static ArrayList<String> genCyclic(String s) {
        int s_len = s.length();
        
        // String[] s_cyclic = new String[s_len];

        ArrayList<String> s_cyclic = new ArrayList<String>();

        for (int i = 0; i < s_len; i++) {
            s_cyclic.add(s.substring(i) + s.substring(0, i));
        }
        
        return s_cyclic;
    }
}