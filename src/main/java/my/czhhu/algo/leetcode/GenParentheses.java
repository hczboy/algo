package my.czhhu.algo.leetcode;

import java.util.LinkedList;
import java.util.List;

public class GenParentheses
{

    public static List<String> gen(int n)
    {
        //Stack<String> stack = new Stack<>();
        List<String> res = new LinkedList<>();
        doGen(res, "", 0, n);

    }

    private static void doGen(List<String> res, String prefix, int i, int n)
    {
        if (i > n)
        {
            res.add(prefix);
            return;
        }
        doGen(res, prefix + "(", i + 1, n);

    }

    public static void main(String[] args)
    {
        // TODO Implement main
        throw new UnsupportedOperationException("main Not Implemented");

    }

}
