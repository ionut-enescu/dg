/**
 *  Given a string s containing (, ), [, ], {, and } characters. Determine if a given string of parentheses is balanced.

    A string of parentheses is considered balanced if every opening parenthesis has a corresponding closing parenthesis in the correct order.

    Example 1:

    Input: String s = "{[()]}";
    Expected Output: true
    Explanation: The parentheses in this string are perfectly balanced. Every opening parenthesis '{', '[', '(' has a corresponding closing parenthesis '}', ']', ')' in the correct order.

    Example 2:

    Input: string s = "{[}]";
    Expected Output: false
    Explanation: The brackets are not balanced in this string. Although it contains the same number of opening and closing brackets for each type, they are not correctly ordered. The ']' closes '[' before '{' can be closed by '}', and similarly, '}' closes '{' before '[' can be closed by ']'.

    Example 3:

    Input: String s = "(]";
    Expected Output: false
    Explanation: The parentheses in this string are not balanced. Here, ')' does not have a matching opening parenthesis '(', and similarly, ']' does not have a matching opening bracket '['.

    Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.
 */

 import java.util.Stack;

public class BalancedParantheses {
    Stack<Character> myStack = new Stack<>();
    
    public boolean isValid(String s) {

        // ToDo: Write Your Code Here.        
        int sumAccOpen = 0;
        int sumAccClose = 0;
        int sumParOpen = 0;
        int sumParClose = 0;
        int sumBraOpen = 0;
        int sumBraClose = 0;
        char lastChar = 0;
        for (char c : s.toCharArray()) {
            if (!myStack.isEmpty()) {
                lastChar = myStack.peek();
            }
            switch (c) {
                case '{': sumAccOpen++; break;
                case '[': sumBraOpen++; break;
                case '(': sumParOpen++; break;
                case '}': 
                    if (lastChar != 0 && (lastChar == '[' || lastChar == '(')) {
                        return false;
                    }
                    sumAccClose++;
                    break;
                case ']':
                    if (lastChar != 0 && (lastChar == '{' || lastChar == '(')) {
                        return false;
                    }
                    sumBraClose++;
                    break;   
                case ')':
                    if (lastChar != 0 && (lastChar == '[' || lastChar == '{')) {
                        return false;
                    }
                    sumParClose++;
                    break; 
                default: return false;       
            }
            myStack.push(c);
        }

        if (sumAccOpen == sumAccClose && sumBraOpen == sumBraClose && sumParOpen == sumParClose) {
            return true;
        }

        return false;
    }
}

// Time complexity: O(n), where n is the length of the string s. We traverse the string once, and each character is pushed and popped from the stack at most once.
// space complexity: O(n) in the worst case, when all characters are opening brackets and are stored in the stack.

