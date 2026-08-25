package binarysearch;

/**
 * Koko Eating Bananas
 *
 * <p>Koko loves to eat bananas. There are {@code n} piles of bananas, where
 * {@code piles[i]} represents the number of bananas in the {@code i}-th pile.
 *
 * <p>The guards will return in {@code h} hours.
 *
 * <p>Koko can decide her eating speed of {@code k} bananas per hour.
 * Each hour, she chooses one pile and eats {@code k} bananas from that pile.
 * If the pile has fewer than {@code k} bananas, she eats all of them and
 * does not eat any more bananas during that hour.
 *
 * <p>Koko wants to eat all the bananas before the guards return.
 *
 * <p>Return the minimum integer {@code k} such that she can eat all the
 * bananas within {@code h} hours.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  piles = [3,6,7,11], h = 8
 * Output: 4
 *
 * Input:  piles = [30,11,23,4,20], h = 5
 * Output: 30
 *
 * Input:  piles = [30,11,23,4,20], h = 6
 * Output: 23
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 1 <= piles.length <= 10000}</li>
 *   <li>{@code 1 <= piles[i] <= 1000000000}</li>
 *   <li>{@code piles.length <= h <= 1000000000}</li>
 * </ul>
 */
public class KokoEatingBananas {

public int solution(int[] piles, int h) {
	// Your solution
	
	int left = 1;
	int right = 0;
	
	for(int pile : piles) {
		right  = Math.max(right, pile);
	}
	
	
	int result = right;
	
	while(left <= right) {
		int mid = left + (right - left)/2;
		
		if(canEatAll(piles, mid, h)) {
			result = mid;
			right = mid - 1;
		} else {
			left = mid + 1;
		}
	}
	
	return result;
}

private boolean canEatAll(int[] piles, int k, int h) {
	
	long totalHours = 0;
	
	for(int pile: piles) {
		totalHours += (pile + k - 1)/k;
		
		if(totalHours > h) {
			return false;
		}
	}
	
	return totalHours <= h;
}

public static void
main(String[] args) {
	KokoEatingBananas solution = new KokoEatingBananas();
	
	// Test case 1
	int[] piles1 = {3, 6, 7, 11};
	int h1 = 8;
	int result1 = solution.solution(piles1, h1);
	System.out.println(
			"Test 1: " + result1 + " | Expected: 4"
	);
	
	// Test case 2
	int[] piles2 = {30, 11, 23, 4, 20};
	int h2 = 5;
	int result2 = solution.solution(piles2, h2);
	System.out.println(
			"Test 2: " + result2 + " | Expected: 30"
	);
	
	// Test case 3
	int[] piles3 = {30, 11, 23, 4, 20};
	int h3 = 6;
	int result3 = solution.solution(piles3, h3);
	System.out.println(
			"Test 3: " + result3 + " | Expected: 23"
	);
	
	// Test case 4
	int[] piles4 = {1, 1, 1, 1};
	int h4 = 4;
	int result4 = solution.solution(piles4, h4);
	System.out.println(
			"Test 4: " + result4 + " | Expected: 1"
	);
	
	// Test case 5
	int[] piles5 = {10};
	int h5 = 5;
	int result5 = solution.solution(piles5, h5);
	System.out.println(
			"Test 5: " + result5 + " | Expected: 2"
	);
}
}