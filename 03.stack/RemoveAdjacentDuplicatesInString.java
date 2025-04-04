/**
 * Give a string s, convert it into a valid string. A string is considered valid if it does not have any two adjacent duplicate characters.

    To make a string valid, we will perform a duplicate removal process. A duplicate removal consists of choosing two adjacent and equal letters and removing them. We repeatedly make duplicate removals on s until we no longer can.

    Return the final string after all such duplicate removals have been made.

    Examples
    Example 1

    Input: "abbaca"
    Expected Output: "ca"
    Description: We remove 'b' from "abbaca" to get "aaca", then remove 'a' from "aaca" to get "ca"
    Example 2

    Input: "azxxzy"
    Expected Output: "ay"
    Description: We remove 'x' from "azxxzy" to get "azzy", then remove 'z' from "azzy" to get "ay"
    Example 3

    Input: "abba"
    Expected Output: ""
    Description: We remove 'b' from "abba" to get "aa", then remove 'a' from "aa" to get an empty string
    Constraints:

    1 <= str.length <= 10^5
    str consists of lowercase English letters.
 */

 import java.util.Stack;

public class RemoveAdjacentDuplicatesInString {
    public String removeDuplicates(String str) {
        // ToDo: Write Your Code Here.
        Stack<Character> myStack = new Stack<>();


        for (char c : str.toCharArray()) {
            if (myStack.isEmpty() || c != myStack.peek()) {
                myStack.push(c);
            } else {
                myStack.pop();
            } 
        }

        StringBuilder sb = new StringBuilder();

        while (!myStack.isEmpty()) {
            sb.append(myStack.pop()) ;
        }
        return sb.reverse().toString();
    }
}
