/**
 * Given the head of a singly linked list, return the head of the reversed list.

    Examples
    Example 1:
    Input: [3, 5, 2]
    Expected Output: [2, 5, 3]
    Justification: Reversing the list [3, 5, 2] gives us [2, 5, 3].
    Example 2:
    Input: [7]
    Expected Output: [7]
    Justification: Since there is only one element in the list, the reversed list remains the same.
    Example 3:
    Input: [-1, 0, 1]
    Expected Output: [1, 0, -1]
    Justification: The list is reversed, so the elements are in the order [1, 0, -1].
 */

 import java.util.Queue;

public class ReverseQueue {
    
    public Queue<Integer> reverseQueue(Queue<Integer> q) {
   
        int arr[] = new int[q.size()];
        int count = 0;
        while(q.peek() != null) {
            arr[count++] = q.remove();
        }

        for (int i = count - 1; i >= 0; i--) {
            q.add(arr[i]);
        }
        return q;
    }
}
