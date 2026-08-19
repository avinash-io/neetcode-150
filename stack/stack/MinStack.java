package stack;

/**
 * Min Stack
 *
 * <p>Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 *
 * <p>Implement the {@code MinStack} class:
 *
 * <ul>
 *   <li>{@code MinStack()} initializes the stack object.</li>
 *   <li>{@code void push(int val)} pushes the element {@code val} onto the stack.</li>
 *   <li>{@code void pop()} removes the element on the top of the stack.</li>
 *   <li>{@code int top()} gets the top element of the stack.</li>
 *   <li>{@code int getMin()} retrieves the minimum element in the stack.</li>
 * </ul>
 *
 * <p>Each operation must run in {@code O(1)} time.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:
 * ["MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"]
 * [[], [-2], [0], [-3], [], [], [], []]
 *
 * Output:
 * [null, null, null, null, -3, null, 0, -2]
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code -2^31 <= val <= 2^31 - 1}</li>
 *   <li>Methods {@code pop}, {@code top}, and {@code getMin} will only be
 *       called on non-empty stacks.</li>
 * </ul>
 */
public class MinStack {

private class Node {
	int val;
	int min;
	Node next;
	public Node(int val, int min, Node next) {
		this.val = val;
		this.min = min;
		this.next = next;
	}
}

private Node head;

public void push(int val) {
	// Your solution
	if (head == null) {
		head = new Node(val, val, null);
	} else  {
		head = new Node(val, Math.min(val, head.min), head);
	}
}

public void pop() {
	// Your solution
	head = head.next;
}

public int top() {
	// Your solution
	return head.val;
}

public int getMin() {
	// Your solution
	return head.min;
}



public static void main(String[] args) {
	MinStack solution = new MinStack();
	
	// Test case 1
	solution.push(-2);
	solution.push(0);
	solution.push(-3);
	
	System.out.println(
			"Test 1 - getMin: " + solution.getMin()
					+ " | Expected: -3"
	);
	
	solution.pop();
	
	System.out.println(
			"Test 1 - top: " + solution.top()
					+ " | Expected: 0"
	);
	
	System.out.println(
			"Test 1 - getMin: " + solution.getMin()
					+ " | Expected: -2"
	);
	
	// Test case 2
	MinStack solution2 = new MinStack();
	
	solution2.push(5);
	solution2.push(3);
	solution2.push(7);
	solution2.push(2);
	
	System.out.println(
			"Test 2 - getMin: " + solution2.getMin()
					+ " | Expected: 2"
	);
	
	solution2.pop();
	
	System.out.println(
			"Test 2 - getMin after pop: " + solution2.getMin()
					+ " | Expected: 3"
	);
	
	// Test case 3
	MinStack solution3 = new MinStack();
	
	solution3.push(1);
	solution3.push(1);
	solution3.push(-1);
	
	System.out.println(
			"Test 3 - getMin: " + solution3.getMin()
					+ " | Expected: -1"
	);
	
	solution3.pop();
	
	System.out.println(
			"Test 3 - getMin after pop: " + solution3.getMin()
					+ " | Expected: 1"
	);
}
}