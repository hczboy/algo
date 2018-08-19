package my.czhhu.algo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a collection of numbers that might contain duplicates, return all possible
unique permutations.
For example, [1,1,2] have the following unique permutations:
[
[1,1,2],
[1,2,1],
[2,1,1]
]
 * */
public class PermutationII47 {

	static List<String> permu(String s) {
		if (s == null || s.length() == 0)
			return Collections.EMPTY_LIST;

		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c).intValue() + 1);
			} else {
				map.put(c, Integer.valueOf(1));
			}

		}
		List<String> res = new ArrayList<>();

		permu(map, "", 0, res, s.length());
		return res;
	}

	private static void permu(Map<Character, Integer> map, String prefix, int start, List<String> res, int len) {
		if (start == len) {
			res.add(prefix);
			return;
		}

		for (Character c : map.keySet()) {
			if (map.get(c) > 0) {

				map.put(c, map.get(c).intValue() - 1);
				permu(map, prefix + c, start + 1, res, len);

				map.put(c, map.get(c).intValue() + 1);
			}
		}

	}

	public static void main(String[] args) {
		String s = "112";

		System.out.println(permu(s));
	}

}
