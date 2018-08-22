package my.czhhu.algo.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

public class UniquePaths62
{

    static int up(int r, int c)
    {
        if (r < 0 || c < 0)
            return 0;

        AtomicInteger count = new AtomicInteger(0);

        up(0, 0, r - 1, c - 1, count);
        return count.get();

    }

    private static void up(int cr, int cc, int r, int c, AtomicInteger count)
    {
        if (cr > r || cc > c)
            return;

        if (cc == c && cr == r)
        {
            count.incrementAndGet();
            return;
        }

        up(cr + 1, cc, r, c, count);
        up(cr, cc + 1, r, c, count);

    }

    public static void main(String[] args)
    {
        System.out.println(up(2, 1));

    }

}
