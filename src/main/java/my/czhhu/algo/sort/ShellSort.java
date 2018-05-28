package my.czhhu.algo.sort;

public class ShellSort extends AbstractSort {

	public ShellSort(int[] sa) {
		super(sa);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		if (a.length <= 1)
			return;
		int step = 1;
		while (step * 3 < a.length)
			step *= 3;
		while (step >= 1) {
			for (int i = 0; i < step; i++) {
				if (i + step >= a.length)
					break;
				for (int j = i + step; j < a.length; j += step) {
					int t = a[j];
					while (j - step >= 0 && a[j - step] > t) {
						a[j] = a[j - step];
						j -= step;
					}
					a[j] = t;
				}
			}
			step = step / 3;
		}
	}

	public static void main(String[] args) {
		// int a[] = { 25, 1, 3, 7, 2, 5, 12, 5, 8, 6, 10, 4, 9, 13 };
		int a[] = { 1, 3, 2 };
		AbstractSort sort = new ShellSort(a);
		System.out.println(sort);
		sort.sort();
		System.out.println(sort);

	}

}
