package my.czhhu.algo.leetcode;

public class Search2DMatrix74
{

    static boolean isExists(int[][] a, int target)
    {
        if (a == null || a.length == 0)
            return false;

        if (target < a[0][0] || target > a[a.length - 1][a[0].length - 1])
        {
            return false;
        }

        int s = 0;
        int e = a.length - 1;
        int c = a[0].length - 1;
        int mid = 0;
        while (s <= e)
        {
            mid = (s + e) / 2;
            if (target == a[mid][c])
            {
                return true;
            }
            else if (target > a[mid][c])
            {
                s = mid + 1;
            }
            else
            {
                e = mid - 1;
            }

        }

        int r = s;

        s = 0;
        e = a[0].length - 1;
        while (s <= e)
        {
            mid = (s + e) / 2;
            if (a[r][mid] == target)
            {
                return true;
            }
            else if (a[r][mid] > target)
            {
                e = mid - 1;
            }
            else
            {
                s = mid + 1;
            }

        }
        return false;

    }

    public static void main(String[] args)
    {
        int a[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };

        System.out.println(isExists(a, 9));

    }

}
