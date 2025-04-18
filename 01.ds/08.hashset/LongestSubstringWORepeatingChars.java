
/**
 * Given a string, identify the length of its longest segment that contains distinct characters. In other words, find the maximum length of a substring that has no repeating characters.

    Examples:

    Example 1:

    Input: "abcdaef"
    Expected Output: 6
    Justification: The longest segment with distinct characters is "bcdaef", which has a length of 6.
    Example 2:

    Input: "aaaaa"
    Expected Output: 1
    Justification: The entire string consists of the same character. Thus, the longest segment with unique characters is just "a", with a length of 1.
    Example 3:

    Input: "abrkaabcdefghijjxxx"
    Expected Output: 10
    Justification: The longest segment with distinct characters is "abcdefghij", which has a length of 10.
    Constraints:

    0 <= s.length <= 5 * 10^4
    s consists of English letters, digits, symbols and spaces.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWORepeatingChars {
    public static void main(String[] args) {
        LongestSubstringWORepeatingChars obj = new LongestSubstringWORepeatingChars();
        String str = "abrkaabcdefghijjxxx";
        System.out.println(
                "Length of longest substring without repeating characters: " + obj.lengthOfLongestSubstring(str));
    }

    public int lengthOfLongestSubstring(String str) {
        int maxLength = 0;
        int curLength = 0;
        Set<Character> mySet = new HashSet<>();
        Map<Character, Integer> myMap = new HashMap<>();
        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            curLength++;
            if (!mySet.contains(charArray[i])) {
                mySet.add(charArray[i]);
            } else {
                int lastIndex = myMap.get(charArray[i]);
                if (i - lastIndex + 1 > curLength) {
                    maxLength = curLength;
                } else {
                    curLength -= myMap.get(charArray[i]) + 1;
                }
            }
            myMap.put(charArray[i], i);

            maxLength = Math.max(curLength, maxLength);
        }

        return Math.max(curLength, maxLength);
    }
}

// Time Complexity: O(n), where n is the length of the string. We traverse the
// string once, and each character is processed in constant time.
// Space Complexity: O(min(n, m)), where n is the length of the string and m is
// the size of the character set. In the worst case, we may store all characters
// in the set or map.
