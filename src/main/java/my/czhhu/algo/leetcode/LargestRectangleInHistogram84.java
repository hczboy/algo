package my.czhhu.algo.leetcode;

import java.util.Stack;

public class LargestRectangleInHistogram84
{

    /*idea is
     * 
     * 1. find the highest index  maxHi;
     * 2. set two index l, r and minHi point to the lowest height between l and r
     * 3. move from maxHi respectively, if(h[l-1]< h[r+1]) { r++} else {l--}, also update minHi if h[r|l] < h[minHi]
     * 4. calc (r-l+1)* h[minHi] repeatedly, keep the max value
     * 
     * */
    static int largetR(int[] h)
    {
        if (h == null || h.length == 0)
            return 0;
        int maxHeight = Integer.MIN_VALUE;
        int maxHi = -1;
        for (int i = 0; i < h.length; i++)
        {
            maxHeight = Math.max(maxHeight, h[i]);
            if (h[i] == maxHeight)
            {
                maxHi = i;
            }
        }

        int l = maxHi, r = maxHi;
        int minHi = maxHi;
        int lr = 0;
        while (l >= 0 && r < h.length)
        {
            int t = (r - l + 1) * h[minHi];
            lr = Math.max(lr, t);
            if (l - 1 < 0)
            {
                l--;
                continue;
            }

            if (r + 1 >= h.length)
            {
                r++;
                continue;
            }
            if ((l - 1) >= 0 && (r + 1) < h.length)
            {
                if (h[l - 1] < h[r + 1])
                {
                    r++;
                    if (h[r] < h[minHi])
                    {
                        minHi = r;
                    }
                }
                else
                {
                    l--;
                    if (h[l] < h[minHi])
                    {
                        minHi = l;
                    }

                }

            }

        }

        if (l < 0)
        {
            while (r + 1 < h.length)
            {
                r++;
                if (h[r] < h[minHi])
                {
                    minHi = r;
                }
                int tr = (r - l + 1) * h[minHi];
                lr = Math.max(lr, tr);
            }

        }

        if (r >= h.length)
        {
            while (l - 1 >= 0)
            {
                l--;
                if (h[l] < h[minHi])
                {
                    minHi = l;
                }
                int tl = (r - l + 1) * h[minHi];
                lr = Math.max(lr, tl);
            }

        }

        return lr;

    }

    static int largeWithStack(int h[])
    {
        Stack<Integer> is = new Stack<>();

        int r = 0;
        int max = 0;
        while (r <= h.length)
        {
            int val = r < h.length ? h[r] : 0;
            if (is.isEmpty() || val >= h[is.peek()])
            {
                is.push(r);
                r++;
            }
            else
            {
                int hi = is.pop();
                int w = is.isEmpty() ? r : r - 1 - is.peek();
                max = Math.max(max, h[hi] * w);

            }

        }
        return max;

    }

    public static void main(String[] args)
    {
        int a[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largetR(a));
        System.out.println(largeWithStack(a));
    }

}
