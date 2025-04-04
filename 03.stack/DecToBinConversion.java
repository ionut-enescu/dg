/**
 * Given a positive integer n, write a function that returns its binary equivalent as a string. The function should not use any in-built binary conversion function.

    Examples
    Example 1:

    Input: 2
    Output: "10"
    Explanation: The binary equivalent of 2 is 10.
    Example 2:

    Input: 7
    Output: "111"
    Explanation: The binary equivalent of 7 is 111.
    Example 3:

    Input: 18
    Output: "10010"
    Explanation: The binary equivalent of 18 is 10010.
    Constraints:

    1 <= n <= 10^9
 */

 import java.util.Stack;

public class DecToBinConversion {
    public static String decimalToBinary(int num) {
        StringBuilder sb = new StringBuilder();
        // ToDo: Write Your Code Here.

        if (num < 2) {
            return Integer.toString(num);
        }
        
        Stack<Character> myStack = new Stack<>();

        while (num != 1) {
            if (num % 2 == 0) {
                myStack.push('0');
            } else {
                myStack.push('1');
            }
            num /= 2;
        }

        myStack.push('1');

        while (!myStack.isEmpty()) {
            sb.append(myStack.pop());
        }

        return sb.toString();
    }
}
