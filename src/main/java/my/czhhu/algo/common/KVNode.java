package my.czhhu.algo.common;

public class KVNode<K, V> {
	public KVNode(K k, V v) {
		this.key = k;
		this.val = v;
	}

	public K key;

	public KVNode() {
		super();
	}

	public V val;

	public KVNode<K, V> next;
}
