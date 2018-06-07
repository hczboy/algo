package my.czhhu.algo.leetcode;

public class LongestCommonPrefix
{

    public static String solution(String[] input)
    {
        if (null == input || input.length == 0)
        {
            return "";
        }
        if (input.length == 1)
        {
            return input[0];
        }
        int largestCommonIndex = 0;
        while (true)
        {
            for (int i = 0; i < input.length; i++)
            {
                if (input[i] == null)
                {
                    return "";
                }
                if (largestCommonIndex >= input[i].length())
                {
                    return input[i];
                }
                if (i > 0 && input[i].charAt(largestCommonIndex) != input[i - 1].charAt(largestCommonIndex))
                {
                    return input[i].substring(0, largestCommonIndex);
                }
            }
            largestCommonIndex++;
        }
    }

    public static void main(String[] args)
    {
        String[] input = { "test", "tea", "ttty" };
        System.out.println(solution(input));

    }

}
