import java.io.*;


// this is a string exercise. Starting from either end find the 
// smaller group of 1's. Then turn on a single light next to that group
// on the side closest to the center. If groups of 4 or more are created,
// switch them off. Repeat. Done.
public class Switch {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = "";
        for (int i = 0; i < n; i++)
            s += br.readLine();
        int count = 0;
        while (!done(s)) {
            s = turnOnNext(s);
            count += 1;
            s = switchOff(s);
        }
        System.out.println(count);
    }

    // at most seven 1's. why?
    public static String switchOff(String s) {
        s = s.replace("1111111", "0000000");
        s = s.replace("111111", "000000");
        s = s.replace("11111", "00000");
        s = s.replace("1111", "0000");
        return s;
    }

    public static boolean done(String s) {
        return s.indexOf("1") < 0;
    }

    public static String turnOnNext(String s) {
        int left = s.indexOf("10");
        int leftPosition = -1;
        int leftSize = 9999;
        if (left >= 0) {
            leftPosition = left + 1;
            leftSize = 0;
            // get all the 1 before 10,  i.e. if 110, then we have leftSize 2
            while (left >= 0 && s.charAt(left) == '1') {
                left = left - 1;
                leftSize += 1;
            }
        }

        int right = s.lastIndexOf("01");
        int rightPosition = -1;
        int rightSize = 99999;

        if (right > 0) {
            rightPosition = right; // no need to -1. why?
            rightSize = 0;
            right = right + 1;
            while (right < s.length() && s.charAt(right) == '1') {
                right = right + 1;
                rightSize += 1;
            }
        }

        // replace 1 char
        if (leftPosition > 0 && leftSize <= rightSize)
            s = s.substring(0, leftPosition) + "1" + s.substring(leftPosition + 1);
        else 
            s = s.substring(0, rightPosition) + "1" + s.substring(rightPosition + 1);
        
        return s;
    }


}