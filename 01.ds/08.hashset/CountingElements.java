
/**
 * Given a list of integers, determine the count of numbers for which there exists another number in the list that is greater by exactly one unit.

    In other words, for each number x in the list, if x + 1 also exists in the list, then x is considered for the count.

    Examples:

    Example 1:

    Input: [4, 3, 1, 5, 6]
    Expected Output: 3
    Justification: The numbers 4, 3, and 5 have 5, 4, and 6 respectively in the list, which are greater by exactly one unit.
    Example 2:

    Input: [7, 8, 9, 10]
    Expected Output: 3
    Justification: The numbers 7, 8, and 9 have 8, 9, and 10 respectively in the list, which are greater by exactly one unit.
    Example 3:

    Input: [11, 13, 15, 16]
    Expected Output: 1
    Justification: Only the number 15 has 16 in the list, which is greater by exactly one unit.
    Constraints:

    1 <= arr.length <= 1000
    0 <= arr[i] <= 1000
 */

import java.util.HashSet;
import java.util.Set;

public class CountingElements {
    public int countElements(int[] arr) {
        int count = 0;
        Set<Integer> mySet = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            mySet.add(arr[i]);

            if (mySet.contains(arr[i] + 1) || mySet.contains(arr[i] - 1)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountingElements ce = new CountingElements();
        int[] arr1 = { 4, 3, 1, 5, 6 };
        int[] arr2 = { 7, 8, 9, 10 };
        int[] arr3 = { 11, 13, 15, 16 };

        System.out.println(ce.countElements(arr1)); // Output: 3
        System.out.println(ce.countElements(arr2)); // Output: 3
        System.out.println(ce.countElements(arr3)); // Output: 1
    }
}

// Time Complexity: O(n), where n is the length of the input array. This is
// because we are iterating through the array once to add elements to the set
// and check for their presence.
// Space Complexity: O(n), where n is the number of unique elements in the input
// array. This is because we are using a HashSet to store the elements of the
// array.
