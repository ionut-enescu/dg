/**
 * Given a binary matrix that has dimensions , consisting of ones and zeros,
 * determine the row that contains the highest number of ones and return two
 * values: the zero-based index of this row and the actual count of ones it
 * possesses.
 * 
 * If there is a tie, i.e., multiple rows contain the same maximum number of
 * ones, we must select the row with the lowest index.
 * 
 * Examples
 * Example 1:
 * 
 * Input: [[1, 0], [1, 1], [0, 1]]
 * Expected Output: [1, 2]
 * Justification: The second row [1, 1] contains the most ones, so the output is
 * [1, 2].
 * Example 2:
 * 
 * Input: [[0, 1, 1], [0, 1, 1], [1, 1, 1]]
 * Expected Output: [2, 3]
 * Justification: The third row [1, 1, 1] has the most ones, leading to the
 * output [2, 3].
 * Example 3:
 * 
 * Input: [[1, 0, 1], [0, 0, 1], [1, 1, 0]]
 * Expected Output: [0, 2]
 * Justification: Both the first and third rows contain two ones, but we choose
 * the first due to its lower index, resulting in [0, 2].
 * Constraints:
 * 
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * mat[i][j] is either 0 or 1.
 */
public class MaximumOnes {
    public int[] findMaxOnesRow(int[][] mat) {
        int maxOnesIdx = 0;
        int maxOnesCount = 0;

        for (int i = 0; i < mat.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                rowSum += mat[i][j];
            }
            if (rowSum > maxOnesCount) {
                maxOnesCount = rowSum;
                maxOnesIdx = i;
            }
        }

        return new int[] { maxOnesIdx, maxOnesCount };
    }
}

// Time Complexity: O(m * n), where m is the number of rows and n is the number
// of columns in the matrix. This is because we need to iterate through each
// element of the matrix to calculate the sum of ones in each row.
// Space Complexity: O(1), as we are using a constant amount of space for
// variables to store the maximum count and index, regardless of the input size.
