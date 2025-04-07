import java.util.ArrayList;
import java.util.List;

/**
 * Given a root node of the Binary Search Tree (BST) and integer 'k'. Return the Kth smallest element among all node values of the binary tree.

    Examples:

    Example 1:
    Input:

         8
        / \
       3   10
      / \    \
     1   6    14
        / \   /
        4  7 13
    k = 4
    Expected Output: 6
    Justification: The in-order traversal of the tree is [1, 3, 4, 6, 7, 8, 10, 13, 14]. The 4th element in this sequence is 6.

    Example 2:
    Input:

        5
       / \
      2   6
     /
    1
    k = 3
    Expected Output: 5
    Justification: The in-order traversal of the tree is [1, 2, 5, 6]. The 3rd element in this sequence is 5.

    Example 3:
    Input:

    1
     \
      3
     /
    2
    k = 2
    Expected Output: 2
    Justification: The in-order traversal of the tree is [1, 2, 3]. The 2nd element in this sequence is 2.

    Constraints:

    The number of nodes in the tree is n.
    1 <= k <= n <= 10^4
    0 <= Node.val <= 10^4
 */

public class  KthsSmallestNode {
    private List<Integer> myList = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        buildList(root, k);

        return myList.get(k - 1);
    }

    private void buildList(TreeNode node, int k) {
        System.out.println("buildList");
        if (myList.size() == k) {
            return;
        }

        if (node.left != null) {
            buildList(node.left, k);
        }

        myList.add(node.val);

        if (node.right != null) {
            buildList(node.right, k);
        }        

    }

    class TreeNode {
        int val;                // Value of the node.
        TreeNode left;          // Reference to the left child.
        TreeNode right;         // Reference to the right child.
        
        // Constructor to initialize the node with its value.
        TreeNode(int x) { val = x; }
    }    
}

// Time Complexity: O(n), where n is the number of nodes in the tree. In the worst case, we may need to traverse all nodes to find the kth smallest element.
// Space Complexity: O(n), where n is the number of nodes in the tree. We are storing the values of all nodes in a list.
