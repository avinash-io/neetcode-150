package linkedlist;

/**
 * Reorder List
 *
 * <p>You are given the head of a singly linked list:
 *
 * <pre>
 * L0 → L1 → L2 → ... → Ln-1 → Ln
 * </pre>
 *
 * <p>Reorder the list to:
 *
 * <pre>
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → ...
 * </pre>
 *
 * <p>You may not modify the values in the list's nodes. Only the nodes
 * themselves may be changed.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  head = [1,2,3,4]
 * Output: [1,4,2,3]
 *
 * Input:  head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 *
 * Input:  head = [1]
 * Output: [1]
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>The number of nodes in the list is in the range {@code [1, 50000]}.</li>
 *   <li>{@code 1 <= Node.val <= 1000}</li>
 * </ul>
 *
 * <p>Follow-up: Can you solve this in {@code O(n)} time and {@code O(1)}
 * extra space?
 */
public class ReorderList {

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

public void solution(ListNode head) {
	// Your solution
	
	if(head == null || head.next == null) return;
	
	ListNode slow = head;
	ListNode fast = head;
	
	while(fast != null && fast.next != null ) {
		slow = slow.next;
		fast = fast.next.next;
	}
	
	ListNode curr = slow.next;
	slow.next = null;
	
	ListNode prev = null;
	
	while(curr != null) {
		ListNode temp = curr.next;
		curr.next = prev;
		prev = curr;
		curr = temp;
	}
	
	ListNode first = head;
	ListNode second = prev;
	
	while(second != null) {
		ListNode tmp1 = first.next;
		ListNode tmp2 = second.next;
		
		first.next = second;
		second.next = tmp1;
		
		first = tmp1;
		second = tmp2;
	}
}

public static void main(String[] args) {
	ReorderList solution = new ReorderList();
	
	// Test case 1
	ListNode head1 = createList(1, 2, 3, 4);
	solution.solution(head1);
	
	System.out.println(
			"Test 1: " + listToString(head1)
					+ " | Expected: [1, 4, 2, 3]"
	);
	
	// Test case 2
	ListNode head2 = createList(1, 2, 3, 4, 5);
	solution.solution(head2);
	
	System.out.println(
			"Test 2: " + listToString(head2)
					+ " | Expected: [1, 5, 2, 4, 3]"
	);
	
	// Test case 3
	ListNode head3 = createList(1);
	solution.solution(head3);
	
	System.out.println(
			"Test 3: " + listToString(head3)
					+ " | Expected: [1]"
	);
	
	// Test case 4
	ListNode head4 = createList(1, 2);
	solution.solution(head4);
	
	System.out.println(
			"Test 4: " + listToString(head4)
					+ " | Expected: [1, 2]"
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