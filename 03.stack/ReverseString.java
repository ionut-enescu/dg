/**
 * Given a string, write a function that uses a stack to reverse the string. The function should return the reversed string.

    Examples
    Example 1:

    Input: "Hello, World!"
    Output: "!dlroW ,olleH"
    Example 2:

    Input: "OpenAI"
    Output: "IAnepO"
    Example 3:

    Input: "Stacks are fun!"
    Output: "!nuf era skcatS"
    Constraints:

    1 <= s.length <= 105
    s[i] is a printable ascii character.
 */

 import java.util.Stack;

public class ReverseString {
    public String reverseString(String s) {
        // ToDo: Write Your Code Here.
        Stack<Character> myStack = new Stack<>();
        if (s == null) {
            return s;
        }

        for (char c : s.toCharArray()) {
            System.out.println(c);
            myStack.push(c);
        }
        s = "";
        int strSize = myStack.size();
        for (int i = 0; i < strSize; i++) {
            s += myStack.pop();
        }
        return s;
    }
}
