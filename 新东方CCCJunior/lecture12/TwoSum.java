package demo3;

import java.util.*;

public class TwoSum {

	public static void main(String[] args) {
		int[] solution1 = twoSum(new int[] {2,7,11,15}, 9);
		System.out.println(solution1[0] + ", " + solution1[1]);
		
		int[] solution2 = twoSum(new int[] {3,2,4}, 6);
		System.out.println(solution2[0] + ", " + solution2[1]);
		
		int[] solution3 = twoSum(new int[] {3, 3}, 6);
		System.out.println(solution3[0] + ", " + solution3[1]);
		
	}
	
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
		throw new IllegalArgumentException("No two sum solution");
		
	}
 
}
