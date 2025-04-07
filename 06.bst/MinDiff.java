/**
 * Given a Binary Search Tree (BST), you are required to find the smallest difference between the values of any two different nodes.

    In a BST, the nodes are arranged in a manner where the value of nodes on the left is less than or equal to the root, and the value of nodes on the right is greater than the root.

    Example

    Example 1:

    Input:
        4
    / \
    2   6
    / \
    1   3
    Expected Output: 1
    Justification: The pairs (1,2), (2,3), or (3,4) have the smallest difference of 1.
    Example 2:

    Input:
       10
      /  \
      5   15
     / \    \
    2   7    18
    Expected Output: 2
    Justification: The pair (5,7) has the smallest difference of 2.
    Example 3:

    Input:
       40
        \
         70
        /  \
       50  90
    Expected Output: 10
    Justification: The pair (40,50) has the smallest difference of 10.
    Constraints:

    The number of nodes in the tree is in the range [2, 10^4].
    0 <= Node.val <= 10^5
 */

import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;
 

 
 public class MinDiff {
     // Using a List to hold the values in order.
     private List<Integer> nodes = new ArrayList<>();
     private int minDiff = Integer.MAX_VALUE;
     
     public int minDiffInBST(TreeNode root) {
         treeToList(root);
         Iterator<Integer> iterator = nodes.iterator();
         int prev = iterator.next();
 
         while (iterator.hasNext()) {
             int cur = iterator.next();
             int tmp = Math.abs(prev - cur);
             prev = cur;
             minDiff = minDiff < tmp ? minDiff : tmp;           
         }
 
         return minDiff;
     }
 
     private void treeToList(TreeNode root) {
         if (root.left != null) {
             treeToList(root.left);
         }
 
         nodes.add(root.val);
 
         if (root.right != null) {
             treeToList(root.right);
         }
     }

    // TreeNode class to represent the Binary Search Tree nodes.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        // Example usage of the MinDiff class.
        MinDiff minDiff = new MinDiff();
        
        // Constructing a sample BST:
        TreeNode root = minDiff.new TreeNode(4);
        root.left = minDiff.new TreeNode(2);
        root.right = minDiff.new TreeNode(6);
        root.left.left = minDiff.new TreeNode(1);
        root.left.right = minDiff.new TreeNode(3);
        
        // Finding the minimum difference in the BST.
        int result = minDiff.minDiffInBST(root);
        System.out.println("Minimum difference: " + result); // Output: 1
    }
 }

// Time Complexity: O(n), where n is the number of nodes in the tree. We traverse each node once to build the list and then again to find the minimum difference.
// Space Complexity: O(n), where n is the number of nodes in the tree. We store all node values in a list. 
 