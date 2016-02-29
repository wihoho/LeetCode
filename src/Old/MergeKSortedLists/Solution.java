package Old.MergeKSortedLists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Authored by GongLi at 12:35 on 2/3/14
 */


public class Solution {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {

        if(lists.size() == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(

        ) {
            @Override
            public int compare(ListNode listNode, ListNode listNode2) {

                if(listNode.val < listNode2.val) return -1;
                else if(listNode.val == listNode2.val) return 0;
                else return 1;
            }
        });

        for(ListNode temp: lists){
            if(temp != null)
                pq.add(temp);
        }

        ListNode head = new ListNode(-1);
        ListNode prev = head;

        while(!pq.isEmpty()){

            ListNode temp = pq.poll();
            prev.next = temp;

            if(temp.next != null)
                pq.add(temp.next);

            prev = prev.next;
        }

        return head.next;
    }


}
