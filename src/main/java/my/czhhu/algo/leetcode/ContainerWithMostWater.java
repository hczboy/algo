package my.czhhu.algo.leetcode;
/*
 *Given n non-negative integers a1, a2, ..., an, where each represents a point at
coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is
at (i, ai) and (i, 0).
Find two lines, which together with x-axis forms a container, such that the
container contains the most water.
Note: You may not slant the container 
 * */

public class ContainerWithMostWater
{

    public static int maxArea(int a[])
    {
        if (a == null || a.length < 2)
            return 0;
        int i = 0, j = a.length - 1;
        int max = 0;
        while (i < j)
        {
            max = Math.max(max, Math.min(a[i], a[j]) * (j - i));
            if (a[i] <= a[j])
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return max;
    }

    static int dpMaxArea(int[] a, int l)
    {
        if (l == 1)
        {
            return Math.min(a[1], a[0]) * (1 - 0);
        }
        int max = 0;
        for (int i = 0; i < l - 1; i++)
        {
            max = Math.max(max, Math.min(a[l], a[i]) * (l - i));
        }
        return Math.max(max, dpMaxArea(a, l - 1));
    }

    public static void main(String[] args)
    {
        int a[] = { 1, 3, 7, 5, 12 };
        System.out.println(maxArea(a));
        System.out.println(dpMaxArea(a, a.length - 1));

    }

}
