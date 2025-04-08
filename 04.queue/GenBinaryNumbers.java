
/**
 * Given an integer N, generate all binary numbers from 1 to N and return them as a list of strings.

    Examples
    Example 1
    Input: N = 2
    Output: ["1", "10"]
    Explanation: The binary representation of 1 is "1", and the binary representation of 2 is "10".
    Example 2
    Input: N = 3
    Output: ["1", "10", "11"]
    Explanation: The binary representation of 1 is "1", the binary representation of 2 is "10", and the binary representation of 3 is "11".
    Example 3
    Input: N = 5
    Output: ["1", "10", "11", "100", "101"]
    Explanation: These are the binary representations of the numbers from 1 to 5.
 */

import java.util.LinkedList;
import java.util.Queue;

public class GenBinaryNumbers {
    public static String[] generateBinaryNumbers(int n) {
        String res[] = new String[n];
        Queue<String> myQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            myQueue.add(generateBinary(i + 1));
        }

        for (int i = 0; i < n; i++) {
            res[i] = myQueue.remove();
        }

        return res;
    }

    private static String generateBinary(int num) {
        StringBuilder sb = new StringBuilder();

        while (num > 1) {
            sb.append(Integer.toString(num % 2));
            num /= 2;
        }

        sb.append(Integer.toString(num));

        return sb.reverse().toString();
    }
}

// time complexity: O(n * log n) where n is the number of elements in the queue
// and log n is the number of bits in the binary representation of the largest
// number.
// space complexity: O(n) for the queue and the result array.
