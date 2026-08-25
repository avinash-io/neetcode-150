package binarysearch;

/**
 * Search in Rotated Sorted Array
 *
 * <p>There is an integer array {@code nums} sorted in ascending order
 * (with distinct values).
 *
 * <p>Prior to being passed to your function, {@code nums} is possibly rotated
 * at an unknown pivot index {@code k}, where the resulting array is:
 *
 * <pre>
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * </pre>
 *
 * <p>For example, {@code [0,1,2,4,5,6,7]} might be rotated at index 3 to
 * become {@code [4,5,6,7,0,1,2]}.
 *
 * <p>Given the array {@code nums} after the possible rotation and an integer
 * {@code target}, return the index of {@code target} if it exists, otherwise
 * return {@code -1}.
 *
 * <p>You must write an algorithm with {@code O(log n)} runtime complexity.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Input:  nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * Input:  nums = [1], target = 0
 * Output: -1
 *
 * Input:  nums = [1,3], target = 3
 * Output: 1
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 1 <= nums.length <= 5000}</li>
 *   <li>{@code -10000 <= nums[i] <= 10000}</li>
 *   <li>All values in {@code nums} are unique.</li>
 *   <li>{@code nums} is sorted and rotated at an unknown pivot.</li>
 * </ul>
 */
public class SearchInRotatedSortedArray {

public int solution(int[] nums, int target) {
	// Your solution
	int left = 0;
	int right = nums.length - 1;
	
	while(left <= right){
		
		int mid = left + (right - left)/2;
		
		if(nums[mid] == target){
			return mid;
		}
		
		if(nums[left] <= nums[mid]){
			if(nums[left] <= target && target < nums[mid]){
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		} else {
			if(nums[mid] < target && target <= nums[right]){
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
	}
	
	
	return -1;
}

public static void main(String[] args) {
	SearchInRotatedSortedArray solution =
			new SearchInRotatedSortedArray();
	
	// Test case 1
	int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
	int target1 = 0;
	int result1 = solution.solution(nums1, target1);
	System.out.println(
			"Test 1: " + result1 + " | Expected: 4"
	);
	
	// Test case 2
	int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
	int target2 = 3;
	int result2 = solution.solution(nums2, target2);
	System.out.println(
			"Test 2: " + result2 + " | Expected: -1"
	);
	
	// Test case 3
	int[] nums3 = {1};
	int target3 = 0;
	int result3 = solution.solution(nums3, target3);
	System.out.println(
			"Test 3: " + result3 + " | Expected: -1"
	);
	
	// Test case 4
	int[] nums4 = {1, 3};
	int target4 = 3;
	int result4 = solution.solution(nums4, target4);
	System.out.println(
			"Test 4: " + result4 + " | Expected: 1"
	);
	
	// Test case 5
	int[] nums5 = {5, 6, 7, 8, 1, 2, 3, 4};
	int target5 = 2;
	int result5 = solution.solution(nums5, target5);
	System.out.println(
			"Test 5: " + result5 + " | Expected: 5"
	);
}
}