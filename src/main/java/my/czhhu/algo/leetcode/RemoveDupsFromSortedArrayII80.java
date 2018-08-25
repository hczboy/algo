package my.czhhu.algo.leetcode;

/*
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
For example, Given sorted array nums = [1,1,1,2,2,3],
Your function should return length = 5,
 * 
 * 
 * */
public class RemoveDupsFromSortedArrayII80
{

    static int r(int[] a)
    {
        if (a == null || a.length == 0)
            return 0;

        if (a.length <= 2)
            return a.length;

        int len = 1; //len of no dups character
        int c = 1; //count for same character

        for (int j = 1; j < a.length; j++)
        {
            if (a[j] == a[j - 1])
            {

                if (c < 2)
                {

                    len++;
                }
                c++;

            }
            else
            {
                c = 1;
                len++;
            }

        }
        return len;
    }

    static int ar(int a[])
    {
        if (a == null || a.length == 0)
            return 0;

        if (a.length <= 2)
            return a.length;

        int i = 0; //this is the index of last valid elem
        boolean allowDups = true;
        for (int j = 1; j < a.length; j++)
        {
            if (a[j] == a[i])
            {
                if (allowDups)
                {
                    a[++i] = a[j];
                    allowDups = false;

                }
            }
            else
            {
                a[++i] = a[j];
                allowDups = true;
            }

        }
        return ++i;

    }

    public static void main(String[] args)
    {
        int a[] = { 1, 1, 1, 2, 2, 2, 3, 4 };
        System.out.println(ar(a));

    }

}
