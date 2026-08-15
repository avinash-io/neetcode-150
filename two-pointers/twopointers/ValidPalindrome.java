package twopointers;

/**
 * Valid Palindrome
 *
 * <p>A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads
 * the same forward and backward.
 *
 * <p>Alphanumeric characters include letters and numbers.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  s = "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Input:  s = "race a car"
 * Output: false
 *
 * Input:  s = " "
 * Output: true
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 1 <= s.length <= 200000}</li>
 *   <li>{@code s} consists only of printable ASCII characters.</li>
 * </ul>
 */
public class ValidPalindrome {

public boolean solution(String s) {
	// Your solution
	int left = 0;
	int right = s.length()-1;
	
	while(left<right) {
		
		while(left<right && !Character.isLetterOrDigit(s.charAt(left))) {
			left++;
		}
		
		while(left<right && !Character.isLetterOrDigit(s.charAt(right))) {
			right--;
		}
		
		if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
			return false;
		}
		
		left++;
		right--;
		
	}
	
	return true;
}

public static void main(String[] args) {
	ValidPalindrome solution = new ValidPalindrome();
	
	// Test case 1
	String s1 = "A man, a plan, a canal: Panama";
	boolean result1 = solution.solution(s1);
	System.out.println(
			"Test 1: " + result1 + " | Expected: true"
	);
	
	// Test case 2
	String s2 = "race a car";
	boolean result2 = solution.solution(s2);
	System.out.println(
			"Test 2: " + result2 + " | Expected: false"
	);
	
	// Test case 3
	String s3 = " ";
	boolean result3 = solution.solution(s3);
	System.out.println(
			"Test 3: " + result3 + " | Expected: true"
	);
	
	// Test case 4
	String s4 = "a";
	boolean result4 = solution.solution(s4);
	System.out.println(
			"Test 4: " + result4 + " | Expected: true"
	);
	
	// Test case 5
	String s5 = "0P";
	boolean result5 = solution.solution(s5);
	System.out.println(
			"Test 5: " + result5 + " | Expected: false"
	);
}
}