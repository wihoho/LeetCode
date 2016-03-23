/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 23/3/2016.
 */
public class InsertSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode runner = head;
        ListNode result = head;

        while (runner.next != null) {
            ListNode temp1 = runner.next;

            ListNode temp2 = null;
            if (temp1 != null) {
                temp2 = temp1.next;
            }

            ListNode runner2 = result;
            if (temp1.val <= runner2.val) {
                temp1.next = result;
                result = temp1;

            } else {

                boolean flag = false;
                while (runner2.next != temp1) {
                    if (temp1.val <= runner2.next.val) {
                        ListNode xx = runner2.next;
                        runner2.next = temp1;
                        temp1.next = xx;
                        flag = true;
                        break;
                    } else {
                        runner2 = runner2.next;
                    }
                }

                if (!flag && runner2.next == temp1) {
                    runner = runner.next;
                }
            }

            runner.next = temp2;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode three = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode four = new ListNode(4);

        four.next = two;
        two.next = one;
        one.next = three;

        InsertSortList insertSortList = new InsertSortList();
        ListNode result = insertSortList.insertionSortList(four);
        System.out.println();
    }
}
