package my.czhhu.algo.leetcode;

import java.util.LinkedList;
import java.util.List;

//given a String "abc", output all premutations for this String 
public class Permutations46 {

	static List<String> permutations(String s) {
		List<String> res = new LinkedList<>();
		if (s == null || s.length() == 0) {
			return res;
		}

		char[] ca = s.toCharArray();
		permutation(ca, 0, res);
		return res;

	}

	private static void permutation(char[] ca, int i, List<String> res) {
		// TODO Auto-generated method stub
		if (i == ca.length - 1) {
			res.add(new String(ca));
			return;
		}

		for (int j = i; j < ca.length; j++) {
			swap(ca, i, j);
			permutation(ca, i + 1, res);
			swap(ca, j, i);
		}
	}

	private static void swap(char[] ca, int i, int j) {
		if (i == j)
			return;
		char t = ca[i];
		ca[i] = ca[j];
		ca[j] = t;

	}

	public static void main(String[] args) {
		String s = "abc";
		List<String> res = permutations(s);
		System.out.println(res);

	}

}
