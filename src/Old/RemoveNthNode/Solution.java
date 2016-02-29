package Old.RemoveNthNode;

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
                System.out.println(temp.val+"->");
                temp = temp.next;
            }
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null || n < 1) return null;

        ListNode fast = head;
        for(int i = 0; i < n; i ++){
            if(fast == null) return head;
            fast = fast.next;
        }

        ListNode slow = head;
        if(fast == null){
            return slow.next;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

}