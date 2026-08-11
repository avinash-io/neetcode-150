package arraysandhashing;

import java.util.HashSet;

/**
 * Contains Duplicate
 *
 * <p>Given an integer array {@code nums}, return {@code true} if any value
 * appears at least twice in the array, and return {@code false} if every
 * element is distinct.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  nums = [1, 2, 3, 1]
 * Output: true
 *
 * Input:  nums = [1, 2, 3, 4]
 * Output: false
 *
 * Input:  nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
 * Output: true
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 1 <= nums.length <= 100000}</li>
 *   <li>{@code -1000000000 <= nums[i] <= 1000000000}</li>
 * </ul>
 */
public class ContainsDuplicate {

public boolean solution(int[] nums) {
	// Your solution
	
	HashSet<Integer> seenNumber = new HashSet<>();
	
	for(int num:nums) {
		
		if(seenNumber.contains(num)) {
			return true;
		}
		
		seenNumber.add(num);
		
	}
	
	return false;
}

public static void main(String[] args) {
	ContainsDuplicate solution = new ContainsDuplicate();
	
	int[] nums1 = {1, 2, 3, 1};
	System.out.println(
			"Test 1: " + solution.solution(nums1) + " | Expected: true"
	);
	
	int[] nums2 = {1, 2, 3, 4};
	System.out.println(
			"Test 2: " + solution.solution(nums2) + " | Expected: false"
	);
	
	int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
	System.out.println(
			"Test 3: " + solution.solution(nums3) + " | Expected: true"
	);
}
}