package linkedlist;

/**
 * Remove Nth Node From End of List
 *
 * <p>Given the head of a linked list, remove the n-th node from the end of
 * the list and return its head.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Input:  head = [1], n = 1
 * Output: []
 *
 * Input:  head = [1,2], n = 1
 * Output: [1]
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>The number of nodes in the list is {@code sz}.</li>
 *   <li>{@code 1 <= sz <= 30}</li>
 *   <li>{@code 0 <= Node.val <= 100}</li>
 *   <li>{@code 1 <= n <= sz}</li>
 * </ul>
 *
 * <p>Follow-up: Could you solve this in one pass?
 */
public class RemoveNthNodeFromEndOfList {

static class ListNode {
	int val;
	ListNode next;
	
	ListNode() {
	}
	
	ListNode(int val) {
		this.val = val;
	}
	
	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public ListNode solution(ListNode head, int n) {
	// Your solution
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	
	ListNode left = dummy;
	ListNode right = dummy;
	
	for(int i = 0; i <= n; i++){
		if (right == null) {
			return head; // Or throw an IllegalArgumentException("n is out of bounds");
		}
		right = right.next;
	}
	
	while(right != null){
		left = left.next;
		right = right.next;
	}
	
	if (left.next != null) {
		left.next = left.next.next;
	}
	
	
	return dummy.next;
}

public static void main(String[] args) {
	RemoveNthNodeFromEndOfList solution =
			new RemoveNthNodeFromEndOfList();
	
	// Test case 1
	ListNode head1 = createList(1, 2, 3, 4, 5);
	ListNode result1 = solution.solution(head1, 2);
	
	System.out.println(
			"Test 1: " + listToString(result1)
					+ " | Expected: [1, 2, 3, 5]"
	);
	
	// Test case 2
	ListNode head2 = createList(1);
	ListNode result2 = solution.solution(head2, 1);
	
	System.out.println(
			"Test 2: " + listToString(result2)
					+ " | Expected: []"
	);
	
	// Test case 3
	ListNode head3 = createList(1, 2);
	ListNode result3 = solution.solution(head3, 1);
	
	System.out.println(
			"Test 3: " + listToString(result3)
					+ " | Expected: [1]"
	);
	
	// Test case 4
	ListNode head4 = createList(1, 2);
	ListNode result4 = solution.solution(head4, 2);
	
	System.out.println(
			"Test 4: " + listToString(result4)
					+ " | Expected: [2]"
	);
	
	// Test case 5
	ListNode head5 = createList(1, 2, 3);
	ListNode result5 = solution.solution(head5, 3);
	
	System.out.println(
			"Test 5: " + listToString(result5)
					+ " | Expected: [2, 3]"
	);
}

private static ListNode createList(int... values) {
	ListNode dummy = new ListNode(0);
	ListNode current = dummy;
	
	for (int value : values) {
		current.next = new ListNode(value);
		current = current.next;
	}
	
	return dummy.next;
}

private static String listToString(ListNode head) {
	StringBuilder result = new StringBuilder("[");
	ListNode current = head;
	
	while (current != null) {
		result.append(current.val);
		
		if (current.next != null) {
			result.append(", ");
		}
		
		current = current.next;
	}
	
	result.append("]");
	return result.toString();
}
}