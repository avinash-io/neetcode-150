package arraysandhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Encode and Decode Strings
 *
 * <p>Design an algorithm to encode a list of strings to a single string,
 * and decode that single string back to the original list of strings.
 *
 * <p>There are no restrictions on the characters that may appear in the
 * strings, including empty strings.
 *
 * <p>Your encoding and decoding methods should be reversible:
 *
 * <pre>
 * encode(decode(encoded)) == encoded
 * decode(encode(strs)) == strs
 * </pre>
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  ["lint", "code", "love", "you"]
 * Encoded: "4#lint4#code4#love3#you"
 * Decoded: ["lint", "code", "love", "you"]
 *
 * Input:  ["we", "say", ":", "yes"]
 * Decoded: ["we", "say", ":", "yes"]
 *
 * Input:  ["", "hello", ""]
 * Decoded: ["", "hello", ""]
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 0 <= strs.length <= 200}</li>
 *   <li>{@code 0 <= strs[i].length <= 200}</li>
 *   <li>Strings may contain any valid characters.</li>
 * </ul>
 */
public class EncodeAndDecodeStrings {

public String encode(List<String> strs) {
	// Your solution
	
	if (strs == null || strs.isEmpty()) {
		return "";
	}
	
	StringBuilder sb = new StringBuilder();
	for (String s : strs) {
		// Append length, a delimiter, and the string itself
		sb.append(s.length()).append("#").append(s);
	}
	return sb.toString();

}

public List<String> decode(String s) {
	// Your solution
	List<String> result = new ArrayList<>();
	if (s.isEmpty()) {
		return result;
	}
	
	int i = 0;
	while (i < s.length()) {
		// Find where the delimiter '#' is
		int delimiterIndex = s.indexOf('#', i);
		
		// Parse out the length of the upcoming string
		int length = Integer.parseInt(s.substring(i, delimiterIndex));
		
		// Move pointer past the '#'
		i = delimiterIndex + 1;
		
		// Extract the exact substring based on the read length
		String str = s.substring(i, i + length);
		result.add(str);
		
		// Move pointer to the start of the next length prefix
		i += length;
	}
	
	return result;
}

public static void main(String[] args) {
	EncodeAndDecodeStrings solution = new EncodeAndDecodeStrings();
	
	// Test case 1
	List<String> strs1 = Arrays.asList("lint", "code", "love", "you");
	String encoded1 = solution.encode(strs1);
	List<String> decoded1 = solution.decode(encoded1);
	
	System.out.println(
			"Test 1: " + decoded1
					+ " | Expected: [lint, code, love, you]"
	);
	
	// Test case 2
	List<String> strs2 = Arrays.asList("we", "say", ":", "yes");
	String encoded2 = solution.encode(strs2);
	List<String> decoded2 = solution.decode(encoded2);
	
	System.out.println(
			"Test 2: " + decoded2
					+ " | Expected: [we, say, :, yes]"
	);
	
	// Test case 3
	List<String> strs3 = Arrays.asList("", "hello", "");
	String encoded3 = solution.encode(strs3);
	List<String> decoded3 = solution.decode(encoded3);
	
	System.out.println(
			"Test 3: " + decoded3
					+ " | Expected: [, hello, ]"
	);
	
	// Test case 4
	List<String> strs4 = List.of();
	String encoded4 = solution.encode(strs4);
	List<String> decoded4 = solution.decode(encoded4);
	
	System.out.println(
			"Test 4: " + decoded4
					+ " | Expected: []"
	);
}
}