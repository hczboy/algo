package my.czhhu.algo.sort.array;

/*
 * there is a array, the abs of neighbors is 1, like {4,5,6,5,6,7,8,9,10,9}
 * try to find the specified number n without iteration.
 * 
 * **/

public class FindNumWithoutIteration
{
    public static int find(int a[], int n)
    {
        int i = 0;
        int j = 0;
        while (i < a.length && (j = Math.abs(n - a[i])) >= 1)
        {
            i = i + j;
        }
        if (i >= a.length)
            return -1;
        if (n == a[i])
            return i;
        return -1;

    }

    public static void main(String[] args)
    {
        int a[] = { 4, 5, 6, 5, 6, 7, 8, 9, 10, 11 };
        //int a[] = { 1, 2, 3, 4, 5, 6 };
        System.out.println(find(a, 6));
    }

}
