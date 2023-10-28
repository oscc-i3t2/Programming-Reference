/*
Problem: You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return solve(lists, lists.length);
    }

    ListNode solve(ListNode[] lists, int length){
         if(length == 1){
            return lists[0];
        }

        int pos = 0;
        for(int i = 0; i < length ; ){
            if(i + 1 < lists.length){
                lists[pos++] = mergeTwoLists(lists[i], lists[i+1]);
                i += 2;
            }else{
                lists[pos++] = lists[i++];
            }
        }
        return solve(lists, pos);
    }

    ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head = new ListNode();
        ListNode ans = head;

        while (l1 != null || l2 != null){
            if (l2 == null || (l1 != null && l1.val < l2.val)) {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }  else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }

        }
        // System.out.println(ans.next.val);
        return ans.next;
    }
}
/*
[|l1, l2,| |l3, l4,| l5.....ln]
[l12, l34, l56, ...ln.n/2]

*/
