/**
     * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

    Examples
    Example 1:

    Input: nums= [1, 2, 3, 4]
    Output: false  
    Explanation: There are no duplicates in the given array.
    Example 2:

    Input: nums= [1, 2, 3, 1]
    Output: true  
    Explanation: '1' is repeating.
    Example 3:

    Input: nums= [3, 2, 6, -1, 2, 1]
    Output: true  
    Explanation: '2' is repeating.
    Constraints:

    1 <= nums.length <= 10^5 
    -10^9 <= nums[i] <= 10^9
 */


public class Duplicates {

  public static void main(String args[]) {
    int[] arr = {1,5,2,5};
    System.out.println(containsDuplicate(arr));
  }
  
  public static boolean containsDuplicate(int[] nums) {
    return runOnce(nums, 1, nums[0]);
  }

  public static boolean runOnce(int[] nums, int pos, int val) {
    for (int i = pos; i < nums.length; i++) {
      if (nums[i] == val) {
        return true;
      }
    }
    pos++;
    if (pos == nums.length + 1) { 
        return false;
    }
  
    return runOnce(nums, pos, nums[pos-1]);    
  }
}

// Time Complexity: O(n^2) - because of the nested loop
// Space Complexity: O(1) - no extra space is used, only the input array is used
