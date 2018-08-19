package my.czhhu.algo.leetcode;

/*
 * Given an array of non-negative integers, you are initially positioned at the first
index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
For example: Given array A = [2,3,1,1,4]
The minimum number of jumps to reach the last index is 2. (Jump 1 step from
index 0 to 1, then 3 steps to the last index.)
 * 
 * */
public class JumpGameII45
{

    static int jump(int a[])
    {
        if (a == null || a.length == 0)
            return 0;
        int start = 0, end = 0, count = 0;
        int maxEnd = 0;
        while (end < a.length)
        {
            maxEnd = 0;
            count++;
            for (int i = start; i <= end; i++)
            {
                maxEnd = Math.max(maxEnd, i + a[i]);
            }
            if (maxEnd >= a.length - 1)
                return count;
            start = end + 1;
            end = maxEnd;

        }

        return count;
    }

    public static void main(String[] args)
    {
        // int a[] = { 2, 3, 1, 1, 4 };
        int a[] = { 2, 2, 1, 5, 4 };
        System.out.println(jump(a));

    }

}
