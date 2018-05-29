package my.czhhu.algo.sort;

public class MergeSort extends AbstractSort
{

    public MergeSort(int[] sa)
    {
        super(sa);

    }

    private void merge(int[] a, int left, int mid, int right)
    {
        if (left == right)
            return;
        int len = right - left + 1;
        int[] b = new int[len];
        int bi = 0;
        int i, j = 0;
        for (i = left, j = mid + 1; i <= mid && j <= right;)
        {
            if (a[i] <= a[j])
            {
                b[bi++] = a[i++];
            }
            else
            {
                b[bi++] = a[j++];
            }
        }
        while (i <= mid)
        {
            b[bi++] = a[i++];
        }
        while (j <= right)
        {
            b[bi++] = a[j++];
        }
        for (int k = 0; k < len; k++)
        {
            a[left++] = b[k];
        }

    }

    private void mergeSortRecursive(int a[], int left, int right)
    {
        if (left == right)
            return;
        int mid = (left + right) / 2;
        mergeSortRecursive(a, left, mid);
        mergeSortRecursive(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    @Override
    public void sort()
    {
        mergeSortRecursive(a, 0, a.length - 1);
    }

    public void mergeSortIteration()
    {
        if (a.length <= 1)
            return;
        int left, mid, right;
        for (int len = 1; len < a.length; len *= 2)
        {
            left = 0;
            while (left + len < a.length)
            {
                mid = left + len - 1;
                right = mid + len < a.length ? mid + len : a.length - 1;
                merge(a, left, mid, right);
                left = right + 1;
            }
        }

    }

    public static void main(String[] args)
    {
        int sa[] = { 6, 5, 3, 1, 8, 7, 9, 2, 4 };
        MergeSort sort = new MergeSort(sa);
        System.out.println(sort);
        // sort.sort();
        sort.mergeSortIteration();
        System.out.println(sort);

    }

}
