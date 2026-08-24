package binarysearch;

/**
 * Search a 2D Matrix
 *
 * <p>Write an efficient algorithm that searches for a value {@code target}
 * in an {@code m x n} integer matrix {@code matrix}.
 *
 * <p>This matrix has the following properties:
 *
 * <ul>
 *   <li>Integers in each row are sorted from left to right.</li>
 *   <li>The first integer of each row is greater than the last integer of
 *       the previous row.</li>
 * </ul>
 *
 * <p>Return {@code true} if {@code target} exists in the matrix, otherwise
 * return {@code false}.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:
 * matrix = [
 *   [1, 3, 5, 7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 60]
 * ]
 * target = 3
 *
 * Output: true
 *
 * Input:
 * matrix = [
 *   [1, 3, 5, 7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 60]
 * ]
 * target = 13
 *
 * Output: false
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code m == matrix.length}</li>
 *   <li>{@code n == matrix[i].length}</li>
 *   <li>{@code 1 <= m, n <= 100}</li>
 *   <li>{@code -10000 <= matrix[i][j], target <= 10000}</li>
 * </ul>
 */
public class SearchA2DMatrix {

public boolean solution(int[][] matrix, int target) {
	// Your solution
	if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
	
	int m = matrix.length, n = matrix[0].length;
	
	int left = 0;
	
	int right = (m*n)-1;
	
	while (left <= right) {
		
		int mid = left + (right - left)/2;
		
		int row = mid / n;
		int col = mid % n;
		
		int element = matrix[row][col];
		
		if (element == target) {
			return true;
		} else  if (element < target) {
			left = mid + 1;
		} else {
			right = mid - 1;
		}
		
	}
	
	return false;
}

public static void main(String[] args) {
	SearchA2DMatrix solution = new SearchA2DMatrix();
	
	// Test case 1
	int[][] matrix1 = {
			{1, 3, 5, 7},
			{10, 11, 16, 20},
			{23, 30, 34, 60}
	};
	int target1 = 3;
	
	boolean result1 = solution.solution(matrix1, target1);
	
	System.out.println(
			"Test 1: " + result1 + " | Expected: true"
	);
	
	// Test case 2
	int[][] matrix2 = {
			{1, 3, 5, 7},
			{10, 11, 16, 20},
			{23, 30, 34, 60}
	};
	int target2 = 13;
	
	boolean result2 = solution.solution(matrix2, target2);
	
	System.out.println(
			"Test 2: " + result2 + " | Expected: false"
	);
	
	// Test case 3
	int[][] matrix3 = {
			{1}
	};
	int target3 = 1;
	
	boolean result3 = solution.solution(matrix3, target3);
	
	System.out.println(
			"Test 3: " + result3 + " | Expected: true"
	);
	
	// Test case 4
	int[][] matrix4 = {
			{1, 3, 5},
			{7, 9, 11}
	};
	int target4 = 11;
	
	boolean result4 = solution.solution(matrix4, target4);
	
	System.out.println(
			"Test 4: " + result4 + " | Expected: true"
	);
	
	// Test case 5
	int[][] matrix5 = {
			{1, 3, 5},
			{7, 9, 11}
	};
	int target5 = 6;
	
	boolean result5 = solution.solution(matrix5, target5);
	
	System.out.println(
			"Test 5: " + result5 + " | Expected: false"
	);
}
}