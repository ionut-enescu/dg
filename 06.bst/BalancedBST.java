/**
 * Determine if a binary tree is height-balanced.

    A binary tree is considered height-balanced if, for each node, the difference in height between its left and right subtrees is no more than one.

    Examples:

    Input:
      3
     / \
    9  20
       / \
      15  7

    Expected Output: true
    Justification: Every node in the tree has a left and right subtree depth difference of either 0 or 1.
    Input:
           1
         /   \
        2     2
       / \   / \
      3   3 3   3
     / \       / \
    4   4     4   4
    Expected Output: true
    Justification: Each node in the tree has a left and right subtree depth difference of either 0 or 1.
    Input:
          1
         / \
        2   5
       /
      3 
     /
    4 
    Expected Output: false
    Justification: The root node has a left subtree depth of 3 and right subtree depth of 1. The difference (3 - 1 = 2) exceeds 1, hence the tree is not balanced.
    Constraints:

    The number of nodes in the tree is in the range [0, 5000].
    -10^4 <= Node.val <= 10^4    
 */



public class BalancedBST { 
    public boolean isBalanced(TreeNode root) {
        
        if (maxDepth(root) == -1) {
            return false;
        }

        return true;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);

        if (leftDepth == -1 || rightDepth == -1) {
            return -1;
        }

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }

        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        // Example usage
        BalancedBST tree = new BalancedBST();
        TreeNode root = tree.new TreeNode(3);
        root.left = tree.new TreeNode(9);
        root.right = tree.new TreeNode(20);
        root.right.left = tree.new TreeNode(15);
        root.right.right = tree.new TreeNode(7);

        System.out.println(tree.isBalanced(root)); // Output: true
    }
}

// Time Complexity: O(n), where n is the number of nodes in the tree. Each node is visited once.
// Space Complexity: O(h), where h is the height of the tree. This is due to the recursion stack space used during the depth-first traversal.
