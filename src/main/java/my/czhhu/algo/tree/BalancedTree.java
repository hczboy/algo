package my.czhhu.algo.tree;

import my.czhhu.algo.common.Tnode;

public class BalancedTree {

	static int checkHeight(Tnode root) {
		if (root == null)
			return 0;

		int hl = checkHeight(root.left);
		int hr = checkHeight(root.right);
		if (hl == -1 || hr == -1)
			return -1;

		int diff = Math.abs(hl - hr);
		if (diff > 1)
			return -1;
		else {
			return Math.max(hl, hr) + 1;
		}

	}

	static boolean isBanlanced(Tnode root) {
		if (checkHeight(root) == -1) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tnode root = new Tnode(4);
		Tnode l1 = new Tnode(3);
		Tnode l1l1 = new Tnode(8);
		Tnode r1 = new Tnode(7);
		Tnode l2 = new Tnode(5);
		Tnode r2 = new Tnode(6);

		// root.left = l1;
		root.left = null;
		l1.right = l1l1;
		root.right = r1;
		r1.left = l2;
		r1.right = r2;

		System.out.println(isBanlanced(root));
	}

}
