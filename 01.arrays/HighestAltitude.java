/**
 * A bike rider is going on a ride. The road contains n + 1 points at different
 * altitudes. The rider starts from point 0 at an altitude of 0.
 * 
 * Given an array of integers gain of length n, where gain[i] represents the net
 * gain in altitude between points i and i + 1 for all (0 <= i < n), return the
 * highest altitude of a point.
 * 
 * Examples
 * Example 1
 * Input: gain = [-5, 1, 5, 0, -7]
 * Expected Output: 1
 * Justification: The altitude changes are [-5, -4, 1, 1, -6], where 1 is the
 * highest altitude reached.
 * Example 2
 * Input: gain = [4, -3, 2, -1, -2]
 * Expected Output: 4
 * Justification: The altitude changes are [4, 1, 3, 2, 0], where 4 is the
 * highest altitude reached.
 * Example 3
 * Input: gain = [2, 2, -3, -1, 2, 1, -5]
 * Expected Output: 4
 * Justification: The altitude changes are [2, 4, 1, 0, 2, 3, -2], where 4 is
 * the highest altitude reached.
 * Constraints:
 * 
 * n == gain.length
 * 1 <= n <= 100
 * -100 <= gain[i] <= 100
 */

public class HighestAltitude {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0; // To store the maximum altitude encountered
        // TODO: Write your code here
        int curAltitude = 0;
        for (int i = 0; i < gain.length; i++) {
            curAltitude += gain[i];
            if (curAltitude > maxAltitude) {
                maxAltitude = curAltitude;
            }
        }

        return maxAltitude;
    }

    public static void main(String[] args) {
        HighestAltitude ha = new HighestAltitude();
        int[] gain1 = { -5, 1, 5, 0, -7 };
        int[] gain2 = { 4, -3, 2, -1, -2 };
        int[] gain3 = { 2, 2, -3, -1, 2, 1, -5 };

        System.out.println(ha.largestAltitude(gain1)); // Output: 1
        System.out.println(ha.largestAltitude(gain2)); // Output: 4
        System.out.println(ha.largestAltitude(gain3)); // Output: 4
    }
}

// Time Complexity: O(n), where n is the length of the gain array. We iterate
// through the array once.
// Space Complexity: O(1), as we are using a constant amount of space for
// variables.