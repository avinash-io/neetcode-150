package twopointers;

/**
 * Trapping Rain Water
 *
 * <p>Given {@code n} non-negative integers representing an elevation map where
 * the width of each bar is 1, compute how much water it can trap after raining.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * Input:  height = [4,2,0,3,2,5]
 * Output: 9
 *
 * Input:  height = [1,2,3,4,5]
 * Output: 0
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code n == height.length}</li>
 *   <li>{@code 1 <= n <= 20000}</li>
 *   <li>{@code 0 <= height[i] <= 100000}</li>
 * </ul>
 */
public class TrappingRainWater {

public int solution(int[] height) {
	// Your solution
	
	int left = 0;
	int right = height.length-1;
	
	int total=0;
	
	int leftMax = height[0];
	int rightMax = height[right];
	
	while(left<right){
		if(height[left]<height[right]){
			leftMax=Math.max(leftMax,height[left]);
			if(leftMax - height[left]>0){
				total = total +  leftMax - height[left];
			}
			left++;
		} else {
			rightMax=Math.max(rightMax,height[right]);
			if(rightMax - height[right]>0){
				total = total +  rightMax - height[right];
			}
			right--;
		}
	}
	
	
	return total;
}

public static void main(String[] args) {
	TrappingRainWater solution = new TrappingRainWater();
	
	// Test case 1
	int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
	int result1 = solution.solution(height1);
	System.out.println(
			"Test 1: " + result1 + " | Expected: 6"
	);
	
	// Test case 2
	int[] height2 = {4, 2, 0, 3, 2, 5};
	int result2 = solution.solution(height2);
	System.out.println(
			"Test 2: " + result2 + " | Expected: 9"
	);
	
	// Test case 3
	int[] height3 = {1, 2, 3, 4, 5};
	int result3 = solution.solution(height3);
	System.out.println(
			"Test 3: " + result3 + " | Expected: 0"
	);
	
	// Test case 4
	int[] height4 = {5, 4, 3, 2, 1};
	int result4 = solution.solution(height4);
	System.out.println(
			"Test 4: " + result4 + " | Expected: 0"
	);
	
	// Test case 5
	int[] height5 = {3, 0, 2, 0, 4};
	int result5 = solution.solution(height5);
	System.out.println(
			"Test 5: " + result5 + " | Expected: 7"
	);
}
}