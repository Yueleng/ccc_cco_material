import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoringBusiness {
	private static boolean[][] grid = new boolean[200][401];
	private static int[] currentPos = {0, -1};
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		driveTo("d", 2);
		driveTo("r", 3);
		driveTo("d", 2);
		driveTo("r", 2);
		driveTo("u", 2);
		driveTo("r", 2);
		driveTo("d", 4);
		driveTo("l", 8);
		driveTo("u", 2);
		while (true) {
			String[] move = br.readLine().split(" ");
			if (move[0].equals("q")) {return;}
			else if (driveTo(move[0], Integer.parseInt(move[1]))) {
				System.out.println(currentPos[0] + " " + currentPos[1] + " safe");
			}
			else {
				System.out.println(currentPos[0] + " " + currentPos[1] + " DANGER");
				return;
			}
				
		}
	}

	public static boolean driveTo(String direction, int steps) {
		grid[-currentPos[1]-1][currentPos[0] + 200] = true;
		boolean isSafe = true;
		switch (direction) {
			case "l":
				for (int i = 1; i <= steps; i++) {
					if (grid[-currentPos[1]-1][currentPos[0] + 200 - i] == false) 
						grid[-currentPos[1]-1][currentPos[0] + 200 - i] = true;
					else {
						isSafe = false;
						break;
					}
						
				}
				currentPos[0] = currentPos[0] - steps;
				return isSafe;
			
			case "r":
				for (int i = 1; i <= steps; i++) {
					if (grid[-currentPos[1]-1][currentPos[0] + 200 + i] == false) 
						grid[-currentPos[1]-1][currentPos[0] + 200 + i] = true;
					else {
						isSafe = false;
						break;
					}
						
				}
				currentPos[0] = currentPos[0] + steps;
				return isSafe;
			
			case "d":
				for (int i = 1; i <= steps; i++) {
					if (grid[-currentPos[1]-1 + i][currentPos[0] + 200] == false) 
						grid[-currentPos[1]-1 + i][currentPos[0] + 200] = true;
					else {
						isSafe = false;
						break;
					}
				}
				currentPos[1] = currentPos[1] - steps;
				return isSafe;
			case "u":
				for (int i = 1; i <= steps; i++) {
					if (grid[-currentPos[1]-1 - i][currentPos[0] + 200] == false) 
						grid[-currentPos[1]-1 - i][currentPos[0] + 200] = true;
					else {
						isSafe = false;
						break;
					}
						
				}
				currentPos[1] = currentPos[1] + steps;
				return isSafe;
			
			default:
				return isSafe;
		}
	}
}
