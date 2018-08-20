package my.czhhu.algo.leetcode;

public class SpiralMatrix54 {

	static int[] spiralM(int[][] a) {
		if (a == null || a.length == 0)
			return null;
		int rs = 0, cs = 0;
		int re = a.length - 1;
		int ce = a[0].length - 1;

		int res[] = new int[a.length * a[0].length];
		int j = 0;
		while (true) {
			for (int i = cs; i <= ce; i++) {
				res[j++] = a[rs][i];
			}
			if (++rs > re)
				break;

			for (int i = rs; i <= re; i++) {
				res[j++] = a[i][ce];
			}
			if (--ce < cs)
				break;
			for (int i = ce; i >= cs; i--) {
				res[j++] = a[re][i];
			}
			if (--re < rs)
				break;
			for (int i = re; i >= rs; i--) {
				res[j++] = a[i][cs];

			}
			if (++cs > ce)
				break;
		}
		return res;

	}

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 } };
		int[] res = spiralM(a);
		for (int i : res) {
			System.out.print(i + ", ");
		}

	}

}
