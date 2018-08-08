package my.czhhu.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
	private static final Map<String, Integer> rToInt = new HashMap<>();

	static {

		rToInt.put("M", 1000);
		rToInt.put("CM", 900);
		rToInt.put("D", 500);
		rToInt.put("CD", 400);
		rToInt.put("C", 100);
		rToInt.put("XC", 90);
		rToInt.put("L", 50);
		rToInt.put("XL", 40);
		rToInt.put("X", 10);
		rToInt.put("IX", 9);
		rToInt.put("V", 5);
		rToInt.put("IV", 4);
		rToInt.put("I", 1);
	}

	static int romanToInt(String s) {
		if (s == null) {
			return -1;
		}
		int res = 0;
		int i = 0;

		while (i <= s.length() - 2) {
			String key = s.substring(i, i + 2);
			if (rToInt.get(key) != null) {
				res += rToInt.get(key);
				i = i + 2;
			} else {
				key = s.substring(i, i + 1);
				res += rToInt.get(key);

				i = i + 1;
			}

		}
		if (i == s.length() - 1) {
			res += rToInt.get(s.substring(i, i + 1));
		}
		return res;
	}

	public static void main(String[] args) {
		// System.out.println(romanToInt("XLV"));
		System.out.println(romanToInt("MCMLXXX"));

	}

}
