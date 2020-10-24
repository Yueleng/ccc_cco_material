import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Art {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int numOfLines = Integer.parseInt(br.readLine());
        
        int leftbottom_x = 101;
        int leftbottom_y = 101;
        int righttop_x = -1;
        int righttop_y = -1;
        
        for (int i = 0; i < numOfLines; i++) {
            String[] lineVector;
            
            lineVector = br.readLine().split(",");
            
            int[] lineVectorInt = new int[2];
            lineVectorInt[0] = Integer.parseInt(lineVector[0]);
            lineVectorInt[1] = Integer.parseInt(lineVector[1]);
            if (lineVectorInt[0] <= leftbottom_x) {
                leftbottom_x = lineVectorInt[0] - 1;
            } 
            
            if (lineVectorInt[0] >= righttop_x) {
                righttop_x = lineVectorInt[0] + 1;
            }
            
            if (lineVectorInt[1] <= leftbottom_y) {
                leftbottom_y = lineVectorInt[1] - 1;
            }
            
            if (lineVectorInt[1] >= righttop_y) {
                righttop_y = lineVectorInt[1] + 1;
            }
        }
        
        System.out.println(leftbottom_x + "," + leftbottom_y);
        System.out.println(righttop_x + "," + righttop_y);
        
    }
}