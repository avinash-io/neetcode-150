package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Daily Temperatures
 *
 * <p>Given an array of integers {@code temperatures} representing the daily
 * temperatures, return an array {@code answer} such that
 * {@code answer[i]} is the number of days you have to wait after the
 * {@code i}-th day to get a warmer temperature.
 *
 * <p>If there is no future day for which this is possible, keep
 * {@code answer[i] == 0}.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 *
 * Input:  temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 *
 * Input:  temperatures = [30,60,90]
 * Output: [1,1,0]
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 1 <= temperatures.length <= 100000}</li>
 *   <li>{@code 30 <= temperatures[i] <= 100}</li>
 * </ul>
 */
public class DailyTemperatures {

public int[] solution(int[] temperatures) {
	// Your solution
	
	int n = temperatures.length;
	int[] res = new int[n];
	Stack<Integer> stack = new Stack<>();
	
	for(int i=0;i<n;i++){
		while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
			int index = stack.pop();
			res[index] = i-index;
		}
		stack.push(i);
	}
	
	return res;
}

public static void main(String[] args) {
	DailyTemperatures solution = new DailyTemperatures();
	
	// Test case 1
	int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
	int[] result1 = solution.solution(temperatures1);
	System.out.println(
			"Test 1: " + Arrays.toString(result1)
					+ " | Expected: [1, 1, 4, 2, 1, 1, 0, 0]"
	);
	
	// Test case 2
	int[] temperatures2 = {30, 40, 50, 60};
	int[] result2 = solution.solution(temperatures2);
	System.out.println(
			"Test 2: " + Arrays.toString(result2)
					+ " | Expected: [1, 1, 1, 0]"
	);
	
	// Test case 3
	int[] temperatures3 = {30, 60, 90};
	int[] result3 = solution.solution(temperatures3);
	System.out.println(
			"Test 3: " + Arrays.toString(result3)
					+ " | Expected: [1, 1, 0]"
	);
	
	// Test case 4
	int[] temperatures4 = {90, 80, 70, 60};
	int[] result4 = solution.solution(temperatures4);
	System.out.println(
			"Test 4: " + Arrays.toString(result4)
					+ " | Expected: [0, 0, 0, 0]"
	);
	
	// Test case 5
	int[] temperatures5 = {70, 70, 71};
	int[] result5 = solution.solution(temperatures5);
	System.out.println(
			"Test 5: " + Arrays.toString(result5)
					+ " | Expected: [2, 1, 0]"
	);
}
}