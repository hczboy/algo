package my.czhhu.algo.leetcode;

/*
 * Given two words word1 and word2, find the minimum number of steps required to
convert word1 to word2. (each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
a) Insert a character
b) Delete a character
c) Replace a character
 * 
 * */
public class EditDistance72
{

    static int editDistance(String w1, String w2)
    {
        if (w1 == null && w2 == null)
            return 0;

        if (w1 == null || w2 == null)
        {
            return w1 == null ? w2.length() : w1.length();
        }

        int w1l = w1.length();
        int w2l = w2.length();
        if (w1l == 0 || w2l == 0)
        {
            return w1l == 0 ? w2l : w1l;
        }

        int d[][] = new int[w1l][w2l];
        if (w1.charAt(0) != w2.charAt(0))
        {
            d[0][0] = 1;

        }
        else
        {
            d[0][0] = 0;

        }
        for (int j = 1; j < w2l; j++)
        {
            d[0][j] = d[0][j - 1] + 1;

        }

        for (int j = 1; j < w1l; j++)
        {
            d[j][0] = d[j - 1][0] + 1;

        }

        for (int i = 1; i < w1l; i++)
        {
            for (int j = 1; j < w2l; j++)
            {

            }

        }

    }

    public static void main(String[] args)
    {
        "cxii", "ixc"
        throw new UnsupportedOperationException("main Not Implemented");

    }

}
