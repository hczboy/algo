package my.czhhu.algo.sort.array;

/*
 * Given a[n], calc b[n], b[i]= a[0]*a[1]*...*a[n-1]/a[i],
 * No division allowed.
 * space complexity is O(1), time complexity is O(n)
 * */

public class CalcWithoutDivide
{

    public static int[] calc(int[] a)
    {
        int b[] = new int[a.length];

        for (int i = 0; i < a.length; i++)
        {
            b[i] = 1;
        }
        for (int i = 1; i < a.length; i++)
        {
            b[i] = b[i - 1] * a[i - 1];
        }
        for (int i = a.length - 1; i >= 1; i--)
        {

            b[i] *= b[0];
            b[0] *= a[i];
        }
        return b;
    }

    public static void main(String[] args)
    {
        int a[] = new int[] { 1, 2, 4, 8, 16 };
        int b[] = calc(a);

        for (int i = 0; i < b.length; i++)
        {
            System.out.println(b[i]);
        }
    }

}
