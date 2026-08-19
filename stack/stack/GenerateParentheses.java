package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses
 *
 * <p>Given {@code n} pairs of parentheses, write a function to generate all
 * combinations of well-formed parentheses.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Input:  n = 1
 * Output: ["()"]
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 1 <= n <= 8}</li>
 * </ul>
 */
public class GenerateParentheses {

public List<String> solution(int n) {
	// Your solution
	List<String> res = new ArrayList<>();
	StringBuilder cur = new StringBuilder();
	int open = 0;
	int close = 0;
	int max = n;
	
	backtrack(res, cur, open, close, max);
	
	return res;
}

public void backtrack(List<String> res, StringBuilder cur, int open, int close, int max) {
	if(cur.length() == max*2) {
		res.add(cur.toString());
		return;
	}
	
	if(open<max) {
		cur.append("(");
		backtrack(res, cur, open+1, close, max);
		cur.deleteCharAt(cur.length()-1);
	}
	
	if(close<open) {
		cur.append(")");
		backtrack(res, cur, open, close+1, max);
		cur.deleteCharAt(cur.length()-1);
	}
	
	
}


public static void main(String[] args) {
	GenerateParentheses solution = new GenerateParentheses();
	
//	// Test case 1
//	int n1 = 3;
//	List<String> result1 = solution.solution(n1);
//	System.out.println(
//			"Test 1: " + result1
//					+ " | Expected: [((())), (()()), (())(), ()(()), ()()()]"
//	);
//
//	// Test case 2
//	int n2 = 1;
//	List<String> result2 = solution.solution(n2);
//	System.out.println(
//			"Test 2: " + result2
//					+ " | Expected: [()]"
//	);
	
	// Test case 3
	int n3 = 2;
	List<String> result3 = solution.solution(n3);
	System.out.println(
			"Test 3: " + result3
					+ " | Expected: [(()), ()()]"
	);
}
}