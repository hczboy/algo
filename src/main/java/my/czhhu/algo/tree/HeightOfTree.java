package my.czhhu.algo.tree;

import my.czhhu.algo.common.Tnode;

public class HeightOfTree {

	static int height(Tnode root) {
		if (root == null) {
			return 0;
		}
		int hl = height(root.left);
		int hr = height(root.right);
		return Math.max(hl, hr) + 1;
	}

	public static void main(String[] args) {
		Tnode root = new Tnode(4);
		Tnode l1 = new Tnode(3);
		Tnode l1l1 = new Tnode(8);
		Tnode r1 = new Tnode(7);
		Tnode l2 = new Tnode(5);
		Tnode r2 = new Tnode(6);

		root.left = l1;
		l1.right = l1l1;
		root.right = r1;
		r1.left = l2;
		r1.right = r2;

		System.out.println(height(root));

	}

}
