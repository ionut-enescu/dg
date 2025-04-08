
/**
 * Given a string, identify the position of the first character that appears only once in the string. If no such character exists, return -1.

    Examples

    Example 1:

    Input: "apple"
    Expected Output: 0
    Justification: The first character 'a' appears only once in the string and is the first character.
    Example 2:

    Input: "abcab"
    Expected Output: 2
    Justification: The first character that appears only once is 'c' and its position is 2.
    Example 3:

    Input: "abab"
    Expected Output: -1
    Justification: There is no character in the string that appears only once.
    Constraints:

    1 <= s.length <= 10^5
    s consists of only lowercase English letters.
*/

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public int firstUniqChar(String s) {
        Map<Character, Integer> myMap = new HashMap<>();
        char[] arr = s.toCharArray();

        for (char c : arr) {
            if (myMap.containsKey(c)) {
                myMap.put(c, myMap.get(c) + 1);
            } else {
                myMap.put(c, 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (myMap.get(arr[i]) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstNonRepeatingChar solution = new FirstNonRepeatingChar();
        System.out.println(solution.firstUniqChar("apple")); // Output: 0
        System.out.println(solution.firstUniqChar("abcab")); // Output: 2
        System.out.println(solution.firstUniqChar("abab")); // Output: -1
    }
}

// Time Complexity: O(n), where n is the length of the string. We traverse the
// string twice: once to count the occurrences and once to find the first unique
// character.
// Space Complexity: O(1), since the size of the map is constant (only lowercase
// English letters).
