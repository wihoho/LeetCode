/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 21/3/2016.
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        RandomListNode runner = head;
        while (runner != null) {
            RandomListNode next = runner.next;
            RandomListNode copy = new RandomListNode(runner.label);
            runner.next = copy;
            copy.next = next;

            runner = next;
        }

        runner = head;
        while (runner != null) {
            RandomListNode copy = runner.next;
            if (runner.random != null) {
                copy.random = runner.random.next;
            }
            runner = copy.next;
        }

        runner = head;
        RandomListNode result = runner.next;
        while (runner != null) {
            RandomListNode copy = runner.next;
            runner.next = copy.next;

            runner = runner.next;
            if (runner == null) {
                break;
            }
            copy.next = runner.next;
        }

        return result;
    }
}
