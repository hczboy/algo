package my.czhhu.algo.sort.array;

/*
 * there is array with number of negative and positive int, try to find out 
 * the largest int which is >0 and NOT in array, time complexity is O(n), space complexity is O(1)
 * for instance, {1, -10, 3, 100, 54}, then the number is 2
 * */
public class FindLargestPositiveIntNotInArray
{
    public static int find(int a[])
    {
        for (int i = 0; i < a.length; i++)
        {
            //although there is while under for, but actual only need one time going through the whole array
            while (a[i] >= 0 && a[i] < a.length && a[i] != i && a[a[i]] != a[i])
            {
                swap(a, i, a[i]);
            }
        }
        int result = 0;
        for (int i = 1; i < a.length; i++)
        {
            if (a[i] != i)
            {
                result = i;
                break;
            }
        }
        if (result == 0)
            result = a.length;
        if (result == a[0])
            result++;
        return result;
    }

    protected static void swap(int[] a, int i, int j)
    {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;

    }

    public static void main(String[] args)
    {
        int a[] = { 5, 2, 100 };
        //int a[] = {1,1,1};
        System.out.println(find(a));

    }

}
