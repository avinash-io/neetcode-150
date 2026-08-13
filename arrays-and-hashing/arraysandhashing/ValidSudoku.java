package arraysandhashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Valid Sudoku
 *
 * <p>Determine if a {@code 9 x 9} Sudoku board is valid. Only the filled cells
 * need to be validated according to the following rules:
 *
 * <ul>
 *   <li>Each row must contain the digits 1-9 without repetition.</li>
 *   <li>Each column must contain the digits 1-9 without repetition.</li>
 *   <li>Each of the nine {@code 3 x 3} sub-boxes must contain the digits
 *       1-9 without repetition.</li>
 * </ul>
 *
 * <p>Note:
 * <ul>
 *   <li>A Sudoku board could be valid but not necessarily solvable.</li>
 *   <li>Only the filled cells need to be validated.</li>
 * </ul>
 *
 * <p>Examples:
 *
 * <pre>
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 *
 * Output: true
 *
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 *
 * Output: false
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code board.length == 9}</li>
 *   <li>{@code board[i].length == 9}</li>
 *   <li>{@code board[i][j]} is a digit 1-9 or {@code '.'}</li>
 * </ul>
 */
public class ValidSudoku {

public boolean solution(char[][] board) {
	// Your solution
	
	int N = 9;
	
	HashSet<Character>[] rows = new HashSet[N];
	HashSet<Character>[] cols = new HashSet[N];
	HashSet<Character>[] boxes = new HashSet[N];
	
	for(int i = 0; i < N; i++) {
		rows[i] = new HashSet<>();
		cols[i] = new HashSet<>();
		boxes[i] = new HashSet<>();
	}
	
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			
			char val = board[i][j];
			
			if(val =='.') {
				continue;
			}
			
			if(rows[i].contains(val)) {
				return false;
			}
			
			rows[i].add(val);
			
			if(cols[j].contains(val)) {
				return false;
			}
			cols[j].add(val);
			
			int idx = (i/3)*3+(j/3);
			if(boxes[idx].contains(val)) {
				return false;
			}
			boxes[idx].add(val);
			
		}
	}
 
	return true;
}

public static void main(String[] args) {
	ValidSudoku solution = new ValidSudoku();
	
	// Test case 1: Valid Sudoku
	char[][] board1 = {
			{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
			{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
			{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
			{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
			{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
			{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
			{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
			{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
			{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
	};
	
	System.out.println(
			"Test 1: " + solution.solution(board1)
					+ " | Expected: true"
	);
	
	// Test case 2: Duplicate 8 in the first column
	char[][] board2 = {
			{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
			{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
			{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
			{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
			{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
			{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
			{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
			{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
			{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
	};
	
	System.out.println(
			"Test 2: " + solution.solution(board2)
					+ " | Expected: false"
	);
	
	// Test case 3: Empty board
	char[][] board3 = {
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'}
	};
	
	System.out.println(
			"Test 3: " + solution.solution(board3)
					+ " | Expected: true"
	);
}
}