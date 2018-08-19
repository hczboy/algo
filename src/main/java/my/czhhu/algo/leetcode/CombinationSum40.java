package my.czhhu.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 * given a positive  array and a target
 * 
 * return all combination'sum equals target
 * 
 * each element only use once
 * 
 * */

public class CombinationSum40
{

    static List<List<Integer>> cs(int a[], int target)
    {
        List<List<Integer>> res = new ArrayList<>();
        if (a == null || a.length == 0)
        {
            return res;
        }

        List<Integer> r = new ArrayList<>();
        Arrays.sort(a);
        cs(a, 0, r, 0, res, target);
        return res;
    }

    private static void cs(int[] a, int start, List<Integer> r, int sum, List<List<Integer>> res, int target)
    {
        if (sum == target)
        {
            res.add(new ArrayList<>(r));
            return;
        }

        for (int i = start; i < a.length; i++)
        {

            if (i > start && a[i] == a[i - 1])
                continue;
            if (sum + a[i] > target)
                break;

            r.add(a[i]);
            cs(a, i + 1, r, sum + a[i], res, target);
            r.remove(r.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        int a[] = { 10, 1, 2, 7, 6, 1, 5 };

        List<List<Integer>> res = cs(a, 8);
        for (List<Integer> r : res)
        {
            System.out.println(r);
        }

    }

}
