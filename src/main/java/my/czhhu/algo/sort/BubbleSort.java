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
        int t;
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

    public static void main(String[] args)
    {
        int a[] = { 25, 1, 3, 7, 2 };
        BubbleSort sort = new BubbleSort(a);
        System.out.println(sort);
        sort.sort();
        System.out.println(sort);

    }

}
