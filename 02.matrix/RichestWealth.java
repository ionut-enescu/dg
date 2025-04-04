/**
    You are given an m x n matrix accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank.

    Return the wealth that the richest customer has.

    Imagine every customer has multiple bank accounts, with each account holding a certain amount of money. The total wealth of a customer is calculated by summing all the money across all their multiple.

    Examples
    Example 1:

    Input: accounts =
    [[5,2,3],
    [0,6,7]]
    Expected Output: 13
    Justification: The total wealth of the first customer is 10 and of the second customer is 13. So, the output is 13 as it's the maximum among all customers.
    Example 2:

    Input: accounts =
    [[1,2],
    [3,4],
    [5,6]]
    Expected Output: 11
    Justification: Total wealth for each customer is [3, 7, 11]. Maximum of these is 11.
    Example 3:

    Input: accounts =
    [[5,10,15],
    [10,20,30],
    [15,30,45]]
    Expected Output: 90
    Justification: Total wealth for each customer is [30, 60, 90]. The wealthiest customer has 90.
    Constraints:

    m == accounts.length
    n == accounts[i].length
    1 <= m, n <= 50
    1 <= accounts[i][j] <= 100
 */

 class RichestWealth {
    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;  // Initialize maxWealth to 0
        // ToDo: Write Your Code Here.

        for (int i = 0; i < accounts.length; i++) {
            int curWealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                curWealth += accounts[i][j];
            }
            if (curWealth > maxWealth) {
                maxWealth = curWealth;
            }
        }
        return maxWealth;
    }
}
   