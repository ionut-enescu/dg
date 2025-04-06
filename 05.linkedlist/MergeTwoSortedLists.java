/**
 * Given the head of two sorted linked lists, l1 and l2.

    Return a new sorted list created by merging together the nodes of the first two lists.

    Examples
    Example 1:

    Input:
    [1, 3, 5]
    [2, 4, 6]
    Expected Output:
    [1, 2, 3, 4, 5, 6]
    Justification: Merging the two sorted linked lists, node by node, results in a single sorted linked list containing all elements from both input lists.
    Example 2:

    Input:
    [2, 4, 6]
    [1, 3, 5]
    Expected Output:
    [1, 2, 3, 4, 5, 6]
    Justification: Both lists are in ascending order; merging them node by node in ascending order gives us the sorted linked list with all elements.
    Example 3:

    Input:
    [1, 2, 3]
    [4, 5, 6]
    Expected Output:
    [1, 2, 3, 4, 5, 6]
    Justification: As the first list contains all smaller elements, combining them results in a new list with elements from the first list followed by the second one.
    Constraints:

    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both list1 and list2 are sorted in non-decreasing order.
 */



public class MergeTwoSortedLists {
    // Function to merge two sorted linked lists
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l1tmp = l1;
        ListNode l2tmp = l2;

        while (l1tmp.next != null) {
            if (l1tmp.val < l2tmp.val) {
                System.out.println("l1tmp: " + l1tmp.val + "; l2tmp: " + l2tmp.val);
                while (l1tmp.next != null && l2tmp.val > l1tmp.next.val) {
                    l1tmp = l1tmp.next;
                }
                ListNode tmp = l1tmp.next;
                l1tmp.next = new ListNode(l2tmp.val, tmp);
                l1tmp = l1tmp.next;
            } else {
                while (l1tmp.val > l2tmp.val) {
                    l1tmp = new ListNode(l2tmp.val, l1tmp);
                    l1= l1tmp;
                    System.out.println(l1.val);
                    System.out.println(l1.next.val);
                    if (l2tmp.next == null) {
                        break;
                    }
                    l2tmp = l2tmp.next;
                }
                // ListNode next = l1tmp.next;
                // l1tmp = new ListNode(l2tmp.val);
                // l1tmp.next = next;
            }

            if (l2tmp.next == null) {
                break;
            }
            l2tmp = l2tmp.next;
        }

        if (l2tmp.next != null) {
            do {
                l1tmp.next = new ListNode(l2tmp.val, null);
                l1tmp = l1tmp.next;
                l2tmp = l2tmp.next;
            } while (l2tmp.next != null);
            l1tmp.next = new ListNode(l2tmp.val, null);
        }

        return l1;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode l1 = mergeTwoSortedLists.new ListNode(1, mergeTwoSortedLists.new ListNode(3, mergeTwoSortedLists.new ListNode(5)));
        ListNode l2 = mergeTwoSortedLists.new ListNode(2, mergeTwoSortedLists.new ListNode(4, mergeTwoSortedLists.new ListNode(6)));
        ListNode mergedList = mergeTwoSortedLists.mergeTwoLists(l1, l2);
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
} 

// time complexity: O(n + m), where n and m are the lengths of the two linked lists
// space complexity: O(1), since we are not using any extra space apart from the input lists and the merged list