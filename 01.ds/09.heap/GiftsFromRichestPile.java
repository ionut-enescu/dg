
/**
 * You're presented with several piles of gifts, with each pile containing a certain number of gifts. Every second, you'll engage in the following activity:

    Pick the pile that contains the highest number of gifts. If multiple piles share this distinction, you can select any of them.
    Compute the square root of the number of gifts in the selected pile, and then leave behind that many gifts (rounded down). Take all the other gifts from this pile.
    You'll do this for "k" seconds. The objective is to find out how many gifts would still remain after these "k" seconds.
    Examples
    Input: gifts = [4, 9, 16], k = 2
    Expected Output: 11
    Justification:
    Take from third pile (16 gifts): leave (  ) = 4 gifts, take 12. Remaining gifts = [4, 9, 4]
    Take from second pile (9 gifts): leave (  ) = 3 gifts, take 6. Remaining gifts = [4, 3, 4]
    Input: gifts = [1, 2, 3], k = 1
    Expected Output: 4
    Justification:
    Take from third pile (3 gifts): leave (  ) = 1 gift (rounded down), take 2. Remaining gifts = [1, 2, 1]
    Input: gifts = [25, 36, 49], k = 3
    Expected Output: 18
    Justification:
    Take from third pile (49 gifts): leave (  ) = 7 gifts, take 42. Remaining gifts = [25, 36, 7]
    Take from second pile (36 gifts): leave (  ) = 6 gifts, take 30. Remaining gifts = [25, 6, 7]
    Take from first pile (25 gifts): leave (  ) = 5 gifts, take 20. Remaining gifts = [5, 6, 7]
    Constraints:

    1 <= gifts.length <= 10^3
    1 <= gifts[i] <= 10^9
    1 <= k <= 10^3
 */

import java.util.PriorityQueue;

public class GiftsFromRichestPile {
    Queue<Integer> heap = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

    public int remainingGifts(int[] gifts, int k) {
        int result = 0;

        for (int gift : gifts) {
            heap.add(gift);
        }

        while (heap.size() > 0) {
            int cur = heap.remove();
            if (k-- > 0) {
                result += (int) Math.sqrt(cur);
            } else {
                result += cur;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        GiftsFromRichestPile giftsFromRichestPile = new GiftsFromRichestPile();
        int[] gifts = { 4, 9, 16 };
        int k = 2;
        System.out.println(giftsFromRichestPile.remainingGifts(gifts, k)); // Output: 11
    }
}

// Time Complexity: O(n + k log n), where n is the number of gifts and k is the
// number of seconds
// Space Complexity: O(n), where n is the number of gifts