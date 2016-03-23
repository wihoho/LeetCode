/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 22/3/2016.
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast != null && fast.val == slow.val) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return fast;
        }

        slow = head;
        while (slow != fast) { // move x steps further
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
