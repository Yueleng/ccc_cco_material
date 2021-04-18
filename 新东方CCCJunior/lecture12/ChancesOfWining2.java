package ccc2013junior;

import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;

public class ChancesOfWining2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int G = sc.nextInt();
		int[] points = new int[5];
		LinkedList<String> games = new LinkedList<>();
		
		games.add("12"); games.add("13"); games.add("14");
		games.add("23"); games.add("24"); games.add("34");
		
		for (int i = 1; i <= G; i++) {
			int team1 = sc.nextInt();
			int team2 = sc.nextInt();
			int team1Score = sc.nextInt();
			int team2Score = sc.nextInt();
			
			// Scores Table Creation
			if (team1Score > team2Score) {
				points[team1] += 3;
			} else if (team1Score == team2Score) {
				points[team1] += 1;
				points[team2] += 1;
			} else {
				points[team2] += 3;
			}
			
			if (games.contains("" + team1 + team2))
				games.remove("" + team1 + team2);
		}
		
		System.out.println(simulate(games, points, "", 2, T));
		
//		int[] pst = new int[] {1,2,3};
//		int[] pst2 = Arrays.copyOf(pst, pst.length);
//		pst[2] = 100;
//		System.out.println(Arrays.toString(pst2));
	}
	
	private static int simulate(LinkedList<String> gamesLeft, int[] pts, String game, int w, int T) {
		int[] ptsCopy = Arrays.copyOf(pts, pts.length);
		
		LinkedList<String> gamesLeftCopy = new LinkedList<>(); 
		// gamesLeftCopy = (LinkedList<String>) gamesLeft.clone();
		gamesLeft.forEach(e -> gamesLeftCopy.add(e));
		
		if (w == 1) {
			ptsCopy[Character.getNumericValue(game.charAt(0))] += 3;
		} else if (w == 0) {
			ptsCopy[Character.getNumericValue(game.charAt(0))] += 1;
			ptsCopy[Character.getNumericValue(game.charAt(1))] += 1;
		} else if (w == -1) {
			ptsCopy[Character.getNumericValue(game.charAt(1))] += 3;
		}
		
		if (gamesLeft.size() == 0) {
			for (int i = 1; i <= 4; i++) {
				if (i != T) {
					if (ptsCopy[i] >= ptsCopy[T]) {
						return 0;
					}
				}
			}
			// System.out.println(game);
			return 1;
		} else {
			
			
			String oneGame = gamesLeftCopy.removeLast();
			
			int sum = 0;
			
	        
			for (int i = -1; i <= 1; i++) {
				// System.out.println(oneGame);
				sum += simulate(gamesLeftCopy, ptsCopy, oneGame, i, T);
			}
			
			return sum;
		}
	}
}
