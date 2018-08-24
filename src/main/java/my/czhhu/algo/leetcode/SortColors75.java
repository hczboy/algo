package my.czhhu.algo.leetcode;

/*
 * this is can be done by count sort with two pass iteration, but 
 * it has constant space with 1-pass iteration
 * 
 * */
public class SortColors75 {

	static void sortC(int c[]) {
		if (c == null || c.length == 0)
			return;

		int p = -1; // last index of 0
		int q = c.length; // first index of 2

		int k = p + 1; // suppose always point to 1
		while (k < q) {
			switch (c[k]) {
			case 0:
				swap(c, ++p, k++);
				break;
			case 1:
				k++;
				break;
			case 2:
				swap(c, --q, k); // note there is should not k++; as k->2 and --q->[0|1], k should keep same
									// position
			}
		}

	}

	private static void swap(int[] c, int i, int j) {
		if (i == j)
			return;
		int t = c[i];
		c[i] = c[j];
		c[j] = t;

	}

	public static void main(String[] args) {
		int[] c = { 0, 1, 0, 2, 1 };
		sortC(c);
		for (int i : c) {
			System.out.print(i + " ");
		}
	}

}
