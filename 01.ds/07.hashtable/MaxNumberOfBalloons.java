
/**
 * Given a string, determine the maximum number of times the word "balloon" can be formed using the characters from the string. Each character in the string can be used only once.

    Examples:

    Example 1:

    Input: "balloonballoon"
    Expected Output: 2
    Justification: The word "balloon" can be formed twice from the given string.
    Example 2:

    Input: "bbaall"
    Expected Output: 0
    Justification: The word "balloon" cannot be formed from the given string as we are missing the character 'o' twice.
    Example 3:

    Input: "balloonballoooon"
    Expected Output: 2
    Justification: The word "balloon" can be formed twice, even though there are extra 'o' characters.
    Constraints:

    1 <= text.length <= 10^4
    text consists of lower case English letters only.
 */

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfBalloons {
    public static void main(String[] args) {
        MaxNumberOfBalloons obj = new MaxNumberOfBalloons();
        String text = "balloonballoon";
        int result = obj.maxNumberOfBalloons(text);
        System.out.println("Maximum number of 'balloon' that can be formed: " + result);
    }

    public int maxNumberOfBalloons(String text) {
        int minCount = Integer.MAX_VALUE;
        Map<Character, Integer> myMap = new HashMap<>();
        Map<Character, Integer> myMap2 = new HashMap<>();
        String s = "balloon";

        for (char c : s.toCharArray()) {
            if (myMap.containsKey(c)) {
                myMap.put(c, myMap.get(c) + 1);
            } else {
                myMap.put(c, 1);
            }
        }
        System.out.println(myMap.toString());

        for (char c : text.toCharArray()) {
            if (myMap.containsKey(c)) {
                if (myMap2.containsKey(c)) {
                    myMap2.put(c, myMap2.get(c) + 1);
                } else {
                    myMap2.put(c, 1);
                }
            }
        }

        System.out.println(myMap2.toString());

        for (char c : myMap.keySet()) {
            if (!myMap2.containsKey(c)) {
                return 0;
            }

            int times = myMap2.get(c) / myMap.get(c);
            if (minCount > times) {
                minCount = times;
            }
        }

        return minCount;
    }
}

// Time Complexity: O(n), where n is the length of the input string text.
// Space Complexity: O(1), since the size of the hash map is constant (limited
// to the characters in "balloon").
