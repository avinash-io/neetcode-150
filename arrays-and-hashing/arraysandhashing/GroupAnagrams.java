package arraysandhashing;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Group Anagrams
 *
 * <p>Given an array of strings {@code strs}, group the anagrams together.
 * You can return the answer in any order.
 *
 * <p>An anagram is a word or phrase formed by rearranging the letters of
 * another word or phrase, using all the original letters exactly once.
 *
 * <p>Examples:
 *
 * <pre>
 * Input:  strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * Output: [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]
 *
 * Input:  strs = [""]
 * Output: [[""]]
 *
 * Input:  strs = ["a"]
 * Output: [["a"]]
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 1 <= strs.length <= 10000}</li>
 *   <li>{@code 0 <= strs[i].length <= 100}</li>
 *   <li>{@code strs[i]} consists of lowercase English letters</li>
 * </ul>
 */
public class GroupAnagrams {

public List<List<String>> solution(String[] strs) {
	// Your solution
	
	if (strs.length == 0) return new ArrayList<>();
	
	// FIX 1: Added <String> generics to the Map definition
	Map<String, List<String>> ansMap = new HashMap<>();
	
	//int[] count = new int[26];
	
	for (String str : strs) {
		int[] count = new int[26];
		
		for (char c : str.toCharArray()) {
			count[c - 'a']++;
		}
		
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < 26; i++) {
			sb.append("#");
			sb.append(count[i]);
		}
		
		String key = sb.toString();
		
		// FIX 2: Added diamond operator < > to the ArrayList instantiation
		if (!ansMap.containsKey(key)) {
			ansMap.put(key, new ArrayList<>());
		}
		
		ansMap.get(key).add(str);
	}
	
	// FIX 3: Added diamond operator < > to match the method return signature
	return new ArrayList<>(ansMap.values());
	
}

public static void main(String[] args) {
	GroupAnagrams solution = new GroupAnagrams();
	
	// Test case 1
	String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
	List<List<String>> result1 = solution.solution(strs1);
	System.out.println(
			"Test 1: " + result1
					+ " | Expected: [[eat, tea, ate], [tan, nat], [bat]]"
	);
	
	// Test case 2
	String[] strs2 = {""};
	List<List<String>> result2 = solution.solution(strs2);
	System.out.println(
			"Test 2: " + result2
					+ " | Expected: [[\"\"]]"
	);
	
	// Test case 3
	String[] strs3 = {"a"};
	List<List<String>> result3 = solution.solution(strs3);
	System.out.println(
			"Test 3: " + result3
					+ " | Expected: [[a]]"
	);
	
	// Test case 4
	String[] strs4 = {"abc", "bca", "cab", "xyz", "zyx"};
	List<List<String>> result4 = solution.solution(strs4);
	System.out.println(
			"Test 4: " + result4
					+ " | Expected: [[abc, bca, cab], [xyz, zyx]]"
	);
}
}