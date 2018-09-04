package my.czhhu.algo.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import my.czhhu.algo.common.Tnode;

public class MostRightTreeNode {

	static List<Integer> getMostRightTreeNode(Tnode root) {
		if (root == null)
			return Collections.EMPTY_LIST;
		LinkedList<Tnode> nq = new LinkedList<>();
		nq.offer(root);
		int cur = 1; // size of current level
		int next = 0; // size of next level
		List<Integer> res = new ArrayList<>();
		while (!nq.isEmpty()) {
			Tnode n = nq.poll();
			cur--;
			if (n.left != null) {
				nq.offer(n.left);
				next++;
			}

			if (n.right != null) {
				nq.offer(n.right);
				next++;
			}
			if (cur == 0) {
				res.add(n.data); // if cur ==0, then reach the last Tnode of current level
				cur = next;
				next = 0;

			}

		}
		return res;

	}

	static List<Integer> getMostRightTreeNodeR(Tnode root) {
		if (root == null)
			return Collections.EMPTY_LIST;
		List<Integer> res = new ArrayList<>();

		getMRTnode(root, res, 0);
		return res;
	}

	private static void getMRTnode(Tnode root, List<Integer> res, int depth) {
		if (root == null)
			return;
		if (depth == res.size()) {
			res.add(root.data);
		}
		getMRTnode(root.right, res, depth + 1);
		getMRTnode(root.left, res, depth + 1);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

		System.out.println(getMostRightTreeNode(root));
		System.out.println(getMostRightTreeNodeR(root));

	}

}
