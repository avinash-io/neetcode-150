package arraysandhashing;

import java.util.*;

/**
 * Top K Frequent Elements
 *
 * <p>Given an integer array {@code nums} and an integer {@code k}, return the
 * {@code k} most frequent elements.
 *
 * <p>You may return the answer in any order.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Input:  nums = [1], k = 1
 * Output: [1]
 *
 * Input:  nums = [1,2,2,3,3,3], k = 2
 * Output: [3,2]
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 1 <= nums.length <= 100000}</li>
 *   <li>{@code -10000 <= nums[i] <= 10000}</li>
 *   <li>{@code 1 <= k <= number of unique elements in nums}</li>
 * </ul>
 *
 * <p>Follow-up: Can you solve this in better than {@code O(n log n)} time?
 */
public class TopKFrequentElements {

public int[] solution(int[] nums, int k) {
	// Your solution
	
	if(k == nums.length) {
		return nums;
	}
	
	Map<Integer, Integer> map = new HashMap<>();
	
	for(int num : nums) {
		map.put(num, map.getOrDefault(num,0)+1);
	}
	
	Queue<Integer> heap = new PriorityQueue<>(
			(a, b) -> map.get(a) - map.get(b));
	
	for (int num : map.keySet()) {
		heap.add(num);
		
		if(heap.size() > k) {
			heap.poll();
		}
	}
	
	int[] ans = new int[k];
	
	
	for (int i = 0; i < k; i++) {
		ans[i] = heap.poll();
	}
	
	return ans;
}

public static void main(String[] args) {
	TopKFrequentElements solution = new TopKFrequentElements();
	
	// Test case 1
	int[] nums1 = {1, 1, 1, 2, 2, 3};
	int k1 = 2;
	int[] result1 = solution.solution(nums1, k1);
	System.out.println(
			"Test 1: " + Arrays.toString(result1)
					+ " | Expected: [1, 2]"
	);
	
	// Test case 2
	int[] nums2 = {1};
	int k2 = 1;
	int[] result2 = solution.solution(nums2, k2);
	System.out.println(
			"Test 2: " + Arrays.toString(result2)
					+ " | Expected: [1]"
	);
	
	// Test case 3
	int[] nums3 = {1, 2, 2, 3, 3, 3};
	int k3 = 2;
	int[] result3 = solution.solution(nums3, k3);
	System.out.println(
			"Test 3: " + Arrays.toString(result3)
					+ " | Expected: [3, 2]"
	);
	
	// Test case 4
	int[] nums4 = {4, 4, 4, 4, 5, 5, 6};
	int k4 = 2;
	int[] result4 = solution.solution(nums4, k4);
	System.out.println(
			"Test 4: " + Arrays.toString(result4)
					+ " | Expected: [4, 5]"
	);
}
}