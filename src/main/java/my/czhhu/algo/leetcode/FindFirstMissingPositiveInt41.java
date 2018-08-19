package my.czhhu.algo.leetcode;

/*
 * 
 * given a unordered array, find the first missing positive number
 * */

public class FindFirstMissingPositiveInt41
{

    static int findFirstMissingPositive(int a[])
    {
        if (a == null || a.length == 0)
            return -1;

        for (int i = 0; i < a.length; i++)
        {
            if (a[i] != i + 1 && a[i] > 0 && a[i] <= a.length && a[a[i] - 1] != a[i])
            {
                int t = a[a[i] - 1];
                a[a[i] - 1] = a[i];
                a[i] = t;
                i--;
            }

        }

        for (int i = 0; i < a.length; i++)
        {
            if (a[i] != i + 1)
                return i + 1;

        }

        return a.length + 1;
    }

    public static void main(String[] args)
    {

        // int a[] = { 3, 4, -1, 1 };
        int a[] = { 3, 0, 1 };

        System.out.println(findFirstMissingPositive(a));
    }

}
