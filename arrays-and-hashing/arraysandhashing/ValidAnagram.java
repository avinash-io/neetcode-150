package arraysandhashing;

/**
 * Valid Anagram
 *
 * <p>Given two strings {@code s} and {@code t}, return {@code true} if
 * {@code t} is an anagram of {@code s}, and {@code false} otherwise.
 *
 * <p>An anagram is a word or phrase formed by rearranging the letters
 * of another word or phrase, using all the original letters exactly once.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  s = "anagram", t = "nagaram"
 * Output: true
 *
 * Input:  s = "rat", t = "car"
 * Output: false
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 1 <= s.length, t.length <= 50000}</li>
 *   <li>{@code s} and {@code t} consist of lowercase English letters</li>
 * </ul>
 */
public class ValidAnagram {

public boolean solution(String s, String t) {
	// Your solution
	
	if(s.length()!=t.length()){
		return false;
	}
	
	char[] charCount = new char[26];
	
	for (int i=0; i < s.length();i++) {
		charCount[s.charAt(i)-'a']++;
		charCount[t.charAt(i)-'a']--;
		
	}
	
	for (char count : charCount) {
		
		if ( count !=0) {
			return false;
		}
		
	}
	
	return true;

}

public static void main(String[] args) {
	ValidAnagram solution = new ValidAnagram();
	
	// Test case 1
	String s1 = "anagram";
	String t1 = "nagaram";
	System.out.println(
			"Test 1: " + solution.solution(s1, t1) + " | Expected: true"
	);
	
	// Test case 2
	String s2 = "rat";
	String t2 = "car";
	System.out.println(
			"Test 2: " + solution.solution(s2, t2) + " | Expected: false"
	);
	
	// Test case 3
	String s3 = "listen";
	String t3 = "silent";
	System.out.println(
			"Test 3: " + solution.solution(s3, t3) + " | Expected: true"
	);
	
	// Test case 4
	String s4 = "hello";
	String t4 = "world";
	System.out.println(
			"Test 4: " + solution.solution(s4, t4) + " | Expected: false"
	);
}
}