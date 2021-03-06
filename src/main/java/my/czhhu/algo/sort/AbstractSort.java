package my.czhhu.algo.sort;

import java.util.Arrays;

public abstract class AbstractSort {
	protected int a[];

	public AbstractSort(int[] sa) {
		this.a = sa;
	}

	public abstract void sort();

	@Override
	public String toString() {
		return "[a=" + Arrays.toString(a) + "]";
	}

    protected void swap(int[] a, int i, int j)
    {
    	int t = a[i];
    	a[i] = a[j];
    	a[j] = t;
    
    }

}
