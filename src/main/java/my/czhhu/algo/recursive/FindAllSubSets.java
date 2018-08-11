package my.czhhu.algo.recursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAllSubSets
{

    static List<List<Integer>> findSets(List<Integer> set)
    {
        if (set == null || set.size() == 0)
            return Collections.EMPTY_LIST;

        return findSets(set, set.size() - 1);
    }

    private static List<List<Integer>> findSets(List<Integer> set, int i)
    {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> thisRound = new ArrayList<Integer>();
        if (i == -1)
        {
            res.add(thisRound);
            return res;
        }
        List<List<Integer>> subRes = findSets(set, i - 1);
        res.addAll(subRes);
        for (List<Integer> subItem : subRes)
        {
            List<Integer> newList = new ArrayList<>();
            newList.addAll(subItem);
            newList.add(set.get(i));
            res.add(newList);

        }
        return res;

    }

    public static void main(String[] args)
    {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        List<List<Integer>> res = findSets(set);

        for (List<Integer> resItem : res)
        {
            System.out.println(resItem);
        }

    }

}
