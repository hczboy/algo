package my.czhhu.algo.leetcode;

public class SearchInRotatedSortedArrayII81
{

    static int s(int a[], int t)
    {
        if (a == null || a.length == 0)
            return -1;

        return s(a, 0, a.length - 1, t);

    }

    private static int s(int[] a, int s, int e, int t)
    {

        if (s > e)
            return -1;

        int mid = (s + e) / 2;

        if (a[mid] == t)
        {
            return mid;
        }

        if (t > a[mid])
        {
            if (a[mid] < a[e] && t <= a[e])
            {
                return s(a, mid + 1, e, t);
            }
            // a[mid] ==a[e]
            int rightRes = s(a, mid + 1, e, t);
            return rightRes != -1 ? rightRes : s(a, s, mid - 1, t);
        }
        // t<a[mid];
        if (a[s] < a[mid] && t >= a[s] || a[mid] > a[e] && t > a[e] || a[mid] < a[e])
        {
            return s(a, s, mid - 1, t);

        }

        if (a[mid] > a[e] && t <= a[e])
        {
            return s(a, mid + 1, e, t);
        }

        int rightRes = s(a, mid + 1, e, t);
        return rightRes != -1 ? rightRes : s(a, s, mid - 1, t);

    }

    static int search(int a[], int t)
    {
        if (a == null || a.length == 0)
            return -1;
        int l = 0;
        int r = a.length - 1;

        int mid = 0;
        while (l <= r)
        {
            mid = (l + r) / 2;

            if (t == a[mid])
                return mid;
            if (a[l] < a[mid])
            {
                if (a[l] <= t && t < a[mid])
                {
                    r = mid - 1;
                }
                else
                {
                    l = mid + 1;

                }

            }
            else if (a[l] > a[mid])
            {
                if (t > a[mid] && t <= a[r])
                {
                    l = mid + 1;
                }
                else
                {
                    r = mid - 1;
                }
            }
            else
            {
                l++;
            }

        }

        return -1;

    }

    public static void main(String[] args)
    {
        int a[] = { 4, 5, 6, 6, 7, 2, 4 };

        System.out.println(s(a, 3));

        System.out.println(search(a, 1));

    }

}
