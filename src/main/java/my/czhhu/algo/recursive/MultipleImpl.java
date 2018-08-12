package my.czhhu.algo.recursive;

/*
 * impl multiple without * and /, only +, - >> allowed
 * 
 * */

public class MultipleImpl
{

    static int multiple(int a, int b)
    {
        int smaller = a < b ? a : b;
        int bigger = b > a ? b : a;

        return minProduct(smaller, bigger);

    }

    private static int minProduct(int smaller, int bigger)
    {
        if (smaller == 0)
            return 0;
        if (smaller == 1)
            return bigger;

        int halfSmaller = smaller >> 1;

        int half = minProduct(halfSmaller, bigger);

        if (smaller % 2 == 0)
        {
            return half + half;
        }
        return half + half + bigger;

    }

    public static void main(String[] args)
    {
        System.out.println(multiple(8, 7));

    }

}
