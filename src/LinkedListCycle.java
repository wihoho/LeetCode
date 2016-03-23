/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 22/3/2016.
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast != null && fast.val == slow.val) {
                return true;
            }
        }

        return false;
    }
}
