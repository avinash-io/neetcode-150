package slidingwindow;

/**
 * Longest Repeating Character Replacement
 *
 * <p>You are given a string {@code s} and an integer {@code k}. You can choose
 * to replace any character in the string with any other uppercase English
 * character at most {@code k} times.
 *
 * <p>Return the length of the longest substring containing the same letter you
 * can get after performing the operations.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  s = "ABAB", k = 2
 * Output: 4
 *
 * Input:  s = "AABABBA", k = 1
 * Output: 4
 * </pre>
 *
 * <p>Explanation:
 *
 * <p>For {@code "AABABBA"} with {@code k = 1}, replace the {@code 'B'} at
 * index 4 with {@code 'A'} to obtain {@code "AABABBA"} → {@code "AABAABA"}
 * and the longest repeating-character substring has length 4.
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 1 <= s.length <= 100000}</li>
 *   <li>{@code s} consists only of uppercase English letters.</li>
 *   <li>{@code 0 <= k <= s.length()}</li>
 * </ul>
 */
public class LongestRepeatingCharacterReplacement {

public int solution(String s, int k) {
	// Your solution
	int[] occurrences = new int[26];
	int left = 0;
	int ans = 0;
	int maxcccurance = 0;
	
	for (int right = 0; right < s.length(); right++) {
		maxcccurance = Math.max(maxcccurance, ++occurrences[s.charAt(right) - 'A']);
		if(right - left + 1 - maxcccurance > k) {
			occurrences[s.charAt(left) - 'A']--;
			left++;
		}
		ans = Math.max(ans, right - left + 1);
	}
	
	return ans;
}

public static void main(String[] args) {
	LongestRepeatingCharacterReplacement solution =
			new LongestRepeatingCharacterReplacement();
	
	// Test case 1
	String s1 = "ABAB";
	int k1 = 2;
	int result1 = solution.solution(s1, k1);
	System.out.println(
			"Test 1: " + result1 + " | Expected: 4"
	);
	
	// Test case 2
	String s2 = "AABABBA";
	int k2 = 1;
	int result2 = solution.solution(s2, k2);
	System.out.println(
			"Test 2: " + result2 + " | Expected: 4"
	);
	
	// Test case 3
	String s3 = "AAAA";
	int k3 = 0;
	int result3 = solution.solution(s3, k3);
	System.out.println(
			"Test 3: " + result3 + " | Expected: 4"
	);
	
	// Test case 4
	String s4 = "ABCD";
	int k4 = 1;
	int result4 = solution.solution(s4, k4);
	System.out.println(
			"Test 4: " + result4 + " | Expected: 2"
	);
	
	// Test case 5
	String s5 = "BAAAB";
	int k5 = 2;
	int result5 = solution.solution(s5, k5);
	System.out.println(
			"Test 5: " + result5 + " | Expected: 5"
	);
}
}