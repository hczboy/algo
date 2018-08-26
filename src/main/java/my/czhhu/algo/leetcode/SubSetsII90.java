package my.czhhu.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Given a collection of integers that might contain duplicates, nums, return all
possible subsets.
Note: The solution set must not contain duplicate subsets.
For example, If nums = [1,2,2], a solution is:
[ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * 
 * */
public class SubSetsII90 {

	static List<List<Integer>> subSets(int[] n) {
		if (n == null || n.length == 0)
			return Collections.EMPTY_LIST;

		Arrays.sort(n);
		List<List<Integer>> res = new ArrayList<>();

		return subSets(n, n.length - 1);
	}

	private static List<List<Integer>> subSets(int[] n, int i) {
		if (i == -1) {
			List<List<Integer>> res = new ArrayList<>();
			res.add(Collections.EMPTY_LIST);
			return res;
		}

		List<List<Integer>> res = new ArrayList<>();
		List<List<Integer>> subRes = subSets(n, i - 1);
		res.addAll(subRes);
		for (int j = 0; j < subRes.size(); j++) {
			ArrayList<Integer> r = new ArrayList<>(subRes.get(j));
			if (i >= 1 && n[i] == n[i - 1] && j < subRes.size() - 2) { // if has dup element, only subRes[size-1] and
																		// subRes[size-2] should be added
				continue;
			}

			r.add(n[i]);
			res.add(r);

		}

		return res;
	}

	static List<List<Integer>> subSetA(int[] n) {
		if (n == null || n.length == 0)
			return Collections.EMPTY_LIST;

		Arrays.sort(n);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> r = new ArrayList<>();

		subSetA(n, 0, res, r);

		return res;
	}

	private static void subSetA(int[] n, int start, List<List<Integer>> res, List<Integer> r) {
		res.add(new ArrayList<>(r));
		for (int i = start; i < n.length; i++) {
			if (i != start && n[i] == n[i - 1]) {
				continue;
			}

			r.add(n[i]);
			subSetA(n, i + 1, res, r);
			r.remove(r.size() - 1);

		}

	}

	public static void main(String[] args) {
		int n[] = { 1, 2, 2 };
		// int n[] = { 2, 2 };
		// System.out.println(subSets(n));
		System.out.println(subSetA(n));

	}

}
