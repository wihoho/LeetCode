package ReverseNodesKGroup;

/**
 * Authored by GongLi at 14:18 on 2/3/14
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

    public ListNode reverseKGroup(ListNode head, int k) {

        if(k <= 1) return head;
        if(head == null) return head;

        ListNode start = head;
        ListNode cur = head;
        ListNode end;

        for(int i = 1; i < k; i ++){

            if(cur.next == null){
//                reverseLinkedlist(start, cur);
//                return cur;
                return head;
            }
            cur = cur.next;
        }

        ListNode next = cur.next;
        reverseLinkedlist(start, cur);
        ListNode newHead = cur;

        // Go on
        if(next == null) return newHead;

        start = next;
        cur = next;
        ListNode prev = head;

        while(true){

            for(int i = 1; i < k; i ++){
                if(cur.next == null){
//                    reverseLinkedlist(start, cur);
                    prev.next = start;
                    return newHead;
                }
                cur = cur.next;
            }

            next = cur.next;
            reverseLinkedlist(start, cur);
            prev.next = cur;
            prev = start;

            if(next != null){
                cur = next;
                start = next;
            }
            else{
                return newHead;
            }

        }
    }


    public void reverseLinkedlist(ListNode start, ListNode end){

        if(start == null) return;
        if(start == end) return;

        if(start.next == end) {
            end.next = start;
            start.next = null;
            return;
        }

        ListNode prev = start;
        ListNode cur = start.next;
        ListNode next = cur.next;

        while(next != end){
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }

        next.next = cur;
        cur.next = prev;

        start.next = null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

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
        s.reverseKGroup(one, 2);
        two.print();
    }

}
