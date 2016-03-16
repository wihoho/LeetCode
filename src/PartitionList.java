/**
 * Created by wihoho on 5/3/16.
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode dummy1 = new ListNode(1);
        ListNode dummy2 = new ListNode(1);

        ListNode p = dummy1;
        ListNode q = dummy2;

        ListNode runner = head;
        while (runner != null) {
            if (runner.val < x) {
                p.next = runner;
                p = p.next;
            } else {
                q.next = runner;
                q = q.next;
            }

            runner = runner.next;
        }

        q.next = null;
        p.next = dummy2.next;
        return dummy1.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

//        node3.next = node2;
        node2.next = node1;

        PartitionList partitionList = new PartitionList();
        ListNode result = partitionList.partition(node2, 1);
        System.out.println();

    }
}
