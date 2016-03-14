/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 4/3/2016.
 */
public class PartitionList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node3.next = node2;
        node2.next = node1;

        PartitionList partitionList = new PartitionList();
        ListNode result = partitionList.partition(node3, 2);
        System.out.println();
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(1);
        dummy.next = head;

        ListNode pivot = dummy;
        ListNode runner = head;
        ListNode prev = dummy;

        while (runner != null) {
            if (runner.val <= x) {
                // exchange
                ListNode temp = pivot.next;
                pivot.next = runner;
                runner = runner.next;
                pivot.next.next = temp;
                pivot = pivot.next;
                prev.next = runner;
            } else {
                runner = runner.next;
                prev = runner;
            }
        }

        return dummy.next;
    }
}
