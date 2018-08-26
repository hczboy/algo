package my.czhhu.algo.leetcode;

/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
containing all ones and return its area.
an extension of 84
 */
public class MaximalRectangle85
{
    static int maxRec(int[][] m)
    {
        if (m == null || m.length == 0 || m[0].length == 0)
            return 0;
        int[][] data = new int[m.length][m[0].length];
        for (int c = 0; c < m[0].length; c++)
        {
            data[0][c] = m[0][c];
        }

        for (int r = 1; r < m.length; r++) //convert 2D matrix to multiple rows Largest Rectangle In Histogram in each row
        {
            for (int c = 0; c < m[0].length; c++)
            {
                if (m[r][c] != 0)
                {
                    data[r][c] = data[r - 1][c] + 1;
                }
                else
                {
                    data[r][c] = 0;
                }

            }

        }

        int max = 0;
        for (int r = m.length - 1; r >= 0; r--)
        {
            max = Math.max(max, LargestRectangleInHistogram84.largeWithStack(data[r]));
            if (max > r * data[r].length)
                break;

        }
        return max;
    }

    public static void main(String[] args)
    {
        int[][] m = { { 0, 1, 1 }, { 1, 0, 1 }, { 0, 1, 1 } };
        System.out.println(maxRec(m));

    }

}
