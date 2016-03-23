/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 22/3/2016.
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode n = reverse(slow.next);
        slow.next = null;

        ListNode m = head;

        while (m != null && n != null) {
            ListNode tempM = m.next;
            ListNode tempN = n.next;

            m.next = n;
            n.next = tempM;
            m = tempM;
            n = tempN;
        }
    }

    public ListNode reverse(ListNode start) {
        if (start == null || start.next == null) return start;

        ListNode m = start;
        ListNode n = start.next;
        start.next = null;
        while (m != null && n!= null) {
            ListNode temp = n.next;
            n.next = m;
            m =n;
            n = temp;
        }

        return m;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
//        three.next = four;
//        four.next = five;

        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(one);
        System.out.println();
    }
}
