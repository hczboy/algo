package my.czhhu.algo.leetcode.dp;

/*
 * A message containing letters from A-Z is being encoded to numbers using the
following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways
to decode it.
For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
"L" (12).
The number of ways decoding "12" is 2.
 * 
 * */
public class DecodeWays91
{
    static int dw(String s)
    {
        if (s == null || s.length() == 0)
            return 0;
        //d is used to save result of s.subString(0,i)
        int d[] = new int[s.length() + 1];

        d[0] = 1;
        d[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < d.length; i++)
        {
            int tmp = Integer.parseInt(s.substring(i - 1, i));
            if (tmp != 0)
            {
                d[i] = d[i - 1];
            }
            tmp = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (tmp >= 10 && tmp <= 26)
            {
                d[i] += d[i - 2];
            }

        }
        return d[s.length()];

    }

    public static void main(String[] args)
    {
        String s = "1234";
        System.out.println(dw(s));

    }

}
