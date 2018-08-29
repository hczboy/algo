package my.czhhu.algo.leetcode;

public class MaximumProductSubArray152 {

	static int maxP(int a[]) {
		if (a == null || a.length == 0) {
			return 0;

		}

		int ans = Integer.MIN_VALUE;
		int max = a[0];
		int min = a[0];

		for (int i = 1; i < a.length; i++) {
			max = a[i] * max;
			min = a[i] * min;

			max = Math.max(Math.max(max, min), a[i]);
			min = Math.min(Math.min(max, min), a[i]);

			ans = Math.max(max, ans);

		}
		return ans;

	}

	public static void main(String[] args) {
		int a[] = { 2, 3, -2, 4 };
		int b[] = { -1, -2, -3 };
		System.out.println(maxP(a));

		System.out.println(maxP(b));
	}

}
