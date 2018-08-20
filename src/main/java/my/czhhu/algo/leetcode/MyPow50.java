package my.czhhu.algo.leetcode;

public class MyPow50
{

    static double pow(double x, int n)
    {
        if (n < 0)
            return 1 / myPow(x, -n);
        return myPow(x, n);

    }

    private static double myPow(double x, int n)
    {
        if (n == 0)
            return 1;
        double v = myPow(x, n / 2);
        if (n % 2 == 0)
        {
            return v * v;
        }
        return v * v * x;

    }

    public static void main(String[] args)
    {
        System.out.println(pow(10, -3));

    }

}
