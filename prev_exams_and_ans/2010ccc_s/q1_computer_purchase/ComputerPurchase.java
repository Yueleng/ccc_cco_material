import java.util.*;
import java.io.*;
public class ComputerPurchase {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Computer[] computers = new Computer[num];
        for (int i = 0; i < num; i++) {
            String[] info = br.readLine().split(" ");
            
            computers[i] = new Computer(
                info[0], 
                Integer.parseInt(info[1]), 
                Integer.parseInt(info[2]), 
                Integer.parseInt(info[3])
            );
        }
        Arrays.sort(computers, Collections.reverseOrder());
        if (computers.length >= 1)
            System.out.println(computers[0].name);
        if (computers.length >= 2)
            System.out.println(computers[1].name);
    }

    public static class Computer implements Comparable<Computer> {
        int RAM;
        int CPU;
        int DISK;
        String name;
    
        Computer(String name, int R, int S, int D) {
            this.name = name;
            this.RAM = R;
            this.CPU = S;
            this.DISK = D;
        }
    
        @Override
        public int compareTo(Computer that) {
            if (2 * this.RAM + 3 * this.CPU + this.DISK - 2 * that.RAM - 3 * that.CPU - that.DISK != 0) {
                return 2 * this.RAM + 3 * this.CPU + this.DISK - 2 * that.RAM - 3 * that.CPU - that.DISK;
            } 
            return -this.name.compareTo(that.name);
        }
    }
}