package my.czhhu.algo.leetcode;

public class MultiplyStrings43
{

    static String multi(String s1, String s2)
    {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)

            return null;
        int len1 = s1.length();
        int len2 = s2.length();
        String bigger = len1 >= len2 ? s1 : s2;
        String shorter = len1 >= len2 ? s2 : s1;
        int[] res = new int[len1 + len2];

        for (int s = shorter.length() - 1; s >= 0; s--)
        {
            char si = shorter.charAt(s);
            int carry = 0;
            char bi = '0';
            int sr = 0;
            int b = bigger.length() - 1;
            for (; b >= 0; b--)
            {
                bi = bigger.charAt(b);
                sr = (bi - '0') * (si - '0') + carry + res[s + b + 1];

                res[s + b + 1] = sr % 10;
                carry = sr / 10;

            }
            res[s + b + 1] = carry;

        }

        int i = 0;
        while (i < res.length && res[i] == 0)
        {
            i++;
        }
        if (i == res.length)
        {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < res.length; j++)
        {
            sb.append(res[j]);
        }
        return sb.toString();

    }

    public static void main(String[] args)
    {
        System.out.println(multi("45", "123"));
        System.out.println(multi("99", "99"));

    }

}
