/**
 * Implement a stack using only two queues. The stack should behave like a typical last-in-first-out (LIFO) stack, meaning that the last element added should be the first one to be removed.

    Implement a Solution class that supports the following operations:

    Solution(): A constructor to initialize the object.
    push(int x): Adds an element x to the top of the stack.
    pop(): Removes the element from the top of the stack and returns it.
    top(): Retrieves the element on the top of the stack without removing it.
    empty(): Checks whether the stack is empty or not and returns true or false accordingly.
    Note: You can only use the basic operations of a queue, such as adding an element to the back, removing an element from the front, checking the size, and verifying if the queue is empty.

    Input and Output Format
    The input and output for this problem are structured using two separate arrays:

    Input Arrays:

    Method Names Array: This is an array of strings where each string represents a method to be called on the Solution class. The first element is always "Solution", indicating the initialization of the stack.
    Arguments Array: This is a nested array where each sub-array contains the arguments for the corresponding method in the Method Names Array. For methods that do not require any arguments (like Solution, pop, top, and empty), the sub-array will be empty.
    Output Array:

    The output is a single array that captures the return value of each method call in the order they were invoked.
    For methods that do not return any value (Solution constructor and push operations), the corresponding output is null.
    For methods that return values (pop, top, and empty), the actual returned value is included in the output array.
    Examples
    Example 1

    Input:

    ["Solution", "push", "push", "top", "pop", "empty"]
    [[], [5], [10], [], [], []]
    Expected Output: [null, null, null, 10, 10, false]

    Explanation:

    push(5) adds 5 to the stack.
    push(10) adds 10 to the top of the stack.
    top() returns 10 since it's the top element.
    pop() removes 10 and returns it.
    empty() returns false because 5 is still in the stack.
    Example 2

    Input:
    ["Solution", "push", "push", "push", "pop", "top", "pop", "empty"]
    [[], [1], [2], [3], [], [], [], []]
    Expected Output: [null, null, null, null, 3, 2, 2, false]
    Explanation:
    push(1) adds 1 to the stack.
    push(2) adds 2 on top of 1.
    push(3) adds 3 on top of 2.
    pop() removes 3 and returns it.
    top() returns 2, the new top element.
    pop() removes 2 and returns it.
    empty() returns false since 1 is still in the stack.
    Example 3

    Input:
    ["Solution", "push", "top", "pop", "empty"]
    [[], [99], [], [], []]
    Expected Output: [null, null, 99, 99, true]
    Explanation:
    push(99) adds 99 to the stack.
    top() returns 99.
    pop() removes 99 and returns it.
    empty() returns true because the stack is now empty.
    Constraints:

    1 <= x <= 9
    At most 100 calls will be made to push, pop, top, and empty.
    All the calls to pop and top are valid.

 */

 import java.util.LinkedList;
import java.util.Queue;

class StackWithQueue {
    Queue<Integer> stackQueue;
    Queue<Integer> tmpQueue;

    public StackWithQueue() {
      stackQueue = new LinkedList<>();
      tmpQueue = new LinkedList<>();
    }

    // Push element x onto the stack
    public void push(int x) {
      tmpQueue.add(x);
      while (stackQueue.peek() != null) {
         tmpQueue.add(stackQueue.remove());
      }
      
      while (tmpQueue.peek() != null) {
         stackQueue.add(tmpQueue.remove());
      }
      System.out.println(stackQueue.toString());
    }

    public int pop() {       
      if (empty()) {
         return 0;
      }

      return stackQueue.remove();
    }

    public int top() {
      if (empty()) {
         return 0;
      }
      
      return stackQueue.peek();
    }

    public boolean empty() {
       if (stackQueue.size() > 0) {
         return false;
       }
       return true;
    }

   public static void main(String[] args) {
      StackWithQueue stack = new StackWithQueue();
      stack.push(5);
      stack.push(10);
      System.out.println(stack.top()); // 10
      System.out.println(stack.pop()); // 10
      System.out.println(stack.empty()); // false
   }
}

// Time Complexity: O(n) for push, O(1) for pop and top
// Space Complexity: O(n) for the queue used to implement the stack