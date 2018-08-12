package my.czhhu.algo.classic;

import java.util.Arrays;

public class MyHeap {

	private int size = 0;

	private int capacity = 100;

	private int[] elem;

	public MyHeap() {
		super();
		this.capacity = 20;

		elem = new int[capacity];
	}

	public MyHeap(int[] elem) {
		super();
		this.elem = elem;

		capacity = elem.length;
		size = elem.length;
	}

	public void put(int e) {
		if (size == capacity) {
			throw new IllegalStateException("full");
		}

		elem[size++] = e;

		goUp(size - 1);

	}

	private void goUp(int i) {
		while (i >= 0) {

			int p = (i - 1) / 2;
			if (p >= 0 && elem[i] > elem[p]) {
				swap(elem, i, p);
				i = p;
			} else {
				return;
			}

		}

	}

	public int pop() {
		if (size > 0) {
			int r = elem[0];
			swap(elem, 0, size - 1);
			size--;
			goDown(0, size);

			return r;
		}
		throw new IllegalStateException("empty");

	}

	public static MyHeap create(int a[]) {

		MyHeap myHeap = new MyHeap(a);
		myHeap.init();
		return myHeap;

	}

	private void init() {
		for (int i = size / 2 - 1; i >= 0; i--) {
			goDown(i, size);
		}

	}

	public void sort() {
		int len = size;
		while (len > 1) {
			swap(elem, 0, --len);
			goDown(0, len);

		}

	}

	private void goDown(int i, int len) {
		while (i < len) {
			int left = 2 * i + 1;
			int right = 2 * i + 2;

			int index = i;

			if (left < len && elem[left] > elem[index]) {
				index = left;
			}

			if (right < len && elem[right] > elem[index]) {
				index = right;
			}

			if (index == i)
				return;

			if (elem[i] < elem[index]) {
				swap(elem, i, index);
				i = index;
			} else {
				return;
			}

		}

	}

	@Override
	public String toString() {
		return "MyHeap [elem=" + Arrays.toString(elem) + "]";
	}

	private void swap(int[] a, int i, int index) {
		int tmp = a[i];
		a[i] = a[index];
		a[index] = tmp;

	}

	public static void main(String[] args) {
		int a[] = { 11, 25, 3, 7, 2, 9 };

		MyHeap h = MyHeap.create(a);
		System.out.println(h);
		h.sort();
		System.out.println(h);

	}

}
