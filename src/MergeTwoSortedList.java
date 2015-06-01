/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedList {


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);

        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n3;
        n3.next = n5;
        n2.next = n4;
        n4.next = n6;

        ListNode merge = mergeTwoLists(n1, n2);

        while (merge != null) {
            System.out.print(merge.val + "->");
            merge = merge.next;
        }

    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        ListNode start, runner1, runner2;
        if (l1.val <= l2.val) {
            start = new ListNode(l1.val);
            runner1 = l1.next;
            runner2 = l2;
        } else {
            start = new ListNode(l2.val);
            runner1 = l1;
            runner2 = l2.next;
        }

        ListNode result = start;
        while (runner1 != null && runner2 != null) {
            if (runner1.val <= runner2.val) {
                start.next = new ListNode(runner1.val);
                runner1 = runner1.next;
            } else {
                start.next = new ListNode(runner2.val);
                runner2 = runner2.next;
            }

            start = start.next;
        }

        if (runner1 == null) {
            while (runner2 != null) {
                start.next = new ListNode(runner2.val);
                start = start.next;
                runner2 = runner2.next;
            }

        } else {
            while (runner1 != null) {

                start.next = new ListNode(runner1.val);
                start = start.next;
                runner1 = runner1.next;
            }

        }


        return result;


    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}