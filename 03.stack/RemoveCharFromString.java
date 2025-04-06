/**
 * Given a string s, where * represents a star. We can remove a star along with its closest non-star character to its left in a single operation.

    The task is to perform as many such operations as possible until all stars have been removed and return the resultant string.

    Examples
    Example 1

    Input: "abc*de*f"
    Expected Output: "abdf"
    Description: We remove c along with * to get "abde*f", then remove e along with * to get "abdf"
    Example 2

    Input: "a*b*c*d"
    Expected Output: "d"
    Description: We remove a along with * to get "b*c*d", then remove b with * to get "c*d", then remove c with * to get "d".
    Example 3

    Input: "abcd"
    Expected Output: "abcd"
    Description: As there is no *, the string remains the same.
    Constraints:

    1 <= s.length <= 10^5
    s consists of lowercase English letters and stars *.
    The operation above can be performed on s.
 */

 import java.util.Stack;

public class RemoveCharFromString {
    public String removeStars(String str) {
        // ToDo: Write Your Code Here.

        Stack<Character> myStack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '*' && !myStack.isEmpty()) {
                myStack.pop();
            } else if (c != '*') {
                myStack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!myStack.isEmpty()) {
            sb.append(myStack.pop());
        }

        return sb.reverse().toString();
    }
}

// Time Complexity: O(n), where n is the length of the string. We are iterating through the string once and then popping elements from the stack.
// Space Complexity: O(n), in the worst case, we might have to store all characters in the stack if there are no stars in the string.
