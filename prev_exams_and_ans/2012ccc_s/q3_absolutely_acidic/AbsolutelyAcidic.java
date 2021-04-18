import java.io.*;
import java.util.*;

public class AbsolutelyAcidic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Info[] freq = new Info[1001];

        for (int i = 0; i <= 1000; i++) {
            Info info = new Info(i, 0);
            freq[i] = info;
        }

        for (int i = 0; i < n; i++) {
            int r = Integer.parseInt(br.readLine());
            freq[r].count += 1;
        }

        Arrays.sort(freq, Collections.reverseOrder());
        
        boolean multiHigh = (freq[0].count == freq[2].count);
        boolean multiSecHigh = (freq[0].count != freq[1].count && freq[1].count == freq[2].count);

        if (multiHigh) {
            int i = 1;
            while (i <= 1000 && freq[0].count == freq[i].count)
                i += 1;
            System.out.println(Math.abs(freq[0].reading - freq[i].reading));
        } else if (multiSecHigh) {
            int i = 3;
            int m = Math.abs(freq[0].reading - freq[1].reading);
            while (i <= 1000 && freq[1].count == freq[i].count) {
                m = Math.max(m, Math.abs(freq[0].reading - freq[i].reading));
                i += 1;
            }
            System.out.println(m);
            // while( i <= 1000 && freq[1].count == freq[i].count)
            //     i +=1;
            // int m = Math.max(
            //     Math.abs(freq[0].reading - freq[1].reading),
            //     Math.abs(freq[0].reading - freq[i].reading)
            // );
            // System.out.println(m);
        } else {
            System.out.println(Math.abs(freq[0].reading - freq[1].reading));
        }
    }
}


class Info implements Comparable<Info> {
    int reading;
    int count;

    public Info(int r, int c) {
        this.reading = r;
        this.count = c;
    }

    @Override
    public int compareTo(Info that) {
        if (this.count != that.count)
            return this.count - that.count;
        else 
            return this.reading - that.reading;
    }
}