package my.czhhu.algo.leetcode;

import java.util.LinkedList;
import java.util.List;

public class GenParentheses {

	public static List<String> gen(int n) {

		List<String> res = new LinkedList<>();
		doGen(res, "", n, n);
		return res;

	}

	private static void doGen(List<String> res, String s, int left, int right) {
		if (left == 0 && right == 0) {
			res.add(s);

		}
		if (left < 0 || right < 0 || left > right) // left >right, it means illegal case ")(" appears
			return;
		doGen(res, s + '(', left - 1, right);
		doGen(res, s + ')', left, right - 1);

	}

	public static void main(String[] args) {
		System.out.println(gen(3));

	}

}
