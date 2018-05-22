package my.czhhu.algo.sort;

public class SelectSort extends AbstractSort {

	public SelectSort(int[] sa) {
		super(sa);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int a[] = { 25, 1, 8, 11 };
		InsertSort sort = new InsertSort(a);
		System.out.println(sort);
		sort.sort();
		System.out.println(sort);

	}

	@Override
	public void sort() {
		if (a.length <= 1)
			return;
		int s, t;
		for (int i = 0; i < a.length; i++) {
			s = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[s])
					s = j;
			}
			t = a[i];
			a[i] = a[s];
			a[s] = t;
		}
	}

}
