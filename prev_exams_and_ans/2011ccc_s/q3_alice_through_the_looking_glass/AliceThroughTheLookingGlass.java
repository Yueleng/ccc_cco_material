import java.io.*;

public class AliceThroughTheLookingGlass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] info = br.readLine().split(" ");
            int m = Integer.parseInt(info[0]);
            int x = Integer.parseInt(info[1]);
            int y = Integer.parseInt(info[2]);
            if (isCrystal(x, y, m))
                System.out.println("crystal");
            else 
                System.out.println("empty");
        }
    }

    public static boolean isCrystal(int x, int y, int level) {
        int edgeSize = power(5, level-1);
        int portX = x / edgeSize;
        int portY = y / edgeSize;
        
        if ((portX == 1 || portX == 2 || portX == 3)  && portY == 0)
            return true;
        
        if (portX == 2 && portY == 1)
            return true;
        
        if ((portX == 1 && portY == 1) || (portX == 2 && portY == 2) || (portX == 2 && portY == 1)) {
            if (level == 1) 
                return false;
            return isCrystal(x - edgeSize * portX, y - edgeSize * portY, level - 1);
        }

        return false;
    }

    public static int power(int n, int p) {
        return (int) Math.pow(n, p);
    }

}
