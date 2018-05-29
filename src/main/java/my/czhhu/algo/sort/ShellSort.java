package my.czhhu.algo.sort;

public class ShellSort extends AbstractSort
{

    public ShellSort(int[] sa)
    {
        super(sa);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void sort()
    {
        if (a.length <= 1)
            return;
        int step = 1;
        while (step * 3 < a.length)
            step *= 3;
        while (step >= 1)
        {
            for (int i = step; i < a.length; i++)
            {

                int t = a[i];
                int j = i - step;
                while (j >= 0 && a[j] > t)
                {
                    a[j + step] = a[j];
                    j -= step;
                }
                a[j + step] = t;

            }
            step = step / 3;
        }
    }

    public static void main(String[] args)
    {
        int a[] = { 25, 1, 3, 7, 2, 5, 12, 5, 8, 6, 10, 4, 9, 13 };
        //int a[] = { 1, 3, 2 };
        AbstractSort sort = new ShellSort(a);
        System.out.println(sort);
        sort.sort();
        System.out.println(sort);

    }

}
