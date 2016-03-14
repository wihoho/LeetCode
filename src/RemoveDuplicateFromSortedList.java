/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 3/3/2016.
 */
public class RemoveDuplicateFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode dummyNode = new ListNode(1);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        ListNode cur = head;

        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }

            if (prev.next == cur) {
                prev = prev.next;
            } else {
                prev.next = cur.next;
            }

            cur = cur.next;
        }

        return dummyNode.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        RemoveDuplicateFromSortedList removeDuplicateFromSortedList = new RemoveDuplicateFromSortedList();
        ListNode result = removeDuplicateFromSortedList.deleteDuplicates(node1);
        System.out.println();

    }
}
