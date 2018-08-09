package my.czhhu.algo.linklist;

import java.util.concurrent.atomic.AtomicReference;

import my.czhhu.algo.common.Node;

public class ReverseK {

	static Node reverseK(Node head, int k) {
		AtomicReference<Node> nref = new AtomicReference<>();

		int len = reverseK(head, k, nref);
		System.out.println("len: " + len);
		return nref.get();
	}

	private static int reverseK(Node head, int k, AtomicReference<Node> nref) {
		int len = 0;
		if (head.getNext() == null) {
			len = 1;
			if (len == k) {
				nref.set(head);
			}
			return len;
		}
		len = reverseK(head.getNext(), k, nref);
		len += 1;

		if (len == k) {
			nref.set(head);
		}
		return len;

	}

	public static void main(String[] args) {
		Node h = new Node(1, new Node(2, new Node(3, new Node(4))));
		System.out.println(reverseK(h, 3).getData());
	}

}
