package codeII;

public class HouseRobber {
	
	public int robLine(int[] houses) {
		
		int[] maxValue = new int[houses.length];
		
		maxValue[0] = houses[0];
		maxValue[1] = Math.max(houses[0], houses[1]);
		
		for(int i = 2; i < houses.length; i++) {
			maxValue[i] = Math.max(maxValue[i-2] + houses[i], maxValue[i-1]);
		}
		
		return maxValue[houses.length - 1];
	}

	public int robCircle(int[] houses) {
		
		int[] startFromFirst = new int[houses.length + 1];
		int[] startFromSecond = new int[houses.length + 1];
		
		startFromFirst[0] = 0;
		startFromSecond[0] = 0;
		
		startFromFirst[1] = houses[0];
		startFromSecond[1] = 0;
		
		for(int i = 2; i < houses.length; i++) {
			startFromFirst[i] = Math.max(startFromFirst[i - 2] + houses[i], startFromFirst[i-1]);
			startFromSecond[i] = Math.max(startFromSecond[i - 2] + houses[i], startFromSecond[i-1]);
		}
		
		return Math.max(startFromFirst[houses.length - 1], startFromSecond[houses.length]);
	}
}
