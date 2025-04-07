/**
 * Given a binary search tree (BST) and a target number, find a node value in the BST that is closest to the given target. If there are multiple answers, print the smallest.

    A BST is a tree where for every node, the values in the left subtree are smaller than the node, and the values in the right subtree are greater.

    Examples
    Example 1:
    Input: Target: 6.4, Tree:
         5
       /   \
      3     8
     / \   / \
    1   4 6   9
    Expected Output: 6
    Justification: The values 6 and 8 are the closest numbers to 6.4 in the tree. Among them, 6 is closer.
    Example 2:
    Input: Target: 25, Tree:
          20
        /    \
       10     30
    Expected Output: 20
    Justification: 20 and 30 are the closest numbers to 25. However, 20 is smaller than 30. So, 20 is selected as an output.
    Example 3:
    Input: Target: 2.9, Tree:
          2
        /   \
       1     3
    Expected Output: 3
    Justification: 3 is the closest value to 2.9 in the tree.
    Constraints:

    The number of nodes in the tree is in the range [1, 10^4].
    0 <= Node.val <= 10^9
    -10^9 <= target <= 10^9
 */

public class ClosestValue {
    double minDiff = Double.MAX_VALUE;
    int closestVal = Integer.MAX_VALUE;

    // This function finds the value in the BST closest to the target.
    public int closestValue(TreeNode root, double target) {
        System.out.println("****************");
        findClosestValue(root, target);
        return closestVal;
    }

    private void findClosestValue(TreeNode node, double target) {
        if (node.left != null) { // && Math.abs(node.left.val - target) <= minDiff) {
            findClosestValue(node.left, target);
        }

        double curDiff = Math.abs(node.val - target);
        if (curDiff < minDiff) {
            minDiff = curDiff;
            closestVal = node.val;
            System.out.println("curDiff: " + curDiff + "; closestVal: " + closestVal);
        }

        if (node.right != null) { // && Math.abs(node.right.val - target) <= minDiff) {
            findClosestValue(node.right, target);
        }
    }

    // Define a TreeNode structure with left and right children.
    class TreeNode {
        int val;                  // Value stored in the node.
        TreeNode left;            // Reference to the left child.
        TreeNode right;           // Reference to the right child.

        // Constructor to initialize a new node with a value.
        TreeNode(int x) { 
            val = x; 
        }
    }
}

// Time Complexity: O(h), where h is the height of the tree. In the worst case, this can be O(n) for a skewed tree. In a balanced tree, it would be O(log n).
// Space Complexity: O(h) for the recursion stack, where h is the height of the tree. In a balanced tree, this would be O(log n), and in a skewed tree, it would be O(n).

