import java.util.*;
import java.io.*;

public class BookArrange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String initArrange = br.readLine();
        int lCnt = (int) initArrange.chars().filter(ch -> ch == 'L').count();
        int mCnt = (int) initArrange.chars().filter(ch -> ch == 'M').count();
        int sCnt = (int) initArrange.chars().filter(ch -> ch == 'S').count();

        int lMissMatch = 0;
        int mMissMatch = 0;
        int sMissMatch = 0;

        for (int i = 0; i < lCnt; i++) {
            if (initArrange.charAt(i) != 'L')
                lMissMatch += 1;
        }

        for (int i = lCnt; i < lCnt + mCnt; i++) {
            if (initArrange.charAt(i) != 'M')
                mMissMatch += 1;
        }

        for (int i = lCnt + mCnt; i < lCnt + mCnt + sCnt; i++) {
            if (initArrange.charAt(i) != 'S')
                sMissMatch += 1;
        }

        int[] missMatch = new int[] {lMissMatch, mMissMatch, sMissMatch};
        Arrays.sort(missMatch);
        int a = missMatch[0];
        int b = missMatch[1];
        int c = missMatch[2];

        System.out.println((a+b-c)*2  + 2*c-(a+b));
    }
    
}
