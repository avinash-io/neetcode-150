package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Largest Rectangle in Histogram
 *
 * <p>Given an array of integers {@code heights} representing the histogram's
 * bar height where the width of each bar is 1, return the area of the
 * largest rectangle in the histogram.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  heights = [2,1,5,6,2,3]
 * Output: 10
 *
 * Explanation:
 * The largest rectangle has an area of 10.
 *
 * Input:  heights = [2,4]
 * Output: 4
 *
 * Input:  heights = [1,1,1,1]
 * Output: 4
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 1 <= heights.length <= 100000}</li>
 *   <li>{@code 0 <= heights[i] <= 10000}</li>
 * </ul>
 */
public class LargestRectangleInHistogram {

public int solution(int[] heights) {
	// Your solution
	Stack<Integer> stack = new Stack<>();
	int maxArea = 0;
	int n = heights.length;
	
	for (int i = 0; i <= n; i++) {
		int currentHeight = (i==n) ? 0 : heights[i];
		
		while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
			int height = heights[stack.pop()];
			int width = stack.isEmpty() ? i : i - stack.peek() - 1;
			maxArea = Math.max(maxArea, height * width);
		}
		
		stack.push(i);
	}
	
	return maxArea;
}

public static void main(String[] args) {
	LargestRectangleInHistogram solution =
			new LargestRectangleInHistogram();
	
	// Test case 1
	int[] heights1 = {2, 1, 5, 6, 2, 3};
	int result1 = solution.solution(heights1);
	System.out.println(
			"Test 1: " + result1 + " | Expected: 10"
	);
	
	// Test case 2
	int[] heights2 = {2, 4};
	int result2 = solution.solution(heights2);
	System.out.println(
			"Test 2: " + result2 + " | Expected: 4"
	);
	
	// Test case 3
	int[] heights3 = {1, 1, 1, 1};
	int result3 = solution.solution(heights3);
	System.out.println(
			"Test 3: " + result3 + " | Expected: 4"
	);
	
	// Test case 4
	int[] heights4 = {5, 4, 3, 2, 1};
	int result4 = solution.solution(heights4);
	System.out.println(
			"Test 4: " + result4 + " | Expected: 9"
	);
	
	// Test case 5
	int[] heights5 = {1, 2, 3, 4, 5};
	int result5 = solution.solution(heights5);
	System.out.println(
			"Test 5: " + result5 + " | Expected: 9"
	);
	
	// Test case 6
	int[] heights6 = {2, 2};
	int result6 = solution.solution(heights6);
	System.out.println(
			"Test 6: " + result6 + " | Expected: 4"
	);
}
}