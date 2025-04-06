/**
 * Given a stack, sort it using only stack operations (push and pop).

    You can use an additional temporary stack, but you may not copy the elements into any other data structure (such as an array). The values in the stack are to be sorted in descending order, with the largest elements on top.

    Examples
    1. Input: [34, 3, 31, 98, 92, 23]
    Output: [3, 23, 31, 34, 92, 98]

    2. Input: [4, 3, 2, 10, 12, 1, 5, 6]
    Output: [1, 2, 3, 4, 5, 6, 10, 12]

    3. Input: [20, 10, -5, -1]
    Output: [-5, -1, 10, 20]
 */

 import java.util.*;

class SortStack {
    public static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> tmpStack = new Stack<Integer>();
        // ToDo: Write Your Code Here.
        tmpStack.push(input.pop());

        while (!input.isEmpty()) {
            int inputPop = input.pop();
            
            if (inputPop >= tmpStack.peek()) {
                tmpStack.push(inputPop);
            } else {
                while (!tmpStack.isEmpty() && inputPop < tmpStack.peek()) {
                    input.push(tmpStack.pop());
                }
                tmpStack.push(inputPop);
            }
        }

        return tmpStack;
    }
}

// Time Complexity: O(n^2) in the worst case, where n is the number of elements in the stack. This occurs when the input stack is sorted in reverse order.
// Space Complexity: O(n) for the temporary stack used to store the sorted elements.