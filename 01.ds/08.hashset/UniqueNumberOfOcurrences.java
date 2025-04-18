
/**
 * Given an array of integers, determine if the number of times each distinct integer appears in the array is unique.

    In other words, the occurrences of each integer in the array should be distinct from the occurrences of every other integer.

    Examples:

    Input: [4, 5, 4, 6, 6, 6]
    Expected Output: true
    Justification: The number 4 appears 2 times, 5 appears 1 time, and 6 appears 3 times. All these occurrences (1, 2, 3) are unique.
    Input: [7, 8, 8, 9, 9, 9, 10, 10]
    Expected Output: false
    Justification: The number 7 appears 1 time, 8 appears 2 times, 9 appears 3 times, and 10 appears 2 times. The occurrences are not unique since the number 2 appears twice.
    Input: [11, 12, 13, 14, 14, 15, 15, 15]
    Expected Output: false
    Justification: The number 11 appears 1 time, 12 appears 1 time, 13 appears 1 time, 14 appears 2 times, and 15 appears 3 times. These occurrences are not unique.
    Constraints:

    1 <= arr.length <= 1000
    -1000 <= arr[i] <= 1000
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOcurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> mySet = new HashSet<>();
        Map<Integer, Integer> myMap = new HashMap<>();

        for (int cur : arr) {
            myMap.put(cur, myMap.getOrDefault(cur, 0) + 1);
        }

        for (int key : myMap.keySet()) {
            mySet.add(myMap.get(key));
        }

        return mySet.size() == myMap.size();
    }

    public static void main(String[] args) {
        UniqueNumberOfOcurrences obj = new UniqueNumberOfOcurrences();
        int[] arr1 = { 4, 5, 4, 6, 6, 6 };
        int[] arr2 = { 7, 8, 8, 9, 9, 9, 10, 10 };
        int[] arr3 = { 11, 12, 13, 14, 14, 15, 15, 15 };

        System.out.println(obj.uniqueOccurrences(arr1)); // true
        System.out.println(obj.uniqueOccurrences(arr2)); // false
        System.out.println(obj.uniqueOccurrences(arr3)); // false
    }
}

// Time Complexity: O(n), where n is the number of elements in the array. We
// traverse the array once to count occurrences and then traverse the map to
// check for uniqueness.
// Space Complexity: O(n), where n is the number of distinct elements in the
// array. We use a map to store the counts and a set to check for uniqueness.