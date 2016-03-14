/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 9/3/2016.
 */
public class ReverseLinkedListTwo {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        for(int i = 1; i < m; i ++) {
            prev = prev.next;
        }

        ListNode cur = prev.next;
        ListNode speical = cur;
        if (cur.next == null) {
            return dummyNode.next;
        } else {
            cur = cur.next;
        }

        for(int i = m; i < n; i ++) {
            ListNode temp = cur.next;

            ListNode prevNext = prev.next;
            prev.next = cur;
            cur.next = prevNext;

            speical.next = temp;
            cur = temp;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;

        ReverseLinkedListTwo reverseLinkedListTwo = new ReverseLinkedListTwo();
        reverseLinkedListTwo.reverseBetween(one, 2, 3);
    }
}
