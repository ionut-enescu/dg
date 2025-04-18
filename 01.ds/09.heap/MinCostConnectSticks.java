
/**
 * Given a collection of sticks with different lengths. To combine any two sticks, there's a cost involved, which is equal to the sum of their lengths.

    Connect all the sticks into a single one with the minimum possible cost. Remember, once two sticks are combined, they form a single stick whose length is the sum of the lengths of the two original sticks.

    Examples
    Input: [2, 4, 3]
    Expected Output: 14
    Justification: Combine sticks 2 and 3 for a cost of 5. Now, we have sticks [4,5]. Combine these at a cost of 9. Total cost = 5 + 9 = 14.
    Input: [1, 8, 2, 5]
    Expected Output: 27
    Justification: Combine sticks 1 and 2 for a cost of 3. Now, we have sticks [3, 8, 5]. Combine 3 and 5 for a cost of 8. Now, we have sticks [8,8]. Combine these for a cost of 16. Total cost = 3 + 8 + 16 = 27.
    Input: [5, 5, 5, 5]
    Expected Output: 40
    Justification: Combine two 5s for a cost of 10. Do this again for another cost of 10. Now, we have two sticks of 10 each. Combine these for a cost of 20. Total cost = 10 + 10 + 20 = 40.
    Constraints:

    1 <= sticks.length <= 10^4
    1 <= sticks[i] <= 10^4
 */

import java.util.*;

public class MinCostConnectSticks {
    public int connectSticks(int[] sticks) {
        int cost = 0;

        Queue<Integer> myHeap = new PriorityQueue<>();

        for (int stick : sticks) {
            myHeap.add(stick);
        }

        if (myHeap.size() <= 1) {
            return 0;
        }

        while (!myHeap.isEmpty()) {
            int first = myHeap.remove();
            int second = myHeap.remove();

            int curCost = first + second;

            if (!myHeap.isEmpty()) {
                myHeap.add(curCost);
            }

            cost += curCost;
        }

        return cost;
    }

    public static void main(String[] args) {
        MinCostConnectSticks obj = new MinCostConnectSticks();
        int[] sticks = { 2, 4, 3 };
        System.out.println(obj.connectSticks(sticks)); // Output: 14

        int[] sticks2 = { 1, 8, 2, 5 };
        System.out.println(obj.connectSticks(sticks2)); // Output: 27

        int[] sticks3 = { 5, 5, 5, 5 };
        System.out.println(obj.connectSticks(sticks3)); // Output: 40
    }
}

// Time Complexity: O(nlogn) where n is the number of sticks. This is because we
// are using a priority queue (min heap) to store the sticks, and each insertion
// and removal operation takes O(logn) time. Since we are doing this for all n
// sticks, the overall time complexity is O(nlogn).
// Space Complexity: O(n) where n is the number of sticks. This is because we
// are storing all the sticks in a priority queue, which takes O(n) space.
