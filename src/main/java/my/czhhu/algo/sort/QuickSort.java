package my.czhhu.algo.sort;

public class QuickSort extends AbstractSort
{

    public QuickSort(int[] sa)
    {
        super(sa);

    }

    @Override
    public void sort()
    {
        if (a.length <= 1)
            return;
        quickSort(a, 0, a.length - 1);

    }

    private void quickSort(int[] a1, int i, int j)
    {

        if (i >= j)
            return;
        int t = a1[i];
        int s = i, e = j;
        while (s < e)
        {

            while (s < e && a1[e] >= t)
                e--;
            if (s < e)
            {
                a[s] = a[e];
                s++;
            }
            while (s < e && a1[s] <= t)
                s++;
            if (s < e)
            {
                a[e] = a[s];
                e--;
            }
        }
        a[s] = t;
        quickSort(a, i, s - 1);
        quickSort(a, s + 1, j);
    }

    public static void main(String[] args)
    {
        int a[] = { 25, 1, 3, 7, 2, 9 };
        // int a[] = { 2, 1 };
        AbstractSort sort = new QuickSort(a);
        System.out.println(sort);
        sort.sort();
        System.out.println(sort);

    }

}
