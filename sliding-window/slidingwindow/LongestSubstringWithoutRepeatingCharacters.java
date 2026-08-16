package slidingwindow;

import java.util.HashSet;

/**
 * Longest Substring Without Repeating Characters
 *
 * <p>Given a string {@code s}, find the length of the longest substring
 * without duplicate characters.
 *
 * <p>A substring is a contiguous sequence of characters within a string.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  s = "abcabcbb"
 * Output: 3
 *
 * Explanation:
 * The answer is "abc", with a length of 3.
 *
 * Input:  s = "bbbbb"
 * Output: 1
 *
 * Explanation:
 * The answer is "b", with a length of 1.
 *
 * Input:  s = "pwwkew"
 * Output: 3
 *
 * Explanation:
 * The answer is "wke", with a length of 3.
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 0 <= s.length <= 50000}</li>
 *   <li>{@code s} consists of English letters, digits, symbols and spaces.</li>
 * </ul>
 */
public class LongestSubstringWithoutRepeatingCharacters {

public int solution(String s) {
	// Your solution
	if(s == null || s.length() == 0) {
		return 0;
	}
	
	if(s.length() == 1) {
		return 1;
	}
	
	int left = 0;
	int right = 0;
	int ans = 0;
	
	
	HashSet<Character> set = new HashSet<>();
	
	while(right < s.length()) {
		
		char c = s.charAt(right);
		
		while(set.contains(c)) {
			set.remove(s.charAt(left));
			left++;
		}
		
		set.add(c);
		ans = Math.max(ans, right - left + 1);
		right++;
	}
	
	
	return ans;
}

public static void main(String[] args) {
	LongestSubstringWithoutRepeatingCharacters solution =
			new LongestSubstringWithoutRepeatingCharacters();
	
	// Test case 1
	String s1 = "abcabcbb";
	int result1 = solution.solution(s1);
	System.out.println(
			"Test 1: " + result1 + " | Expected: 3"
	);
	
	// Test case 2
	String s2 = "bbbbb";
	int result2 = solution.solution(s2);
	System.out.println(
			"Test 2: " + result2 + " | Expected: 1"
	);
	
	// Test case 3
	String s3 = "pwwkew";
	int result3 = solution.solution(s3);
	System.out.println(
			"Test 3: " + result3 + " | Expected: 3"
	);
	
	// Test case 4
	String s4 = "";
	int result4 = solution.solution(s4);
	System.out.println(
			"Test 4: " + result4 + " | Expected: 0"
	);
	
	// Test case 5
	String s5 = "abcdef";
	int result5 = solution.solution(s5);
	System.out.println(
			"Test 5: " + result5 + " | Expected: 6"
	);
}
}