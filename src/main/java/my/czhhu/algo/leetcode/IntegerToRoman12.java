package my.czhhu.algo.leetcode;

public class IntegerToRoman12 {

	private static final String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	private static final int[] v = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

	static String intToRoman(int n) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; n != 0; i++) {
			while (n >= v[i]) {
				n -= v[i];
				sb.append(roman[i]);

			}
		}

		return sb.toString();

	}

	public static void main(String[] args) {
		System.out.println(intToRoman(45)); // XLV
	}

}
