package my.czhhu.algo.leetcode.linkedList;

import java.util.concurrent.atomic.AtomicReference;

import my.czhhu.algo.common.CommonOp;
import my.czhhu.algo.common.Node;

public class ReverseLinkedListII92 {

	static Node rse(Node h, int s, int e) {
		if (h == null)
			return null;

		Node dummy = new Node(-1);
		dummy.next = h;
		Node p = dummy;
		int k = s - 1;
		while (k > 0 && p != null) {
			p = p.next;
			k--;
		}
		if (k != 0) {
			return null;
		}

		k = e;
		Node q = dummy;
		while (k > 0 && q != null) {
			q = q.next;
			k--;

		}
		if (k != 0) {
			return null;
		}

		Node tail = q.next;
		q.next = null;
		AtomicReference<Node> headRef = new AtomicReference<Node>();

		Node st = reverse(p.next, headRef);
		p.next = headRef.get();
		if (st != null) {
			st.next = tail;
		}

		return dummy.next;

	}

	static Node reverse(Node head, AtomicReference<Node> headRef) {
		if (head == null)
			return null;

		Node prefix = reverse(head.next, headRef);
		if (prefix == null) {
			headRef.set(head);
			return head;
		} else {
			prefix.next = head;
			prefix = head;
			prefix.next = null;
			return prefix;
		}

	}

	static Node reversePart(Node h, int s, int e) {
		if (h == null)
			return h;

		Node dummy = new Node(-1);
		dummy.next = h;
		Node p = dummy;
		int k = 0;
		while (++k < s) {
			p = p.next;

		}

		Node tail = p.next;
		while (++k <= e) {
			Node tmp = p.next;

			p.next = tail.next;
			tail.next = tail.next.next;
			p.next.next = tmp;
		}

		return dummy.next;

	}

	public static void main(String[] args) {
		/*
		 * AtomicReference<Node> headRef = new AtomicReference<Node>(); Node h = new
		 * Node(1, new Node(2));
		 * 
		 * reverse(h, headRef); CommonOp.printLinkedList(headRef.get());
		 */

		Node h = new Node(1, new Node(2, new Node(3)));
		// CommonOp.printLinkedList(rse(h, 1, 3));
		CommonOp.printLinkedList(reversePart(h, 1, 3));

	}

}
