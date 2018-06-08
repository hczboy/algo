package my.czhhu.algo.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/*
 * Given a digit string, return all possible letter combinations that the number could
represent.
A mapping of digit to letters (just like on the telephone buttons).
 * */
public class LetterCombinations
{

    private static final String dict[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    private static Pattern p = Pattern.compile("^[[1-9]{1}\\d*]|[0]$");

    public static List<String> combination(String numStr)
    {
        if (!p.matcher(numStr).matches())
        {

            throw new IllegalArgumentException("Not number string for: " + numStr);
        }
        char[] chs = numStr.toCharArray();
        List<String> res = new LinkedList<>();
        doCom(chs, 0, "", res);
        return res;
    }

    private static void doCom(char[] chs, int i, String prefix, List<String> res)
    {
        if (i == chs.length)
        {
            if (!prefix.isEmpty())
            {
                res.add(prefix);
            }
            return;
        }

        String strForNum = dict[chs[i] - '0'];
        if (strForNum.isEmpty()) // for chr[i] = 0 or 1, will go this if, NOT go for loop
        {
            doCom(chs, i + 1, prefix, res);
        }
        for (Character c : strForNum.toCharArray())
        {
            doCom(chs, i + 1, prefix + c, res);
        }

    }

    public static void main(String[] args)
    {
        List<String> res = null;
        /* List<String> res = combination("23");
        System.out.println(res);*/
        res = combination("01");
        System.out.println(res.size());
    }

}
