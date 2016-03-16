/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 15/3/2016.
 */
public class ListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode runner = head;
        while (runner.next != null) {
            runner = runner.next;
        }

        return  sortedListToBST(head, runner);

    }

    public TreeNode sortedListToBST(ListNode start, ListNode end) {
        if (start == null || end == null) {
            return null;
        }

        ListNode runnerCheck = start;
        while (!runnerCheck.equals(end) ) {
            runnerCheck = runnerCheck.next;
        }

        if (!runnerCheck.equals(end)) {
            return null;
        }

        if (start.equals(end)) {
            return new TreeNode(start.val);
        }

        if (start.next.equals(end)) {
            TreeNode one = new TreeNode(start.val);
            TreeNode two = new TreeNode(end.val);
            two.left = one;
            return two;
        }

        ListNode prev = null;
        ListNode slow = start;
        ListNode fast = start;

        while (fast != end && fast.next != end) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(start, prev);
        root.right = sortedListToBST(slow.next, end);

        return root;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        ListToBST listToBST = new ListToBST();
        TreeNode  n = listToBST.sortedListToBST(a);
        System.out.println();
    }


}
