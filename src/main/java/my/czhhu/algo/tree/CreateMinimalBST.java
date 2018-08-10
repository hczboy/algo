package my.czhhu.algo.tree;

import my.czhhu.algo.common.CommonOp;
import my.czhhu.algo.common.Tnode;

public class CreateMinimalBST {

	static Tnode create(int[] a) {
		if (a == null || a.length == 0)
			return null;
		return create(a, 0, a.length - 1);
	}

	private static Tnode create(int[] a, int s, int e) {
		if (s > e) {
			return null;
		}
		int mid = (s + e) / 2;
		Tnode n = new Tnode(a[mid]);
		n.left = create(a, s, mid - 1);
		n.right = create(a, mid + 1, e);
		return n;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, };

		CommonOp.printTreeByLevel(create(a));
	}

}
