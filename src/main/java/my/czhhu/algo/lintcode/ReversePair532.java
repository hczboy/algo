package my.czhhu.algo.lintcode;

/*
 * for int array a if a[i] > a[j] and i<j, then a[i], a[j] is an reverse pair
 * 
 * */

public class ReversePair532 {

	static int reversePairCount(int a[]) {
		if (a == null || a.length == 1)
			return 0;

		return mergeReversePairCount(a, 0, a.length - 1);

	}

	private static int mergeReversePairCount(int[] a, int s, int e) {
		if (s == e) {
			return 0;
		}
		int mid = (s + e) / 2;
		int res = 0;
		res += mergeReversePairCount(a, s, mid);
		res += mergeReversePairCount(a, mid + 1, e);
		int p = s;
		int q = mid + 1;
		int b[] = new int[e - s + 1];
		int i = 0;
		// int rc = 0;
		while (p <= mid && q <= e) {
			if (a[p] <= a[q]) {
				b[i++] = a[p++];
			} else {
				b[i++] = a[q++];
				res += mid - p + 1;

			}
		}

		while (p <= mid) {
			b[i++] = a[p++];
		}
		while (q <= e) {
			b[i++] = a[q++];
		}
		for (i = 0, p = s; i < b.length; i++, p++) {
			a[p] = b[i];
		}
		return res;
	}

	public static void main(String[] args) {
		// int a[] = { 2, 4, 1, 3, 5 };

		int a[] = { 2, 1, 5, 7, 4, 6, 3 };
		System.out.println(reversePairCount(a));
	}

}
