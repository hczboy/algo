package my.czhhu.algo.leetcode;

/*
 * Given two words word1 and word2, find the minimum number of steps required to
convert word1 to word2. (each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
a) Insert a character
b) Delete a character
c) Replace a character
 * 
 * */
public class EditDistance72 {

	static int editDistance(String w1, String w2) {
		if (w1 == null && w2 == null)
			return 0;

		if (w1 == null || w2 == null) {
			return w1 == null ? w2.length() : w1.length();
		}

		int w1l = w1.length();
		int w2l = w2.length();
		if (w1l == 0 || w2l == 0) {
			return w1l == 0 ? w2l : w1l;
		}

		int d[][] = new int[w1l + 1][w2l + 1];

		// init if w1 is "", then all characters in w2 should be inserted
		for (int j = 0; j <= w2l; j++) {
			d[0][j] = j;

		}

		for (int j = 0; j <= w1l; j++) {
			d[j][0] = j;

		}

		for (int i = 1; i <= w1l; i++) {
			for (int j = 1; j <= w2l; j++) {

				if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
					d[i][j] = d[i - 1][j - 1];

				} else {
					d[i][j] = Math.min(d[i][j - 1], Math.min(d[i - 1][j], d[i - 1][j - 1])) + 1;
				}
			}

		}

		return d[w1l][w2l];

	}

	public static void main(String[] args) {

		String w1 = "cxii", w2 = "ixci";
		System.out.println(editDistance(w1, w2));

	}

}
