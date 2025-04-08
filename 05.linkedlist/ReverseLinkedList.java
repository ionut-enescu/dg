/**
 * Given the head of a singly linked list, your task is to reverse the list and
 * return its head. The singly linked list has nodes, and each node contains an
 * integer and a pointer to the next node. The last node in the list points to
 * null, indicating the end of the list.
 * 
 * Examples
 * Example 1:
 * Input: [3, 5, 2]
 * Expected Output: [2, 5, 3]
 * Justification: Reversing the list [3, 5, 2] gives us [2, 5, 3].
 * Example 2:
 * Input: [7]
 * Expected Output: [7]
 * Justification: Since there is only one element in the list, the reversed list
 * remains the same.
 * Example 3:
 * Input: [-1, 0, 1]
 * Expected Output: [1, 0, -1]
 * Justification: The list is reversed, so the elements are in the order [1, 0,
 * -1].
 * Constraints:
 * 
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 */

class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode head2 = null;
        ListNode temp = head;

        do {
            ListNode newNode = new ListNode(temp.val);
            newNode.next = head2;
            head2 = newNode;
            temp = temp.next;
        } while (temp != null);

        return head2;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList rll = new ReverseLinkedList();
        ListNode head = rll.new ListNode(1);
        head.next = rll.new ListNode(2);
        head.next.next = rll.new ListNode(3);
        head.next.next.next = rll.new ListNode(4);
        head.next.next.next.next = rll.new ListNode(5);

        ListNode reversedHead = rll.reverseList(head);
        while (reversedHead != null) {
            System.out.print(reversedHead.val + " ");
            reversedHead = reversedHead.next;
        }
    }

}

// Time Complexity: O(n), where n is the number of nodes in the linked list.
// Space Complexity: O(n), as we are creating a new linked list to store the
// reversed nodes.
