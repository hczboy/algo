package my.czhhu.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * given a positive array and target,
 * return all combinations with sum == target,
 * the element can be used repeatedly
 *  
 * output must be no duplicate combinations
 * 
 * */

public class CombinationSum39
{

    static List<List<Integer>> cs(int a[], int target)
    {

        List<List<Integer>> res = new ArrayList<>();

        if (a == null || a.length == 0)
            return res;
        Arrays.sort(a);

        LinkedList<Integer> r = new LinkedList<>();
        cs(a, r, 0, res, target);
        return res;

    }

    private static void cs(int[] a, LinkedList<Integer> r, int i, List<List<Integer>> res, int target)
    {

        int sum = sum(r);
        if (sum > target)
            return;
        if (sum == target && i <= a.length)
        {
            LinkedList<Integer> clone = (LinkedList<Integer>) r.clone();
            res.add(clone);
            return;
        }
        if (i == a.length)
        {
            return;
        }

        int cur = a[i];
        int j = 0;

        while (sum < target)
        {
            sum += cur;
            r.add(cur);
            j++;
            cs(a, r, i + 1, res, target);

        }
        while (j > 0)
        {
            int n = r.removeLast();
            j--;
            sum -= n;
        }
        if (sum < target)
        {
            cs(a, r, i + 1, res, target);
        }
    }

    private static int sum(List<Integer> r)
    {
        int sum = 0;

        for (Integer i : r)
        {
            sum += i;
        }
        return sum;

    }

    public static void main(String[] args)
    {
        int a[] = { 2, 3, 5, 7 };

        List<List<Integer>> res = cs(a, 7);
        for (List<Integer> r : res)
        {
            System.out.println(r);
        }

    }

}
