/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 4/3/2016.
 */
public class RemoveDuplicateFromSortedListOne {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode cur = head;

        while (cur != null) {
            while (cur.next != null && cur.next.val == cur.val) {
                cur.next = cur.next.next;
            }

            cur = cur.next;
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
