package my.czhhu.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChar3
{
    /* incorrect, only working for subString from start
     static int findLongestSubStr(char[] s, int len)
    {
        if (s == null || len < 1)
            return 0;
        if (len == 1)
            return 1;
        char c = s[len - 1];
        boolean isRepeat = false;
        for (int i = 0; i < len - 1; i++)
        {
            if (s[i] == c)
            {
                isRepeat = true;
                break;
            }
        }
        int num = findLongestSubStr(s, len - 1);
        return isRepeat ? num : num + 1;
    }*/

    static int findLongestSubStr(char[] s, int start)
    {
        if (start == s.length - 1)
            return 1;
        int c = 1;

        for (int i = start + 1; i < s.length; i++)
        {

            for (int j = start; j < i; j++)
            {
                if (s[j] == s[i])
                {
                    return c;
                }

            }
            c++;

        }
        return c;
    }

    static int findLongestSubStr(String s)
    {
        if (s == null)
            return -1;
        char[] sc = s.toCharArray();
        int max = -1;
        for (int start = 0; start < sc.length; start++)
        {
            max = Math.max(findLongestSubStr(sc, start), max);
        }
        return max;
    }

    static int findLongestSubStrV1(String s)
    {
        if (s == null)
            return -1;
        char[] sc = s.toCharArray();
        int lastDupIndex = -1;
        Integer lastIndex = -1;
        Map<Character, Integer> charToIndex = new HashMap<Character, Integer>();
        int max = -1;
        for (int i = 0; i < sc.length; i++)
        {
            lastIndex = charToIndex.get(sc[i]);
            if (lastIndex != null && lastDupIndex < lastIndex)
            {
                lastDupIndex = lastIndex;
            }
            max = Math.max(i - lastDupIndex, max);
            charToIndex.put(sc[i], i);
        }
        return max;
    }

    public static void main(String[] args)
    {
        String s = "abcabcbb";
        String s1 = "bbbbb";
        String s2 = "pwwkew";
        System.out.println(findLongestSubStrV1(s));
        System.out.println(findLongestSubStrV1(s1));
        System.out.println(findLongestSubStrV1(s2));
    }

}
