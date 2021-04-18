
import java.util.*;
import java.io.*;
public class Othello {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String config = input[0];
        
        Board board = new Board(config);
        
    }
    
}

class Board {
    private int[][] array = new int[][]{new int[8], new int[8], new int[8], new int[8], new int[8], new int[8], new int[8], new int[8]};
    private int blackCount;
    private int whiteCount;
    // Constructor;
    public Board(String config) {
        if (config.equals("a")) {
            this.array[3][3] = 2;
            this.array[3][4] = 1;
            this.array[4][3] = 1;
            this.array[4][4] = 2;

        } else if (config.equals("b")) {
            for(int x = 0; x < 8; ++x) {
                this.array[x][x] = 1; // 1: black
                int whiteCounter = 7 - x;
                this.array[x][whiteCounter] = 2; // 2: white
            }

        } else if (config.equals("c")) {
            for(int x = 0; x < 8; ++x) {
                this.array[x][2] = 1; // 
                this.array[x][3] = 1;
                this.array[x][4] = 2;
                this.array[x][5] = 2;
            }

        }
    }

    public void move(int x, int y, int index) {
        // update array

    }

    public int getNumOfBlack() {
        return blackCount;
    }

    public int getNumOfWhite() {
        return whiteCount;
    }



}