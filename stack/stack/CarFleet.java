package stack;

import java.util.Arrays;

/**
 * Car Fleet
 *
 * <p>There are {@code n} cars going to the same destination along a one-lane
 * road. The destination is {@code target} miles away.
 *
 * <p>You are given two integer arrays:
 *
 * <ul>
 *   <li>{@code position[i]} — the starting position of the {@code i}-th car.</li>
 *   <li>{@code speed[i]} — the speed of the {@code i}-th car in miles per hour.</li>
 * </ul>
 *
 * <p>A car cannot pass another car, but it can catch up to another car and
 * then travel at the same speed as that car.
 *
 * <p>A car fleet is a group of cars that drive together at the same position
 * and speed.
 *
 * <p>Return the number of car fleets that will arrive at the destination.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  target = 12
 *        position = [10,8,0,5,3]
 *        speed = [2,4,1,1,3]
 *
 * Output: 3
 *
 * Input:  target = 10
 *        position = [3]
 *        speed = [3]
 *
 * Output: 1
 *
 * Input:  target = 100
 *        position = [0,2,4]
 *        speed = [4,2,1]
 *
 * Output: 1
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code n == position.length == speed.length}</li>
 *   <li>{@code 1 <= n <= 1000}</li>
 *   <li>{@code 0 < target <= 1000}</li>
 *   <li>{@code 0 <= position[i] < target}</li>
 *   <li>{@code 0 < speed[i] <= 1000}</li>
 *   <li>All values in {@code position} are unique.</li>
 * </ul>
 */
public class CarFleet {

public int solution(int target, int[] position, int[] speed) {
	// Your solution
	return 0;
}

public static void main(String[] args) {
	CarFleet solution = new CarFleet();
	
	// Test case 1
	int target1 = 12;
	int[] position1 = {10, 8, 0, 5, 3};
	int[] speed1 = {2, 4, 1, 1, 3};
	
	int result1 = solution.solution(target1, position1, speed1);
	
	System.out.println(
			"Test 1: " + result1 + " | Expected: 3"
	);
	
	// Test case 2
	int target2 = 10;
	int[] position2 = {3};
	int[] speed2 = {3};
	
	int result2 = solution.solution(target2, position2, speed2);
	
	System.out.println(
			"Test 2: " + result2 + " | Expected: 1"
	);
	
	// Test case 3
	int target3 = 100;
	int[] position3 = {0, 2, 4};
	int[] speed3 = {4, 2, 1};
	
	int result3 = solution.solution(target3, position3, speed3);
	
	System.out.println(
			"Test 3: " + result3 + " | Expected: 1"
	);
	
	// Test case 4
	int target4 = 10;
	int[] position4 = {6, 8};
	int[] speed4 = {3, 2};
	
	int result4 = solution.solution(target4, position4, speed4);
	
	System.out.println(
			"Test 4: " + result4 + " | Expected: 2"
	);
}
}