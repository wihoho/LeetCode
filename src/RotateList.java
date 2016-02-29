/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 11/12/2015.
 */
public class RotateList {
    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;

        RotateList rotateList = new RotateList();
        ListNode result = rotateList.rotateRight(n1, 2);
        System.out.println();
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        if (k <= 0) return head;

        int length = 0;
        ListNode runner = head;
        while (runner != null) {
            length += 1;
            runner = runner.next;
        }

        k = k % length;
        if (k == 0) {
            return head;
        }

        runner = head;
        int step = length - k - 1;

        for (int i = 1; i <= step; i++) {
            runner = runner.next;
        }

        ListNode newEnd = runner;
        ListNode newStart = runner.next;

        newEnd.next = null;

        runner = newStart;
        while (runner.next != null) {
            runner = runner.next;
        }

        runner.next = head;
        return newStart;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
