
/**
 * Given two strings. The first string represents types of jewels, where each character is a unique type of jewel. The second string represents stones you have, where each character represents a type of stone. Determine how many of the stones you have are also jewels.

    Examples:

    Example 1:

    Input: Jewels = "abc", Stones = "aabbcc"
    Expected Output: 6
    Justification: All the stones are jewels.
    Example 2:

    Input: Jewels = "aA", Stones = "aAaZz"
    Expected Output: 3
    Justification: There are 2 'a' and 1 'A' stones that are jewels.
    Example 3:

    Input: Jewels = "zZ", Stones = "zZzZzZ"
    Expected Output: 6
    Justification: All the stones are jewels.
    Constraints:

    1 <= jewels.length, stones.length <= 50
    jewels and stones consist of only English letters.
    All the characters of jewels are unique.
 */

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {
        JewelsAndStones jewelsAndStones = new JewelsAndStones();
        System.out.println(jewelsAndStones.numJewelsInStones("abc", "aabbcc")); // 6
        System.out.println(jewelsAndStones.numJewelsInStones("aA", "aAaZz")); // 3
        System.out.println(jewelsAndStones.numJewelsInStones("zZ", "zZzZzZ")); // 6
    }

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        Set<Character> mySet = new HashSet<>();

        for (char c : jewels.toCharArray()) {
            mySet.add(c);
        }

        for (char c : stones.toCharArray()) {
            if (mySet.contains(c)) {
                count++;
            }
        }

        return count;
    }
}

// Time Complexity: O(n + m), where n is the length of jewels and m is the
// length of stones. We iterate through both strings once.
// Space Complexity: O(n), where n is the length of jewels. We store the jewels
// in a HashSet, which takes O(n) space.
