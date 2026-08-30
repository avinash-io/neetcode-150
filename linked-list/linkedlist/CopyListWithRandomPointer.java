package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Copy List with Random Pointer
 *
 * <p>A linked list of length {@code n} is given such that each node contains
 * an additional random pointer, which could point to any node in the list
 * or {@code null}.
 *
 * <p>Construct a deep copy of the list. The deep copy should consist of
 * exactly {@code n} brand-new nodes, where each new node has the same value
 * as its corresponding original node.
 *
 * <p>Both the {@code next} and {@code random} pointers of the new nodes should
 * point to nodes in the copied list, preserving the same relationships as
 * the original list.
 *
 * <p>No pointer in the new list should reference a node from the original
 * list.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:
 * head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * Output:
 * [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * Input:
 * head = [[1,1],[2,1]]
 *
 * Output:
 * [[1,1],[2,1]]
 *
 * Input:
 * head = []
 *
 * Output:
 * []
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 0 <= n <= 1000}</li>
 *   <li>{@code -10000 <= Node.val <= 10000}</li>
 *   <li>{@code random} is either {@code null} or points to a node in the
 *       linked list.</li>
 * </ul>
 *
 * <p>Follow-up: Can you solve this in {@code O(n)} time and {@code O(1)}
 * extra space?
 */
public class CopyListWithRandomPointer {

static class Node {
	int val;
	Node next;
	Node random;
	
	Node(int val) {
		this.val = val;
	}
}

public Node solution(Node head) {
	// Your solution
	return null;
}

public static void main(String[] args) {
	CopyListWithRandomPointer solution =
			new CopyListWithRandomPointer();
	
	// Test case 1
	Node head1 = createList(7, 13, 11, 10, 1);
	
	head1.random = null;
	head1.next.random = head1;
	head1.next.next.random = head1.next.next.next.next;
	head1.next.next.next.random = head1.next.next;
	head1.next.next.next.next.random = head1;
	
	Node result1 = solution.solution(head1);
	
	System.out.println(
			"Test 1: " + listToString(result1)
					+ " | Expected: [7->null, 13->7, 11->1, 10->11, 1->7]"
	);
	
	// Test case 2
	Node head2 = createList(1, 2);
	
	head2.random = head2.next;
	head2.next.random = head2.next;
	
	Node result2 = solution.solution(head2);
	
	System.out.println(
			"Test 2: " + listToString(result2)
					+ " | Expected: [1->2, 2->2]"
	);
	
	// Test case 3
	Node head3 = null;
	
	Node result3 = solution.solution(head3);
	
	System.out.println(
			"Test 3: " + listToString(result3)
					+ " | Expected: []"
	);
	
	// Test case 4
	Node head4 = createList(1);
	
	head4.random = head4;
	
	Node result4 = solution.solution(head4);
	
	System.out.println(
			"Test 4: " + listToString(result4)
					+ " | Expected: [1->1]"
	);
}

private static Node createList(int... values) {
	if (values.length == 0) {
		return null;
	}
	
	Node head = new Node(values[0]);
	Node current = head;
	
	for (int i = 1; i < values.length; i++) {
		current.next = new Node(values[i]);
		current = current.next;
	}
	
	return head;
}

private static String listToString(Node head) {
	if (head == null) {
		return "[]";
	}
	
	StringBuilder result = new StringBuilder("[");
	Node current = head;
	
	while (current != null) {
		result.append(current.val)
				.append("->");
		
		if (current.random == null) {
			result.append("null");
		} else {
			result.append(current.random.val);
		}
		
		if (current.next != null) {
			result.append(", ");
		}
		
		current = current.next;
	}
	
	result.append("]");
	return result.toString();
}
}