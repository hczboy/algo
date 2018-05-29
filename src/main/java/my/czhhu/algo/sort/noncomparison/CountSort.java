package my.czhhu.algo.sort.noncomparison;
/*
 * Non-comparison sort

*/

import my.czhhu.algo.sort.AbstractSort;

/*
 * 1. count frequency of each value of a[] and save it into count[]
 * 2. from start of count[] to end, do  count[j] = count[j - 1] + count[j]; to calculate the frequency of value count[j] no more than j 
 * 3. padded b[] in reverse, place value of a[i] at b[count[a[i]]-1] and count[a[i]]-- 
 * */
public class CountSort extends AbstractSort
{

    public CountSort(int[] sa)
    {
        super(sa);

    }

    //the value of item is no more than 20
    private static final int V_MAX = 20;
    private int count[] = new int[V_MAX];

    @Override
    public void sort()
    {
        if (a.length <= 1)
            return;
        for (int i = 0; i < a.length; i++)
        {
            count[a[i]] += 1;
        }
        for (int j = 1; j < V_MAX; j++)
        {
            count[j] = count[j - 1] + count[j];
        }
        int b[] = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) //padded b[] in reverse, make sure it's stable sort
        {
            b[count[a[i]] - 1] = a[i];
            count[a[i]]--;
        }
        for (int i = 0; i < a.length; i++)
        {
            a[i] = b[i];
        }
    }

    public static void main(String[] args)
    {
        //int sa[] = { 6, 5, 3, 1, 8, 7, 9, 2, 4 };
        int sa[] = { 6, 5, 3, 1, 8, 7, 9, 2, 5 };
        CountSort sort = new CountSort(sa);
        System.out.println(sort);
        sort.sort();

        System.out.println(sort);

    }

}
