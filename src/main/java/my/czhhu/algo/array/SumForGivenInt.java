package my.czhhu.algo.array;

/*
 * input 8:
 * 
 * output:
 * 8=1+2+5
 * 8=1+3+4
 * 8=1+7
 * 8=2+6
 * 8=3+5
 * */
public class SumForGivenInt
{
    static void print(int[] r, int k)
    {
        for (int i = 0; i <= k; i++)
        {
            System.out.print(r[i] + " ");
        }
        System.out.println();
    }

    static void run(int n)
    {
        int sum = 0, len = 1;
        while (sum < n)
        {
            sum += len;
            len++;
        }
        System.out.println(len);
        System.out.println(sum);
        len--;
        int r[] = new int[len];
        for (int i = 0; i < len; i++)
        {
            r[i] = i + 1;
        }
        int k = len - 2;
        sum -= r[len - 1];
        while (true)
        {
            if (k == 0 && r[k] == n)
            {
                break;
            }
            if (sum < n)
            {
                r[k + 1] = r[k] + 1;
                k++;
                sum += r[k];
            }
            else
            {
                if (sum == n)
                {
                    print(r, k);
                }
                sum -= r[k];
                r[--k]++;
                sum++;
            }
        }
    }

    public static void main(String[] args)
    {
        run(8);
    }

}
