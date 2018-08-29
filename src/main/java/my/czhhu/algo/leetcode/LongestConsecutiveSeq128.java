package my.czhhu.algo.leetcode;

import java.util.HashSet;

/*
 * given an unsorted array, return the longest ConsecutiveSeq
 * 
 * o(n)
 * 
 * */
public class LongestConsecutiveSeq128 {

	static int solution(int a[]) {
		if (a == null || a.length == 0)
			return 0;

		HashSet<Integer> set = new HashSet<>();
		for (int i : a) {
			set.add(i);
		}
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			int val = a[i];
			if (set.contains(val)) {
				set.remove(val);
				int low = val - 1;
				while (set.contains(low)) {

					set.remove(low);
					low--;
				}
				int up = val + 1;
				while (set.contains(up)) {
					set.remove(up);
					up++;

				}

				res = Math.max(res, up - low - 1);
			}

		}
		return res;

	}

	public static void main(String[] args) {
		int a[] = { 100, 4, 20, 2, 3, 1 };
		System.out.println(solution(a));
	}

}
