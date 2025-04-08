
/**
 * Given two strings, one representing a ransom note and the other representing the available letters from a magazine, determine if it's possible to construct the ransom note using only the letters from the magazine. Each letter from the magazine can be used only once.

    Examples:

    Example 1:

    Input: Ransom Note = "hello", Magazine = "hellworld"
    Expected Output: true
    Justification: The word "hello" can be constructed from the letters in "hellworld".
    Example 2:

    Input: Ransom Note = "notes", Magazine = "stoned"
    Expected Output: true
    Justification: The word "notes" can be fully constructed from "stoned" from its first 5 letters.
    Example 3:

    Input: Ransom Note = "apple", Magazine = "pale"
    Expected Output: false
    Justification: The word "apple" cannot be constructed from "pale" as we are missing one 'p'.
    Constraints:

    1 <= ransomNote.length, magazine.length <= 10^5
    ransomNote and magazine consist of lowercase English letters.
 */

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> rnMap = new HashMap<>();
        Map<Character, Integer> mMap = new HashMap<>();

        for (char c : ransomNote.toCharArray()) {
            rnMap.put(c, rnMap.getOrDefault(c, 0) + 1);
        }

        for (char c : magazine.toCharArray()) {
            mMap.put(c, mMap.getOrDefault(c, 0) + 1);
        }

        for (char c : rnMap.keySet()) {
            if (!mMap.containsKey(c) || mMap.get(c) < rnMap.get(c)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        RansomNote rn = new RansomNote();
        System.out.println(rn.canConstruct("hello", "helloworld")); // true
        System.out.println(rn.canConstruct("notes", "stoned")); // true
        System.out.println(rn.canConstruct("apple", "pale")); // false
    }
}
