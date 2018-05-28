package my.czhhu.algo.sort;

public class BubbleSort extends AbstractSort
{

    public BubbleSort(int[] sa)
    {
        super(sa);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void sort()
    {
        if (a.length <= 1)
            return;

        boolean isSwap = false;
        for (int i = a.length - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (a[j] > a[j + 1])
                {
                    swap(a, j, j + 1);
                    isSwap = true;
                }
            }
            if (!isSwap)
                break;
        }

    }

    public void cockTailSort()
    {
        if (a.length <= 1)
            return;
        int left = 0, right = a.length - 1;
        while (left < right)
        {
            for (int i = left; i < right; i++)
            {
                if (a[i] > a[i + 1])
                    swap(a, i, i + 1);
            }
            right--;
            for (int j = right; j > left; j--)
            {
                if (a[j] < a[j - 1])
                    swap(a, j, j - 1);
            }
            left++;

        }

    }

    public static void main(String[] args)
    {
        int a[] = { 25, 1, 3, 7, 2 };
        BubbleSort sort = new BubbleSort(a);
        System.out.println(sort);
        //sort.sort();
        sort.cockTailSort();
        System.out.println(sort);

    }

}
