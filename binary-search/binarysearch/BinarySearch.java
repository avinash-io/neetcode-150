package binarysearch;

/**
 * Binary Search
 *
 * <p>Given an array of integers {@code nums} which is sorted in ascending
 * order, and an integer {@code target}, write a function to search
 * {@code target} in {@code nums}. If {@code target} exists, then return
 * its index. Otherwise, return {@code -1}.
 *
 * <p>You must write an algorithm with {@code O(log n)} runtime complexity.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 *
 * Input:  nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 *
 * Input:  nums = [5], target = 5
 * Output: 0
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 1 <= nums.length <= 10000}</li>
 *   <li>{@code -10000 <= nums[i], target <= 10000}</li>
 *   <li>All integers in {@code nums} are unique.</li>
 *   <li>{@code nums} is sorted in ascending order.</li>
 * </ul>
 */
public class BinarySearch {

public int solution(int[] nums, int target) {
	// Your solution
	int left = 0;
	int right = nums.length - 1;
	
	while(left <= right) {
		
		int mid = left + (right - left) / 2;
		
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] < target) {
			left = mid + 1;
		} else {
			right = mid - 1;
		}
		
	}
	
	return -1;
}

public static void main(String[] args) {
	BinarySearch solution = new BinarySearch();
	
	// Test case 1
	int[] nums1 = {-1, 0, 3, 5, 9, 12};
	int target1 = 9;
	int result1 = solution.solution(nums1, target1);
	System.out.println(
			"Test 1: " + result1 + " | Expected: 4"
	);
	
	// Test case 2
	int[] nums2 = {-1, 0, 3, 5, 9, 12};
	int target2 = 2;
	int result2 = solution.solution(nums2, target2);
	System.out.println(
			"Test 2: " + result2 + " | Expected: -1"
	);
	
	// Test case 3
	int[] nums3 = {5};
	int target3 = 5;
	int result3 = solution.solution(nums3, target3);
	System.out.println(
			"Test 3: " + result3 + " | Expected: 0"
	);
	
	// Test case 4
	int[] nums4 = {1, 2, 3, 4, 5};
	int target4 = 1;
	int result4 = solution.solution(nums4, target4);
	System.out.println(
			"Test 4: " + result4 + " | Expected: 0"
	);
	
	// Test case 5
	int[] nums5 = {1, 2, 3, 4, 5};
	int target5 = 5;
	int result5 = solution.solution(nums5, target5);
	System.out.println(
			"Test 5: " + result5 + " | Expected: 4"
	);
}
}