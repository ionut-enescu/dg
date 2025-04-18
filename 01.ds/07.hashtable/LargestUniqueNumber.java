
/**
 * Given an array of integers, identify the highest value that appears only once in the array. If no such number exists, return -1.

    Examples:

    Example 1:

    Input: [5, 7, 3, 7, 5, 8]
    Expected Output: 8
    Justification: The number 8 is the highest value that appears only once in the array.
    Example 2:

    Input: [1, 2, 3, 2, 1, 4, 4]
    Expected Output: 3
    Justification: The number 3 is the highest value that appears only once in the array.
    Example 3:

    Input: [9, 9, 8, 8, 7, 7]
    Expected Output: -1
    Justification: There is no number in the array that appears only once.
    Constraints:

    1 <= nums.length <= 2000
    0 <= nums[i] <= 1000
 */

import java.util.HashMap;
import java.util.Map;

public class LargestUniqueNumber {
    public static void main(String[] args) {
        LargestUniqueNumber lun = new LargestUniqueNumber();
        int[] A = { 5, 7, 3, 7, 5, 8 };
        System.out.println(lun.largestUniqueNumber(A)); // Output: 8

        int[] B = { 1, 2, 3, 2, 1, 4, 4 };
        System.out.println(lun.largestUniqueNumber(B)); // Output: 3

        int[] C = { 9, 9, 8, 8, 7, 7 };
        System.out.println(lun.largestUniqueNumber(C)); // Output: -1
    }

    public int largestUniqueNumber(int[] A) {
        int maxUnique = -1;
        Map<Integer, Integer> myMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (myMap.containsKey(A[i])) {
                myMap.put(A[i], myMap.get(A[i]) + 1);
            } else {
                myMap.put(A[i], 1);
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (maxUnique < A[i] && myMap.get(A[i]) == 1) {
                maxUnique = A[i];
            }
        }

        return maxUnique;
    }
}

// Time Complexity: O(n), where n is the length of the array A. We traverse the
// array twice: once to build the frequency map and once to find the maximum
// unique number.
// Space Complexity: O(n), where n is the number of unique elements in the array
// A. In the worst case, all elements are unique, and we store them in the map.
