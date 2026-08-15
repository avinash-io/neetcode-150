package arraysandhashing;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Longest Consecutive Sequence
 *
 * <p>Given an unsorted array of integers {@code nums}, return the length of
 * the longest consecutive elements sequence.
 *
 * <p>You must write an algorithm that runs in {@code O(n)} time.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  nums = [100,4,200,1,3,2]
 * Output: 4
 *
 * Explanation:
 * The longest consecutive elements sequence is [1,2,3,4].
 * Therefore, the answer is 4.
 *
 * Input:  nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 * Explanation:
 * The longest consecutive elements sequence is [0,1,2,3,4,5,6,7,8].
 * Therefore, the answer is 9.
 *
 * Input:  nums = [1,0,1,2]
 * Output: 3
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 0 <= nums.length <= 100000}</li>
 *   <li>{@code -1000000000 <= nums[i] <= 1000000000}</li>
 * </ul>
 */
public class LongestConsecutiveSequence {

public int solution(int[] nums) {
	// Your solution
	if(nums.length==0){
		return 0;
	}
	
	HashSet<Integer> numSet = new HashSet<>();
	
	for(int i=0;i<nums.length;i++){
		numSet.add(nums[i]);
	}
	
	int longestSub = 1;
	
	for(int num:numSet) {
		
		if(numSet.contains(num-1)) {
			continue;
		} else {
			int currentNum = num;
			int currentSub = 1;
			
			while(numSet.contains(currentNum+1)) {
				currentNum++;
				currentSub++;
			}
			
			longestSub = Math.max(longestSub, currentSub);
			
		}
		
		
	}
	
	
	return longestSub;
}

public static void main(String[] args) {
	LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
	
	// Test case 1
	int[] nums1 = {100, 4, 200, 1, 3, 2};
	int result1 = solution.solution(nums1);
	System.out.println(
			"Test 1: " + result1 + " | Expected: 4"
	);
	
	// Test case 2
	int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
	int result2 = solution.solution(nums2);
	System.out.println(
			"Test 2: " + result2 + " | Expected: 9"
	);
	
	// Test case 3
	int[] nums3 = {1, 0, 1, 2};
	int result3 = solution.solution(nums3);
	System.out.println(
			"Test 3: " + result3 + " | Expected: 3"
	);
	
	// Test case 4
	int[] nums4 = {};
	int result4 = solution.solution(nums4);
	System.out.println(
			"Test 4: " + result4 + " | Expected: 0"
	);
	
	// Test case 5
	int[] nums5 = {10};
	int result5 = solution.solution(nums5);
	System.out.println(
			"Test 5: " + result5 + " | Expected: 1"
	);
}
}