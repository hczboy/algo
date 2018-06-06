package my.czhhu.algo.leetcode;

public class ReverseInteger
{

    /*
     * 321 => 123
     * -321 =>-123
     *  1000000003 => overflow, return 0;
     * */
    public static int doReverse(int i)
    {
        if (i == 0)
            return 0;

        boolean isPositive = i > 0 ? true : false;
        int x = Math.abs(i);
        int r = 0;
        while (x > 0)
        {
            if (r > Integer.MAX_VALUE / 10)
                return 0;
            r = r * 10 + x % 10;
            x /= 10;
        }

        return isPositive ? r : -r;
    }

    public static void main(String[] args)
    {
        System.out.println(doReverse(123));
        System.out.println(doReverse(-1000000002));
    }

}
