import java.io.*;

public class DontPassMeTheBall {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n <= 3) {
            System.out.println(0);
            return;
        } else {
            System.out.println((n-1) * (n-2) * (n-3) / 6);  // C^{N-1}_3
        }
    }
}
