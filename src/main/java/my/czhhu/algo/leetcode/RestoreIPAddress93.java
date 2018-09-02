package my.czhhu.algo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestoreIPAddress93 {

	static List<String> restore(String s) {
		if (s == null || s.length() == 0) {
			return Collections.EMPTY_LIST;

		}
		if (s.length() < 4 || s.length() > 12) {
			return Collections.EMPTY_LIST;
		}
		List<String> res = new ArrayList<>();
		List<String> rs = new ArrayList<String>();

		r(s, 0, rs, res);

		return res;
	}

	private static void r(String s, int i, List<String> rs, List<String> res) {
		if (i == s.length()) {
			if (rs.size() == 4) {
				StringBuilder sb = new StringBuilder();
				for (int b = 0; b < rs.size(); b++) {
					sb.append(rs.get(b));
					if (b != rs.size() - 1) {
						sb.append(".");
					}

				}
				res.add(sb.toString());

			}
			return;
		}

		for (int j = i + 1; j <= s.length() && j <= i + 3; j++) {
			String p = s.substring(i, j);
			if (p.length() == 3) {
				int pi = Integer.valueOf(p); // if one part is >255, continue
				if (pi > 255) {
					continue;
				}
			}
			if (p.length() == 2 || p.length() == 3) {
				if (p.startsWith("0")) { // if meet 0x or 0xx, contiune
					continue;
				}
			}
			rs.add(p);
			r(s, j, rs, res);
			rs.remove(rs.size() - 1);
		}

	}

	public static void main(String[] args) {
		// String s = "25525511135";
		String s = "10011";

		System.out.println(restore(s));

	}

}
