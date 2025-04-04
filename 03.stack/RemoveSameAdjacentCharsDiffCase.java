/**
 * Given a string of English lowercase and uppercase letters, make the string "good" by removing two adjacent characters that are the same but in different cases.

    Continue to do this until there are no more adjacent characters of the same letter but in different cases. An empty string is also considered "good".

    Examples
    Example 1
    Input: "AaBCcdEeff"
    Output: "Bdff"
    Explanation: In the first step, "AaBCcDEeff" becomes "BcCDdEeff" because 'A' and 'a' are the same letter, but one is uppercase and the other is lowercase. Then we remove "cC", and "Ee". In the end we are left with "Bdff" which we can't remove - although both characters are the same but with the same case.
    Example 2
    Input: "abBA"
    Output: ""
    Explanation: In the first step, "abBA" becomes "aA" because 'b' and 'B' are the same letter, but one is uppercase and the other is lowercase. Then "aA" becomes "" for the same reason. The final string is empty, which is good.
    Example 3
    Input: "s"
    Output: "s"
    Explanation: The string "s" is already good because it only contains one character.
    Constraints:

    1 <= s.length <= 100
    s contains only lower and upper case English letters.
 */

 import java.util.Stack;

public class RemoveSameAdjacentCharsDiffCase {
    public String makeGood(String str) {
        // ToDo: Write Your Code Here.
        Stack<Character> myStack = new Stack<>();

        for (char c : str.toCharArray()) {
            System.out.println(Character.getNumericValue(c));
            if (!myStack.isEmpty() && 
                Character.toLowerCase(c) == Character.toLowerCase(myStack.peek()) && 
                Character.compare(c, myStack.peek()) != 0) {
                myStack.pop();
            } else {
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
