package binarysearch;

/**
 * Find Minimum in Rotated Sorted Array
 *
 * <p>Suppose an array of length {@code n} sorted in ascending order is rotated
 * between 1 and {@code n} times. For example:
 *
 * <pre>
 * Original: [0,1,2,4,5,6,7]
 * Rotated:  [4,5,6,7,0,1,2]
 * </pre>
 *
 * <p>Given the rotated array {@code nums} of unique elements, return the
 * minimum element of the array.
 *
 * <p>You must write an algorithm that runs in {@code O(log n)} time.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  nums = [3,4,5,1,2]
 * Output: 1
 *
 * Input:  nums = [4,5,6,7,0,1,2]
 * Output: 0
 *
 * Input:  nums = [11,13,15,17]
 * Output: 11
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 1 <= nums.length <= 5000}</li>
 *   <li>{@code -5000 <= nums[i] <= 5000}</li>
 *   <li>All integers in {@code nums} are unique.</li>
 *   <li>{@code nums} is sorted and rotated between 1 and {@code n} times.</li>
 * </ul>
 */
public class FindMinimumInRotatedSortedArray {

public int solution(int[] nums) {
	// Your solution
	
	int left = 0;
	int right = nums.length-1;
	
	while(left < right){
		
		int mid = left+(right - left)/2;
		
		if(nums[mid] > nums[right]) {
			left = mid+1;
		} else {
			right = mid;
		}
		
	}
	
	return nums[left];
}

public static void main(String[] args) {
	FindMinimumInRotatedSortedArray solution =
			new FindMinimumInRotatedSortedArray();
	
	// Test case 1
	int[] nums1 = {3, 4, 5, 1, 2};
	int result1 = solution.solution(nums1);
	System.out.println(
			"Test 1: " + result1 + " | Expected: 1"
	);
	
	// Test case 2
	int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
	int result2 = solution.solution(nums2);
	System.out.println(
			"Test 2: " + result2 + " | Expected: 0"
	);
	
	// Test case 3
	int[] nums3 = {11, 13, 15, 17};
	int result3 = solution.solution(nums3);
	System.out.println(
			"Test 3: " + result3 + " | Expected: 11"
	);
	
	// Test case 4
	int[] nums4 = {2, 1};
	int result4 = solution.solution(nums4);
	System.out.println(
			"Test 4: " + result4 + " | Expected: 1"
	);
	
	// Test case 5
	int[] nums5 = {5, 1, 2, 3, 4};
	int result5 = solution.solution(nums5);
	System.out.println(
			"Test 5: " + result5 + " | Expected: 1"
	);
}
}