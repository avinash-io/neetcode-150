package slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Sliding Window Maximum
 *
 * <p>You are given an array of integers {@code nums}, and there is a sliding
 * window of size {@code k} that moves from the very left of the array to the
 * very right.
 *
 * <p>You can only see the {@code k} numbers in the window. Each time the
 * sliding window moves one position to the right, return the maximum value
 * inside the window.
 *
 * <p>Return the maximum values for each window.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 *
 * Input:  nums = [1], k = 1
 * Output: [1]
 *
 * Input:  nums = [1,-1], k = 1
 * Output: [1,-1]
 *
 * Input:  nums = [9,11], k = 2
 * Output: [11]
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 1 <= nums.length <= 100000}</li>
 *   <li>{@code 1 <= k <= nums.length}</li>
 *   <li>{@code -10000 <= nums[i] <= 10000}</li>
 * </ul>
 */
public class SlidingWindowMaximum {

public int[] solution(int[] nums, int k) {
	// Your solution
	if(nums==null || nums.length==0 || k<=0 ) {
		return new int[0];
	}
	
	int n = nums.length;
	int[] result = new int[n-k+1];
	Deque<Integer> dequeu = new LinkedList<>();
	
	for(int i=0;i < n;i++) {
		
		while(!dequeu.isEmpty() && dequeu.peek()<i-k+1) {
			dequeu.poll();
		}
		
		while(!dequeu.isEmpty() && nums[dequeu.peekLast()]<nums[i]) {
			dequeu.pollLast();
		}
		
		dequeu.offer(i);
		
		if(i>=k-1) {
			result[i - k + 1] = nums[dequeu.peek()];
		}
		
		
	}
	
	return result;
}

public static void main(String[] args) {
	SlidingWindowMaximum solution = new SlidingWindowMaximum();
	
	// Test case 1
	int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
	int k1 = 3;
	int[] result1 = solution.solution(nums1, k1);
	System.out.println(
			"Test 1: " + Arrays.toString(result1)
					+ " | Expected: [3, 3, 5, 5, 6, 7]"
	);
	
	// Test case 2
	int[] nums2 = {1};
	int k2 = 1;
	int[] result2 = solution.solution(nums2, k2);
	System.out.println(
			"Test 2: " + Arrays.toString(result2)
					+ " | Expected: [1]"
	);
	
	// Test case 3
	int[] nums3 = {1, -1};
	int k3 = 1;
	int[] result3 = solution.solution(nums3, k3);
	System.out.println(
			"Test 3: " + Arrays.toString(result3)
					+ " | Expected: [1, -1]"
	);
	
	// Test case 4
	int[] nums4 = {9, 11};
	int k4 = 2;
	int[] result4 = solution.solution(nums4, k4);
	System.out.println(
			"Test 4: " + Arrays.toString(result4)
					+ " | Expected: [11]"
	);
	
	// Test case 5
	int[] nums5 = {4, 3, 2, 1};
	int k5 = 2;
	int[] result5 = solution.solution(nums5, k5);
	System.out.println(
			"Test 5: " + Arrays.toString(result5)
					+ " | Expected: [4, 3, 2]"
	);
}
}