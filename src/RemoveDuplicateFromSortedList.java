/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 3/3/2016.
 */
public class RemoveDuplicateFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode start = head.next;
        if (start == null) {
            return head;
        }

        ListNode prev = head;
        ListNode prevPrev = null;

        ListNode finalHead = null;
        while (start != null) {
            if (start.val == prev.val) {
                if (prevPrev == null) {
                    if (start.next != null) {
                        prev = start.next;
                        start = prev.next;
                        finalHead = prev;
                    } else {
                        break;
                    }
                } else {
                    prevPrev.next = start.next;
                    prev = start.next;

                    if (start.next != null) {
                        start = start.next.next;
                    } else {
                        break;
                    }
                }
            } else {
                prevPrev = prev;
                prev = start;
                start = start.next;

                if (finalHead == null) {
                    finalHead = prevPrev;
                }
            }
        }

        return finalHead;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        RemoveDuplicateFromSortedList removeDuplicateFromSortedList = new RemoveDuplicateFromSortedList();
        ListNode result = removeDuplicateFromSortedList.deleteDuplicates(node1);
        System.out.println();

    }
}
