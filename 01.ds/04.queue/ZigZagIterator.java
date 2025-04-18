
/**
 * Given two 1d vectors, implement an iterator to return their elements alternately.

    Implement the Solution class:

    Solution(List<int> v1, List<int> v2) is a constructor.
    int next() returns the current element of the iterator and moves the iterator to the next element.
    boolean hasNext() returns true if the iterator still has elements, and false otherwise.
    Examples
    Example 1
    Input: V1 = [1,2], v2 = [3,4,5,6]
    Expected Output: [1,3,2,4,5,6]
    Explanation: The elements will be returned in [1,3,2,4,5,6] order when we make v1.size() + v2.size() number of calls to the next() method.
    Example 2
    Input: V1 = [1, 2, 3, 4], v2 = [5,6]
    Expected Output: [1,5,2,6,3,4]
    Explanation: The elements will be returned in [1,5,2,6,3,4] order when we make v1.size() + v2.size() number of calls to the next() method.
    Example 3
    Input: V1 = [1, 2], v2 = []
    Expected Output: [1,2]
    Explanation: The elements will be returned in [1, 2] order when we make v1.size() + v2.size() number of calls to the next() method.
    Constraints:

    0 <= v1.length, v2.length <= 1000
    1 <= v1.length + v2.length <= 2000
    -2^31 <= v1[i], v2[i] <= 2^31 - 1
 */

import java.util.*;

class ZigZagIterator {
    Queue<Integer> myQueue;
    int pos;
    int size;

    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        myQueue = new LinkedList<>();

        pos = 0;
        int v1Size = v1.size();
        int v2Size = v2.size();
        int maxRuns = v1Size > v2Size ? v1Size : v2Size;

        for (int i = 0; i < maxRuns; i++) {
            if (i < v1Size) {
                myQueue.add(v1.get(i));
            }

            if (i < v2Size) {
                myQueue.add(v2.get(i));
            }
        }
    }

    public int next() {

        int returnVal = -1;
        if (pos == myQueue.size() - 1) {
            return returnVal;
        }

        Queue<Integer> tmpQueue = new LinkedList<>();
        int curPos = 0;
        pos++;

        while (myQueue.peek() != null) {
            if (curPos++ == pos) {
                returnVal = myQueue.peek();
            }
            tmpQueue.add(myQueue.remove());
        }

        myQueue = tmpQueue;

        return returnVal;
    }

    public boolean hasNext() {

        return myQueue.size() > 1;
    }

    public static void main(String[] args) {
        List<Integer> v1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> v2 = Arrays.asList(5, 6);
        ZigZagIterator zigZagIterator = new ZigZagIterator(v1, v2);

        while (zigZagIterator.hasNext()) {
            System.out.print(zigZagIterator.next() + " ");
        }
    }
}

// Time Complexity: O(n), where n is the total number of elements in both lists.
// Space Complexity: O(n), where n is the total number of elements in both
// lists.
