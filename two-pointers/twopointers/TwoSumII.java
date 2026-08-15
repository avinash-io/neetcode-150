package twopointers;

/**
 * Two Sum II - Input Array Is Sorted
 *
 * <p>Given a 1-indexed array of integers {@code numbers} that is already sorted
 * in non-decreasing order, find two numbers such that they add up to a specific
 * {@code target} number.
 *
 * <p>Return the indices of the two numbers as an integer array
 * {@code [index1, index2]}, where {@code 1 <= index1 < index2 <= numbers.length}.
 *
 * <p>You may assume that each input has exactly one solution.
 *
 * <p>Your solution must use only constant extra space.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 *
 * Input:  numbers = [2,3,4], target = 6
 * Output: [1,3]
 *
 * Input:  numbers = [-1,0], target = -1
 * Output: [1,2]
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 2 <= numbers.length <= 30000}</li>
 *   <li>{@code -1000 <= numbers[i] <= 1000}</li>
 *   <li>{@code -1000 <= target <= 1000}</li>
 *   <li>Exactly one solution exists.</li>
 *   <li>{@code numbers} is sorted in non-decreasing order.</li>
 * </ul>
 */
public class TwoSumII {

public int[] solution(int[] numbers, int target) {
	// Your solution
	
	int left=0, right=numbers.length-1;
	
	while(left < right) {
		if(numbers[left] + numbers[right] > target) {
			right--;
		} else  if(numbers[left] + numbers[right] < target) {
			left++;
		} else {
			return new int[] {left+1,right+1};
		}
	}
	
	return new int[]{};
}

public static void main(String[] args) {
	TwoSumII solution = new TwoSumII();
	
	// Test case 1
	int[] numbers1 = {2, 7, 11, 15};
	int target1 = 9;
	int[] result1 = solution.solution(numbers1, target1);
	System.out.println(
			"Test 1: [" + result1[0] + ", " + result1[1]
					+ "] | Expected: [1, 2]"
	);
	
	// Test case 2
	int[] numbers2 = {2, 3, 4};
	int target2 = 6;
	int[] result2 = solution.solution(numbers2, target2);
	System.out.println(
			"Test 2: [" + result2[0] + ", " + result2[1]
					+ "] | Expected: [1, 3]"
	);
	
	// Test case 3
	int[] numbers3 = {-1, 0};
	int target3 = -1;
	int[] result3 = solution.solution(numbers3, target3);
	System.out.println(
			"Test 3: [" + result3[0] + ", " + result3[1]
					+ "] | Expected: [1, 2]"
	);
	
	// Test case 4
	int[] numbers4 = {1, 2, 3, 4, 4, 9, 56};
	int target4 = 8;
	int[] result4 = solution.solution(numbers4, target4);
	System.out.println(
			"Test 4: [" + result4[0] + ", " + result4[1]
					+ "] | Expected: [4, 5]"
	);
}
}