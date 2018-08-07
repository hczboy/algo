package my.czhhu.algo.lintcode;

public class ArraySplit31
{

    static int solution(int[] nums, int k)
    {
        if (nums == null || nums.length == 0)
            return -1;

        int p = 0, q = nums.length - 1;
        while (p < q)
        {
            while (p < q && nums[p] < k)
                p++;
            while (p < q && nums[q] >= k)
                q--;
            if (p < q)
            {
                int tmp = nums[p];
                nums[p] = nums[q];
                nums[q] = tmp;
            }
        }
        if (nums[p] < k)
        {
            return p + 1;
        }
        return p;

    }

    public static void main(String[] args)
    {
        // int a[] = { 3, 2, 2, 1 };
        //int a[] = { 3, 4, 5, 7 };
        int a[] = { 4 };
        System.out.println(solution(a, 4));

    }

}
