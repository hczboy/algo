package my.czhhu.algo.array;

/**
 * Given a integer array, find the minimal non negative integer missing in this
 * array
 * 
 * [2, 5, -2, 6], return 0
 *
 */
public class FindMinimalNonNegativeInteger {

	static int find(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException();
		}
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			while (arr[i] >= 0 && arr[i] < arr.length && arr[i] != arr[arr[i]]) {
				temp = arr[arr[i]];
				arr[arr[i]] = arr[i];
				arr[i] = temp;
			}
		}
		int i = 0;
		for (; i < arr.length && i == arr[i]; i++)
			;
		return i;

	}

	public static void main(String[] args) {
		// int a[] = { 2, 5, -2, 0 };
		int a[] = { 0, 1, 2, 3, 4, 5 };
		System.out.println(find(a));

	}

}
