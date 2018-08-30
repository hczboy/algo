package my.czhhu.algo.linklist;

import my.czhhu.algo.common.CommonOp;
import my.czhhu.algo.common.Node;

public class ReverseLinkedList {

	static Node r(Node h) {
		if (h == null)
			return h;

		Node p = new Node(-1);
		p.next = h;
		Node tail = h;
		while (tail.next != null) {
			Node tmp = p.next;
			p.next = tail.next;
			tail.next = tail.next.next;
			p.next.next = tmp;
		}
		return p.next;
	}

	public static void main(String[] args) {
		Node h = new Node(1, new Node(2));

		CommonOp.printLinkedList(r(h));

	}

}
