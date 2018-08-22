package my.czhhu.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification68 {

	static List<String> textJ(String[] sa, int len) {
		if (sa == null || sa.length == 0)
			return null;

		int start = 0, end = 0;
		int sumOfChar = 0;

		List<String> res = new ArrayList<>();
		while (end < sa.length) {
			sumOfChar += sa[end].length();
			if (sumOfChar > len) {

				sumOfChar -= sa[end].length();
				end--;
				res.add(handle(sa, start, end, sumOfChar, len, false));
				start = end + 1;
				end = start;
				sumOfChar = 0;
			} else if (sumOfChar == len) {
				boolean isLastLine = end == sa.length - 1 ? true : false;
				res.add(handle(sa, start, end, sumOfChar, len, isLastLine));
				start = end + 1;
				end = start;
				sumOfChar = 0;
			} else {
				if (end == sa.length - 1) {
					res.add(handle(sa, start, end, sumOfChar, len, true));
					return res;
				} else {
					end++;
				}
			}

		}

		return res;

	}

	private static String handle(String[] sa, int start, int end, int sumOfChar, int len, boolean isLastLine) {
		int numOfWord = end - start + 1;
		int spaceNb = len - sumOfChar;
		StringBuilder sb = new StringBuilder();
		if (spaceNb == 0 || isLastLine) {
			for (int i = start; i <= end; i++) {
				sb.append(sa[i]);

			}
		} else if (!isLastLine) {
			int eachSpace = numOfWord > 1 ? spaceNb / (numOfWord - 1) : spaceNb;
			int extraSpace = spaceNb % (numOfWord - 1);
			for (int i = start; i <= end; i++) {
				sb.append(sa[i]);
				if (start == end || start != end && i != end) {
					sb.append(padSpace(eachSpace));
					if (i == start && extraSpace != 0) {
						sb.append(padSpace(extraSpace));
					}
				}

			}

		}
		return sb.toString();
	}

	private static String padSpace(int eachSpace) {
		StringBuilder sb = new StringBuilder();
		while (eachSpace > 0) {
			sb.append(" ");
			eachSpace--;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] words = { "this", "is", "an", "example", "of", "text", "justification." };

		System.out.println(textJ(words, 16));

	}

}
