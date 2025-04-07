/**
 * Given a root node of the binary tree, return the depth (or height) of a binary tree.

    The Depth of the binary tree refers to the number of nodes along the longest path from the root node to the farthest leaf node. If the tree is empty, the depth is 0.

    Examples
    Example 1
    Input: root = [1, 2, 3, 4, 5]
    Expected Output: 3
    Explanation: The longest path is 1->2->4 or 1->2->5 with 3 nodes.
    Example 2
    Input: root = [1, null, 2, null, 3]
    Expected Output: 3
    Justification: There's only one path 1->2->3 with 3 nodes.
    Example 3
    Input: root = [1, 2, 3, 4, 7, null, null, null, null, null, 9]
    Expected Output: 4
    Justification: The longest path is 1->2->7->9 with 4 nodes.
    Constraints:

    The number of nodes in the tree is in the range [0, 104].
    -100 <= Node.val <= 100
 */

public class MaxDepth {
    private int height = 0;

    // Method to compute the maximum depth of a binary tree
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left != null || root.right != null) {
            height++;
        }        

        if (root.left != null) {
            maxDepth(root.left);
        } 
        
        if (root.right != null) {
            maxDepth(root.right);
        }
        
        return height;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        TreeNode root = maxDepth.new TreeNode(1);
        root.left = maxDepth.new TreeNode(2);
        root.right = maxDepth.new TreeNode(3);
        root.left.left = maxDepth.new TreeNode(4);
        root.left.right = maxDepth.new TreeNode(5);

        System.out.println("Maximum Depth of the Binary Tree: " + maxDepth.maxDepth(root)); // Output: 3
    }

}

// Time Complexity: O(n), where n is the number of nodes in the binary tree. We visit each node once.
// Space Complexity: O(h), where h is the height of the binary tree. This is due to the recursion stack space used during the traversal.
