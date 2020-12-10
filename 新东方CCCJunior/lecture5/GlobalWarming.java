import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GlobalWarming {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		LinkedList<String> lines = new LinkedList<String>();
		
		String eachLine;
		do {
			
			eachLine = sc.nextLine().trim();
			lines.add(eachLine);
			
		}while(!eachLine.equals("0"));
		
		lines.removeLast();
		
		for(String line : lines)
		{
			System.out.println(getShortestCycle(line));
		}
	}
	
	public static int getShortestCycle(String temperatures) {
		
		String[] temperatureArr = temperatures.split(" ");
		
		if(Integer.parseInt(temperatureArr[0])<3){
		    return Integer.parseInt(temperatureArr[0])-1;
		}
		
		int[] dArr = new int[temperatureArr.length-2];
		
		
		for(int i = 0; i < dArr.length; i++) 
		{
			dArr[i] = Integer.parseInt(temperatureArr[i+2]) - Integer.parseInt(temperatureArr[i+1]);
		}
		
		ArrayList<Integer> shortestCycle = new ArrayList<Integer>();
		shortestCycle.add(dArr[0]);
		int index = 1;
		
		while(!isCycleValid(shortestCycle, dArr))
		{
			shortestCycle.add(dArr[index++]);
		}
		
		return shortestCycle.size();
	}

	public static boolean isCycleValid(ArrayList<Integer> cycle, int[] dArr)
	{
		int sizeOfCycle = cycle.size();

		for(int i = 0; i < dArr.length; i++)
		{
			if(dArr[i] != cycle.get(i%sizeOfCycle))
			{
				return false;
			}
		}
		
		return true;
	}
}
