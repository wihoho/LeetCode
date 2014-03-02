package SwapNodesInPairs;

/**
 * Authored by GongLi at 12:44 on 2/3/14
 */


public class Solution {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }


        void print(){
            ListNode temp = this;
            while(temp != null){
                System.out.print(temp.val + "->");
                temp = temp.next;
            }
            System.out.println();
        }
    }


    public ListNode swapPairs(ListNode head) {

        if(head == null) return null;
        if(head.next == null) return head;
        if(head.next.next == null){
            ListNode cur = head.next;
            cur.next = head;
            head.next = null;
            return cur;
        }

        ListNode prev = head;
        ListNode cur = head.next;
        ListNode next = cur.next;

        ListNode resultHead = cur;
        cur.next = prev;

        if(next.next == null){
            prev.next = next;
            return resultHead;
        }

        cur = next;
        next = next.next.next;

        while (next != null){
            prev.next = cur.next;
            prev.next.next = cur;

            prev = cur;
            cur = next;

            if(next.next == null){
                prev.next = cur;
                return resultHead;
            }

            else
                next = next.next.next;
        }

        prev.next = cur.next;
        cur.next.next = cur;
        cur.next = null;

        return resultHead;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
//        four.next = five;
        one.print();

        Solution s = new Solution();
        ListNode temp = s.swapPairs(one);
        temp.print();



    }
}
