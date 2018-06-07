package my.czhhu.algo.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c
= 0? Find all unique triplets in the array which gives the sum of zero.
Note: The solution set must not contain duplicate triplets.
For example, given array S = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
[-1, 0, 1],
[-1, -1, 2]
]
 * */
public class ThreeSum
{

    static class Triple
    {
        private int i;
        private int j;
        private int k;

        public Triple(int i, int j, int k)
        {
            super();
            this.i = i;
            this.j = j;
            this.k = k;
        }

        public int getI()
        {
            return i;
        }

        public void setI(int i)
        {
            this.i = i;
        }

        public int getJ()
        {
            return j;
        }

        public void setJ(int j)
        {
            this.j = j;
        }

        public int getK()
        {
            return k;
        }

        public void setK(int k)
        {
            this.k = k;
        }

        @Override
        public String toString()
        {
            return "Triple [i=" + i + ", j=" + j + ", k=" + k + "]";
        }

    }

    public static List<Triple> solution(int a[])
    {
        if (a == null || a.length < 3)
            return Collections.EMPTY_LIST;

        Arrays.sort(a);
        LinkedList<Triple> res = new LinkedList<>();
        int l, r, sum = 0;
        for (int i = 0; i < a.length - 2; i++)
        {
            if (i > 0 && a[i] == a[i - 1])
                continue; //to avoid duplicated triple
            l = i + 1;
            r = a.length - 1;
            while (l < r)
            {
                sum = a[i] + a[l] + a[r];
                if (sum == 0)
                {
                    Triple t = new Triple(a[i], a[l], a[r]);
                    res.add(t);
                    l++;
                    r--;
                    //to avoid duplicated triple
                    while (l < r && a[r] == a[r + 1])
                        r--;
                    while (l < r && a[l] == a[l - 1])
                        l++;
                }
                else if (sum > 0)
                {
                    r--;

                }
                else
                {
                    l++;

                }

            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        int a[] = { -1, 0, 1, 2, -1, -4 };
        System.out.println(solution(a));

    }

}
