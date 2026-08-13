package arraysandhashing;

import java.util.Arrays;

/**
 * Product of Array Except Self
 *
 * <p>Given an integer array {@code nums}, return an array {@code answer} such
 * that {@code answer[i]} is equal to the product of all the elements of
 * {@code nums} except {@code nums[i]}.
 *
 * <p>The product of any prefix or suffix of {@code nums} is guaranteed to fit
 * in a 32-bit integer.
 *
 * <p>You must solve the problem in {@code O(n)} time and without using the
 * division operation.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Input:  nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 2 <= nums.length <= 100000}</li>
 *   <li>{@code -30 <= nums[i] <= 30}</li>
 * </ul>
 *
 * <p>Follow-up: Can you solve it using {@code O(1)} extra space, excluding
 * the output array?
 */
public class ProductOfArrayExceptSelf {

public int[] solution(int[] nums) {
	// Your solution
	
	int[] result = new int[nums.length];
	
	Arrays.fill(result, 1);
	
	int prefix = 1, postfix = 1;
	
	for (int i = 0; i < nums.length; i++) {
		
		result[i]  = prefix;
		prefix = nums[i]*prefix;
		
	}
	
	for (int i = result.length - 1; i >= 0; i--) {
		result[i] = result[i] * postfix;
		postfix = postfix * nums[i];
	}
	
	return result;
	
}

public static void main(String[] args) {
	ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
	
	// Test case 1
	int[] nums1 = {1, 2, 3, 4};
	int[] result1 = solution.solution(nums1);
	System.out.println(
			"Test 1: " + Arrays.toString(result1)
					+ " | Expected: [24, 12, 8, 6]"
	);
	
	// Test case 2
	int[] nums2 = {-1, 1, 0, -3, 3};
	int[] result2 = solution.solution(nums2);
	System.out.println(
			"Test 2: " + Arrays.toString(result2)
					+ " | Expected: [0, 0, 9, 0, 0]"
	);
	
	// Test case 3
	int[] nums3 = {2, 3, 4, 5};
	int[] result3 = solution.solution(nums3);
	System.out.println(
			"Test 3: " + Arrays.toString(result3)
					+ " | Expected: [60, 40, 30, 24]"
	);
	
	// Test case 4
	int[] nums4 = {1, 0};
	int[] result4 = solution.solution(nums4);
	System.out.println(
			"Test 4: " + Arrays.toString(result4)
					+ " | Expected: [0, 1]"
	);
}
}