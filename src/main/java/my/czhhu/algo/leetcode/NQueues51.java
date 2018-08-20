package my.czhhu.algo.leetcode;

public class NQueues51
{

    static void nQueue(int n)
    {
        if (n <= 0)
            return;
        int[] res = new int[n];

        for (int i = 0; i < n; i++)
        {
            res[i] = -1;
        }
        nQueue(res, 0);

    }

    private static void nQueue(int[] res, int r)
    {
        if (r == res.length)
        {
            print(res);
            return;
        }
        for (int c = 0; c < res.length; c++)
        {
            if (isValid(res, r, c))
            {
                res[r] = c;
                nQueue(res, r + 1);
                res[r] = -1;
            }

        }

    }

    private static void print(int[] res)
    {
        for (int r = 0; r < res.length; r++)
        {
            for (int c = 0; c < res.length; c++)
            {
                if (res[r] == c)
                {
                    System.out.print("Q");
                }
                else
                {
                    System.out.print(".");
                }

            }
            System.out.println();

        }

        System.out.println("=========================");

    }

    static boolean isValid(int[] res, int r, int c)
    {
        for (int i = 0; i < res.length && res[i] != -1; i++)
        {
            if (c == res[i])
                return false;

            if (r - i == Math.abs(c - res[i]))
                return false;

        }
        return true;

    }

    public static void main(String[] args)
    {
        //  nQueue(4);
        nQueue(1);
    }

}
