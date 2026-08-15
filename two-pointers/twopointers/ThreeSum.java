package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3Sum
 *
 * <p>Given an integer array {@code nums}, return all the triplets
 * {@code [nums[i], nums[j], nums[k]]} such that:
 *
 * <ul>
 *   <li>{@code i != j}</li>
 *   <li>{@code i != k}</li>
 *   <li>{@code j != k}</li>
 *   <li>{@code nums[i] + nums[j] + nums[k] == 0}</li>
 * </ul>
 *
 * <p>Notice that the solution set must not contain duplicate triplets.
 *
 * <p>You may return the triplets in any order.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * Input:  nums = [0,1,1]
 * Output: []
 *
 * Input:  nums = [0,0,0]
 * Output: [[0,0,0]]
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 3 <= nums.length <= 3000}</li>
 *   <li>{@code -100000 <= nums[i] <= 100000}</li>
 * </ul>
 */
public class ThreeSum {

public List<List<Integer>> solution(int[] nums) {
	// Your solution
	List<List<Integer>> res = new ArrayList<>();
	
	
	Arrays.sort(nums);
	
	for (int i = 0; i < nums.length - 2; i++) {
	
		if(i > 0 && nums[i] == nums[i-1]) {
			continue;
		}
		
		int left = i + 1;
		int right  =  nums.length - 1;
		int target = -nums[i];
	
		while(left < right) {
			
			int curreentSum = nums[left] + nums[right];
			
			if(curreentSum == target) {
				
				res.add(Arrays.asList(nums[i], nums[left], nums[right]));
				left++;
				right--;
				
				while(left < right && nums[left] == nums[left-1]) {
					left++;
				}
				
				while(left < right && nums[right] == nums[right+1]) {
					right--;
				}
			} else if(curreentSum < target) {
				
				left++;
				
			} else {
				right--;
			}
			
		}
		
	}
	
	
	return res;
}

public static void main(String[] args) {
	ThreeSum solution = new ThreeSum();
	
	// Test case 1
	int[] nums1 = {-1, 0, 1, 2, -1, -4};
	List<List<Integer>> result1 = solution.solution(nums1);
	System.out.println(
			"Test 1: " + result1
					+ " | Expected: [[-1, -1, 2], [-1, 0, 1]]"
	);
	
	// Test case 2
	int[] nums2 = {0, 1, 1};
	List<List<Integer>> result2 = solution.solution(nums2);
	System.out.println(
			"Test 2: " + result2
					+ " | Expected: []"
	);
	
	// Test case 3
	int[] nums3 = {0, 0, 0};
	List<List<Integer>> result3 = solution.solution(nums3);
	System.out.println(
			"Test 3: " + result3
					+ " | Expected: [[0, 0, 0]]"
	);
	
	// Test case 4
	int[] nums4 = {-2, 0, 1, 1, 2};
	List<List<Integer>> result4 = solution.solution(nums4);
	System.out.println(
			"Test 4: " + result4
					+ " | Expected: [[-2, 0, 2], [-2, 1, 1]]"
	);
}
}