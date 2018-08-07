package my.czhhu.algo.common;

public class Tnode {
	public int data;

	public Tnode left;

	public Tnode right;

	public Tnode(int data, Tnode left, Tnode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public Tnode(int data) {
		super();
		this.data = data;
	}

}
