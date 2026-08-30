package linkedlist;

/**
 * Merge Two Sorted Lists
 *
 * <p>You are given the heads of two sorted linked lists {@code list1} and
 * {@code list2}.
 *
 * <p>Merge the two lists into one sorted linked list and return the head
 * of the merged linked list.
 *
 * <p>The merged list should be made by splicing together the nodes of the
 * first two lists.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Input:  list1 = [], list2 = []
 * Output: []
 *
 * Input:  list1 = [], list2 = [0]
 * Output: [0]
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>The number of nodes in both lists is in the range {@code [0, 50]}.</li>
 *   <li>{@code -100 <= Node.val <= 100}</li>
 *   <li>Both {@code list1} and {@code list2} are sorted in non-decreasing
 *       order.</li>
 * </ul>
 */
public class MergeTwoSortedLists {

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

public ListNode solution(ListNode list1, ListNode list2) {
	// Your solution
	
	ListNode dummy = new ListNode(0);
	ListNode tail = dummy;
	
	while(list1 != null && list2 != null){
		if(list1.val <= list2.val){
			tail.next = list1;
			list1 = list1.next;
		} else {
			tail.next = list2;
			list2 = list2.next;
		}
		
		tail = tail.next;
	}
	
	if(list1 != null) {
		tail.next = list1;
	} else if (list2 != null) {
		tail.next = list2;
	}
	
	return dummy.next;
}

public static void main(String[] args) {
	MergeTwoSortedLists solution = new MergeTwoSortedLists();
	
	// Test case 1
	ListNode list1 = createList(1, 2, 4);
	ListNode list2 = createList(1, 3, 4);
	
	ListNode result1 = solution.solution(list1, list2);
	
	System.out.println(
			"Test 1: " + listToString(result1)
					+ " | Expected: [1, 1, 2, 3, 4, 4]"
	);
	
	// Test case 2
	ListNode list3 = null;
	ListNode list4 = null;
	
	ListNode result2 = solution.solution(list3, list4);
	
	System.out.println(
			"Test 2: " + listToString(result2)
					+ " | Expected: []"
	);
	
	// Test case 3
	ListNode list5 = null;
	ListNode list6 = createList(0);
	
	ListNode result3 = solution.solution(list5, list6);
	
	System.out.println(
			"Test 3: " + listToString(result3)
					+ " | Expected: [0]"
	);
	
	// Test case 4
	ListNode list7 = createList(1, 3, 5);
	ListNode list8 = createList(2, 4, 6);
	
	ListNode result4 = solution.solution(list7, list8);
	
	System.out.println(
			"Test 4: " + listToString(result4)
					+ " | Expected: [1, 2, 3, 4, 5, 6]"
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