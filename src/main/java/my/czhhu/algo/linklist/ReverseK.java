package my.czhhu.algo.linklist;

import java.util.concurrent.atomic.AtomicInteger;
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

	static Node rk(Node head, int k) {
		if (head == null)
			return null;
		return rk(head, new AtomicInteger(0), k);

	}

	private static Node rk(Node p, AtomicInteger count, int k) {
		if (p == null)
			return null;
		Node r = rk(p.next, count, k);

		count.incrementAndGet();

		if (count.get() == k) {
			return p;
		}
		return r;

		/*
		 * if (p.next == null) { count.incrementAndGet(); if (k == count.get()) { return
		 * p; } else { return null; }
		 * 
		 * }
		 * 
		 * Node r = rk(p.next, count, k); if (r != null) return r; if (count.get() + 1
		 * == k) { return p; } else { count.incrementAndGet(); return null; }
		 */
	}

	public static void main(String[] args) {
		Node h = new Node(1, new Node(2, new Node(3, new Node(4))));
		System.out.println(reverseK(h, 3).getData());

		System.out.println(rk(h, 4).getData());
	}

}
