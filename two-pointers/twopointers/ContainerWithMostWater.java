package twopointers;

/**
 * Container With Most Water
 *
 * <p>You are given an integer array {@code height} of length {@code n}.
 * There are {@code n} vertical lines such that the two endpoints of the
 * {@code i}-th line are at {@code (i, 0)} and {@code (i, height[i])}.
 *
 * <p>Find two lines that, together with the x-axis, form a container that
 * contains the most water.
 *
 * <p>Return the maximum amount of water a container can store.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * Input:  height = [1,1]
 * Output: 1
 *
 * Input:  height = [4,3,2,1,4]
 * Output: 16
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 2 <= height.length <= 100000}</li>
 *   <li>{@code 0 <= height[i] <= 10000}</li>
 * </ul>
 */
public class ContainerWithMostWater {

public int solution(int[] height) {
	// Your solution
	int max =0;
	int left = 0;
	int right = height.length-1;
	
	while(left<right){
		
		int width = right - left;
		
		int area = Math.min(height[left],height[right]) * width;
		
		max = Math.max(max,area);
		
		if(height[left] <= height[right]){
			left++;
		} else {
			right--;
		}
		
	}
	
	
	return max;
}

public static void main(String[] args) {
	ContainerWithMostWater solution = new ContainerWithMostWater();
	
	// Test case 1
	int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
	int result1 = solution.solution(height1);
	System.out.println(
			"Test 1: " + result1 + " | Expected: 49"
	);
	
	// Test case 2
	int[] height2 = {1, 1};
	int result2 = solution.solution(height2);
	System.out.println(
			"Test 2: " + result2 + " | Expected: 1"
	);
	
	// Test case 3
	int[] height3 = {4, 3, 2, 1, 4};
	int result3 = solution.solution(height3);
	System.out.println(
			"Test 3: " + result3 + " | Expected: 16"
	);
	
	// Test case 4
	int[] height4 = {1, 2, 1};
	int result4 = solution.solution(height4);
	System.out.println(
			"Test 4: " + result4 + " | Expected: 2"
	);
}
}