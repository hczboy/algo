package my.czhhu.algo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubSets78
{

    static List<List<Integer>> subSets(int[] n)
    {
        if (n == null || n.length == 0)
            return Collections.EMPTY_LIST;

        return subSets(n, n.length - 1);
    }

    private static List<List<Integer>> subSets(int[] n, int i)
    {
        if (i == -1)
        {
            List<List<Integer>> res = new ArrayList<>();
            res.add(Collections.EMPTY_LIST);
            return res;
        }

        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> subRes = subSets(n, i - 1);
        res.addAll(subRes);
        for (int j = 0; j < subRes.size(); j++)
        {
            ArrayList<Integer> r = new ArrayList<>(subRes.get(j));
            r.add(n[i]);
            res.add(r);

        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] n = { 3, 2, 1 };

        System.out.println(subSets(n));

    }

}
