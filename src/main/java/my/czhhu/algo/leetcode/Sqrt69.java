package my.czhhu.algo.leetcode;

public class Sqrt69
{

    static int sqrt(int x)
    {
        if (x == 0 || x == 1)
            return x;
        int l = 0, r = x;
        while (l <= r)
        {
            int mid = (l + r) / 2;
            if (x / mid == mid)
                return mid;
            if (x / mid < mid)
            {
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
            }

        }
        return r;

    }

    public static void main(String[] args)
    {
        System.out.println(sqrt(2));

    }

}
