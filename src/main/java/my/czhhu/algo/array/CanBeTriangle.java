package my.czhhu.algo.array;

/*
 * given a array, return true if 
 * a[i] + a[j] > a[k]
 * a[j] + a[k] > a[i]
 * a[i] + a[k] >a[j]
 * 
 * 
 * **/

public class CanBeTriangle {

	static boolean isCan(int a[]) {
		if (a == null || a.length < 3)
			return false;

		for (int i = 0; i < a.length - 2; i++) {
			if (a[i] > 0 && a[i] + a[i + 1] > a[i + 2]) {// after sorting a[i+2] always >=a[i+1] and >=a[i]
				return true;
			}
		}
		return false;

	}

	public static void main(String[] args) {
		int a[] = { 2, 2, 3, 4 };
		System.out.println(isCan(a));
	}

}
