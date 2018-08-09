package my.czhhu.algo.lintcode;

import java.util.HashMap;
import java.util.Map;

import my.czhhu.algo.common.KVNode;

public class LRUCache134<K, V> {

	private int capacity = 5;

	private int size = 0;

	private KVNode<K, V> head, tail;

	private Map<K, KVNode<K, V>> keyToPrev;

	public LRUCache134(int capacity) {
		super();
		if (capacity < 1) {
			throw new IllegalStateException("capacity must be > 0");
		}
		this.capacity = capacity;

		keyToPrev = new HashMap<>((int) (capacity / 0.75) + 1);
		head = new KVNode<>();
		tail = head;

	}

	public V get(K key) {
		if (!exists(key) || key == null) {
			return null;
		}

		moveToTail(key);
		return tail.val;

	}

	private void moveToTail(K key) {
		KVNode<K, V> prev = keyToPrev.get(key);

		KVNode<K, V> cur = prev.next;
		if (cur != tail) {
			prev.next = cur.next;
			tail.next = cur;
			keyToPrev.put(cur.key, tail);
			tail = cur;
			tail.next = null;
		}

	}

	private boolean exists(K key) {
		return keyToPrev.containsKey(key);
	}

	public void set(K key, V val) {

		// if (key == null || val == null)
		// return;
		if (exists(key)) {
			moveToTail(key);
			tail.val = val;
		} else {
			KVNode<K, V> node = new KVNode<K, V>(key, val);
			size++;
			tail.next = node;
			keyToPrev.put(key, tail);
			tail = node;

			if (size > capacity) {
				KVNode<K, V> first = head.next;
				head.next = first.next;
				keyToPrev.remove(first.key);
				size--;
			}

		}
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		return "LRUCache134 [capacity=" + capacity + ", size=" + size + ", [Key:val]=" + toStr(head) + "]";
	}

	private String toStr(KVNode<K, V> head) {
		KVNode<K, V> first = head.next;
		StringBuilder sb = new StringBuilder();

		while (first != null) {
			sb.append(first.key).append(":").append(first.val).append(", ");
			first = first.next;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		LRUCache134<Integer, String> cache = new LRUCache134<>(2);
		System.out.println(cache);
		cache.set(1, "hi");
		System.out.println(cache);
		System.out.println(cache.get(1));
		cache.set(1, "sed");
		System.out.println(cache);
		cache.set(null, null);
		System.out.println(cache);
		cache.set(1, "no");
		System.out.println(cache);
		cache.set(2, "22");
		System.out.println(cache);

		System.out.println(cache.get(3));
	}

}
