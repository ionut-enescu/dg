/**
 * Given a one-dimensional array of integers, create a new array that represents
 * the running sum of the original array.
 * 
 * The running sum at position i in the new array is calculated as the sum of
 * all the numbers in the original array from the 0th index up to the i-th index
 * (inclusive). Formally, the resulting array should be computed as follows:
 * result[i] = sum(nums[0] + nums[1] + ... + nums[i]) for each i from 0 to the
 * length of the array minus one.
 * 
 * Examples
 * Example 1
 * 
 * Input: [2, 3, 5, 1, 6]
 * Expected Output: [2, 5, 10, 11, 17]
 * Justification:
 * For i=0: 2
 * For i=1: 2 + 3 = 5
 * For i=2: 2 + 3 + 5 = 10
 * For i=3: 2 + 3 + 5 + 1 = 11
 * For i=4: 2 + 3 + 5 + 1 + 6 = 17
 * Example 2
 * 
 * Input: [1, 1, 1, 1, 1]
 * Expected Output: [1, 2, 3, 4, 5]
 * Justification: Each element is simply the sum of all preceding elements plus
 * the current element.
 * Example 3
 * 
 * Input: [-1, 2, -3, 4, -5]
 * Expected Output: [-1, 1, -2, 2, -3]
 * Justification: Negative numbers are also summed up in the same manner as
 * positive ones.
 * Constraints:
 * 
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 */
class RunningSum1DArray {
    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        // TODO: Write your code here
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        arr = runningSum(arr);
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }
}

// Time Complexity: O(n) where n is the length of the input array nums. This is
// because we are iterating through the array once to calculate the running sum.
// Space Complexity: O(n) where n is the length of the input array nums. This is
// because we are creating a new array of the same length to store the running
// sum.
