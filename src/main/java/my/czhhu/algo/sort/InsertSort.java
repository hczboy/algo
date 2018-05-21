package my.czhhu.algo.sort;

import java.util.Arrays;

public class InsertSort {

	private int a[];

	public InsertSort(int[] sa) {
		this.a = sa;
	}

	private void sort() {
		if (a.length == 1) {
			return;
		}
		for (int i = 1; i < a.length; i++) {
			int t = a[i];
			int j = i;
			while (j - 1 >= 0 && a[j - 1] > a[j]) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = t;
		}

	}

	@Override
	public String toString() {
		return "InsertSort [a=" + Arrays.toString(a) + "]";
	}

	public static void main(String[] args) {
		int a[] = { 25, 1, 8, 11 };
		InsertSort sort = new InsertSort(a);
		System.out.println(sort);
		sort.sort();
		System.out.println(sort);

	}

}
