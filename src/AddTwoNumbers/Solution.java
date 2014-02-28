package AddTwoNumbers;

/**
 * Authored by GongLi at 0:16 on 27/2/14
 */


public class Solution {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int c) {

        if(l1 == null) {

            if(c == 0)
                return l2;
            else
                return addTwoNumbers(new ListNode(1), l2, 0);
        }

        if(l2 == null) {

            if(c == 0)
                return l1;
            else
                return addTwoNumbers(l1, new ListNode(1), 0);
        }


        int sum = l1.val + l2.val + c;
        ListNode current;
        if(sum <= 9){
            current = new ListNode(sum);
            current.next = addTwoNumbers(l1.next, l2.next, 0);
        }

        else{
            current = new ListNode(sum - 10);
            current.next = addTwoNumbers(l1.next, l2.next, 1);
        }

        return current;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return addTwoNumbers(l1,l2,0);

    }





    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(4);
        ListNode three = new ListNode(3);

        ListNode one1 = new ListNode(5);
        ListNode two1 = new ListNode(6);
        ListNode three1 = new ListNode(4);

        one.next = two;
        two.next = three;

        one1.next = two1;
//        two1.next = three1;

        ListNode cur = s.addTwoNumbers(one, one1, 0);
        System.out.println();


    }


}
