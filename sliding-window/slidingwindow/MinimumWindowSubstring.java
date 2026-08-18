package slidingwindow;

/**
 * Minimum Window Substring
 *
 * <p>Given two strings {@code s} and {@code t} of lengths {@code m} and
 * {@code n}, return the minimum window substring of {@code s} such that
 * every character in {@code t} (including duplicates) is included in the
 * window.
 *
 * <p>If there is no such substring, return the empty string {@code ""}.
 *
 * <p>The test cases will be generated such that the answer is unique.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 *
 * Input:  s = "a", t = "a"
 * Output: "a"
 *
 * Input:  s = "a", t = "aa"
 * Output: ""
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code m == s.length}</li>
 *   <li>{@code n == t.length}</li>
 *   <li>{@code 1 <= m, n <= 100000}</li>
 *   <li>{@code s} and {@code t} consist of uppercase and lowercase English
 *       letters.</li>
 * </ul>
 */
public class MinimumWindowSubstring {

public String solution(String s, String t) {
	// Your solution
	if(s == null || t ==null || s.length() < t.length()) {
		return "";
	}
	
	int[] targetCount = new int[128];
	
	for(char c: t.toCharArray()) {
		targetCount[c]++;
	}
	
	int[] windowCount = new int[128];
	
	
	int required = 0;
	
	for(int count: targetCount) {
		if(count > 0) {
			required++;
		}
	}
	
	int left=0;
	int right=0;
	int formed = 0;
	
	int minLength = Integer.MAX_VALUE;
	int startIdx = 0;
	
	while(right < s.length()) {
		
		char rightChar = s.charAt(right);
		windowCount[rightChar]++;
		
		if(targetCount[rightChar] > 0 && windowCount[rightChar] == targetCount[rightChar]) {
			formed++;
		}
		
		while(left <= right && formed == required) {
			char leftChar = s.charAt(left);
			
			if(right - left + 1 <  minLength) {
				minLength = right - left + 1;
				startIdx = left;
			}
			
			windowCount[leftChar]--;
		
			if(targetCount[leftChar] > 0 && windowCount[leftChar] < targetCount[leftChar]) {
				formed--;
			}
			left++;
		
		}
		right++;
		
	}
	
	return minLength == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLength);
}

public static void main(String[] args) {
	MinimumWindowSubstring solution = new MinimumWindowSubstring();
	
	// Test case 1
	String s1 = "ADOBECODEBANC";
	String t1 = "ABC";
	String result1 = solution.solution(s1, t1);
	System.out.println(
			"Test 1: " + result1 + " | Expected: BANC"
	);
	
	// Test case 2
	String s2 = "a";
	String t2 = "a";
	String result2 = solution.solution(s2, t2);
	System.out.println(
			"Test 2: " + result2 + " | Expected: a"
	);
	
	// Test case 3
	String s3 = "a";
	String t3 = "aa";
	String result3 = solution.solution(s3, t3);
	System.out.println(
			"Test 3: " + result3 + " | Expected: \"\""
	);
	
	// Test case 4
	String s4 = "ab";
	String t4 = "b";
	String result4 = solution.solution(s4, t4);
	System.out.println(
			"Test 4: " + result4 + " | Expected: b"
	);
	
	// Test case 5
	String s5 = "aa";
	String t5 = "aa";
	String result5 = solution.solution(s5, t5);
	System.out.println(
			"Test 5: " + result5 + " | Expected: aa"
	);
}
}