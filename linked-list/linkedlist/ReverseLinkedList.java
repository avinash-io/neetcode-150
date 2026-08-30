package linkedlist;

/**
 * Reverse Linked List
 *
 * <p>Given the head of a singly linked list, reverse the list, and return
 * the reversed list.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Input:  head = [1,2]
 * Output: [2,1]
 *
 * Input:  head = []
 * Output: []
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>The number of nodes in the list is in the range {@code [0, 5000]}.</li>
 *   <li>{@code -5000 <= Node.val <= 5000}</li>
 * </ul>
 *
 * <p>Follow-up: A linked list can be reversed either iteratively or
 * recursively. Can you solve both ways?
 */
public class ReverseLinkedList {

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

public ListNode solution(ListNode head) {
	// Your solution
	ListNode prev = null;
	ListNode curr = head;
	
	while(curr != null) {
		ListNode tmp = curr.next;
		curr.next = prev;
		prev = curr;
		curr = tmp;
	}
	
	
	return prev;
}

public static void main(String[] args) {
	ReverseLinkedList solution = new ReverseLinkedList();
	
	// Test case 1
	ListNode head1 = createList(1, 2, 3, 4, 5);
	ListNode result1 = solution.solution(head1);
	
	System.out.println(
			"Test 1: " + listToString(result1)
					+ " | Expected: [5, 4, 3, 2, 1]"
	);
	
	// Test case 2
	ListNode head2 = createList(1, 2);
	ListNode result2 = solution.solution(head2);
	
	System.out.println(
			"Test 2: " + listToString(result2)
					+ " | Expected: [2, 1]"
	);
	
	// Test case 3
	ListNode head3 = null;
	ListNode result3 = solution.solution(head3);
	
	System.out.println(
			"Test 3: " + listToString(result3)
					+ " | Expected: []"
	);
	
	// Test case 4
	ListNode head4 = createList(1);
	ListNode result4 = solution.solution(head4);
	
	System.out.println(
			"Test 4: " + listToString(result4)
					+ " | Expected: [1]"
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