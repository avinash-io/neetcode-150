package binarysearch;

import java.lang.classfile.instruction.StoreInstruction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time Based Key-Value Store
 *
 * <p>Design a time-based key-value data structure that supports:
 *
 * <ul>
 *   <li>{@code set(String key, String value, int timestamp)}</li>
 *   <li>{@code get(String key, int timestamp)}</li>
 * </ul>
 *
 * <p>The {@code set} method stores the key-value pair together with the
 * timestamp.
 *
 * <p>The {@code get} method returns the value associated with the largest
 * timestamp that is less than or equal to the given timestamp.
 *
 * <p>If there are no values stored for the given key at or before the
 * requested timestamp, return an empty string.
 *
 * <p>Examples:
 *
 * <pre>
 * TimeMap timeMap = new TimeMap();
 *
 * timeMap.set("foo", "bar", 1);
 * timeMap.get("foo", 1);
 * // Output: "bar"
 *
 * timeMap.get("foo", 3);
 * // Output: "bar"
 *
 * timeMap.set("foo", "bar2", 4);
 * timeMap.get("foo", 4);
 * // Output: "bar2"
 *
 * timeMap.get("foo", 5);
 * // Output: "bar2"
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 1 <= key.length <= 100}</li>
 *   <li>{@code 1 <= value.length <= 100}</li>
 *   <li>{@code 1 <= timestamp <= 1000000000}</li>
 *   <li>All timestamps for a given key are strictly increasing.</li>
 *   <li>Up to {@code 200000} calls will be made to {@code set} and {@code get}.</li>
 * </ul>
 *
 * <p>The {@code get} operation should use binary search.
 */
public class TimeBasedKeyValueStore {

private final Map<String, List<Entry>> store;

private static class Entry {
	String value;
	int timestamp;
	
	Entry(String value, int timestamp) {
		this.value = value;
		this.timestamp = timestamp;
	}
}
public TimeBasedKeyValueStore() {
	store = new HashMap<>();
}

public void set(String key, String value, int timestamp) {
	// Your solution
	store.computeIfAbsent(key, k->new ArrayList<>()).add(new Entry(value, timestamp));
}

public String get(String key, int timestamp) {
	// Your solution
	
	if(!store.containsKey(key)) {
		return "";
	}
	
	List<Entry> versions = store.get(key);
	int left =0;
	int right = versions.size() - 1;
	String result = "";
	
	while(left<=right) {
		
		int mid = left + (right - left)/2;
		Entry current = versions.get(mid);
		
		if(current.timestamp == timestamp) {
			return current.value;
		} else if(current.timestamp < timestamp) {
			result = current.value;
			left = mid + 1;
		} else {
			right = mid - 1;
		}
	}
	
	return result;
}

public static void main(String[] args) {
	TimeBasedKeyValueStore solution = new TimeBasedKeyValueStore();
	
	// Test case 1
	solution.set("foo", "bar", 1);
	
	System.out.println(
			"Test 1: " + solution.get("foo", 1)
					+ " | Expected: bar"
	);
	
	// Test case 2
	System.out.println(
			"Test 2: " + solution.get("foo", 3)
					+ " | Expected: bar"
	);
	
	// Test case 3
	solution.set("foo", "bar2", 4);
	
	System.out.println(
			"Test 3: " + solution.get("foo", 4)
					+ " | Expected: bar2"
	);
	
	// Test case 4
	System.out.println(
			"Test 4: " + solution.get("foo", 5)
					+ " | Expected: bar2"
	);
	
	// Test case 5
	System.out.println(
			"Test 5: " + solution.get("foo", 0)
					+ " | Expected: \"\""
	);
	
	// Test case 6
	solution.set("baz", "hello", 2);
	
	System.out.println(
			"Test 6: " + solution.get("baz", 1)
					+ " | Expected: \"\""
	);
}
}