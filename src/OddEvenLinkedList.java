/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 25/7/2016.
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode dummy1 = new ListNode(1);
        ListNode dummy2 = new ListNode(2);
        dummyHead.next = dummy1;
        dummy1.next = dummy2;
        dummy2.next = head;

        ListNode pivot1 = dummy1;
        ListNode pivot2 = dummy2;

        int index = 1;
        ListNode runner = head;
        while (runner != null) {
            ListNode next = runner.next;

            if (index % 2 == 1) {
                // odd
                ListNode temp = pivot1.next;
                pivot1.next = runner;
                runner.next = temp;
                pivot2.next = next;
                pivot1 = pivot1.next;
            } else {
                // even
                pivot2 = pivot2.next;
            }

            runner = next;
            index ++;
        }

        runner = dummyHead;
        while (runner.next != dummy1) {
            runner = runner.next;
        }
        runner.next = runner.next.next;

        while (runner.next != dummy2) {
            runner = runner.next;
        }
        runner.next = runner.next.next;

        return dummy1.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        ListNode result = oddEvenLinkedList.oddEvenList(listNode1);
        System.out.println();

    }
}
