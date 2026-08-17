package slidingwindow;

/**
 * Permutation in String
 *
 * <p>Given two strings {@code s1} and {@code s2}, return {@code true} if
 * {@code s2} contains a permutation of {@code s1}, or {@code false} otherwise.
 *
 * <p>In other words, return {@code true} if one of the permutations of
 * {@code s1} is a substring of {@code s2}.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  s1 = "ab", s2 = "eidbaooo"
 * Output: true
 *
 * Explanation:
 * {@code s2} contains the permutation {@code "ba"}.
 *
 * Input:  s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 * Input:  s1 = "adc", s2 = "dcda"
 * Output: true
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 1 <= s1.length, s2.length <= 10000}</li>
 *   <li>{@code s1} and {@code s2} consist of lowercase English letters.</li>
 * </ul>
 */
public class PermutationInString {

public boolean solution(String s1, String s2) {
	s1 = s1.toLowerCase();
	s2 = s2.toLowerCase();
	
	if (s1.length() > s2.length()) { return false; }
	
	int[] s1Count = new int[26];
	int[] s2Count = new int[26];
	
	for (int i = 0; i < s1.length(); i++) {
		s1Count[s1.charAt(i) - 'a']++;
		s2Count[s2.charAt(i) - 'a']++;
	}
	
	int matches = 0;
	for (int i = 0; i < 26; i++) {
		if (s1Count[i] == s2Count[i]) { matches++; }
	}
	
	int left = 0;
	for (int right = s1.length(); right < s2.length(); right++) {
		if (matches == 26) { return true; }
		
		// 1. Right character entering the window
		int rChar = s2.charAt(right) - 'a';
		s2Count[rChar]++;
		if (s1Count[rChar] == s2Count[rChar]) {
			matches++;
		} else if (s1Count[rChar] + 1 == s2Count[rChar]) {
			matches--;
		}
		
		// 2. Left character leaving the window
		int lChar = s2.charAt(left) - 'a'; // FIX 1: Read from s2, NOT s1
		s2Count[lChar]--;                  // FIX 2: Decrement s2Count, NOT s1Count
		if (s1Count[lChar] == s2Count[lChar]) {
			matches++;
		} else if (s1Count[lChar] - 1 == s2Count[lChar]) {
			matches--;
		}
		
		left++;
	}
	
	return matches == 26; // FIX 3: Catches a match made on the very last window slide
}


public static void main(String[] args) {
	PermutationInString solution = new PermutationInString();
	
	// Test case 1
	String s1 = "ab";
	String s2 = "eidbaooo";
	boolean result1 = solution.solution(s1, s2);
	System.out.println(
			"Test 1: " + result1 + " | Expected: true"
	);
	
	// Test case 2
	String s3 = "ab";
	String s4 = "eidboaoo";
	boolean result2 = solution.solution(s3, s4);
	System.out.println(
			"Test 2: " + result2 + " | Expected: false"
	);
	
	// Test case 3
	String s5 = "adc";
	String s6 = "dcda";
	boolean result3 = solution.solution(s5, s6);
	System.out.println(
			"Test 3: " + result3 + " | Expected: true"
	);
	
	// Test case 4
	String s7 = "a";
	String s8 = "ab";
	boolean result4 = solution.solution(s7, s8);
	System.out.println(
			"Test 4: " + result4 + " | Expected: true"
	);
	
	// Test case 5
	String s9 = "abc";
	String s10 = "ccccbbbbaaaa";
	boolean result5 = solution.solution(s9, s10);
	System.out.println(
			"Test 5: " + result5 + " | Expected: false"
	);
	
	
	String s11 = "abc";
	String s12 = "efgh";
	boolean result6 = solution.solution(s9, s10);
	System.out.println(
			"Test 5: " + result6 + " | Expected: false"
	);
}
}