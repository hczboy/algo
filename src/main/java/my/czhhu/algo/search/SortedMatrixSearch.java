package my.czhhu.algo.search;

/*
 * Sorted Matrix Search: Given an M x N matrix in which each row and each column is sorted in
ascending order, write a method to find an element.
 * 
 * */

public class SortedMatrixSearch {
	static class Coordinate {
		public int r;
		public int c;

		public boolean isBefore(Coordinate coord) {
			return r <= coord.r && c <= coord.c;
		}

		public void setAverage(Coordinate orig, Coordinate dest) {
			r = (orig.r + dest.r) / 2;
			c = (orig.c + dest.c) / 2;
		}

		public Coordinate(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public Coordinate clone() {
			return new Coordinate(r, c);

		}

		public boolean inBound(int[][] m) {
			return r >= 0 && r < m.length && c >= 0 && c < m[0].length;

		}

		@Override
		public String toString() {
			return "Coordinate [r=" + r + ", c=" + c + "]";
		}

	}

	static Coordinate findE(int[][] m, int target) {
		if (m == null || m.length == 0 || m[0].length == 0)
			return null;

		if (target < m[0][0] || target > m[m.length - 1][m[0].length - 1]) {
			return null;
		}
		Coordinate orig = new Coordinate(0, 0);
		Coordinate dest = new Coordinate(m.length - 1, m[0].length - 1);

		return findE(m, orig, dest, target);

	}

	private static Coordinate findE(int[][] m, Coordinate orig, Coordinate dest, int target) {
		if (!orig.inBound(m) || !dest.inBound(m))
			return null;

		if (m[orig.r][orig.c] == target) {
			return orig;
		}

		if (!orig.isBefore(dest)) {
			return null;
		}

		int diff = Math.min(dest.r - orig.r, dest.c - orig.c);

		Coordinate o = orig.clone();
		Coordinate d = new Coordinate(orig.r + diff, orig.c + diff);

		Coordinate p = new Coordinate(0, 0);

		while (o.isBefore(d)) {
			p.setAverage(o, d);
			if (m[p.r][p.c] == target)
				return p;
			else if (target > m[p.r][p.c]) {
				o.r = p.r + 1;
				o.c = p.c + 1;
			} else {
				d.r = p.r - 1;
				d.c = p.c - 1;
			}

		}

		return paritionSearch(m, orig, dest, o, target);

	}

	private static Coordinate paritionSearch(int[][] m, Coordinate orig, Coordinate dest, Coordinate pivot,
			int target) {
		Coordinate res = findE(m, new Coordinate(pivot.r, orig.c), new Coordinate(dest.r, pivot.c - 1), target);

		return res != null ? res
				: findE(m, new Coordinate(orig.r, pivot.c), new Coordinate(pivot.r - 1, dest.c), target);

	}

	public static void main(String[] args) {
		int[][] m = { { 15, 20, 40, 95 }, { 20, 35, 80, 95 }, { 30, 55, 96, 105 }

		};

		System.out.println(findE(m, 95));
	}

}
