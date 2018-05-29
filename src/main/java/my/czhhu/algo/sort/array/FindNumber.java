package my.czhhu.algo.sort.array;

public class FindNumber
{

    /*
     * there is a int array, all numbers occur 3 times but 1 number only occur 1 time,
     * find out the number only occur 1 time
     * */

    public static int find(int a[])
    {
        int bit[] = new int[32];
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < 32; j++)
            {
                bit[j] += ((a[i] >> j & 1));
            }
        }
        int result = 0;
        for (int j = 0; j < 32; j++)
        {
            result += (bit[j] % 3 == 0 ? 0 : 1 << j);
        }
        return result;
    }

    public static void main(String[] args)
    {
        int a[] = { 2, 3, 1, 2, 3, 7, 1, 2, 3, 1 };
        System.out.println(find(a));

    }

}
