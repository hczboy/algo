package my.czhhu.algo.leetcode;

import my.czhhu.algo.common.CommonOp;
import my.czhhu.algo.common.Node;

public class RotateList61 {

	static Node rotate(Node head, int k) {
		if (head == null || k <= 0)
			return head;

		int len = 0;
		Node p = head;

		while (p != null) {
			len++;
			p = p.next;
		}

		k = k % len;

		if (k == 0)
			return head;
		Node f = head, s = head;
		while (k > 0 && f != null) {
			f = f.next;
			k--;
		}
		if (f == null)
			return null;
		while (f.next != null) {
			s = s.next;
			f = f.next;
		}

		Node t = head;
		head = s.next;
		f.next = t;
		s.next = null;
		return head;

	}

	public static void main(String[] args) {
		Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));

		Node t = rotate(head, 6);

		CommonOp.printLinkedList(t);

	}

}
