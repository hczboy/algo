package my.czhhu.algo.leetcode;

/*
 * Given a sorted array and a target value, return the index if target is found
 * or return the position which is should be inserted
 * 
 * 
 * */
public class SearchInsertPosition35
{

    static int pos(int[] a, int target)
    {
        if (a == null)
            return -1;
        if (a.length == 0)
            return 0;

        int l = 0;
        int r = a.length - 1;

        int mid = 0;

        while (l < r)
        {
            mid = (l + r) / 2;
            if (a[mid] == target)
            {
                return mid;

            }
            else if (a[mid] < target)
            {
                l = mid + 1;
            }
            else
            {
                r = mid; // if not found, keep r is the first bigger than target,
            } // waiting for l moving towards r

        }

        /* if l == r, there is a corner case: target is bigger than the biggest element 
          * in the array. in other word, r is always a.length-1, in this case, finally l will 
          * equals r, but a[l] may still < target, if so, the return value is l+1
          *  
          */
        if (a[l] < target)
            return l + 1;
        return l;

    }

    public static void main(String[] args)
    {
        int a[] = { 1, 3, 5, 7 };

        System.out.println(pos(a, 5));
        System.out.println(pos(a, 6));
        System.out.println(pos(a, 9));
    }

}
