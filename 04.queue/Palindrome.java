/**
 * Given a string s, determine if that string is a palindrome using a queue data structure. Return true if the string is a palindrome. Otherwise, return false.

    A palindrome is a word, number, phrase, or other sequence of characters that reads the same forward and backward, ignoring spaces, punctuation, and capitalization.

    Examples
    Example 1
    Input: s = "madam"
    Output: true
    Explanation: The word "madam" reads the same forwards and backwards.
    Example 2
    Input: s = "openai"
    Output: false
    Explanation: The word "openai" does not read the same forwards and backwards.
    Example 3
    Input: s = "A man a plan a canal Panama"
    Output: true
    Explanation: The phrase "A man a plan a canal Panama" reads the same forwards and backwards when we ignore spaces and capitalization.
 */

 import java.util.*;

 public class Palindrome {
 
     public static boolean checkPalindrome(String s) {
         Queue<Character> myQueue = new LinkedList<>();
         Stack<Character> myStack = new Stack<>();
         
         for (char c: s.toCharArray()) {
             if (Character.isLetterOrDigit(c)) {
                 myQueue.add(c);
                 myStack.push(c);
             }
         }
 
         for (int i = 0; i < myQueue.size(); i++) {
             if (myStack.pop() !=  myQueue.remove()) {
                 return false;
             }
         }
 
         return true;
    }
}

// time complexity: O(n), where n is the length of the string s. This is because we are iterating through the string once to populate the queue and stack, and then iterating through the queue once to check for palindrome.
// space complexity: O(n), where n is the length of the string s. This is because we are using a queue and stack to store the characters of the string.
 