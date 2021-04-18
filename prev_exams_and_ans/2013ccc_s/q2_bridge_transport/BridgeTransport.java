import java.io.*;

public class BridgeTransport {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int capacity = Integer.parseInt(br.readLine());
        int totalCars = Integer.parseInt(br.readLine());
        int[] carWeight = new int[totalCars + 3];
        carWeight[0]=0; carWeight[1] = 0; carWeight[2] = 0;
        for (int i = 0; i < totalCars; i++) {
            carWeight[i+3] = Integer.parseInt(br.readLine());
        }
        int i = 3;
        int carsAcross = 0;
        int totalWeight = carWeight[i-3] + carWeight[i-2] + carWeight[i-1] + carWeight[i];
        while (totalWeight <= capacity) {
            carsAcross = carsAcross + 1;
            if (i == carWeight.length - 1) break;
            i += 1;
            totalWeight = carWeight[i-3] + carWeight[i-2] + carWeight[i-1] + carWeight[i];
        }
        System.out.println(carsAcross);
    }
    
}
