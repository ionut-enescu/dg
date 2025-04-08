/**
 * Given an input array of integers nums, find an integer array, let's call it
 * differenceArray, of the same length as an input integer array.
 * 
 * Each element of differenceArray, i.e., differenceArray[i], should be
 * calculated as follows: take the sum of all elements to the left of index i in
 * array nums (let's call it leftSumi), and subtract it from the sum of all
 * elements to the right of index i in array nums (let's call it rightSumi),
 * taking the absolute value of the result:
 * 
 * differenceArray[i] = | leftSumi - rightSumi |
 * 
 * If there are no elements to the left or right of i, the corresponding sum
 * should be taken as 0.
 * 
 * Examples
 * Example 1:
 * 
 * Input: nums = [2, 5, 1, 6, 1]
 * Expected Output: [13, 6, 0, 7, 14]
 * Explanation:
 * For i=0: |(0) - (5+1+6+1)| = |0 - 13| = 13
 * For i=1: |(2) - (1+6+1)| = |2 - 8| = 6
 * For i=2: |(2+5) - (6+1)| = |7 - 7| = 0
 * For i=3: |(2+5+1) - (1)| = |8 - 1| = 7
 * For i=4: |(2+5+1+6) - (0)| = |14 - 0| = 14
 * Example 2:
 * 
 * Input: nums = [3, 3, 3]
 * Expected Output: [6, 0, 6]
 * Explanation:
 * For i=0: |(0) - (3+3)| = 6
 * For i=1: |(3) - (3)| = 0
 * For i=2: |(3+3) - (0)| = 6
 * Example 3:
 * 
 * Input: nums = [1, 2, 3, 4, 5]
 * Expected Output: [14, 11, 6, 1, 10]
 * Explanation:
 * Calculations for each index i will follow the above-mentioned logic.
 * Constraints:
 * 
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 10^5
 */

public class LeftAndRightSumDiffs {
    public int[] findDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] differenceArray = new int[n];
        // TODO: Write your code here
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int elem = sum - nums[0];
        differenceArray[0] = elem > 0 ? elem : -elem;
        elem = sum - nums[nums.length - 1];
        differenceArray[nums.length - 1] = elem > 0 ? elem : -elem;

        int leftSum = nums[0];
        // int rightSum = nums[i - 1];

        for (int i = 1; i < nums.length - 1; i++) {
            int rightSum = sum - leftSum - nums[i];
            elem = leftSum - rightSum;
            leftSum += nums[i];

            differenceArray[i] = elem > 0 ? elem : -elem;
        }
        return differenceArray;
    }

    public static void main(String[] args) {
        LeftAndRightSumDiffs obj = new LeftAndRightSumDiffs();
        int[] nums = { 2, 5, 1, 6, 1 };
        int[] result = obj.findDifferenceArray(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

// Time Complexity: O(n), where n is the length of the input array nums. This is
// because we are iterating through the array a constant number of times (once
// to calculate the total sum and once to calculate the difference array).
// Space Complexity: O(n), where n is the length of the input array nums. This
// is because we are creating a new array of the same length to store the
// difference values.