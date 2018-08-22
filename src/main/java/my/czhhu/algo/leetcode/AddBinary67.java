package my.czhhu.algo.leetcode;

public class AddBinary67 {

	static String add(String s1, String s2) {
		if (s1 == null && s2 == null)
			return null;
		if (s1 == null || s2 == null)
			return s1 == null ? s2 : s1;

		int p = s1.length() - 1;
		int q = s2.length() - 1;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while (p >= 0 || q >= 0) {
			int i1 = p >= 0 ? s1.charAt(p--) - '0' : 0;
			int i2 = q >= 0 ? s2.charAt(q--) - '0' : 0;
			int sum = (i1 + i2 + carry) % 2;
			carry = (i1 + i2 + carry) / 2;
			sb.append(sum);

		}

		if (carry != 0) {
			sb.append(carry);
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String s1 = "101";
		String s2 = "1";
		System.out.println(add(s1, s2));

		s1 = "";
		s2 = "10";
		System.out.println(add(s1, s2));

	}

}
