/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 21/4/2016.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half
        ListNode secondHalfHeader = slow.next;
        slow.next = null;

        ListNode reverseHead = reverseNode(secondHalfHeader);

        ListNode runner1 = head;
        ListNode runner2 = reverseHead;

        while (runner1 != null && runner2 != null) {
            if (runner1.val != runner2.val) {
                return false;
            }

            runner1 = runner1.next;
            runner2 = runner2.next;
        }

        if (runner1 == null  && runner2 == null) {
            return true;
        } else if (runner1 != null && runner1.next == null) {
            return true;
        } else if (runner2 != null && runner2.next == null) {
            return true;
        }

        return false;
    }

    public ListNode reverseNode(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode nextNode = head.next;
        ListNode result = reverseNode(head.next);
        nextNode.next = head;
        head.next = null;
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        boolean result = palindromeLinkedList.isPalindrome(node1);
        System.out.println(result);

    }
}
