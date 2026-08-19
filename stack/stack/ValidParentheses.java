package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Valid Parentheses
 *
 * <p>Given a string {@code s} containing just the characters
 * {@code '(', ')', '{', '}', '['} and {@code ']'}, determine if the input
 * string is valid.
 *
 * <p>An input string is valid if:
 *
 * <ul>
 *   <li>Open brackets must be closed by the same type of brackets.</li>
 *   <li>Open brackets must be closed in the correct order.</li>
 *   <li>Every closing bracket has a corresponding open bracket of the same
 *       type.</li>
 * </ul>
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  s = "()"
 * Output: true
 *
 * Input:  s = "()[]{}"
 * Output: true
 *
 * Input:  s = "(]"
 * Output: false
 *
 * Input:  s = "([])"
 * Output: true
 *
 * Input:  s = "([)]"
 * Output: false
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 1 <= s.length <= 10000}</li>
 *   <li>{@code s} consists only of parentheses, brackets, and braces.</li>
 * </ul>
 */
public class ValidParentheses {

public boolean solution(String s) {
	// Your solution
	
	HashMap<Character,Character> map=new HashMap<>();
	map.put(')','(');
	map.put(']','[');
	map.put('}','{');
	
	Stack<Character> stack = new Stack<>();
	
	for (int i = 0; i < s.length(); i++) {
		
		char c = s.charAt(i);
		
		if (!map.containsKey(c)) {
			stack.push(c);
		} else {
			if(stack.isEmpty()){
				return false;
			}
			
			char topElement = stack.pop();
			if (topElement != map.get(c)) {
				return false;
			}
			
		}
		
		
	}
	
	return stack.isEmpty();
}

public static void main(String[] args) {
	ValidParentheses solution = new ValidParentheses();
	
	// Test case 1
	String s1 = "()";
	boolean result1 = solution.solution(s1);
	System.out.println(
			"Test 1: " + result1 + " | Expected: true"
	);
	
	// Test case 2
	String s2 = "()[]{}";
	boolean result2 = solution.solution(s2);
	System.out.println(
			"Test 2: " + result2 + " | Expected: true"
	);
	
	// Test case 3
	String s3 = "(]";
	boolean result3 = solution.solution(s3);
	System.out.println(
			"Test 3: " + result3 + " | Expected: false"
	);
	
	// Test case 4
	String s4 = "([])";
	boolean result4 = solution.solution(s4);
	System.out.println(
			"Test 4: " + result4 + " | Expected: true"
	);
	
	// Test case 5
	String s5 = "([)]";
	boolean result5 = solution.solution(s5);
	System.out.println(
			"Test 5: " + result5 + " | Expected: false"
	);
	
	// Test case 6
	String s6 = "{[]}";
	boolean result6 = solution.solution(s6);
	System.out.println(
			"Test 6: " + result6 + " | Expected: true"
	);
}
}