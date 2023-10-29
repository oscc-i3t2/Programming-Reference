/* Leetcode Problem Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
*/

import java.util.*;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    // Function to delete duplicates from a sorted singly-linked list.
    public ListNode deleteDuplicates(ListNode head) { 
        // Create a dummy node to handle cases where the head itself is a duplicate.
        ListNode dummy = new ListNode(0);
        // Initialize fast and slow pointers.
        ListNode fast = head;
        ListNode slow = dummy;
        // Connect dummy node to the head of the original list.
        slow.next = fast;
        // Traverse through the list.
        while(fast != null) {
            // Use a while loop to find the last node of the duplicates.
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            // If duplicates are detected, remove them.
            if (slow.next != fast) {
                slow.next = fast.next;
                fast = slow.next;
            } else { // If no duplicate is found, move down both pointers.
                slow = slow.next;
                fast = fast.next;
            }
        }
        // Return the modified list without duplicates.
        return dummy.next;
    }

    // Main function to test the deleteDuplicates function.
    public static void main(String[] args) {
       // Create a sample linked list for testing the function.
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Create an instance of the Solution class.
        Solution solution = new Solution();
        // Call the deleteDuplicates function and store the result in modifiedList.
        ListNode modifiedList = solution.deleteDuplicates(node1);

        // Print the modified list to verify the function.
        ListNode temp = modifiedList;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
