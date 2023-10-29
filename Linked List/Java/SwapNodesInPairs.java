/* Leetcode Problem Link: https://leetcode.com/problems/swap-nodes-in-pairs/

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
*/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    // Function to swap pairs in a linked list
    public ListNode swapPairs(ListNode head) {
        // If the list is empty or has only one node, return the head
        if (head == null || head.next == null)
            return head;
        
        // Store the second node
        ListNode n = head.next;
        // Recursively call swapPairs for the rest of the list
        head.next = swapPairs(head.next.next);
        // Swap the first and second nodes
        n.next = head;
        // Return the new head of the swapped pairs
        return n;
    }

    // Main function to test the swapPairs method
    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        // Creating an instance of the Solution class
        Solution solution = new Solution();

        // Calling the swapPairs method and storing the new head
        ListNode newHead = solution.swapPairs(node1);

        // Printing the swapped pairs
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
