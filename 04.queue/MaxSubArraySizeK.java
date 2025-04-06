/**
 * Given an integer array arr and an integer k, return the result list containing the maximum for each and every contiguous subarray of size k.

    In other words, result[i] = max(arr[0],..., arr[k]), result[1] = max(arr[1],...arr[k+1]), etc.

    Examples
    Example 1
    Input: arr = [1, 2, 3, 1, 4, 5, 2, 3, 6], k = 3
    Output: [3, 3, 4, 5, 5, 5, 6]
    Description: Here, subarray [1,2,3] has maximum 3, [2,3,1] has maximum 3, [3,1,4] has maximum 4, [1,4,5] has maximum 5, [4,5,2] has maximum 5, [5,2,3] has maximum 5, and [2,3,6] has maximum 6.
    Example 2
    Input: arr = [8, 5, 10, 7, 9, 4, 15, 12, 90, 13], k = 4
    Output: [10, 10, 10, 15, 15, 90, 90]
    Description: Here, the maximum of each subarray of size 4 are 10, 10, 10, 15, 15, 90, 90 respectively.
    Example 3
    Input: arr = [12, 1, 78, 90, 57], k = 3
    Output: [78, 90, 90]
    Description: Here, the maximum of each subarray of size 3 are 78, 90, and 90 respectively.
    Constraints:

    1 <= arr.length <= 10^5
    -10^4 <= arr[i] <= 10^4
    1 <= k <= arr.length
 */

 import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxSubArraySizeK {
    public List<Integer> printMax(int[] arr, int k) {
        List<Integer> result = new ArrayList<Integer>();
        Queue<Integer> myQueue = new LinkedList();

        for (int i = 0; i < arr.length; i++) {
            myQueue.add(arr[i]);
        }

        System.out.println(myQueue.toString());

        int cur = 1;
        int max = -10000;
        int prevMaxKMinus1 = -10000;
        while (myQueue.size() > 0) {
            int head = myQueue.peek();
            if (head > max) {
                max = head;                
            }
            if (cur > 1 && head > prevMaxKMinus1) {
                System.out.println("prevMaxKMinus1: " + prevMaxKMinus1 + "; head: " + head);
                prevMaxKMinus1 = head;
            }

            if (cur >= k) {                
                result.add(max);
                max = head > prevMaxKMinus1 ? head : prevMaxKMinus1;
            //    prevMaxKMinus1 = -10000;
            } 
            prevMaxKMinus1 = 
            cur++;
            myQueue.remove();
        }

        return result;
    }
}

// Time complexity: O(n) - we are iterating through the array once and using a queue to store the elements. The queue operations (add, remove, peek) are O(1) on average.
// Space complexity: O(k) - we are using a queue to store the elements of the current subarray of size k. In the worst case, the queue will store k elements.
