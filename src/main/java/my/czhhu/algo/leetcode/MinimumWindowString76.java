package my.czhhu.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * o(n)
 * */
public class MinimumWindowString76 {

	static String minS(String s, String t) {
		if (s == null || t == null)
			return null;
		if (t.length() == 0 || s.length() == 0)
			return "";

		Map<Character, Integer> target = new HashMap<>();

		for (char c : t.toCharArray()) {
			int count = 1;
			if (target.containsKey(c)) {
				count = target.get(c) + 1;
			}
			target.put(c, count);
		}

		int maxWinStart = -1;
		int minWinLen = Integer.MAX_VALUE;

		Map<Character, Integer> found = new HashMap<>();

		int start = 0;
		int foundNumber = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!target.containsKey(c))
				continue;

			int k = 1;
			if (found.containsKey(c)) {
				k = found.get(c) + 1;
			}
			found.put(c, k);
			if (foundNumber < t.length()) {
				foundNumber++;
			}

			if (foundNumber == t.length()) {
				char begin = s.charAt(start);
				while (!found.containsKey(begin) || found.get(begin) > target.get(begin)) {
					if (found.containsKey(begin)) {
						found.put(begin, found.get(begin) - 1);
					}
					start++;
					begin = s.charAt(start);
				}

				int len = i - start + 1;

				if (len < minWinLen) {
					minWinLen = len;
					maxWinStart = start;
				}

			}

		}
		if (minWinLen != Integer.MAX_VALUE) {
			return s.substring(maxWinStart, maxWinStart + minWinLen);
		}

		return "";

	}

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";

		System.out.println(minS(s, t));

	}

}
