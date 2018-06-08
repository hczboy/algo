package my.czhhu.algo.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FourSum
{

    static class Quad
    {
        private int i;
        private int j;
        private int s;
        private int k;

        @Override
        public String toString()
        {
            return "Quad [i=" + i + ", j=" + j + ", s=" + s + ", k=" + k + "]";
        }

        public Quad(int i, int j, int s, int k)
        {
            super();
            this.i = i;
            this.j = j;
            this.s = s;
            this.k = k;
        }

    }

    public static List<Quad> solution(int a[], int target)
    {
        if (a == null || a.length < 4)
        {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(a);
        List<Quad> res = new LinkedList<>();
        for (int i = 0; i < a.length - 3; i++)
        {
            if (i > 0 && a[i] == a[i - 1])
                continue;
            for (int j = i + 1; j < a.length - 2; j++)
            {
                if (j > i + 1 && a[j] == a[j - 1])
                    continue;
                int s = j + 1, k = a.length - 1;
                while (s < k)
                {
                    int sum = a[i] + a[j] + a[s] + a[k];
                    if (sum == target)
                    {
                        Quad quad = new Quad(a[i], a[j], a[s], a[k]);
                        res.add(quad);
                        s++;
                        k--;
                        while (s < k && a[s] == a[s - 1])
                            s++;
                        while (s < k && a[k] == a[k + 1])
                            k--;
                    }
                    else if (sum > target)
                    {
                        k--;
                    }
                    else
                    {
                        s++;
                    }
                }
            }

        }
        return res;
    }

    public static void main(String[] args)
    {
        int a[] = { 1, 0, -1, 0, -2, 2 };
        System.out.println(solution(a, 0));

    }

}
