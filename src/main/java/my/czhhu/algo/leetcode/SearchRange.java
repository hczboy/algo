package my.czhhu.algo.leetcode;

import java.util.Arrays;

/*
 * given a target value, to find the target range in orderd array, 
 * for example a[] = { 1, 2, 3, 5, 5, 5, 6, 8 }, search(a, 5) , return (3,5);
 * if not found, return (-1, -1);
 * 
 * */
public class SearchRange {

	static int[] search(int[] a, int target) {
		int[] res = { -1, -1 };
		if (a == null || a.length == 0)
			return res;

		int l = 0;
		int r = a.length - 1;
		int mid = 0;

		while (l < r) {
			mid = (l + r) / 2;
			if (a[mid] < target) {
				l = mid + 1;
			} else {
				r = mid; // find the most left index with a[index] = target
			}
		}

		if (a[l] != target)
			return res;
		res[0] = l;

		r = a.length - 1;

		while (l < r) {
			mid = (l + r) / 2;
			if (a[mid] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}

		}

		res[1] = r;

		return res;
	}

	public static void main(String[] args) {
		// int a[] = { 1, 2, 4, 5, 5, 6, 7, 8 };

		// int a[] = { 1, 2, 3, 5, 5, 5, 6, 8 };
		int a[] = { 3, 3, 3 };
		int res[] = search(a, 3);

		System.out.println(Arrays.asList(res[0], res[1]));
	}

}
