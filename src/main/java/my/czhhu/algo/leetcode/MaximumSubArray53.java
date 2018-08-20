package my.czhhu.algo.leetcode;

/*
 * 
 * Find the contiguous subarray within an array (containing at least one number)
which has the largest sum.
For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * */
public class MaximumSubArray53
{
    static int maxSubSum(int a[])
    {
        if (a == null || a.length == 0)
        {
            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < a.length; i++)
        {
            sum += a[i];
            if (sum > max)
            {
                max = sum;
            }
            if (sum < 0) //if sum<0, discard all visited element
            {
                sum = 0;
            }

        }
        return max;
    }

    static int maxSubSumDP(int a[])
    {
        if (a == null || a.length == 0)
        {
            return Integer.MIN_VALUE;
        }
        int d[] = new int[a.length];
        d[0] = a[0];
        for (int i = 1; i < a.length; i++)
        {

        }

    }

    public static void main(String[] args)
    {
        // int a[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        int a[] = { -1, 2, 4, -3, 2 };
        System.out.println(maxSubSum(a));
    }

}
