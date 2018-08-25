package my.czhhu.algo.leetcode;

import my.czhhu.algo.common.CommonOp;
import my.czhhu.algo.common.Node;

public class RemoveDuplicatedFromSortedListII82 {

	static Node removeDup(Node head) {
		if (head == null || head.next == null)
			return head;

		Node found = null; // pointer to tail of result
		Node h = null; // pointer to head

		Node n = head; // head of next beginning
		Node cur = n.next; // cur pointer

		while (cur != null) {
			while (cur != null && n.data == cur.data) {
				cur = cur.next;
			}
			if (cur == null)
				return h;

			if (n.next == cur) {
				if (found == null) {
					found = n;
					h = n;

				} else {
					found.next = n;
					found = n;

				}
				found.next = null;

			}
			n = cur;
			cur = n.next;

		}
		found.next = n;
		found = n;
		found.next = null;

		// Node p = head;
		// Node q = head.next;
		// Node l = p;
		// Node h = null;
		// boolean isDup = false;
		// while (q != null) {
		// if (p.data != q.data) {
		// p = q;
		// q = q.next;
		// if (isDup) {
		// if (q == null)
		// return h;
		// p = q;
		// q = q.next;
		// l = p;
		// } else {
		//
		// if (h == null) {
		// h = l;
		// }
		// l = p;
		// }
		//
		// isDup = false;
		// } else {
		// isDup = true;
		// p.next = q.next;
		// q = q.next;
		//
		// }
		//
		// }

		return h;

	}

	public static void main(String[] args) {
		Node head = new Node(1, new Node(2, new Node(3, new Node(3, new Node(4, new Node(4, new Node(5)))))));
		Node h1 = new Node(1, new Node(1, new Node(1, new Node(2, new Node(3, new Node(3))))));
		CommonOp.printLinkedList(removeDup(head));
		CommonOp.printLinkedList(removeDup(h1));

	}

}
