/**
 * Given two binary trees, root1 and root2, merge them into a single, new binary tree.

    If two nodes from the given trees share the same position, their values should be summed up in the resulting tree. If a node exists in one tree but not in the other, the resulting tree should have a node at the same position with the value from the existing node.

    Examples

    Example 1:

    Trees:

    Tree 1:    1            Tree 2:       1
             /   \                      /   \
            3     2                    2     3

    Merged:       2
                /   \
               5     5
    Justification: The root nodes of both trees have the value 1, so the merged tree's root has a value of 1 + 1 = 2. For the left child, 3 + 2 = 5 and for the right child, 2 + 3 = 5.

    Example 2:

    Trees:

    Tree 1:   5            Tree 2:       3
            /   \                      /   \
           4     7                    2     6

    Merged:       8
                /   \
               6    13
    Justification: The root nodes have values 5 and 3 respectively. So, the merged tree's root value becomes 5 + 3 = 8. The left child is 4 + 2 = 6 and the right child is 7 + 6 = 13.

    Example 3:

    Trees:

    Tree 1:    2            Tree 2:      2
                \                       /   
                 5                     3     

    Merged:       4
                /   \
               3     5
    Justification: The root nodes have values 2 each, so the merged tree's root value is 2 + 2 = 4. Tree 1 doesn't have a left child, so we take the left child of Tree 2 as it is, which is 3. Similarly, Tree 2 doesn't have a right child, so the merged tree's right child is the same as Tree 1, which is 5.

    Example 4:

    Trees:

    Tree 1:   10           Tree 2:       10
            /    \                     /    \
           5     15                   6     16

    Merged:       20
                /    \
               11    31
    Justification: The root nodes have the value 10, so they add up to 20 for the merged tree. The left child values add up to 5 + 6 = 11 and the right child values sum up to 15 + 16 = 31.

    Constraints:

    The number of nodes in the tree is in the range [0, 2000].
    -10^4 <= Node.val <= 10^4
 */


public class MergeTwoBSTs {

    private boolean dontAdd = false;

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        mergeSubtrees(t1, t2);

        return t1;        
    }


    private void mergeSubtrees(TreeNode t1, TreeNode t2) {
        if (dontAdd) {
            dontAdd = false;
        } else if (t1 != null && t2 != null) {
            t1.val += t2.val;
        } else if (t2 == null) {
            System.out.println("t2 is null");
            return;
        }

        if (t1.left == null && t2.left != null) {
            t1.left = new TreeNode(t2.left.val);
            dontAdd = true;
        }
        mergeSubtrees(t1.left, t2.left);

        if (t1.right == null && t2.right != null) {
            t1.right = new TreeNode(t2.right.val);
            dontAdd = true;
        } 
        mergeSubtrees(t1.right, t2.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

// Time Complexity: O(n), where n is the number of nodes in the larger tree. This is because we need to traverse each node once to merge the trees.
// Space Complexity: O(h), where h is the height of the tree. This is due to the recursion stack space used during the traversal. In the worst case, this can be O(n) if the tree is skewed (like a linked list). However, in a balanced tree, it would be O(log n).
