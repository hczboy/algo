package my.czhhu.algo.classic;

public class StringToInt
{

    static int toInt(String s)
    {
        if (s == null || s.length() == 0)
        {
            throw new NumberFormatException("null or empty string");
        }
        int i = 0;
        boolean isNegative = false;
        String fs = s.trim();
        while (fs.charAt(i) == '+' || fs.charAt(i) == '-')
        {
            if (fs.charAt(i) == '-')
            {
                isNegative = true;
            }
            i++;

        }

        int start = i;
        int res = 0;
        char c;
        int digit = 0;
        while (start < fs.length())
        {
            c = fs.charAt(start++);
            digit = c - '0';
            if (digit < 0 || digit > 9)
            {
                throw new NumberFormatException(c + " is not number");
            }
            if (!isNegative)
            {
                if (res * 10 > Integer.MAX_VALUE - digit)
                {
                    throw new NumberFormatException("upper overflow");
                }
            }
            else
            {
                if (res * 10 < Integer.MIN_VALUE + digit)
                {
                    throw new NumberFormatException("under overflow");
                }
            }

            if (isNegative)
            {
                res = res * 10 - digit;
            }
            else
            {
                res = res * 10 + digit;
            }

        }

        return res;

    }

    public static void main(String[] args)
    {
        System.out.println(toInt("2147483647"));
        System.out.println(toInt("-2147483649"));

    }

}
