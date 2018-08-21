package my.czhhu.algo.leetcode;

public class SpiralMatrixII59 {

	static int[][] spiralM(int n) {
		if (n <= 0)
			return null;

		int res[][] = new int[n][n];
		int rs = 0, cs = 0;
		int re = n - 1, ce = n - 1;
		// int total = n * n;
		int i = 1;
		while (true) {
			for (int k = cs; k <= ce; k++) {
				res[rs][k] = i++;

			}
			if (++rs > re)
				break;

			for (int k = rs; k <= re; k++) {
				res[k][ce] = i++;
			}
			if (--ce < cs)
				break;

			for (int k = ce; k >= cs; k--) {
				res[re][k] = i++;
			}
			if (--re < rs)
				break;

			for (int k = re; k >= rs; k--) {
				res[k][cs] = i++;

			}
			if (++cs > ce)
				break;

		}
		return res;
	}

	public static void main(String[] args) {
		int[][] res = spiralM(5);

		for (int r = 0; r < res.length; r++) {
			for (int c = 0; c < res[0].length; c++) {
				System.out.print(res[r][c] + " ");

			}
			System.out.println();

		}

	}

}
