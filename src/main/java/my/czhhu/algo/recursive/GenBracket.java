package my.czhhu.algo.recursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenBracket {

	static List<String> gen(int npair) {
		if (npair <= 0)
			return Collections.emptyList();

		List<String> result = new ArrayList<>();
		gen(npair, "", 0, 0, result);
		return result;

	}

	private static void gen(int npair, String s, int nl, int nr, List<String> result) {
		if (nl + nr == npair * 2) {
			result.add(s);
			return;
		}

		if (nl >= nr && nl < npair) {
			gen(npair, s + "(", nl + 1, nr, result);
		}
		if (nl > nr && nl <= npair) {
			gen(npair, s + ")", nl, nr + 1, result);
		}
		return;
	}

	public static void main(String[] args) {
		List<String> genList = gen(4);
		System.out.println(genList);

	}

}
