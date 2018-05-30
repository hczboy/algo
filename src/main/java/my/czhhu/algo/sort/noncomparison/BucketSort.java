package my.czhhu.algo.sort.noncomparison;

import my.czhhu.algo.sort.AbstractSort;

public class BucketSort extends AbstractSort
{
    /*
     * suppose the values of the array fall into [0, 49] 
     * have 5 buckets [0, 9], [10, 19], [20, 29], [30, 39], [40, 49]
     * and then do sort within buckets
     * */
    private static final int BUCKETS = 5;
    private int[] count = new int[BUCKETS];

    public BucketSort(int[] sa)
    {
        super(sa);

    }

    private int getBucket(int x)
    {
        return x / 10;
    }

    @Override
    public void sort()
    {
        putIntoBuckets();
        int left, right;
        for (int j = 0; j < BUCKETS; j++)
        {
            left = count[j];
            right = (j == BUCKETS - 1 ? a.length - 1 : count[j + 1] - 1);
            sortWithinBucket(a, left, right);
        }

    }

    private void sortWithinBucket(int[] a, int left, int right)
    {
        if (left < right)
        {
            int t;
            for (int j = left + 1; j <= right; j++)
            {
                t = a[j];
                while (j > left && a[j - 1] > t)
                {
                    a[j] = a[j - 1];
                    j--;
                }
                a[j] = t;
            }
        }
    }

    private void putIntoBuckets()
    {
        for (int i = 0; i < a.length; i++)
        {
            count[getBucket(a[i])]++;
        }
        for (int j = 1; j < BUCKETS; j++)
        {
            count[j] = count[j - 1] + count[j];
        }
        int b[] = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--)
        {
            b[--count[getBucket(a[i])]] = a[i];
        }
        for (int i = 0; i < a.length; i++)
        {
            a[i] = b[i];
        }
    }

    public static void main(String[] args)
    {
        int a[] = { 29, 25, 3, 49, 9, 37, 21, 43 };
        AbstractSort sort = new BucketSort(a);
        System.out.println(sort);
        sort.sort();
        System.out.println(sort);

    }

}
