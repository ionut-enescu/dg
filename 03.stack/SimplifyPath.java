
/**
 * Given an absolute file path in a Unix-style file system, simplify it by converting ".." to the previous directory and removing any "." or multiple slashes. The resulting string should represent the shortest absolute path.

    Examples
    Example 1
    Input: path = "/a//b////c/d//././/.."
    Expected Output: "/a/b/c"
    Explanation:
    Convert multiple slashes (//) into single slashes (/).
    "." refers to the current directory and is ignored.
    ".." moves up one directory, so "d" is removed.
    The simplified path is "/a/b/c".
    Example 2
    Input: path = "/../"
    Expected Output: "/"
    Explanation:
    ".." moves up one directory, but we are already at the root ("/"), so nothing happens.
    The final simplified path remains "/".
    Example 3
    Input: path = "/home//foo/"
    Expected Output: "/home/foo"
    Explanation:
    Convert multiple slashes (//) into single slashes (/).
    The final simplified path is "/home/foo".
    Constraints:

    1 <= path.length <= 3000
    path consists of English letters, digits, period '.', slash '/' or '_'.
    path is a valid absolute Unix path.
 */

import java.util.*;

public class SimplifyPath {
    public String simplifyPath(String path) {
        // ToDo: Write Your Code Here.
        Stack<Character> myStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : path.toCharArray()) {
            if (myStack.isEmpty() && c == '/') {
                myStack.push(c);
            } else {
                char tmp = myStack.peek();
                if (c == '/') {
                    if (tmp == '.') {
                        myStack.pop();
                    } else if (tmp != '/') {
                        myStack.push(c);
                    }
                } else if (c == '.') {
                    if (tmp == '.') {
                        for (int i = 0; i < 4; i++) {
                            myStack.pop();
                            if (myStack.isEmpty()) {
                                myStack.push('/');
                                break;
                            }
                        }
                    } else if (tmp == '/') {
                        myStack.push(c);
                    }
                } else {
                    myStack.push(c);
                }
            }
        }

        while (myStack.peek() == '/' || myStack.peek() == '.') {
            myStack.pop();
            if (myStack.isEmpty()) {
                myStack.push('/');
                break;
            }
        }

        while (!myStack.isEmpty()) {
            sb.append(myStack.pop());
        }

        return sb.reverse().toString();
    }
}

// Time Complexity: O(n), where n is the length of the input string path. We
// iterate through the string once, and each character is pushed and popped from
// the stack at most once.
// Space Complexity: O(n), where n is the length of the input string path. In
// the worst case, all characters are stored in the stack if there are no
// slashes or dots to simplify the path.
