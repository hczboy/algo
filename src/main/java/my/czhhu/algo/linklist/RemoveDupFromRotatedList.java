package my.czhhu.algo.linklist;

import my.czhhu.algo.common.CommonOp;
import my.czhhu.algo.common.Node;

/*
 * 1->2->2
 * ^_____|     
 * return 1->
 *        ^__| 
 * 
 * 
 * /
 */
public class RemoveDupFromRotatedList {

	static Node removeDups(Node head, int t) {
		if (head == null)
			return null;

		// Node dummy = new Node(-1);
		// dummy.next = head;

		Node h = head;
		while (h.data == t && h.next != head) {
			h = h.next;
		}

		if (h.next == head)
			return null;

		head = h;

		Node p = head, q = p.next;
		while (q != head) {
			if (q.data == t) {
				p.next = q.next;
			} else {
				p = p.next;
			}
			q = q.next;
		}

		return head;
	}

	public static void main(String[] args) {
		Node last = new Node(2, null);

		Node head = new Node(1, new Node(2, last));
		last.next = head;

		Node l = new Node(2, null);
		Node h1 = new Node(2, new Node(1, l));
		l.next = h1;

		Node l2 = new Node(2, null);
		Node h2 = new Node(2, new Node(2, l2));
		l2.next = h2;

		CommonOp.printRotateLinkedList(removeDups(head, 2));
		CommonOp.printRotateLinkedList(removeDups(h1, 2));
		CommonOp.printRotateLinkedList(removeDups(h2, 2));

	}

}
