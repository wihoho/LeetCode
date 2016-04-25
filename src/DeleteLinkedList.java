/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 22/4/2016.
 */
public class DeleteLinkedList {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        ;
        if (node.next != null) {
            int nextValue = node.next.val;
            node.next = node.next.next;
            node.val = nextValue;
        }
    }
}
