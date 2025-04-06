/**
 * Given a doubly linked list, determine whether it is a palindrome.

    A doubly linked list is a palindrome if it reads the same backward as forward, utilizing the previous and next pointers of the nodes.

    Examples
    Example 1:

    Input: 1 <-> 2 <-> 3 <-> 2 <-> 1
    Output: true
    Justification: The list reads the same backward as forward.
    Example 2:

    Input: 1 <-> 2 <-> 2 <-> 3
    Output: false
    Justification: Reading backward, the list is 3 <-> 2 <-> 2 <-> 1, which is not the same as reading forward.
    Example 3:

    Input: 1 <-> 1 <-> 1 <-> 1
    Output: true
    Justification: All elements are the same, so the list is a palindrome.
 */



class PalindromeInDeque {
   public boolean isPalindrome(DLNode head) {
       if (head == null || head.next == null) {
           return true;
       }

       DLNode curHead = head;
       DLNode curTail;
       int size = 1;

       while (curHead.next != null) {
           size++;
           curHead = curHead.next;
       }

       curTail = curHead;
       curHead = head;

       for (int i = 0; i < size/2; i++) {
           if (curHead.val != curTail.val) {
               return false;
           }
           curHead = curHead.next;
           curTail = curTail.prev;
       }

       return true;
   }

   class DLNode {
      int val;
      DLNode next, prev;
      DLNode(int val) { this.val = val; }
   }

    public static void main(String[] args) {
         PalindromeInDeque solution = new PalindromeInDeque();
         DLNode head = solution.new DLNode(1);
         head.next = solution.new DLNode(2);
         head.next.prev = head;
         head.next.next = solution.new DLNode(3);
         head.next.next.prev = head.next;
         head.next.next.next = solution.new DLNode(2);
         head.next.next.next.prev = head.next.next;
         head.next.next.next.next = solution.new DLNode(1);
         head.next.next.next.next.prev = head.next.next.next;
    
         System.out.println(solution.isPalindrome(head)); // Output: true
    }
}

// Time Complexity: O(n), where n is the number of nodes in the doubly linked list.
// Space Complexity: O(1), as we are using a constant amount of space for pointers and variables.
