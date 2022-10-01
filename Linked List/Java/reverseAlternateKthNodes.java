/*Reverse alternate K nodes in a Singly Linked List

Difficulty Level : Medium
Last Updated : 03 Jul, 2022
Given a linked list, write a function to reverse every alternate k nodes (where k is an input to the function) in an efficient way. Give the complexity of your algorithm.

Example: 

Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
Output:   3->2->1->4->5->6->9->8->7->NULL. */

class reverseAlternateKthNodes {

	static Node head;

	class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/* Alternatively reverses the given linked list in groups of
	given size k. */
	Node kAltReverse(Node head, int k) {
		return _kAltReverse(head, k, true);
	}

	Node _kAltReverse(Node node, int k, boolean b) {
		if (node == null) {
			return null;
		}

		int count = 1;
		Node prev = null;
		Node current = node;
		Node next = null;

		while (current != null && count <= k) {
			next = current.next;

			/* Reverse the nodes only if b is true*/
			if (b == true) {
				current.next = prev;
			}

			prev = current;
			current = next;
			count++;
		}

		if (b == true) {
			node.next = _kAltReverse(current, k, !b);
			return prev;
		}
        else {
			prev.next = _kAltReverse(current, k, !b);
			return node;
		}
	}

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	void push(int newdata) {
		Node mynode = new Node(newdata);
		mynode.next = head;
		head = mynode;
	}

	public static void main(String[] args) {
		reverseAlternateKthNodes list = new reverseAlternateKthNodes();

		// Creating the linkedlist
		for (int i = 20; i > 0; i--) {
			list.push(i);
		}
		System.out.println("Given Linked List :");
		list.printList(head);
		head = list.kAltReverse(head, 3);
		System.out.println("");
		System.out.println("Modified Linked List :");
		list.printList(head);

	}
}