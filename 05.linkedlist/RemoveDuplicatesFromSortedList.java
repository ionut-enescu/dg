/**
 * Given a sorted linked list, remove all the duplicate elements to leave only distinct numbers. The linked list should remain sorted, and the modified list should be returned.

    Examples
    Example 1:
    Input: 1 -> 1 -> 2
    Output: 1 -> 2
    Justification: Since 1 is repeated, we remove the duplicate to leave a sorted list of unique numbers.
    Example 2:
    Input: 1 -> 2 -> 2 -> 3
    Output: 1 -> 2 -> 3
    Justification: Here, 2 is the duplicate element, and by removing it, we obtain a list containing only distinct elements.
    Example 3:
    Input: 3 -> 3 -> 3
    Output: 3
    Justification: We remove the repeated 3s to leave a single 3 in the list.
    Constraints:

    The number of nodes in the list is in the range [0, 300].
    -100 <= Node.val <= 100
    The list is guaranteed to be sorted in ascending order.
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
            
        return head;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        ListNode head = solution.new ListNode(1, solution.new ListNode(1, solution.new ListNode(2)));
        ListNode result = solution.deleteDuplicates(head);
        
        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

// Time Complexity: O(n), where n is the number of nodes in the linked list. We traverse the list once, checking each node and its next node for duplicates.
// Space Complexity: O(1), as we are modifying the list in place without using any additional data structures.
