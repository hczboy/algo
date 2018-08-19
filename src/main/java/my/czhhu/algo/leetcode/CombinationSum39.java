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

            res.add(new ArrayList<>(r));
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
            while (i + 1 < a.length && cur == a[i + 1])
            {
                i++;
            }

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

    static List<List<Integer>> csBetter(int a[], int target)
    {

        List<List<Integer>> res = new ArrayList<>();

        if (a == null || a.length == 0)
            return res;
        Arrays.sort(a);

        LinkedList<Integer> r = new LinkedList<>();
        csBetter(a, 0, r, 0, res, target);
        return res;

    }

    private static void csBetter(int[] a, int start, LinkedList<Integer> r, int sum, List<List<Integer>> res,
            int target)
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

            if (a[i] + sum > target)
                break;

            r.add(a[i]);
            csBetter(a, i, r, sum + a[i], res, target);
            r.removeLast();

        }

    }

    public static void main(String[] args)
    {
        int a[] = { 2, 2, 3, 5, 7 };

        List<List<Integer>> res = csBetter(a, 7);
        for (List<Integer> r : res)
        {
            System.out.println(r);
        }

    }

}
