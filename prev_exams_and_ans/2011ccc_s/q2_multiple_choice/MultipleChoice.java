import java.io.*;
public class MultipleChoice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] tAns = new char[n];
        char[] sAns = new char[n];
        for (int i = 0; i < n; i++) {
            tAns[i] = br.readLine().charAt(0);
        }

        for (int i = 0; i < n; i++) {
            sAns[i] = br.readLine().charAt(0);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (tAns[i] == sAns[i])
                cnt++;
        }

        System.out.println(cnt);
    }
}
