package my.czhhu.algo.leetcode;

import java.util.Stack;

public class LongestValidParentheses {

	static int find(String s) {
		if (s == null || s.length() < 2)
			return 0;

		Stack<Integer> stack = new Stack<>();

		int invaildIndex = -1;
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(')
				stack.push(i);
			else {
				if (!stack.isEmpty()) {
					stack.pop();
					int start = stack.isEmpty() ? invaildIndex : stack.peek();
					max = Math.max(i - start, max);

				} else {
					invaildIndex = i;
				}

			}

		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(find(")(()))()"));

	}

}
