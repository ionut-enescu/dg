
/**
 * Given a string, determine the length of the longest palindrome that can be constructed using the characters from the string. You don't need to return the palindrome itself, just its maximum possible length.

    Examples:

    Input: "applepie"
    Expected Output: 5
    Justification: The longest palindrome that can be constructed from the string is "pepep", which has a length of 5. There are are other palindromes too but they all will be of length 5.
    Input: "aabbcc"
    Expected Output: 6
    Justification: We can form the palindrome "abccba" using the characters from the string, which has a length of 6.
    Input: "bananas"
    Expected Output: 5
    Justification: The longest palindrome that can be constructed from the string is "anana", which has a length of 5.
    Constraints:

    1 <= s.length <= 2000
    s consists of lowercase and/or uppercase English letters only.
 */

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int length = 0;
        Map<Character, Integer> myMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            myMap.put(c, myMap.getOrDefault(c, 0) + 1);
        }

        boolean addOne = false;

        for (char c : myMap.keySet()) {
            int cur = myMap.get(c);
            if (cur > 1) {
                length += cur % 2 == 0 ? cur : cur - 1;
            }

            if (!addOne) {
                if (cur == 1 || cur % 2 > 0) {
                    length++;
                    addOne = true;
                }
            }
        }

        return length;
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome("applepie")); // Output: 5
        System.out.println(lp.longestPalindrome("aabbcc")); // Output: 6
        System.out.println(lp.longestPalindrome("bananas")); // Output: 5
    }
}

// Time Complexity: O(n), where n is the length of the string s. We are
// iterating through the string once to count the characters and then iterating
// through the map to calculate the length of the longest palindrome.
// Space Complexity: O(n), where n is the number of unique characters in the
// string s. In the worst case, we may have to store all characters in the map.
