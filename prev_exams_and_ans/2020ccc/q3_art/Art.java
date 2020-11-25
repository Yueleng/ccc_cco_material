import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Topic: geometry; 2d array; 

public class Art {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int numOfLines = Integer.parseInt(br.readLine());
        
        int leftBoundary = 101;
        int lowerBoundary = 101;
        int rightBoundary = -1;
        int upperBoundary = -1;
        
        for (int i = 0; i < numOfLines; i++) {
            String[] pointString;
            
            pointString = br.readLine().split(",");
            
            int[] point = new int[2];
            point[0] = Integer.parseInt(pointString[0]);
            point[1] = Integer.parseInt(pointString[1]);
            if (point[0] <= leftBoundary) {
                leftBoundary = point[0] - 1;
            } 
            
            if (point[0] >= rightBoundary) {
                rightBoundary = point[0] + 1;
            }
            
            if (point[1] <= lowerBoundary) {
                lowerBoundary = point[1] - 1;
            }
            
            if (point[1] >= upperBoundary) {
                upperBoundary = point[1] + 1;
            }
        }
        
        System.out.println(leftBoundary + "," + lowerBoundary);
        System.out.println(rightBoundary + "," + upperBoundary);
        
    }
}