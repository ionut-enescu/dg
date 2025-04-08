/**
 * Given a singly linked list, swap every two adjacent nodes and return the head
 * of the modified list.
 * 
 * If the total number of nodes in the list is odd, the last node remains in
 * place. Every node in the linked list contains a single integer value.
 * 
 * Examples
 * Input: [1, 2, 3, 4]
 * Output: [2, 1, 4, 3]
 * Justification: Pairs (1,2) and (3,4) are swapped.
 * 
 * Input: [7, 8, 9, 10, 11]
 * Output: [8, 7, 10, 9, 11]
 * Justification: Pairs (7,8) and (9,10) are swapped. 11 remains in its place as
 * it has no adjacent node to swap with.
 * 
 * Input: [5, 6]
 * Output: [6, 5]
 * Justification: The pair (5,6) is swapped.
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode prev = new ListNode(-1, null);
        head = prev;

        while (cur != null && cur.next != null) {
            ListNode first = new ListNode(cur.next.val);
            ListNode second = new ListNode(cur.val);
            ListNode third = cur.next.next != null ? new ListNode(cur.next.next.val) : null;

            prev.next = first;
            first.next = second;
            second.next = third;

            prev = second;
            cur = cur.next.next != null ? cur.next.next : null;
        }

        return head.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        ListNode head = solution.new ListNode(1,
                solution.new ListNode(2, solution.new ListNode(3, solution.new ListNode(4))));
        ListNode swappedHead = solution.swapPairs(head);

        // Print the swapped list
        ListNode current = swappedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}

// Time Complexity: O(n), where n is the number of nodes in the linked list.
// Space Complexity: O(1), as we are using a constant amount of space for the
// pointers.