
/**
 * Design a class to calculate the median of a number stream. The class should have the following two methods:

    insertNum(int num): stores the number in the class
    findMedian(): returns the median of all numbers inserted in the class
    If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.

    Example 1:

    1. insertNum(3)
    2. insertNum(1)
    3. findMedian() -> output: 2
    4. insertNum(5)
    5. findMedian() -> output: 3
    6. insertNum(4)
    7. findMedian() -> output: 3.5
    Constraints:

    -10^5 <= num <= 10^5
    There will be at least one element in the data structure before calling findMedian.
    At most 5 * 10^4 calls will be made to insertNum and findMedian.
 */

import java.util.*;

public class MedianOfNumberStream {
    Queue<Integer> myMinHeap = new PriorityQueue<>();
    Queue<Integer> myMaxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

    public void insertNum(int num) {
        if (myMaxHeap.isEmpty() || num <= myMaxHeap.peek()) {
            myMaxHeap.add(num);
        } else {
            myMinHeap.add(num);
        }

        if (myMaxHeap.size() > myMinHeap.size() + 1) {
            myMinHeap.offer(myMaxHeap.poll());
        } else if (myMinHeap.size() > myMaxHeap.size()) {
            myMaxHeap.offer(myMinHeap.poll());
        }
    }

    public double findMedian() {
        if (myMaxHeap.size() == myMinHeap.size()) {
            return (double) (myMaxHeap.peek() + myMinHeap.peek()) / 2;
        } else {
            return myMaxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianOfNumberStream medianFinder = new MedianOfNumberStream();
        medianFinder.insertNum(1);
        System.out.println(medianFinder.findMedian()); // 1.0
        medianFinder.insertNum(2);
        System.out.println(medianFinder.findMedian()); // 1.5
        medianFinder.insertNum(3);
        System.out.println(medianFinder.findMedian()); // 2.0
    }
}

// Time Complexity: O(log n) for insertNum and O(1) for findMedian
// Space Complexity: O(n) for storing the numbers in heaps
