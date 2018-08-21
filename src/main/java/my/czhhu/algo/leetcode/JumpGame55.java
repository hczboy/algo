package my.czhhu.algo.leetcode;

public class JumpGame55
{

    static boolean jump(int a[])
    {
        if (a == null || a.length == 0)
        {
            return true;

        }

        int start = 0, end = 0;
        int max = 0;
        while (end < a.length)
        {
            max = 0;
            for (int i = start; i <= end; i++)
            {
                max = Math.max(max, i + a[i]);
            }

            if (max >= a.length - 1)
                return true;
            if (max <= end)
                return false;
            start = end + 1;
            end = max;
        }
        return true;

    }

    static boolean canJump(int a[])
    {

        if (a == null || a.length == 0)
        {
            return true;

        }

        int max = 0;
        for (int i = 0; i < a.length; i++)
        {
            if (max >= a.length - 1 || i > max)
                break;
            max = Math.max(max, i + a[i]);

        }
        return max >= a.length - 1 ? true : false;

    }

    public static void main(String[] args)
    {
        int a[] = { 2, 3, 1, 1, 4 };
        System.out.println(jump(a));
        int b[] = { 3, 2, 1, 0, 4 };
        System.out.println(jump(b));

    }

}
