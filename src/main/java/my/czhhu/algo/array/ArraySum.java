package my.czhhu.algo.array;

public class ArraySum {
	static void print(int[] a, char[] b, int total) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + String.valueOf(b[i]));
		}
		System.out.println(total);
	}

	static void arraySum(int[] a, int as, int al, int sum, char[] b, int total) {
		if (al == 1) {
			if (a[as] == sum) {
				b[as - 1] = '+';
				b[as] = '=';
				print(a, b, total);
			} else if (a[as] == -sum) {
				b[as - 1] = '-';
				b[as] = '=';
				print(a, b, total);

			} else {
				System.out.println("Not found");
			}
			return;
		}
		b[as - 1] = '+';
		arraySum(a, as + 1, al - 1, sum - a[as], b, total);
		b[as - 1] = '-';
		arraySum(a, as + 1, al - 1, sum + a[as], b, total);

	}

	static void arrayS(int[] a, int sum) {
		if (a.length == 1) {
			if (a[0] == sum) {
				System.out.println(a[0] + "=" + sum);
			} else {
				System.out.println("Not found");
			}
		} else {
			char[] b = new char[a.length];
			arraySum(a, 1, a.length - 1, sum - a[0], b, sum);
		}
	}

	public static void main(String[] args) {
		int[] a = { 2, -3, 4 };
		arrayS(a, 1);

		/*
		 * int[] a = { 3, 4, 5, 6 }; arrayS(a, 10);
		 */
	}

}
