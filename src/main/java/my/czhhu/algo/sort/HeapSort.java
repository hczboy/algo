package my.czhhu.algo.sort;

public class HeapSort extends AbstractSort {

	public HeapSort(int[] sa) {
		super(sa);

	}

	public static void main(String[] args) {
		int a[] = { 25, 1, 3, 7, 2, 9 };
		// int a[] = { 2, 1 };
		AbstractSort sort = new HeapSort(a);
		System.out.println(sort);
		sort.sort();
		System.out.println(sort);
	}

	@Override
	public void sort() {

		createHeap();
		int l = a.length;
		while (l > 1) {
			swap(a, 0, --l);
			// heapfy(a, 0, l);
			heapfyNoRur(a, 0, l);
		}

	}

	private void createHeap() {
		for (int i = a.length / 2 - 1; i > -1; i--) {
			// heapfy(a, i, a.length);
			heapfyNoRur(a, i, a.length);
		}

	}

	private void heapfy(int[] a, int i, int l) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int max = i;
		if (left < l && a[left] > a[max])
			max = left;
		if (right < l && a[right] > a[max])
			max = right;
		if (max != i) {
			swap(a, max, i);
			heapfy(a, max, l);
		}

	}

	private void heapfyNoRur(int[] a, int i, int l) {
		while (i < l) {
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			int max = i;
			if (left < l && a[left] > a[max])
				max = left;
			if (right < l && a[right] > a[max])
				max = right;
			if (max != i) {
				swap(a, max, i);
				i = max;
			} else {
				break;
			}
		}
	}
}
