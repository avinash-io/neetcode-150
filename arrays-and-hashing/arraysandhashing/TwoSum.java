package arraysandhashing;

/**
 * Two Sum
 *
 * <p>Given an array of integers {@code nums} and an integer {@code target},
 * return the indices of the two numbers such that they add up to
 * {@code target}.
 *
 * <p>You may assume that each input has exactly one solution, and you may
 * not use the same element twice.
 *
 * <p>You can return the answer in any order.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  nums = [2, 7, 11, 15], target = 9
 * Output: [0, 1]
 *
 * Input:  nums = [3, 2, 4], target = 6
 * Output: [1, 2]
 *
 * Input:  nums = [3, 3], target = 6
 * Output: [0, 1]
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 2 <= nums.length <= 10000}</li>
 *   <li>{@code -1000000000 <= nums[i] <= 1000000000}</li>
 *   <li>{@code -1000000000 <= target <= 1000000000}</li>
 *   <li>There is exactly one valid answer.</li>
 * </ul>
 */
public class TwoSum {

public int[] solution(int[] nums, int target) {
	// Your solution
	return new int[]{};
}

public static void main(String[] args) {
	TwoSum solution = new TwoSum();
	
	// Test case 1
	int[] nums1 = {2, 7, 11, 15};
	int target1 = 9;
	int[] result1 = solution.solution(nums1, target1);
	System.out.println(
			"Test 1: [" + result1[0] + ", " + result1[1] + "] | Expected: [0, 1]"
	);
	
	// Test case 2
	int[] nums2 = {3, 2, 4};
	int target2 = 6;
	int[] result2 = solution.solution(nums2, target2);
	System.out.println(
			"Test 2: [" + result2[0] + ", " + result2[1] + "] | Expected: [1, 2]"
	);
	
	// Test case 3
	int[] nums3 = {3, 3};
	int target3 = 6;
	int[] result3 = solution.solution(nums3, target3);
	System.out.println(
			"Test 3: [" + result3[0] + ", " + result3[1] + "] | Expected: [0, 1]"
	);
}
}