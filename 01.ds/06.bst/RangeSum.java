/**
 * Given a Binary Search Tree (BST) and a range defined by two integers, L and
 * R, calculate the sum of all the values of nodes that fall within this range.
 * The node's value is inclusive within the range if and only if L <= node's
 * value <= R.
 * 
 * Examples:
 * 
 * Example 1:
 * 
 * Input:
 * 
 * Tree:
 * 10
 * / \
 * 5 15
 * / \ \
 * 3 7 18
 * Range: [7, 15]
 * Expected Output: 32
 * 
 * Justification: The values that fall within the range [7, 15] are 7, 10, and
 * 15. Their sum is 7 + 10 + 15 = 32.
 * 
 * Example 2:
 * 
 * Input:
 * 
 * Tree:
 * 20
 * / \
 * 5 25
 * / \
 * 3 10
 * Range: [3, 10]
 * Expected Output: 18
 * 
 * Justification: The values within the range [3, 10] are 3, 5, and 10. Their
 * sum is 3 + 5 + 10 = 18.
 * 
 * Example 3:
 * 
 * Input:
 * 
 * Tree:
 * 30
 * \
 * 35
 * /
 * 32
 * Range: [30, 34]
 * Expected Output: 62
 * 
 * Justification: The values within the range [30, 34] are 30 and 32. Their sum
 * is 30 + 32 = 62.
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 2 * 10^4].
 * 1 <= Node.val <= 10^5
 * 1 <= low <= high <= 10^5
 * All Node.val are unique.
 * 
 */

public class RangeSum {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;

        if (root.left != null) {
            sum += rangeSumBST(root.left, L, R);
        }

        if (root.right != null) {
            sum += rangeSumBST(root.right, L, R);
        }

        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }

        return sum;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new RangeSum().new TreeNode(10);
        root.left = new RangeSum().new TreeNode(5);
        root.right = new RangeSum().new TreeNode(15);
        root.left.left = new RangeSum().new TreeNode(3);
        root.left.right = new RangeSum().new TreeNode(7);
        root.right.right = new RangeSum().new TreeNode(18);

        int L = 7, R = 15;
        int result = new RangeSum().rangeSumBST(root, L, R);
        System.out.println("Range Sum: " + result); // Output: 32
    }
}

// Time Complexity: O(n), where n is the number of nodes in the tree. In the
// worst case, we may have to visit all nodes.
// Space Complexity: O(h), where h is the height of the tree. This is due to the
// recursion stack. In the worst case, for a skewed tree, h can be equal to n.
