package my.czhhu.algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * given a array and a target number, if there are sum of two element
 * equals target, return the indices of the two
 * 
 * [0,1,2,0] = 0
 * 
 * return [0,3]
 * */
public class TwoSum1
{
    static Integer[] run(int[] a, int sum)
    {
        if (a == null || a.length < 2)
            return null;
        Map<Integer, Integer> eleToIndex = new HashMap<Integer, Integer>();
        Integer[] indices = new Integer[2];
        for (int i = 0; i < a.length; i++)
        {
            if (eleToIndex.get(a[i]) != null)
            {
                //cross stroing key: sum-a[i], value: i
                indices[0] = eleToIndex.get(a[i]);
                indices[1] = i;
                return indices;
            }
            eleToIndex.put(Integer.valueOf(sum - a[i]), i);
        }
        return null;

    }

    public static void main(String[] args)
    {
        int a[] = { 0, 1, 2, 0 };
        System.out.println(Arrays.asList(run(a, 0)));
    }

}
