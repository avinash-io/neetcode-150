package slidingwindow;

/**
 * Best Time to Buy and Sell Stock
 *
 * <p>You are given an array {@code prices} where {@code prices[i]} is the price
 * of a given stock on the {@code i}-th day.
 *
 * <p>You want to maximize your profit by choosing a single day to buy one
 * stock and choosing a different day in the future to sell that stock.
 *
 * <p>Return the maximum profit you can achieve. If you cannot achieve any
 * profit, return {@code 0}.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  prices = [7,1,5,3,6,4]
 * Output: 5
 *
 * Explanation:
 * Buy on day 2 at price 1 and sell on day 5 at price 6.
 * Profit = 6 - 1 = 5.
 *
 * Input:  prices = [7,6,4,3,1]
 * Output: 0
 *
 * Explanation:
 * There is no way to make a positive profit.
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 1 <= prices.length <= 100000}</li>
 *   <li>{@code 0 <= prices[i] <= 10000}</li>
 * </ul>
 */
public class BestTimeToBuyAndSellStock {

public int solution(int[] prices) {
	// Your solution
	
	int buy = prices[0];
	int profit = 0;
	
	for (int i = 1; i < prices.length; i++) {
		if(prices[i] < buy) {
			buy = prices[i];
		}
		
		profit = Math.max(profit, prices[i] - buy);
	}
	
	return profit;
}

public static void main(String[] args) {
	BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
	
	// Test case 1
	int[] prices1 = {7, 1, 5, 3, 6, 4};
	int result1 = solution.solution(prices1);
	System.out.println(
			"Test 1: " + result1 + " | Expected: 5"
	);
	
	// Test case 2
	int[] prices2 = {7, 6, 4, 3, 1};
	int result2 = solution.solution(prices2);
	System.out.println(
			"Test 2: " + result2 + " | Expected: 0"
	);
	
	// Test case 3
	int[] prices3 = {1, 2, 3, 4, 5};
	int result3 = solution.solution(prices3);
	System.out.println(
			"Test 3: " + result3 + " | Expected: 4"
	);
	
	// Test case 4
	int[] prices4 = {2, 4, 1};
	int result4 = solution.solution(prices4);
	System.out.println(
			"Test 4: " + result4 + " | Expected: 2"
	);
}
}