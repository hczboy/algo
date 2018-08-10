package my.czhhu.algo.tree;

import java.util.LinkedList;
import java.util.function.Consumer;

import my.czhhu.algo.common.Tnode;

public class VisitTreeByLevel {

	public static void visit(Tnode root, Consumer<Tnode> nodeCallback, Runnable levelCallback) {
		if (root == null)
			return;
		LinkedList<Tnode> q = new LinkedList<Tnode>();
		q.offer(root);
		int curVisit = 1;
		int nextVisit = 0;
		while (!q.isEmpty()) {
			Tnode n = q.poll();

			nodeCallback.accept(n);
			if (n.left != null) {
				q.offer(n.left);
				nextVisit++;
			}
			if (n.right != null) {
				q.offer(n.right);
				nextVisit++;
			}
			curVisit--;
			if (curVisit == 0) {
				levelCallback.run();
				curVisit = nextVisit;
				nextVisit = 0;
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
