/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 23/3/2016.
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        if (head.next.next == null) {
            ListNode one = head;
            ListNode two = head.next;

            if (one.val <= two.val) {
                return head;
            } else {

                two.next = one;
                one.next = null;
                return two;

            }


        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        ListNode fist1 = sortList(head);
        ListNode second1 = sortList(second);

        return merge(fist1, second1);
    }

    public ListNode merge(ListNode m, ListNode n) {
        ListNode dummy = new ListNode(0);

        ListNode runner = dummy;
        while (m != null && n != null) {
            if (m.val <= n.val) {
                runner.next = m;
                m = m.next;
            } else {
                runner.next = n;
                n = n.next;
            }
            runner = runner.next;
        }

        if (m == null) {
            runner.next = n;
        }

        if (n == null) {
            runner.next = m;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        two.next = one;
        three.next = two;

        SortList sortList = new SortList();
        ListNode result = sortList.sortList(three);
        System.out.println();
    }
}
