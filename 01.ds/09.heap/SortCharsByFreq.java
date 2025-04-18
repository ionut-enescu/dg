
/**
 *  Given a string, arrange its characters in descending order based on the frequency of each character. If two characters have the same frequency, their relative order in the output string can be arbitrary.

    Example
    Input: s = "trersesess"
    Expected Output: "sssseeerrt"
    Justification: The character s appears four times, e three times, r two times and t only once. All characters are sorted based on their frequnecy.
    Input: s = "banana"
    Expected Output: "aaannb".
    Justification: The character 'a' appears three times, 'n' twice and 'b' once.
    Input: s = "abb"
    Expected Output: "bba"
    Justification: The character b appears twice and a` only once.
    Constraints:

    1 <= s.length <= 5 * 10^5
    s consists of uppercase and lowercase English letters and digits.
 */

import java.util.*;

public class SortCharsByFreq {
    public String frequencySort(String str) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> myMap = new HashMap<>();
        Queue<Map.Entry<Character, Integer>> myHeap = new PriorityQueue<>(
                ((x, y) -> Integer.compare(y.getValue(), x.getValue())));

        for (char c : str.toCharArray()) {
            myMap.put(c, myMap.getOrDefault(c, 0) + 1);
        }

        myHeap.addAll(myMap.entrySet());

        while (!myHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = myHeap.remove();
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        SortCharsByFreq sortCharsByFreq = new SortCharsByFreq();
        String str = "tree";
        System.out.println(sortCharsByFreq.frequencySort(str)); // Output: "eetr" or "eert"
    }
}

// Time Complexity: O(n log n), where n is the length of the string
// Space Complexity: O(n), where n is the length of the string