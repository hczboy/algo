package my.czhhu.algo.recursive;

import java.util.HashMap;
import java.util.Map;

public class BoolExpr
{
    /*
     * given a expression only have '0'. '1', '|', '^', '&'
     * count the number of ways parenthesizing the expr so that it evalutes to result
     * countEval("1^0|0|1", false)->2
     * */
    static int countEval(String expr, boolean result)
    {
        if (expr == null || expr.length() == 0)
            return 0;
        if (expr.length() == 1)
        {
            return stringToBool(expr) == result ? 1 : 0;

        }

        int ways = 0;
        for (int i = 1; i < expr.length(); i += 2)
        {

            char c = expr.charAt(i);
            String left = expr.substring(0, i);
            String right = expr.substring(i + 1);

            int leftTrue = countEval(left, true);
            int leftFalse = countEval(left, false);
            int rightTrue = countEval(right, true);
            int rightFalse = countEval(right, false);

            int totalRight = rightFalse + rightTrue;
            int totalLeft = leftFalse + leftTrue;

            int total = totalRight * totalLeft;

            int countTrue = 0;
            switch (c)
            {
                case '|':
                    countTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
                    break;
                case '&':
                    countTrue = leftTrue * rightTrue;
                    break;
                case '^':
                    countTrue = leftFalse * rightTrue + leftTrue * rightFalse;

            }
            ways += result == true ? countTrue : total - countTrue;
        }

        return ways;

    }

    static int countEvalDP(String expr, boolean result, Map<String, Integer> cache)
    {
        if (expr == null || expr.length() == 0)
            return 0;
        if (expr.length() == 1)
        {
            return stringToBool(expr) == result ? 1 : 0;

        }

        String key = result + expr;

        if (cache.containsKey(key))
        {
            return cache.get(key);
        }

        int ways = 0;
        for (int i = 1; i < expr.length(); i += 2)
        {

            char c = expr.charAt(i);
            String left = expr.substring(0, i);
            String right = expr.substring(i + 1);

            int leftTrue = countEval(left, true);
            int leftFalse = countEval(left, false);
            int rightTrue = countEval(right, true);
            int rightFalse = countEval(right, false);

            int totalRight = rightFalse + rightTrue;
            int totalLeft = leftFalse + leftTrue;

            int total = totalRight * totalLeft;

            int countTrue = 0;
            switch (c)
            {
                case '|':
                    countTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
                    break;
                case '&':
                    countTrue = leftTrue * rightTrue;
                    break;
                case '^':
                    countTrue = leftFalse * rightTrue + leftTrue * rightFalse;

            }
            int subWays = result == true ? countTrue : total - countTrue;
            cache.put(key, subWays);
            ways += subWays;
        }

        return ways;

    }

    private static boolean stringToBool(String expr)
    {
        return "1".equals(expr);

    }

    public static void main(String[] args)
    {
        System.out.println(countEval("1^0|0|1", false)); //2
        System.out.println(countEval("0&0&0&1^1|0", true));//10

        HashMap<String, Integer> cache = new HashMap<String, Integer>();

        System.out.println(countEvalDP("1^0|0|1", false, cache));
        System.out.println(countEvalDP("0&0&0&1^1|0", true, cache));
    }

}
