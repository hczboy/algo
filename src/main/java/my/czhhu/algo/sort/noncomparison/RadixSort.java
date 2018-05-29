package my.czhhu.algo.sort.noncomparison;

public class RadixSort extends my.czhhu.algo.sort.AbstractSort
{
    private static final int MAX_DIGITS = 3;

    private static final int RADIX = 10;

    private int count[] = new int[RADIX];

    public RadixSort(int[] sa)
    {
        super(sa);

    }

    public static int getDigit(int n, int d)
    {
        int r = 0;
        while (d >= 1)
        {
            r = n % RADIX;
            n /= RADIX;
            d--;
        }
        return r;
    }

    public static void main(String[] args)
    {
        int a[] = { 20, 90, 64, 289, 998, 365, 852, 123, 789, 456 };
        RadixSort radixSort = new RadixSort(a);
        System.out.println(radixSort);
        radixSort.sort();
        System.out.println(radixSort);
    }

    @Override
    public void sort()
    {
        if (a.length <= 1)
            return;
        for (int d = 1; d <= MAX_DIGITS; d++)
        {
            for (int r = 0; r < RADIX; r++)
            {
                count[r] = 0;
            }
            for (int i = 0; i < a.length; i++)
            {
                count[getDigit(a[i], d)] += 1;
            }
            for (int r = 1; r < RADIX; r++)
            {
                count[r] = count[r - 1] + count[r];
            }
            int b[] = new int[a.length];
            for (int i = a.length - 1; i >= 0; i--)
            {
                b[--count[getDigit(a[i], d)]] = a[i];

            }
            int i = 0;
            while (i < a.length)
            {
                a[i] = b[i];
                i++;
            }
        }

    }

}
