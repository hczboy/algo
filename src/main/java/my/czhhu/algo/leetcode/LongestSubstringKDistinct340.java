package my.czhhu.algo.leetcode;

public class LongestSubstringKDistinct340 {

	static int solution(String s, int k) {
		if (s == null || k < 1) {
			return 0;
		} // array c is a counter array to count number of each char in String s
		int[] c = new int[256];
		/*
		 * the idea here is to maintain a slide window with most left index(i) and most
		 * right index(j), the subString between i and j has no more than k distinct
		 * chars go through each char, if first meet, dis++, count++ c[char]++ if dis>k,
		 * move i to right else if NOT first meet, just j++, count++, c[char++], Key is
		 * moving the slide window
		 */
		// dis: the distinct char number
		// max: the max subString length of k distinct char
		// count: one round of length of subString
		//
		int dis = 0, max = 0, count = 0, i = 0, j = 0;
		while (j < s.length()) {
			if (c[s.charAt(j)] == 0) {
				dis++;
				if (dis > k) {
					max = Math.max(max, count);
					while (dis > k) {

						c[s.charAt(i)] -= 1;
						count--;
						if (c[s.charAt(i)] == 0) {
							dis--;
						}
						i++;

					}

				}
			}
			c[s.charAt(j)] += 1;

			count++;
			j++;

		}
		return max;
	}

	public static void main(String[] args) {
		String s = "eceba";
		// String s = "ecebaaec";
		// solution(s, 3) = 4; "eceb"

		System.out.println(solution(s, 3));

	}

}
