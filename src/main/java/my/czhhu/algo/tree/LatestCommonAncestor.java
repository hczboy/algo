package my.czhhu.algo.tree;

import my.czhhu.algo.common.Tnode;

public class LatestCommonAncestor {

	static Tnode lca(Tnode root, Tnode n1, Tnode n2) {
		if (root == null || root == n1 || root == n2)
			return root;

		Tnode left = lca(root.left, n1, n2);
		Tnode right = lca(root.right, n1, n2);
		if (left != null && right != null) {
			return root;
		}
		if (left != null) {
			return left;
		}
		if (right != null) {
			return right;
		}

		return null;
	}

	static void printTreeByLevel(Tnode root) {
		if (root == null)
			return;
		System.out.println(root.data);
		printTreeByLevel(root.left);
		printTreeByLevel(root.right);
	}

	public static void main(String[] args) {
		Tnode root = new Tnode(4);
		Tnode l1 = new Tnode(3);
		// Tnode l1l1 = new Tnode(8);
		Tnode r1 = new Tnode(7);
		Tnode l2 = new Tnode(5);
		Tnode r2 = new Tnode(6);

		root.left = l1;
		// l1.right = l1l1;
		root.right = r1;
		r1.left = l2;
		r1.right = r2;

		System.out.println(lca(root, r1, l2).data);

	}

}
