package my.czhhu.algo.dp;

import java.util.Deque;
import java.util.LinkedList;

/*
 * 
 * LIS: longest increasing subsequence
 *  LIS of {1 9 10 5 11 2 13} is {1 9 10 11 13}
 * */
public class LIS
{
    public static int findLenOfLIS(int a[])
    {
        int d[] = new int[a.length];
        //index[] and lastIndex is used to construct LIS path
        int index[] = new int[a.length];
        int lastIndex = 0;
        for (int i = 0; i < a.length; i++)
        {
            d[i] = 1;
            index[i] = i;
        }
        int len = 1;

        for (int j = 1; j < a.length; j++)
        {
            for (int i = 0; i < j; i++)
            {
                if (a[i] <= a[j] && d[i] + 1 > d[j])
                {
                    d[j] = d[i] + 1;
                    index[j] = i;
                }
            }

            if (d[j] > len)
            {
                len = d[j];
                lastIndex = j;
            }
        }
        printLISPath(a, index, lastIndex);
        return len;
    }

    private static void printLISPath(int[] a, int[] index, int lastIndex)
    {
        Deque<Integer> dq = new LinkedList<>();
        int j = lastIndex;
        while (j != index[j])
        {
            dq.push(j);
            j = index[j];
        }
        dq.push(j);
        System.out.println("print LIS=============");
        while (!dq.isEmpty())
        {
            System.out.print(a[dq.pop()] + " ");
        }
        System.out.println("===========");
    }

    public static void main(String[] args)
    {
        // int a[] = { 5, 3, 4, 8, 6, 7 };
        //int a[] = { 1, 9, 10, 5, 11, 2, 13 };
        int a[] = { 11, 9, 10, 10, 11, 2, 13 };
        System.out.println(findLenOfLIS(a));

    }

}
