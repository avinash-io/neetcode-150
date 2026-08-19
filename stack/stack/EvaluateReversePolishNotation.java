package stack;

import java.util.Stack;

/**
 * Evaluate Reverse Polish Notation
 *
 * <p>You are given an array of strings {@code tokens} that represents an
 * arithmetic expression in Reverse Polish Notation.
 *
 * <p>Evaluate the expression and return an integer that represents its value.
 *
 * <p>Valid operators are {@code +}, {@code -}, {@code *}, and {@code /}.
 *
 * <p>Each operand may be an integer or another expression.
 *
 * <p>Division between two integers should truncate toward zero.
 *
 * <p>You may assume that the given expression is always valid.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  tokens = ["2","1","+","3","*"]
 * Output: 9
 *
 * Explanation:
 * ((2 + 1) * 3) = 9
 *
 * Input:  tokens = ["4","13","5","/","+"]
 * Output: 6
 *
 * Explanation:
 * 4 + (13 / 5) = 6
 *
 * Input:  tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 1 <= tokens.length <= 10000}</li>
 *   <li>{@code tokens[i]} is either an operator or an integer.</li>
 *   <li>{@code -200 <= Integer.parseInt(tokens[i]) <= 200}</li>
 * </ul>
 */
public class EvaluateReversePolishNotation {

public int solution(String[] tokens) {
	// Your solution
	
	Stack<Integer> stack = new Stack<>();
	
	for (String token : tokens) {
	
		if(isOperator(token)) {
			int b = stack.pop();
			int a = stack.pop();
			int result = applyOperator(token, a, b);
			stack.push(result);
		} else {
			stack.push(Integer.parseInt(token));
		}
	
	}
	
	return stack.pop();
}

private int applyOperator(String token, int a, int b) {
	switch (token) {
		case "+": return a + b;
		case "-": return a - b;
		case "*": return a * b;
		case "/": return a / b;
		default: throw new IllegalArgumentException("Invalid operator");
		
	}
}

private boolean isOperator(String token) {
	return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
}

public static void main(String[] args) {
	EvaluateReversePolishNotation solution =
			new EvaluateReversePolishNotation();
	
	// Test case 1
	String[] tokens1 = {"2", "1", "+", "3", "*"};
	int result1 = solution.solution(tokens1);
	System.out.println(
			"Test 1: " + result1 + " | Expected: 9"
	);
	
	// Test case 2
	String[] tokens2 = {"4", "13", "5", "/", "+"};
	int result2 = solution.solution(tokens2);
	System.out.println(
			"Test 2: " + result2 + " | Expected: 6"
	);
	
	// Test case 3
	String[] tokens3 = {
			"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"
	};
	int result3 = solution.solution(tokens3);
	System.out.println(
			"Test 3: " + result3 + " | Expected: 22"
	);
	
	// Test case 4
	String[] tokens4 = {"3", "4", "+"};
	int result4 = solution.solution(tokens4);
	System.out.println(
			"Test 4: " + result4 + " | Expected: 7"
	);
	
	// Test case 5
	String[] tokens5 = {"7", "2", "/"};
	int result5 = solution.solution(tokens5);
	System.out.println(
			"Test 5: " + result5 + " | Expected: 3"
	);
}
}